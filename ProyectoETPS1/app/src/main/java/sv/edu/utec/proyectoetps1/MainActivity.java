package sv.edu.utec.proyectoetps1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistro = findViewById(R.id.btnRegistrar);
        btnInicio = findViewById(R.id.btnLogin);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(new Intent(getApplicationContext(), Busqueda.class));
                startActivity(new Intent(i));
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(new Intent(getApplicationContext(), Registro.class));
                startActivity(new Intent(i));
            }
        });

    }
}