package hu.petrik.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField numberOne;
    @FXML
    private TextField numberTwo;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonMulti;
    @FXML
    private Button buttonDivision;
    @FXML
    private Button buttonRemain;
    @FXML
    private Label resultLabel;
    @FXML
    private Boolean joSzamok = false;
    @FXML
    public void Plus(ActionEvent actionEvent) {
        String bekert1 = numberOne.getText();
        String bekert2 = numberTwo.getText();
        check(bekert1, bekert2);
        if (joSzamok){
            double szam1 = Double.parseDouble(numberOne.getText());
            double szam2 = Double.parseDouble(numberTwo.getText());
            resultLabel.setText(String.valueOf(szam1 + szam2));
        }
    }
    @FXML
    public void minus(ActionEvent actionEvent) {
        String bekert1 = numberOne.getText();
        String bekert2 = numberTwo.getText();
        check(bekert1, bekert2);
        if (joSzamok){
            double szam1 = Double.parseDouble(numberOne.getText());
            double szam2 = Double.parseDouble(numberTwo.getText());
            resultLabel.setText(String.valueOf(szam1 - szam2));
        }
    }
    @FXML
    public void Multi(ActionEvent actionEvent) {
        String bekert1 = numberOne.getText();
        String bekert2 = numberTwo.getText();
        check(bekert1, bekert2);
        if (joSzamok){
            double szam1 = Double.parseDouble(numberOne.getText());
            double szam2 = Double.parseDouble(numberTwo.getText());
            resultLabel.setText(String.valueOf(szam1 * szam2));
        }
    }
    @FXML
    public void division(ActionEvent actionEvent) {
        String bekert1 = numberOne.getText();
        String bekert2 = numberTwo.getText();
        check(bekert1, bekert2);
        if (joSzamok){
            double szam1 = Double.parseDouble(numberOne.getText());
            double szam2 = Double.parseDouble(numberTwo.getText());
            double ertek = szam1 / szam2;
            double vegeredmeny = Math.round(ertek * 100.0) / 100.0;
            resultLabel.setText(String.valueOf(vegeredmeny));
        }
    }
    @FXML
    public void remain(ActionEvent actionEvent) {
        String bekert1 = numberOne.getText();
        String bekert2 = numberTwo.getText();
        check(bekert1, bekert2);
        if (joSzamok){
            double szam1 = Double.parseDouble(numberOne.getText());
            double szam2 = Double.parseDouble(numberTwo.getText());
            double ertek = szam1 % szam2;
            double vegeredmeny = Math.round(ertek * 100.0) / 100.0;
            resultLabel.setText(String.valueOf(vegeredmeny));
        }
    }
    public void check(String bekertSzam1, String bekertSzam2){
        resultLabel.setText("");
        joSzamok = false;
        Alert felugroAblak = new Alert(Alert.AlertType.WARNING);
        if (numberOne.getText().isEmpty() && numberTwo.getText().isEmpty()){
            felugroAblak.setContentText("Nem adott meg étrékeket!");
            felugroAblak.show();
        }else if(numberOne.getText()==null){
            felugroAblak.setContentText("Az első rublikába nem adott értéket!");
            felugroAblak.show();
        }else if(numberTwo.getText() == null){
            felugroAblak.setContentText("A második rublikába nem adott értéket!");
            felugroAblak.show();
        }else{
            Boolean szam1 = true;
            Boolean szam2 = true;
            try{
                Double num1 = Double.parseDouble(bekertSzam1);
            }catch (NumberFormatException e){
                szam1 = false;
            }
            try{
                Double num2 = Double.parseDouble(bekertSzam2);
            }catch (NumberFormatException e){
                szam2 = false;
            }
            if (!szam1){
                felugroAblak.setContentText("Az első rublikába nem számot adott meg!");
                felugroAblak.show();
            }else if (!szam2){
                felugroAblak.setContentText("A második rublikába nem számot adott meg!");
                felugroAblak.show();
            }else{
                joSzamok = true;
            }
        }
    }
}