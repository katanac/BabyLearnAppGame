package com.learningbaby.babylearning.transversal.enumeradores;

import com.learningbaby.babylearning.R;

public enum  itemsNumerosEnum {

    Cero(0, R.drawable.cero, "Cero"),
    Uno(0, R.drawable.uno, "Uno"),
    Dos(1, R.drawable.dos, "Azul"),
    Tres(2, R.drawable.tres, "Blanco"),
    Cuatro(3, R.drawable.cuatro, "Cafe"),
    Cinco(4, R.drawable.cinco, "Morado"),
    Seis(5, R.drawable.seis, "Naranja"),
    Siete(6, R.drawable.siete, "Negro"),
    Ocho(7, R.drawable.ocho, "Rojo"),
    Nueve(8, R.drawable.nueve, "Rosado"),
    Diez(9, R.drawable.diez, "Verde");


    private final int id;
    private final int idRecurso;
    private final String nombreBandeja;

    public int getId() {
        return id;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public String getNombreBandeja() {
        return nombreBandeja;
    }

    itemsNumerosEnum(int id, int idRecurso, String nombreBandeja) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.nombreBandeja = nombreBandeja;

    }
}
