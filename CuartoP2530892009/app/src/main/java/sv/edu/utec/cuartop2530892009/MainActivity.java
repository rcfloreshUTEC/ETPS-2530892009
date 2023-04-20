package sv.edu.utec.cuartop2530892009;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kotlin.contracts.Returns;
import sv.edu.utec.cuartop2530892009.Clases.AddFragment;
import sv.edu.utec.cuartop2530892009.Clases.ContactsFragment;
import sv.edu.utec.cuartop2530892009.Clases.HomeFragment;
import sv.edu.utec.cuartop2530892009.Clases.SearchFragment;
import sv.edu.utec.cuartop2530892009.Clases.SettingsFragment;


public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtTelefono, txtEmail;
    Button btnAdd, btnSearch, btnDelete, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.edtNombre);
        txtApellido = findViewById(R.id.edtApellido);
        txtTelefono = findViewById(R.id.edtPhone);
        txtEmail = findViewById(R.id.edtEmail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_config, menu);
        return true;
    }

     private BottomNavigationView.OnNavigationItemSelectedListener navaListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;

            switch (item.getItemId()) {
                case R.id.menuHome:
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menuSearch:
                    seleccionFrag = new SearchFragment();
                    break;
                case R.id.menuAdd:
                    seleccionFrag = new AddFragment();
                    break;
                case R.id.menuContact:
                    seleccionFrag = new ContactsFragment();
                    break;

                case R.id.menuSettings:
                    seleccionFrag = new SettingsFragment();
                    break;
            }
            return true;

        }

    };
}