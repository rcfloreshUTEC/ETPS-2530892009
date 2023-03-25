package sv.edu.utec.gp3eje02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNumeros;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumeros = findViewById(R.id.edtNumeros);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void Calcular (View view){
        int numero;

        try {
            numero = Integer.parseInt(edtNumeros.getText().toString());
            if (numero >= 100 && numero <= 999)
            {
                tvResultado.setText("El numero cuenta con tres cifras");
            }
            else if (numero >=10 && numero <= 99)
            {
                tvResultado.setText("El numero cuenta con dos cifras");
            } else if (numero >= 0 && numero <= 9) {
                tvResultado.setText("El numero cuenta con una cifra");
            }
            else
            {
                tvResultado.setText(String.valueOf("El dato ingresado es erroneo"));
            }
        }
        catch (Exception e)
        {
            tvResultado.setText(String.valueOf("El dato ingresado es erroneo"));
        }
    }
}