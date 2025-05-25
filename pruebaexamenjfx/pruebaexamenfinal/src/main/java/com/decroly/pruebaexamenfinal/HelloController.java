package com.decroly.pruebaexamenfinal;

import com.decroly.pruebaexamenfinal.Utils.FileUtils;
import com.decroly.pruebaexamenfinal.model.Producto;
import com.decroly.pruebaexamenfinal.model.Producto_especial;
import com.decroly.pruebaexamenfinal.model.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    //Objetos para controlar las entidades
    private Producto_especial producto_especial;
    private Tipo tipo;
    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    //Paneles de la aplicacion

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
    private ComboBox tipoRegisterField;

    @FXML
    private TextField descuentoRegisterField;

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
    private Button quitarProductoBtn;

    @FXML
    private Button exportarDatosBtn;

    //Evento de los botones
    @FXML
    protected void onSaveButtonAction(javafx.event.ActionEvent event) {
        producto_especial = new Producto_especial();
        try{
            producto_especial.setId(Integer.parseInt(idRegisterField.getText()));
            producto_especial.setNombre(nombreRegisterField.getText());
            producto_especial.setDescripcion(descripcionRegisterField.getText());
            producto_especial.setPrecio(Double.parseDouble(precioRegisterField.getText()));
            producto_especial.setTipo(tipo);
            producto_especial.setDescuento(Integer.parseInt(descuentoRegisterField.getText()));

            //Ir al panel de lista de productos
            selectPanelVisible(2);

            productos.add(producto_especial);
        } catch (NumberFormatException e) {
            idRegisterField.setText("");
            idRegisterField.setPromptText("Ingrese un numero");
            precioRegisterField.setText("");
            precioRegisterField.setPromptText("Ingrese un numero");
            descuentoRegisterField.setText("");
            descuentoRegisterField.setPromptText("Ingrese un numero");
        }
    }

    @FXML
    protected void onRegisterBtnAction(javafx.event.ActionEvent event) {
        //Ir al panel de registro de producto
        selectPanelVisible(1);
        this.clearFields();
    }


    @FXML
    protected void onRemoveSelectedItemAction(javafx.event.ActionEvent event) {
        boolean remove = productos.remove(listaProductosView.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected void onBtnSaveInFile(javafx.event.ActionEvent event) {
        FileUtils.WriteFile("export_Productos.dat", new LinkedList<Producto_especial>());
    }

    //Metodo initialize que se ejecuta al inicarse el HelloController
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaPanel.setVisible(false);
        registrarPanel.setVisible(true);

        idRegisterField.setPromptText("Id");
        nombreRegisterField.setPromptText("Nombre");
        descripcionRegisterField.setPromptText("Descripcion");
        precioRegisterField.setPromptText("Precio");
        tipoRegisterField.setPromptText("Tipo");
        descuentoRegisterField.setPromptText("Descuento");

        List<Producto_especial> especial_product = loadFileProductos();
        productos.addAll(especial_product);
        listaProductosView.setItems(productos);


        //Añadir listener a la propiedad de elemento seleccionado de la lista
        listaProductosView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                registrarProductoBtn.setDisable(true);
                quitarProductoBtn.setDisable(true);
            }
            else {
                registrarProductoBtn.setDisable(false);
                quitarProductoBtn.setDisable(false);
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
    //metodo initialize
    private List<Producto_especial> loadFileProductos(){
        return FileUtils.readFile("export_Productos.dat");
    }

    //Metodos internos para realizar operaciones
    private void clearFields(){
        idRegisterField.setText("");
        nombreRegisterField.setText("");
        descripcionRegisterField.setText("");
        precioRegisterField.setText("");
        tipoRegisterField.setPromptText("Tipo");
        descuentoRegisterField.setText("Descuento");
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
}