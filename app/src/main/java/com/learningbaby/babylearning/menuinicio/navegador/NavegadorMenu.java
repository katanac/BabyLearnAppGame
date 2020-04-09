package com.learningbaby.babylearning.menuinicio.navegador;

import android.content.Context;

import com.learningbaby.babylearning.menuniveles.MenuNvlActividad;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;

public class NavegadorMenu implements NavegacionMenu{
    @Override
    public void navegarMenuNivelesColores(Context contexto) {
        contexto.startActivity(MenuNvlActividad.obtenerIntencion(contexto, TipoMenu.MENUCOLORES));
    }

    @Override
    public void navegarMenuNivelesNumeros(Context contexto) {
        contexto.startActivity(MenuNvlActividad.obtenerIntencion(contexto, TipoMenu.MENUNUMEROS));
    }

    @Override
    public void navegarMenuNivelesAbecedario(Context contexto) {
        contexto.startActivity(MenuNvlActividad.obtenerIntencion(contexto, TipoMenu.MENUALFABETO));
    }
}
