package com.example.laboratorio5.ui.dbRespuesta;

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
public final class DaoRespuesta_Impl implements DaoRespuesta {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataBaseRespuesta> __insertionAdapterOfDataBaseRespuesta;

  public DaoRespuesta_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataBaseRespuesta = new EntityInsertionAdapter<DataBaseRespuesta>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `DataBaseRespuesta` (`id`,`poll_id`,`question_id`,`answer`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataBaseRespuesta value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getPoll_id());
        stmt.bindLong(3, value.getQuestion_id());
        if (value.getAnswer() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAnswer());
        }
      }
    };
  }

  @Override
  public void insertAll(final DataBaseRespuesta... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDataBaseRespuesta.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DataBaseRespuesta> getAll() {
    final String _sql = "SELECT * FROM DataBaseRespuesta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPollId = CursorUtil.getColumnIndexOrThrow(_cursor, "poll_id");
      final int _cursorIndexOfQuestionId = CursorUtil.getColumnIndexOrThrow(_cursor, "question_id");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final List<DataBaseRespuesta> _result = new ArrayList<DataBaseRespuesta>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBaseRespuesta _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpPoll_id;
        _tmpPoll_id = _cursor.getInt(_cursorIndexOfPollId);
        final int _tmpQuestion_id;
        _tmpQuestion_id = _cursor.getInt(_cursorIndexOfQuestionId);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        _item = new DataBaseRespuesta(_tmpId,_tmpPoll_id,_tmpQuestion_id,_tmpAnswer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DataBaseRespuesta> findid(final int search) {
    final String _sql = "SELECT * FROM DataBaseRespuesta WHERE poll_id LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, search);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPollId = CursorUtil.getColumnIndexOrThrow(_cursor, "poll_id");
      final int _cursorIndexOfQuestionId = CursorUtil.getColumnIndexOrThrow(_cursor, "question_id");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final List<DataBaseRespuesta> _result = new ArrayList<DataBaseRespuesta>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBaseRespuesta _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpPoll_id;
        _tmpPoll_id = _cursor.getInt(_cursorIndexOfPollId);
        final int _tmpQuestion_id;
        _tmpQuestion_id = _cursor.getInt(_cursorIndexOfQuestionId);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        _item = new DataBaseRespuesta(_tmpId,_tmpPoll_id,_tmpQuestion_id,_tmpAnswer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DataBaseRespuesta> find(final int search) {
    final String _sql = "SELECT * FROM DataBaseRespuesta WHERE question_id LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, search);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPollId = CursorUtil.getColumnIndexOrThrow(_cursor, "poll_id");
      final int _cursorIndexOfQuestionId = CursorUtil.getColumnIndexOrThrow(_cursor, "question_id");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final List<DataBaseRespuesta> _result = new ArrayList<DataBaseRespuesta>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataBaseRespuesta _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpPoll_id;
        _tmpPoll_id = _cursor.getInt(_cursorIndexOfPollId);
        final int _tmpQuestion_id;
        _tmpQuestion_id = _cursor.getInt(_cursorIndexOfQuestionId);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        _item = new DataBaseRespuesta(_tmpId,_tmpPoll_id,_tmpQuestion_id,_tmpAnswer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
