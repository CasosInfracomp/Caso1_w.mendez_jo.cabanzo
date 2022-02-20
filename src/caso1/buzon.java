package caso1;

public class Buzon {

    private int numMensajes;
    private int capMaxima;
    private String nombre;
    private String ultimoMensaje;

    public Buzon(int capMaxima, String nombre) {
        this.numMensajes = 0;
        this.capMaxima = capMaxima;
        this.nombre = nombre;
    }


    /*Verifica la entrada de un mensajero activo al buzon. Lo deja esperando si la  
     capacidad de mensajes esta llena. Continua si no es así*/
    public void entrarProceso(int Thread, String msj)
    {
        synchronized(this)
        {
            while(numMensajes<=capMaxima)
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


    /*Permite escribir en buzon */
    public void añadirMensaje(int Thread, String msj)
    {
        synchronized(this)
        {
            try {
                System.out.println("El proceso numero:" + Thread + " añadió el mensaje " + msj);
                numMensajes++;
                ultimoMensaje = msj;
                notify();
            } catch (Exception e) {
                System.out.println("Fallo al añadir el mensaje" + Thread);
            }
        }
        
    }


    /*Permite escribir en buzon */

    public void sacarMensaje(int Thread)
    {
       synchronized(this)
           {
                while(numMensajes != 0)
                {   
                    notifyAll();
                    System.out.println("El proceso numero:" + Thread + "sacó el ultimo mensaje." );
                    numMensajes--;
               
                }
            }

    }

    public String darUltimoMensaje()
    {
        return ultimoMensaje;
    }

}
