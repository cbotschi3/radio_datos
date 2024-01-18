

public interface Radio {

    public float getEmisora();

    public int getVolumen();

    public boolean getEncendido();

    public int getBanda();

    public void encender();

    public void apagar();

    public void setVolumen(int volumen);

    public void cambiarBandar(int banda);

    public void subirEmisora();

    public void bajarEmisora();

    public void guardarEmisora(int boton, float frecuencia);

    public void seleccionarEmisora(int boton);

}