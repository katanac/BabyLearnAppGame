package com.learningbaby.babylearning.menuinicio.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.learningbaby.babylearning.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MenuInicioActividad extends AppCompatActivity {

    public static Intent obtenerIntencion(Context contexto) {
        return new Intent(contexto, MenuInicioActividad.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragmento = getSupportFragmentManager().findFragmentById(R.id.contenedor);
        if (fragmento == null) {
            fragmento= MenuFragmento.obtenerInstancia();
            agregarFragmento(R.id.contenedor, fragmento);
        }
    }

    public void agregarFragmento(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

}
