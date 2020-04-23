package com.learningbaby.babylearning.transversal.utilidades;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;
import com.learningbaby.babylearning.transversal.enumeradores.ItensColoresEnum;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;
import com.learningbaby.babylearning.transversal.enumeradores.itemsNumerosEnum;

import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoFlotanteFragmento extends DialogFragment {

    //region Atributos
    public enum AccionesDialogoString implements Serializable {EDITAR, CONSULTAR}

    private TipoMenu tipoMenu;

    private DialogoStringCallBack listener;
    private EditText edtString;
    private ItemsAbecedarioEnum abecedarioEnum;
    private itemsNumerosEnum itemsNumerosEnum;
    private ItensColoresEnum coloresEnum;
    //endregion

    //region Instancia
    public DialogoFlotanteFragmento() {
        super();
    }

    public static DialogoFlotanteFragmento obtenerInstancia(@NonNull String titulo
            , @NonNull String textoModificar
            , @NonNull AccionesDialogoString acciondialogo
            , @NonNull DialogoStringCallBack listener
            , ItemsAbecedarioEnum abecedarioEnum,
                                                            TipoMenu tipoMenu) {
        DialogoFlotanteFragmento dialogo = new DialogoFlotanteFragmento();
        Bundle args = new Bundle();
        args.putString(Constantes.EXTRA_DIALOGO_TITULO, titulo);
        args.putString(Constantes.EXTRA_DIALOGO_TEXTO_MODIFICAR, textoModificar);
        args.putSerializable(Constantes.EXTRA_DIALOGO_LISTENER, listener);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ACCION, acciondialogo);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ENUM, abecedarioEnum);
        args.putSerializable(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        dialogo.setArguments(args);
        return dialogo;
    }

    public static DialogoFlotanteFragmento obtenerInstancia(@NonNull String titulo
            , @NonNull String textoModificar
            , @NonNull AccionesDialogoString acciondialogo
            , @NonNull DialogoStringCallBack listener
            , itemsNumerosEnum numerosEnum,
                                                            TipoMenu tipoMenu) {
        DialogoFlotanteFragmento dialogo = new DialogoFlotanteFragmento();
        Bundle args = new Bundle();
        args.putString(Constantes.EXTRA_DIALOGO_TITULO, titulo);
        args.putString(Constantes.EXTRA_DIALOGO_TEXTO_MODIFICAR, textoModificar);
        args.putSerializable(Constantes.EXTRA_DIALOGO_LISTENER, listener);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ACCION, acciondialogo);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ENUM, numerosEnum);
        args.putSerializable(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        dialogo.setArguments(args);
        return dialogo;
    }

    public static DialogoFlotanteFragmento obtenerInstancia(@NonNull String titulo
            , @NonNull String textoModificar
            , @NonNull AccionesDialogoString acciondialogo
            , @NonNull DialogoStringCallBack listener
            , ItensColoresEnum numerosEnum,
                                                            TipoMenu tipoMenu) {
        DialogoFlotanteFragmento dialogo = new DialogoFlotanteFragmento();
        Bundle args = new Bundle();
        args.putString(Constantes.EXTRA_DIALOGO_TITULO, titulo);
        args.putString(Constantes.EXTRA_DIALOGO_TEXTO_MODIFICAR, textoModificar);
        args.putSerializable(Constantes.EXTRA_DIALOGO_LISTENER, listener);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ACCION, acciondialogo);
        args.putSerializable(Constantes.EXTRA_DIALOGO_ENUM, numerosEnum);
        args.putSerializable(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        dialogo.setArguments(args);
        return dialogo;
    }
    //endregion

    //region Sobrecargas

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);
        return inflater.inflate(R.layout.fragmento_dialogo_flotante, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitulo = view.findViewById(R.id.toolbar_dialogo);
        edtString = view.findViewById(R.id.edt_dialogo_captura_texto);
        ImageButton botonAceptar = view.findViewById(R.id.btn_aceptar_dialogo);

        listener = (DialogoStringCallBack) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_LISTENER);
        AccionesDialogoString accion = (AccionesDialogoString) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_ACCION);

        tipoMenu = (TipoMenu) getArguments().getSerializable(Constantes.EXTRA_TIPO_MENU);

        if (tipoMenu == TipoMenu.MENUCOLORES) {
            coloresEnum = (ItensColoresEnum) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_ENUM);
        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            itemsNumerosEnum = (itemsNumerosEnum) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_ENUM);
        } else {
            abecedarioEnum = (ItemsAbecedarioEnum) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_ENUM);
        }

        tvTitulo.setText(getArguments().getString(Constantes.EXTRA_DIALOGO_TITULO));


        switch (accion) {
            case CONSULTAR:
                edtString.setText(Objects.requireNonNull(getArguments()).getString(Constantes.EXTRA_DIALOGO_TEXTO_MODIFICAR));
                edtString.setEnabled(false);
                botonAceptar.setVisibility(View.GONE);
                break;
            case EDITAR:
                if (tipoMenu == TipoMenu.MENUNUMEROS) {
                    InputFilter[] fArray = new InputFilter[1];
                    fArray[0] = new InputFilter.LengthFilter(2);
                    edtString.setFilters(fArray);
                    edtString.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                    edtString.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
                edtString.setEnabled(true);
                botonAceptar.setVisibility(View.VISIBLE);

                if (tipoMenu == TipoMenu.MENUCOLORES) {
                    botonAceptar.setOnClickListener(v -> listener.opcionAceptarColores(edtString.getText().toString(), getArguments().getInt(Constantes.EXTRA_DIALOGO_ITEM_SELECCIONADO), coloresEnum, tipoMenu));
                } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
                    botonAceptar.setOnClickListener(v -> listener.opcionAceptarNumeros(edtString.getText().toString(), getArguments().getInt(Constantes.EXTRA_DIALOGO_ITEM_SELECCIONADO), itemsNumerosEnum, tipoMenu));
                } else {
                    botonAceptar.setOnClickListener(v -> listener.opcionAceptarAbecedario(edtString.getText().toString(), getArguments().getInt(Constantes.EXTRA_DIALOGO_ITEM_SELECCIONADO), abecedarioEnum, tipoMenu));
                }

                break;
        }

        Objects.requireNonNull(getDialog().getWindow()).setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onPause() {
        dismiss();
        super.onPause();
    }

    //endregion

    //region Callback
    public interface DialogoStringCallBack extends Serializable {

        void opcionAceptarNumeros(String texto, int itemSelecionado, itemsNumerosEnum numerosEnum, TipoMenu tipoMenu);

        void opcionAceptarColores(String texto, int itemSelecionado, ItensColoresEnum coloresEnum, TipoMenu tipoMenu);

        void opcionAceptarAbecedario(String texto, int itemSelecionado, ItemsAbecedarioEnum abecedarioEnum, TipoMenu tipoMenu);

    }
//endregion

}


