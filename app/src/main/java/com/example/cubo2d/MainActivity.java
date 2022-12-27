package com.example.cubo2d;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

  private canvaCube canvaCube; //instancia de la clase canvaCube
  private  Button btnRight; //instancia de los botones
  private  boolean sentido;
  private RadioButton radioBtnEjeV, radioBtnEjeH, radioBtnEjeP, radioBtnSentidoH, radioBtnSentidoA;
  private EditText edtxGiros, edtxNumero;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //referencia al canvas del layout
    canvaCube = findViewById(R.id.cube_canvas);

    radioBtnEjeV = (RadioButton) findViewById(R.id.radio_vertical);
    radioBtnEjeH = (RadioButton) findViewById(R.id.radio_horizontal);
    radioBtnEjeP = (RadioButton) findViewById(R.id.radio_profundidad);
    radioBtnSentidoH = (RadioButton) findViewById(R.id.radio_horario);
    radioBtnSentidoA = (RadioButton) findViewById(R.id.radio_anti);
    edtxGiros = (EditText) findViewById(R.id.tex_number_giros);
    edtxNumero = (EditText) findViewById(R.id.tex_number_numero);

    //referencia a los boton girar
    btnRight = findViewById(R.id.btn_girar);
    //crear evento onClick para el boton
    btnRight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int giros = Integer.parseInt(edtxGiros.getText().toString());
        edtxNumero.setText(String.valueOf(canvaCube.getcuboNumero()));
        //eje vertical y sentido horario
        if (radioBtnEjeV.isChecked() && radioBtnSentidoH.isChecked() && giros > 0 && giros < 4 ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateRight();
          }
        }
        //eje vertical y sentido antihorario
        else  if (radioBtnEjeV.isChecked() && radioBtnSentidoA.isChecked()  && giros > 0 && giros < 4 ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateLeft();
          }
        }
        //eje horizontal y sentido horario
        else if (radioBtnEjeH.isChecked() && radioBtnSentidoH.isChecked()  && giros > 0 && giros < 4 ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateDown();
          }
        }
        //eje horizontal y sentido antihorario
        else if (radioBtnEjeH.isChecked() && radioBtnSentidoA.isChecked()  && giros > 0 && giros < 4  ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateUp();
          }
        }
        //eje profundidad y sentido horario
        else if (radioBtnEjeP.isChecked() && radioBtnSentidoH.isChecked() && giros > 0 && giros < 4 ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateFrontHorario();
          }
        }
        //eje profundidad y sentido antihorario
        else if (radioBtnEjeP.isChecked() && radioBtnSentidoA.isChecked() && giros > 0 && giros < 4 ) {
          for (int i = 0; i < giros; i++) {
            canvaCube.rotateFrontAnti();
          }
        }
        else {
          //mandar mendaje de error en Toast Y setar los valores por defecto
          edtxGiros.setText("1");
          Toast toast = Toast.makeText(getApplicationContext(), "El numero de giros debe ser menor a 4 y mayor a 0 o el numero de cubo" +
                  "debe ser mayor a cero o menor a 721", Toast.LENGTH_SHORT);
          toast.show();
        }
      }
    });
  }

}