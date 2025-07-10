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
import javafx.scene.control.TextArea;
import javafx.stage.Modality;

public class ControlleurDelireDetail {

    @FXML
    private Label titreDelire;

    @FXML
    private ImageView imageDelire;

    @FXML
    private TextArea textDelire;

    @FXML

    public void setContenu(String titre, String texte, String imagePath){
        titreDelire.setText(titre);
        textDelire.setText(texte);
        if (imagePath != null && !imagePath.isEmpty()){
            imageDelire.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        }
        
    }

}