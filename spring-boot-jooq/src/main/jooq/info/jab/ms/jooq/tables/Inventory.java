/*
 * This file is generated by jOOQ.
 */
package info.jab.ms.jooq.tables;


import info.jab.ms.jooq.Indexes;
import info.jab.ms.jooq.Keys;
import info.jab.ms.jooq.Public;
import info.jab.ms.jooq.tables.records.InventoryRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Inventory extends TableImpl<InventoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.inventory</code>
     */
    public static final Inventory INVENTORY = new Inventory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InventoryRecord> getRecordType() {
        return InventoryRecord.class;
    }

    /**
     * The column <code>public.inventory.inventory_id</code>.
     */
    public final TableField<InventoryRecord, Long> INVENTORY_ID = createField(DSL.name("inventory_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.inventory.film_id</code>.
     */
    public final TableField<InventoryRecord, Long> FILM_ID = createField(DSL.name("film_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.inventory.store_id</code>.
     */
    public final TableField<InventoryRecord, Long> STORE_ID = createField(DSL.name("store_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.inventory.last_update</code>.
     */
    public final TableField<InventoryRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private Inventory(Name alias, Table<InventoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Inventory(Name alias, Table<InventoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.inventory</code> table reference
     */
    public Inventory(String alias) {
        this(DSL.name(alias), INVENTORY);
    }

    /**
     * Create an aliased <code>public.inventory</code> table reference
     */
    public Inventory(Name alias) {
        this(alias, INVENTORY);
    }

    /**
     * Create a <code>public.inventory</code> table reference
     */
    public Inventory() {
        this(DSL.name("inventory"), null);
    }

    public <O extends Record> Inventory(Table<O> child, ForeignKey<O, InventoryRecord> key) {
        super(child, key, INVENTORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_STORE_ID_FILM_ID);
    }

    @Override
    public Identity<InventoryRecord, Long> getIdentity() {
        return (Identity<InventoryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<InventoryRecord> getPrimaryKey() {
        return Keys.INVENTORY_PKEY;
    }

    @Override
    public List<ForeignKey<InventoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.INVENTORY__INVENTORY_FILM_ID_FKEY, Keys.INVENTORY__INVENTORY_STORE_ID_FKEY);
    }

    private transient Film _film;
    private transient Store _store;

    /**
     * Get the implicit join path to the <code>public.film</code> table.
     */
    public Film film() {
        if (_film == null)
            _film = new Film(this, Keys.INVENTORY__INVENTORY_FILM_ID_FKEY);

        return _film;
    }

    /**
     * Get the implicit join path to the <code>public.store</code> table.
     */
    public Store store() {
        if (_store == null)
            _store = new Store(this, Keys.INVENTORY__INVENTORY_STORE_ID_FKEY);

        return _store;
    }

    @Override
    public Inventory as(String alias) {
        return new Inventory(DSL.name(alias), this);
    }

    @Override
    public Inventory as(Name alias) {
        return new Inventory(alias, this);
    }

    @Override
    public Inventory as(Table<?> alias) {
        return new Inventory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Inventory rename(String name) {
        return new Inventory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Inventory rename(Name name) {
        return new Inventory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Inventory rename(Table<?> name) {
        return new Inventory(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super Long, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Long, ? super Long, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}