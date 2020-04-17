package com.learningbaby.babylearning.transversal.enumeradores;

import com.learningbaby.babylearning.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public enum  ItemsAbecedarioEnum {

    A(0,R.drawable.a, "A"),
    B(1, R.drawable.b, "B"),
    C(2, R.drawable.c, "C"),
    D(3, R.drawable.d, "D"),
    E(4, R.drawable.e, "E"),
    F(5, R.drawable.f, "F"),
    G(6, R.drawable.g, "G"),
    H(7, R.drawable.h, "H"),
    I(8, R.drawable.i, "I"),
    J(9, R.drawable.j, "J"),
    K(10, R.drawable.k, "K"),
    L(11, R.drawable.l, "L"),
    M(12, R.drawable.m, "M"),
    N(13, R.drawable.n, "N"),
    O(14, R.drawable.o, "O"),
    P(15, R.drawable.p, "P"),
    Q(16, R.drawable.q, "Q"),
    r(17, R.drawable.r, "R"),
    S(18, R.drawable.s, "S"),
    T(19, R.drawable.t, "T"),
    U(20, R.drawable.u, "U"),
    W(21, R.drawable.w, "W"),
    V(22, R.drawable.v, "V"),
    X(23, R.drawable.x, "X"),
    Y(24, R.drawable.y, "Y"),
    Z(25, R.drawable.z, "Z");


    public final int id;
    public final int idRecurso;
    public final String nombreBandeja;
    private static HashMap<Integer, ItemsAbecedarioEnum> map = new LinkedHashMap<>();


    ItemsAbecedarioEnum(int id, int idRecurso, String nombreBandeja) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.nombreBandeja = nombreBandeja;
    }

    static {
        for (ItemsAbecedarioEnum item : ItemsAbecedarioEnum.values()) {
            map.put(item.id, item);
            map.put(item.idRecurso, item);
        }
    }

    public static ItemsAbecedarioEnum valueOf(int id) {
        return map.get(id);
    }

    public int getId() {
        return id;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public String getNombreBandeja() {
        return nombreBandeja;
    }
}
