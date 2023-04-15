package sv.edu.utec.listapersona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] nombres={"ana", "carlos", "fernanda", "gustavo", "jose",
            "juan", "karla", "maria", "marta", "pedro", "silvi"};
    ListView lv1;
    Integer[]ImgPpersonas={
            R.drawable.ana,
            R.drawable.carlos,
            R.drawable.fernanda,
            R.drawable.gustavo,
            R.drawable.jose,
            R.drawable.juan,
            R.drawable.karla,
            R.drawable.luis,
            R.drawable.maria,
            R.drawable.marta,
            R.drawable.pedro,
            R.drawable.silvia
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorPersonas adaptador = new AdaptadorPersonas(this,nombres, ImgPpersonas);
        lv1 = findViewById(R.id.lsvPersonas);
        lv1.setAdapter(adaptador);
    }

}