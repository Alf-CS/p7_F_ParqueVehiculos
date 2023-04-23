package p_ParqueVehiculos;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class ES {
	
	public static final int LENGTH_MIN = 1;
	public static final int FONT_SIZE = 14;
	
	private ES() {}

	
	//--------------------------------- VALORES ENTEROS ------------------------------------------
	
	// Con mensaje estandar
	/*
	public static int obtenerInt() {
		int entero=0;
		String entrada = null;
		boolean valido = false;
		do {
			entrada = JOptionPane.showInputDialog(txtMonospaced("Introduce un número entero:"));
			try {
				entero = Integer.parseInt(entrada);
				valido = true;
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		} while(valido == false);
		return entero;
	}*/
	
	public static int obtenerInt() {

		while (true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced("Introduce un número entero:"));			
			try {
				return Integer.parseInt(entrada);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}

	// Con mensaje como argumento
	public static int obtenerInt (String mensaje) {
		while (true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced(mensaje));
			try {
				return Integer.parseInt(entrada);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}

	// Con mensaje y rango permitido
	public static int obtenerInt (int min, int max, String mensaje) {
		if(min>max) {
			int temp = max;
			max = min;
			min = temp;
		}
		while(true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced(mensaje));
			try {
				int entero = Integer.parseInt(entrada);
				if(entero>=min && entero<=max)
					return entero;
				else
					JOptionPane.showMessageDialog(null, txtMonospaced("Entrada fuera de rango"));
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}

	// Con mensaje, rango y muestra el rango en el mensaje
	public static int obtenerInt(int min, int max, String mensaje, boolean rango) {
		// Permite rango: [mayor, menor]
		if (rango == true) {
			String mensajeRango = mensaje + " ["+ min + ", " + max + "]";
			return obtenerInt(min, max, mensajeRango);
		} 
		else
			return obtenerInt(min, max, mensaje);
	}
	
	
	//--------------------------------- VALORES REALES ------------------------------------------
	
	// Con mensaje estandar
	public static float obtenerFloat() {
		while(true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced("Introduce un número entero:"));
			try {
				return Float.parseFloat(entrada);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}

	// Con mensaje como argumento
	public static float obtenerFloat (String mensaje) {
		while(true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced(mensaje));
			try {
				return Float.parseFloat(entrada);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}

	// Con mensaje y rango permitido
	public static float obtenerFloat (float min, float max, String mensaje) {
		if(min>max) {
			float temp = max;
			max = min;
			min = temp;
		}
		while (true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced(mensaje));
			try {
				float real = Float.parseFloat(entrada);
				if(real>=min && real<=max)
					return real;
				else
					JOptionPane.showMessageDialog(null, txtMonospaced("Entrada fuera de rango"));
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, txtMonospaced("Entrada no válida: " + entrada));
			}
		}
	}
	
	// Con mensaje, rango y muestra el rango en el mensaje
	public static float obtenerFloat(float min, float max, String mensaje, boolean rango) {
		// Permite rango: [mayor, menor]
		if (rango) {
			String mensajeRango = mensaje + " ["+ min + ", " + max + "]";
			return obtenerFloat(min, max, mensajeRango);
		} 
		else
			return obtenerFloat(min, max, mensaje);
	}
	
	//------------------------------ CADENAS DE CARACTERES ---------------------------------------
	
	// Con mensaje y rango permitido
	
	public static String obtenerTexto (int min, int max, String mensaje) {
		if(min>max) {
			int temp = max;
			max = min;
			min = temp;
		}
		if(min < LENGTH_MIN)
			throw new ArithmeticException("La longitug del string debe ser mayor o igual que LENGTH_MIN");
		while(true) {
			String entrada = JOptionPane.showInputDialog(txtMonospaced(mensaje));
			entrada = entrada.trim();
			if(entrada.length()>=min && entrada.length()<=max)
				return entrada;
			else {
				String error =  "Entrada no válida: " + entrada + "\n" +
								"Longitud = " + entrada.length() + ", fuera de rango";
				JOptionPane.showMessageDialog(null, txtMonospaced(error));
			}
		}
	}

	// Con mensaje, rango y muestra el rango en el mensaje
	public static String obtenerTexto(int min, int max, String mensaje, boolean rango) {
		// Permite rango: [mayor, menor]
		if (rango) {
			String mensajeRango = mensaje + " ["+ min + ", " + max + "]";
			return obtenerTexto(min, max, mensajeRango);
		} 
		else
			return obtenerTexto(min, max, mensaje);
	}

	
	//------------------------- AUXILIARES STRING to JTextArea -----------------------------------

	public static JTextArea txtMonospaced (String mensaje) {
		JTextArea label = new JTextArea(mensaje);
	    label.setOpaque( false );
	    label.setEditable( false );
	    label.setFont(new Font("Consolas", Font.BOLD, FONT_SIZE));
	    return label;
	}
	
	public static void mostrarMensaje (String mensaje) {
	    JOptionPane.showMessageDialog(null, txtMonospaced(mensaje));
	}
	
	
}





		
	
	
	