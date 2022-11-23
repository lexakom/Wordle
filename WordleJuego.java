
import java.util.Scanner;

public class WordleJuego {

	public static String palabraImp() {
		int n = 4;
		String[] dic = new String[n];
		dic[0] = "ESTIO";
		dic[1] = "AVALA";
		dic[2] = "PRADO";
		dic[3] = "MAREA";
		return (dic[(int) (Math.random() * n)]);
	}

	public static void main(String[] args) {
			try (Scanner in = new Scanner(System.in)) {
				String cadena;
				String propuesta;
				System.out.println("Juguemos a Wordle");
				System.out.println("Piensa una palabra...");
				System.out.println("Y dime si la acierto:");
				propuesta = palabraImp();
				System.out.println(propuesta);
				cadena = in.nextLine();
				String respuesta = evalCad(propuesta, cadena);
				System.out.println(respuesta);
			}

	}

	public static char[] aVector(String s) {
		// Convierte un string en un vector de caracteres
		char[] v = new char[s.length()];
		for (int i = 0; i < v.length; i++)
			v[i] = s.charAt(i); // lo recorre asignando a cada posición cada letra del string
		return v;
	}

	public static String aString(char[] v) {
		// Convierte un vector en string
		String s = "";
		for (int i = 0; i < v.length; i++)
			s = s + v[i];
		return s;
	}

	public static String evalCad(String propuesta, String cadena) {
		/*
		 * ENTRADA cadena de 0,1,2 que responde a la palabra propuesta por el juego
		 * 
		 * DEVUELVE palabra con las características
		 * 
		 * MÉTODO crea una palabra vacía y le va asignando las letras correspondientes
		 */
		char[] vCadena, vPropuesta, vRespuesta;
		int longitud = propuesta.length();

		vRespuesta = new char[longitud];
		for (int i = 0; i < vRespuesta.length; i++)
			vRespuesta[i] = '0';

		vCadena = aVector(cadena);
		vPropuesta = aVector(propuesta);// convierto el String de 0,1y 2 en vector

		for (int i = 0; i < longitud; i++) {
			if (vCadena[i] == '2')
				vRespuesta[i] = vPropuesta[i]; // le asigna al vector vacío las letras que están en la posición correcta

		}
		String respuesta;
		respuesta = aString(vRespuesta);
		return respuesta;
	}
}