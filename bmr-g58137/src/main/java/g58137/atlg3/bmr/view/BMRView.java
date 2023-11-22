package g58137.atlg3.bmr.view;

import g58137.atlg3.bmr.model.Facade;
import g58137.atlg3.bmr.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Pattern;

/**
 * Represents a view.
 * @author Florian Essomba
 */
public class BMRView extends Application implements Observer {
    private BMRInput bmrInput;
    private BMROutput bmrOutput;
    private Facade facade;
    private static final String USER_DATA = "\\d+\s\\d+\s\\d+";

    public BMRView(){
        this.bmrInput = new BMRInput();
        this.bmrOutput = new BMROutput();
        this.facade = new Facade();
        facade.register(this);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calcul du BMR");

        // MenuBar
        MenuBar menuBar = new MenuBar();
        // Menu
        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        // MenuItem
        MenuItem exit = new MenuItem("Exit");
        file.getItems().add(exit);
        exit.setOnAction((ActionEvent t) -> System.exit(0));
        // root -> VBox
        VBox root = new VBox(menuBar);
        root.setAlignment(Pos.TOP_CENTER);

        root.setPadding(new Insets(0,0,5,0)); // v = top; v1= droite; v2 = bas; v3 = gauche
        root.setSpacing(10);
        Scene scene = new Scene(root);
        // HBox
        HBox hbox = new HBox();
        root.getChildren().add(hbox);
        VBox.setMargin(hbox,new Insets(20,10,5,10)); // v = top; v1= droite; v2 = bas; v3 = gauche
        // Ajoute les deux GridPane au HBox
        hbox.getChildren().addAll(bmrInput,bmrOutput);
        // Bouton calcul
        Button btnCalcul = new Button("Calcul du BMR");
        btnCalcul.setMaxWidth(400);
        btnCalcul.setAlignment(Pos.CENTER);
        root.getChildren().add(btnCalcul);
        // Alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'encodage");
        alert.setHeaderText("Valeur de la taille éronnée");
        alert.setContentText("vous devez encoder une valeur strictement supérieur à zéro.");
        // Quand on clique sur btnCalcul
        btnCalcul.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    if (goodValue(bmrInput.getTailleTF(), bmrInput.getPoidsTF(), bmrInput.getAgeTF(),
                            bmrInput.getSexe(), bmrInput.getLifeStyleCB())) {
                        if (notZero(bmrInput.getTailleTF(), bmrInput.getPoidsTF(),
                                bmrInput.getAgeTF())) {
                            facade.set(Integer.parseInt(bmrInput.getAgeTF()),
                                    Integer.parseInt(bmrInput.getTailleTF()),
                                    Integer.parseInt(bmrInput.getPoidsTF()),
                                    bmrInput.getFemmeRB(),
                                    bmrInput.getHommeRB(),
                                    bmrInput.getLifeStyle());
                        } else {
                            alert.show();
                        }
                    }
                } catch (Exception e){
                        bmrOutput.setBMR("Failed !");
                        bmrOutput.setCalories("Failed !");
                    }
            }
        });

        // Bouton clear
        Button clear = new Button("Clear");
        clear.setMaxWidth(400);
        root.getChildren().add(clear);
        clear.setAlignment(Pos.CENTER);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bmrInput.setTailleTF("");
                bmrInput.setPoidsTF("");
                bmrInput.setAgeTF("");
                bmrInput.setFemmeRB(false);
                bmrInput.setHommeRB(false);
                bmrInput.setLifeStyleCB(null);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    /**
     * If there is a correct value in the TextField.
     * @param taille a given size.
     * @param poids a given height.
     * @param age a given age.
     * @param sexe a given sexe.
     * @param styleDeVie a given style.
     * @return a boolean
     */
    private boolean goodValue(String taille, String poids, String age, String sexe, String styleDeVie){
        if(!taille.isEmpty() && !poids.isEmpty() && !age.isEmpty()) {
            return Pattern.matches(USER_DATA, taille + " " + poids + " " + age)
                    && sexe == "femme" || sexe.equals("homme") && !styleDeVie.isEmpty();
        }
        return false;
    }

    /**
     * Return true if there is a 0 in the input.
     * @param taille a given string
     * @param poids a given string
     * @param age a given string
     * @return a boolean
     */
    private boolean notZero(String taille, String poids, String age){
        return Integer.parseInt(taille) != 0 && Integer.parseInt(poids) != 0 && Integer.parseInt(age) != 0;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update() {
        bmrOutput.setBMR(facade.getBMR());
        bmrOutput.setCalories(facade.getCalories());
    }
}
