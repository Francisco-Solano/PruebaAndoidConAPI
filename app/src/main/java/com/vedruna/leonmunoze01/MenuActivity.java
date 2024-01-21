package com.vedruna.leonmunoze01;

import android.os.Bundle;
import android.view.MenuItem;  // Asegúrate de importar la clase MenuItem correcta
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vedruna.leonmunoze01.R;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Establecer la ActionBar
        setSupportActionBar(findViewById(R.id.toolbar));  // Reemplaza "R.id.toolbar" con el ID correcto de tu Toolbar

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);

        // Configura la AppBarConfiguration con los fragmentos de nivel superior
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_contador,
                R.id.navigation_exit,
                R.id.navigation_api
        ).build();

        // Configura la barra de acción con el controlador de navegación
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Configura la navegación con el controlador y la barra de acción
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        // Manejar la selección del elemento del menú en el BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.homeFragment);
                return true;
            } else if (item.getItemId() == R.id.navigation_exit) {
                navController.navigate(R.id.exitFragment);
                return true;
            } else if (item.getItemId() == R.id.navigation_contador) {
                navController.navigate(R.id.contadorFragment);
                return true;
            } else if (item.getItemId() == R.id.navigation_api) {
                navController.navigate(R.id.apiFragment);
                return true;
            } else {
                return false;
            }
        });

// También puedes agregar esto para manejar la selección inicial (startDestination) al iniciar la actividad
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);



    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
