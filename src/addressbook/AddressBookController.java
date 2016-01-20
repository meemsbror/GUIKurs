
package addressbook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.chalmers.cse.dat215.lab1.Presenter;


public class AddressBookController implements Initializable {
    
    @FXML private MenuBar menuBar;
    @FXML private Button closeAboutButton;
    @FXML private Button newButton;
    @FXML private Button deleteButton;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField phone;
    @FXML private TextField email;
    @FXML private TextField address;
    @FXML private TextField postCode;
    @FXML private TextField city;
    @FXML private ListView listView;
    private Presenter pr;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pr = new Presenter(listView,
                firstName,
                lastName,
                phone,
                email,
                address,
                postCode,
                city
                );

        pr.init();


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                pr.contactsListChanged();
            }

        });
        
    }
    @FXML
    protected void newButtonActionPerformed (ActionEvent event){
        pr.newContact();
    }

    @FXML
    protected void deleteButtonActionPerformed (ActionEvent event){
        pr.removeCurrentContact();
    }

    @FXML
    protected void openAboutActionPerformed(ActionEvent event) throws IOException{
    
        ResourceBundle bundle = ResourceBundle.getBundle("addressbook/resources/AddressBook");
        Parent root = FXMLLoader.load(getClass().getResource("address_book_about.fxml"), bundle);
        Stage aboutStage = new Stage();
        aboutStage.setScene(new Scene(root));
        aboutStage.setTitle(bundle.getString("about.title.text"));
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.initOwner(menuBar.getScene().getWindow());
        aboutStage.setResizable(false);
        aboutStage.showAndWait();
    }
    
    @FXML 
    protected void closeAboutActionPerformed(ActionEvent event) throws IOException{
        
        Stage aboutStage = (Stage) closeAboutButton.getScene().getWindow();
        aboutStage.hide();
    }
    
    @FXML 
    protected void closeApplicationActionPerformed(ActionEvent event) throws IOException{
        
        Stage addressBookStage = (Stage) menuBar.getScene().getWindow();
        addressBookStage.hide();
    }    
}
