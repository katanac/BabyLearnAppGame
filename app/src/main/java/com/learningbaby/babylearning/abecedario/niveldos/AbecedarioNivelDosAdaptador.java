package com.learningbaby.babylearning.abecedario.niveldos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AbecedarioNivelDosAdaptador extends RecyclerView.Adapter<AbecedarioNivelDosAdaptador.ViewHolder> {

    private Context contexto;
    private ListadoNivelCallback listener;
    private List<Integer> listaDeIds = new LinkedList<>();
    int cantidad = 6, rango = 25;
    int arreglo[] = new int[cantidad];


    public AbecedarioNivelDosAdaptador(Context contexto, ListadoNivelCallback listener) {
        this.contexto = contexto;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nivel_dos, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bin(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imv_imagen_nvl_dos)
        ImageView imgennvl2;
        @BindView(R.id.card_nivel_dos)
        CardView cardViewNvl;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bin(final int posicion) {

            Random random = new Random();
            int id = obtenerId()[random.nextInt(obtenerId().length)];

            final ItemsAbecedarioEnum abecedarioEnum = ItemsAbecedarioEnum.valueOf(id);
            cardViewNvl.setOnClickListener(view -> listener.itemSelected(posicion, abecedarioEnum));
            Glide.with(contexto)
                    .load(abecedarioEnum.getIdRecurso())
                    .apply(new RequestOptions().placeholder(R.drawable.gradient_carga_imagen))
                    .into(imgennvl2);
        }
    }

    private int[] obtenerId() {
        return new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,};

    }

    interface ListadoNivelCallback {
        void itemSelected(int position, ItemsAbecedarioEnum abecedarioEnum);
    }
}



