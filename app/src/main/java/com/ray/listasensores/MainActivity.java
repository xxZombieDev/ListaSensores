package com.ray.listasensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.List;
//Clase principal
public class MainActivity extends AppCompatActivity {
    // Creamos una variable de tipo TextView
    private TextView txtSensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Agregamos el Toolbar personalizado a nuestra activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Referenciamos nuestro TextView con el de nuestro activity
        txtSensores = findViewById(R.id.txtSensores);
        // Praparamos un SensorManager para poder hacer uso de los sensores
        SensorManager sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
        //Creamos un List con todos los sensores que tenemos en nuestro dispositivo
        List<Sensor> listaSensores = sensorManager.
                getSensorList(Sensor.TYPE_ALL);
        // Hacemos un For Each que haga un recorrido de todos los sensores que tenemos
        for(Sensor sensor: listaSensores) {
            // y los mostramos en nuestro TextView con el metodo Append
            txtSensores.append(sensor.getName() + "\n");
        }
        // Referenciamos un FAB con el de nuestro activity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            // Al hacer clic en el
            @Override
            public void onClick(View view) {
                // Mostramos un MaterialDialog con informacion de que tenemos un listado de sensores
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Ayuda")
                        .setMessage(R.string.textoAyuda)
                        .setIcon(R.drawable.ic_help)
                        .setPositiveButton("Aceptar", null)
                        .show();
            }
        });
    }

}
