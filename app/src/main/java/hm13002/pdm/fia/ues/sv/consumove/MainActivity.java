package hm13002.pdm.fia.ues.sv.consumove;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarActividad(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.button_cliente_insertar:
                i = new Intent(this, InsertarAlumnoActivity.class);
                break;
            case R.id.button_cliente_consultar:
                i = new Intent(this, ConsultarClienteActivity.class);
                break;

        }
        if (i != null)
            startActivity(i);
    }
}
