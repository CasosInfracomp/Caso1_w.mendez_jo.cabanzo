package caso1;

import java.util.ArrayList;

public class Buzon {

    private int numMensajes;
    private int capMaxima;
    private String nombre;
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

    /* Permite escribir en buzon */
    public void aniadirMensajePasivo(int idThread, String msj) {
        boolean esperando = true;
        while (esperando) {
            synchronized (this) {
                if (numMensajes <= capMaxima) {
                    mensajes.add(msj);
                    numMensajes++;
                    ultimoMensaje = msj;
                    System.out.println("El mensajero " + idThread + " agrego: " + msj + " al buzon: " + nombre);
                    notifyAll();
                    esperando = false;
                } else {
                    System.out.println(nombre + " esta lleno, no puede agregar: " + msj);
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
        while (esperando) {
            synchronized (this) {
                if (numMensajes + 1 <= capMaxima) {
                    numMensajes++;
                    ultimoMensaje = msj;
                    mensajes.add(msj);
                    System.out.println(("El mensajero " + idThread + " agrego: " + msj + " al buzon: " + nombre));
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
        while (esperando) {
            synchronized (this) {
                if (numMensajes != 0) {
                    System.out.println("El mensajero " + Thread + " saco: " + mensajes.get(0) + " del buzon:" + nombre);
                    numMensajes--;
                    notifyAll();
                    retorno = mensajes.remove(0);
                    esperando = false;
                } else {
                    // System.out.println(nombre + " esta vacio");
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
                    System.out.println("El mensajero " + idThread + " saco: " + mensajes.get(0) + " del buzon:" + nombre);
                    numMensajes--;
                    notifyAll();
                    retorno = mensajes.remove(0);
                    esperando = false;
                } else {
                    // System.out.println(nombre + " esta vacio");
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

}
