/*
 * This file is generated by jOOQ.
 */
package info.jab.ms.jooq.tables.records;


import info.jab.ms.jooq.tables.FilmActor;
import info.jab.ms.jooq.tables.pojos.JooqFilmActor;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FilmActorRecord extends UpdatableRecordImpl<FilmActorRecord> implements Record3<Long, Long, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.film_actor.actor_id</code>.
     */
    public void setActorId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.film_actor.actor_id</code>.
     */
    public Long getActorId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.film_actor.film_id</code>.
     */
    public void setFilmId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.film_actor.film_id</code>.
     */
    public Long getFilmId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.film_actor.last_update</code>.
     */
    public void setLastUpdate(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.film_actor.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, LocalDateTime> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return FilmActor.FILM_ACTOR.ACTOR_ID;
    }

    @Override
    public Field<Long> field2() {
        return FilmActor.FILM_ACTOR.FILM_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return FilmActor.FILM_ACTOR.LAST_UPDATE;
    }

    @Override
    public Long component1() {
        return getActorId();
    }

    @Override
    public Long component2() {
        return getFilmId();
    }

    @Override
    public LocalDateTime component3() {
        return getLastUpdate();
    }

    @Override
    public Long value1() {
        return getActorId();
    }

    @Override
    public Long value2() {
        return getFilmId();
    }

    @Override
    public LocalDateTime value3() {
        return getLastUpdate();
    }

    @Override
    public FilmActorRecord value1(Long value) {
        setActorId(value);
        return this;
    }

    @Override
    public FilmActorRecord value2(Long value) {
        setFilmId(value);
        return this;
    }

    @Override
    public FilmActorRecord value3(LocalDateTime value) {
        setLastUpdate(value);
        return this;
    }

    @Override
    public FilmActorRecord values(Long value1, Long value2, LocalDateTime value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FilmActorRecord
     */
    public FilmActorRecord() {
        super(FilmActor.FILM_ACTOR);
    }

    /**
     * Create a detached, initialised FilmActorRecord
     */
    public FilmActorRecord(Long actorId, Long filmId, LocalDateTime lastUpdate) {
        super(FilmActor.FILM_ACTOR);

        setActorId(actorId);
        setFilmId(filmId);
        setLastUpdate(lastUpdate);
    }

    /**
     * Create a detached, initialised FilmActorRecord
     */
    public FilmActorRecord(JooqFilmActor value) {
        super(FilmActor.FILM_ACTOR);

        if (value != null) {
            setActorId(value.getActorId());
            setFilmId(value.getFilmId());
            setLastUpdate(value.getLastUpdate());
        }
    }
}