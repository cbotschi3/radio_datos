import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ElMejorRadioDeLaClaseTest {

    private ElMejorRadioDeLaClase radio;

    @Before
    public void setUp() {
        radio = new ElMejorRadioDeLaClase();
    }

    @Test
    public void testEncender() {
        assertFalse(radio.estaEncendido);
        radio.encender();
        assertTrue(radio.estaEncendido);
    }

    @Test
    public void testApagar() {
        radio.encender();
        assertTrue(radio.estaEncendido);
        radio.apagar();
        assertFalse(radio.estaEncendido);
    }

    @Test
    public void testSetVolumen() {
        assertEquals(0, radio.volumen);
        radio.setVolumen(5);
        assertEquals(5, radio.volumen);
    }

    @Test
    public void testCambiarBanda() {
        assertTrue(radio.modoAM);
        radio.cambiarBanda(ElMejorRadioDeLaClase.FM);
        assertFalse(radio.modoAM);
    }

    @Test
    public void testSubirEmisora() {
        assertEquals(ElMejorRadioDeLaClase.MINAM, radio.frecuenciaActual, 0.01);
        radio.subirEmisora();
        assertEquals(ElMejorRadioDeLaClase.MINAM + ElMejorRadioDeLaClase.PASOAM, radio.frecuenciaActual, 0.01);
    }

    @Test
    public void testBajarEmisora() {
        assertEquals(ElMejorRadioDeLaClase.MINAM, radio.frecuenciaActual, 0.01);
        radio.bajarEmisora();
        assertEquals(ElMejorRadioDeLaClase.MINAM - ElMejorRadioDeLaClase.PASOAM, radio.frecuenciaActual, 0.01);
    }

    @Test
    public void testGuardarYSeleccionarEmisora() {
        radio.guardarEmisora(0, 100.5f);
        radio.guardarEmisora(1, 95.7f);

        radio.seleccionarEmisora(0);
        assertEquals(100.5f, radio.frecuenciaActual, 0.01);

        radio.seleccionarEmisora(1);
        assertEquals(95.7f, radio.frecuenciaActual, 0.01);
    }
}
