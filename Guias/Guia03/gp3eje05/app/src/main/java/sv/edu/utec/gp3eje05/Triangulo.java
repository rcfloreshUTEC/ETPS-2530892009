package sv.edu.utec.gp3eje05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Triangulo extends AppCompatActivity {
    String Resultado;
    TextView edtTipoTriangulo;

    ImageView imgvFormaT;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        Bundle bundle = getIntent().getExtras();

        edtTipoTriangulo = findViewById(R.id.edtFTriangulo);
        imgvFormaT = findViewById(R.id.imgvForma);

        Integer[]imvShape={
                R.drawable.equilatero,
                R.drawable.isosceles,
                R.drawable.escaleno
        };


        Double lado01 = bundle.getDouble("lado01");
        Double lado02 = bundle.getDouble("lado02");
        Double lado03 = bundle.getDouble("lado03");

        if (lado01.equals(lado02) && lado01.equals(lado03))
        {
            Resultado = "Equilatero";
            imgvFormaT.setImageResource(imvShape[0]);

        }
        else if (lado01.equals(lado02) || lado01.equals(lado03) || lado02.equals(lado03))
        {
            Resultado = "Isosceles";
            imgvFormaT.setImageResource(imvShape[1]);
        }
        else
        {
            Resultado = "Escaleno";
            imgvFormaT.setImageResource(imvShape[2]);
        }

        edtTipoTriangulo.setText(Resultado);
    }
}