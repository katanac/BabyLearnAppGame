package com.learningbaby.babylearning.abecedario.niveluno;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.learningbaby.babylearning.R;
import com.learningbaby.babylearning.transversal.Constantes.Constantes;
import com.learningbaby.babylearning.transversal.enumeradores.TipoMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class AbecedarioNivelUnoActividad extends AppCompatActivity {


    //region Atributos
    private ImageView ImagenPregunta;
    private TextView tvPregunta;
    private String RespuestaCorrecta;
    private ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    private Button respuestaBoton1;
    private Button respuestaBoton2;
    private Button respuestaBoton3;

    private TipoMenu tipoMenu;

    private String InformacionPreguntas[][] = {
            {"abeja", "A", "F", "G"},
            {"burro", "B", "T", "M"},
            {"cerdo", "C", "V", "K"},
            {"delfin", "D", "L", "P"},
            {"elefante", "E", "N", "S"},
            {"foca", "F", "X", "W"},
            {"gato", "G", "A", "Z"},
    };

    private String InformacionPreguntasNumericas[][] = {

            {"cero", "0", "7", "2"},
            {"uno", "1", "3", "8"},
            {"dos", "2", "5", "9"},
            {"tres", "3", "8", "9"},
            {"cuatro", "4", "6", "8"},
            {"cinco", "5", "7", "9"},
            {"seis", "6", "3", "10"},
            {"siete", "7", "1", "0"},
            {"ocho", "8", "3", "0"},
            {"nueve", "9", "4", "5"},
            {"diez", "10", "3", "0"},

    };

    private String InformacionPreguntasColores[][] = {
            {"rojo", "rojo", "azul", "blanco"},
            {"azul", "azul", "verde", "amarillo"},
            {"verde", "verde", "negro", "azul"},
            {"blanco", "blanco", "verde", "negro"},
            {"amarillo", "amarillo", "verde", "blanco"},
            {"negro", "negro", "rojo", "morado"},
            {"morado", "morado", "azul", "blanco"},
    };

    //endregion

    //region Intencion
    public static Intent obtenerIntencion(Context contexto, TipoMenu tipoMenu) {
        Intent intencion = new Intent(contexto, AbecedarioNivelUnoActividad.class);
        intencion.putExtra(Constantes.EXTRA_TIPO_MENU, tipoMenu);
        return intencion;
    }
    //endregion

    //region Constructor
//    public AbecedarioNivelUnoActividad(String rightAnswer) {
//        this.rightAnswer = rightAnswer;
//    }
    //endregion

    //region Sobrecargas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmento_preguntas);


        tipoMenu = (TipoMenu) getIntent().getSerializableExtra(Constantes.EXTRA_TIPO_MENU);
        tvPregunta = findViewById(R.id.textViewPregunta);
        ImagenPregunta = findViewById(R.id.ImagenPregunta);
        respuestaBoton1 = findViewById(R.id.button);
        respuestaBoton2 = findViewById(R.id.button2);
        respuestaBoton3 = findViewById(R.id.button3);


        tvPregunta.setText(obtenePreguntaArreglo());

        for (int i = 0; i < obteneArreglo().length; i++) {

            ArrayList<String> Recopilador = new ArrayList<>();

            Recopilador.add(obteneArreglo()[i][0]);
            Recopilador.add(obteneArreglo()[i][1]);
            Recopilador.add(obteneArreglo()[i][2]);
            Recopilador.add(obteneArreglo()[i][3]);

            quizArray.add(Recopilador);

        }
        MostrarSigPregunta();

    }
    //endregion

    //region Eventos

    public void MostrarSigPregunta() {

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        ImagenPregunta.setImageResource(getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        RespuestaCorrecta = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        respuestaBoton1.setText(quiz.get(0));
        respuestaBoton2.setText(quiz.get(1));
        respuestaBoton3.setText(quiz.get(2));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button RespuestaBtn = findViewById(view.getId());
        String btnTexto = RespuestaBtn.getText().toString();

        String alertTitle;

        if (btnTexto.equals(RespuestaCorrecta)) {
            // Correct!!
            alertTitle = "Correcto!";

        } else {
            // Wrong
            alertTitle = "Mal...";
        }

        // Create Dialog.

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta : " + RespuestaCorrecta);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            if (quizArray.size() < 1) {
                // quizArray is empty.
                showResult(builder);

            } else {

                MostrarSigPregunta();

            }
        });
        builder.setCancelable(false);
        builder.show();


    }

    public void showResult(AlertDialog.Builder builder) {
        builder.setPositiveButton("Re-intentar", (dialogInterface, i) -> recreate());
        builder.setNegativeButton("Salir", (dialogInterface, i) -> finish());
        builder.show();
    }


    private String[][] obteneArreglo() {

        if (tipoMenu == TipoMenu.MENUCOLORES) {
            return InformacionPreguntasColores;

        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            return InformacionPreguntasNumericas;

        } else {
            return InformacionPreguntas;
        }
    }


    private int obtenePreguntaArreglo() {

        if (tipoMenu == TipoMenu.MENUCOLORES) {
            return R.string.Pregunta_color;

        } else if (tipoMenu == TipoMenu.MENUNUMEROS) {
            return R.string.Pregunta_numero;

        } else {
            return R.string.Pregunta;
        }
    }
    //endregion
}

