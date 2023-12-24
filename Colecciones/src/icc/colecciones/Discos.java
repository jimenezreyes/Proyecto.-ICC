package icc.colecciones;
import icc.colors.Colors;


/**
* Clase que representa a un Disco
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

public class Discos extends Compartir{

    /** Interprete */
    private String interprete;

    /** Pistas */
    private int pistas;

    /**
    * Constructor en el que se crea un nuevo disco, en el que el orden de sus
    * datos es el mismo que viene como los parámetros que recibe.
    * @param titulo el titulo del disco.
    * @param genero el genero del disco.
    * @param interprete del disco.
    * @param pistas del disco.
    */
    public Discos(String titulo, String genero, String interprete, int pistas){
        //this.titulo = titulo;
        //this.genero= genero;
        super (titulo, genero);
        this.interprete= interprete;
        this.pistas= pistas;
    }

    /**
    * Revisa si el interpréte que tiene el disco
    * es igual a lo que fue ingresado como parámetro.
    * @param aux, aux lo que fue ingresado por el usuario.
    * @return true.
    */
    public boolean interprete(String aux){
        return interprete.equals(aux);
    }


    /**
    * Revisa si el número de pistas que tiene un disco es mayor a 10
    * @return Pistas mayores a 10.
    */
    public boolean pistasDiez(){
        return (pistas>10);
    }
    
    /**
    *Almacenar cuando se ingrese interprete 
    * @return interprete    Interprete ingresado
    */
    public String interprete(){
    return interprete;
  }
    /**
    * Revisa si el género que tiene el disco
    * es igual a lo que fue ingresado como prámetro.
    * @param aux, aux lo que fue ingresado por el usuario.
    * @return true.
    */
    public boolean genero(String aux){
    return genero.equals(aux);
  }


    /**
    * Crea un nuevo disco con el orden definido para hacerlo.
    * StringBuilder mandará titulo, genero, autor y tema
    * en el mismo orden que está en el constructor, y será separado por comas.
    * Crea la línea que se guardará en el archivo .csv
    * Traduce un disco como tal, a una de las lineas del archivo .csv
    * @return sb StringBuilder
    */
    public String toFile(){
        StringBuilder sb = new StringBuilder();

        sb.append (titulo);
        sb.append (",");
        sb.append (genero);
        sb.append (",");
        sb.append (interprete);
        sb.append (",");
        sb.append (pistas);
        return sb.toString();
    }

    /**
    * Metodo para darle formato a la impresión de consultas.
    * @return sb.toString  StringBuilder
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
        sb.append ("Interprete: ");
        sb.append (Colors.RESTORE);
        sb.append (interprete);
        sb.append ("\n");
        sb.append (Colors.HIGH_INTENSITY);
        sb.append ("Pistas: ");
        sb.append (Colors.RESTORE);
        sb.append (pistas);

        return sb.toString();

    }
}
