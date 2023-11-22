package g58137.atlg3.bmr.view;

import g58137.atlg3.bmr.model.LifeStyle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * Represents the input of the bmr.
 * @author Florian Essomba
 */
public class BMRInput extends GridPane {
    private TextField tailleTF;
    private TextField poidsTF;
    private TextField ageTF;
    private RadioButton femmeRB;
    private RadioButton hommeRB;
    private ChoiceBox lifeStyleCB;

    /**
     * Construts a new BMRInput.
     */
    public BMRInput(){
        this.setVgap(10);
        this.setHgap(5);
        Text text1 = new Text("Données");
        text1.setUnderline(true);
        this.add(text1,0,0); // i = x; i1 = y
        initTailleTF();
        initPoidsTF();
        initAgeTF();
        initSexe();
        ToggleGroup toggleGroup = new ToggleGroup();
        initFemmeRB(toggleGroup);
        initHommeRB(toggleGroup);
        initLifeStyleCB();
    }

    /**
     * Init the tailleTF attribute.
     */
    private void initTailleTF(){
        Label taille = new Label("Taille (cm)");
        this.add(taille,0, 1); // i = x; i1 = y
        tailleTF = new TextField();
        tailleTF.setPromptText("Taille en cm");
        tailleTF.addEventFilter(
                KeyEvent.KEY_TYPED,
                addFilter()
        );
        this.add(tailleTF,1,1);
    }

    /**
     * Init the poidsTF attribute.
     */
    private void initPoidsTF(){
        Label poids = new Label("Poids (kg)");
        this.add(poids,0, 2); // i = x; i1 = y
        poidsTF = new TextField();
        poidsTF.setPromptText("Poids en kg");
        poidsTF.addEventFilter(
                KeyEvent.KEY_TYPED,
                addFilter()
        );
        this.add(poidsTF,1, 2);
    }

    /**
     * Init the ageTF attribute.
     */
    private void initAgeTF(){
        Label age = new Label("Age (années)");
        this.add(age,0, 3); // i = x; i1 = y
        ageTF = new TextField();
        ageTF.setPromptText("Age en années");
        ageTF.addEventFilter(
                KeyEvent.KEY_TYPED,
                addFilter()
        );
        this.add(ageTF,1, 3);
    }

    /**
     * Init the Label sexe.
     */
    private void initSexe(){
        Label sexe = new Label("Sexe");
        this.add(sexe,0, 4); // i = x; i1 = y
    }

    /**
     * Init the femmeRB attribute.
     * @param toggleGroup a given toggleGroup.
     */
    private void initFemmeRB(ToggleGroup toggleGroup){
        femmeRB = new RadioButton("Femme");
        femmeRB.setToggleGroup(toggleGroup);
        this.add(femmeRB,1,4);
    }

    /**
     * Init the hommeRB attribute.
     * @param toggleGroup a given toggleGroup.
     */
    private void initHommeRB(ToggleGroup toggleGroup){
        hommeRB = new RadioButton("Homme");
        hommeRB.setToggleGroup(toggleGroup);
        this.add(hommeRB,2,4);
    }

    /**
     * Init the lifeStyleCB attribute.
     */
    private void initLifeStyleCB(){
        Label vie = new Label("Style de vie");
        this.add(vie,0, 5); // i = x; i1 = y
        lifeStyleCB = new ChoiceBox(FXCollections
                .observableArrayList("Sédentaire", "Peu actif","Actif","Fort actif","Extrêmement actif"));
        this.add(lifeStyleCB,1,5);
    }

    /**
     * Add a filter.
     * @return an EvenHandler.
     */
    private EventHandler addFilter(){
        EventHandler filter = new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!( (KeyEvent) event).getCharacter().matches("\\d+")){
                    event.consume();
                }
            }
        };
        return filter;
    }

    public String getTailleTF() {
        return tailleTF.getText();
    }

    public String getAgeTF() {
        return ageTF.getText();
    }

    public String getPoidsTF() {
        return poidsTF.getText();
    }

    public String getSexe(){
        if(femmeRB.selectedProperty().get()){
            return "femme";
        } else if (hommeRB.selectedProperty().get()) {
            return "homme";
        }
        return "";
    }

    public String getLifeStyleCB() {
        return (String) lifeStyleCB.getValue();
    }

    public boolean getFemmeRB() {
        return femmeRB.selectedProperty().get();
    }

    public boolean getHommeRB() {
        return hommeRB.selectedProperty().get();
    }

    public double getLifeStyle() {
        if(lifeStyleCB.getValue() == null){
            throw new IllegalArgumentException("No data matches in lifeStyle");
        }
        switch (lifeStyleCB.getValue().toString()) {
            case "Sédentaire":
                return LifeStyle.SEDENTAIRE.getValue();
            case "Peu actif":
                return LifeStyle.PEU_ACTIF.getValue();
            case "Actif":
                return LifeStyle.ACTIF.getValue();
            case "Fort actif":
                return LifeStyle.FORT_ACTIF.getValue();
            case "Extrêmement actif":
                return LifeStyle.EXTREMEMENT_ACTIF.getValue();
            default:
                System.out.println(lifeStyleCB.toString());
                throw new IllegalArgumentException("No data matches in lifeStyle");
        }
    }

    public void setTailleTF(String tailleTF) {
        this.tailleTF.setText(tailleTF);
    }

    public void setPoidsTF(String poidsTF) {
        this.poidsTF.setText(poidsTF);
    }

    public void setAgeTF(String ageTF) {
        this.ageTF.setText(ageTF);
    }

    public void setLifeStyleCB(Boolean bool) {
        this.lifeStyleCB.setValue(bool);
    }

    public void setFemmeRB(Boolean bool) {
        this.femmeRB.selectedProperty().setValue(bool);
    }

    public void setHommeRB(Boolean bool) {
        this.hommeRB.selectedProperty().setValue(bool);
    }
}
