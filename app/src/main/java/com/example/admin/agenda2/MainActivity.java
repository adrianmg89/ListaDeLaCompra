package com.example.admin.agenda2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vistaNuevoProducto();
                    return true;
                case R.id.navigation_dashboard:
                    vistaBusquedaProducto();
                    return true;
            }
            return false;
        }
    };

    private void vistaNuevoProducto(){
        Fragment NuevoProducto = new NuevoProducto();
        FragmentManager ncfm = getSupportFragmentManager();
        FragmentTransaction ncft = ncfm.beginTransaction();
        ncft.replace(R.id.content,NuevoProducto);
        ncft.commit();
    }

    public void vistaBusquedaProducto(){
        Fragment BusquedaProducto = new ListaCompra();
        FragmentManager bcfm = getSupportFragmentManager();
        FragmentTransaction bcft = bcfm.beginTransaction();
        bcft.replace(R.id.content,BusquedaProducto);
        bcft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vistaNuevoProducto();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
