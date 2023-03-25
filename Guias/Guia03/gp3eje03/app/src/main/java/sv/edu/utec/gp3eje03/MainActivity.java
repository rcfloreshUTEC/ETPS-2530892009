package sv.edu.utec.gp3eje03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtnumeros;
    TextView tvResultado, tvVueltas;
    double suma = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtnumeros = findViewById(R.id.edtNumero);
        tvResultado = findViewById(R.id.tvResultado);
        tvVueltas = findViewById(R.id.tvVuelta);
    }
    public void Calcular (View view){
        int i = 0;
        boolean status = true;

        do {
            i++;
            if (i <10)
            {
                Double numero = Double.parseDouble(edtnumeros.getText().toString());

                if (i > 4) {
                    suma += numero;
                    tvResultado.setText(String.valueOf("Suma: "+suma));
                }
            }
            else {
                status = false;
            }


        }while(status);

    }
}