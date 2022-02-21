package caso1;

public class Mensajero extends Thread {

    private int id;
    private int tEspera;
    private boolean tipoEntrada;
    private boolean tipoSalida;
    private boolean corriendo = true;
    private Buzon buzonRecoger;
    private Buzon buzonEntregar;
    private String msgActual = "";

    public Mensajero(int id, Buzon[] buzones, boolean tipoEntrada, boolean tipoSalida, int tEspera) {
        this.id = id + 1;
        this.tipoEntrada = tipoEntrada;
        this.tipoSalida = tipoSalida;
        this.tEspera = tEspera;
        this.buzonRecoger = buzones[id];
        this.buzonEntregar = buzones[(id + 1) % 4];
        System.out.println(
                "Mensajero " + id + " sacar " + buzonRecoger.getNombre() + " entregar " + buzonEntregar.getNombre());
    }


    public boolean isCorriendo() {
        return corriendo;
    }

    @Override
    public void run() {
        while (corriendo) {
            entrar();
            recoger();
            if (corriendo) {
                escribir();
            }
            entregar();
        }
        System.out.println(id + " acaba");
    }

    private void entregar() {
        if (!msgActual.isEmpty()) {
            if (tipoSalida) {
                buzonEntregar.aniadirMensajeActivo(id, msgActual);
            } else {
                buzonEntregar.aniadirMensajePasivo(id, msgActual);
            }
        }
    }

    private void escribir() {
        String recoger = tipoEntrada ? "A" : "P";
        String entregar = tipoSalida ? "A" : "P";
        if (!msgActual.isEmpty()) {
            msgActual = msgActual + " " + id + recoger + entregar;
        }
        synchronized (this) {
            try {
                wait(tEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void recoger() {
        if (tipoEntrada) {
            msgActual = buzonRecoger.sacarMensajeActivo(id);
        } else {
            msgActual = buzonRecoger.sacarMensajePasivo(id);
        }
        if (msgActual.contains("FIN")) {
            Main.barrera = true;
            corriendo = false;
        }
    }

    private void entrar() {
    }

}
