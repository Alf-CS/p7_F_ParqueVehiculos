package p_ParqueVehiculos;

public abstract class Vehiculo {
	
	// 	constantes estáticas
	public static final int MAX_VEHICULOS=5;
	private static int NUM_VEHICULOS=0;
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color="blanco";
	private int kilometros=0;
	private int NumPuertas;
	private int NumPlazas;
	
	public Vehiculo() {
		if (NUM_VEHICULOS<MAX_VEHICULOS) NUM_VEHICULOS++;
		System.out.println("Se ha creado un nuevo vehículo");
		}
	public Vehiculo(String marca, String modelo, String color, int km, int NumPuertas, int NumPlazas) {
		this.marca=marca;
		this.modelo=modelo;
		this.color=color;
		this.kilometros=km;	
		this.NumPuertas=NumPuertas;
		this.NumPlazas=NumPlazas;
	}
		
	protected abstract void frenar();
	protected abstract void acelerar();
	protected abstract void arrancar();
	
	@Override
	public abstract String toString() {
		String info="";
		info="Características del vehículo con matrícula "+this.matricula+"\n";
		return info;
	}

}
