package icc.colecciones;

/**
* Clase que hereda titulo y genero
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

public abstract class Compartir {
  /** Titulo */
  String titulo;
  
  /** Genero*/
  String genero;
  
  /**
  * Crea un titulo y genero para libros, discos y peliculas.
  * @param titulo el titulo de libros,disccos y peliculas.
  * @param genero el genero de libros, discos y peliculas.
  */
  public Compartir(String titulo, String genero){
    this.titulo = titulo;
    this.genero= genero;
  }

  public boolean titulo(String aux){
    return titulo.equals(aux);
  }

  public boolean genero(String au){
    return genero.equals(au);
  }

}
