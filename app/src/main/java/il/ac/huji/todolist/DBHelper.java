package il.ac.huji.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "todo_db", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // backward compatibility :D
        db.execSQL("DROP TABLE IF EXISTS " + RepositoryConsts.TABLE_TODOS);
        db.execSQL(
                "CREATE TABLE " + RepositoryConsts.TABLE_TODOS + " (" + RepositoryConsts.FIELD_TODOS_ID + " integer primary key autoincrement, " +
                        RepositoryConsts.FIELD_TODOS_TITLE + " string, " +
                        RepositoryConsts.FIELD_TODOS_DUE_DATE + " long);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
