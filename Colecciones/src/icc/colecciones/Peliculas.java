package icc.colecciones;

import icc.colors.Colors;

/**
* Representacion de una Pelicula.
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/
public class Peliculas extends Compartir{

  /** actor */
  private String actor;
  /** fecha */
  private int fecha;

  /**
  * Constructor en el que se crea una nueva pelicula, en el que el orden de
  * sus datos es el mismo que viene como los parámetros que recibe.
  * @param titulo el titulo de la pelicula.
  * @param genero el genero de la pelicula.
  * @param actor el actor de la pelicula.
  * @param fecha la fecha de la pelicula.
  */
  public Peliculas(String titulo, String genero, String actor, int fecha){
    super(titulo,genero);
    this.actor= actor;
    this.fecha= fecha;
  }

  /**
  * Revisa si el genero que tiene la pelicula es igual a lo que fue ingresado como parámetro.
  * @param aux Lo ingresado por teclado
  * @return true
  */
  public boolean genero(String aux){
    return genero.equals(aux);
  }

  /**
  * Revisa si el titulo que tiene la pelicula es igual a lo que fue ingresado como parámetro.
  * @param auxp Lo ingresado por teclado
  * @return true
  */
  public boolean titulos(String auxp){
    return titulo.equals(auxp);
  }

  /**
  *Metodo que almacena al actor
  * @return actor
  */
  public String actor(){
    return actor;
  }

  /**
  * Revisa si el actor que tiene la pelicula es igual a lo que fue ingresado como parámetro.
  * @param aux Lo ingresado por teclado
  * @return true
  */
  public boolean actor(String aux){
    return actor.equals(aux);
  }

  /**
  * Revisa si la fecha que tiene la pelicula es igual a lo que fue ingresado como parámetro.
  * @param aux Lo ingresado por teclado
  * @return true
  */
  public boolean fecha(int aux){
    return fecha ==aux;
  }

  /**
  * Crear una nueva pelicula con el orden definido para hacerlo.
  * StringBuilder mandará titulo, genero, autor y tema
  * en el mismo orden que está en el constructor, y será separado por comas.
  * Crea la línea que se guardará en el archivo .csv
  * Traduce una pelicula como tal, a una de las lineas del archivo .csv
  * @return sb StringBuilder
  */
  public String toFile(){
    StringBuilder sb = new StringBuilder();

    sb.append (titulo);
    sb.append (",");
    sb.append (genero);
    sb.append (",");
    sb.append (actor);
    sb.append (",");
    sb.append (fecha);
    return sb.toString();
  }


  /**
  * Método para darle formato a la impresión de consultas.
  * @return sb StringBuilder
  */
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();

    sb.append(Colors.HIGH_INTENSITY);
    sb.append ("Titulo: ");
    sb.append (Colors.RESTORE);
    sb.append (titulo);
    sb.append ("\n");
    sb.append (Colors.HIGH_INTENSITY);
    sb.append ("Genero: ");
    sb.append (Colors.RESTORE);
    sb.append (genero);
    sb.append ("\n");
    sb.append (Colors.HIGH_INTENSITY);
    sb.append ("Actor o actriz: ");
    sb.append (Colors.RESTORE);
    sb.append (actor);
    sb.append ("\n");
    sb.append (Colors.HIGH_INTENSITY);
    sb.append ("Año de filmacion: ");
    sb.append (Colors.RESTORE);
    sb.append (fecha);

    return sb.toString();

  }

}
