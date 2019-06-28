package pe.sacooliveros.apptablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import pe.sacooliveros.apptablet.WebServiceInstitucion.SacoWSConsult;

public class AdminActivity extends AppCompatActivity {

    EditText restoresystem, restorekey;
    Button btn_ingresar;

    RelativeLayout relative_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        restoresystem= findViewById(R.id.edt_restoresystem);
        restorekey= findViewById(R.id.edt_restorekey);

        btn_ingresar=findViewById(R.id.btn_ingresar);
        relative_admin=findViewById(R.id.relative_admin);


        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario= restoresystem.getText().toString();
                String password= restorekey.getText().toString();

                SacoWSConsult consult = new SacoWSConsult();
                consult.setCurrentContext(getApplicationContext());
                consult.setCurrentLayout(relative_admin);
                consult.execute(password);
            }
        });

    }
}
