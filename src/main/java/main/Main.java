package main;
import java.io.IOException;
import java.time.Duration;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;


public class Main extends Application {


@Override
public void start(Stage premierStage){
//Image de fond
    Image background = new Image(getClass().getResourceAsStream("/ressources/images/background.png"));
    ImageView backgroundView = new ImageView(background);
    backgroundView.setPreserveRatio(false);

//titre 

Text titreBvn = new Text("Bienvenue dans ");
titreBvn.setFont(Font.font("Verdana", 28));
titreBvn.setFill(Color.LAVENDER);

Text nomApp = new Text("SarttleSekai");
nomApp.setFont(Font.font("Verdana", 38));
nomApp.setFill(Color.LAVENDER);

VBox blocTitre = new VBox(5, titreBvn, nomApp);
blocTitre.setAlignment(Pos.CENTER);

Button btnentrer = new Button("Entrer dans l'univers");
btnentrer.setStyle("-fx-background-color: #f2789f; -fx-text-fill: white; -fx-font-size: 14pt; -fx-background-radius: 20px;");
btnentrer.getStyleClass().add("bouton-entree");

btnentrer.setOnAction(e -> {
    try {
        Parent rootMenu = FXMLLoader.load(getClass().getResource("/vue/MenuPrincipal.fxml"));
        Scene sceneMenu = new Scene(rootMenu, 800, 600);
        sceneMenu.getStylesheets().add(getClass().getResource("/ressources/css/style.css").toExternalForm());
        premierStage.setScene(sceneMenu);

    } catch (IOException ex){
        ex.printStackTrace();
    }

});

Region espace = new Region();
espace.setMinHeight(50);

VBox contenu = new VBox(blocTitre,espace,btnentrer);
contenu.setAlignment(Pos.CENTER);
contenu.setPadding(new Insets(30));




// Pane racine
StackPane root = new StackPane();
root.getChildren().add(backgroundView);
root.getChildren().add(contenu);

// Creation de la scène

Scene scene = new Scene(root, 800, 600); //taille de base
scene.getStylesheets().add(getClass().getResource("/ressources/css/style.css").toExternalForm());
//Liaison dynamique pour que l'image suive la taille de la fenetre
backgroundView.fitWidthProperty().bind(scene.widthProperty());
backgroundView.fitHeightProperty().bind(scene.heightProperty());

//affichage 

premierStage.setTitle("SarttleSekai");
premierStage.setScene(scene);
premierStage.setMaximized(true); // pour que la fenetre soit automatiquement agrandie

Pane animationLayer = new Pane();
animationLayer.setPickOnBounds(false);
root.getChildren().add(animationLayer);

premierStage.show();

}



public static void main(String[] args){
    Font.loadFont(Main.class.getResourceAsStream("/ressources/fonts/BalonkuRegular-la1w.otf"), 10);
    System.out.println(Font.getFontNames().stream()
    .filter(name -> name.toLowerCase().contains("balonku"))
    .toList());
    launch(args);
}



}