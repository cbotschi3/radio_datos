

public class ElMejorRadioDeLaClase implements Radio {

    private boolean estaEncendido;
    private int volumen;
    private boolean modoAM;
    private float frecuenciaActual;
    private float ultimaFrecuenciaAM;
    private float ultimaFrecuenciaFM;
    float botones[];

    private final static float MINAM = 530f;
    private final static float MAXAM = 1610f;
    private final static float PASOAM = 10f;
    private final static float MINFM = 87.9f;
    private final static float MAXFM = 107.9f;
    private final static float PASOFM = 0.2f;

    public final static int AM = 0;
    public final static int FM = 1;

    /**
     * 
     */
    public ElMejorRadioDeLaClase() {
        estaEncendido = false;
        volumen = 0;
        modoAM = true;
        frecuenciaActual = MINAM;
        ultimaFrecuenciaAM = MAXAM;
        botones = new float[12];
    }

    public float getEmisora() {
        return frecuenciaActual;
    }

    public int getVolumen() {
        return volumen;
    }

    public boolean getEncendido() {
        return estaEncendido;
    }

    public int getBanda() {
        if (modoAM) {
            return AM;
        } else {
            return FM;
        }
    }

    /**
     * encuende el radio
     */
    public void encender() {
        estaEncendido = true;
    }

    /**
     * Apaga Radio
     */
    public void apagar() {
        estaEncendido = false;
    }

    /**
     * @param volumen
     * Sube el volumen seleccionado en el parametro
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    /**
     * @param banda
     * cambia la banda por medio de un true y un false
     */
    public void cambiarBanda(int banda) {
        if (banda == AM && !modoAM) {
            ultimaFrecuenciaFM = frecuenciaActual;
            frecuenciaActual = ultimaFrecuenciaAM;
            modoAM = true;
        } else if (banda == FM && modoAM) {
            ultimaFrecuenciaAM = frecuenciaActual;
            frecuenciaActual = ultimaFrecuenciaFM;
            modoAM = false;
        }
    }

    /**
     * sube la emisora segun los requerimientos en cada una (am/fm)
     */
    public void subirEmisora() {
        if (modoAM) {
            frecuenciaActual += PASOAM;
            if (frecuenciaActual >= MAXAM) {
                frecuenciaActual = MAXAM;
            }
        } else {
            frecuenciaActual += PASOFM;
            if (frecuenciaActual >= MAXFM) {
                frecuenciaActual = MAXFM;
            }
        }
    }

    /**
     * Baja emisora segun los requerimientos de cada una (am/fm)
     */
    public void bajarEmisora() {
        if (modoAM) {
            frecuenciaActual -= PASOAM;
            if (frecuenciaActual <= MINAM) {
                frecuenciaActual = MINAM;
            }
        } else {
            frecuenciaActual -= PASOFM;
            if (frecuenciaActual <= MINFM) {
                frecuenciaActual = MINFM;
            }
        }
    }

    /**
     * @param boton
     * @param frecuencia
     * guarda emisora dentro de un arreglo
     */
    public void guardarEmisora(int boton, float frecuencia) {
        if (boton >= 0 && boton <= 11) {
            botones[boton] = frecuencia;
        }
    }

    /**
     * @param boton
     * selecciona la emisora de dicho boton seleccionado por el parametro int
     */
    public void seleccionarEmisora(int boton) {
        float frecuenciaBoton = botones[boton];
        if (frecuenciaBoton != 0.0f) {
            if (frecuenciaBoton >= 530 && frecuenciaBoton <= 1610) {
                if (modoAM) {
                    frecuenciaActual = frecuenciaBoton;
                } else {
                    ultimaFrecuenciaFM = frecuenciaActual;
                    frecuenciaActual = frecuenciaBoton;
                    modoAM = true;
                }
            } else if (frecuenciaBoton >= 87.9 && frecuenciaBoton <= 107.9) {
                if (!modoAM) {
                    frecuenciaActual = frecuenciaBoton;
                } else {
                    ultimaFrecuenciaAM = frecuenciaActual;
                    frecuenciaActual = frecuenciaBoton;
                    modoAM = false;
                }
            }
        }
    }

}