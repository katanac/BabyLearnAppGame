package com.learningbaby.babylearning.menuniveles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.abecedario.niveldos.AbecedarioNivelDosActividad;
import com.learningbaby.babylearning.abecedario.niveldos.AbecedarioNivelDosFragmento;
import com.learningbaby.babylearning.abecedario.niveluno.AbecedarioNivelUnoActividad;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.OnClick;

public class MenuNvlFragmento extends Fragment implements View.OnClickListener {

    //region Atributos
    private CarouselView carouselView;
    private Button btnnvl1;
    private Button btnnvl2;
    private TipoMenu tipoMenu;
    //endregion

    //region Instancia
    static MenuNvlFragmento obtenerInstancia(TipoMenu tipoMenu) {
        MenuNvlFragmento menuNvlFragmento = new MenuNvlFragmento();
        Bundle argumentosBundle = new Bundle();
        argumentosBundle.putSerializable(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        menuNvlFragmento.setArguments(argumentosBundle);
        return menuNvlFragmento;
    }
    //endregion

    //region Sobrecarga
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_niveles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.getArguments() != null) {
            tipoMenu = (TipoMenu) this.getArguments().getSerializable(Constantes.EXTRA_TIPO_MENU);
        }

        carouselView = (view.findViewById(R.id.carousel_juego));
        btnnvl1 = (view.findViewById(R.id.btn_nivel_uno));
        btnnvl2 = (view.findViewById(R.id.btn_nivel_dos));
        llenadoCarouselView(carouselView);
        btnnvl1.setOnClickListener(this);
        btnnvl2.setOnClickListener(this);
    }
    //endregion

    //region Propios
    private void llenadoCarouselView(CarouselView carouselView) {

        carouselView.setImageListener(listenerImagen);
        carouselView.setImageClickListener(listenerOnclick);
        carouselView.setPageCount(tipoMenu == TipoMenu.MENUCOLORES ? obtenerImagenesCarouselColores().length : obtenerImagenesCarouselAbecedario().length);

    }

    private int[] obtenerImagenesCarouselAbecedario() {
        return new int[]{
                R.drawable.mostruo1,
                R.drawable.mostruo2,
                R.drawable.mostruo3,
                R.drawable.mostruo4,
                R.drawable.mostruo5,
                R.drawable.mostruo6,
                R.drawable.mostruo7,
                R.drawable.mostruo8};

    }

    private int[] obtenerImagenesCarouselColores() {
        return new int[]{
                R.drawable.azul,
                R.drawable.amarrillo,
                R.drawable.blanco,
                R.drawable.cafe,
                R.drawable.morado,
                R.drawable.naranja,
                R.drawable.rojo,
                R.drawable.rosado};

    }

    private String[] obtenerNombresCarrousel() {
        return new String[]{
                "mostruo1",
                "mostruo2",
                "mostruo3",
                "mostruo4 ",
                "mostruo5",
                "mostruo6",
                "mostruo7 ",
                "mostruo8"
        };
    }

    private String[] obtenerNombresCarrouselColores() {
        return new String[]{
                "azul",
                "amarillo",
                "blanco",
                "cafe ",
                "morado",
                "naranja",
                "rojo ",
                "rosado"
        };
    }
    //endregion

    //region Listeners
    ImageListener listenerImagen = (position, imageView) -> imageView.setImageResource(tipoMenu == TipoMenu.MENUCOLORES ? obtenerImagenesCarouselColores()[position]
            : obtenerImagenesCarouselAbecedario()[position]);

    ImageClickListener listenerOnclick = position ->
            Toast.makeText(getActivity(), tipoMenu == TipoMenu.MENUCOLORES ? obtenerNombresCarrouselColores()[position]
                    : obtenerNombresCarrousel()[position], Toast.LENGTH_SHORT).show();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_nivel_uno:
                Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelUnoActividad.obtenerIntencion(getContext()));
                break;
            case R.id.btn_nivel_dos:
                Toast.makeText(getContext(), "estoy presionando el boton del nivel dos", Toast.LENGTH_LONG).show();
                Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelDosActividad.obtenerintencionNivelDosAbe(getContext()));
                break;

        }
    }

    //endregion


}
