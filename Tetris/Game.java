public class Game
{
    private Block[][] gameBoard = new Block[10][10];
    private int[] top = new int[10];
    private int score = 0;
    
    public Game()
    {
        for (int row = 0; row < 10; row++)
            for (int column = 0; column < 10; column++)
                gameBoard[row][column] = new Block(false);
    
        for (int index = 0; index < 10; index++)
            top[index] = 10;
    }
    
    public String push(Shape myShape, int column)
    {
        for (int index = 0; index < 10; index++)
        {
            if (top[index] == 1)
            {
                if (column == index)
                {
                    return "Game Over!";
                }
            }
            else if (top[index] == 2)
            {
                if (myShape.getBlock(1,0).getValue() == true || myShape.getBlock(1,1).getValue() == true)
                {    
                    if (column == index)
                    {
                        return "Game Over!";
                    }
                }
            }
        }
        for (int shapeRow = 1; shapeRow > -1; shapeRow--)
        {
            if (myShape.getFfloat() == true && shapeRow == 1 || myShape.getBlock(shapeRow, 0).getValue() == true && myShape.getBlock(shapeRow, 1).getValue() == true)
            {
                if (top[column+1] < top[column])
                {
                    if (myShape.getBlock(shapeRow, 0).getValue() == true && myShape.getBlock(shapeRow, 1).getValue() == false)
                    {
                        top[column] = top[column+1]+1;
                        gameBoard[--top[column]][column].setValue(true);
                    }
                    else
                    {
                        top[column] = top[column+1];
                        for (int shapeColumn = 0; shapeColumn < 2; shapeColumn++)    
                            gameBoard[--top[column+shapeColumn]][column+shapeColumn].setValue(myShape.getBlock(shapeRow, shapeColumn).getValue());
                    }
                }
                else if (top[column+1] > top[column])
                {
                    if (myShape.getBlock(shapeRow, 1).getValue() == true && myShape.getBlock(shapeRow, 0).getValue() == false)
                    {
                        top[column+1] = top[column]+1;
                        gameBoard[--top[column+1]][column+1].setValue(true);
                    }
                    else
                    {
                        top[column+1] = top[column];
                        for (int shapeColumn = 0; shapeColumn < 2; shapeColumn++)    
                            gameBoard[--top[column+shapeColumn]][column+shapeColumn].setValue(myShape.getBlock(shapeRow, shapeColumn).getValue());
                    }
                }
                else
                    for (int shapeColumn = 0; shapeColumn < 2; shapeColumn++)    
                        gameBoard[--top[column+shapeColumn]][column+shapeColumn].setValue(myShape.getBlock(shapeRow, shapeColumn).getValue());
            }
            else
            {
                int columnInserted = 0;
                for (int shapeColumn = 0; shapeColumn < 2; shapeColumn++)
                {
                    if (myShape.getBlock(shapeRow, shapeColumn).getValue() == true)
                    {
                        gameBoard[--top[column+columnInserted]][column+columnInserted].setValue(true);
                        columnInserted++;
                    }
                    else
                        columnInserted++;
                }
            }
        }
        boolean clear = true;
        boolean doubleClear = false;
        if (myShape.getBlock(0,0).getValue() == true && myShape.getBlock(1,0).getValue() == true || myShape.getBlock(0,0).getValue() == true && myShape.getBlock(1,1).getValue())
        {
            for (int index = 0; index < 10; index++)
                if (gameBoard[top[column]+1][index].getValue() == false)
                    clear = false;
            if (clear == true)
            {
                score += 10;
                doubleClear = true;
                for (int checkColumn = 0; checkColumn < 10; checkColumn++)
                {
                    if (top[column]+1+1 < 10)
                    {
                        if (gameBoard[top[column]+1+1][checkColumn].getValue() == false && top[checkColumn] == top[column]+1)
                        {
                            int nextRow = top[column]+1+1;
                            do
                            {
                                top[checkColumn]++;
                                if (nextRow < 9)
                                    nextRow++;
                                else
                                    break;
                            }
                            while (gameBoard[nextRow][checkColumn].getValue() == false);
                        }
                    }
                }
                for (int clearRow = top[column]+1; clearRow > 0; clearRow--)
                    for (int clearColumn = 0; clearColumn < 10; clearColumn++)
                        gameBoard[clearRow][clearColumn].setValue(gameBoard[clearRow-1][clearColumn].getValue());
                for (int index = 0; index < 10; index++)
                    top[index]++;
            }
        }
        clear = true;
        for (int index = 0; index < 10; index++)
            if (gameBoard[top[column]][index].getValue() == false)
                clear = false;
        if (clear == true)
        {
            score += 10;
            if (doubleClear == true)
                score += 30;
            for (int checkColumn = 0; checkColumn < 10; checkColumn++)
            {
                if (top[column]+1 < 10)
                { 
                    if (gameBoard[top[column]+1][checkColumn].getValue() == false && top[checkColumn] == top[column])
                    {
                        int nextRow = top[column]+1;
                        do
                        {
                            top[checkColumn]++;
                            if (nextRow < 9)
                                nextRow++;
                            else
                                break;
                        }
                        while (gameBoard[nextRow][checkColumn].getValue() == false);
                    }
                }
            }
            for (int clearRow = top[column]; clearRow > 0; clearRow--)
                for (int clearColumn = 0; clearColumn < 10; clearColumn++)
                    gameBoard[clearRow][clearColumn].setValue(gameBoard[clearRow-1][clearColumn].getValue());
            for (int index = 0; index < 10; index++)
                top[index]++;
        }
        return "";
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void display()
    {
        for (int columnIndex = 0; columnIndex < 10; columnIndex++)
            System.out.print(columnIndex+" ");
        System.out.println();
        for (int row = 0; row < 10; row++)
        {
            for (int column = 0; column < 10; column++)
            {
                if (gameBoard[row][column].getValue() == false)
                    System.out.print("□ ");
                else
                    System.out.print("■ ");
            }
            System.out.println();
        }
        for (int columnIndex = 0; columnIndex < 10; columnIndex++)
            System.out.print(columnIndex+" ");
    }
}
