package caso1;

public class buzon {
    
    private int numMensajes;
    private int capMaxima;
    private String nombre;

    public buzon(int capMaxima, String nombre)
    {
        this.capMaxima = capMaxima;
        this.numMensajes = 0;
        this.nombre = nombre;
    }

    public void añadirMensaje(int Thread, String msj) throws InterruptedException
    {
        synchronized(this)
        {   
           if(numMensajes<capMaxima)
           {
              wait();
              System.out.println("El proceso numero:" + Thread + "se durmio" );
           }
           else
           {
           }
        }
    }
    public void sacarMensaje()
    {

    }


}
