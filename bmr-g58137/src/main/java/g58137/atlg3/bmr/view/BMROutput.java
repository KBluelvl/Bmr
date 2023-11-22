package g58137.atlg3.bmr.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * Represents the output of the bmr.
 * @author Florian Essomba
 */
public class BMROutput extends GridPane {
    private TextField bmrTF;
    private TextField caloriesTF;

    /**
     * Constructs a new BMROutput which initializes bmrTF and caloriesTF attributes.
     */
    public BMROutput(){
        this.setVgap(5);
        Text text2 = new Text("Résultats");
        text2.setUnderline(true);
        this.add(text2,0,0 );
        this.bmrTF = setBMRTF();
        this.caloriesTF = setCaloriesTF();
    }

    /**
     * Set the BMRTF attribute.
     * @return a textField.
     */
    private TextField setBMRTF(){
        Label bmr = new Label("BMR");
        this.add(bmr,0,1);
        TextField result = new TextField();
        result.setPromptText("Résultats du BMR");
        result.setEditable(false);
        this.add(result,1,1);
        return result;
    }

    /**
     * Set the caloriesTF attribute.
     * @return a TextField.
     */
    private TextField setCaloriesTF(){
        Label calories = new Label("Calories");
        this.add(calories,0,2);
        TextField depense = new TextField();
        depense.setPromptText("Dépense en calories");
        depense.setEditable(false);
        this.add(depense,1,2);
        return depense;
    }

    /**
     * Set the BMRTF's text.
     * @param bmr a given text.
     */
    public void setBMR(double bmr){
        bmrTF.setText(""+bmr);
    }

    /**
     * Set the bmr's text.
     * @param bmr a given string.
     */
    public void setBMR(String bmr){ // remplacer ceci par une méthode: displayBmrErroMessage(String bmrMessage)
        bmrTF.setText(bmr);
    }

    /**
     * Set the calories's text.
     * @param calories a given double.
     */
    public void setCalories(double calories){
        caloriesTF.setText(""+calories);
    }

    /**
     * Set the calories's text.
     * @param calories a given string.
     */
    public void setCalories(String calories){
        caloriesTF.setText(calories);
    }
}
