package icc.colecciones;

import icc.colors.Colors;


/**
* Clase que representa un Libro.
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

public class Libro extends Compartir{
  //private String titulo;
  //private String genero;
  /** Autor */
  private String autor;

  /**Tema */
  private String tema;

  /**
  * Constructor en el que se crea un nuevo libro, en el que el orden de sus datos
  * es el mismo que viene como los parámetros que recibe.
  * @param titulo el titulo del libro.
  * @param genero el genero del libro.
  * @param autor el autor del libro.
  * @param tema el tema del libro.
  */
  public Libro(String titulo, String genero, String autor, String tema){
    super (titulo,genero);
    this.autor= autor;
    this.tema= tema;
  }

////////////////////////////////////////////////////////////////////////////////////////
//   estos de autor, tema y titulo irian en clase articulo cuando hagamos herencia    //
////////////////////////////////////////////////////////////////////////////////////////


/**
* Método que revisa si el autor que tiene el libro es igual a lo que fue ingresado como parámetro.
* @param aux Lo ingresado por teclado
* @return true
*/
  public boolean autor(String aux){
    return autor.equals(aux);
  }
  
  
/**
* Método que revisa si el titulo que tiene el libro es igual a lo que fue ingresado como parámetro.
* @param aux Lo ingresado por teclado
* @return true
*/
  public boolean titulo(String aux){
    return titulo.equals(aux);
  }
  
  
/**
* Método que revisa si el tema que tiene el libro es igual a lo que fue ingresado como parámetro.
* @param aux Lo ingresado por teclado
* @return true
*/
  public boolean tema(String aux){
    return tema.equals(aux);
  }


////////////////////////////////////////////////////////////////////////////////////////

/**
* Método que crea un nuevo libro con el orden definido para hacerlo.
* StringBuilder mandará titulo, genero, autor y tema
* en el mismo orden que está en el constructor, y será separado por comas.
* Crea la línea que se guardará en el archivo .csv
* Traduce un libro como tal, a una de las lineas del archivo .csv
* @return sb StringBuilder
*/
  public String toFile(){
    StringBuilder sb = new StringBuilder();

    sb.append (titulo);
    sb.append (",");
    sb.append (genero);
    sb.append (",");
    sb.append (autor);
    sb.append (",");
    sb.append (tema);
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
    sb.append ("Autor: ");
    sb.append (Colors.RESTORE);
    sb.append (autor);
    sb.append ("\n");
    sb.append (Colors.HIGH_INTENSITY);
    sb.append ("Tema: ");
    sb.append (Colors.RESTORE);
    sb.append (tema);

    return sb.toString();

  }
}
