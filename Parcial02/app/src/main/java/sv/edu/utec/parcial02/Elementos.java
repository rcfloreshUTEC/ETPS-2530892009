package sv.edu.utec.parcial02;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder {
    static ImageView imgProfile;
    static TextView tvNProfile, tvNPosition, tvNCompany;


    public Elementos (@NonNull View itemView){
        super(itemView);

        imgProfile=itemView.findViewById(R.id.imvProfile);
        tvNProfile = itemView.findViewById(R.id.tvNameProfile);
        tvNPosition = itemView.findViewById(R.id.tvPosition);
        tvNCompany = itemView.findViewById(R.id.tvCompany);


    }
}
