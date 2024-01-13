public class ElMejorRadioDeLaClase implements Radio{

    private boolean estaEncendido;
    private int volumen;
    private boolean modoAM;
    private float frecuenciaActual;
    private float ultimaFrecuenciaAM;
    private float ultimaFrecuenciaFM;
    private float botones[];

    private final static float MINAM = 530f;
    private final static float MAXAM = 1610f;
    private final static float PASOAM = 10f;
    private final static float MINFM = 87.9f;
    private final static float MAXFM = 107.9f;
    private final static float PASOFM = 0.2f;
    private final static int MINVOLUMEN = 0;
    private final static int MAXVOLUMEN = 100;

    public final static int AM = 0;
    public final static int FM = 1;

    public void ElMejorRadio(){  
        estaEncendido = false;
        volumen = 0;
        modoAM = true;
        frecuenciaActual = MINAM;
        ultimaFrecuenciaAM = MINAM;
        botones = new float[12]; 
    }

    @Override
    public float getEmisora(){
        return frecuenciaActual;
    }

    @Override
    public int getVolumen(){
        return volumen;
    }

    @Override
    public boolean getEncendido(){
        return estaEncendido;
    }


    //Este método retorna un int ya que en clase se definió que 0 equivale a AM y 1 a FM
    @Override
    public int getBanda(){
        if(modoAM){
            return AM;
        }else{
            return FM;
        }
    }

    @Override
    public void encender(){
        estaEncendido = true;
    }

    @Override
    public void apagar(){
        estaEncendido = false;
    }

    @Override
    public void setVolumen(int volumen){
        if(volumen <= MINVOLUMEN){
            this.volumen = MINVOLUMEN;
        }
        else if(volumen >= MAXVOLUMEN){
            this.volumen = MAXVOLUMEN;

        }else{
            this.volumen = volumen;
        }
        
    }

    @Override
    public void cambiarBandar(int banda){
        if(banda == AM && !modoAM){
            ultimaFrecuenciaFM = frecuenciaActual;
            frecuenciaActual = ultimaFrecuenciaAM;
            modoAM = true;
        }
        else if(banda == FM  && modoAM){
            ultimaFrecuenciaAM = frecuenciaActual;
            frecuenciaActual = ultimaFrecuenciaFM;
            modoAM = false;
        }
    }

    @Override
    public void subirEmisora(){
        if(modoAM){
            frecuenciaActual += PASOAM;
            if(frecuenciaActual >= MAXAM){
                frecuenciaActual = MAXAM;
            }
        }
        else{
            frecuenciaActual += PASOFM;
            if(frecuenciaActual >= MAXFM){
                frecuenciaActual = MAXFM;
            }
        }
    }

    @Override
    public void bajarEmisora(){
        if(modoAM){
            frecuenciaActual -= PASOAM;
            if(frecuenciaActual <= MINAM){
                frecuenciaActual = MINAM;
            }
        }
        else{
            frecuenciaActual -= PASOFM;
            if(frecuenciaActual <= MINFM){
                frecuenciaActual = MINFM;
            }
        }
    }

    @Override
    public void guardarEmisora(int boton, float frecuencia){
        if(boton >= 0 && boton <= 11){
            botones[boton] = frecuencia;
        }
    }

    @Override
    public void seleccionarEmisora(int boton){
        float frecuenciaBoton = botones[boton];
        if(frecuenciaBoton != 0.0f ){
            if(frecuenciaBoton >= 530 && frecuenciaBoton <= 1610){
                if(modoAM){
                    frecuenciaActual = frecuenciaBoton;
                }else{
                    ultimaFrecuenciaFM = frecuenciaActual;
                    frecuenciaActual = frecuenciaBoton;
                    modoAM = true;
                }
            }
            else if(frecuenciaBoton >= 87.9 && frecuenciaBoton <= 107.9){
                if(!modoAM){
                    frecuenciaActual = frecuenciaBoton;
                }else{
                    ultimaFrecuenciaAM = frecuenciaActual;
                    frecuenciaActual = frecuenciaBoton;
                    modoAM = false;
                }
            }
        }
    }

}