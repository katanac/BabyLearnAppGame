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
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.k,
                R.drawable.l,
                R.drawable.n,
                R.drawable.m,
                R.drawable.o,
                R.drawable.p,
                R.drawable.q,
                R.drawable.r,
                R.drawable.s,
                R.drawable.t,
                R.drawable.u,
                R.drawable.v,
                R.drawable.w,
                R.drawable.x,
                R.drawable.y,
                R.drawable.z};

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
                " Esta es la letra A",
                " Esta es la letra B",
                " Esta es la letra C",
                " Esta es la letra D",
                " Esta es la letra E",
                " Esta es la letra F",
                " Esta es la letra G",
                " Esta es la letra H",
                " Esta es la letra I",
                " Esta es la letra J",
                " Esta es la letra K",
                " Esta es la letra L",
                " Esta es la letra N",
                " Esta es la letra M",
                " Esta es la letra O",
                " Esta es la letra P",
                " Esta es la letra Q",
                " Esta es la letra R",
                " Esta es la letra S",
                " Esta es la letra T",
                " Esta es la letra U",
                " Esta es la letra V",
                " Esta es la letra W",
                " Esta es la letra X",
                " Esta es la letra Y",
                " Esta es la letra Z",
        };
    }

    private String[] obtenerNombresCarrouselColores() {
        return new String[]{
                " Este es el color azul",
                " Este es el color amarillo",
                "Este es el color blanco",
                "Este es el color cafe ",
                "Este es el color morado",
                "Este es el color naranja",
                "Este es el colorrojo ",
                "Este es el color rosado"
        };
    }


    private String[] obtenerNombresCarrouselNumeros() {
        return new String[]{
                "Este es el numero 0",
                "Este es el numero 1",
                "Este es el numero 2",
                "Este es el numero 3 ",
                "Este es el numero 4",
                "Este es el numero 5",
                "Este es el numero 6 ",
                "Este es el numero 7",
                "Este es el numero 8",
                "Este es el numero 9 ",
                "Este es el numero 10"
        };
    }
    //endregion

    //region Listeners
    ImageListener listenerImagen = (position, imageView) -> imageView.setImageResource(obtenerImagenesCarrusel(tipoMenu, position));

    ImageClickListener listenerOnclick = position ->
            Toast.makeText(getActivity(), obteneNombresCarrusel(tipoMenu, position), Toast.LENGTH_SHORT/2).show();

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
