package com.learningbaby.babylearning.menuniveles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learningbaby.babylearning.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

public class MenuNvlFragmento extends Fragment {

    //region Atributos
    CarouselView carouselView;
    //endregion

    //region Instancia
    static MenuNvlFragmento obtenerInstancia() {
        return new MenuNvlFragmento();
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
        carouselView = (view.findViewById(R.id.carousel_juego));
        llenadoCarouselView(carouselView);
    }
    //endregion

    //region Propios
    private void llenadoCarouselView(CarouselView carouselView) {

        carouselView.setImageListener(listenerImagen);
        carouselView.setImageClickListener(listenerOnclick);
        carouselView.setPageCount(obtenerImagenesCarousel().length);

    }

    private int[] obtenerImagenesCarousel() {
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

    private String[] obtenerNombresCarrousel() {
        return new String[]{
                "NUESTRO",
                "JUEGO",
                "ES",
                "EL ",
                "MEJOR"
        };
    }
    //endregion

    //region Listeners
    ImageListener listenerImagen = (position, imageView) -> imageView.setImageResource(obtenerImagenesCarousel()[position]);

    ImageClickListener listenerOnclick = position ->
            Toast.makeText(getActivity(), obtenerNombresCarrousel()[position], Toast.LENGTH_SHORT).show();
    //endregion

}
