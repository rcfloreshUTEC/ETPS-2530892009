package sv.edu.utec.parcial02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Elementos> {

    Context context;
    ArrayList<Employees> employees;

    public Adaptador(Context context, ArrayList<Employees> employees) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public Elementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.activity_main,null);
        return new Elementos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Elementos holder, int position) {
        //Elementos.imgProfile.setImageResource(employees.get(position).get());
        Elementos.tvNProfile.setText(employees.get(position).getEmployeeName());
        Elementos.tvNPosition.setText(employees.get(position).getEmployeePosition());
        Elementos.tvNCompany.setText(employees.get(position).getEmployeeCompany());

    }

    @Override
    public int getItemCount() {

        return employees.size();
    }
}
