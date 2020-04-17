package com.learningbaby.babylearning.abecedario.niveldos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AbecedarioNivelDosFragmento extends Fragment implements AbecedarioNivelDosAdaptador.ListadoNivelCallback {

    private AbecedarioNivelDosAdaptador adaptador;
    private Activity actividad;

    RecyclerView recyclerView;

    public static AbecedarioNivelDosFragmento obtenerInstancia() {
        return new AbecedarioNivelDosFragmento();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_nivel2, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adaptador = new AbecedarioNivelDosAdaptador(actividad, this);
        recyclerView = view.findViewById(R.id.recycler_nivel_dos);
        recyclerView.addItemDecoration(new SpaceItemDecorationNvl2(19));
        recyclerView.setLayoutManager(new GridLayoutManager(actividad, 2));
        recyclerView.setAdapter(adaptador);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        actividad = (Activity) context;
    }


    @Override
    public void itemSelected(int position, int id) {
        ItemsAbecedarioEnum abecedarioEnum = ItemsAbecedarioEnum.valueOf(id);
        switch (abecedarioEnum) {
            case A:
                Toast.makeText(actividad, "letra A", Toast.LENGTH_SHORT).show();
                break;
            case B:
                Toast.makeText(actividad, "letra B", Toast.LENGTH_SHORT).show();
                break;
            case C:
                Toast.makeText(actividad, "letra C", Toast.LENGTH_SHORT).show();
                break;
            case D:
                Toast.makeText(actividad, "letra D", Toast.LENGTH_SHORT).show();
                break;
            case E:
                Toast.makeText(actividad, "letra Ed", Toast.LENGTH_SHORT).show();
                break;
            case F:
                Toast.makeText(actividad, "letra F", Toast.LENGTH_SHORT).show();
                break;
            case G:
                Toast.makeText(actividad, "letra G", Toast.LENGTH_SHORT).show();
                break;
            case H:
                Toast.makeText(actividad, "letra H", Toast.LENGTH_SHORT).show();
                break;
            case I:
                Toast.makeText(actividad, "letra I", Toast.LENGTH_SHORT).show();
                break;
            case J:
                Toast.makeText(actividad, "letra J", Toast.LENGTH_SHORT).show();
                break;
            case K:
                Toast.makeText(actividad, "letra K", Toast.LENGTH_SHORT).show();
                break;
            case L:
                Toast.makeText(actividad, "letra L", Toast.LENGTH_SHORT).show();
                break;
            case M:
                Toast.makeText(actividad, "letra M", Toast.LENGTH_SHORT).show();
                break;
            case N:
                Toast.makeText(actividad, "letra N", Toast.LENGTH_SHORT).show();
                break;
            case O:
                Toast.makeText(actividad, "letra O", Toast.LENGTH_SHORT).show();
                break;
            case P:
                Toast.makeText(actividad, "letra P", Toast.LENGTH_SHORT).show();
                break;
            case Q:
                Toast.makeText(actividad, "letra Q", Toast.LENGTH_SHORT).show();
                break;
            case r:
                Toast.makeText(actividad, "letra R", Toast.LENGTH_SHORT).show();
                break;
            case S:
                Toast.makeText(actividad, "letra S", Toast.LENGTH_SHORT).show();
                break;
            case T:
                Toast.makeText(actividad, "letra T", Toast.LENGTH_SHORT).show();
                break;
            case U:
                Toast.makeText(actividad, "letra U", Toast.LENGTH_SHORT).show();
                break;
            case V:
                Toast.makeText(actividad, "letra V", Toast.LENGTH_SHORT).show();
                break;
            case W:
                Toast.makeText(actividad, "letra W", Toast.LENGTH_SHORT).show();
                break;
            case X:
                Toast.makeText(actividad, "letra X", Toast.LENGTH_SHORT).show();
                break;
            case Y:
                Toast.makeText(actividad, "letra Y", Toast.LENGTH_SHORT).show();
                break;
            case Z:
                Toast.makeText(actividad, "letra Z", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
