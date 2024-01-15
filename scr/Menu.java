package scr;

import java.util.Scanner;

public class Menu {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Radio rad = new ElMejorRadioDeLaClase();


        System.out.println("El Mejor Radio");
        System.out.println("1. Encender");
        System.out.println("2. Cambiar Banda");
        System.out.println("3. Volumen");
        System.out.println("4. Subir Emisora");
        System.out.println("5. Bajar Emisora");
        System.out.println("6. Guardar Emisora");
        System.out.println("7. Seleccionar Emisora");
        System.out.println("8. Estado Actual Emisora");
        System.out.println("9. Apagar");
        int teclado = input.nextInt();
        
        if(rad.getEncendido()){

            switch (teclado) {
                case 1:
                    System.out.println("Radio Encendida");
                    rad.encender();
                    break;

                case 2:
                    System.out.println("AM (0) / FM (1)");
                    int band = input.nextInt();
                    rad.cambiarBandar(band);

                case 3:
                    System.out.println("Volumen: ");
                    int vol = input.nextInt();
                    rad.setVolumen(vol);
                    break;

                case 4:
                    rad.subirEmisora();
                    break;

                case 5:
                    rad.bajarEmisora();
                    break;

                case 6:
                    System.out.println("Seleccione el boton [1-12]");
                    int bot = input.nextInt();
                    rad.guardarEmisora(bot, rad.getBanda());
                    break;

                case 7:
                    System.out.println("Seleccione la Emisora que decea escuchas: ");
                    int emisoras = input.nextInt();
                    rad.seleccionarEmisora(emisoras);
                    break;

                case 8:
                    System.out.println("Estado Actual Emisora");
                    //BestRadio.ElMejorRadioDeLaClase();
                    break;

                case 9:
                    System.out.println("Radio Apagada");
                    rad.apagar();
                    break;

                default:
                    break;

            }
        }
        else if (rad.getEncendido()){
            System.out.println("Sistema de Radio Apagado...");
        }
    }

}
