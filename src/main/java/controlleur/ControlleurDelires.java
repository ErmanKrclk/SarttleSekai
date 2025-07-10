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

public class ControlleurDelires {

    @FXML
    private ImageView logo;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button btnAcceuil;

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

    if(btnAcceuil != null){
        btnAcceuil.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vue/MenuPrincipal.fxml"));
                Scene scene = new Scene(root, 800, 600);
                scene.getStylesheets().add(getClass().getResource("/ressources/css/style.css").toExternalForm());
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });
    }

applyCSS();
}

private void applyCSS(){
    if(backgroundImage != null){
        backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null && !newScene.getStylesheets().contains(getClass().getResource("/ressources/css/style.css").toExternalForm())); {
                newScene.getStylesheets().add(getClass().getResource("/ressources/css/style.css").toExternalForm());
            }
        });
    }
}


}