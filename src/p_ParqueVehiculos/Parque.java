package p_ParqueVehiculos;

import javax.swing.JOptionPane;

public class Parque {
	
	// constantes estáticas
	public static final int MAX_VEHICULOS;
	public static final int MATRICULA_MAX;
	public static final int MATRICULA_MIN;
	public static final int MATRICULA_DIGITOS;
	private static final int ERROR;
	
	// inicializador estático
	static {
		MAX_VEHICULOS = 5;
		MATRICULA_MAX = 99999;
		MATRICULA_MIN = 0;
		MATRICULA_DIGITOS = Integer.toString(MATRICULA_MAX).length();
		ERROR = -1;
	}
	
	// constructores
	private Parque() {}
	
	// variables de instancia
	private Coche[] coches;
	
	// métodos propios
	public static void main(String[] args) {

		Parque f = new Parque();
		f.coches = new Coche[MAX_VEHICULOS]; // Nótese que está permitido acceder a f.coches (porque estamos dentro de la clase)

		String menu = 
				"Fábrica de coches interactiva.\n" +
				"\n" +
				"Elije una opción:\n" +
				"1. Fabricar coche (conociendo la matrícula)\n" +
				"2. Fabricar coche (a partir del nº de puertas y el nº de plazas)\n" +
				"3. Fabricar coche (a partir de la marca, modelo y color)\n" +
				"4. Fabricar coche (sin datos)\n" +
				"5. Tunear coche (pintándolo de un color)\n" +
				"6. Tunear coche (sin pintarlo)\n" +
				"7. Avanzar kilómetros\n" + 
				"8. Listar matrículas\n" + 
				"9. Mostrar características de un coche\n" + 
				"\n" +
				"0. Salir del programa";
		
		String opcion;
		
		do {
			opcion = JOptionPane.showInputDialog(menu);
			if(opcion == null)
				opcion = "0";
			switch (opcion) {
				case "1" : f.fabricarMatricula();
				case "2" : f.fabricarPuertasPlazas();
				case "3" : f.fabricarMarcaModeloColor();
				case "4" : f.fabricarSinDatos();
				case "5" : f.tunearColorFabrica();
				case "6" : f.tunearFabrica();
				case "7" : f.avanzarKm();
				case "8" : f.listarMatriculas();
				case "9" : f.ficha();
				case "0" : {}
				default  : JOptionPane.showMessageDialog(null, "Opción no válida");
			}
		} while(!opcion.equals("0"));
		
	}
	
	public void fabricarMatricula() {
		
	if(Coche.getNumCoches()<MAX_VEHICULOS) {
		int intMatricula = ES.obtenerInt(MATRICULA_MIN, MATRICULA_MAX, "Introduce la matrícula:");
		String stringMatricula = matriculaToString(intMatricula);
		coches[Coche.getNumCoches()] = new Coche (stringMatricula);
		JOptionPane.showMessageDialog(null, Coche.getNumCoches() + "\n" + caracteristicas(coches[Coche.getNumCoches()-1]));
	} else
		JOptionPane.showMessageDialog(null, "El almacén está lleno");
	}
	
	
	public void fabricarPuertasPlazas() {
		if(Coche.getNumCoches()<MAX_VEHICULOS) {
			int numPuertas = ES.obtenerInt(Coche.PUERTAS_MIN, Coche.PUERTAS_MAX, "Introduce el número de puertas:");
			int numPlazas = ES.obtenerInt(Coche.PLAZAS_MIN, Coche.PLAZAS_MAX, "Introduce el número de plazas:");
			coches[Coche.getNumCoches()] = new Coche (numPuertas, numPlazas);
			JOptionPane.showMessageDialog(
				null,
				"Fabricados: " + Coche.getNumCoches() + "\n" + caracteristicas(coches[Coche.getNumCoches()-1])
			);
		} else
			JOptionPane.showMessageDialog(null, "El almacén está lleno");
	}
	
	public void fabricarMarcaModeloColor() {
		if(Coche.getNumCoches()<MAX_VEHICULOS) {
			String marca = ES.obtenerTexto(Coche.STRING_LENGTH_MIN, Coche.STRING_LENGTH_MAX, "Introduce marca:");
			String modelo = ES.obtenerTexto(Coche.STRING_LENGTH_MIN, Coche.STRING_LENGTH_MAX, "Introduce modelo:");
			String color = ES.obtenerTexto(Coche.STRING_LENGTH_MIN, Coche.STRING_LENGTH_MAX, "Introduce color:");
			
			coches[Coche.getNumCoches()] = new Coche (marca, modelo, color);
			JOptionPane.showMessageDialog(
				null,
				"Fabricados: " + Coche.getNumCoches() + "\n" + caracteristicas(coches[Coche.getNumCoches()-1])
			);
		} else
			JOptionPane.showMessageDialog(null, "El almacén está lleno");
	}
	
	public void fabricarSinDatos() {
		if(Coche.getNumCoches()<MAX_VEHICULOS) {
			coches[Coche.getNumCoches()] = new Coche ();
			JOptionPane.showMessageDialog(
				null,
				"Fabricados: " + Coche.getNumCoches() + "\n" + caracteristicas(coches[Coche.getNumCoches()-1])
			);
		} else
			JOptionPane.showMessageDialog(null, "El almacén está lleno");
	}
	
	public void tunearColorFabrica(){
		String matricula = ES.obtenerTexto(MATRICULA_DIGITOS, MATRICULA_DIGITOS, "Introduce la matrícula:");
		int i = buscaCoche(matricula);
		if (i!=ERROR) {
			String color = ES.obtenerTexto(Coche.STRING_LENGTH_MIN, Coche.STRING_LENGTH_MAX, "Introduce el color:");
			coches[i].tunear(color);
			JOptionPane.showMessageDialog(null, caracteristicas(coches[i]));
		} else {
			JOptionPane.showMessageDialog(null, "Matrícula no encontrada");
		}
	}
	
	public void tunearFabrica(){
		String matricula = ES.obtenerTexto(MATRICULA_DIGITOS, MATRICULA_DIGITOS, "Introduce la matrícula:");
		int i = buscaCoche(matricula);
		if (i!=ERROR) {
			coches[i].tunear();
			JOptionPane.showMessageDialog(null, caracteristicas(coches[i]));
		} else {
			JOptionPane.showMessageDialog(null, "Matrícula no encontrada");
		}
	}
	
	public void avanzarKm(){
		String matricula = ES.obtenerTexto(MATRICULA_DIGITOS, MATRICULA_DIGITOS, "Introduce la matrícula:");
		int i = buscaCoche(matricula);
		if (i!=ERROR) {
			float km = ES.obtenerFloat(Coche.KM_MIN, Coche.KM_MAX-coches[i].getKm(), "Introduce km de avance:");
			coches[i].avanzar(km);
			JOptionPane.showMessageDialog(null, caracteristicas(coches[i]));
		} else {
			JOptionPane.showMessageDialog(null, "Matrícula no encontrada");
		}
	}
	
	public void listarMatriculas() {
		if(Coche.getNumCoches()==0)
			JOptionPane.showMessageDialog(null, "No hay coches");
		else {
			String listado = "Lista de las matrículas\n\n";
			for(int i=0; i<Coche.getNumCoches(); i++)
				listado+=coches[i].getMatricula()+"\n";
			JOptionPane.showMessageDialog(null, listado);
		}
	}
	
	public void ficha(){
		int matricula = ES.obtenerInt(MATRICULA_MIN, MATRICULA_MAX, "Introduce la matrícula:");
		int i = buscaCoche(matriculaToString(matricula));
		if (i==ERROR)
			JOptionPane.showMessageDialog(null, "Matrícula no encontrada");
		else
			JOptionPane.showMessageDialog(null, caracteristicas(coches[i]));
	}
	
	public static String caracteristicas(Coche c) {
		
		final String TECHO_SI_O_NO;
		if(c.getTechoSolar() == true)
			TECHO_SI_O_NO = "SI";
		else
			TECHO_SI_O_NO = "NO";
		
		String carac =  "Características:\n" +
						"Matrícula: " + c.getMatricula() + "\n" +
						"Marca: " + c.getMarca() + "\n" +
						"Modelo: " + c.getModelo() + "\n" +
						"Color: " + c.getColor() + "\n" +
						"Techo solar: " + TECHO_SI_O_NO + "\n" +
						"Kilómetros: " + c.getKm() + "\n" +
						"Nº puertas: " + c.getNumPuertas() + "\n" +
						"Nº plazas: " + c.getNumPlazas() + "\n";
		
		return carac;
	}
	
	public static String matAleatoria() {
		int intMatricula = (int ) Math.round(Math.random()*MATRICULA_MAX);
		return matriculaToString(intMatricula);
	}
	
	public static String matriculaToString(int matricula) {
		String stringMatricula = "";
		for (int i = MATRICULA_DIGITOS-1; i>0; i--) {
			if (matricula < Math.pow(10, i))
				stringMatricula += "0";
		}
		return stringMatricula+= matricula;
	}
	
	public int buscaCoche(String matricula) {
		int i;
		for(i = 0; i<Coche.getNumCoches(); i++) {
			if(coches[i].getMatricula().equals(matricula))
				return i;
		}
		return ERROR;
	}
}

