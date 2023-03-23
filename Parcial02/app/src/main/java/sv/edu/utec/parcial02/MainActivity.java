package sv.edu.utec.parcial02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Employees> EmployeeList;

    ListView lvProfile;

    Integer[]imvProfile={
            R.drawable.lead_photo_1,
            R.drawable.lead_photo_2,
            R.drawable.lead_photo_3,
            R.drawable.lead_photo_4,
            R.drawable.lead_photo_5,
            R.drawable.lead_photo_6,
            R.drawable.lead_photo_7,
            R.drawable.lead_photo_8,
            R.drawable.lead_photo_9,
            R.drawable.lead_photo_10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeList = new ArrayList<Employees>();

        EmployeeList.add(new Employees("Alexander Pierrot", "CEO", "Insures S.O"));
        EmployeeList.add(new Employees("Carlos Lopez", "Asistente", "Hospital Blue"));
        EmployeeList.add(new Employees("Sara Bonz", "Directora de Marketing", "Electrical Parts LTD"));
        EmployeeList.add(new Employees("Liliana Clarence", "Diseñadora de Producto", "Creativa App"));
        EmployeeList.add(new Employees("Benito Peralta", "Supervisor de Ventas", "Neumaticos Press"));
        EmployeeList.add(new Employees("Juan Jaramillo", "CEO", "Banco Nacional"));
        EmployeeList.add(new Employees("Christian Steps", "CTO", "Cooperativa Verde"));
        EmployeeList.add(new Employees("Alexa Giraldo", "Lead Programmer", "Frutisofy"));
        EmployeeList.add(new Employees("Linda Murillo", "Directora de Marketing", "Seguros Boliver"));
        EmployeeList.add(new Employees("Lizete Astrada", "CEO", "Concesionario Motolox"));

        EmployeesAdapter adapter = new EmployeesAdapter(this);
        lvProfile = findViewById(R.id.lvEmployees);
        lvProfile.setAdapter(adapter);

        lvProfile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(adapterView.getContext(), "Seleccionar "+adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();


                }

            }
        );
    }


    public class EmployeesAdapter extends ArrayAdapter<Employees> {

        AppCompatActivity appCompatActivity;

        EmployeesAdapter (AppCompatActivity context){
            super(context, R.layout.employees_list, EmployeeList);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.employees_list, null);

            ImageView imvProfileT = item.findViewById(R.id.imvProfile);
            imvProfileT.setImageResource(imvProfile[position]);

            TextView tvNameProfileT = item.findViewById(R.id.tvNameProfile);
            tvNameProfileT.setText(EmployeeList.get(position).getEmployeeName());

            TextView tvPositionT = item.findViewById(R.id.tvPosition);
            tvPositionT.setText(EmployeeList.get(position).getEmployeePosition());

            TextView tvCompanyT = item.findViewById(R.id.tvCompany);
            tvCompanyT.setText(EmployeeList.get(position).getEmployeeCompany());

            return(item);
        }

    }

}

