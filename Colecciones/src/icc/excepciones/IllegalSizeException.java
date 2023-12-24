package icc.excepciones;

/**
* Representacion de las excepciones
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

/**
* Indica que el tamaño fue excedido.
*/
public class IllegalSizeException extends Exception{
    /**
     * Constructor
     */
    public IllegalSizeException(){
        super();
    }

     /**
     * Constructor
     * @param message Información detallada sobre que porque se mandó la excepción
     */
    public IllegalSizeException(String message){
        super(message);
    }
}
