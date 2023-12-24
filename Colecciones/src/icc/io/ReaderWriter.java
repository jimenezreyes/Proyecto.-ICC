package icc.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

/**
* Representacion para escribir texto y almacenarlo.
* @author Etni Castro
* @author Abraham Jiménez Reyes
* @version 30/Ene/2022
* @since ICC-java
*/

/**
* Clase para escribir textos
*/

public class ReaderWriter{
    public static void write (String line, String fileName){

        /** inicio el null */
        FileWriter out= null;
        //Secuencia de enunciados/
        try{
            out=new FileWriter(fileName, true);
            out.write(line);
            out.write("\n");
        } catch (IOException e){
            System.out.println(e);
        }finally{
            try{
                if(out!=null){
                    out.close();
                }
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }


    public static String[] read(String fileName, int size){
        /** inicio el null*/
        BufferedReader in=null;
        String[]array=new String[size];

        try{
            in= new BufferedReader(new FileReader(fileName));
            for(int i=0;i<size;i++){
                array[i]=in.readLine();
                if(array[i]==null) break;
            }
        }catch (IOException e){
            System.out.println(e);
        }finally{
            try{
                if(in!=null){
                    in.close();
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }
        return array;
    }
}
