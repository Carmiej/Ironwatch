package views;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import models.*;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.math.*;
import java.util.Random;

public class CombatPanel extends JPanel {

	private JTextPane textPane = new JTextPane();
	private JButton attackButton = new JButton("Attack");
	private JButton runButton = new JButton("Run");
        JLabel imageLabel = new JLabel("New label");
        Image img = new ImageIcon(this.getClass().getResource("/cell.jpg")).getImage();
        
	public CombatPanel(Game gameData) {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 400, 340);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		
		imageLabel.setBounds(10, 11, 199, 247);
                
		
		imageLabel.setIcon(new ImageIcon(img));
		add(imageLabel);
		
		
		attackButton.setBounds(256, 51, 89, 23);
		add(attackButton);
		
		JButton statsButton = new JButton("Stats");
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("Player health: "+gameData.getPlayer().getPlayerCurrentHealth()+
							   "\nMonster health: "+ gameData.getMonster().getHealth()+" level: "+gameData.getMonster().getLevel());
			}
		});
		statsButton.setBounds(256, 99, 89, 23);
		add(statsButton);
		
		runButton.setBounds(256, 148, 89, 23);
		add(runButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("During combat you have the option to attack which deals damage to the enemy, "
						+ "then you, running has a 50/50 chance of either "
						+ "escaping to the second room or taking x2 damage!");
			}
		});
		helpButton.setBounds(256, 198, 89, 23);
		add(helpButton);
		
		textPane.setBounds(20, 269, 355, 54);
		add(textPane);
	}
	
	public void setText(String text){
		textPane.setText(text);
	}
	
	public void setText(Monster monster){
		textPane.setText("You are being attacked by a "+monster.getName()+"! Prepare Yourself!");
	}
	
	public void setText(Monster monster, Player player){
		textPane.setText("You strike enemy "+monster.getName()+" for "+player.getPlayerDamage()
						+", "+monster.getName()+" hits you for "+monster.getDamage()+" your armour"
						+" blocking "+player.getPlayerArmor()+" of the damage"+". Enemy health:"
						+monster.getHealth()+", Player health:"+player.getPlayerCurrentHealth());
	}
	
	public void damageMonster(Game gameData){
		gameData.getMonster().setHealth(gameData.getMonster().getHealth() -
				gameData.getPlayer().getPlayerDamage());
	}

	public void damagePlayer(Game gameData){
		gameData.getPlayer().takeDamage(gameData.getMonster().getDamage());
	}
	
	public JButton getAttackButton(){
		return attackButton;
	}
	
	public JButton getRunButton(){
		return runButton;
	}
        
        public void setImage(Monster monster){
                    
            img = new ImageIcon(this.getClass().getResource(
                monster.getImageLink())).getImage(); 
            imageLabel.setIcon(new ImageIcon(img));
        }
}
