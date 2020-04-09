package com.learningbaby.babylearning.menuniveles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MenuNvlActividad extends AppCompatActivity {

    private TipoMenu tipoMenu;


    public static Intent obtenerIntencion(Context contexto, TipoMenu tipoMenu) {
        Intent intencion = new Intent(contexto, MenuNvlActividad.class);
        intencion.putExtra(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        return intencion;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipoMenu = (TipoMenu) getIntent().getSerializableExtra(Constantes.EXTRA_TIPO_MENU);
        Fragment fragmento = getSupportFragmentManager().findFragmentById(R.id.contenedor);
        if (fragmento == null) {
            fragmento = MenuNvlFragmento.obtenerInstancia(tipoMenu);
            agregarFragmento(R.id.contenedor, fragmento);
        }
    }

    public void agregarFragmento(int containerViewId, Fragment fragment) {

        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();

    }
}
