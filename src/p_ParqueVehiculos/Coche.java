package p_ParqueVehiculos;


/*
 La variable numCoches se define privada y no dispone de setter (sí getter)
 para que no se pueda modificar su valor fuera de la clase.
 
 La constante MAX_COCHES prefiero declararla en la clase Fabrica.
 Por concepto, la clase Coche no tiene por qué tener límites a la creación de objetos.
 
 Si la declaramos en la clase Coche, debe ser pública para usarla en la clase Fabrica.
 No necesita ni setter (es una CONSTANTE que se inicializa en la clase Coche) ni getter (pues es public)
 */

public class Coche implements PuedeCircular {
	
	// variables y constantes estáticas
	private static int numCoches;
	
	public static final int KM_MIN;
	public static final int KM_MAX;
	public static final int PLAZAS_MAX;
	public static final int PLAZAS_MIN;
	public static final int PUERTAS_MAX;
	public static final int PUERTAS_MIN;
	public static final int STRING_LENGTH_MAX;
	public static final int STRING_LENGTH_MIN;
	
	// inicializador estático
	static {
		numCoches = 0;
		
		KM_MIN = 0;
		KM_MAX = 10000000;
		PLAZAS_MAX =7;
		PLAZAS_MIN =1;
		PUERTAS_MAX=5;
		PUERTAS_MIN=1;
		STRING_LENGTH_MAX = 30;
		STRING_LENGTH_MIN = 2;
	}
	
	// variables de instancia
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private boolean techoSolar;
	private float km;
	private int numPuertas;
	private int numPlazas;
	
	// constructores
	public Coche() {
		numCoches++;
		setMatricula(Fabrica.matAleatoria()); // Esto es un atajo. Habría que definir nuevos constructores
		setMarca("SEAT");
		setModelo("ALTEA");
		setColor("Blanco");
		setTechoSolar(false);
		setKm(0f);
		setNumPuertas(3);
		setNumPlazas(5);
	}
	
	public Coche(String matricula) {
		this();
		this.setMatricula(matricula);
	}
	
	public Coche(int numPuertas, int numPlazas) {
		this();
		this.setNumPuertas(numPuertas);
		this.setNumPlazas(numPlazas);
	}
	
	public Coche(String marca, String modelo, String color) {
		this();
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
	}

	// getters y setters (de variables estáticas)
	public static int getNumCoches() {
		return numCoches;
	}
	
	// getters y setters (de variables de instancia)
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) throws ArithmeticException, NullPointerException {
		marca = marca.trim();
		if(marca.length()<STRING_LENGTH_MIN || marca.length()>STRING_LENGTH_MAX)
			throw new ArithmeticException(
				"\"marca\" debe tener de " + STRING_LENGTH_MIN + " a " + STRING_LENGTH_MAX +
				" caracteres sin espacios iniciales ni finales"
			);
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws ArithmeticException, NullPointerException{
		modelo = modelo.trim();
		if(modelo.length()<STRING_LENGTH_MIN || modelo.length()>STRING_LENGTH_MAX)
			throw new ArithmeticException(
				"\"modelo\" debe tener de " + STRING_LENGTH_MIN + " a " + STRING_LENGTH_MAX +
				" caracteres sin espacios iniciales ni finales"
			);
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) throws ArithmeticException, NullPointerException{
		color = color.trim();
		if(color.length()<STRING_LENGTH_MIN || color.length()>STRING_LENGTH_MAX)
			throw new ArithmeticException(
				"\"color\" debe tener de " + STRING_LENGTH_MIN + " a " + STRING_LENGTH_MAX +
				" caracteres sin espacios iniciales ni finales"
			);
		this.color = color;
	}

	public boolean getTechoSolar() {
		return techoSolar;
	}

	public void setTechoSolar(boolean techoSolar) {
		this.techoSolar = techoSolar;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) throws ArithmeticException {
		if(km<KM_MIN || km>KM_MAX)
			throw new ArithmeticException("\"km\" deber ser decimal positivo menor que " + KM_MAX);		
		this.km = km;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) throws ArithmeticException {
		if(numPuertas<PUERTAS_MIN || numPuertas>PUERTAS_MAX)
			throw new ArithmeticException(
				"El valor de \"numPuertas\" debe estar en el rango [" +
				PUERTAS_MIN + ", " + PUERTAS_MAX +"]"
			);
		this.numPuertas = numPuertas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) throws ArithmeticException {
		if(numPlazas<PLAZAS_MIN || numPlazas > PLAZAS_MAX)
			throw new ArithmeticException(
				"El valor de \"numPlazas\" debe estar en el rango [" +
				PLAZAS_MIN + ", " + PLAZAS_MAX +"]"
			);
		this.numPlazas = numPlazas;
	}
	
	// métodos propios
	public void avanzar(float km) throws ArithmeticException {
		if(km<KM_MIN)
			throw new ArithmeticException("\"km\" deber ser decimal positivo");	
		setKm(this.km+=km);
	}
	
	public void tunear() {
		setKm(0);
		setTechoSolar(true);
	}
	
	public void tunear(String color) throws ArithmeticException {
		tunear();
		setColor(color);
	}
	
	// matricular carece de sentido
	public void matricular (String matricula) throws ArithmeticException {
		setMatricula(matricula);
	}

}
