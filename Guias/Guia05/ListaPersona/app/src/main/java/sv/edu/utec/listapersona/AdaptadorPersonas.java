package sv.edu.utec.listapersona;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdaptadorPersonas extends ArrayAdapter<String> {
    Activity contexto;
    String[]nombres;
    Integer[] ImgPpersonas;
    ImageView imgpPerso;
    TextView tvNombre;
    public AdaptadorPersonas(Activity contexto, String[]nombres,Integer[] ImgPpersonas){
        super(contexto,R.layout.persona,nombres);
        this.contexto=contexto;
        this.nombres=nombres;
        this.ImgPpersonas=ImgPpersonas;
    }
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.persona, null, true);
        tvNombre = rowView.findViewById(R.id.tvNombrePersonas);
        imgpPerso = rowView.findViewById(R.id.imvFoto);
        tvNombre.setText(nombres[position]);
        imgpPerso.setImageResource(ImgPpersonas[position]);
        return rowView;
    }
}
