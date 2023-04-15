package sv.edu.utec.listadofruta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Frutas> listafrutas;
    ListView lv1;
    Integer[]ImgFrutas={
            R.drawable.banana,
            R.drawable.carambola,
            R.drawable.cereza,
            R.drawable.ciruela,
            R.drawable.coco,
            R.drawable.fresa,
            R.drawable.granadilla,
            R.drawable.guayaba,
            R.drawable.higo,
            R.drawable.kiwi,
            R.drawable.limon,
            R.drawable.mandarina,
            R.drawable.mango,
            R.drawable.manzana,
            R.drawable.melon,
            R.drawable.mora,
            R.drawable.naranja,
            R.drawable.nuez,
            R.drawable.papaya,
            R.drawable.pera,
            R.drawable.pina,
            R.drawable.sandia,
            R.drawable.tamarindo,
            R.drawable.uva,
            R.drawable.zapote
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listafrutas=new ArrayList<Frutas>();

        listafrutas.add(new Frutas("banana"));
        listafrutas.add(new Frutas("carambola"));
        listafrutas.add(new Frutas("cereza"));
        listafrutas.add(new Frutas("ciruela"));
        listafrutas.add(new Frutas("coco"));
        listafrutas.add(new Frutas("fresa"));
        listafrutas.add(new Frutas("granadilla"));
        listafrutas.add(new Frutas("guayaba"));
        listafrutas.add(new Frutas("higo"));
        listafrutas.add(new Frutas("kiwi"));
        listafrutas.add(new Frutas("limon"));
        listafrutas.add(new Frutas("mandarina"));
        listafrutas.add(new Frutas("mango"));
        listafrutas.add(new Frutas("manzana"));
        listafrutas.add(new Frutas("melon"));
        listafrutas.add(new Frutas("mora"));
        listafrutas.add(new Frutas("naranja"));
        listafrutas.add(new Frutas("nuez"));
        listafrutas.add(new Frutas("papaya"));
        listafrutas.add(new Frutas("pera"));
        listafrutas.add(new Frutas("pina"));
        listafrutas.add(new Frutas("sandia"));
        listafrutas.add(new Frutas("tamarindo"));
        listafrutas.add(new Frutas("uva"));
        listafrutas.add(new Frutas("zapote"));

        AdaptadorFrutas adaptador = new AdaptadorFrutas(this);
        lv1=findViewById(R.id.lsvFrutas);
        lv1.setAdapter(adaptador);
    }
    class AdaptadorFrutas extends ArrayAdapter<Frutas>{

        AppCompatActivity appCompatActivity;
        AdaptadorFrutas(AppCompatActivity context){
            super(context, R.layout.frutas, listafrutas);
            appCompatActivity = context;

        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.frutas, null);

            TextView textView1 = item.findViewById(R.id.tvFruta);
            textView1.setText(listafrutas.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imvFoto);
            imageView1.setImageResource(ImgFrutas[position]);
            return(item);
        }
    }
}