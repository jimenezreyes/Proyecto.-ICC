package icc.gestor;
import icc.colecciones.Libro;
import icc.io.ReaderWriter;
import icc.excepciones.IllegalSizeException;
import icc.excepciones.RepeatedTitleException;
import icc.colecciones.Discos;
import icc.colecciones.Peliculas;
import icc.colecciones.Compartir;

/**
* Clase que se encarga de, como el nombre lo dice, gestionar los datos dependiendo de la colección seleccionada
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

public class Gestor{

    public static final int SIZE=32; //límite impuesto

    private String file_libros;
    private Libro col_libros[]; //colección de libros
    private int index_libros; //variable extra para llevar el conteo de libros
    String titulo;

    ///////////////////// PARA DISCOS /////////////////////////
    private String file_discos;
    private Discos col_discos[]; //colección de discos
    private int index_discos; //variable extra para llevar el conteo de discos
    String genero;
    int pistas;

     ///////////////////// PARA PELICULAS/////////////////////////
    private String file_peliculas;
    private Peliculas col_peliculas[];
    private int index_peliculas;
    public Gestor(){
    ///////////////////// PARA ARCHIVOS CSV/////////////////////////

        file_libros="libros.csv";
        loadLibros();

        file_discos="discos.csv";
        loadDiscos();

        file_peliculas="peliculas.csv";
        loadPeliculas();
    }

    /**
    * Método para cargar a un archivo libros.csv los datos que se ingresen por teclado
    */

    private void loadLibros(){
        //cambiar parametro
        String[]libros=ReaderWriter.read(file_libros,SIZE);
        String[]array;

        index_libros=0; //nos impone cuantos libros ya tenemos agregados

        col_libros=new Libro[SIZE];
        //preguntamos por el índice
        //indice obtenido con el ++
        while(index_libros<SIZE && libros[index_libros]!=null){
            array=libros[index_libros].split(",");
            col_libros[index_libros++]=new Libro(array[0],array[1],array[2],array[3]);
        }
    }

    /**
    * Impresión del título para los libros
    * de los que encajen con el título ingresado
    * @param aux Lo ingresado por teclado
    */
    public void titulo (String aux){
        System.out.println();
        for (int i=0; i<index_libros;i++){
            if (col_libros[i].titulo(aux)){
                System.out.println(col_libros[i]);
                System.out.println();
            }
        }
    }
    /**
    * Impresión del tema para los libros
    * de los que encajen con el tema ingresado
    * @param aux Lo ingresado por teclado
    */
    public void tema (String aux){
        System.out.println();
        for (int i=0; i<index_libros;i++){
            if (col_libros[i].tema(aux)){
                System.out.println(col_libros[i]);
                System.out.println();
            }
        }
    }


    /**
    * Impresión del autor para los libros
    * de los que encajen con el autor ingresado
    * @param aux Lo ingresado por teclado
    */
    public void autor (String aux){
        System.out.println();
        //delegamos trabajo a libros
        for (int i=0; i<index_libros;i++){
            if (col_libros[i].autor(aux)){
                System.out.println(col_libros[i]);
                System.out.println();
            }
        }
    }

    /**
    * Método que se encarga de realizar la consulta de toda la colección
    */
    public void libros () {
        System.out.println();
        for (int i=0; i<index_libros;i++){
            System.out.println(col_libros[i]);
            System.out.println(); //vuelta de carro
        }
    }



    /**
    * Método encargado de revisar si existe el título o no
    * Si se repite el título, se detiene la ejecución del programa
    * y lanza una excepción
    * @param aux                        Titulo ingresado por teclado
    * @throws RepeatedTitleException    Excepción para titulo repetido
    */
    public void newLibro(String aux) throws RepeatedTitleException{
        for (int i=0;i<index_libros;i++) {
            if (col_libros[i].titulo(aux)){
                throw new RepeatedTitleException("Título Repetido");
            }
        }
    }
    /**
    * Método encargado de revisar si el indices de libros que lleva el conteo de la cantidad
    * de libros ya llegó a SIZE, significa que ya tengo el número de libros máximo
    *
    * Se agrega al arreglo de libros y al archivo
    *
    * @param aux                       Lo ingresado por teclado
    * @throws IllegalSizeException    Excepción para capacidad máxima alcanzada
    */
    public void agregarLibro(Libro aux) throws IllegalSizeException {
        if(index_libros==SIZE)
        throw new IllegalSizeException("Capacidad máxima alcanzada");
        col_libros[index_libros++]=aux; //agrega el libro al arreglo 13:11
        ReaderWriter.write(aux.toFile(),file_libros); //13:26
    }


    ///////////////////// PARA DISCOS /////////////////////////


    /**
    * Método para cargar a un archivo disco.csv los datos que se ingresen por teclado
    */

    private void loadDiscos(){
        //cambiar parametro
        String[]discos=ReaderWriter.read(file_discos,SIZE);
        String[]arrayDiscos;

        index_discos=0; //nos impone cuantos discos ya tenemos agregados

        col_discos=new Discos[SIZE];
        while(index_discos<SIZE && discos[index_discos]!=null){
            arrayDiscos=discos[index_discos].split(",");
            col_discos[index_discos++]=new Discos(arrayDiscos[0],arrayDiscos[1],arrayDiscos[2], Integer.valueOf(arrayDiscos[3]).intValue() );
        }
    }

    /**
    * Método para revisar si el titulo ingresado es igual al que teníamos
    * @param aux        Lo ingresado por teclado
    * @return titulo    Si el título es igual
    */

    public boolean tituloDisco(String aux){
        return titulo.equals(aux);
    }


    /**
    * Impresión de aquellos discos
    * que encajen con el género ingresado
    * @param aux Género ingresado por teclado
    */

    public void generoDisco (String aux){
        System.out.println();
        for (int i=0; i<index_discos;i++){
            if (col_discos[i].genero(aux)){
                System.out.println(col_discos[i]);
                System.out.println();
            }
        }
    }


    /**
    * Método para la opción 3 del menú de discos.
    * Recorre los discos para revisar la cantidad de pistas de cada uno,
    * si sus pistas son mayor a 10, imprime el disco.
    * @return true          Imprime el disco
    */
    public boolean recorridoDiez(){
        System.out.println();
        for (int i=0; i<index_discos;i++){
            if (col_discos[i].pistasDiez( )){
                System.out.println(col_discos[i]);
                System.out.println();
            }
        } return true;
    }


    /**
    * Impresión del interprete para los discos
    * de los que encajen con el interprete ingresado
    * @param aux Lo ingresado por teclado
    */
    public void interpreteDisco (String aux){
        System.out.println();
        //delegamos trabajo a discos
        for (int i=0; i<index_discos;i++){
            if (col_discos[i].interprete(aux)){
                System.out.println(col_discos[i]);
                System.out.println();
            }
        }
    }

    /**
    * Método que se encarga de realizar la consulta de toda la colección
    */
    public void discos () {
        System.out.println();
        for (int i=0; i<index_discos;i++){
            System.out.println(col_discos[i]);
            System.out.println(); //vuelta de carro
        }
    }



    /**
    * Método encargado de revisar si existe el título o no
    * Si se repite el título, se detiene la ejecución del programa
    * y lanza una excepción
    * @param aux                         Lo ingresado por teclado
    * @throws RepeatedTitleException    Excepción para titulo repetido
    */
    public void newDisco(String aux) throws RepeatedTitleException{
        for (int i=0;i<index_discos;i++) {
            if (col_discos[i].titulo(aux)){
                throw new RepeatedTitleException("Título Repetido");
            }
        }
    }

    /**
    * Método encargado de revisar si el indices de discos que lleva el conteo de la cantidad
    * de discos ya llegó a SIZE, significa que ya tengo el número de discos máximo
    *
    * Se agrega al arreglo de discos y al archivo
    * @param aux                        Disco ingresado por teclado
    * @throws IllegalSizeException    Excepción para capacidad máxima alcanzada
    */
    public void agregarDisco(Discos aux) throws IllegalSizeException {
        if(index_discos==SIZE)
        throw new IllegalSizeException("Capacidad máxima alcanzada");
        col_discos[index_discos++]=aux; //agrega el libro al arreglo 13:11
        ReaderWriter.write(aux.toFile(),file_discos); //13:26
    }

     ///////////////////// PARA PELICULAS /////////////////////////

    /**
    * Método para cargar a un archivo peliculas.csv los datos que se ingresen por teclado
    */
    private void loadPeliculas(){
        String[]peliculas=ReaderWriter.read(file_peliculas,SIZE);
        String[]arrayP;

        index_peliculas=0; //nos impone cuantas peliculas ya tenemos agregados

        col_peliculas=new Peliculas[SIZE];
        while(index_peliculas<SIZE && peliculas[index_peliculas]!=null){
            arrayP=peliculas[index_peliculas].split(",");
            col_peliculas[index_peliculas++]=new Peliculas(arrayP[0],arrayP[1],arrayP[2], Integer.valueOf(arrayP[3]).intValue() );
        }
    }


    /**
    * Método que se encarga de realizar la consulta de toda la colección
    */
    public void peliculas () {
        System.out.println();
        for (int i=0; i<index_peliculas;i++){
            System.out.println(col_peliculas[i]);
            System.out.println(); //vuelta de carro
        }
    }

    /**
    * Método encargado de revisar si existe el título o no
    * Si se repite el título, se detiene la ejecución del programa
    * y lanza una excepción
    * @param aux                        Lo ingresado por teclado
    * @throws RepeatedTitleException    Excepción para titulo repetido
    */
    public void newPelicula(String aux) throws RepeatedTitleException{
        for (int i=0;i<index_peliculas;i++) {
            if (col_peliculas[i].titulos(aux)){
                throw new RepeatedTitleException("Título Repetido. ");
            }
        }
    }

    /**
    * Método encargado de revisar si el indices de discos que lleva el conteo de la cantidad
    * de peliculas ya llegó a SIZE, significa que ya tengo el número de peliculas máximo
    * Se agrega al arreglo de peliculas y al archivo
    * @param aux                      Lo ingresado por teclado
    * @throws IllegalSizeException    Excepción para capacidad máxima alcanzada
    */

    public void agregarPeliculas(Peliculas aux) throws IllegalSizeException {
        if(index_peliculas==SIZE)
        throw new IllegalSizeException("Capacidad máxima alcanzada.");
        col_peliculas[index_peliculas++]=aux; //agrega la pelicula al arreglo 13:11
        ReaderWriter.write(aux.toFile(),file_peliculas); //13:26
    }
    

    /**
    * Metodo para guardar el año de una pelicula
    * @param aux el año ingresado por teclado
    */
    public void fecha (int aux){
        for (int i=0; i<index_peliculas;i++){
            if (col_peliculas[i].fecha(aux)) {
                System.out.println(col_peliculas[i]);
                System.out.println();
            }
        }
    }
    
    /**
    * Metodo para saber si tenemos un actor
    * o actriz que aparecen en mas de una pelicula
    */
    public void actores (){ 
    boolean[] actor = new boolean[index_peliculas];
        for(int i=0;i<index_peliculas;i++){
            for(int j=i+1;j<index_peliculas;j++){
                if(col_peliculas[i].actor().equals(col_peliculas[j].actor())){
                    actor[i]=true;
                    actor[j]=true;
                }
            }
        }
        for(int i=0;i<index_peliculas;i++){
            if(actor[i]){
                System.out.println(col_peliculas[i]+ "\n");
            }
        }
    }                           
    
    
        /**
        * Impresión de las peliculas
        * que encajen con el género ingresado
        * @param aux Género ingresado por teclado
        */
        public void generoPeliculas (String aux){
        System.out.println();
        for (int i=0; i<index_peliculas;i++){
            if (col_peliculas[i].genero(aux)){
                System.out.println(col_peliculas[i]);
                System.out.println();
            }
        }
    }
}
