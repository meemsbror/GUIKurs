package recipesearch;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.lab2.Recipe;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;



public class RecipeSearchResultPane extends AnchorPane{
    Recipe recipe;
    Parent root;

    @FXML private Label nameLabel;
    @FXML private Label infoLabel;
    @FXML private ImageView recipeImage;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);



    public RecipeSearchResultPane(Recipe recipe){
        if(recipe==null){
            System.out.println("hej");
        }
        this.recipe=recipe;
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("search_results.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setRecipe();


    }

    public void addPropertyChangeListener(PropertyChangeListener p){
        pcs.addPropertyChangeListener(p);
    }

    public void recipeClicked(MouseEvent event){
        System.out.println("hej");
        pcs.firePropertyChange("recipe selected",null,recipe);
    }



    private void setRecipe(){

            recipeImage.setImage(recipe.getFXImage());
            nameLabel.setText(recipe.getName());
            infoLabel.setText(recipe.getCuisine() + "/n" +
                    recipe.getDifficulty() + "/n" +
                    recipe.getMainIngredient() + "/n" +
                    recipe.getServings() + "/n" +
                    recipe.getTime());

    }
}
