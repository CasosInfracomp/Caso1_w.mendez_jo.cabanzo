package caso1;

public class Mensajero extends Thread {

    private int id;
    private boolean tipoEntrada;
    private boolean tipoSalida;

    public Mensajero(int id, boolean tipoEntrada, boolean tipoSalida) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.tipoSalida = tipoSalida;
    }

}
