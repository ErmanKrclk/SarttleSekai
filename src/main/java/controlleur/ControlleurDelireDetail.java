package controlleur;

import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Modality;

public class ControlleurDelireDetail {

    @FXML
    private Label titreDelire;

    @FXML
    private ImageView imageDelire;

    @FXML
    private Text textDelire;

    @FXML

    public void setContenu(String titre, String texte, String imagePath){
        titreDelire.setText(titre);
        textDelire.setText(texte);
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageDelire.setImage(image);
        } catch(Exception e){
            System.out.println("Erreur de chargement d'image : " + imagePath);
        }
    }
}