package caso1;

public class buzon {
    
    private int numMensajes;
    private int capMaxima;

    public buzon(int capMaxima)
    {
        this.capMaxima = capMaxima;
        this.numMensajes = 0;
    }
 
    public void llenarBuzon(int Thread, String msj)
    {
         synchronized(this)
         {   

            if(numMensajes<capMaxima)
            {
               wait();
               
            }

            else
            {
            }
         }
         System.out.println("El thread numero:" + Thread );
    }

    public void entrarBuzon()
    {
        synchronized(this)
        {   

           if(numMensajes>capMaxima)
           {
              
           }

           else
           {
           }
        }
    }
    public void vaciarBuzon()
    {

    }


}
