package com.example.app;

import android.os.Bundle;
import android.widget.TextView; // Importante para exibir o resultado

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String sPeso = extras.getString("PESO");
            String sAltura = extras.getString("ALTURA");

            if (sPeso != null && sAltura != null) {
                double valorPeso = Double.parseDouble(sPeso);
                double valorAltura = Double.parseDouble(sAltura);

                double imc = valorPeso / (valorAltura * valorAltura);

                TextView resultado = findViewById(R.id.textViewResultado);
                resultado.setText(String.format("Seu IMC é: %.2f", imc));
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}