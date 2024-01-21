package com.vedruna.leonmunoze01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LoginActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText contrasena;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.Nombre);
        contrasena = findViewById(R.id.Contrasena);
        mensaje = findViewById(R.id.mensajeFinal);
    }

    public void loguear(View view) {
        if (!nombre.getText().toString().equals("admin") || !contrasena.getText().toString().equals("admin")) {
            mensaje.setText("Usuario o contraseña incorrecta");
        } else {
            mensaje.setText("Usuario y contraseña correcta");

            Intent intent = new Intent(this, MenuActivity.class);
          intent.putExtra("valor", nombre.getText().toString());
            startActivity(intent);

        }
    }
}

