import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testMenu() {
        ElMejorRadioDeLaClase radio = new ElMejorRadioDeLaClase();
        //Menu menu = new Menu();

        assertFalse(radio.getEncendido());
        Menu.main(null);
        assertFalse(radio.getEncendido());

        Menu.main(null); 
        assertTrue(radio.getEncendido());

        Menu.main(new String[]{"2"});
        assertEquals(ElMejorRadioDeLaClase.FM, radio.getBanda());

        float emisoraAntes = radio.getEmisora();
        Menu.main(new String[]{"4"});
        assertTrue(radio.getEmisora() > emisoraAntes);

        emisoraAntes = radio.getEmisora();
        Menu.main(new String[]{"5"});
        assertTrue(radio.getEmisora() < emisoraAntes);

        Menu.main(new String[]{"6"});
        assertEquals(radio.getEmisora(), radio.botones[1], 0.01);

        float emisoraGuardada = radio.botones[1];
        Menu.main(new String[]{"7"});
        assertEquals(emisoraGuardada, radio.getEmisora(), 0.01);

        Menu.main(new String[]{"8"});

        Menu.main(new String[]{"9"});
        assertFalse(radio.getEncendido());
    }
}
