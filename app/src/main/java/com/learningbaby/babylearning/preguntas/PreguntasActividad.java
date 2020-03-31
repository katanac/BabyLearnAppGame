package com.learningbaby.babylearning.preguntas;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.learningbaby.babylearning.R;

import java.util.ArrayList;


public class PreguntasActividad extends AppCompatActivity {


    private ImageView ImagenPregunta;
    private Button RespuestaBoton1, RespuestaBoton2, RespuestaBoton3;

    private String rightAnswer;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"abeja", "A", "E", "I", "O"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmento_preguntas);
        ImagenPregunta = findViewById(R.id.ImagenPregunta);

        RespuestaBoton1 = findViewById(R.id.button);
        RespuestaBoton2 = findViewById(R.id.button2);
        RespuestaBoton3 = findViewById(R.id.button3);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct!!
            alertTitle = "Correcto!";

        } else {
            // Wrong
            alertTitle = "Mal...";
        }

        // Create Dialog.

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArray.size() < 1) {
                    // quizArray is empty.
                    showResult();

                }
            }
        });
        builder.setCancelable(false);
        builder.show();


    }

    public void showResult() {

        android.app.AlertDialog.Builder builder = null;
        builder.setPositiveButton("Re-intentar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }
}

