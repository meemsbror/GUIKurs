package recipesearch;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.lab2.Recipe;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;

/**
 * Created by frej on 2/8/16.
 */
public class RecipeSearchResultPane extends AnchorPane{
    Recipe recipe;
    Parent root;

    @FXML private Label nameLabel;
    @FXML private Label infoLabel;
    @FXML private ImageView recipeImage;



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

    private void setRecipe(){
            if(recipe==null) {
                System.out.println("fuck allt");
            }
            recipeImage.setImage(recipe.getFXImage());
            nameLabel.setText(recipe.getName());
            infoLabel.setText(recipe.getCuisine() + "/n" +
                    recipe.getDifficulty() + "/n" +
                    recipe.getMainIngredient() + "/n" +
                    recipe.getServings() + "/n" +
                    recipe.getTime());

    }
}
