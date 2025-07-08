package controlleur;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControlleurDelires {

    @FXML
    private ImageView logo;
    @FXML
    private ImageView backgroundImage;

    @FXML
    public void initialize(){
    if (backgroundImage != null) {
        backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {     
        if (newScene != null) {
            backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
        backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
        }
    });
    //pour afficher le logo dans le nav
    Image img = new Image(getClass().getResourceAsStream("/ressources/app_icon.png"));
    logo.setImage(img);

    }

}

}