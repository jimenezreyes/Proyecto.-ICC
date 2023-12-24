package icc.excepciones;

/**
* Representacion de un titulo repetido.
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

/**
* Indica título repetido.
*/
public class RepeatedTitleException extends Exception{

        /**
        * Constructor
        */
        public RepeatedTitleException(){
            super();
        }
        
        /**
        * Constructor
        * @param message Información detallada sobre que porque se mandó la excepción
        */
        public RepeatedTitleException(String message){
            super(message);
        }
    }
