package caso1;

public class buzon {
    
    private int numMensajes;
    private int capMaxima;

    public buzon(int capMaxima)
    {
        this.capMaxima = capMaxima;
        this.numMensajes = 0;
    }

    public void añadirMensaje(int Thread, String msj)
    {
        synchronized(this)
        {   
           while(numMensajes<capMaxima)
           {
              System.out.println("El proceso numero:" + Thread + " envió el mensaje " + msj );
              numMensajes++;
              notify();

           }
           
        }
    }


    public void sacarMensaje(int Thread)
    {
        synchronized(this)
        {   
           while(numMensajes!= 0)
           {
              System.out.println("El proceso numero:" + Thread + "sacó el ultimo mensaje." );
              numMensajes--;
              notifyAll();
           }
        }

    }


}
