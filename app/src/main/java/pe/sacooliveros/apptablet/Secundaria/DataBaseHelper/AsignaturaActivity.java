package pe.sacooliveros.apptablet.Secundaria.DataBaseHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import pe.sacooliveros.apptablet.R;

public class AsignaturaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_codigo, et_capitulo, et_asignatura, et_urlpdf, et_ssdpdf, et_habilitar, et_tomopdf, et_gradopdf, et_listyoutube;

    Button btRegistrar, btBuscar, btEliminar, btModificar, btVaciar, btListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);


        et_codigo = findViewById(R.id.txt_codigodb);
        et_capitulo = findViewById(R.id.txt_capitulodb);
        et_asignatura = findViewById(R.id.txt_asiganturadb);
        et_urlpdf = findViewById(R.id.txt_urlpdfdb);
        et_ssdpdf = findViewById(R.id.txt_ssdpdfdb);
        et_habilitar = findViewById(R.id.txt_deshabilitardb);
        et_tomopdf = findViewById(R.id.txt_tomopdf);
        et_gradopdf = findViewById(R.id.txt_gradopdf);
        et_listyoutube = findViewById(R.id.txt_listyoutube);


        btRegistrar = findViewById(R.id.btRegistrar);
        btBuscar = findViewById(R.id.btnBuscar);
        btEliminar = findViewById(R.id.btnEliminar);
        btModificar = findViewById(R.id.btnModificar);
        btVaciar = findViewById(R.id.btnVaciar);
        btListar = findViewById(R.id.btnListar);


        btRegistrar.setOnClickListener(this);
        btBuscar.setOnClickListener(this);
        btEliminar.setOnClickListener(this);
        btModificar.setOnClickListener(this);
        btVaciar.setOnClickListener(this);
        btListar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btRegistrar:

                Registrar();

                break;

            case R.id.btnBuscar:

                Buscar();

                break;

            case R.id.btnEliminar:

                Eliminar();

                break;

            case R.id.btnModificar:

                Modificar();

                break;

            case R.id.btnVaciar:
                // Vaciar();

                break;


            case R.id.btnListar:
                listar();

                break;
        }
    }


    private void Eliminar() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdseminarios", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String codigo = et_codigo.getText().toString();

        if (!codigo.isEmpty()) {
            int cantidad = BaseDeDatos.delete("videoseminario", "codigo=" + codigo, null);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_capitulo.setText("");
            et_asignatura.setText("");
            et_urlpdf.setText("");
            et_ssdpdf.setText("");
            et_habilitar.setText("");
            et_tomopdf.setText("");
            et_gradopdf.setText("");
            et_listyoutube.setText("");

            if (cantidad == 1) {
                Toast.makeText(this, "Eliminacion exitosa", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "no existe el articulo que deseas eliminar", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        } else {
            Toast.makeText(this, "Debes ingresar un codigo para eliminiar", Toast.LENGTH_SHORT).show();
        }

    }

    private void Buscar() {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdseminarios", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String codigo = et_codigo.getText().toString();


        if (!codigo.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery(
                    "select asignatura, habilitar,capitulo,urlpdf,ssdpdf,tomopdf,gradopdf,listyoutube from videoseminario where codigo=" + codigo, null);

            if (fila.moveToFirst())

            {
                et_asignatura.setText(fila.getString(0));
                et_habilitar.setText(fila.getString(1));
                et_capitulo.setText(fila.getString(2));
                et_urlpdf.setText(fila.getString(3));
                et_ssdpdf.setText(fila.getString(4));
                et_tomopdf.setText(fila.getString(5));
                et_gradopdf.setText(fila.getString(6));
                et_listyoutube.setText(fila.getString(7));

                BaseDeDatos.close();

            } else {
                Toast.makeText(this, "no existe el articulo que estas buscando", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        } else {
            Toast.makeText(this, "Debes ingresar un codigo para buscar", Toast.LENGTH_SHORT).show();
        }
    }

    private void listar() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdseminarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (BaseDeDatos != null) {
            Cursor c = BaseDeDatos.rawQuery("select * from videoseminario", null);

            int cantidad = c.getCount();
            int i = 0;
            //cantidad de registros


            String[] arreglo = new String[cantidad];

            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getString(3) + " " + c.getString(4) + " " + c.getString(5) + " " + c.getString(6) + " " + c.getString(7) + " " + c.getString(8);

                    arreglo[i] = linea;
                    i++;

                } while (c.moveToNext());
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);

            ListView lista = (ListView) findViewById(R.id.lista);

            lista.setAdapter(adapter);
        }
    }

    public void Registrar() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdseminarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        et_codigo = findViewById(R.id.txt_codigodb);
        et_capitulo = findViewById(R.id.txt_capitulodb);
        et_asignatura = findViewById(R.id.txt_asiganturadb);
        et_urlpdf = findViewById(R.id.txt_urlpdfdb);
        et_ssdpdf = findViewById(R.id.txt_ssdpdfdb);
        et_habilitar = findViewById(R.id.txt_deshabilitardb);
        et_tomopdf = findViewById(R.id.txt_tomopdf);
        et_gradopdf = findViewById(R.id.txt_gradopdf);
        et_listyoutube = findViewById(R.id.txt_listyoutube);

        String codigo = et_codigo.getText().toString();
        String capitulo = et_capitulo.getText().toString();
        String asignatura = et_asignatura.getText().toString();
        String urlpdf = et_urlpdf.getText().toString();
        String ssdpdf = et_ssdpdf.getText().toString();
        String habilitar = et_habilitar.getText().toString();
        String tomopdf = et_tomopdf.getText().toString();
        String gradopdf = et_gradopdf.getText().toString();
        String listyoutube = et_listyoutube.getText().toString();

        if (!codigo.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("asignatura", asignatura);
            registro.put("habilitar", habilitar);
            registro.put("capitulo", capitulo);
            registro.put("urlpdf", urlpdf);
            registro.put("ssdpdf", ssdpdf);
            registro.put("tomopdf", tomopdf);
            registro.put("gradopdf", gradopdf);
            registro.put("listyoutube", listyoutube);

            BaseDeDatos.insert("videoseminario", null, registro);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_capitulo.setText("");
            et_asignatura.setText("");
            et_urlpdf.setText("");
            et_ssdpdf.setText("");
            et_habilitar.setText("");
            et_tomopdf.setText("");
            et_gradopdf.setText("");
            et_listyoutube.setText("");

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Debes llenar los  datos", Toast.LENGTH_SHORT).show();
        }

    }


    private void Modificar() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdseminarios", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String capitulo = et_capitulo.getText().toString();
        String asignatura = et_asignatura.getText().toString();
        String urlpdf = et_urlpdf.getText().toString();
        String ssdpdf = et_ssdpdf.getText().toString();
        String habilitar = et_habilitar.getText().toString();
        String tomopdf = et_tomopdf.getText().toString();
        String gradopdf = et_gradopdf.getText().toString();
        String listyoutube = et_listyoutube.getText().toString();

        if (!codigo.isEmpty())

        {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("asignatura", asignatura);
            registro.put("habilitar", habilitar);
            registro.put("capitulo", capitulo);
            registro.put("urlpdf", urlpdf);
            registro.put("ssdpdf", ssdpdf);
            registro.put("tomopdf", tomopdf);
            registro.put("gradopdf", gradopdf);
            registro.put("listyoutube", listyoutube);


            int cantidad = BasedeDatos.update("videoseminario", registro, "codigo=" + codigo, null);
            BasedeDatos.close();

            if (cantidad == 1) {
                Toast.makeText(this, "articulo modificado correctamen", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "el articulo no existe", Toast.LENGTH_SHORT).show();

            }


        } else {
            Toast.makeText(this, "debes ingresar un dato", Toast.LENGTH_SHORT).show();
        }

    }

}
