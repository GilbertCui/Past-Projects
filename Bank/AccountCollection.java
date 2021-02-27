
import java.text.NumberFormat;
import java.io.*;

public class AccountCollection
{
    private Account[] collection;
    private int count;
    private double totalBalance;
    private double theBalance;
    private String theName;
    private boolean theStatus;
    private boolean theEnoughCaSH;
    private int thePassword;
    final private String adminPassword = "AaAa123321";
	private double interest = 0.05;
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    public AccountCollection()
    {
        collection = new Account[100];
        count = 0;
        totalBalance = 0;
    }

    public void addAccount(String name, int number, double balance, int password, boolean lock)
     {
        if (count == collection.length)
            increaseSize();
        collection[count] = new Account(name, number, balance, password, lock);
        totalBalance += balance;
        count++;
    }
    
	public String getAccount(int userNumber)
	{
		for (int search = 0; search < collection.length; search++)
		{
			if (collection[search].getNumber() == userNumber)
				return ""+collection[search].toString();
		}
		return "Account not found";
	}
	
	public String addInterest()
	{
		interest += 0.03;
		return "The interest for all accounts is now "+interest*100+"%";
	}
	
    public String getAdminPassword()
    {
        return adminPassword;
    }
    
    public int getLength()
    {
        return collection.length;
    }
    
    public boolean checkNumber(int userNumber)
    {
        boolean result = false;
        for (int check = 0; check < collection.length; check++)
        {
            if (collection[check].getNumber() == userNumber)
            {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public int getNumber(int index)
    {
        return collection[index].getNumber();
    }
    
    public void replaceNumber(int userOldNumber, int userNewNumber)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userOldNumber)
            {
                collection[search].replaceNumber(userNewNumber);
                break;
            }
        }
    }
    
    public boolean checkPassword(int userPassword)
    {
        boolean result = false;
        for (int check = 0; check < collection.length; check++)
        {
            if (collection[check].getPassword() == userPassword)
            {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public void setPassword(int userNumber, int userPassword)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                collection[search].setPassword(userPassword);
                break;
            }
        }
    }
    
    public double getBalance(int userNumber)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                theBalance = collection[search].getBalance();
                break;
            }
        }
        return theBalance;
    }
    
    public String getName(int userNumber)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {    
                theName = collection[search].getName();
                break;
            }
        }
        return theName;
    }
    
    public boolean getStatus(int userNumber)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                theStatus = collection[search].getStatus();
                break;
            }
        }
        return theStatus;
    }
    
    public void setStatus(int userNumber, boolean userLock)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                collection[search].setStatus(userLock);
                break;
            }
        }
    }
    
    public void deposit(int userNumber, double userDeposit)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                collection[search].deposit(userDeposit);
                break;
            }
        }
    }
    
    public boolean withdraw(int userNumber, double userWithdraw)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                theEnoughCaSH = collection[search].withdraw(userWithdraw);
                break;
            }
        }
        return theEnoughCaSH;
    }
    
    public void deleteAccount(int userNumber)
    {
        for (int search = 0; search < collection.length; search++)
        {
            if (collection[search].getNumber() == userNumber)
            {
                while (search != collection.length-1)
                {
                    Account temp = new Account(null, 0, 0, 0, true);
                    temp = collection[search];
                    collection[search] = collection[search+1];
                    collection[search+1] = temp;
                    search++;
                }
                Account[] temp = new Account[collection.length-1];
                for (int index = 0; index < collection.length-1; index++)
                    temp[index] = collection[index];
                collection = temp;
                count--;
                break;
            }
        }
    }
    
    public String reportStats()
    {
        String stats = "Account Statistics:\n\n";
        stats += "Number of Accounts: " + count + "\n";
        stats += "Total balance: " + fmt.format(totalBalance) + "\n";
        stats += "Average balance: " + fmt.format(totalBalance/count) +"\n";
		stats += "Interest: " + interest*100 + "%";
        return stats;
    }
    
    public void numberSort()
    {
        int min = collection[0].getNumber();
        int max = collection[0].getNumber();
        for (int searchExtreme = 1; searchExtreme < collection.length; searchExtreme++)
        {
            int next = collection[searchExtreme].getNumber();
            if (next < min)
                min = next;
            if (next > max)
                max = next;
        }
       
	    int[] sortList = new int [collection.length];
        for (int index = 0; index < collection.length; index++)
            sortList[index] = collection[index].getNumber();
        int[] subListLength = new int [40*sortList.length];
        subListLength[0] = 0;
        subListLength[1] = sortList.length;
        int subListIndex = 1;
        int subListEnd = 0;
		int subListStart = 0;
		int preMid = 0;
		double subListNum = 0.5;
		int[] subListSorted = new int [sortList.length];
		int numOfSorted = 0;
		boolean listSorted = false;
		int[] midJump = new int[4*sortList.length];
		int midJumpIndex = 0;
		
		do
        {
			int noListCount = 1;
            int inputIndex = 0;
			int mid = ((max-min)/2)+min;
			int sortedIndex = 0;
			int[] preSubListSorted = new int [numOfSorted+1];
			for (int index = 0; index < numOfSorted; index++)
            		preSubListSorted[index] = subListSorted[index];
			int preSortedIndex = 0;
			subListIndex++;
            subListLength[subListIndex] = 0;
			double numOfSubList = (subListNum)*2-numOfSorted;
			subListNum = numOfSubList;
			int indexOfSubList = 1;
			
			for (int subList = 1; subList < subListNum+1; subList++)
            {
                int[] FHList = new int[sortList.length];
                int[] SHList = new int[sortList.length];
                int FHCount = 0;
                int SHCount = 0;
				int FHSorted = 2;
				int SHSorted = 3;
				int sortedCount = 0;
				
				do
				{
					if (subListLength[subListStart+1] == -1)
					{
						do
						{
							int gap2 = subListLength[subListStart+2] - subListLength[subListStart];
							subListIndex++;
		        				subListLength[subListIndex] = -1;
							subListIndex++;
							subListLength[subListIndex] = subListLength[subListIndex-2] + gap2;
							
							for (int midJumpSearch = 0; midJumpSearch < midJump.length; midJumpSearch += 3)
							{
								if (midJump[midJumpSearch] == subListLength[subListStart] && midJump[midJumpSearch+2] == 0)
								{
									midJump[midJumpSearch+1] *= 2;
									sortedCount += midJump[midJumpSearch+1];
									midJump[midJumpSearch+2] = -1;
									break;
								}
							}
							
							subListStart += 2;
						}
						while (subListLength[subListStart+1] == -1);
					}
					if (indexOfSubList == preSubListSorted[preSortedIndex])
					{
						int gap = subListLength[subListStart+1] - subListLength[subListStart];
						subListIndex++;
            				subListLength[subListIndex] = -1;
						subListIndex++;
						subListLength[subListIndex] = subListLength[subListIndex-2] + gap;
						
						midJump[midJumpIndex] = subListLength[subListStart];
						midJumpIndex++;
						midJump[midJumpIndex] = 1;
						midJumpIndex++;
						midJump[midJumpIndex] = 0;
						midJumpIndex++;
						
						sortedCount++;
						subListStart++;
						preSortedIndex++;
						indexOfSubList++;
					}
				}
				while (subListLength[subListStart+1] == -1 || indexOfSubList == preSubListSorted[preSortedIndex]);
				
				subListEnd = subListStart + 1;
				mid += sortedCount*preMid;
				
                for (int search = subListLength[subListStart]; search < subListLength[subListEnd]; search++)
                {
                    if (subListLength[subListStart] < 0)
						break;
					if (sortList[search] <= mid)
                    {    
                        FHList[FHCount] = sortList[search];
                        FHCount++;
                    }
                    else  
                    {
                        SHList[SHCount] = sortList[search];
                        SHCount++;
                    }
                }
                
				int FHsortListIndex = subListLength[subListStart];
                for (int FHIndex = 0; FHIndex < FHCount; FHIndex++ )
				{
					if (FHIndex < FHCount-1)
						if (FHList[FHIndex] > FHList[FHIndex+1])
							FHSorted = 0;
					sortList[FHsortListIndex] = FHList[FHIndex];
					FHsortListIndex++;
				}
                int SHsortListIndex = FHCount + subListLength[subListStart];
				for (int SHIndex = 0; SHIndex < SHCount; SHIndex++ )
                {
					if (SHIndex < SHCount-1)
						if (SHList[SHIndex] > SHList[SHIndex+1])
							SHSorted = 0;
					sortList[SHsortListIndex] = SHList[SHIndex];
					SHsortListIndex++;
				}
				
				if (FHSorted != 0)
				{
					subListSorted[sortedIndex] = subList*FHSorted-1;
					sortedIndex++;
				}
				if (SHSorted != 0)
				{
					subListSorted[sortedIndex] = subList*SHSorted-subList;
					sortedIndex++;
				}
				
				subListIndex++;
                subListLength[subListIndex] = subListLength[subListIndex-1] + FHCount;
                subListIndex++;
                subListLength[subListIndex] = subListLength[subListIndex-1] + SHCount;
				mid += preMid;
				subListStart++;
				indexOfSubList++;
			}
			
			for (int midJumpZero = 2; midJumpZero < midJump.length; midJumpZero += 3)
				midJump[midJumpZero] = 0;
			
			while (subListLength[subListStart] != 0)
				subListStart++;
			
			numOfSorted = sortedIndex;
			preMid = (max-min)/2;
			max = ((max-min)/2)+min;
			
			listSorted = true;
			for (int listIndex = 0; listIndex < sortList.length; listIndex++)
			{
				if (listIndex < sortList.length-1)
					if (sortList[listIndex] > sortList[listIndex+1])
							listSorted = false;
			}
        }
		while (listSorted == false);
		
		for (int search = 0; search < sortList.length; search++)
        {
	        for (int search2 = 0; search2 < collection.length; search2++)    
			{	
				if (sortList[search] == collection[search2].getNumber())
	            {
	                Account[] temp = new Account[1];
					temp[0] = collection[search];
					collection[search] = collection[search2];
					collection[search2] = temp[0];
	                break;
	            }
			}
        }
    }
	
	public String richPeopleFilter()
	{
		String outPut = "";
		for (int search = 0; search < collection.length; search++)
		{
			if (collection[search].getBalance() > 50000.0)
				outPut += ""+collection[search].toString()+"\n";
		}
		if (outPut.equals(""))
			return "None";
		else
			return outPut;
	}
        
    public String toString()
    {
        String report = "Account List:\n\n";
        for (int theAccount = 0; theAccount < collection.length; theAccount++)
            report += collection[theAccount].toString() + "\n";
        return report;
    }

    private void increaseSize()
    {
        Account[] temp = new Account[collection.length + 1];

        for (int index = 0; index < collection.length; index++)
            temp[index] = collection[index];

        collection = temp;
    }
}