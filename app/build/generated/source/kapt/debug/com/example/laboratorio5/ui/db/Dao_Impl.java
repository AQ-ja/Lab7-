package com.example.laboratorio5.ui.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
public final class Dao_Impl implements Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataBase> __insertionAdapterOfDataBase;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  public Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataBase = new EntityInsertionAdapter<DataBase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `DataBase` (`id`,`tipo`,`pregunta`,`defaul`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataBase value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTipo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipo());
        }
        if (value.getPregunta() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPregunta());
        }
        final int _tmp;
        _tmp = value.getDefaul() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM `DataBase` WHERE `DataBase`.`defaul` = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final DataBase... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDataBase.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeAll(final boolean dayId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAll.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = dayId ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveAll.release(_stmt);
    }
  }

  @Override
  public List<DataBase> getAll() {
    final String _sql = "SELECT * FROM `DataBase` ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfPregunta = CursorUtil.getColumnIndexOrThrow(_cursor, "pregunta");
      final int _cursorIndexOfDefaul = CursorUtil.getColumnIndexOrThrow(_cursor, "defaul");
      final List<DataBase> _result = new ArrayList<DataBase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBase _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        final String _tmpPregunta;
        _tmpPregunta = _cursor.getString(_cursorIndexOfPregunta);
        final boolean _tmpDefaul;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDefaul);
        _tmpDefaul = _tmp != 0;
        _item = new DataBase(_tmpId,_tmpTipo,_tmpPregunta,_tmpDefaul);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DataBase> findID(final int search) {
    final String _sql = "SELECT * FROM `DataBase` WHERE id LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, search);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfPregunta = CursorUtil.getColumnIndexOrThrow(_cursor, "pregunta");
      final int _cursorIndexOfDefaul = CursorUtil.getColumnIndexOrThrow(_cursor, "defaul");
      final List<DataBase> _result = new ArrayList<DataBase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBase _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        final String _tmpPregunta;
        _tmpPregunta = _cursor.getString(_cursorIndexOfPregunta);
        final boolean _tmpDefaul;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDefaul);
        _tmpDefaul = _tmp != 0;
        _item = new DataBase(_tmpId,_tmpTipo,_tmpPregunta,_tmpDefaul);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
