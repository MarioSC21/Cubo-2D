package com.example.cubo2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.io.Console;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class canvaCube extends View {
  //array de los colores de las caras
  public Map<String, Integer> map = new HashMap<String, Integer>();
  //instanciamos la clase cuboCombinaciones
  cuboCombinatciones cubo;
  //argb del green claro
  private int[] colors = new int[6];
  private int defaultForma = 1;
  private int numeroForma = 1;
  // 0 = frente = RED
  // 1 = atras = BLUE
  // 2 = derecha = GRAY
  // 3 = izquierda = BLACK
  // 4 = arriba = GREEN
  // 5 = abajo = YELLOW


  //instancia de la clase Paint
  private Paint paint = new Paint();

  //constructor de View que recibe el contexto y los atributos
  public canvaCube(Context context, AttributeSet attrs) {
    super(context, attrs);
    cubo = new cuboCombinatciones();
    map.put("Plomo",Color.rgb(192,192,192));//2
    map.put("Negro",Color.rgb(105,105,105));//3
    map.put("Rojo",Color.rgb(205,92,92));//0
    map.put("Verde",Color.argb(77,116,190, 20));//4
    map.put("Azul",Color.rgb(30,144,255));//1
    map.put("Amarillo", Color.rgb(240,230,140));//5
    colors[0] = map.get(cubo.getNombreColor(cubo.getFrente(defaultForma)));
    colors[1] = map.get(cubo.getNombreColor(cubo.getAtras(defaultForma)));
    colors[2] = map.get(cubo.getNombreColor(cubo.getDerecha(defaultForma)));
    colors[3] = map.get(cubo.getNombreColor(cubo.getIzquierda(defaultForma)));
    colors[4] = map.get(cubo.getNombreColor(cubo.getArriba(defaultForma)));
    colors[5] = map.get(cubo.getNombreColor(cubo.getAbajo(defaultForma)));
    System.out.println("Frente: " + cubo.getNumeroCubos());
  }

  //sobreescribimos el método onDraw
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    int cubeSize = 350; //size cube

    // Dibuja la cara azul del cubo (ATRAS)
    paint.setColor(colors[1]);
    canvas.drawRect(cubeSize, 0, 2 * cubeSize, cubeSize, paint);

    // Dibuja la cara verde del cubo debajo de la cara azul (ARRIBA)
    paint.setColor(colors[4]);
    canvas.drawRect(cubeSize, cubeSize, 2 * cubeSize, 2 * cubeSize, paint);

    // Dibuja la cara negra del cubo a la izquierda de la roja (IZQUIERDA)
    paint.setColor(colors[3]);
    canvas.drawRect(0, 2 * cubeSize, cubeSize, 3 * cubeSize, paint);

    // Dibuja la cara roja del cubo debajo de la cara verde (FRENTE)
    paint.setColor(colors[0]);
    canvas.drawRect(cubeSize, 2 * cubeSize, 2 * cubeSize, 3 * cubeSize, paint);

    // Dibuja la cara gris del cubo al lado derecho de la cara roja(DERECHA)
    paint.setColor(colors[2]);
    canvas.drawRect(2 * cubeSize, 2 * cubeSize, 3 * cubeSize, 3 * cubeSize, paint);

    // Dibuja la cara amarilla del cubo abajo de la cara roja (ABAJO)
    paint.setColor(colors[5]);
    canvas.drawRect(cubeSize, 3 * cubeSize, 2 * cubeSize, 4 * cubeSize, paint);

  }
  //! Metodos para rotar el cubo
  public void rotateRight() {
    //movuiendo los colores hacia la derecha
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    int temp = colors[0];
    colors[0] = colors[2];
    colors[2] = colors[1];
    colors[1] = colors[3];
    colors[3] = temp;
    invalidate(); //redibujar la vista, vuelve a dibujar la vista
  }

  public void rotateLeft() {
  // movuiendo los colores hacia la izquierda
    int temp = colors[0];
    colors[0] = colors[3];
    colors[3] = colors[1];
    colors[1] = colors[2];
    colors[2] = temp;
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    invalidate();
  }

  public void rotateDown() {
    // movuiendo los colores hacia abajo
    int temp = colors[0];
    colors[0] = colors[4];
    colors[4] = colors[1];
    colors[1] = colors[5];
    colors[5] = temp;
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    invalidate();
  }

  public void rotateUp() {
    // movuiendo los colores hacia arriba
    int temp = colors[0];
    colors[0] = colors[5];
    colors[5] = colors[1];
    colors[1] = colors[4];
    colors[4] = temp;
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    invalidate();
  }

  public void rotateFrontAnti() {
    // antohoario
    int temp = colors[2];
    colors[2] = colors[5];
    colors[5] = colors[3];
    colors[3] = colors[4];
    colors[4] = temp;
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    invalidate();
  }
  public void rotateFrontHorario() {
    // horario
    int temp = colors[2];
    colors[2] = colors[4];
    colors[4] = colors[3];
    colors[3] = colors[5];
    colors[5] = temp;
    numeroForma = cubo.getNumeroCubo(cubo.getFrente(defaultForma), cubo.getDerecha(defaultForma), cubo.getAtras(defaultForma), cubo.getIzquierda(defaultForma), cubo.getArriba(defaultForma), cubo.getAbajo(defaultForma));
    invalidate();
  }
  public int getcuboNumero(){
    return numeroForma;
  }
  public void setcuboNumero(int numero){
    defaultForma = numero;
  }
}
