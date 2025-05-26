package com.decroly.pruebaexamenfinal;

import com.decroly.pruebaexamenfinal.Utils.FileUtils;
import com.decroly.pruebaexamenfinal.model.Producto;
import com.decroly.pruebaexamenfinal.model.Tipo;
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
    private Button editarProdcutoBtn;

    @FXML
    private Button quitarProductoBtn;

    @FXML
    private Button exportarDatosBtn;

    //Objetos para controlar las entidades
    ObservableList<Producto> lista = FXCollections.observableArrayList();

    //Metodo initialize que se ejecuta al inicarse el HelloController
    @FXML
    public void initialize() {
        tablaPanel.setVisible(true);
        registrarPanel.setVisible(false);
        tipoRegisterField.getItems().setAll(Tipo.values());
        listaProductosView.setItems(lista);


        //Añadir listener a la propiedad de elemento seleccionado de la lista
        listaProductosView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
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
                if(!validateId(idRegisterField.getText())) {
                    idRegisterField.setText("");
                    idRegisterField.setPromptText("Ingrese un numero");
                }
            }
        });

        nombreRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(validateNombre(nombreRegisterField.getText())){
                    nombreRegisterField.setText("");
                    nombreRegisterField.setPromptText("Valor incorrecto");
                }
            }
        });
        descripcionRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(validateDescripcion(descripcionRegisterField.getText())) {
                    descripcionRegisterField.setText("");
                    descripcionRegisterField.setPromptText("Valor incorrecto");
                }
            }
        });
        precioRegisterField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(validatePrecio(precioRegisterField.getText())) {
                    precioRegisterField.setText("");
                    precioRegisterField.setPromptText("Ingrese un numero decimal");
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
            Producto p = new Producto(Integer.parseInt(id), nombre, descripcion, Double.parseDouble(precio), tipo);
            lista.add(p);
            showAlert("Exito, Producto añadido correctamente");
            listaProductosView.setItems(lista);
            //Limpiar los campos
            clearFields();
            selectPanelVisible(1);
            listaProductosView.refresh();
    }

    @FXML
    private void eliminarProducto() {
        Producto seleccionado = productoseleccionado();
        if(seleccionado != null){
            lista.remove(seleccionado);
            showAlert("Exito, Producto eliminado correctamente");
            listaProductosView.refresh();
            clearFields();
        } else {
            showAlert("ERROR, No hay ningun producto seleccionado");
        }
    }

    @FXML
    private void editarProducto() {
        Producto seleccionado = productoseleccionado();
        if(seleccionado != null){
            String nuevoId = idRegisterField.getText();
            String nuevoNombre = nombreRegisterField.getText();
            String nuevaDescripcion = descripcionRegisterField.getText();
            String nuevoPrecio = precioRegisterField.getText();
            Tipo nuevoTipo = tipoRegisterField.getValue();
            if(validateId(nuevoId) && validateNombre(nuevoNombre) && validateDescripcion(nuevaDescripcion) && validatePrecio(nuevoPrecio)){
                seleccionado.setId(Integer.parseInt(nuevoId));
                seleccionado.setNombre(nuevoNombre);
                seleccionado.setDescripcion(nuevaDescripcion);
                seleccionado.setPrecio(Double.parseDouble(nuevoPrecio));
                showAlert("Exito, Producto editado correctamente");
                listaProductosView.refresh();
                clearFields();
            } else {
                showAlert("ERROR, Todos los campos deben ser completados");
            }
        } else {
            showAlert("ERROR, No hay ningun producto seleccionado");
        }
    }



    @FXML
    private void saveInFile() {
        FileUtils.WriteFile("export_Productos.dat", new LinkedList<Producto>());
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
    private boolean validateId(String Id){
        return Id.matches("[1-9]{1,3}");
    }
    private boolean validateNombre(String Nombre){
        return (Nombre.length() > 3 && Nombre.matches("[A-Z]{1}[a-z]{2,100}"));
    }
    private boolean validateDescripcion(String Descripcion){
        return (Descripcion.length() > 10);
    }
    private boolean validatePrecio(String Precio){
        return Precio.matches("[1-9]{1,3}[,]{1}[1-9]{2}");
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    private Producto productoseleccionado() {
        Producto seleccionado = listaProductosView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            quitarProductoBtn.setDisable(false);
            editarProdcutoBtn.setDisable(false);
        } else {
            quitarProductoBtn.setDisable(true);
            editarProdcutoBtn.setDisable(true);
        }
        return seleccionado;
    }
}

