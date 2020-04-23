package com.learningbaby.babylearning.transversal.utilidades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;

import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

public class DialogoFlotanteFragmento extends DialogFragment {

    //region Atributos
    public enum AccionesDialogoString implements Serializable {EDITAR, CONSULTAR}
    private TipoMenu tipoMenu;

    private DialogoStringCallBack listener;
    private EditText edtString;
    private ItemsAbecedarioEnum abecedarioEnum;
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
        abecedarioEnum = (ItemsAbecedarioEnum) Objects.requireNonNull(getArguments()).getSerializable(Constantes.EXTRA_DIALOGO_ENUM);
        tipoMenu = (TipoMenu) getArguments().getSerializable(Constantes.EXTRA_TIPO_MENU);

        tvTitulo.setText(getArguments().getString(Constantes.EXTRA_DIALOGO_TITULO));


        switch (accion) {
            case CONSULTAR:
                edtString.setText(Objects.requireNonNull(getArguments()).getString(Constantes.EXTRA_DIALOGO_TEXTO_MODIFICAR));
                edtString.setEnabled(false);
                botonAceptar.setVisibility(View.GONE);
                break;
            case EDITAR:
                edtString.setEnabled(true);
                botonAceptar.setVisibility(View.VISIBLE);
                botonAceptar.setOnClickListener(v -> listener.opcionAceptar(edtString.getText().toString(), getArguments().getInt(Constantes.EXTRA_DIALOGO_ITEM_SELECCIONADO), abecedarioEnum,tipoMenu));
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

        void opcionAceptar(String texto, int itemSelecionado, ItemsAbecedarioEnum abecedarioEnum, TipoMenu tipoMenu);

    }
//endregion

}


