package caso1;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	static String ruta = "config.properties";
	private buzon[] buzones = new buzon[4];
	private mensajero[] mensajeros = new mensajero[4];
	static private int capacidadA;
	static private int capacidadB;
	static private int capacidadC;
	static private int capacidadD;
	static private int tiempo1;
	static private Boolean tipoEn1;
	static private Boolean tipoRe1;
	static private int tiempo2;
	static private Boolean tipoEn2;
	static private Boolean tipoRe2;
	static private int tiempo3;
	static private Boolean tipoEn3;
	static private Boolean tipoRe3;
	static private int tiempo4;
	static private Boolean tipoEn4;
	static private Boolean tipoRe4;

	public static void cargarDatos() {
		Scanner sc = new Scanner(System.in);
		boolean carga = false;
		while (!carga) {
			// Carga de datos del archivo Properties
			try {
				InputStream input = new FileInputStream(ruta);
				Properties prop = new Properties();
				prop.load(input);

				capacidadA = Integer.parseInt(prop.getProperty("caso.buzonA"));
				capacidadB = Integer.parseInt(prop.getProperty("caso.buzonB"));
				capacidadC = Integer.parseInt(prop.getProperty("caso.buzonC"));
				capacidadD = Integer.parseInt(prop.getProperty("caso.buzonD"));
				tiempo1 = Integer.parseInt(prop.getProperty("caso.caso.msg1_tEspera"));
				tipoEn1 = Boolean.parseBoolean(prop.getProperty("caso.msg1_tipoEnvio"));
				tipoRe1 = Boolean.parseBoolean(prop.getProperty("caso.msg1_tiporecepcion"));
				tiempo2 = Integer.parseInt(prop.getProperty("caso.caso.msg2_tEspera"));
				tipoEn2 = Boolean.parseBoolean(prop.getProperty("caso.msg2_tipoEnvio"));
				tipoRe2 = Boolean.parseBoolean(prop.getProperty("caso.msg2_tiporecepcion"));
				tiempo3 = Integer.parseInt(prop.getProperty("caso.caso.msg3_tEspera"));
				tipoEn3 = Boolean.parseBoolean(prop.getProperty("caso.msg3_tipoEnvio"));
				tipoRe3 = Boolean.parseBoolean(prop.getProperty("caso.msg3_tiporecepcion"));
				tiempo4 = Integer.parseInt(prop.getProperty("caso.caso.msg4_tEspera"));
				tipoEn4 = Boolean.parseBoolean(prop.getProperty("caso.msg4_tipoEnvio"));
				tipoRe4 = Boolean.parseBoolean(prop.getProperty("caso.msg4_tiporecepcion"));
				System.out.println("Configuración cargada");
				carga = true;
				sc.close();
			} catch (FileNotFoundException ex) {
				System.out.println("No se encontró el archivo.");
				System.out.println("Por favor ingresa la ruta del archivo de propiedades:");
				ruta = sc.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {

		}
	}

}
