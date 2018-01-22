/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Tony
 */
public class calcFXMLDocumentController implements Initializable {
    
    @FXML
    private Label workspace, result;
    private long input = 0;
    private boolean start = true;
    private String operator = "";
    private float output;
    
    @FXML
    public void processNumbers(ActionEvent event) {
        if(start){
            start = false;
            workspace.setText("");
        }
        String value = ((Button)event.getSource()).getText();
        workspace.setText(workspace.getText()+value);
        //result.setText(result.getText() + value);
    }
    
    public void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            input = Long.parseLong(workspace.getText());
            workspace.setText("");
        }else{
            if(operator.isEmpty()){
                return;
            }
            long input2 = Long.parseLong(workspace.getText());
            output = Model.calculate(input, input2, operator);
            workspace.setText(String.valueOf(output));
        }
        
    }
    @FXML
    public void reset(){
        clean();
        workspace.setText("0");
        input = 0;
    }
    
    public void clean(){
        start = true;
        operator = "";
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        workspace.setText("0");
        workspace.setText("0");
    }    
    
}
