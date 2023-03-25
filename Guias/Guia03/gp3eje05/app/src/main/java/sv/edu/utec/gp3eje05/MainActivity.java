package sv.edu.utec.gp3eje05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {

    Button btnCalculo;
    EditText edtlado01, edtlado02, edtlado03;
    TextView tvTipoFormas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculo = findViewById(R.id.btnCalcular);

        edtlado01 = findViewById(R.id.edtLado1);
        edtlado02 = findViewById(R.id.edtLado2);
        edtlado03 = findViewById(R.id.edtLado3);

        //tvTipoFormas = findViewById(R.id.tvtipoforma);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new Intent(getApplicationContext(), Triangulo.class));
                i.putExtra("lado01", Double.parseDouble(edtlado01.getText().toString()));
                i.putExtra("lado02", Double.parseDouble(edtlado02.getText().toString()));
                i.putExtra("lado03", Double.parseDouble(edtlado03.getText().toString()));
                startActivity(new Intent(i));
            }
        });



    }






}

