package sv.edu.utec.gp3eje01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    EditText edtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumero = findViewById(R.id.edtNumero);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void Calcular(View view) {
        double numero;


        try {
            numero = Double.parseDouble(edtNumero.getText().toString());
            if (numero < 0) {
                tvResultado.setText(String.valueOf("El numero es negativo"));
            } else if (numero > 0) {
                tvResultado.setText(String.valueOf("El numero es positivo"));
            } else {
                tvResultado.setText(String.valueOf("El numero es nulo"));
            }
        }
        catch (Exception e){
            tvResultado.setText(String.valueOf("El dato ingresado es erroneo"));
        }


    }

}