
/**
 * interface Radio implementada en clase ElMejorRadioDeLaClase
 */
public interface Radio {

    /**
     * @return
     */
    public float getEmisora();

    /**
     * @return
     */
    public int getVolumen();

    /**
     * @return
     */
    public boolean getEncendido();

    /**
     * @return
     */
    public int getBanda();

    /**
     * 
     */
    public void encender();

    /**
     * 
     */
    public void apagar();

    /**
     * @param volumen
     */
    public void setVolumen(int volumen);

    /**
     * @param banda
     */
    public void cambiarBanda(int banda);

    /**
     * 
     */
    public void subirEmisora();

    /**
     * 
     */
    public void bajarEmisora();

    /**
     * @param boton
     * @param frecuencia
     */
    public void guardarEmisora(int boton, float frecuencia);

    /**
     * @param boton
     */
    public void seleccionarEmisora(int boton);

}