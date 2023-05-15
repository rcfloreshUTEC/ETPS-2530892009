package sv.edu.utec.tareainvestigacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import sv.edu.utec.tareainvestigacion.modelo.Aplicacion;

public class MainActivity extends AppCompatActivity {

    private List<Aplicacion> listApp = new ArrayList<Aplicacion>();
    ArrayAdapter<Aplicacion> arrayAdapterAplicacion;

    EditText edtvAplicacion, edtvEmail, edtvPassword;
    ListView listVAplicaciones;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Aplicacion appSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtvAplicacion = findViewById(R.id.edtAplicacion);
        edtvEmail = findViewById(R.id.edtEmail);
        edtvPassword = findViewById(R.id.edtPassword);

        listVAplicaciones = findViewById(R.id.lvListaApp);
        startFirebase();
        listarAplicaciones();
        listVAplicaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                appSelected =  (Aplicacion) adapterView.getItemAtPosition(i);
                edtvAplicacion.setText(appSelected.getApp());
                edtvEmail.setText(appSelected.getEmail());
                edtvPassword.setText(appSelected.getPassword());
            }
        });
    }

    private void listarAplicaciones() {
        //databaseReference.child("Aplicacion").addChildEventListener(new ValueEventListener() {

        databaseReference.child("Aplicacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listApp.clear();
                for (DataSnapshot objSnaptshot : snapshot.getChildren()){
                    Aplicacion A = objSnaptshot.getValue(Aplicacion.class);
                    listApp.add(A);
                    arrayAdapterAplicacion = new ArrayAdapter<Aplicacion>(MainActivity.this,  android.R.layout.simple_list_item_1, listApp);
                    listVAplicaciones.setAdapter(arrayAdapterAplicacion);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    private void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String app = edtvAplicacion.getText().toString();
        String email = edtvEmail.getText().toString();
        String password = edtvPassword.getText().toString();

        switch (item.getItemId()){
            case R.id.itMAdd:
                if(app.equals("") || email.equals("")||password.equals(""))
                {
                    validacion();
                }
                else {
                    Aplicacion A= new Aplicacion();

                    A.setuID(UUID.randomUUID().toString());
                    A.setApp(app);
                    A.setEmail(email);
                    A.setPassword(password);

                    databaseReference.child("Aplicacion").child(A.getuID()).setValue(A);
                    Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
                    cleanBoxes();
                }

                break;
            case R.id.itMSave:
                if(app.equals("") || email.equals("")||password.equals(""))
                {
                    validacion();
                }
                else {

                    Aplicacion A = new Aplicacion();

                    A.setuID(appSelected.getuID());
                    A.setApp(edtvAplicacion.getText().toString().trim());
                    A.setEmail(edtvEmail.getText().toString().trim());
                    A.setPassword(edtvPassword.getText().toString().trim());

                    databaseReference.child("Aplicacion").child(A.getuID()).setValue(A);

                    Toast.makeText(this, "Registro Actualizado", Toast.LENGTH_SHORT).show();
                    cleanBoxes();
                }
                break;
            case R.id.itMDelete:
                if(app.equals("") || email.equals("")||password.equals(""))
                {
                    validacion();
                }
                else {
                    Aplicacion Ap = new Aplicacion();
                    Ap.setuID(appSelected.getuID());
                    databaseReference.child("Aplicacion").child(Ap.getuID()).removeValue();
                    Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();
                    cleanBoxes();
                }
                break;
            default:break;
        }
        return true;
    }

    private void cleanBoxes() {
        edtvAplicacion.setText("");
        edtvEmail.setText("");
        edtvPassword.setText("");
    }

    private void validacion() {
        String app = edtvAplicacion.getText().toString();
        String email = edtvEmail.getText().toString();
        String password = edtvPassword.getText().toString();

        if(app.equals("")){
            edtvAplicacion.setError("Required");
        }else if (email.equals("")){
            edtvEmail.setError("Required");
        } else if (password.equals("")) {
            edtvPassword.setError("Required");
        }
    }

}