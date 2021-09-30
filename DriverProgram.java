import java.util.*;
/**
 * Programa Principal en donde se ejecutara el menu
 * @author Javier Luis Angel Chavez Escobar 21016
 */

public class DriverProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        manipulacionArchivo tiendasOakland = new manipulacionArchivo("Oakland.txt");
        manipulacionArchivo tiendasMiraflores = new manipulacionArchivo("Miraflores.txt");
    
        Comercial OaklandMall = new Comercial("Oakland Mall", tiendasOakland.generarListadoTiendas());
        Comercial MirafloresMall = new Comercial("Miraflores", tiendasMiraflores.generarListadoTiendas());
        
        Reporte reportador = new Reporte();
        Noticias noticiero = new Noticias();
        
        while(!salir){
            System.out.println("\n1. Asistir a una tienda en un comercial");
            System.out.println("2. Reporte Diario");
            System.out.println("3. Noticias");
            System.out.println("4. -");
            System.out.println("5. Salir"); //simulador
            try {
                System.out.println("Opcion -> ");
                opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        /**
                         * 
                         */
                        //mira o oakland
                        //mostrar tiendas del comercial elegido
                        //recibir tienda y no. de personas
                        //asistirComercial
                        System.out.println( "\n\t\t\tComerciales Disponibles" );
                        System.out.print(OaklandMall.toString());
                        System.out.println(MirafloresMall.toString() );
                        int comercialElegido;
                        do{
                            System.out.println( "A cual deseas asistir? 1 o 2" );
                            comercialElegido = input.nextInt();
                            input.nextLine();
                        }while(comercialElegido > 2 || comercialElegido < 0 );
                        
                        
                        if(comercialElegido == 1){
                            System.out.println(OaklandMall.tiendasEnElComercial());
                            System.out.println( "A cual deseas asistir? (escribir igual)" );
                            String queTienda = input.nextLine();
                            System.out.println( "Cuantos van asistir? " );
                            int cuantasPersonas = input.nextInt();
                            input.nextLine();
                            System.out.println(OaklandMall.asistirTienda(queTienda, cuantasPersonas));
                        }else if(comercialElegido == 2){
                            System.out.println(MirafloresMall.tiendasEnElComercial());
                            System.out.println( "A cual deseas asistir? (escribir igual)" );
                            String queTienda = input.nextLine();
                            System.out.println( "Cuantos van asistir? " );
                            int cuantasPersonas = input.nextInt();
                            input.nextLine();
                            System.out.println(MirafloresMall.asistirTienda(queTienda, cuantasPersonas));
                        }
                        break;
                    case 2:
                        /**
                         * 
                         */
                        System.out.println( "\nPorfavor responda con 'si' o 'no' a las siguientes preguntas:" );
                        System.out.println( "En los últimos días ha mostrado alguno de los siguientes síntomas: fiebre, tos, congestión o problemas respiratorios?" );
                        String rp1 = input.nextLine();
                        System.out.println( "Ha estado en contacto recientemente con alguien que se haya contagiado de COVID-19?" );
                        String rp2 = input.nextLine();
                        System.out.println( "Ha diagnosticado como positivo en una prueba de COVID-19?" );
                        String rp3 = input.nextLine();
                        String mensaje = reportador.ReporteDiario(rp1, rp2, rp3);
                        if(!mensaje.equals("")){
                            System.out.println( mensaje );
                        }
                        break;
                    case 3:
                        /**
                         * 
                         */
                        try{
                            noticiero.PopUpNoticias();
                        }catch(Exception e){
                            System.out.println( e );
                        }
                        
                        break;
                    case 4:
                        /**
                         * 
                         */
                        break;
                    case 5:
                        /**
                         * Para salir del ciclo while
                         */
                        System.out.println("**********************************\n");
                        System.out.println("\tGracias por usar el programa :)\n");
                        System.out.println("**********************************\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingresa una opcion valida\n");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("\nDebes insertar un número\n");
                input.next();
            }
        }
    }
}