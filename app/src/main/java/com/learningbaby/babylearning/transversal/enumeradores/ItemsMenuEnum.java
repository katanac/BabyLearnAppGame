package com.learningbaby.babylearning.transversal.enumeradores;



import com.learningbaby.babylearning.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public enum ItemsMenuEnum {

    COLORES(0, R.drawable.colores, "Colores"),
    NUMEROS(1, R.drawable.numeros, "Numeros"),
    ABECEDARIO(2, R.drawable.abece, "Abecedario");


    private final int id;
    private final int idRecurso;
    private final String nombreBandeja;
    private static HashMap<Integer, ItemsMenuEnum> map = new LinkedHashMap<>();


    ItemsMenuEnum(int id, int idRecurso, String nombreBandeja) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.nombreBandeja = nombreBandeja;
    }

    static {
        for (ItemsMenuEnum item : ItemsMenuEnum.values()) {
            map.put(item.id, item);
            map.put(item.idRecurso, item);
        }
    }

    public static ItemsMenuEnum valueOf(int idMenu) {
        return map.get(idMenu);
    }

    public int getValue() {
        return id;
    }
    public int getRecursoId(){return idRecurso;}

    public String getNombreBandeja() {
        return nombreBandeja;
    }


}
