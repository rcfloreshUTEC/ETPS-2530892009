package sv.edu.utec.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import sv.edu.utec.proyectofinal.datos.baseHelper;
import sv.edu.utec.proyectofinal.datos.daoUsuarios;
import sv.edu.utec.proyectofinal.entidades.EntUsuarios;

public class MainActivity extends AppCompatActivity {

    Context context;
    EditText email, password;
    Button btnRegistro, btnLogin;

    daoUsuarios dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botones
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistro = findViewById(R.id.btnRegistro);

        // EditText
        email = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);

        dao = new daoUsuarios(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email.getText().toString();
                password.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Error: Camposs vacios", Toast.LENGTH_LONG).show();
                    validacionLogin();
                } /*else if (dao.login(email, password) == 1) {
                    Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(new Intent(getApplicationContext(), Home.class));
                    startActivity(new Intent(i2));
                } else {
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();
                }*/
                else {
                    Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(new Intent(getApplicationContext(), home.class));
                    startActivity(new Intent(i2));
                }
            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new Intent(getApplicationContext(), Registro.class));
                startActivity(new Intent(i));
            }
        });
    }

    private void validacionLogin() {
        if (email.equals("")) {
            email.setError("Campo requerido");
        } else if (password.equals("")) {
            password.setError("Campo requerido");
        }
    }
}