import java.util.Random;
public class Player1 extends PlayerData
{
    private double damage;
    private int damagePoints = 0;
    private double defence;
    private int defencePoints = 0;
    private double[] technique = new double[2];
    private int techniquePoints = 0;
    private double speed;
    private int speedPoints = 0;
    private Ability[] playerAbility = new Ability[4];
    private int abilityCount = 1;
    private AbilityChart allAbility = new AbilityChart();
    private Random RD = new Random();
    private int odds = RD.nextInt(3);
	private int poisonConIndex = 0;
	private int burgerConIndex = 0;
	private int buffConIndex = 0;
	private int debuffConIndex = 0;
    
    public Player1()
    {
        damage = 1.0;
        defence = 1.0;
        technique[0] = 0.5;
        technique[1] = 1.0;
        speed = 0.0;
        playerAbility[0] = allAbility.getAbility(0);
		playerAbility[1] = allAbility.getAbility(0);
		playerAbility[2] = allAbility.getAbility(0);
		playerAbility[3] = allAbility.getAbility(0);
    }
    
    public void setPlayerAbility(int ability)
    {
        playerAbility[abilityCount] = allAbility.getAbility(ability); 
        abilityCount++;
    }
    
    public String getAbilityName(int index)
    {
        return playerAbility[index].getName();
    }
    
    public int getAbilityContinuity(int index)
    {
        return playerAbility[index].getContinuity();
    }
    
	public int getAllAbilityCost(int index)
	{
		return allAbility.getAbilityCost(index);
	}
	
    public double getHP()
    {
        return player1HP;
    }
    
    public double getMP()
    {
        return player1MP;
    }
	
	public double getShield()
	{
		return player1Shield;
	}
	
	public int getPlayer1PoisonCon(int index)
	{
		return player1PoisonCon[index];
	}
	
	public void setPlayer1PoisonCon(int index, int conDecline)
	{
		player1PoisonCon[index] += conDecline;
	}
	
	public int getPlayer1BurgerCon(int index)
	{
		return player1BurgerCon[index];
	}
	
	public void setPlayer1BurgerCon(int index, int conDecline)
	{
		player1BurgerCon[index] += conDecline;
	}
	
	public int getPlayer1BuffCon(int index)
	{
		return player1BuffCon[index];
	}
	
	public void setPlayer1BuffCon(int index, int conDecline)
	{
		player1BuffCon[index] += conDecline;
	}
	
	public int getPlayer1DebuffCon(int index)
	{
		return player1DebuffCon[index];
	}
    
	public void setPlayer1DebuffCon(int index, int conDecline)
	{
		player1DebuffCon[index] += conDecline;
	}
	
    public void setDamage(int points)
    {   
        damagePoints += points;
        damage += 0.5*points;
    }
	
	public int getDamagePoints()
	{
		return damagePoints;
	}
    
    public void setDefence(int points)
    {   
        defencePoints += points;
        defence += (-1/6)*points;
    }
	
	public int getDefencePoints()
	{
		return defencePoints;
	}
    
    public void setTechnique(int points)
    {   
        techniquePoints += points;
        technique[0] += 0.625*points;
        technique[1] += points;
    }
    
	public int getTechniquePoints()
	{
		return techniquePoints;
	}
    
	
    public void setSpeed(int points)
    {   
        speedPoints += points;
        speed += 0.15*points;
    }
    
	public int getSpeedPoints()
	{
		return speedPoints;
	}
	
    public double getSpeed()
    {
        return speed;
    }
    
    // use different abilities
    public void useAbility(int index)
    {
        switch (playerAbility[index].getName())
        {
            case "Attack":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2HP += playerAbility[index].getEffect()*damage*player1Status;
				player1MP += playerAbility[index].getCost();
                break;
            case "Heal":
                if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
				player1HP += playerAbility[index].getEffect();
                player1MP += playerAbility[index].getCost();
				if (player1HP > 200.0)
					player1HP = 200.0;
                break;
            case "Poison":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2HP += playerAbility[index].getEffect()*damage*player1Status;
				player1PoisonCon[poisonConIndex] = playerAbility[index].getContinuity();
				poisonConIndex++;
                player1MP += playerAbility[index].getCost();
                break;
            case "Eat A Burger":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1HP += playerAbility[index].getEffect();
				player1BurgerCon[burgerConIndex] = playerAbility[index].getContinuity();
				burgerConIndex++;
                player1MP += playerAbility[index].getCost();
				if (player1HP > 200.0)
					player1HP = 200.0;
                break;
            case "Strength Buff":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1Status += playerAbility[index].getEffect()*technique[0];
				player1BuffCon[buffConIndex] = playerAbility[index].getContinuity();
				buffConIndex++;
                player1MP += playerAbility[index].getCost();
                break;
            case "Strength Debuff":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2Status *= playerAbility[index].getEffect();
				player1DebuffCon[debuffConIndex] = playerAbility[index].getContinuity()*(int)technique[1];
				debuffConIndex++;
                player1MP += playerAbility[index].getCost();
                break;
			case "Shield":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
				player1Shield = playerAbility[index].getEffect();
				player1MP += playerAbility[index].getCost();
				break;
            case "Purify":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                if (player1Status < 1)
                    player1Status = playerAbility[index].getEffect();
                if (player2Status > 1)
                    player2Status = playerAbility[index].getEffect();
				for (int conIndex = 0; conIndex < 10; conIndex++)
				{	
					player2PoisonCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player2BurgerCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player2BuffCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player2DebuffCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
				}
                player1MP += playerAbility[index].getCost();
                break;
            case "Snare":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2Snare = true;
                break;
            case "Instant Kill":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                if (player2HP < 200/3)
                    if (odds == 0 || odds == 1)
                        player2HP = playerAbility[index].getEffect();
                player1MP += playerAbility[index].getCost();
                break;
            case "Magic Potion":
				if (player1MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1MP +=  playerAbility[index].getEffect();
				player1MP += playerAbility[index].getCost();
				if (player1MP > 100.0)
					player1MP = 100.0;
                break;  
        }
    }
    
    
	public void passiveAbility(int index)
	{
		switch (allAbility.getAbilityName(index))
        {
			case "Poison":
				player2HP += allAbility.getAbilityEffect(index)*damage*player1Status;
				break;
			case "Eat A Burger":
				player1HP += allAbility.getAbilityEffect(index);
				break;
			case "Strength Buff":
                player1Status += -allAbility.getAbilityEffect(index)*technique[0];
				break;
			case "Strength Debuff":
				player2Status /= allAbility.getAbilityEffect(index);
				break;
		}
	}
	
    public String playerAttributes()
    {
        String display = "Your Attributes: 1-Damage("+damagePoints+")\t2-Defence("+defencePoints+")\t3-Technique("+techniquePoints+")\t  4-Speed("+speedPoints+")";
        return display;
    }
    
    public String playerAbilities()
    {
        String display = "Your Abilities: 1-"+playerAbility[1].getName()+"\t\t2-"+playerAbility[2].getName()+"\t\t3-"+playerAbility[3].getName();
        return display;
    }
}
