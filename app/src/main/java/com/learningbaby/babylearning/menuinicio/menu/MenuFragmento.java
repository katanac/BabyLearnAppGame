package com.learningbaby.babylearning.menuinicio.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.menuinicio.navegador.NavegadorMenu;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsMenuEnum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenuFragmento extends Fragment implements MenuPrincipalAdaptador.ListadoMenuCallback {

    private MenuPrincipalAdaptador adaptador;
    private Activity actividad;

    RecyclerView recyclerView;

    public static MenuFragmento obtenerInstancia() {
        return new MenuFragmento();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_menu_principal, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adaptador = new MenuPrincipalAdaptador(actividad, this);
        recyclerView = view.findViewById(R.id.recycler_menu);
        recyclerView.addItemDecoration(new SpaceItemDecoration(16));
        recyclerView.setLayoutManager(new GridLayoutManager(actividad, 2));
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        actividad = (Activity) context;
    }

    @Override
    public void itemSelected(int position) {
        ItemsMenuEnum itemsMenu = ItemsMenuEnum.valueOf(position);
        switch (itemsMenu) {
            case COLORES:
                new NavegadorMenu().navegarMenuNivelesColores(actividad);
                break;
            case NUMEROS:
                new NavegadorMenu().navegarMenuNivelesNumeros(actividad);
                break;
            case ABECEDARIO:
                new NavegadorMenu().navegarMenuNivelesAbecedario(actividad);
                break;
        }
    }
}
