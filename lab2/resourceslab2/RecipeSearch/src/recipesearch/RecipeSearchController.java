
package recipesearch;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;


public class RecipeSearchController implements Initializable {
    
    @FXML private MenuBar menuBar;


    //The different "Tabs" that contain information.
    @FXML private AnchorPane pane1;
    @FXML private AnchorPane pane2;
    @FXML private AnchorPane pane3;
    
    @FXML private ChoiceBox cuisineChoiceBox;
    @FXML private ChoiceBox ingredientChoiceBox;
    @FXML private RadioButton ezRadio;
    @FXML private RadioButton lessEzRadio;
    @FXML private RadioButton notEzRadio;
    @FXML private TextField priceTextField;
    @FXML private Slider timeSlider;
    @FXML private Button searchButton;

    //Pane numero dos
    @FXML private AnchorPane recipe1;

    //Pane numero dres
    @FXML private Label nameText;
    @FXML private Label ingredientText;
    @FXML private Label descriptionText;
    @FXML private ImageView recipePic;






    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    @FXML 
    protected void openAboutActionPerformed(ActionEvent event) throws IOException{
    
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("recipesearch/resources/RecipeSearch");
        Parent root = FXMLLoader.load(getClass().getResource("recipe_search_about.fxml"), bundle);
        Stage aboutStage = new Stage();
        aboutStage.setScene(new Scene(root));
        aboutStage.setTitle(bundle.getString("about.title.text"));
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.setResizable(false);
        aboutStage.showAndWait();
    }
    
    @FXML 
    protected void closeApplicationActionPerformed(ActionEvent event) throws IOException{
        
        Stage addressBookStage = (Stage) menuBar.getScene().getWindow();
        addressBookStage.hide();
    }

    @FXML
    protected void backButton1ActionPreformed(ActionEvent event){
        pane1.toFront();
    }
    @FXML
    protected void backButton2ActionPreformed(ActionEvent event){
        pane2.toFront();
    }
    @FXML
    protected void recipeChoosen(MouseEvent event){
        recipeText.setText("");
        pane3.toFront();
    }
    @FXML
    protected void recipeHoover(MouseEvent event){
        //TODO
    }
    @FXML
    protected void searchButtonActionPreformed(ActionEvent event){
        pane2.toFront();
    }
}
