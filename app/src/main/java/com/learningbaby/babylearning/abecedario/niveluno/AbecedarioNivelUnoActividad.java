package com.learningbaby.babylearning.abecedario.niveluno;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.learningbaby.babylearning.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class AbecedarioNivelUnoActividad extends AppCompatActivity {


    //region Atributos
    private ImageView ImagenPregunta;
    private String RespuestaCorrecta;
    private ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    private Button respuestaBoton1;
    private Button respuestaBoton2;
    private Button respuestaBoton3;

    String InformacionPreguntas [][] = {
            {"abeja","A","F","G"},
            {"burro","B","T","M"},
            {"cerdo","C","V","K"},
            {"delfin","D","L","P"},
            {"elefante","E","N","S"},
            {"foca","F","X","W"},
            {"gato","G","A","Z"},
            {"hipopotamo","H","C","N"},
    };

    //endregion

    //region Intencion
    public static Intent obtenerIntencion(Context contexto) {
        return new Intent(contexto, AbecedarioNivelUnoActividad.class);
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

        ImagenPregunta = findViewById(R.id.ImagenPregunta);
        respuestaBoton1 = findViewById(R.id.button);
        respuestaBoton2 = findViewById(R.id.button2);
        respuestaBoton3 = findViewById(R.id.button3);

        for (int i = 0; i < InformacionPreguntas.length; i++) {

            ArrayList<String> Recopilador = new ArrayList<>();

            Recopilador.add(InformacionPreguntas[i][0]);
            Recopilador.add(InformacionPreguntas[i][1]);
            Recopilador.add(InformacionPreguntas[i][2]);
            Recopilador.add(InformacionPreguntas[i][3]);

            quizArray.add(Recopilador);

        }

            MostrarSigPregunta();

    }
    //endregion

    //region Eventos

    public void MostrarSigPregunta(){

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

            }else{

                MostrarSigPregunta();

            }
        });
        builder.setCancelable(false);
        builder.show();


    }

    public void showResult(  AlertDialog.Builder builder) {
        builder.setPositiveButton("Re-intentar", (dialogInterface, i) -> recreate());
        builder.setNegativeButton("Salir", (dialogInterface, i) -> finish());
        builder.show();
    }
    //endregion
}

