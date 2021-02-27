import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class AbilityPane extends TwoPlayers
{
    private ChoiceBox<String> ability1, ability2, ability3;
    private Label cost, describing;
    private String[] abilities = {"Choose ability...", "Heal", "Poison", "Eat A Burger", "Strength Buff", "Strength Debuff", "Shield", "Purify", "Snare", "Instant Kill", "Magic Potion"};
    private String[] description = new String[11];
    private Button set;
    private int finalDec1 = 0;
    private int finalDec2 = 0;
    private int finalDec3 = 0;
	private BorderPane pane;
    private VBox descriptionLayout;
	private boolean setPressed = false;
	
    public AbilityPane()
    {
        Label command = new Label("Ability Bank");
        cost = new Label();
        
        description[0] = "";
        description[1] = "Recover yourself 60 health as you use the ability in your round; no aftermath effect";
        description[2] = "Cause a relative small amount of damage(depends on your attribute) to your opponent as you use the ability in your round; continue to cause the same amount of damage for next 3 rounds";
        description[3] = "Recover yourself 10 health as you use the ability in your round; continue to recover 10 health for next 3 rounds";
        description[4] = "Increase your damage by certain amount(depends on your attribute) as you use the ability in your round; continue to have the same effect for your next 4 rounds";
        description[5] = "Decrease your opponent's damage by 50% as you use the ability in your round; continue to have the same effect for your opponent's next 4 rounds";
        description[6] = "Obtain a shield which has the equivalent of 100 health as you use the ability in your round; no aftermath effect";
        description[7] = "Erase all of your negative states and all of your opponent's positive states as you use the ability in your round; no aftermath effect";
        description[8] = "Jump your opponent's next two rounds";
        description[9] = "Ability activates as your opponent's health drops below 66; instantly kill your opponent by an odds of 70% as you use the ability in your round; no aftermath effect";
        description[10] = "Recover yourself 20 magic as you use the ability in your round; no aftermath effect";
    	
		describing = new Label(description[0]);
		describing.setPrefWidth(200);
   	 	describing.setWrapText(true);
		
        ability1 = new ChoiceBox<String>();
        ability1.getItems().addAll(abilities);
        ability1.getSelectionModel().selectFirst();
        ability1.setOnAction(this::processChoice);
        
        ability2 = new ChoiceBox<String>();
        ability2.getItems().addAll(abilities);
        ability2.getSelectionModel().selectFirst();
        ability2.setOnAction(this::processChoice);
        
        ability3 = new ChoiceBox<String>();
        ability3.getItems().addAll(abilities);
        ability3.getSelectionModel().selectFirst();
        ability3.setOnAction(this::processChoice);
        
        set = new Button("All Set");
        set.setOnAction(this::processButtonPress);
		set.setDisable(true);
        
        VBox abilityLayout = new VBox(ability1, ability2, ability3);
        abilityLayout.setSpacing(20);
		abilityLayout.setAlignment(Pos.CENTER);
        
        descriptionLayout = new VBox(describing, cost);
        descriptionLayout.setSpacing(20);
		descriptionLayout.setAlignment(Pos.CENTER);
		
		StackPane descriptionPane = new StackPane(descriptionLayout);
		descriptionPane.setPrefSize(200, 200);
		
		pane = new BorderPane(descriptionPane, command, null, set, abilityLayout);
		pane.setPadding(new Insets(20, 20, 0, 20));
		pane.setAlignment(command, Pos.CENTER); 
        pane.setAlignment(set, Pos.CENTER); 
        pane.setAlignment(descriptionPane, Pos.CENTER); 
		pane.setMargin(descriptionPane, new Insets(25, 0, 10, 50));
    }
    
    public void processChoice(ActionEvent event)
    {
		if (event.getSource() == ability1)
        {
            finalDec1 = ability1.getSelectionModel().getSelectedIndex();
            describing.setText(description[finalDec1]);
			if (ability1.getSelectionModel().getSelectedIndex() == 0)
				cost.setText("");
			else
				cost.setText("Magic Cost: "+Math.abs(player1.getAllAbilityCost(ability1.getSelectionModel().getSelectedIndex())));
		}
        else if (event.getSource() == ability2)
        {
            finalDec2 = ability2.getSelectionModel().getSelectedIndex();
            describing.setText(description[finalDec2]);
			if (ability2.getSelectionModel().getSelectedIndex() == 0)
				cost.setText("");
			else
				cost.setText("Magic Cost: "+Math.abs(player1.getAllAbilityCost(ability2.getSelectionModel().getSelectedIndex())));
        }
        else
        {
            finalDec3 = ability3.getSelectionModel().getSelectedIndex();
            describing.setText(description[finalDec3]);
			if (ability3.getSelectionModel().getSelectedIndex() == 0)
				cost.setText("");
			else
				cost.setText("Magic Cost: "+Math.abs(player1.getAllAbilityCost(ability3.getSelectionModel().getSelectedIndex())));
        }
		if (ability1.getSelectionModel().getSelectedIndex() != 0 && ability2.getSelectionModel().getSelectedIndex() != 0 && ability3.getSelectionModel().getSelectedIndex() != 0)
			set.setDisable(false);
		if (ability1.getSelectionModel().getSelectedIndex() == 0 || ability2.getSelectionModel().getSelectedIndex() == 0 || ability3.getSelectionModel().getSelectedIndex() == 0)
			set.setDisable(true);
    }
    
    public void processButtonPress(ActionEvent event)
    {
        player1.setPlayerAbility(finalDec1);
        player1.setPlayerAbility(finalDec2);
        player1.setPlayerAbility(finalDec3);
		ability1.setDisable(true);
		ability2.setDisable(true);
		ability3.setDisable(true);
		descriptionLayout.getChildren().clear();
		Text endLine = new Text("You are good to go!");
		descriptionLayout.getChildren().addAll(endLine);
		setPressed = true;
    }
    
	public boolean getStatus()
	{
		if (setPressed == true)
			return true;
		else 
			return false;
	}
	
    public BorderPane getPane()
    {
        return pane;
    }
}