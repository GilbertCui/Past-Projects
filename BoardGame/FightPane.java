import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.scene.text.Font;

public class FightPane extends TwoPlayers
{
	private GridPane pane;
	private Button player1Ability1, player1Ability2, player1Ability3;
	private Rectangle player1Health, player1Magic;
	private Button player2Ability1, player2Ability2, player2Ability3;
	private Rectangle player2Health, player2Magic;
	private Button player1Attack, player2Attack;
	private Label timer;
	private int countDown1 = 10;
	private int countDown2 = 10;
	private int turn = 1;
	private int timePassing = 0;
	private ImageView DT;
	private ImageView KJ;
	private Image DT_Stand1 = new Image("DT_stand1.png");
	private Image DT_Stand2 = new Image("DT_stand2.png");
	private Image KJ_Stand1 = new Image("KJ_stand1.png");
	private Image KJ_Stand2 = new Image("KJ_stand2.png");
	private Timeline countingDown;
	
	public FightPane()
	{
		player1Health = new Rectangle(player1.getHP()*5, 20, null);
		player1Health.setFill(Color.RED);
		Rectangle player1HealthBar = new Rectangle(player1.getHP()*5, 20, null);
		player1HealthBar.setStroke(Color.DARKGREY);
		player1HealthBar.setStrokeWidth(4);
		player1HealthBar.setFill(null);
		
		player2Health = new Rectangle(player2.getHP()*5, 20, null);
		player2Health.setFill(Color.RED);
		Rectangle player2HealthBar = new Rectangle(player2.getHP()*5, 20, null);
		player2HealthBar.setStroke(Color.DARKGREY);
		player2HealthBar.setStrokeWidth(4);
		player2HealthBar.setFill(null);
		
		player1Magic = new Rectangle(player1.getMP()*5, 20, null);
		player1Magic.setFill(Color.BLUE);
		Rectangle player1MagicBar = new Rectangle(player1.getMP()*5, 20, null);
		player1MagicBar.setStroke(Color.DARKGREY);
		player1MagicBar.setStrokeWidth(4);
		player1MagicBar.setFill(null);
		
		player2Magic = new Rectangle(player2.getMP()*5, 20, null);
		player2Magic.setFill(Color.BLUE);
		Rectangle player2MagicBar = new Rectangle(player2.getMP()*5, 20, null);
		player2MagicBar.setStroke(Color.DARKGREY);
		player2MagicBar.setStrokeWidth(4);
		player2MagicBar.setFill(null);
		
		Ellipse timerBox = new Ellipse(120, 30);
		timerBox.setStroke(Color.RED);
		timerBox.setStrokeWidth(2);
		timerBox.setFill(null);
		
		timer = new Label("DT's Round: "+countDown1);
		timer.setFont(Font.font(30));
		timer.setTextFill(Color.RED);
		
		StackPane player1HeathDisplay = new StackPane(player1Health, player1HealthBar);
		player1HeathDisplay.setPrefSize(1000, 20);
		player1HeathDisplay.setAlignment(Pos.CENTER_LEFT);
		StackPane player1MagicDisplay = new StackPane(player1Magic, player1MagicBar);
		player1MagicDisplay.setPrefSize(500, 20);
		player1MagicDisplay.setAlignment(Pos.CENTER_LEFT);
		
		StackPane player2HeathDisplay = new StackPane(player2Health, player2HealthBar);
		player2HeathDisplay.setPrefSize(1000, 20);
		player2HeathDisplay.setAlignment(Pos.CENTER_RIGHT);
		StackPane player2MagicDisplay = new StackPane(player2Magic, player2MagicBar);
		player2MagicDisplay.setPrefSize(500, 20);
		player2MagicDisplay.setAlignment(Pos.CENTER_RIGHT);
		
		StackPane timerDisplay = new StackPane(timer, timerBox);
		timerDisplay.setAlignment(Pos.CENTER);
		
		player1Ability1 = new Button("");
		player1Ability1.setOnAction(this::processButtonPress);
		player1Ability1.setPrefSize(150, 40);
		player1Ability2 = new Button("");
		player1Ability2.setOnAction(this::processButtonPress);
		player1Ability2.setPrefSize(150, 40);
		player1Ability3 = new Button("");
		player1Ability3.setOnAction(this::processButtonPress);
		player1Ability3.setPrefSize(150, 40);
		
		player2Ability1 = new Button("");
		player2Ability1.setOnAction(this::processButtonPress);
		player2Ability1.setPrefSize(150, 40);
		player2Ability2 = new Button("");
		player2Ability2.setOnAction(this::processButtonPress);
		player2Ability2.setPrefSize(150, 40);
		player2Ability3 = new Button("");
		player2Ability3.setOnAction(this::processButtonPress);
		player2Ability3.setPrefSize(150, 40);
		
		Image attack1 = new Image("attack1.png");
		ImageView attack1View = new ImageView(attack1);
		attack1View.setFitWidth(100);
		attack1View.setFitHeight(50);
		player1Attack = new Button(null, attack1View);
		player1Attack.setOnAction(this::processButtonPress);
		
		Image attack2 = new Image("attack2.png");
		ImageView attack2View = new ImageView(attack2);
		attack2View.setFitWidth(100);
		attack2View.setFitHeight(50);
		player2Attack = new Button(null, attack2View);
		player2Attack.setOnAction(this::processButtonPress);
		
		DT = new ImageView(DT_Stand1);
		DT.setFitWidth(140);
		DT.setFitHeight(240);
		
		KJ = new ImageView(KJ_Stand1);
		KJ.setFitWidth(140);
		KJ.setFitHeight(160);
		
		KeyFrame oneSec = new KeyFrame(Duration.seconds(1), this::processTimePass);
		
		countingDown = new Timeline(oneSec);
		countingDown.setCycleCount(Timeline.INDEFINITE);
		
		HBox player1Abilities = new HBox(player1Ability1, player1Ability2, player1Ability3);
		player1Abilities.setAlignment(Pos.CENTER);
		player1Abilities.setSpacing(200);
		
		HBox player2Abilities = new HBox(player2Ability1, player2Ability2, player2Ability3);
		player2Abilities.setAlignment(Pos.CENTER);
		player2Abilities.setSpacing(200);
		
		VBox player1bars = new VBox(player1HeathDisplay, player1MagicDisplay);
		player1bars.setAlignment(Pos.CENTER_LEFT);
		player1bars.setSpacing(5);
		player1bars.setPrefSize(1000, 50);
		
		VBox player2bars = new VBox(player2HeathDisplay, player2MagicDisplay);
		player2bars.setAlignment(Pos.CENTER_RIGHT);
		player2bars.setSpacing(5);
		player2bars.setPrefSize(1000, 50);
		
		pane = new GridPane();
		pane.setHgap(250);
		pane.setVgap(30);
		pane.setAlignment(Pos.CENTER);
		pane.setOnMouseMoved(this::processMouseMove);
		
		pane.add(player1bars, 0, 6, 3, 1);
		pane.add(player1Abilities, 0, 5, 3, 1);
		pane.add(DT, 0, 4, 1, 1);
		pane.add(player1Attack, 2, 4, 1, 1);
		pane.add(timerDisplay, 1, 3, 1, 1);
		pane.add(KJ, 2, 2, 1, 1);
		pane.add(player2Attack, 0, 2, 1, 1);
		pane.add(player2Abilities, 0, 1, 3, 1);
		pane.add(player2bars, 0, 0, 3, 1);
	}
	
	public void processButtonPress(ActionEvent event)
	{
		if (event.getSource() == player1Ability1)
		{
			player1.useAbility(1);
		}
		else if (event.getSource() == player1Ability2)
		{
			player1.useAbility(2);
		}
		else if (event.getSource() == player1Ability3)
		{
			player1.useAbility(3);
		}
		else if (event.getSource() == player2Ability1)
		{
			player2.useAbility(1);
		}
		else if (event.getSource() == player2Ability2)
		{
			player2.useAbility(2);
		}
		else if (event.getSource() == player2Ability3)
		{
			player2.useAbility(3);
		}
		else if (event.getSource() == player1Attack)
		{
			player1.useAbility(0);
		}
		else if (event.getSource() == player2Attack)
		{
			player2.useAbility(0);
		}
		
		if (turn == 1)
			turn = 2;
		else
			turn = 1;
		
		player1Health.setWidth(player1.getHP()*5);
		player1Magic.setWidth(player1.getMP()*5);
		
		player2Health.setWidth(player2.getHP()*5);
		player2Magic.setWidth(player2.getMP()*5);
	}
	
	public void processMouseMove(MouseEvent event)
	{
		countingDown.play();
		
		player1Ability1.setText(""+player1.getAbilityName(1));
		player1Ability2.setText(""+player1.getAbilityName(2));
		player1Ability3.setText(""+player1.getAbilityName(3));
		
		player2Ability1.setText(""+player2.getAbilityName(1));
		player2Ability2.setText(""+player2.getAbilityName(2));
		player2Ability3.setText(""+player2.getAbilityName(3));
	}
	
	public void processTimePass(ActionEvent event)
	{
		if (turn == 1 && countDown1 > 0)
		{
			countDown2 = 11;
			countDown1--;
			timer.setText("DT's Round: "+countDown1);
			player1Ability1.setDisable(false);
			player1Ability2.setDisable(false);
			player1Ability3.setDisable(false);
			player1Attack.setDisable(false);
			
			player2Ability1.setDisable(true);
			player2Ability2.setDisable(true);
			player2Ability3.setDisable(true);
			player2Attack.setDisable(true);
		}
		else
			turn = 2;
		if (turn == 2 && countDown2 > 0)
		{
			countDown1 = 11;
			countDown2--;
			timer.setText("KJ's Round: "+countDown2);
			player1Ability1.setDisable(true);
			player1Ability2.setDisable(true);
			player1Ability3.setDisable(true);
			player1Attack.setDisable(true);
			
			player2Ability1.setDisable(false);
			player2Ability2.setDisable(false);
			player2Ability3.setDisable(false);
			player2Attack.setDisable(false);
		}
		else
			turn = 1;
		timePassing++;
		if (timePassing%2 == 0)
		{
			DT.setImage(DT_Stand2);
			KJ.setImage(KJ_Stand2);
		}
		else
		{
			DT.setImage(DT_Stand1);
			KJ.setImage(KJ_Stand1);
		}
	}
	
	public boolean getStatus()
	{
		if (player1.getHP() <= 0 || player2.getHP() <= 0)
			return true;
		else 
			return false;
	}
	
	public GridPane getPane()
	{
		return pane;
	}
}