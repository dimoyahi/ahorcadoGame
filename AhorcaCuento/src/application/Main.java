package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	String FrmInicio = "/aplication/escenarios/inicio.fxml";
	String prueba = "/aplication/escenarios/uno.fxml";

	@Override
	public void start(Stage primaryStage) {	
		try {
			 	Parent inicio = FXMLLoader.load(getClass().getResource(FrmInicio));
		        Scene scene = new Scene(inicio);
		        primaryStage.setScene(scene);
		        primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
