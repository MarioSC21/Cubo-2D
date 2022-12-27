package com.example.cubo2d;

public class cuboCombinatciones {
  private int[][] cubo = new int[720][6];
  private static int arriba, abajo, frente, atras, derecha, izquierda;
  private static int secuencia = 0;

  public cuboCombinatciones() {
    for (arriba = 1; arriba <= 6; arriba++) {
      for (abajo = 1; abajo <= 6; abajo++) {
        if (abajo != arriba) {
          for (frente = 1; frente <= 6; frente++) {
            if (frente != arriba && frente != abajo) {
              for (atras = 1; atras <= 6; atras++) {
                if (atras != arriba && atras != abajo && atras != frente) {
                  for (derecha = 1; derecha <= 6; derecha++) {
                    if (derecha != arriba && derecha != abajo && derecha != frente && derecha != atras) {
                      for (izquierda = 1; izquierda <= 6; izquierda++) {
                        if (izquierda != arriba && izquierda != abajo && izquierda != frente && izquierda != atras && izquierda != derecha) {
                          cubo[secuencia][0] = arriba;
                          cubo[secuencia][1] = abajo;
                          cubo[secuencia][2] = frente;
                          cubo[secuencia][3] = atras;
                          cubo[secuencia][4] = derecha;
                          cubo[secuencia][5] = izquierda;
                          secuencia++;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
}
  public int getArriba(int numeroCubo) {
    return cubo[numeroCubo][0];
  }

  public int getAbajo(int numeroCubo) {
    return cubo[numeroCubo][1];
  }

  public int getFrente(int numeroCubo) {
    return cubo[numeroCubo][2];
  }

  public int getAtras(int numeroCubo) {
    return cubo[numeroCubo][3];
  }

  public int getDerecha(int numeroCubo) {
    return cubo[numeroCubo][4];
  }

  public int getIzquierda(int numeroCubo) {
    return cubo[numeroCubo][5];
  }

  public int[][] getCubo() {
    return cubo;
  }
  public String getNombreColor(int numeroColor) {
    switch (numeroColor) {
      case 1:
        return "Plomo";
      case 2:
        return "Negro";
      case 3:
        return "Rojo";
      case 4:
        return "Verde";
      case 5:
        return "Amarillo";
      case 6:
        return "Azul";
      default:
        return "Color no válido";
    }
  }
  public int getNumeroCubos() {
    return secuencia;
  }
  public int getNumeroCubo(int frente, int atras, int derecha, int izquierda, int arriba, int abajo) {
    for (int i = 0; i < secuencia; i++) {
      if (cubo[i][0] == arriba && cubo[i][1] == abajo && cubo[i][2] == frente && cubo[i][3] == atras && cubo[i][4] == derecha && cubo[i][5] == izquierda) {
        return i;
      }
    }
    return -1;
  }
}
