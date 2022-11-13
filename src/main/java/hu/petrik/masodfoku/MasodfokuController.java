package hu.petrik.masodfoku;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

public class MasodfokuController {

    @FXML
    private TextField elsoText;
    @FXML
    private TextField masodikText;
    @FXML
    private TextField harmadikText;
    @FXML
    private Button buttonSzamolas;
    @FXML
    private Label xErtek1;
    @FXML
    private Label xErtek2;
    @FXML
    public void szamolasClick(ActionEvent actionEvent) {
        double elsoertek = Double.parseDouble(elsoText.getText());
        double masodikertek = Double.parseDouble(masodikText.getText());
        double harmadikertek = Double.parseDouble(harmadikText.getText());
        double diszkriminans = masodikertek * masodikertek - 4.0 * elsoertek * harmadikertek;
        if (diszkriminans == 0){
            double r1 = (-masodikertek + Math.pow(diszkriminans, 0.5)) / (2.0 * elsoertek);
            xErtek1.setText("x1 = " + String.valueOf(r1));
            xErtek2.setText("");
        }else if(diszkriminans < 0){
            xErtek1.setText("Nem oldható meg a valós számok halmazán!");
            xErtek2.setText("");
        }else{
            double r1 = (-masodikertek + Math.pow(diszkriminans, 0.5)) / (2.0 * elsoertek);
            double r2 = (-masodikertek - Math.pow(diszkriminans, 0.5)) / (2.0 * elsoertek);
            xErtek1.setText(String.valueOf("x1 = " + r1));
            xErtek2.setText(String.valueOf("x2 = " + r2));
        }
    }
    public void textField1Change(KeyEvent keyEvent) {
        elsoText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    elsoText.setText(newValue.replaceAll("\\D",""));
                }
            }
        });
    }
    public void textField2Change(KeyEvent keyEvent) {
        masodikText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    masodikText.setText(newValue.replaceAll("\\D",""));
                }
            }
        });
    }
    public void textField3Change(KeyEvent keyEvent) {
        harmadikText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    harmadikText.setText(newValue.replaceAll("\\D",""));
                }
            }
        });
    }
}