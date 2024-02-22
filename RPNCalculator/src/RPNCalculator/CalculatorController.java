/**
 * CSIS 312 Assignment 2.
 * @author Wade Schofield and Abby Schofield
 *
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
 * Complete the methods noted below
 **/

package RPNCalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author 
 */
public class CalculatorController implements Initializable
{
    // Composition instance variables
    String currentVal = "";
    RPNModel rpn;

    @FXML
    private Button buttonZero;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonSeven;
        
    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonSign;

    @FXML
    private Button buttonDivide;
    
    @FXML
    private TextArea display;

    @FXML
    private Button buttonEnter;

    @FXML
    private Button buttonDrop;

    @FXML
    private Label errorMessage;

    /**
     * Drop the top value on the stack
     * @param event - not used
     */
    @FXML
    void buttonDropClick(ActionEvent event) {
        if (currentVal.equals("")) {
            if (!rpn.drop())
                displayErrorMessage("No Value to Drop");
        }
        else
        {
            currentVal = currentVal.substring(0,currentVal.length()-1);
        }
        updateDisplay();
    }

    /**
     * Push the entered value onto the stack
     * @param event - not used
     */
    @FXML
    void buttonEnterClick(ActionEvent event) {
        try {
            if (rpn.enter(Integer.parseInt(currentVal))){
                currentVal = "";
                updateDisplay();
            }
            else
            {
                displayErrorMessage("Stack Full");
            }
        }
        catch (Exception e)
        {
            displayErrorMessage("Invalid Value");
        }
    }

    /**
     * 5 button handler
     * @param event
     */
    @FXML
    void buttonFiveClick(ActionEvent event) {
        currentVal = currentVal + "5";
        updateDisplay();
    }

    /**
     * 4 button handler
     * @param event - not used
     */
    @FXML
    void buttonFourClick(ActionEvent event) {
        currentVal = currentVal + "4";
        updateDisplay();
    }

    /**
     * 1 button handler
     * @param event - not used
     */
    @FXML
    void buttonOneClick(ActionEvent event) {
        currentVal = currentVal + "1";
        updateDisplay();
    }

    /**
     * 7 button handler
     * @param event
     */
    @FXML
    void buttonSevenClick(ActionEvent event) {
        currentVal = currentVal + "7";
        updateDisplay();
    }

    /**
     * 6 button handler
     * @param event - not used
     */
    @FXML
    void buttonSixClick(ActionEvent event) {
        currentVal = currentVal + "6";
        updateDisplay();
    }

    /**
     * 3 button handler
     * @param event - unused
     */
    @FXML
    void buttonThreeClick(ActionEvent event) {
        currentVal = currentVal + "3";
        updateDisplay();
    }

    /**
     * 2 button hanlder
     * @param event - not used
     */
    @FXML
    void buttonTwoClick(ActionEvent event) {
        currentVal = currentVal + "2";
        updateDisplay();
    }

    /**
     * zero button handler
     * @param event
     */
    @FXML
    void buttonZeroClick(ActionEvent event) {
        currentVal = currentVal + "0";
        updateDisplay();
    }

    /**
     * Complete the + operation
     * @param event
     */
    @FXML
    void buttonPlusClick(ActionEvent event) {
        checkCursor();
        if(!rpn.add())
            displayErrorMessage("ERROR: Insufficient Operands");
        else
            updateDisplay();
    }
    
    @FXML
    void buttonMinusClick(ActionEvent event) {
        checkCursor();
        if (!rpn.subtract())
            displayErrorMessage("ERROR: Insufficient Operands");
        else
            updateDisplay();
    }

    /**
     * Complete the divide operation
     * @param event - unused
     */
    @FXML
    void buttonDivideClick(ActionEvent event) throws Exception {
        checkCursor();
        if (!rpn.divide())
            displayErrorMessage("ERROR: Insufficient Operands");
        else
            updateDisplay();
    }

    /**
     * Multiply operation
     * @param event - not used
     */
    @FXML
    void buttonMultiplyClick(ActionEvent event) {
        checkCursor();
        if (!rpn.multiply())
            displayErrorMessage("ERROR: Insufficient Operands for Multiply");
        else
            updateDisplay();
    }

    /**
     * 8 button handler
     * @param event
     */
    @FXML
    void buttonEightClick(ActionEvent event) {
        currentVal = currentVal + "8";
        updateDisplay();
    }


    /**
     * 9 button handler
     * @param event - unused
     */
    @FXML
    void buttonNineClick(ActionEvent event) {
        currentVal = currentVal + "9";
        updateDisplay();
    }

    /**
     * Displays an error message at the bottom
     * @param msg - error to display
     */
    void displayErrorMessage(String msg)
    {
        errorMessage.setText(msg);
    }

    /**
     * Updates the display and clears the error indicator
     */
    public void updateDisplay()
    {
        try {
            String stack = rpn.getValues();
            display.setText(stack + currentVal);
            errorMessage.setText("");
        }
        catch(Exception e)
        {
            displayErrorMessage(e.getMessage());
        }
    }

    /**
     * If a value has been entered, it is pushed on the stack. If not, no action is taken.
     */
    private void checkCursor()
    {
        if (currentVal.length() > 0) {
            try {
                if (rpn.enter(Integer.parseInt(currentVal)))
                    currentVal = "";

            }
            catch (Exception e) // shouldn't happen
            {
                displayErrorMessage("ERROR: Invalid Value");
            }
        }
    }

    /** GUI Initialization
     *
     * @param url - not used
     * @param rb - not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        rpn = new RPNModel();
        display.setFont(Font.font("Serif", FontWeight.NORMAL, 22));
        display.setPrefRowCount(6);
    }
}
