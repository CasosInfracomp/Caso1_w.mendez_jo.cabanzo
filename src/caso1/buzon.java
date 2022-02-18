package caso1;

public class Buzon {

    private int numMensajes;
    private int capMaxima;
    private String nombre;

    public Buzon(int capMaxima, String nombre)
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
