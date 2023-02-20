package info.jab.ms.mybatis.generated.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ActorTableDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ActorTable actorTable = new ActorTable();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> actorId = actorTable.actorId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> firstName = actorTable.firstName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastName = actorTable.lastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lastUpdate = actorTable.lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ActorTable extends AliasableSqlTable<ActorTable> {
        public final SqlColumn<Integer> actorId = column("actor_id", JDBCType.INTEGER);

        public final SqlColumn<String> firstName = column("first_name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> lastUpdate = column("last_update", JDBCType.TIMESTAMP);

        public ActorTable() {
            super("public.actor", ActorTable::new);
        }
    }
}