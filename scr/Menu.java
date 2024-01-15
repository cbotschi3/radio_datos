package scr;

import scr.Radio;
import java.util.Scanner;

public class Menu implements Radio {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ElMejorRadioDeLaClase BestRadio = new ElMejorRadioDeLaClase();
        boolean estadoEncendido = BestRadio.getEncendido();

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

        switch (teclado) {
            case 1:
                System.out.println("Radio Encendida");
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
                System.out.println("Seleccione la Emisora que decea escuchas: ");
                int emisoras = input.nextInt();
                BestRadio.seleccionarEmisora(emisoras);
                break;

            case 8:
                System.out.println("Estado Actual Emisora");
                BestRadio.ElMejorRadio();
                break;

            case 9:
                System.out.println("Radio Apagada");
                BestRadio.apagar();
                break;

            default:
                break;

        }

    }

}
