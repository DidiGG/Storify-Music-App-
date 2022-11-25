package controller;


import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LoginController {
	Main aplicacion;

	@FXML
	private ToggleGroup TipoIngreso;

	@FXML
	private RadioButton RBadmin;

	@FXML
	private PasswordField txtPassw;

	@FXML
	private RadioButton RBuser;

	@FXML
	private TextField txtUsuario;

	@FXML
	void initialize() {

	}

	public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	void ingresar(ActionEvent event) {

		String usuario = txtUsuario.getText();
		String contrasena = txtPassw.getText();
		if (usuario.equals("admin") && contrasena.equals("admin")) {
			aplicacion.ingresarAdmin(usuario, contrasena);
		} else {
			aplicacion.ingresarUsuario(usuario, contrasena);
		}

	}

	@FXML
	void crearUsu(ActionEvent event) {
		aplicacion.mostrarVentanaCrearUsuario();
	}
}
