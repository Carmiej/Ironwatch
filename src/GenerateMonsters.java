import java.math.*;
import java.util.Random;

public class GenerateMonsters {
	
	public Monster generate()
	{
		int number = 1;
		Monster monster = null;
		Random rand = new Random();
		//number = rand.nextInt(1)+1;
		
		if (number == 1)
		{
			monster = Slime();
		}
		
		
		return monster;
		
	}
	
	private Monster Slime()
	{
		Monster slime = new Monster("Slime", 10, 1, 4, 4, 0, "Glob");
		return slime;
	}
	

}
