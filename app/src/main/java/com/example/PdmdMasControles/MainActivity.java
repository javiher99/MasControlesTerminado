package com.example.PdmdMasControles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String A = "AB";
    //Instancia
    ToggleButton toggle;
    Switch sw;
    TextView tv;
    EditText ciudadFav;
    Button btLanzar;

    private static final String[] COUNTRIES = new String[] {
            "España", "Francia", "Italia", "Alemania", "Noruega", "Japon", "Portugal", "Africa Negros"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.paisesArray);
        textView.setAdapter(adapter);

        ciudadFav = findViewById(R.id.etCiudadFav);

        // Accion del ToogleButton
        toggle = findViewById(R.id.tbGusta);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv = findViewById(R.id.tvTexto);
                    tv.setText(R.string.vivir);
                } else {
                    // The toggle is disabled
                    tv = findViewById(R.id.tvTexto);
                    tv.setText(R.string.noVivir);
                }
            }
        });

        // Accion del Switch
        sw = findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv.setText("Quiero una pareja de alli");
                }else{
                    tv.setText("No quiero una pareja de alli");
                }
            }
        });


        btLanzar = findViewById(R.id.btEnviar);
        btLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad();
            }
        });
    }

    private void lanzarActividad(){
        Intent i = new Intent(MainActivity.this, SegundaActivity.class);
        String ciudad = ciudadFav.getText().toString();
        i.putExtra(A,ciudad);
        startActivity(i);

    }
}
