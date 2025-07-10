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
import javafx.stage.Modality;

public class ControlleurDelires {

    @FXML
    private ImageView logo;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button btnAcceuil;
    @FXML
    private Button btnChien;
    @FXML
    private Button btnBowling;

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

    if (btnChien != null){
        btnChien.setOnAction(e -> ouvrirFenetreDelire(
            "Chien arret maladie",
            "Quand le chien est intoxifier par les poubelles a stirox",
            "/ressources/images/malinoisVisage.png"
        ));
    }

    if (btnBowling != null){
        btnBowling.setOnAction(e -> ouvrirFenetreDelire(
            "Bowling",
            "Sarah qui me spawn kill h24",
            "/ressources/images/bowling.jpg"
        ));
    }
}

private void ouvrirFenetreDelire(String titre, String texte, String imagePath) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/DeliresDetail.fxml"));
        Parent root = fxmlLoader.load();

        ControlleurDelireDetail controller = fxmlLoader.getController();
        controller.setContenu(titre, texte, imagePath);

        Stage stage = new Stage();
        stage.setTitle(titre);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    } catch (IOException e){
        e.printStackTrace();
    }

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