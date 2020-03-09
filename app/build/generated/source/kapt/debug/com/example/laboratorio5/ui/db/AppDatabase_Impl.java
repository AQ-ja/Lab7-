package com.example.laboratorio5.ui.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.laboratorio5.ui.dbEncuesta.DaoEncuesta;
import com.example.laboratorio5.ui.dbEncuesta.DaoEncuesta_Impl;
import com.example.laboratorio5.ui.dbRespuesta.DaoRespuesta;
import com.example.laboratorio5.ui.dbRespuesta.DaoRespuesta_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile Dao _dao;

  private volatile DaoEncuesta _daoEncuesta;

  private volatile DaoRespuesta _daoRespuesta;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DataBase` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `tipo` TEXT NOT NULL, `pregunta` TEXT NOT NULL, `defaul` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DataBaseEncuesta` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `fecha_creacion` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DataBaseRespuesta` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `poll_id` INTEGER NOT NULL, `question_id` INTEGER NOT NULL, `answer` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dccc4ae7da8b32e613663d935abfc642')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `DataBase`");
        _db.execSQL("DROP TABLE IF EXISTS `DataBaseEncuesta`");
        _db.execSQL("DROP TABLE IF EXISTS `DataBaseRespuesta`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDataBase = new HashMap<String, TableInfo.Column>(4);
        _columnsDataBase.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBase.put("tipo", new TableInfo.Column("tipo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBase.put("pregunta", new TableInfo.Column("pregunta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBase.put("defaul", new TableInfo.Column("defaul", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDataBase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDataBase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDataBase = new TableInfo("DataBase", _columnsDataBase, _foreignKeysDataBase, _indicesDataBase);
        final TableInfo _existingDataBase = TableInfo.read(_db, "DataBase");
        if (! _infoDataBase.equals(_existingDataBase)) {
          return new RoomOpenHelper.ValidationResult(false, "DataBase(com.example.laboratorio5.ui.db.DataBase).\n"
                  + " Expected:\n" + _infoDataBase + "\n"
                  + " Found:\n" + _existingDataBase);
        }
        final HashMap<String, TableInfo.Column> _columnsDataBaseEncuesta = new HashMap<String, TableInfo.Column>(2);
        _columnsDataBaseEncuesta.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBaseEncuesta.put("fecha_creacion", new TableInfo.Column("fecha_creacion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDataBaseEncuesta = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDataBaseEncuesta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDataBaseEncuesta = new TableInfo("DataBaseEncuesta", _columnsDataBaseEncuesta, _foreignKeysDataBaseEncuesta, _indicesDataBaseEncuesta);
        final TableInfo _existingDataBaseEncuesta = TableInfo.read(_db, "DataBaseEncuesta");
        if (! _infoDataBaseEncuesta.equals(_existingDataBaseEncuesta)) {
          return new RoomOpenHelper.ValidationResult(false, "DataBaseEncuesta(com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta).\n"
                  + " Expected:\n" + _infoDataBaseEncuesta + "\n"
                  + " Found:\n" + _existingDataBaseEncuesta);
        }
        final HashMap<String, TableInfo.Column> _columnsDataBaseRespuesta = new HashMap<String, TableInfo.Column>(4);
        _columnsDataBaseRespuesta.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBaseRespuesta.put("poll_id", new TableInfo.Column("poll_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBaseRespuesta.put("question_id", new TableInfo.Column("question_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDataBaseRespuesta.put("answer", new TableInfo.Column("answer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDataBaseRespuesta = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDataBaseRespuesta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDataBaseRespuesta = new TableInfo("DataBaseRespuesta", _columnsDataBaseRespuesta, _foreignKeysDataBaseRespuesta, _indicesDataBaseRespuesta);
        final TableInfo _existingDataBaseRespuesta = TableInfo.read(_db, "DataBaseRespuesta");
        if (! _infoDataBaseRespuesta.equals(_existingDataBaseRespuesta)) {
          return new RoomOpenHelper.ValidationResult(false, "DataBaseRespuesta(com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta).\n"
                  + " Expected:\n" + _infoDataBaseRespuesta + "\n"
                  + " Found:\n" + _existingDataBaseRespuesta);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dccc4ae7da8b32e613663d935abfc642", "2e36d55f527c0e0e86d008e8eed352b1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DataBase","DataBaseEncuesta","DataBaseRespuesta");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `DataBase`");
      _db.execSQL("DELETE FROM `DataBaseEncuesta`");
      _db.execSQL("DELETE FROM `DataBaseRespuesta`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public Dao userDao() {
    if (_dao != null) {
      return _dao;
    } else {
      synchronized(this) {
        if(_dao == null) {
          _dao = new Dao_Impl(this);
        }
        return _dao;
      }
    }
  }

  @Override
  public DaoEncuesta encuesta() {
    if (_daoEncuesta != null) {
      return _daoEncuesta;
    } else {
      synchronized(this) {
        if(_daoEncuesta == null) {
          _daoEncuesta = new DaoEncuesta_Impl(this);
        }
        return _daoEncuesta;
      }
    }
  }

  @Override
  public DaoRespuesta respuesta() {
    if (_daoRespuesta != null) {
      return _daoRespuesta;
    } else {
      synchronized(this) {
        if(_daoRespuesta == null) {
          _daoRespuesta = new DaoRespuesta_Impl(this);
        }
        return _daoRespuesta;
      }
    }
  }
}
