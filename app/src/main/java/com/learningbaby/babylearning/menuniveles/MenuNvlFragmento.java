package com.learningbaby.babylearning.menuniveles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.niveles.niveldos.AbecedarioNivelDosActividad;
import com.learningbaby.babylearning.niveles.niveluno.AbecedarioNivelUnoActividad;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        carouselView.setPageCount(obtenerLongitudCarrusel(tipoMenu));

    }

    private int obtenerLongitudCarrusel(TipoMenu tipoMenu) {

        if (tipoMenu == TipoMenu.MENUCOLORES) {
            return obtenerImagenesCarouselColores().length;

        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            return obtenerImagenesCarouselNumeros().length;

        } else {
            return obtenerImagenesCarouselAbecedario().length;
        }
    }


    private int obtenerImagenesCarrusel(TipoMenu tipoMenu, int posicion) {

        if (tipoMenu == TipoMenu.MENUCOLORES) {
            return obtenerImagenesCarouselColores()[posicion];
        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            return obtenerImagenesCarouselNumeros()[posicion];
        } else {
            return obtenerImagenesCarouselAbecedario()[posicion];
        }

    }


    private String obteneNombresCarrusel(TipoMenu tipoMenu, int posicion) {
        if (tipoMenu == TipoMenu.MENUCOLORES) {
            return obtenerNombresCarrouselColores()[posicion];
        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            return obtenerNombresCarrouselNumeros()[posicion];
        } else {
            return obtenerNombresCarrousel()[posicion];
        }
    }


    private int[] obtenerImagenesCarouselAbecedario() {
        return new int[]{
                R.drawable.a,
                R.drawable.r,
                R.drawable.s,
                R.drawable.o,
                R.drawable.u,
                R.drawable.t,
                R.drawable.f,
                R.drawable.c};

    }

    private int[] obtenerImagenesCarouselColores() {
        return new int[]{
                R.drawable.azul,
                R.drawable.amarillo,
                R.drawable.blanco,
                R.drawable.cafe,
                R.drawable.morado,
                R.drawable.naranja,
                R.drawable.rojo,
                R.drawable.rosado};

    }

    private int[] obtenerImagenesCarouselNumeros() {
        return new int[]{
                R.drawable.cero,
                R.drawable.uno,
                R.drawable.dos,
                R.drawable.tres,
                R.drawable.cuatro,
                R.drawable.cinco,
                R.drawable.seis,
                R.drawable.siete,
                R.drawable.ocho,
                R.drawable.nueve,
                R.drawable.diez};

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


    private String[] obtenerNombresCarrouselNumeros() {
        return new String[]{
                "cero",
                "uno",
                "dos",
                "tres ",
                "cuatro",
                "cinco",
                "seis ",
                "siete",
                "ocho",
                "nueve ",
                "diez"
        };
    }
    //endregion

    //region Listeners
    ImageListener listenerImagen = (position, imageView) -> imageView.setImageResource(obtenerImagenesCarrusel(tipoMenu, position));

    ImageClickListener listenerOnclick = position ->
            Toast.makeText(getActivity(), obteneNombresCarrusel(tipoMenu, position), Toast.LENGTH_SHORT).show();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_nivel_uno:
                Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelUnoActividad.obtenerIntencion(getContext(), tipoMenu));
                break;
            case R.id.btn_nivel_dos:
                Objects.requireNonNull(getContext()).startActivity(AbecedarioNivelDosActividad.obtenerintencionNivelDosAbe(getContext(), tipoMenu));
                break;

        }
    }

    //endregion


}
