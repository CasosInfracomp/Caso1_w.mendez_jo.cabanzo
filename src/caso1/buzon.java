package caso1;

public class buzon {
    
    private int numMensajes;
    private int capMaxima;

    public buzon(int capMaxima)
    {
        this.capMaxima = capMaxima;
        this.numMensajes = 0;
    }

    public void entrarProceso(int Thread, String msj)
    {
        while(numMensajes<=capMaxima)
        {
            synchronized(this)
            {
                try {
                    System.out.println("El proceso numero:" + Thread + " se durmió ");
                    wait();
                } catch (Exception e) {
                    System.out.println("Fallo al dormir proceso" + Thread);
                }
            }
        }
        
    }

    public void añadirMensaje(int Thread, String msj)
    {
        while(numMensajes<capMaxima)
        {
            synchronized(this)
            {
                try {
                    System.out.println("El proceso numero:" + Thread + " añadió el mensaje " + msj);
                    numMensajes++;
                    notify();

                } catch (Exception e) {
                    System.out.println("Fallo al añadir el mensaje" + Thread);
                }
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
