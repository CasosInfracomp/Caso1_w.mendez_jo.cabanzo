package caso1;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	static String ruta = "Caso1_w.mendez_jo.cabanzo\\config.properties";
	static private Buzon[] buzones = new Buzon[4];
	static private Mensajero[] mensajeros = new Mensajero[4];
	static private ArrayList<Integer> capacidades = new ArrayList<Integer>();
	static private String[] letras = { "A", "B", "C", "D" };
	static private ArrayList<Integer> tiempos = new ArrayList<Integer>();
	static private ArrayList<Boolean> tiposRecepcion = new ArrayList<Boolean>();
	static private ArrayList<Boolean> tiposEnvio = new ArrayList<Boolean>();
	static public int barrera = 4;

	public static void cargarDatos() {
		Scanner sc = new Scanner(System.in);
		boolean carga = false;
		while (!carga) {
			// Carga de datos del archivo Properties
			try {
				InputStream input = new FileInputStream(ruta);
				Properties prop = new Properties();
				prop.load(input);

				capacidades.add(Integer.parseInt(prop.getProperty("caso.buzonA")));
				capacidades.add(Integer.parseInt(prop.getProperty("caso.buzonB")));
				capacidades.add(Integer.parseInt(prop.getProperty("caso.buzonC")));
				capacidades.add(Integer.parseInt(prop.getProperty("caso.buzonD")));
				tiempos.add(Integer.parseInt(prop.getProperty("caso.msg1_tEspera")));
				tiempos.add(Integer.parseInt(prop.getProperty("caso.msg2_tEspera")));
				tiempos.add(Integer.parseInt(prop.getProperty("caso.msg3_tEspera")));
				tiempos.add(Integer.parseInt(prop.getProperty("caso.msg4_tEspera")));
				tiposEnvio.add(Boolean.parseBoolean(prop.getProperty("caso.msg1_tipoEnvio")));
				tiposEnvio.add(Boolean.parseBoolean(prop.getProperty("caso.msg2_tipoEnvio")));
				tiposEnvio.add(Boolean.parseBoolean(prop.getProperty("caso.msg3_tipoEnvio")));
				tiposEnvio.add(Boolean.parseBoolean(prop.getProperty("caso.msg4_tipoEnvio")));
				tiposRecepcion.add(Boolean.parseBoolean(prop.getProperty("caso.msg1_tiporecepcion")));
				tiposRecepcion.add(Boolean.parseBoolean(prop.getProperty("caso.msg2_tiporecepcion")));
				tiposRecepcion.add(Boolean.parseBoolean(prop.getProperty("caso.msg3_tiporecepcion")));
				tiposRecepcion.add(Boolean.parseBoolean(prop.getProperty("caso.msg4_tiporecepcion")));
				System.out.println("Configuración cargada");
				carga = true;
			} catch (FileNotFoundException ex) {
				System.out.println("No se encontró el archivo.");
				System.out.println("Por favor ingresa la ruta del archivo de propiedades:");
				ruta = sc.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void poblar() {
		for (int i = 0; i < 4; i++) {
			buzones[i] = new Buzon(capacidades.get(i), letras[i]);
		}
		for (int i = 0; i < 4; i++) {
			mensajeros[i] = new Mensajero(i, buzones, tiposRecepcion.get(i), tiposEnvio.get(i), tiempos.get(i));
		}
		System.out.println("Entidades creadas");
	}

	private static void iniciar() {
		for (int i = 0; i < 4; i++) {
			mensajeros[i].start();
			System.out.println("Mensajero " + (i + 1) + " iniciado");
		}
	}

	private static void enviarMensaje(String msg) {
		buzones[0].aniadirMensajeActivo(0, msg);
	}

	public static void main(String[] args) {

		cargarDatos();
		poblar();

		boolean entrada = true;
		int cantidadMensajes = -1;
		while (entrada) {
			System.out.println("====================================");
			System.out.println("Cantidad de mensajes: ");
			cantidadMensajes = new Scanner(System.in).nextInt();

			int total = 0;
			for (int i = 0; i < 4; i++) {
				total += buzones[i].getCapMaxima();
			}

			if (cantidadMensajes > total) {
				System.out.println("Esta cantidad de mensajes no cabe en los buzones");
			} else {
				entrada = false;
			}
		}

		iniciar();

		for (int i = 0; i < cantidadMensajes; i++) {
			enviarMensaje("Msg " + i);
		}
		enviarMensaje("FIN");

		for (int i = 0; i < cantidadMensajes; i++) {
			System.out.println(buzones[0].sacarMensajePasivo(0));
		}

	}

}
