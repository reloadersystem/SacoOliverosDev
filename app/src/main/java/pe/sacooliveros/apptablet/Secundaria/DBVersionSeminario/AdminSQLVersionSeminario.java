package pe.sacooliveros.apptablet.Secundaria.DBVersionSeminario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLVersionSeminario extends SQLiteOpenHelper {


    public AdminSQLVersionSeminario(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        BaseDeDatos.execSQL(UtilVersion.CREAR_TABLA_VERSIONSEMINARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

        BaseDeDatos.execSQL("DROP TABLE IF EXISTS tablaversiondb");

    }
}
