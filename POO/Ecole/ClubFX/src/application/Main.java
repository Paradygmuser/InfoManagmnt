package application;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// rendre la fenêtre transparente (sans décor natif)
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			// root transparent qui contient une "carte" arrondie avec effet
			StackPane root = new StackPane();
			root.setPadding(new Insets(20)); // espace pour laisser l'ombre visible
			root.setStyle("-fx-background-color: transparent;");
			
			// Utiliser un Rectangle arrondi (plutôt qu'un Region+clip) pour éviter que
			// l'ombre soit coupée par un clip. Le Rectangle est responsive en se liant
			// à la taille du root.
			Rectangle card = new Rectangle();
			card.setArcWidth(24);
			card.setArcHeight(24);
			card.setFill(Color.rgb(255,255,255,160)); // 160/255 ~= 0.63 alpha
			card.widthProperty().bind(root.widthProperty().subtract(40));
			card.heightProperty().bind(root.heightProperty().subtract(40));
			
			// ombre + flou combinés : on floute d'abord le contenu interne (blur),
			// puis on applique une ombre qui enveloppe le résultat.
			GaussianBlur blur = new GaussianBlur(8);
			DropShadow shadow = new DropShadow();
			shadow.setRadius(14);
			shadow.setOffsetX(0);
			shadow.setOffsetY(6);
			shadow.setColor(Color.rgb(0,0,0,0.25));
			shadow.setInput(blur);
			card.setEffect(shadow);
			
			// ajouter la card au root
			root.getChildren().add(card);
			
			Scene scene = new Scene(root, 800, 600, Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Club FX Application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}