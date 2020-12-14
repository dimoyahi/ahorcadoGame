package application;

import java.util.Scanner;
import java.util.Random;

/**
 * Juego de ahorcado con base en un cuento
 * 
 * @author Yeferson Eduardo Noreña Arenas Cod 1721023878
 *		   Nicolás Andrés Barahona Código: 1821027680
 *		   Andres Felipe Villegas Corrales Código: 1921025700
 *		   Diego Armando Moya Código 1911020174
 * 
 */
public class prototipo {

	public static void main(String[] args) {
		// Constante que almacena la cantidad de intentos permitidos
		final int INTENTOS_TOTALES = 10;
		int intentos = 0;
		int aciertos = 0;
		// Se inicia el Scanner
		Scanner teclado = new Scanner(System.in);
		teclado.useDelimiter("\n");
		char resp;

		// Se declara la variable que genera las palablas de forma aleatoria
		Random rnd = new Random();
		// Se crea un array de las palaras que se van a utiizar en el Juego
		String arrayPalabras[] = new String[7];
		// Palabras del Juego
		arrayPalabras[0] = "michin";
		arrayPalabras[1] = "encontro";
		arrayPalabras[2] = "robar";
		arrayPalabras[3] = "gente";
		arrayPalabras[4] = "morira";
		arrayPalabras[5] = "impedirlo";
		arrayPalabras[6] = "diegoarmadnomoya";

		do {

			// Descomponemos las palabras que se van a buscar
			int alea = rnd.nextInt(7);
			char[] descomponer = descompone(arrayPalabras[alea]);
			char[] copia = descompone(arrayPalabras[alea]);

			// Array que muestras caracteres en pantalla
			char[] tusRespuestas = new char[descomponer.length];

			// Rellenamos palabras con guiones
			for (int i = 0; i < tusRespuestas.length; i++) {
				tusRespuestas[i] = '_';
			}

			// Empezamos a pintar las palabras
			System.out.println("Las palabras del Cuento!");
			System.out.println("Michín dijo a su mamá: \n" + "Voy a volverme Pateta, \n "
					+ "y el que a impedirlo se meta \n" + "en el acto morirá. \n" + "Ya le he robado a papá \n"
					+ "daga y pistolas; ya estoy \n" + "armado y listo; y me voy \n" + "a robar y matar gente, \n"
					+ "y nunca más (¡ten presente!) \n" + "verás a Michín desde hoy \n"
					+ "Yéndose al monte, encontró \n" + "a un gallo por el camino, \n" + "y dijo: A ver qué tal tino \n"
					+ "para matar tengo yo \n");

			// Mientras que no nos pasemos con los intentos y no la acertemos...
			while (intentos < INTENTOS_TOTALES && aciertos != tusRespuestas.length) {
				imprimeOculta(tusRespuestas);
				// Preguntamos la letra por teclado
				//System.out.println("\nIngrese una letra: ");
				resp = teclado.next().toLowerCase().charAt(0);
				// Recorremos el array y comprobamos si se ha producido un acierto
				for (int i = 0; i < descomponer.length; i++) {
					if (descomponer[i] == resp) {
						tusRespuestas[i] = descomponer[i];
						descomponer[i] = ' ';
						aciertos++;
					}
				}
				intentos++;
			}
			// Si hemos acertado todas imprimimos un mensaje
			if (aciertos == tusRespuestas.length) {
				System.out.print("\nFelicidades!! has acertado la palabra: ");
				imprimeOculta(tusRespuestas);
			}
			// Si no otro
			else {
				System.out.print("\nHaz perdido intenta de nuevo: ");
				for (int i = 0; i < copia.length; i++) {
					System.out.print(copia[i] + " ");
				}
			}
			// Reseteamos contadores
			intentos = 0;
			aciertos = 0;
			// Volvemos a preguntarle al usuario si quiere volver a jugar
			resp = pregunta("\n\nQuieres volver a jugar?", teclado);
		} while (resp != 'n');

	}

	/**
	 * Esto descompone el String en un array de caracteres
	 * 
	 * @return array de letras.
	 */
	private static char[] descompone(String palAzar) {
		char[] letras;
		letras = new char[palAzar.length()];
		for (int i = 0; i < palAzar.length(); i++) {
			letras[i] = palAzar.charAt(i);
		}
		return letras;
	}

	/**
	 * Esto imprime la palabra con espacios
	 * 
	 * @param tusRespuestas el array de caracteres
	 */
	private static void imprimeOculta(char[] tusRespuestas) {

		for (int i = 0; i < tusRespuestas.length; i++) {
			System.out.print(tusRespuestas[i] + " ");
		}
	}

	/**
	 * Esto nos pregunta si queremos volver a jugar y comprueba los caracteres
	 * introducidos
	 * 
	 * @param men texto para mostrar al usuario
	 * @return caracter de respuesta (s/n)
	 * 
	 */
	public static char pregunta(String men, Scanner teclado) {
		char resp;
		System.out.println(men + " (s/n)");
		resp = teclado.next().toLowerCase().charAt(0);
		while (resp != 's' && resp != 'n') {
			System.out.println("Error! solo se admite S o N");
			resp = teclado.next().toLowerCase().charAt(0);
		}
		return resp;
	}

}