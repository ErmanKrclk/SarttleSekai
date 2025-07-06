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
    public void initialize(){
        //pour afficher le logo dans le nav
        Image img = new Image(getClass().getResourceAsStream("/ressources/app_icon.png"));
        logo.setImage(img);

        btnQuitter.setOnAction(e -> Platform.exit());
    }
}
