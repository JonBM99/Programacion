package com.decroly.pruebaexamenfinal;

import com.decroly.pruebaexamenfinal.Utils.FileUtils;
import com.decroly.pruebaexamenfinal.model.Producto;
import com.decroly.pruebaexamenfinal.model.SQLAccess;
import com.decroly.pruebaexamenfinal.model.Tipo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class HelloController {
    //Panel de registro de nuevo producto
    @FXML
    private AnchorPane mainPanel;

    @FXML
    private VBox registrarPanel;

    //Campos de texto del registro
    @FXML
    private TextField idRegisterField;

    @FXML
    private TextField nombreRegisterField;

    @FXML
    private TextField descripcionRegisterField;

    @FXML
    private TextField precioRegisterField;

    @FXML
    private ComboBox<Tipo> tipoRegisterField;

    //Boton de registro de nuevo producto
    @FXML
    private Button registrarProductoBtn;


    //Panel de lista de productos
    @FXML
    private VBox tablaPanel;

    //Listview de productos
    @FXML
    private ListView<Producto> listaProductosView;

    //Botones de panel de lista de productos
    @FXML
    private Button nuevoProductoBtn;

    @FXML
    private Button editarProductoBtn;

    @FXML
    private Button quitarProductoBtn;

    @FXML
    private Button exportarDatosBtn;

    //Objetos para controlar las entidades
    ObservableList<Producto> lista = FXCollections.observableArrayList();

    //Metodo initialize que se ejecuta al iniciarse el HelloController
    @FXML
    public void initialize() {
        tablaPanel.setVisible(true);
        registrarPanel.setVisible(false);
        listaProductosView.setItems(lista);
        tipoRegisterField.getItems().setAll(Tipo.values());

        //Añadir listener para los botones
        listaProductosView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            quitarProductoBtn.setDisable(newValue == null);
            editarProductoBtn.setDisable(newValue == null);
        });


        //Añadir listener para actualizar los campos al seleccionar un producto
        listaProductosView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && productoenedicion != null){
                idRegisterField.setText(String.valueOf(newValue.getId()));
                nombreRegisterField.setText(newValue.getNombre());
                descripcionRegisterField.setText(newValue.getDescripcion());
                precioRegisterField.setText(String.valueOf(newValue.getPrecio()));
                tipoRegisterField.setValue(newValue.getTipo());
                selectPanelVisible(0);
            }
        });

        //Añadir listener a las propiedades de focus de los TextFields
        idRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(idRegisterField.getText().isEmpty()){
                    idRegisterField.setText("");
                    idRegisterField.setPromptText("Ingrese un numero");
                }
            }
        });

        nombreRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(nombreRegisterField.getText().isEmpty()){
                    nombreRegisterField.setText("");
                    nombreRegisterField.setPromptText("Ingrese un nombre");
                }
            }
        });
        descripcionRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(descripcionRegisterField.getText().isEmpty()){
                    descripcionRegisterField.setText("");
                    descripcionRegisterField.setPromptText("Ingrese una descripcion");
                }
            }
        });
        precioRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(precioRegisterField.getText().isEmpty()){
                    precioRegisterField.setText("");
                    precioRegisterField.setPromptText("Ingrese un precio");
                }
            }
        });
    }

    private List<Producto> loadFileProductos(){
        return FileUtils.readFile("export_Productos.dat");
    }

    //Evento de los botones
    @FXML
    private void añadirproducto() {
        String id = idRegisterField.getText();
        String nombre = nombreRegisterField.getText();
        String descripcion = descripcionRegisterField.getText();
        String precio = precioRegisterField.getText();
        Tipo tipo = tipoRegisterField.getValue();
        if(idRegisterField.getText().isEmpty() || nombreRegisterField.getText().isEmpty() || descripcionRegisterField.getText().isEmpty() || precioRegisterField.getText().isEmpty() || tipoRegisterField.getValue() == null){
            showAlert("Error, todos los campos son obligatorios");
        }else {
            Producto p = new Producto(Integer.parseInt(id), nombre, descripcion, Double.parseDouble(precio), tipo);
            lista.add(p);
            SQLAccess.añadirProducto(p);
            showAlert("Exito, Producto añadido correctamente");
            clearFields();
            selectPanelVisible(1);
            listaProductosView.refresh();
        }
    }
    @FXML
    private void guardarProducto(){
        if(productoenedicion != null){
            editarProductoConfirmar();
        } else {
            añadirproducto();
        }
    }

    @FXML
    private void eliminarProducto() {
        Producto seleccionado = productoseleccionado();
        if(seleccionado != null){
            lista.remove(seleccionado);
            listaProductosView.refresh();
            selectPanelVisible(1);
            SQLAccess.eliminarProducto(seleccionado);
            showAlert("Exito, Producto eliminado correctamente");
        } else {
            showAlert("ERROR, No hay ningun producto seleccionado");
        }
    }
    private Producto productoenedicion;
    @FXML
    private void editarProducto() {
        Producto seleccionado = productoseleccionado();
        if(seleccionado != null){
            selectPanelVisible(0);

            idRegisterField.setText(String.valueOf(seleccionado.getId()));
            nombreRegisterField.setText(seleccionado.getNombre());
            descripcionRegisterField.setText(seleccionado.getDescripcion());
            precioRegisterField.setText(String.valueOf(seleccionado.getPrecio()));
            tipoRegisterField.setValue(seleccionado.getTipo());

            productoenedicion = seleccionado;

        } else {
            showAlert("ERROR, No hay ningun producto seleccionado");
        }
    }
    @FXML
    private void editarProductoConfirmar(){
        String id = idRegisterField.getText();
        String nombre = nombreRegisterField.getText();
        String descripcion = descripcionRegisterField.getText();
        String precio = precioRegisterField.getText();
        Tipo tipo = tipoRegisterField.getValue();
        if(idRegisterField.getText().isEmpty() || nombreRegisterField.getText().isEmpty() || descripcionRegisterField.getText().isEmpty() || precioRegisterField.getText().isEmpty() || tipoRegisterField.getValue() == null){
            showAlert("Error, todos los campos son obligatorios");
        }else {
            productoenedicion.setId(Integer.parseInt(id));
            productoenedicion.setNombre(nombre);
            productoenedicion.setDescripcion(descripcion);
            productoenedicion.setPrecio(Double.parseDouble(precio));
            productoenedicion.setTipo(tipo);

            listaProductosView.refresh();
            SQLAccess.editarProducto(productoenedicion);
            showAlert("Exito, Producto editado correctamente");

            productoenedicion = null;
            clearFields();
            selectPanelVisible(1);
        }
    }

    @FXML
    private void saveInFile() {
        FileUtils.writeFile("export_Productos.dat", new LinkedList<Producto>());
    }

    //Metodos internos para realizar operaciones
    @FXML
    private void cambiararegistro(){
        selectPanelVisible(0);
    }

    private void clearFields(){
        idRegisterField.setText("");
        nombreRegisterField.setText("");
        descripcionRegisterField.setText("");
        precioRegisterField.setText("");
        tipoRegisterField.setPromptText("Tipo");
        tipoRegisterField.getSelectionModel().clearSelection();
    }

    private void selectPanelVisible(int panel){
        switch (panel){
            case 0:
                registrarPanel.setVisible(true);
                tablaPanel.setVisible(false);
            break;
            case 1:
                registrarPanel.setVisible(false);
                tablaPanel.setVisible(true);
            break;
            default:
                registrarPanel.setVisible(true);
                tablaPanel.setVisible(false);
        }
    }


    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    private Producto productoseleccionado() {
        return listaProductosView.getSelectionModel().getSelectedItem();
    }
}

