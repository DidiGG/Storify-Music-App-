package controller;

import javax.swing.JOptionPane;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cancion;

public class agregarCancionController {

	Main aplicacion;

	private ObservableList<Cancion> listaCancionesData = FXCollections.observableArrayList();
	Cancion cancionSeleccionada;


		@FXML
	    private TableView<Cancion> tablaCanciones;

	    @FXML
	    private TableColumn<String, Cancion> columnArtista;

	    @FXML
	    private TableColumn<String, Cancion> columnNombre;

	    public void setAplicacion(Main aplicacion) {
			this.aplicacion = aplicacion;
			tablaCanciones.getItems().clear();
			tablaCanciones.setItems(getListaCanciones());

		}


	    private ObservableList<Cancion> getListaCanciones() {
			listaCancionesData.addAll(aplicacion.obtenerCanciones());
			return listaCancionesData;
		}

	    @FXML
	    void initialize(){
	    	this.columnArtista.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    	this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nomArtista"));
	    	tablaCanciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	    		cancionSeleccionada = newSelection;
	    		});
	    	}


		@FXML
	    void agregarCancion(ActionEvent event) {

			if(cancionSeleccionada!=null){
				aplicacion.agregarCancionListaUser(null, cancionSeleccionada);
				aplicacion.mostrarVentanaUsuario(null);
			}else{
				JOptionPane.showMessageDialog(null, "seleccione una cancion");
			}



	    }
}
