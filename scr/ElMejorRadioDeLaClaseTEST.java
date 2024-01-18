import org.junit.Test;

import static org.junit.Assert.*;

public class ElMejorRadioDeLaClaseTEST {

    @Test
    public void testRadio() {
        ElMejorRadioDeLaClase radio = new ElMejorRadioDeLaClase();

        assertFalse(radio.getEncendido());
        assertEquals(0, radio.getVolumen());
        assertEquals(ElMejorRadioDeLaClase.AM, radio.getBanda());
        assertEquals(530f, radio.getEmisora(), 0.01);

        radio.encender();
        assertTrue(radio.getEncendido());

        radio.setVolumen(10);
        assertEquals(10, radio.getVolumen());

        radio.cambiarBandar(ElMejorRadioDeLaClase.FM);
        assertEquals(ElMejorRadioDeLaClase.FM, radio.getBanda());

        radio.subirEmisora();
        assertEquals(88.1f, radio.getEmisora(), 0.01);
        radio.bajarEmisora();
        assertEquals(87.9f, radio.getEmisora(), 0.01);

        radio.guardarEmisora(0, 95.5f);
        radio.seleccionarEmisora(0);
        assertEquals(95.5f, radio.getEmisora(), 0.01);

    }
}