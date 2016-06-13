package hm13002.pdm.fia.ues.sv.consumove;

import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

@SuppressLint("NewApi")
public class ConsultaEstablecimientoPorTipo extends Activity {

    Spinner tipoEs;
    ControlBDAlumno db;
    Conexion conn;
    ListView listaEstable;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_establecimiento_por_tipo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        tipoEs =(Spinner) findViewById(R.id.spinnerTE);
        listaEstable =(ListView) findViewById(R.id.listaestablec);
        conn = new Conexion();
         /*Spinner de tipo estblecimiento*/
       String url = conn.getURLLocal() + "/listaTipoEstablec.php";
        String listaTiEs = ControladorServicio.obtenerRespuestaPeticion(url, this);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ControladorServicio.listaTipoEstablec(listaTiEs,this));
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoEs.setAdapter(adaptador);

    }

    public void consultarPromedioPHP(View v) {
        String tipoEstablecimiento = tipoEs.getSelectedItem().toString();
        String url = "";
        url = conn.getURLLocal() + "/ws_db_carnet_group.php?carnet=" + tipoEstablecimiento;
        String notaPromedioJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
        //lista.setText("Nota Promedio Externo: " + ControladorServicio.obtenerPromedioJSON(notaPromedioJSON, this));
    }
}
