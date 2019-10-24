package com.example.PdmdMasControles;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SegundaActivity extends AppCompatActivity {
    private static final String A = "A";
    // Instancia
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        // Saco lo que hay en el intent
        Intent intent = getIntent();
        //messageSex tiene el contenido de ciudadFav
        String mensaje =intent.getStringExtra("AB");

        tv = findViewById(R.id.tvFav);
        tv.setText(mensaje);
    }
}
