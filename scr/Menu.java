
import java.util.Scanner;

public class Menu {

    /**
     * @param args
     * Menu (UI)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Radio rad = new ElMejorRadioDeLaClase();

        System.out.println("El Mejor Radio");

        while (true) {
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

            if (!rad.getEncendido()) {
                switch (teclado) {
                    case 1:
                        System.out.println("Radio Encendida");
                        rad.encender();
                        break;
                    default:
                        System.out.println("Encienda la radio primero.");
                        break;
                }
            } else {
                switch (teclado) {
                    case 1:
                        System.out.println("Radio ya está encendida.");
                        break;
                    case 2:
                        System.out.println("AM (0) / FM (1)");
                        int band = input.nextInt();
                        rad.cambiarBanda(band);
                        System.out.println("Banda cambiada a " + (band == 0 ? "AM" : "FM"));
                        break;
                    case 3:
                        System.out.println("Volumen: ");
                        int vol = input.nextInt();
                        rad.setVolumen(vol);
                        System.out.println("Volumen cambiado a " + vol);
                        break;
                    case 4:
                        rad.subirEmisora();
                        System.out.println("Emisora subida a " + rad.getEmisora());
                        break;
                    case 5:
                        rad.bajarEmisora();
                        System.out.println("Emisora bajada a " + rad.getEmisora());
                        break;
                    case 6:
                        System.out.println("Seleccione el botón [1-12]");
                        int bot = input.nextInt();
                        rad.guardarEmisora(bot, rad.getEmisora());
                        System.out.println("Emisora guardada en el botón " + bot);
                        break;
                    case 7:
                        System.out.println("Seleccione la Emisora que desea escuchar: ");
                        int emisoraSeleccionada = input.nextInt();
                        rad.seleccionarEmisora(emisoraSeleccionada);
                        System.out.println("Emisora seleccionada desde el botón " + emisoraSeleccionada);
                        break;
                    case 8:
                        System.out.println("Estado Actual Emisora: " + rad.getEmisora());
                        break;
                    case 9:
                        System.out.println("Radio Apagada");
                        rad.apagar();
                        return; // Terminar el programa después de apagar la radio
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
        }
    }
}