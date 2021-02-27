import java.util.Scanner;

public class GameLaunchText
{
	public static void main (String[] args)
	{
		Player1 player1 = new Player1();
		Player2 player2 = new Player2();
		Scanner scan = new Scanner(System.in);
		int playerPoints = 5;
		int damageChoice = 0;
		int defenceChoice = 0;
		int techniqueChoice = 0;
		int speedChoice = 0;
		int round = 1;
		
		player2.setDamage(1);
		player2.setDefence(2);
		player2.setTechnique(2);
		System.out.println("Welcome! In this game, you will have four different attributes which you need to manage.");
		System.out.println("You have 5 points in total that you can distribute to whatever attribute you want, \nbut you can only distribute maximum 4 points to each attribute.\n");

		while (playerPoints > 0)
		{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("You still have "+playerPoints+" points left.");
		System.out.println(player1.playerAttributes());
		System.out.println("Now, input the number in front of the attribute that you want to distribute points to");
		int choice = scan.nextInt();
			switch (choice)
			{
				case 1:
					System.out.println("Okay, how many points you want to distribute to \"Damage\"?");
					damageChoice = scan.nextInt();
					while (damageChoice > playerPoints)
					{
						System.out.println("You only have "+playerPoints+" points left to attribute, please try again");
						damageChoice = scan.nextInt();
					}
					while (damageChoice > 4)
					{
						System.out.println("Over the maximum of one attribute, please try again");
						damageChoice = scan.nextInt();
					}
					player1.setDamage(damageChoice);
					playerPoints = playerPoints - damageChoice;
					break;
				case 2:
					System.out.println("Okay, how many points you want to distribute to \"Defence\"?");
					defenceChoice = scan.nextInt();
					while (defenceChoice > playerPoints)
					{
						System.out.println("You only have "+playerPoints+" points left to attribute, please try again");
						defenceChoice = scan.nextInt();
					}
					while (defenceChoice > 4)
					{
						System.out.println("Over the maximum of one attribute, please try again");
						defenceChoice = scan.nextInt();
					}
					player1.setDefence(defenceChoice);
					playerPoints = playerPoints - defenceChoice;
					break;
				case 3:
					System.out.println("Okay, how many points you want to distribute to \"Technique\"?");
					techniqueChoice = scan.nextInt();
					while (techniqueChoice > playerPoints)
					{
						System.out.println("You only have "+playerPoints+" points left to attribute, please try again");
						techniqueChoice = scan.nextInt();
					}
					while (techniqueChoice > 4)
					{
						System.out.println("Over the maximum of one attribute, please try again");
						techniqueChoice = scan.nextInt();
					}
					player1.setTechnique(techniqueChoice);
					playerPoints = playerPoints - techniqueChoice;
					break;
				case 4:
					System.out.println("Okay, how many points you want to distribute to \"Speed\"?");
					speedChoice = scan.nextInt();
					while (speedChoice > playerPoints)
					{
						System.out.println("You only have "+playerPoints+" points left to attribute, please try again");
						speedChoice = scan.nextInt();
					}
					while (speedChoice > 4)
					{
						System.out.println("Over the maximum of one attribute, please try again");
						speedChoice = scan.nextInt();
					}
					player1.setSpeed(speedChoice);
					playerPoints = playerPoints - speedChoice;
					break;
			}
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println(player1.playerAttributes());
		System.out.println("\nOkay, finishing distribute points to your attributes, you will now choose all your 3 abilities.");
		System.out.println("Here are 10 abilities you can choose from:\n");
		System.out.println("1-Heal, 2-Poison, 3-Eat A Burger, 4-Strength Buff, 5-Strength Debuff,");
		System.out.println("6-Shield, 7-Purify, 8-Snare, 9-Instant Kill, 10-Magic Potion");
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Input the number in front of your wanted first ability");
		int abilityChoice = scan.nextInt();
		player1.setPlayerAbility(abilityChoice);
		System.out.println("You chose \""+player1.getAbilityName(1)+"\" to be your first ability.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Input the number in front of your wanted second ability");
		abilityChoice = scan.nextInt();
		player1.setPlayerAbility(abilityChoice);
		System.out.println("You chose \""+player1.getAbilityName(2)+"\" to be your second ability.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Input the number in front of your wanted third ability");
		abilityChoice = scan.nextInt();
		player1.setPlayerAbility(abilityChoice);
		System.out.println("You chose \""+player1.getAbilityName(3)+"\" to be your third ability.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		System.out.println("Now, your fight starts.\n");
		while (player1.getHP() > 0 && player2.getHP() >0)
		{
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Round: "+round+"\n");
			round++;
			if (player1.getSpeed() >= player2.getSpeed())
			{
				System.out.println("Your round:");
				for (int conIndex = 0; conIndex < 10; conIndex++)
				{	
					if (player1.getPlayer1PoisonCon(conIndex) > 0)
					{
						player1.passiveAbility(2);
						player1.setPlayer1PoisonCon(conIndex, -1);
					}
					if (player1.getPlayer1BurgerCon(conIndex) > 0)
					{
						player1.passiveAbility(3);
						player1.setPlayer1BurgerCon(conIndex, -1);
					}
					if (player1.getPlayer1BuffCon(conIndex) > 0)
					{
						player1.setPlayer1BuffCon(conIndex, -1);
						if (player1.getPlayer1BuffCon(conIndex) == 0)
							player1.passiveAbility(4);
					}
					if (player1.getPlayer1DebuffCon(conIndex) > 0)
					{
						player1.setPlayer1DebuffCon(conIndex, -1);
						if (player1.getPlayer1DebuffCon(conIndex) == 0)
							player1.passiveAbility(5);
					}
				}
				System.out.println("Your HP: "+player1.getHP()+"\tYour MP: "+player1.getMP());
				if (player1.getShield() > 0)
					System.out.println("Your Shield: "+player1.getShield());
				System.out.println("\n0-Basic Attack");
				System.out.println(player1.playerAbilities());
				System.out.println("\nInput the number in front of the move you want to take");
				int move = scan.nextInt();
				player1.useAbility(move);
				System.out.println("\nYour opponent's round:");
				System.out.println("Your opponent's HP: "+player2.getHP()+"\tYour opponent's MP: "+player2.getMP());
			}
		}
		
	}
}