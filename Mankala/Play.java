import java.util.Scanner;
public class Play
{
    public static void main (String[] args)
    {
       GameBoard myGame = new GameBoard();
       Scanner scan = new Scanner(System.in);
       System.out.println("Hi, my friend, let's play MANKALA!!\n");
       System.out.println("How many stones do you want to have in each pit?");
       int answer = scan.nextInt();
       myGame.resetBoard(answer);
       boolean runForever = true;
       outerloop:
       while (runForever == true)
       {
           boolean result;
           do
           {
               myGame.printBoard();
               System.out.println("-----------------------------------------------------------");
               System.out.println("Now it is player1's turn, choose the pit you want to play:");
               int choice = scan.nextInt();
               while (choice > 6)
               {
                  System.out.println("You can only choose your pits, please choose again:");
                  choice = scan.nextInt(); 
               }
               result = myGame.play(choice,1);
               if (myGame.gameEnd() == true)
                    break outerloop;
           }
           while(result == true);
           do
           {
               myGame.printBoard();
               System.out.println("-----------------------------------------------------------");
               System.out.println("Now it is player2's turn, choose the pit you want to play:");
               int choice = scan.nextInt();
               while (choice < 7)
               {
                  System.out.println("You can only choose your pits, please choose again:");
                  choice = scan.nextInt(); 
               }
               result = myGame.play(choice,2);
               if (myGame.gameEnd() == true)
                    break outerloop;
           }
           while(result == true);
       }
       myGame.printBoard();
       System.out.println("\nThe game has ended.");
       myGame.whoWins();
    }
}
