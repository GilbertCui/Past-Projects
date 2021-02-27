import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BoardGameProjectGUI extends Application
{
	Text test = new Text("");
	public void start(Stage primaryStage)
    {
		AttributePane attributePane = new AttributePane();
		AbilityPane abilityPane = new AbilityPane();
		AttributePane2 attributePane2 = new AttributePane2();
		AbilityPane2 abilityPane2 = new AbilityPane2();
		FightPane fightPane = new FightPane();
		EndPane endPane = new EndPane();
		
		Button button1 = new Button("Next");
		button1.setDisable(true);
		Button button2 = new Button("Next");
		button2.setDisable(true);
		Button button3 = new Button("Next");
		button3.setDisable(true);
		Button button4 = new Button("Next");
		button4.setDisable(true);
		
		AnchorPane navPane1 = new AnchorPane();
		navPane1.setPrefHeight(50);
		navPane1.setStyle("-fx-background-color: grey");
		AnchorPane.setRightAnchor(button1, 20.0);
		AnchorPane.setBottomAnchor(button1, 10.0);
		navPane1.getChildren().add(button1);
		
		AnchorPane navPane3 = new AnchorPane();
		navPane3.setPrefHeight(50);
		navPane3.setStyle("-fx-background-color: grey");
		AnchorPane.setRightAnchor(button3, 20.0);
		AnchorPane.setBottomAnchor(button3, 10.0);
		navPane3.getChildren().add(button3);
		
		AnchorPane navPane2 = new AnchorPane();
		navPane2.setPrefHeight(83);
		navPane2.setStyle("-fx-background-color: grey");
		AnchorPane.setRightAnchor(button2, 20.0);
		AnchorPane.setBottomAnchor(button2, 9.0);
		navPane2.getChildren().add(button2);
		
		AnchorPane navPane4 = new AnchorPane();
		navPane4.setPrefHeight(83);
		navPane4.setStyle("-fx-background-color: grey");
		AnchorPane.setRightAnchor(button4, 20.0);
		AnchorPane.setBottomAnchor(button4, 9.0);
		navPane4.getChildren().add(button4);
		
		VBox fullPane1 = new VBox();
		fullPane1.getChildren().addAll(attributePane.getPane(), navPane1);
		fullPane1.setAlignment(Pos.CENTER);
		fullPane1.setSpacing(50);
		
		VBox fullPane3 = new VBox();
		fullPane3.getChildren().addAll(attributePane2.getPane(), navPane3);
		fullPane3.setAlignment(Pos.CENTER);
		fullPane3.setSpacing(50);
		
		VBox fullPane2 = new VBox();
		fullPane2.getChildren().addAll(abilityPane.getPane(), navPane2);
		fullPane2.setAlignment(Pos.CENTER);
		fullPane2.setSpacing(50);
		
		VBox fullPane4 = new VBox();
		fullPane4.getChildren().addAll(abilityPane2.getPane(), navPane4);
		fullPane4.setAlignment(Pos.CENTER);
		fullPane4.setSpacing(50);
		
		Scene attributeScene = new Scene(fullPane1, 500, 350);
		Scene abilityScene = new Scene(fullPane2, 500, 350);
		Scene attributeScene2 = new Scene(fullPane3, 500, 350);
		Scene abilityScene2 = new Scene(fullPane4, 500, 350);
		Scene fightScene = new Scene(fightPane.getPane(), 1100, 800);
		Scene endScene = new Scene(endPane.getPane(), 500, 350);
		
		attributeScene.setOnMouseMoved(e -> 
		{
		    if (attributePane.getStatus() == true)
				button1.setDisable(false);
		});
		button1.setOnAction(e -> primaryStage.setScene(abilityScene));
		
		attributeScene2.setOnMouseMoved(e -> 
		{
		    if (attributePane2.getStatus() == true)
				button3.setDisable(false);
		});
		button3.setOnAction(e -> primaryStage.setScene(abilityScene2));
		
		abilityScene.setOnMouseMoved(e -> 
		{
		    if (abilityPane.getStatus() == true)
				button2.setDisable(false);
		});
		button2.setOnAction(e -> primaryStage.setScene(attributeScene2));
		
		abilityScene2.setOnMouseMoved(e -> 
		{
		    if (abilityPane2.getStatus() == true)
				button4.setDisable(false);
		});
		button4.setOnAction(e -> primaryStage.setScene(fightScene));
		
		fightScene.setOnMouseMoved(e -> 
		{
		    if (fightPane.getStatus() == true)
				primaryStage.setScene(endScene);
		});
		
		primaryStage.setScene(attributeScene);
		primaryStage.show();
    }
	
    public static void main(String[] args)
    {
        launch(args);
    }
}
