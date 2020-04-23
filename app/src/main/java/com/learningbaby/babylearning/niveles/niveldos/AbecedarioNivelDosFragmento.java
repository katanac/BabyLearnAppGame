package com.learningbaby.babylearning.niveles.niveldos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;
import com.learningbaby.babylearning.transversal.enumeradores.ItensColoresEnum;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;
import com.learningbaby.babylearning.transversal.enumeradores.itemsNumerosEnum;
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

    private Activity actividad;

    private DialogoFlotanteFragmento dialogoFlotante;
    private TipoMenu tipoMenu;

    static AbecedarioNivelDosFragmento obtenerInstancia(TipoMenu tipoMenu) {
        AbecedarioNivelDosFragmento fragmento = new AbecedarioNivelDosFragmento();
        Bundle argumentos = new Bundle();
        argumentos.putSerializable(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        fragmento.setArguments(argumentos);
        return fragmento;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_nivel2, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            tipoMenu = (TipoMenu) getArguments().getSerializable(Constantes.EXTRA_TIPO_MENU);
        }

        AbecedarioNivelDosAdaptador adaptador = new AbecedarioNivelDosAdaptador(actividad, this, tipoMenu);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_nivel_dos);
        recyclerView.addItemDecoration(new SpaceItemDecorationNvl2(19));
        recyclerView.setLayoutManager(new GridLayoutManager(actividad, 2));
        recyclerView.setAdapter(adaptador);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        actividad = (Activity) context;
    }


    @Override
    public void itemSelectedNumeros(int position, itemsNumerosEnum itemsNumerosEnum) {
        itemsNumerosEnum = itemsNumerosEnum.valueOf(itemsNumerosEnum.getId());
        switch (itemsNumerosEnum) {
            case Cero:
            case Uno:
            case Dos:
            case Tres:
            case Cuatro:
            case Cinco:
            case Seis:
            case Siete:
            case Ocho:
            case Nueve:
            case Diez:
                if (dialogoFlotante != null) dialogoFlotante.dismiss();
                dialogoFlotante = DialogoFlotanteFragmento.obtenerInstancia("Escribe el numero que elegiste",
                        "", DialogoFlotanteFragmento.AccionesDialogoString.EDITAR, this, itemsNumerosEnum, tipoMenu);
                dialogoFlotante.show(this.getFragmentManager(), "tag");
                break;
        }

    }

    @Override
    public void itemSelectedColores(int position, ItensColoresEnum itensColoresEnum) {
        itensColoresEnum = ItensColoresEnum.valueOf(itensColoresEnum.getId());
        switch (itensColoresEnum) {
            case Azul:
            case Cafe:
            case Rojo:
            case Negro:
            case Verde:
            case Blanco:
            case Morado:
            case Rosado:
            case Naranja:
            case Amarrillo:

                if (dialogoFlotante != null) dialogoFlotante.dismiss();
                dialogoFlotante = DialogoFlotanteFragmento.obtenerInstancia("Escribe El que seleccionaste",
                        "", DialogoFlotanteFragmento.AccionesDialogoString.EDITAR, this, itensColoresEnum, tipoMenu);
                dialogoFlotante.show(this.getFragmentManager(), "tag");
                break;
        }
    }

    //region CallBacks
    @Override
    public void itemSelectedAbecedario(int position, ItemsAbecedarioEnum abecedarioEnum) {
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
                        "", DialogoFlotanteFragmento.AccionesDialogoString.EDITAR, this, abecedarioEnum, tipoMenu);
                dialogoFlotante.show(this.getFragmentManager(), "tag");
                break;

        }

    }


    @Override
    public void opcionAceptarNumeros(String texto, int itemSelecionado, itemsNumerosEnum numerosEnum, TipoMenu tipoMenu) {
            dialogoFlotante.dismiss();

            if (numerosEnum.getNombreBandeja().toUpperCase().equals(texto.toUpperCase())) {
                alertDialogoCorrecto(tipoMenu);
            } else {
                alertDialogoIncorrecto();

            }
    }

    @Override
    public void opcionAceptarColores(String texto, int itemSelecionado, ItensColoresEnum coloresEnum, TipoMenu tipoMenu) {
            dialogoFlotante.dismiss();
            if (coloresEnum.getNombreBandeja().toUpperCase().equals(texto.toUpperCase())) {
                alertDialogoCorrecto(tipoMenu);
            } else {
                alertDialogoIncorrecto();

            }
    }

    @Override
    public void opcionAceptarAbecedario(String texto, int itemSelecionado, ItemsAbecedarioEnum
            abecedarioEnum, TipoMenu tipoMenu) {
        dialogoFlotante.dismiss();

        if (abecedarioEnum.getNombreBandeja().toUpperCase().equals(texto.toUpperCase())) {
            alertDialogoCorrecto(tipoMenu);
        } else {
            alertDialogoIncorrecto();

        }
    }


    private void alertDialogoCorrecto(TipoMenu tipoMenu) {

        AlertDialog.Builder alertadd = new AlertDialog.Builder(actividad);
        LayoutInflater factory = LayoutInflater.from(actividad);
        final View view = factory.inflate(R.layout.fragmento_correcto, null);
        alertadd.setView(view);

        alertadd.setNeutralButton("¿De nuevo?", (dlg, sumthin) -> {
            actividad.finish();
            Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelDosActividad.obtenerintencionNivelDosAbe(getContext(), tipoMenu));
        });

        alertadd.setNegativeButton("Salir", (dlg, sumthin) -> actividad.finish());

        alertadd.show();
    }


    private void alertDialogoIncorrecto() {

        AlertDialog.Builder alertadd = new AlertDialog.Builder(actividad);
        LayoutInflater factory = LayoutInflater.from(actividad);
        final View view = factory.inflate(R.layout.fragmento_incorrecto, null);
        alertadd.setView(view);
        alertadd.setNeutralButton("Intentar", (dlg, sumthin) -> {

        });
        alertadd.setNegativeButton("Salir", (dlg, sumthin) -> actividad.finish());

        alertadd.show();
    }
    //endregion
}
