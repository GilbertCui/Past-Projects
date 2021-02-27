public class GameBoard
{
    private int pitNumber;
    private Pit pit1 = new Pit(4); 
    private Pit pit2 = new Pit(4);
    private Pit pit3 = new Pit(4); 
    private Pit pit4 = new Pit(4); 
    private Pit pit5 = new Pit(4); 
    private Pit pit6 = new Pit(4);
    private Pit store1 = new Pit(0);
    private Pit pit7 = new Pit(4); 
    private Pit pit8 = new Pit(4); 
    private Pit pit9 = new Pit(4);
    private Pit pit10 = new Pit(4); 
    private Pit pit11 = new Pit(4);
    private Pit pit12 = new Pit(4);
    private Pit store2 = new Pit(0);
    
    public GameBoard()
    {
        pitNumber = 14;
        pit1.setNext(pit2);
        pit2.setNext(pit3);
        pit3.setNext(pit4);
        pit4.setNext(pit5);
        pit5.setNext(pit6);
        pit6.setNext(store1);
        store1.setNext(pit7);
        pit7.setNext(pit8);
        pit8.setNext(pit9);
        pit9.setNext(pit10);
        pit10.setNext(pit11);
        pit11.setNext(pit12);
        pit12.setNext(store2);
        store2.setNext(pit1);
    } 
    
    public void resetBoard(int SPP)
    {
        int count = 1;
		pit1.setStone(SPP);
        Pit currentPit = pit1.getNext();
        while (currentPit.getStone() != SPP)
        {
            count++;
			if (count != 7 && count != 14)
				currentPit.setStone(SPP);
			else
				currentPit.setStone(0);
            currentPit = currentPit.getNext();
        }
    }
    
    public void printBoard()
    { 
        Pit currentPit = store2.getNext();
        int count = 0;
		System.out.println(" 1\t 2\t 3\t 4\t 5\t 6");
        while (currentPit != store2)
        {
            count++;
            if (count == 7)
            {
                System.out.print(currentPit.getStone()+"]\n");
            }
            else
            {
                System.out.print("("+currentPit.getStone()+")"+"\t");
                if (count == 6)
                {
                    System.out.print("[");
                }
                if (count == 13)
                {
                    System.out.print("[");
                }
            }
            currentPit = currentPit.getNext();
        }
        System.out.print(store2.getStone()+"]\n");
		System.out.println(" 7\t 8\t 9\t 10\t 11\t 12");
    }

    public boolean play(int location, int player)
	{
		int count = 0;
		int opponentStore;
		Pit targetPit = store2;
		if (player == 1)
			opponentStore = 14;
		else
		{
		    location++;
		    opponentStore = 21;
                }
		for (int search = 0; search < location; search++)
		{
			targetPit = targetPit.getNext();
			count++;
		}
		int stoneInHand = targetPit.getStone();
		targetPit.setStone(0);
		for (int drop = 0; drop < stoneInHand; drop++)
		{
			targetPit = targetPit.getNext();
			count++;
			if (count % opponentStore != 0)
			{
				int stoneInPit = targetPit.getStone();
				targetPit.setStone(stoneInPit+1);
			}
			else
				drop--;
		}
		int fullCycle = 14;
		importantGameRule:
		while (targetPit.getStone() == 1)
		{
			if (count > fullCycle)
				fullCycle = fullCycle*2;
			else
			{
				if (player == 1)
				{
					if (fullCycle-count > 7)
					{
						targetPit.setStone(0);
						for (int get = 0; get < 7; get++)
							targetPit = targetPit.getNext();
						if (targetPit.getStone() != 0)
						{
							store1.setStone(store1.getStone()+targetPit.getStone()+1);
							targetPit.setStone(0);
						}
						else
						{
							for (int get2 = 0; get2 < 7; get2++)
								targetPit = targetPit.getNext();
							targetPit.setStone(1);
							break importantGameRule;
						}
					}
					else
						break importantGameRule;
				}
				else
				{
					if (fullCycle-count < 7 && fullCycle-count != 0)
					{
						targetPit.setStone(0);
						for (int get = 0; get < 7; get++)
							targetPit = targetPit.getNext();
						if (targetPit.getStone() != 0)
						{
							store2.setStone(store2.getStone()+targetPit.getStone()+1);
							targetPit.setStone(0);
						} 
						else
						{
							for (int get2 = 0; get2 < 7; get2++)
								targetPit = targetPit.getNext();
							targetPit.setStone(1);
							break importantGameRule;
						}
					}
					else
						break importantGameRule;
				}
			}
		}
		if (count % 7 == 0)
			return true;
		else
			return false;
	}
	
	public boolean gameEnd()
	{
		int count = 0;
		Pit currentPit = pit1; 
		int player1TotalStone = 0;
		int player2TotalStone = 0;
		while (currentPit != store1)
		{
			player1TotalStone += currentPit.getStone();
			currentPit = currentPit.getNext();
		}
		currentPit = pit7;
		while (currentPit != store2)
		{
			player2TotalStone += currentPit.getStone();
			currentPit = currentPit.getNext();
		}
		if (player1TotalStone == 0 || player2TotalStone == 0)
			return true;
		else
			return false;
	}
	
	public void whoWins()
	{
		if (store1.getStone() > store2.getStone())
			System.out.println("Player1 won the game!");
		else if (store1.getStone() < store2.getStone())
			System.out.println("Player2 won the game!");
		else
			System.out.println("You tied!");
	}
}
