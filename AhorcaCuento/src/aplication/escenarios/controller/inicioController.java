package aplication.escenarios.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class inicioController {
	
	

	String[] imgFondo = new String[]{"/imagenes/fondo/fondo1.jpg","/imagenes/fondo/fondo2.jpg","/imagenes/fondo/fondo3.jpg"};
	
	@FXML
	private ImageView fondo;
	
	// Event Listener on Button.onAction
	@FXML
	public void clic_IniciarJuego(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void clic_Reglas(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void clic_Config(ActionEvent event) {

	}
	// Event Listener on Button.onAction
	@FXML
	public void clic_Tutorial(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void clic_Salir(ActionEvent event) {
		System.exit(0);
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void clic_Fondo(ActionEvent event) {
		fondoAleatorio();
	}
	
	public void fondoAleatorio() {
		String url = imgFondo[(int)Math.floor(Math.random()*imgFondo.length)];
		fondo.setImage(new Image(url));
	}
	

}