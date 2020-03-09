package com.example.laboratorio5.ui.dbEncuesta;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DaoEncuesta_Impl implements DaoEncuesta {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataBaseEncuesta> __insertionAdapterOfDataBaseEncuesta;

  public DaoEncuesta_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataBaseEncuesta = new EntityInsertionAdapter<DataBaseEncuesta>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `DataBaseEncuesta` (`id`,`fecha_creacion`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataBaseEncuesta value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getFecha_creacion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFecha_creacion());
        }
      }
    };
  }

  @Override
  public void insertAll(final DataBaseEncuesta... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDataBaseEncuesta.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DataBaseEncuesta> getAll() {
    final String _sql = "SELECT * FROM DataBaseEncuesta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha_creacion");
      final List<DataBaseEncuesta> _result = new ArrayList<DataBaseEncuesta>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBaseEncuesta _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpFecha_creacion;
        _tmpFecha_creacion = _cursor.getString(_cursorIndexOfFechaCreacion);
        _item = new DataBaseEncuesta(_tmpId,_tmpFecha_creacion);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
