
/**
 * Clase Reporte
 *
 * @author Andres Quezada 21085
 * @version 29-09-21
 */
import java.util.*;
public class Reporte{
    private boolean estado;
    
    /**
     * Constructor for objects of class Reporte
     */
    public Reporte(){
        this.estado = false;
    }

    /**
     * Metodo que sirve para determinar el estado del usuario, entre positivo y negativo segun
     * la respuesta a las preguntas del usuario,
     * @param respuestas de las 3 preguntas
     * @return el mensaje correspondiente al resultado
     */
    public String ReporteDiario(String rp1,String rp2, String rp3){
        estado = false;
        if (rp1.contains("si")||rp2.contains("si")||rp3.contains("si")){
            estado = true;
        }
        String mensaje = "";
        if (estado == true){
            mensaje += "\nExiste la posibilidad de que usted padezca de COVID19, vaya a hacerse una prueba y tome las precuaciones necesarias.\n";
        }else if (estado == false){
            mensaje += "\nLa posibilidad de que usted padezca de COVID19 es baja, para estar 100% seguro hagase una prueba medica.\n";
        }
        return mensaje;
    }

}
