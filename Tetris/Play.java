import java.util.Scanner;
public class Play
{
    public static void main (String[] args)
    {
        Game myGame = new Game();
        ShapeList myList = new ShapeList();
        Scanner scan = new Scanner(System.in);
        Shape tempShape;
        String gameOn;
        
        do
        {
            System.out.println("If you want to rotate your shape, input \"r\"; if not, input \"y\"");
            tempShape = myList.randomShape();
            myList.display(tempShape);
            String input = scan.next();
            while (input.equals("r"))
            {
                tempShape = myList.changeShape(tempShape);
                myList.display(tempShape);
                input = scan.next();
            }
            System.out.println();
            myGame.display();
            System.out.println();
            int insert = scan.nextInt();
            gameOn = myGame.push(tempShape, insert);
            myGame.display();
            System.out.println("\n\nYour score:"+myGame.getScore());
            System.out.println("\n--------------------------------------------------------------------------------------------------\n");
        }
        while (!"Game Over!".equals(gameOn));
        System.out.print(gameOn);
    }
}
