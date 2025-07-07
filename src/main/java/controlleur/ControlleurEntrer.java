package controlleur;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControlleurEntrer {
    
    @FXML
    private ImageView logo;

    @FXML
    private Button btnQuitter;

    @FXML
    private ImageView backgroundImage;

    @FXML
    public void initialize(){
    if (backgroundImage != null) {
        backgroundImage.fitWidthProperty().bind(backgroundImage.getScene().widthProperty());
        backgroundImage.fitHeightProperty().bind(backgroundImage.getScene().heightProperty());
        // Pour que le binding fonctionne même si la scène n'est pas encore prête
        backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
                backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
            }
        });

        //pour afficher le logo dans le nav
        Image img = new Image(getClass().getResourceAsStream("/ressources/app_icon.png"));
        logo.setImage(img);

        btnQuitter.setOnAction(e -> Platform.exit());
    }
}
}
