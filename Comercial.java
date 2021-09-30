import java.util.ArrayList;

/**
 * Write a description of class Comercial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comercial{
    private String nombre;
    private int cantidadTiendas, capacidadTotalComercial;
    private ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>();
    
    /**
     * Constructor para objetos de la clase Comercial
     * @param String nombre
     * @param ArrayList<Tienda> listaTiendas
     */
    public Comercial(String nombre, ArrayList<Tienda> listaTiendas){
        this.nombre = nombre;
        this.listaTiendas = listaTiendas;
        this.cantidadTiendas = listaTiendas.size();
        
        this.capacidadTotalComercial = 0;
        for(Tienda tienda: listaTiendas){
            this.capacidadTotalComercial += tienda.espaciosDisponibles();
        }
    }
    
    /**
     * Metodo que recibe la tienda en texto a la cual se desea asistir con la cantidad de personas que acompanan
     * @param String queTienda
     * @param int cuantasPersonas
     */
    public String asistirTienda(String queTienda, int cuantasPersonas){
        String mensaje = "";
        for(Tienda tienda: listaTiendas){
            if(tienda.getNombre().equals(queTienda)){
                if(tienda.espaciosDisponibles() >= cuantasPersonas){
                    tienda.ocuparEspacio(cuantasPersonas);
                    mensaje += "Usted puede asistir con " + cuantasPersonas + " personas a "+ queTienda;
                }else{
                    mensaje += "No hay espacio suficiente en "+ queTienda +" para que asistan "+ cuantasPersonas + "personas";
                }
            }
            //else{
            //    mensaje += "La tienda ingresada está incorrecta";
            //}
        }
        return mensaje;
    }
    
    /**
     * Metodo que da un formato para mostrar las tiendas que contiene el comercial
     */
    public String tiendasEnElComercial(){
        String tiendas = "\nTiendas disponibles en *" + nombre + "* y su respectivo espacio disponible. \n";
        for(Tienda tienda : listaTiendas){
            tiendas += "\t["+tienda.getNombre()+"]";
        }
        tiendas += "\n";
        for(Tienda tienda : listaTiendas){
            tiendas += "\t["+tienda.espaciosDisponibles()+"]";
        }
        return tiendas;
    }
    
    /**
     * Metodo toString para mostrar con un formato las tiendas y sus caracteristicas
     */
    public String toString(){
        int espacioDisponible = 0;
        for(Tienda tienda: listaTiendas){
            espacioDisponible += tienda.espaciosDisponibles();
        }
        return "\n\t\t*"+nombre+"*"+"\tNo. Tiendas: "+cantidadTiendas + "\tEspacio Total: "+ capacidadTotalComercial + "\tEspacio Disponible: " + espacioDisponible;
    }
    // -------------- FUNCIONES DE GRAFICAS

}
