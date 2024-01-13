package scr;

import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ElMejorRadioDeLaClase BestRadio = new ElMejorRadioDeLaClase();

        System.out.println("El Mejor Radio");
        System.out.println("1. Encender");
        System.out.println("2. Cambiar Banda");
        System.out.println("3. Volumen");
        System.out.println("4. Subir Emisora");
        System.out.println("5. Bajar Emisora");
        System.out.println("6. Guardar Emisora");
        System.out.println("7. Apagar");
        int teclado = input.nextInt();

        if(estaEncendido = true){

            switch (teclado) {
                case 1:
                    BestRadio.encender();
                    break;
                
                case 2:
                    System.out.println("AM (0) / FM (1)");
                    int band = input.nextInt();  
                    BestRadio.cambiarBandar(band);
    
                case 3:
                    System.out.println("Volumen: ");
                    int vol = input.nextInt();
                    BestRadio.setVolumen(vol);
                    break;
    
                case 4:
                    BestRadio.subirEmisora();
                    break;
    
                case 5:
                    BestRadio.bajarEmisora();
                    break;
    
                case 6:
                    System.out.println("Seleccione el boton [1-12]");
                    int bot = input.nextInt();
                    BestRadio.guardarEmisora(bot, BestRadio.getFrecuenciaActual());
                    break;
    
                case 7:
                    BestRadio.apagar();
                    break;
            
                default:
                    break;
            } if (estaEncendido = false){

            }

        }
        


    }
}
