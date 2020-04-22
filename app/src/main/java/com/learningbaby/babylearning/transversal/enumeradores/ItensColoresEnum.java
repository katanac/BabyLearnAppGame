package com.learningbaby.babylearning.transversal.enumeradores;

import com.learningbaby.babylearning.R;

public enum  ItensColoresEnum {

    Amarrillo(0, R.drawable.amarillo, "Amarrillo"),
    Azul(1, R.drawable.azul, "Azul"),
    Blanco(2, R.drawable.blanco, "Blanco"),
    Cafe(3, R.drawable.cafe, "Cafe"),
    Morado(4, R.drawable.morado, "Morado"),
    Naranja(5, R.drawable.naranja, "Naranja"),
    Negro(6, R.drawable.negro, "Negro"),
    Rojo(7, R.drawable.rojo, "Rojo"),
    Rosado(8, R.drawable.rosado, "Rosado"),
    Verde(9, R.drawable.verde, "Verde");


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

    ItensColoresEnum(int id, int idRecurso, String nombreBandeja) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.nombreBandeja = nombreBandeja;

    }
}
