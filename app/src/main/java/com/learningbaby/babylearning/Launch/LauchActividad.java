package com.learningbaby.babylearning.Launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.menuinicio.menu.MenuInicioActividad;

import androidx.annotation.Nullable;

public class LauchActividad extends Activity {

    //region Atributos
    private int tiempo = 1;
    int recurso;
    ImageView imageLauncher;
    boolean nuevaScreean;
    //endregion

    public LauchActividad() {
    }


    public LauchActividad(int recurso, boolean nuevaScreean) {
        this.recurso = recurso;
        this.nuevaScreean = nuevaScreean;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmento_launcher);
        imageLauncher = findViewById(R.id.imagenLaunch);
        if (nuevaScreean){
            imageLauncher.setImageResource(recurso);
        }
        iniciarLaunch();
    }

    public void iniciarLaunch() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(new Intent(getBaseContext(), MenuInicioActividad.class)));
            finish();
        }, tiempo * 4000);
    }
}
