package com.example.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.editTextText);
        altura = findViewById(R.id.editTextText2);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String strPeso = peso.getText().toString();
            String strAltura = altura.getText().toString();

            if (!strPeso.isEmpty() && !strAltura.isEmpty()) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("PESO_INFORMADO", strPeso);
                intent.putExtra("ALTURA_INFORMADA", strAltura);

                startActivity(intent);
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}