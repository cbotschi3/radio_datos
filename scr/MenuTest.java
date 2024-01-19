import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {

    /**
     * Test de clase Menu
     */
    @Test
    public void testMenu() {
        ElMejorRadioDeLaClase radio = new ElMejorRadioDeLaClase();
        Menu menu = new Menu();

        assertFalse(radio.getEncendido());
        menu.main(null);
        assertFalse(radio.getEncendido());

        menu.main(null); 
        assertTrue(radio.getEncendido());

        menu.main(new String[]{"2"});
        assertEquals(ElMejorRadioDeLaClase.FM, radio.getBanda());

        float emisoraAntes = radio.getEmisora();
        menu.main(new String[]{"4"});
        assertTrue(radio.getEmisora() > emisoraAntes);

        emisoraAntes = radio.getEmisora();
        menu.main(new String[]{"5"});
        assertTrue(radio.getEmisora() < emisoraAntes);

        menu.main(new String[]{"6"});
        assertEquals(radio.getEmisora(), radio.botones[1], 0.01);

        float emisoraGuardada = radio.botones[1];
        menu.main(new String[]{"7"});
        assertEquals(emisoraGuardada, radio.getEmisora(), 0.01);

        menu.main(new String[]{"8"});

        menu.main(new String[]{"9"});
        assertFalse(radio.getEncendido());
    }
}
