package com.learningbaby.babylearning.niveles.niveldos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.enumeradores.ItemsAbecedarioEnum;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AbecedarioNivelDosAdaptador extends RecyclerView.Adapter<AbecedarioNivelDosAdaptador.ViewHolder> {

    //region Atributos
    private Context contexto;
    private ListadoNivelCallback listener;
    private List<Integer> listaDeIds = new LinkedList<>();
    //endregion

    //region Sobrecarga
    AbecedarioNivelDosAdaptador(Context contexto, ListadoNivelCallback listener) {
        this.contexto = contexto;
        this.listener = listener;
    }
    //endregion

    //region Sobrecarga
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


            final ItemsAbecedarioEnum abecedarioEnum = ItemsAbecedarioEnum.valueOf(retornoId());
            cardViewNvl.setOnClickListener(view -> listener.itemSelected(posicion, abecedarioEnum));
            Glide.with(contexto)
                    .load(abecedarioEnum.getIdRecurso())
                    .apply(new RequestOptions().placeholder(R.drawable.gradient_carga_imagen))
                    .into(imgennvl2);


        }
    }
    //endregion

    //region Porpios


    private int[] idAbecedario() {
        return new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,};

    }


    private int[] idNumerosColores() {
        return new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    }

    private int retornoId() {
        Random random = new Random();
        int id=0;
        boolean valorRRespuesta = false;

        while (!valorRRespuesta){
            id = idAbecedario()[random.nextInt(idAbecedario().length)];

            if (!listaDeIds.contains(id)){
                valorRRespuesta = true;
                listaDeIds.add(id);

            }
        }

        return id;
    }
    //endregion

    //region Listener
    interface ListadoNivelCallback {
        void itemSelected(int position, ItemsAbecedarioEnum abecedarioEnum);
    }
    //endregion

}



