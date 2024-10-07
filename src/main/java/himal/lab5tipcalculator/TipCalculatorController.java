//package himal.lab5tipcalculator;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.NumberFormat;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.Slider;
//import javafx.scene.control.TextField;
//
//public class TipCalculatorController {
//    // formatters for currency and percentages
//    private static final NumberFormat currency =
//            NumberFormat.getCurrencyInstance();
//    private static final NumberFormat percent =
//            NumberFormat.getPercentInstance();
//
//    private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
//
//    // GUI controls defined in FXML and used by the controller's code
//    @FXML
//    private TextField amountTextField;
//
//    @FXML
//    private Label tipPercentageLabel;
//
//    @FXML
//    private Slider tipPercentageSlider;
//
//    @FXML
//    private TextField tipTextField;
//
//    @FXML
//    private TextField totalTextField;
//
//    // calculates and displays the tip and total amounts
//    @FXML
//    private void calculateButtonPressed(ActionEvent event) {
//        try {
//            BigDecimal amount = new BigDecimal(amountTextField.getText());
//            BigDecimal tip = amount.multiply(tipPercentage);
//            BigDecimal total = amount.add(tip);
//
//            tipTextField.setText(currency.format(tip));
//            totalTextField.setText(currency.format(total));
//        }
//        catch (NumberFormatException ex) {
//            amountTextField.setText("Enter amount");
//            amountTextField.selectAll();
//            amountTextField.requestFocus();
//        }
//    }
//
//    // called by FXMLLoader to initialize the controller
//    public void initialize() {
//        // 0-4 rounds down, 5-9 rounds up
//        currency.setRoundingMode(RoundingMode.HALF_UP);
//
//        // listener for changes to tipPercentageSlider's value
//        tipPercentageSlider.valueProperty().addListener(
//                new ChangeListener<Number>() {
//                    @Override
//                    public void changed(ObservableValue<? extends Number> ov,
//                                        Number oldValue, Number newValue) {
//                        tipPercentage =
//                                BigDecimal.valueOf(newValue.intValue() / 100.0);
//                        tipPercentageLabel.setText(percent.format(tipPercentage));
//                    }
//                }
//        );
//    }
//}

package himal.lab5tipcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
    // formatters for currency and percentages
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

    // GUI controls defined in FXML and used by the controller's code
    @FXML
    private TextField amountTextField;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    private final StringProperty tipAmount = new SimpleStringProperty("");
    private final StringProperty totalAmount = new SimpleStringProperty("");

    // called by FXMLLoader to initialize the controller
    public void initialize() {
        // 0-4 rounds down, 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);

        // Bind the tipPercentageLabel text to the slider value
        tipPercentageLabel.textProperty().bind(Bindings.createStringBinding(
                () -> percent.format(tipPercentageSlider.getValue() / 100.0),
                tipPercentageSlider.valueProperty()
        ));

        // Add a listener to the amountTextField to update the calculation when it changes
        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> calculate());

        // Add a listener to the slider to update the calculation when it changes
        tipPercentageSlider.valueProperty().addListener((observable, oldValue, newValue) -> calculate());

        // Bind the tip and total fields to their respective calculated values
        tipTextField.textProperty().bind(tipAmount);
        totalTextField.textProperty().bind(totalAmount);
    }

    // Method to calculate the tip and total
    private void calculate() {
        try {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(BigDecimal.valueOf(tipPercentageSlider.getValue() / 100.0));
            BigDecimal total = amount.add(tip);

            tipAmount.set(currency.format(tip));
            totalAmount.set(currency.format(total));
        } catch (NumberFormatException ex) {
            tipAmount.set("");
            totalAmount.set("");
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }
}
