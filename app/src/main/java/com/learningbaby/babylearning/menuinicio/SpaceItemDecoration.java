package com.learningbaby.babylearning.menuinicio;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    //region Atributos
    private int space;
    //endregion

    //region Constructor
    SpaceItemDecoration(int space) {
        this.space = space;
    }
    //endregion

    //region Sobrecarga
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.top = space;
    }
    //endregion
}
