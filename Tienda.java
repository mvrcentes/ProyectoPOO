/**
 * Write a description of class Tienda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tienda{
    private String nombre;
    private int espacios;
    
    /**
     * Constructor para objetos de la clase Tienda
     */
    public Tienda(String nombre, int espacios){
        this.nombre = nombre;
        this.espacios= espacios;
    }
    
    /**
     * Metodo que devuelve el nombre de la tienda
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Metodo que disminuye los espacios segun cuantas personas lleguen
     * @param int personas
     */
    public void ocuparEspacio(int personas){
        espacios -= personas;
    }
    
    /**
     * Metodo que devuelve los espacios disponibles
     */
    public int espaciosDisponibles(){
        return espacios;
    }
    
}
