package caso1;

public class buzon {
    
    private int numMensajes;
    private int capMaxima;

    public buzon(int capMaxima)
    {
        this.capMaxima = capMaxima;
        this.numMensajes = 0;
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
