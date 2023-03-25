package sv.edu.utec.ejercicio4guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Personas> PersonasList;
    ListView lvPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonasList = new ArrayList<Personas>();

        PersonasList.add(new Personas("Rubia Salazar", "27", "San Juan Opico la libertad"));
        PersonasList.add(new Personas("Roberto Carlos", "35", "colonia 10 de septiembre, San Salvador"));
        PersonasList.add(new Personas("Diego Alas ", "25", "Lourdes colon La libertad"));
        PersonasList.add(new Personas("Jeffry  Flores ", "23", "Santa Tecla Lalibertad"));
        PersonasList.add(new Personas("Merlin Flores ", "27", "Ciudad Merliot La Libertad"));
        PersonasList.add(new Personas("David Gomez", "30", "Colonea San Benito San Salvasdor"));
        PersonasList.add(new Personas("Alejandra Valladares", "40", "Tenesi USA"));

        PersonasAdapter adapter = new PersonasAdapter(this);
        lvPersonas = findViewById(R.id.lvPersonas);
        lvPersonas.setAdapter(adapter);

    }

    public class PersonasAdapter extends ArrayAdapter<Personas> {
        AppCompatActivity appCompatActivity;

        PersonasAdapter (AppCompatActivity context){
            super(context, R.layout.lista,PersonasList);
            appCompatActivity = context;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista, null);

            TextView tvNameProfileT = item.findViewById(R.id.txvNombre);
            tvNameProfileT.setText("Nombre: " + PersonasList.get(position).getPersonaNombre());

            TextView tvPositionT = item.findViewById(R.id.txvEdad);
            tvPositionT.setText("Edad: " + PersonasList.get(position).getPersonaEdad() + " Años" );

            TextView tvCompanyT = item.findViewById(R.id.txvDireccion);
            tvCompanyT.setText("Direccion: " + PersonasList.get(position).getPersonaDireccion());

            return(item);
        }

    }


}