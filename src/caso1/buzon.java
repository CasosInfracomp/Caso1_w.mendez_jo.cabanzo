package caso1;

import java.util.ArrayList;

public class Buzon {

    private int numMensajes;
    private int capMaxima;
    private String nombre;
    private String ultimoMensaje;
    private ArrayList<String> mensajes;

    public Buzon(int capMaxima, String nombre) {
        this.numMensajes = 0;
        this.capMaxima = capMaxima;
        this.nombre = nombre;
        this.mensajes = new ArrayList<String>();
    }

    public int getCapMaxima() {
        return capMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    /*
     * Verifica la entrada de un mensajero activo al buzon. Lo deja esperando si la
     * capacidad de mensajes esta llena. Continua si no es así
     */
    public void entrarProceso(int Thread, String msj) {
        synchronized (this) {
            while (numMensajes <= capMaxima) {
                try {
                    System.out.println("El proceso numero:" + Thread + " se durmió");
                    wait();
                } catch (Exception e) {
                    System.out.println("Fallo al dormir proceso" + Thread);
                }
            }
        }

    }

    /* Permite escribir en buzon */
    public void aniadirMensajePasivo(int idThread, String msj) {
        boolean esperando = true;
        synchronized (this) {
            while (esperando) {
                if (numMensajes < capMaxima) {
                    mensajes.add(msj);
                    numMensajes++;
                    ultimoMensaje = msj;
                    System.out.println("+ " + idThread + ": " + msj + " b:" + nombre);
                    notifyAll();
                    esperando = false;
                } else {
                    System.out.println(nombre + " esta lleno, no puede agregar el mensaje: " + msj);
                    System.out.println(idThread + " se durmio");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public void aniadirMensajeActivo(int idThread, String msj) {
        boolean esperando = true;
        synchronized (this) {
            while (esperando) {
                if (numMensajes + 1 < capMaxima) {
                    numMensajes++;
                    ultimoMensaje = msj;
                    mensajes.add(msj);
                    System.out.println(("+ " + idThread + ": " + msj + " b:" + nombre));
                    notifyAll();
                    esperando = false;
                }
            }
        }
    }

    /* Permite escribir en buzon */

    public String sacarMensajeActivo(int Thread) {
        boolean esperando = true;
        String retorno = "";
        synchronized (this) {
            while (esperando) {
                if (numMensajes != 0) {
                    System.out.println("- " + Thread + ": " + mensajes.get(0) + " b:" + nombre);
                    numMensajes--;
                    notifyAll();
                    retorno = mensajes.remove(0);
                    esperando = false;
                } else {
                    // try {
                    //     wait(200);
                    // } catch (InterruptedException e) {
                    //     // TODO Auto-generated catch block
                    //     e.printStackTrace();
                    // }
                    // System.out.println(Thread + " trato de sacar un mensaje pero " + nombre + " esta vacio");
                }
            }
        }
        return retorno;
    }

    public String sacarMensajePasivo(int idThread) {
        boolean esperando = true;
        String retorno = "";
        while (esperando) {
            synchronized (this) {
                if (numMensajes != 0) {
                    System.out.println("- " + idThread + ": " + mensajes.get(0) + " b:" + nombre);
                    numMensajes--;
                    notifyAll();
                    retorno =  mensajes.remove(0);
                    esperando = false;
                } else {
                    // System.out
                    //         .println(idThread + " trato de sacar un mensaje pero " + nombre + " esta vacio");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return retorno;
    }

    public String darUltimoMensaje() {
        return ultimoMensaje;
    }

}
