package info.jab.jooq.db;

import static info.jab.jooq.db.Tables.FILM;
import static info.jab.jooq.db.Tables.FILM_ACTOR;
import static info.jab.jooq.db.Tables.FILM_CATEGORY;
import static info.jab.jooq.db.Tables.PAYMENT;
import static info.jab.jooq.db.tables.Actor.ACTOR;
import static info.jab.jooq.db.tables.Category.CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jooq.JSONFormat.RecordFormat.OBJECT;
import static org.jooq.Records.mapping;
import static org.jooq.XMLFormat.RecordFormat.COLUMN_NAME_ELEMENTS;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.multisetAgg;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.sum;

import info.jab.jooq.db.tables.FilmActor;
import info.jab.jooq.db.tables.FilmCategory;
import info.jab.jooq.db.tables.records.FilmRecord;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.jooq.DSLContext;
import org.jooq.JSONFormat;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Source;
import org.jooq.TXTFormat;
import org.jooq.XMLFormat;
import org.jooq.impl.DSL;
import org.jooq.tools.JooqLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.jdbc.ContainerDatabaseDriver;

public class TestContainersTest {

    static JooqLogger log = JooqLogger.getLogger(TestContainersTest.class);
    static Connection connection;
    static DSLContext ctx;

    //TODO Improve this configuration using Spring Boot utility classes
    @BeforeAll
    public static void init() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("username", "postgres");
        properties.setProperty("password", "postgres");

        log.info("Connecting");
        connection =
            new ContainerDatabaseDriver()
                .connect("jdbc:tc:postgresql:15.1-alpine:///sakila?TC_TMPFS=/testtmpfs:rw", properties);

        ctx = DSL.using(connection, SQLDialect.POSTGRES);

        // Use JDBC directly instead of jOOQ to avoid DEBUG logging all of this
        try (Statement s = connection.createStatement()) {
            log.info("Setting up database");
            s.execute(
                Source.of(TestContainersTest.class.getResourceAsStream("/postgres-sakila-schema.sql")).readString()
            );

            log.info("Inserting data to database");
            s.execute(
                Source.of(TestContainersTest.class.getResourceAsStream("/postgres-sakila-insert-data.sql")).readString()
            );

            log.info("Finished setup");
        }
    }

    record Film(String title) {}

    record Actor(String firstName, String lastName) {}

    record Category(String name) {}

    public record ActorWithFirstAndLastName(String firstName, String lastName) {}

    public record ActorWithFilms(String firstName, String lastName, List<ActorWithFilms.FilmName> films) {
        public record FilmName(String name) {}
    }

    @Test
    public void testMultisetMappingIntoJavaRecords() {
        // Get films by title, and their actors and categories as nested collections, as well as
        // all the customers that have rented the film
        Result<?> result = println(
            ctx
                .select(
                    FILM.TITLE.convertFrom(Film::new),
                    multiset(
                        select(FILM_ACTOR.actor().FIRST_NAME, FILM_ACTOR.actor().LAST_NAME)
                            .from(FILM_ACTOR)
                            .where(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                    )
                        .convertFrom(r -> r.map(mapping(Actor::new))),
                    multiset(
                        select(FILM_CATEGORY.category().NAME)
                            .from(FILM_CATEGORY)
                            .where(FILM_CATEGORY.FILM_ID.eq(FILM.FILM_ID))
                    )
                        .convertFrom(r -> r.map(mapping(Category::new)))
                )
                .from(FILM)
                .where(FILM.TITLE.like("A%"))
                .orderBy(FILM.TITLE)
                .limit(5)
        )
            .fetch();

        System.out.println(result);
    }

    @Test
    public void testMultisetFormattingAsXMLorJSON() {
        // Get films by title, and their actors and categories as nested collections,
        // and all the customers that have rented the film, and their payments
        Result<?> result = println(
            ctx
                .select(
                    FILM.TITLE,
                    multiset(
                        select(FILM_ACTOR.actor().FIRST_NAME, FILM_ACTOR.actor().LAST_NAME)
                            .from(FILM_ACTOR)
                            .where(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                    )
                        .as("actors"),
                    multiset(
                        select(FILM_CATEGORY.category().NAME)
                            .from(FILM_CATEGORY)
                            .where(FILM_CATEGORY.FILM_ID.eq(FILM.FILM_ID))
                    )
                        .as("categories"),
                    multiset(
                        select(
                            PAYMENT.rental().customer().FIRST_NAME,
                            PAYMENT.rental().customer().LAST_NAME,
                            multisetAgg(PAYMENT.PAYMENT_DATE, PAYMENT.AMOUNT).as("payments"),
                            sum(PAYMENT.AMOUNT).as("total")
                        )
                            .from(PAYMENT)
                            .where(PAYMENT.rental().inventory().FILM_ID.eq(FILM.FILM_ID))
                            .groupBy(
                                PAYMENT.rental().customer().CUSTOMER_ID,
                                PAYMENT.rental().customer().FIRST_NAME,
                                PAYMENT.rental().customer().LAST_NAME
                            )
                    )
                        .as("customers")
                )
                .from(FILM)
                .where(FILM.TITLE.like("A%"))
                .orderBy(FILM.TITLE)
                .limit(5)
        )
            .fetch();

        System.out.println(result.format(new TXTFormat()));
        System.out.println(
            result.formatXML(new XMLFormat().xmlns(false).format(true).header(false).recordFormat(COLUMN_NAME_ELEMENTS))
        );
        System.out.println(result.formatJSON(new JSONFormat().format(true).header(false).recordFormat(OBJECT)));
    }

    public static final <T> T println(T t) {
        if (t instanceof Object[]) {
            System.out.println(Arrays.asList(t));
        } else {
            System.out.println(t);
        }

        return t;
    }

    @Test
    void find_all_films() {
        Result<FilmRecord> films = ctx.selectFrom(FILM).fetch();

        assertThat(films.size()).isEqualTo(1001);
    }

    @Test
    void find_all_actors_of_horror_films() {
        Result<Record2<String, String>> actorsOfHorrorFilms = ctx
            .select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .from(ACTOR)
            .join(FilmActor.FILM_ACTOR)
            .on(FilmActor.FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
            .join(FILM)
            .on(FilmActor.FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
            .join(FilmCategory.FILM_CATEGORY)
            .on(FilmCategory.FILM_CATEGORY.FILM_ID.eq(FILM.FILM_ID))
            .join(CATEGORY)
            .on(FilmCategory.FILM_CATEGORY.CATEGORY_ID.eq(CATEGORY.CATEGORY_ID))
            .where(CATEGORY.NAME.eq("Horror"))
            .groupBy(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .orderBy(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .fetch();

        assertThat(actorsOfHorrorFilms.size()).isEqualTo(155);
    }

    @Test
    void find_all_actors_of_horror_films_implicit_join() {
        Result<Record2<String, String>> actorsOfHorrorFilms = ctx
            .select(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .from(FilmActor.FILM_ACTOR)
            .join(FilmCategory.FILM_CATEGORY)
            .on(FilmActor.FILM_ACTOR.FILM_ID.eq(FilmCategory.FILM_CATEGORY.FILM_ID))
            .where(FilmCategory.FILM_CATEGORY.category().NAME.eq("Horror"))
            .groupBy(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .orderBy(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .fetch();

        assertThat(actorsOfHorrorFilms.size()).isEqualTo(155);
    }

    @Test
    void find_all_actors_of_horror_films_implicit_join_into_record() {
        List<ActorWithFirstAndLastName> actorsOfHorrorFilms = ctx
            .select(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .from(FilmActor.FILM_ACTOR)
            .join(FilmCategory.FILM_CATEGORY)
            .on(FilmActor.FILM_ACTOR.FILM_ID.eq(FilmCategory.FILM_CATEGORY.FILM_ID))
            .where(FilmCategory.FILM_CATEGORY.category().NAME.eq("Horror"))
            .groupBy(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .orderBy(FilmActor.FILM_ACTOR.actor().FIRST_NAME, FilmActor.FILM_ACTOR.actor().LAST_NAME)
            .fetchInto(ActorWithFirstAndLastName.class);

        assertThat(actorsOfHorrorFilms.size()).isEqualTo(155);
    }

    @Test
    void insert_film() {
        int insertedRows = ctx.insertInto(FILM).columns(FILM.TITLE, FILM.LANGUAGE_ID).values("Test", 1L).execute();

        assertThat(insertedRows).isEqualTo(1);
    }

    @Test
    void insert_film_using_record() {
        FilmRecord filmRecord = ctx.newRecord(FILM);
        filmRecord.setTitle("Test");
        filmRecord.setLanguageId(1L);
        int insertedRows = filmRecord.store();

        assertThat(insertedRows).isEqualTo(1);
    }

    @Test
    void find_film() {
        FilmRecord filmRecord = ctx.selectFrom(FILM).where(FILM.FILM_ID.eq(1L)).fetchOne();

        assertThat(filmRecord).isNotNull();
        assertThat(filmRecord.getTitle()).isEqualTo("ACADEMY DINOSAUR");
    }
}
