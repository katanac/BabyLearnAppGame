package com.learningbaby.babylearning.transversal.enumeradores;

public enum AccionesFabricaMenuEnum {
    MENUCOLORES(1,"colores"),
    MENUNUMEROS(2,"numeros"),
    MENUALFABETO(3,"abecedario");


    int idAccion;
    String nombreAccion;


    AccionesFabricaMenuEnum(int idAccion, String nombreAccion) {
        this.idAccion = idAccion;
        this.nombreAccion = nombreAccion;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }
}
