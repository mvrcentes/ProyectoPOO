import java.io.*;
import java.util.*;

/**
 * Clase encargada de la manipulacion de archivos.
 * @author Javier Luis Angel Chavez Escobar 21016
 */
public class manipulacionArchivo{
    private String cadena;
    private File archivo;
    private FileReader leer;
    private FileWriter escribir;
    private PrintWriter linea;
    private BufferedReader almacenamiento;
    private String texto;
    
    /**
     * Constructor para objetos de la clase manipulacionArchivo
     * @param miArchivo
     */
    public manipulacionArchivo(String miArchivo){
        archivo = new File(miArchivo);
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                leer = new FileReader(archivo);
                almacenamiento = new BufferedReader(leer);
                cadena = "";
                while(cadena!=null){
                    try{
                        cadena = almacenamiento.readLine();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                almacenamiento.close();
                leer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Funcion que devuelve una lista de tipo Tienda con los datos obtenidos del csv.
     */
    public ArrayList<Tienda> generarListadoTiendas(){
        List<List<String>> lines = new ArrayList<>();
        try{
                Scanner inputStream = new Scanner(archivo);
                while(inputStream.hasNext()){
                    String line= inputStream.next();
                    String[] values = line.split(System.getProperty("line.separator"));
                    lines.add(Arrays.asList(values));
                }
                inputStream.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        
        ArrayList<Tienda> listadoTiendasFinal = new ArrayList<Tienda>();
        
        for(List<String> line: lines) {
            for (String value: line) {
                String[] partes = value.split(",");
                String nombrePrograma = partes[0]; 
                String espacioOcupaString = partes[1];
                int espacioOcupaInt = Integer.parseInt(espacioOcupaString);
                //String nombre, int espacios
                listadoTiendasFinal.add( new Tienda(nombrePrograma, espacioOcupaInt) );
            }
        }        
        
        return listadoTiendasFinal;
    }
    
    public String leer(){
        /**
         * Funcion que permite leer el contenido del archivo
         */
        texto = "";
        try {
            Scanner myReader = new Scanner(archivo);
            while (myReader.hasNextLine()) {
                texto += myReader.nextLine() + "\n";
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return texto;
    }
    
    public void escribir(String texto){
        /**
         * Funcion que permite escribir en el archivo
         */
        if(archivo.exists()){
            try{
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                linea.println(texto);
                linea.close();
                escribir.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
