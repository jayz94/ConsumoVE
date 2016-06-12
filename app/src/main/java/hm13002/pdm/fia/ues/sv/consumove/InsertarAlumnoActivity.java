package hm13002.pdm.fia.ues.sv.consumove;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class InsertarAlumnoActivity extends AppCompatActivity {

    EditText dui;
    EditText nombre;
    EditText apellido;
    RadioGroup radioGroupSexo;
    EditText edad;
    EditText correo;
    String sexo;

    Conexion conn;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insertar_alumno);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        conn = new Conexion();

        dui=(EditText)findViewById(R.id.editTextDui);
        nombre=(EditText)findViewById(R.id.editTextNombre);
        apellido=(EditText)findViewById(R.id.editTextApellido);

        radioGroupSexo=(RadioGroup)findViewById(R.id.radioGroupCliente);
        edad=(EditText)findViewById(R.id.editTextEdad);
        correo=(EditText)findViewById(R.id.editTextCorreo);

        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    sexo = "M";

                } else if (checkedId == R.id.radioButton2) {
                    sexo = "F";
                }
            }
        });
    }

    public void insertarCliente(View v) {
        String Dui=dui.getText().toString();
        String Nombre=nombre.getText().toString();
        String Apellido=apellido.getText().toString();

        Integer Edad=Integer.valueOf(edad.getText().toString());
        String Correo=correo.getText().toString();

        String url = null;

        JSONObject datosCliente = new JSONObject();
        JSONObject cliente = new JSONObject();

        if (v.getId() == R.id.btLocal) {
            url = "";
                url = conn.getURLLocal() + "/ws_cliente_insert.php" + "?dui=" + Dui + "&nombre=" + Nombre + "&apellido=" + apellido + "&sexo=" + sexo + "&edad" + Edad + "&correo"+ Correo;

            ControladorServicio.insertarClientePHP(url, this);
        }
    }
}
