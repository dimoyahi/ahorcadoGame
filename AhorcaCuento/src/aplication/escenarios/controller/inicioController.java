package aplication.escenarios.controller;

import java.util.Random;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class inicioController {
	String[] imgFondo = new String[] { "/imagenes/fondo/fondoInicio.jpg", "/imagenes/fondo/fondo1.jpg",
			"/imagenes/fondo/fondo2.jpg", "/imagenes/fondo/fondo3.jpg" };
	String[] imgAhorcado = new String[] { "/imagenes/ahorcado/ahorcado_1.jpg", "/imagenes/ahorcado/ahorcado_2.jpg",
			"/imagenes/ahorcado/ahorcado_3.jpg", "/imagenes/ahorcado/ahorcado_4.jpg",
			"/imagenes/ahorcado/ahorcado_5.jpg", "/imagenes/ahorcado/ahorcado_6.jpg" };

	int indice = 0;
	
	@FXML
	private Pane cuento;
	@FXML
	private Pane Juego;
	@FXML
	private Label frase;
	@FXML
	private Label cuentoCompleto;
	@FXML
	private ImageView ahorcado;
	@FXML
	private ProgressBar tiempo;
	@FXML
	private Pane configuracion;
	@FXML
	private Pane inicio;
	@FXML
	private ImageView fondo;
    @FXML
    private Label textoAhorcado;
    @FXML
    private Button A;
	
	final int INTENTOS_TOTALES = 10;
	int intentos = 0;
	int aciertos = 0;
	char resp;
	

	
	public void logJuego() {
		Scanner teclado = new Scanner(System.in);
		teclado.useDelimiter("\n");
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
		arrayPalabras[6] = "monte";
	
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
			frase.setText("hola");;
			// Mientras que no nos pasemos con los intentos y no la acertemos...
			while (intentos < INTENTOS_TOTALES && aciertos != tusRespuestas.length) {
				imprimeOculta(tusRespuestas);
				// Preguntamos la letra por teclado
				//System.out.println("\nIngrese una letra: ");
//				resp = teclado.next().toLowerCase().charAt(0);
				// Recorremos el array y comprobamos si se ha producido un acierto
				for (int i = 0; i < descomponer.length; i++) {
					if (descomponer[i] == 0) {
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
	
	double i = 0.0;


	// Event Listener on Button.onAction
	@FXML
	public void iniciarJuaego(ActionEvent event) {
		Juego.setVisible(true);
		

	}

	// Event Listener on Button.onAction
	@FXML
	public void Salir(ActionEvent event) {
		inicio.setVisible(true);
	}

	// Event Listener on Button.onAction
	@FXML
	public void Nprincipal(ActionEvent event) {
		inicio.setVisible(true);
		cuento();
		Juego.setVisible(false);
	}

	// Event Listener on Button.onAction
	@FXML
	public void nuevoJuego(ActionEvent event) {
		logJuego();
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_A(ActionEvent event) {
		String url = imgAhorcado[0];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_B(ActionEvent event) {
		String url = imgAhorcado[1];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_C(ActionEvent event) {
		String url = imgAhorcado[2];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_D(ActionEvent event) {
		String url = imgAhorcado[3];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_E(ActionEvent event) {
		String url = imgAhorcado[4];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_F(ActionEvent event) {
		String url = imgAhorcado[5];
		ahorcado.setImage(new Image(url));
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_G(ActionEvent event) {
		// TODO Autogenerated
		incorrecto();
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_H(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_I(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_J(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_K(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_L(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_M(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_N(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_NN(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_O(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_P(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_Q(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_R(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_S(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_T(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_U(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_V(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_W(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_X(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_Y(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void bto_Z(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_Salir(ActionEvent event) {
		System.exit(0);
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_Tutorial(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_Config(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_Reglas(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_IniciarJuego(ActionEvent event) {
		cuento.setVisible(true);
		inicio.setVisible(false);
		cuento();
	}

	// Event Listener on Button.onAction
	@FXML
	public void clic_Fondo(ActionEvent event) {
		fondoAleatorio();
	}

	public void fondoAleatorio() {
		String url = imgFondo[(int) Math.floor(Math.random() * imgFondo.length)];
		fondo.setImage(new Image(url));
	}

	public void cuento() {
		String cuentos;
		cuentos = "Mich�n dijo a su mam�: Voy a volverme Pateta, "
				+ "y el que a impedirlo se meta en el acto morir�. " + "Ya le he robado a pap�  "
				+ "daga y pistolas; ya estoy armado y listo; y me voy  " + "a robar y matar gente,  "
				+ "y nunca m�s (�ten presente!) ver�s a Mich�n desde hoy  "
				+ "Y�ndose al monte, encontr� a un gallo por el camino,  " + "y dijo: A ver qu� tal tino  "
				+ "para matar tengo yo \n";
		cuentoCompleto.setText(cuentos);
	}

	public void progress() {
		tiempo.setProgress(i);
		i = i + 0.01;
//		if (i == 1.00) {
//			System.out.println("Perdiste");
//		}else {
//			tiempo.setProgress(i);
//			i=i+0.01;
//		}
	}
	public void imprimeOculta(char[] tusRespuestas) {
		for (int i = 0; i < tusRespuestas.length; i++) {
			System.out.print(tusRespuestas[i] + " ");
//			textoAhorcado.setText(tusRespuestas[i] + " ");
			char respuesta;
			respuesta = tusRespuestas[i];
			textoAhorcado.setText("_______________");
		}
	}
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
	private static char[] descompone(String palAzar) {
		char[] letras;
		letras = new char[palAzar.length()];
		for (int i = 0; i < palAzar.length(); i++) {
			letras[i] = palAzar.charAt(i);
		}
		return letras;
	}
	public void PresionBto() {
		A.setText("A");
	}
	
	public void incorrecto() {
		if (indice == 6) {
			indice = 6;
		}else {
			indice++;
			String url = imgAhorcado[indice];
			ahorcado.setImage(new Image(url));
//			ahorcado.setImage(imgAhorcado[indice]);
		}
	}
}
