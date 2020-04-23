package com.learningbaby.babylearning.abecedario.niveldos;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.Launch.LauchActividad;
import com.learningbaby.babylearning.menuinicio.menu.MenuInicioActividad;
import com.learningbaby.babylearning.menuniveles.MenuNvlActividad;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;
import com.learningbaby.babylearning.transversal.utilidades.DialogoFlotanteFragmento;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AbecedarioNivelDosFragmento extends Fragment implements AbecedarioNivelDosAdaptador.ListadoNivelCallback,
        DialogoFlotanteFragmento.DialogoStringCallBack {

    private AbecedarioNivelDosAdaptador adaptador;
    private Activity actividad;

    private RecyclerView recyclerView;
    private DialogoFlotanteFragmento dialogoFlotante;

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
    public void itemSelected(int position, ItemsAbecedarioEnum abecedarioEnum) {
        abecedarioEnum = ItemsAbecedarioEnum.valueOf(abecedarioEnum.id);
        switch (abecedarioEnum) {
            case A:
            case B:
            case C:
            case D:
            case E:
            case F:
            case G:
            case H:
            case I:
            case J:
            case K:
            case L:
            case M:
            case N:
            case O:
            case P:
            case Q:
            case r:
            case S:
            case T:
            case U:
            case V:
            case W:
            case X:
            case Y:
            case Z:
                if (dialogoFlotante != null) dialogoFlotante.dismiss();
                dialogoFlotante = DialogoFlotanteFragmento.obtenerInstancia("Escribe la letra que seleccionaste",
                        "", DialogoFlotanteFragmento.AccionesDialogoString.EDITAR, this, abecedarioEnum);
                dialogoFlotante.show(this.getParentFragmentManager(), "tag");
                break;

        }

    }


    @Override
    public void opcionAceptar(String texto, int itemSelecionado, ItemsAbecedarioEnum abecedarioEnum) {
        dialogoFlotante.dismiss();

        if (abecedarioEnum.getNombreBandeja().equals(texto.toUpperCase())) {
            Toast.makeText(actividad, "es correcto", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder alertadd = new AlertDialog.Builder(actividad);
            LayoutInflater factory = LayoutInflater.from(actividad);
            final View view = factory.inflate(R.layout.fragmento_correcto, null);
            alertadd.setView(view);

            alertadd.setNeutralButton("¿De nuevo?", (dlg, sumthin) -> {
                actividad.finish();
                Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelDosActividad.obtenerintencionNivelDosAbe(getContext()));
            });

            alertadd.setNegativeButton("Salir", (dlg, sumthin) -> {
                Objects.requireNonNull(getContext()).startActivity(MenuNvlActividad.obtenerIntencion(actividad, TipoMenu.MENUALFABETO));
            });

            alertadd.show();
        } else {
            Toast.makeText(actividad, "incorrecto", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder alertadd = new AlertDialog.Builder(actividad);
            LayoutInflater factory = LayoutInflater.from(actividad);
            final View view = factory.inflate(R.layout.fragmento_incorrecto, null);
            alertadd.setView(view);
            alertadd.setNeutralButton("Intentar", (dlg, sumthin) -> {

            });
            alertadd.setNegativeButton("Salir", (dlg, sumthin) -> {
                actividad.finish();
                Objects.requireNonNull(getContext()).startActivity(MenuNvlActividad.obtenerIntencion(actividad, TipoMenu.MENUALFABETO));
            });

            alertadd.show();
        }
    }
}
