package com.decroly.ejemplojavafx;

import com.decroly.ejemplojavafx.model.Persona;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Maincontroller implements Initializable {

    private Persona person;

    //Panel principal
    @FXML
    private VBox mainPanel;


    //Campos de texto del formulario
    @FXML
    private TextField nameTextLabel;

    @FXML
    private TextField surnameTextLabel;

    @FXML
    private TextField ageTextLabel;

    @FXML
    private TextField emailTextLabel;

    @FXML
    private TextField phoneTextLabel;

    //Eventos
    @FXML
    protected void onSaveButtonAction(ActionEvent event) {
        person = new Persona();

        try {
            person.setNombre(nameTextLabel.getText());
            person.setApellido(surnameTextLabel.getText());
            person.setEdad(Integer.parseInt(ageTextLabel.getText()));
            person.setEmail(emailTextLabel.getText());
            person.setTelefono(phoneTextLabel.getText());

        }catch (NumberFormatException e) {
            ageTextLabel.setText("");
            ageTextLabel.setPromptText("Escribe un numero paleto");
        }
    }

    @FXML
    protected void onCloseButtonAction(ActionEvent event) {
        Platform.exit();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}