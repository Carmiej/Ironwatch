import java.util.Scanner;

public class Combat {

	private static final String ATTACK = "attack";
	private int playerDamage;
	private int monsterDamage;
	private String input;
	Scanner scanner = new Scanner(System.in);
	
	public void battle(Player player, Monster monster)
	{
		System.out.println("-----------------------------------------------------------------");
		System.out.println("You have enterd battlemode.");
		System.out.println("-----------------------------------------------------------------");
		
		System.out.println("You are now Facing: "+monster.getName());
		System.out.println(monster.getEmote());
		
		
		while (monster.getHealth() > 0)
		{
			System.out.println("Please enter a command: ");
			input = scanner.nextLine();
			
			
			switch(input.toLowerCase())
			{
				case ATTACK:
				{
					playerDamage = player.getPlayerDamage();
					monster.takeDamage(playerDamage);
					System.out.println(monster.getName()+" has lost "+playerDamage+" damage.");
					System.out.println("-----------------------------------------------------------------");
					if (monster.getHealth() <= 0)
					{
						System.out.println("-----------------------------------------------------------------");
						System.out.println(monster.getName()+" has fallen");
						player.setPlayerGold(monster.getGold());
						System.out.println("Your gold count is now: "+player.getPlayerGold());
						System.out.println("-----------------------------------------------------------------");
					}
					else
					{
						monsterDamage = monster.getDamage();
						player.setPlayerCurrentHealth(monsterDamage);
						System.out.println("You take "+monsterDamage+" damage");
						System.out.println("-----------------------------------------------------------------");
					}
					if (player.getPlayerCurrentHealth() < 0)
					{
						System.out.println("-----------------------------------------------------------------");
						System.out.println("You have died, better luck next time.");
						System.out.println("-----------------------------------------------------------------");
						System.exit(0);
						break;
					}
					else
					{
					// do nothing
					}
				}
				break;
			
			}
			System.out.println("-----------------------------------------------------------------");
		}
		}
		
		
	}
	

