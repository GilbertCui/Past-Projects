import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;

public class AttributePane2 extends TwoPlayers
{
	private int playerPoints = 5;
    private Text points;
	private Label showMessage;
    private Button attribute1, attribute2, attribute3, attribute4;
    private BorderPane pane;
	private String[] message = new String[4];
    
    public AttributePane2()
    {
        Text hello = new Text("Hi, KJ!");
        Text command = new Text("Attributes Management");
        points = new Text("Points Available: "+playerPoints);
		
		message[0] = "Higher points gives you more damage.";
		message[1] = "Higher ponits makes you less vulnerable to damage.";
		message[2] = "Higher points causes your buff and debuff abilities (if you choose them) more effective.";
		message[3] = "Higher points allows you to move first and to have higher chance eluding damage.";
        
		showMessage = new Label();
		showMessage.setPrefWidth(200);
		showMessage.setWrapText(true);
		
        attribute1 = new Button("Damage: "+player2.getDamagePoints());
		attribute1.setOnAction(this::processButtonPress);
		attribute1.setOnMouseEntered(this::processMouseEnter);
		attribute1.setOnMouseExited(this::processMouseExit);
		
        attribute2 = new Button("Defence: "+player2.getDefencePoints());
        attribute2.setOnAction(this::processButtonPress);
		attribute2.setOnMouseEntered(this::processMouseEnter);
		attribute2.setOnMouseExited(this::processMouseExit);
		
        attribute3 = new Button("Technique: "+player2.getTechniquePoints());
        attribute3.setOnAction(this::processButtonPress);
		attribute3.setOnMouseEntered(this::processMouseEnter);
		attribute3.setOnMouseExited(this::processMouseExit);
		
        attribute4 = new Button("Speed: "+player2.getSpeedPoints());
        attribute4.setOnAction(this::processButtonPress);
		attribute4.setOnMouseEntered(this::processMouseEnter);
		attribute4.setOnMouseExited(this::processMouseExit);
		
		StackPane messagePane = new StackPane(showMessage);
		messagePane.setPrefSize(200, 100);
		
		VBox textPane = new VBox(hello, command);
		textPane.setAlignment(Pos.CENTER);
		textPane.setSpacing(20);
		
		HBox attributeLayout = new HBox(attribute1, attribute2, attribute3, attribute4);
		attributeLayout.setAlignment(Pos.CENTER);
		attributeLayout.setSpacing(30);
		
		VBox bottomPane = new VBox(points, attributeLayout);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setSpacing(20);
		
		pane = new BorderPane(messagePane, textPane, null, bottomPane, null);
		pane.setPadding(new Insets(20,20, 0,20));
		pane.setMargin(messagePane, new Insets(15, 0, 15, 40));
    }
    
    public void processButtonPress(ActionEvent event)
    {
        playerPoints += -1;
        points.setText("Points Available: "+playerPoints);
        if (event.getSource() == attribute1)
        {
            player2.setDamage(1);
            attribute1.setText("Damage: "+player2.getDamagePoints());
            if (player2.getDamagePoints() == 4)
                attribute1.setDisable(true);
        }
        else if (event.getSource() == attribute2)
        {
            player2.setDefence(1);
            attribute2.setText("Defence: "+player2.getDefencePoints());
            if (player2.getDefencePoints() == 4)
                attribute2.setDisable(true);
        }
        else if (event.getSource() == attribute3)
        {
            player2.setTechnique(1);
            attribute3.setText("Technique: "+player2.getTechniquePoints());
            if (player2.getTechniquePoints() == 4)
                attribute3.setDisable(true);
        }
        else
        {
            player2.setSpeed(1);
            attribute4.setText("Speed: "+player2.getSpeedPoints());
            if (player2.getSpeedPoints() == 4)
                attribute4.setDisable(true);
        }
        if (playerPoints == 0)
        {
            attribute1.setDisable(true);
            attribute2.setDisable(true);
            attribute3.setDisable(true);
            attribute4.setDisable(true);
        }   
    }
	
	public void processMouseEnter(MouseEvent event)
	{
		if (event.getSource() == attribute1)
			showMessage.setText(message[0]);
		else if (event.getSource() == attribute2)
			showMessage.setText(message[1]);
		else if (event.getSource() == attribute3)
			showMessage.setText(message[2]);
		else 
			showMessage.setText(message[3]);
	}
	
	public void processMouseExit(MouseEvent event)
	{
		showMessage.setText("");
	}
	
    public BorderPane getPane()
    {
        return pane;
    }
    
    public boolean getStatus()
    {
        if (playerPoints == 0)
            return true;
        else
            return false;
    }
}
