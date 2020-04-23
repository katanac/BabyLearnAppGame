package com.learningbaby.babylearning.transversal.enumeradores;

import com.learningbaby.babylearning.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public enum  itemsNumerosEnum {

    Cero(0, R.drawable.cero, "0"),
    Uno(0, R.drawable.uno, "1"),
    Dos(1, R.drawable.dos, "2"),
    Tres(2, R.drawable.tres, "3"),
    Cuatro(3, R.drawable.cuatro, "4"),
    Cinco(4, R.drawable.cinco, "5"),
    Seis(5, R.drawable.seis, "6"),
    Siete(6, R.drawable.siete, "7"),
    Ocho(7, R.drawable.ocho, "8"),
    Nueve(8, R.drawable.nueve, "9"),
    Diez(9, R.drawable.diez, "10");


    private final int id;
    private final int idRecurso;
    private final String nombreBandeja;
    private static HashMap<Integer, itemsNumerosEnum> map = new LinkedHashMap<>();

    public int getId() {
        return id;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public String getNombreBandeja() {
        return nombreBandeja;
    }


    static {
        for (itemsNumerosEnum item : itemsNumerosEnum.values()) {
            map.put(item.id, item);
            map.put(item.idRecurso, item);
        }
    }

    public static itemsNumerosEnum valueOf(int id) {
        return map.get(id);
    }

    itemsNumerosEnum(int id, int idRecurso, String nombreBandeja) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.nombreBandeja = nombreBandeja;

    }
}
