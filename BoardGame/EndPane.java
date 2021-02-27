import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class EndPane extends TwoPlayers
{
	StackPane pane;
	Text end;
	
	public EndPane()
	{
		end = new Text("");
		
		pane = new StackPane(end);
		pane.setAlignment(Pos.CENTER);
		
		pane.setOnMouseMoved(e -> 
		{
		    if (player1.getHP() <= 0)
			{
				end.setText("KJ Won!!");
				end.setFont(Font.font(30));
			}
			else if (player2.getHP() <= 0)
			{
				end.setText("DT Won!!");
				end.setFont(Font.font(30));
			}
		});
	}
	
	public StackPane getPane()
	{
		return pane;
	}
}
