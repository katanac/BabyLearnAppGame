package com.learningbaby.babylearning.abecedario.niveluno;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.learningbaby.babylearning.R;

import java.util.ArrayList;


public class AbecedarioNivelUnoActividad extends AppCompatActivity {


    //region Atributos
    private String rightAnswer;
    private ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
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

        Button respuestaBoton1 = findViewById(R.id.button);
        Button respuestaBoton2 = findViewById(R.id.button2);
        Button respuestaBoton3 = findViewById(R.id.button3);

    }
    //endregion

    //region Eventos
    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals("A")) {
            // Correct!!
            alertTitle = "Correcto!";

        } else {
            // Wrong
            alertTitle = "Mal...";
        }

        // Create Dialog.

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta : " + "A");
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            if (quizArray.size() < 1) {
                // quizArray is empty.
                showResult(builder);

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

