package caso1;

public class main {
    private buzon[] buzones = new buzon[4];
    private mensajero[] mensajeros = new mensajeros[4];
    private int capacidadA;
    private int capacidadB;
    private int capacidadC;
    private int capacidadD;
    private int tiempo1;
	private Boolean tipoEn1; 
	private Boolean tipoRe1;
	private int tiempo2;
	private Boolean tipoEn2;
	private Boolean tipoRe2;
	private int tiempo3;
	private Boolean tipoEn3;
	private Boolean tipoRe3;
	private int tiempo4; 
	private Boolean tipoEn4;
	private Boolean tipoRe4;

    public static void cargarDatos() {
		Scanner sc = new Scanner(System.in);
		while (!carga) {
			// Carga de datos del archivo Properties
			try {
				InputStream input = new FileInputStream("config.properties");
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
				pathToProperties = sc.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public static void main(String[] args) {
        for (int i = 0, i<4, i++) {
            
        }
    }

}
