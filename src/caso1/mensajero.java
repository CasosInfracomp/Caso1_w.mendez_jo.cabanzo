package caso1;

public class Mensajero extends Thread {

    private int id;
    private int tEspera;
    private boolean tipoEntrada;
    private boolean tipoSalida;
    private boolean corriendo = true;

    public Mensajero(int id, boolean tipoEntrada, boolean tipoSalida, int tEspera) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.tipoSalida = tipoSalida;
        this.tEspera = tEspera;
    }

    @Override
    public void run() {
        while (corriendo) {
            recoger();
            escribir();
            entregar();
        }
    }

    private void entregar() {
    }

    private void escribir() {

    }

    private void recoger() {
    }

}
