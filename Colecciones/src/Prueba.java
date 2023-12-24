//package icc;

import java.util.Scanner;
import icc.colors.Colors;
import icc.colecciones.Libro;
import icc.excepciones.IllegalSizeException;
import icc.excepciones.RepeatedTitleException;
import icc.gestor.Gestor;
import icc.colecciones.Discos;
import icc.colecciones.Peliculas;

/**
* Clase principal en la que se hacen los menús y se manda a llamar los diferentes métodos para realizar dependiendo la opción seleccionada.
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

public class Prueba {



    /**
    * Método utilizado para forzar al usuario a que nos de una opción válida para el menú
    *
    * @param mensaje de tipo String que se le muestra al usuario para pedir que ingrese un valor
    * @param error de tipo String que se le muestra al usuario en caso de que el valor ingresado no sea válido
    * @param min de tipo double: valor mínimo permitido
    * @param max de tipo double: valor máximo permitido
    *
    * @return valor leído de tipo entero
    */
    public static int getInt (String mensaje, String error, int min, int max){

        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.println(mensaje);
            if(scn.hasNextInt()){
                int val = scn.nextInt();
                if ( val < min || max < val){
                    System.out.println(error);
                    continue;
                }
                return val;
            }
            scn.next();
            System.out.println(error);
        }
    }


    /**
    * Método utilizado para forzar al usuario a que nos de una opción válida para el menú
    *
    * @param mensaje de tipo String que se le muestra al usuario para pedir que ingrese un valor
    * @param error de tipo String que se le muestra al usuario en caso de que el valor ingresado no sea válido
    * @param min de tipo double: valor mínimo permitido
    * @param max de tipo double: valor máximo permitido
    *
    * @return valor leído de tipo double
    */
    public static double getDouble(String mensaje, String error, double min, double max) {
        double val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println(mensaje);
            if (scn.hasNextDouble()) {
                val = scn.nextDouble();
                if (val < min || max < val) {
                    System.out.println(error);
                } else {
                    return val;
                }
            } else {
                scn.next();
                System.out.println(error);
            }
        }
    }


    /**
    * Método para crear el libro como tal
    * @param g                          Donde se almacenará todo el libro
    * @throws RepeatedTitleException    Excepción para titulo repetido
    * @return Libro                    Crea libro
    */
    public static Libro getLibro (Gestor g) throws RepeatedTitleException {
        Scanner scn= new Scanner(System.in);
        String titulo, genero, autor, tema;

        System.out.println("Ingrese el titulo del libro. (Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios  ");
        titulo = scn.next();
        g.newLibro(titulo); //revisión de si existe el título o no
        System.out.println("Ingrese el genero del libro. ");
        genero = scn.next();
        System.out.println("Ingrese el autor del libro. ");
        autor = scn.next();
        System.out.println("Ingrese el tema del libro. ");
        tema = scn.next();

        return new Libro(titulo, genero, autor, tema);
    }

    /**
    * Método para crear un disco.
    * @param g                          Donde se almacenará todo el disco
    * @throws RepeatedTitleException    Excepción para titulo repetido
    * @return Discos                    Crea disco
    */
    public static Discos getDisco(Gestor g) throws RepeatedTitleException {
        Scanner scn= new Scanner(System.in);
        String titulo, genero, interpretacion;
        int pistas;
        System.out.println("Ingrese el titulo del disco. (Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios");
        titulo = scn.next();
        g.newDisco(titulo); //revisión de si existe el título o no
        System.out.println("Ingrese el genero del disco. (Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios \n  ");
        genero = scn.next();
        System.out.println("Ingrese el interprete del disco.(Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios \n  ");
        interpretacion = scn.next();
        System.out.println("Ingrese numero de pistas.\n ");
        pistas= getInt("Ingrese numero de pistas","Ingrese una opcion valida",0,40);

        return new Discos(titulo, genero, interpretacion, pistas);
    }

    /**
    * Método para crear una pelicula.
    * @param g                          Donde se almacenará todo el libro
    * @throws RepeatedTitleException    Excepción para titulo repetido
    * @return Peliculas                 Crea película
    */
    public static Peliculas getPelicula (Gestor g) throws RepeatedTitleException {
        Scanner scn= new Scanner(System.in);
        String titulo, genero, actor;
        int fecha;

        System.out.println("Ingrese el titulo de la pelicula.(Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios \n  ");
        titulo = scn.next();
        g.newPelicula(titulo); //revisión de si existe el título o no
        System.out.println("Ingrese el genero de la pelicula. (Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios \n  ");
        genero = scn.next();
        System.out.println("Ingrese el actor o actriz principal de la pelicula. (Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios \n  ");
        actor = scn.next();
        System.out.println("Ingrese el año de filmacion de la pelicula. ");
        fecha = getInt("Ingrese año de filmacion", "Ingresa una opcion valida",0,3333) ;

        return new Peliculas(titulo, genero, actor, fecha);
    }

    public static void main(String args []) throws IllegalSizeException, RepeatedTitleException {
        int principal , secundaria, k, opcion;
        String mensajePrincipal, mensajeLibros,mensajeDiscos, mensajePeliculas, error,aux;
        StringBuilder sb;

        Scanner scn = new Scanner(System.in);
        Gestor g;

        Colors.println("Bienvenido a este programa es un gestor de articulos de entrenenimiento. ", Colors.HIGH_INTENSITY);

        sb = new StringBuilder();
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("1. Gestionar Libros.\n ");
        sb.append("2. Gestionar Discos.\n ");
        sb.append("3. Gestionar Peliculas.\n ");
        sb.append("0. Salir. \n");
        sb.append(Colors.RESTORE);
        mensajePrincipal = sb.toString();
        error ="Por favor ingresa una opcion valida. ";

        sb = new StringBuilder ();
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("1. Consulta por autor.\n ");
        sb.append("2. Consulta por tema.\n ");
        sb.append("3. Consulta por titulo.\n ");
        sb.append("4. Consulta completa.\n ");
        sb.append("5. Añadir libro .\n ");
        sb.append("0. Regresar al menu anterior.\n ");
        sb.append(Colors.RESTORE);
        mensajeLibros = sb.toString();


        ////  MENÚ DISCOS///////////
        sb = new StringBuilder ();
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("1. Consultar los discos de un mismo intérprete dado.\n ");
        sb.append("2. Consultar todos los intérpretes de discos de un mismo género.\n ");
        sb.append("3. Consultar los discos que tengan más de 10 pistas.\n ");
        sb.append("4. Consultar toda la colección.\n ");
        sb.append("5. Agregar un disco.\n ");
        sb.append("0. Regresar al menu anterior.\n ");
        sb.append(Colors.RESTORE);
        mensajeDiscos= sb.toString();

         ////  MENÚ PELICULAS///////////
        sb = new StringBuilder ();
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("1. Consulta el año de la pelicula.\n ");
        sb.append("2. Consultar actor o actriz que salen en mas de una pelicula. \n ");
        sb.append("3. Consultar por genero.\n ");
        sb.append("4. Consulta completa.\n ");
        sb.append("5. Agregar pelicula.\n ");
        sb.append("0. Regresar al menu anterior.\n ");
        sb.append(Colors.RESTORE);
        mensajePeliculas= sb.toString();


        g = new Gestor();
        try {
            do {
                principal = getInt(mensajePrincipal, error,0,3);
                switch (principal){
                    case 1:
                    do{
                        secundaria = getInt(mensajeLibros, error,0,5);
                        switch (secundaria){
                            case 1:
                            System.out.println("Ingrese autor  a buscar; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                            aux = scn.next();
                            g.autor(aux);
                            break;
                            case 2:
                            System.out.println("Ingrese tema a buscar ; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                            aux = scn.next();
                            g.tema(aux);
                            break;
                            case 3:
                            System.out.println("Ingrese titulo a buscar. ; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                            aux= scn.next();
                            g.titulo(aux);
                            break;
                            case 4:
                            g.libros();
                            break;
                            case 5:
                            g.agregarLibro(getLibro(g));
                            break;
                        }
                    } while (secundaria != 0);
                    break;
                    //MENÚ PARA DISCOS
                    case 2:
                    do{
                        secundaria = getInt(mensajeDiscos, error,0,5);
                        switch (secundaria){
                            case 1:
                            //CONSULTAR POR AUTOR
                            System.out.println("Ingrese intérprete a buscar; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                            aux = scn.next();
                            g.interpreteDisco(aux);
                            break;
                            case 2:
                            //CONSULTAR TODOS LOS ARTISTAS POR GÉNERO
                            System.out.println("Ingrese el tipo de género del que quiere consultar todos los intérpretes; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                            aux = scn.next();
                            g.generoDisco(aux);
                            break;
                            case 3:
                            //CONSULTAR  DISCOS CON MÁS DE 10 PISTAS
                            g.recorridoDiez();
                            break;
                            case 4:
                            //CONSULTA COMPLETA
                            g.discos();
                            break;
                            //AÑADIR DISCO
                            case 5:
                            g.agregarDisco(getDisco(g));
                            break;
                        }
                    } while (secundaria != 0);
                    break;

                    case 3:
                   do {

                     secundaria = getInt(mensajePeliculas, error,0,5);
                            switch (secundaria){
                              case 1:
                                    g.fecha(getInt("Ingrese año a buscar", error,0,9999));
                                    break;
                              case 2:
                                    g.actores();
                                    break;
                              case 3:
                                    System.out.println("Ingrese genero a buscar ; Si contiene más de 1 palabra, por favor separalas con guiones y no con espacios ");
                                    aux= scn.next();
                                    g.generoPeliculas(aux);
                                    break;
                              case 4:
                                    g.peliculas();
                                    break;
                              case 5:
                                    g.agregarPeliculas(getPelicula(g));
                                    break;
                             }
                   }while (secundaria !=0);
                   break;
                   default: System.out.println("Vuelve pronto.");
                   break;     

                }
            } while (principal != 0);
        } catch ( Exception e){
            System.out.println(e);
        }
    }
}
