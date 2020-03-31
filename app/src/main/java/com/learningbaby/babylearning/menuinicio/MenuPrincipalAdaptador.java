package com.learningbaby.babylearning.menuinicio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsMenuEnum;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuPrincipalAdaptador extends RecyclerView.Adapter<MenuPrincipalAdaptador.ViewHolder> {

    //region Atributos
    private Context contexto;
    private ListadoMenuCallback listener;

    //endregion

    //region Contructor
    MenuPrincipalAdaptador(Context contexto, ListadoMenuCallback listener) {
        this.contexto = contexto;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuPrincipalAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_menu_principal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuPrincipalAdaptador.ViewHolder viewHolder, int i) {
        viewHolder.bin(i);
    }

    @Override
    public int getItemCount() {
        return obtenerId().length;
    }
    //endregion

    //region Contenedor
    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_menu_principal)
        CardView cardItemManu;
        @BindView(R.id.linear_enumerador)
        LinearLayout lyEnumerador;
        @BindView(R.id.txt_titulo_menu)
        TextView tvTituloMenu;
        @BindView(R.id.tv_enumerador_menu)
        TextView tvEnumerador;
        @BindView(R.id.imv_menu_principal)
        ImageView imagenMenu;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bin(final int position) {
            int id = obtenerId()[position];
            final ItemsMenuEnum menuEnum = ItemsMenuEnum.valueOf(id);
            lyEnumerador.setVisibility(View.INVISIBLE);
            tvTituloMenu.setText(menuEnum.getNombreBandeja());
            tvEnumerador.setVisibility(View.INVISIBLE);
            cardItemManu.setOnClickListener(v -> listener.itemSelected(position));
            Glide.with(contexto)
                    .load(menuEnum.getRecursoId())
                    .apply(new RequestOptions().placeholder(R.drawable.gradient_carga_imagen))
                    .into(imagenMenu);

        }
    }
    //endregion

    private int[] obtenerId() {
        return new int[]{
                1,
                2,
                3};

    }

    //region Callback
    interface ListadoMenuCallback {
        void itemSelected(int position);
    }
    //endregion
}
