package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import models.*;

public class ExplorePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextPane textPane = new JTextPane();
	JButton enterButton = new JButton("enter");
        JLabel image = new JLabel("New label");
        Image img;
        
	public ExplorePanel(Game gameData) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 400, 340);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		textPane.setBounds(30, 236, 330, 87);
		textPane.setText("Welcome Adventurer!");
		textPane.setEditable(false);
		add(textPane);

		JButton statusButton = new JButton("status");
		statusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextPane(gameData.getPlayer().getPlayerInformation());
			}
		});
		statusButton.setBounds(20, 202, 82, 23);
		add(statusButton);
		
		JButton helpButton = new JButton("help");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextPane("This game requires you to defeat the final boss at room 10 to win," + 
						  "In order to accomplish this you must level up, fight and strengthen"+
						  " your character. Returning to the start will restore your health but"+
						  " will also repopulate the map with monsters!");
			}
		});
		helpButton.setBounds(108, 202, 82, 23);
		add(helpButton);

		JButton searchButton = new JButton("search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextPane(gameData.getMap().printRoomDetails(gameData.getPlayer()));
			}
		});
		searchButton.setBounds(200, 202, 82, 23);
		add(searchButton);

		
		enterButton.setBounds(292, 202, 82, 23);
		add(enterButton);

		
		img = new ImageIcon(this.getClass().getResource(
                gameData.getMap().getRooms().get(gameData.getPlayer().getPlayerLocation()-1)
                .getImg())).getImage();
		image.setIcon(new ImageIcon(img));
		image.setBounds(88, 11, 199, 180);
		add(image);
	}

	public void setTextPane(String text) {
		textPane.setText(text);
	}
	
	public void handleVictory(Game gameData){
		textPane.setText("You have defeated the "+gameData.getMonster().getName()+" collecting "
						+gameData.getMonster().getExp()+" Exp and "+gameData.getMonster().getGold()+" gold!");
		gameData.getPlayer().setPlayerGold(gameData.getPlayer().getPlayerGold() + gameData.getMonster().getGold());
		gameData.getPlayer().setPlayerXp(gameData.getPlayer().getPlayerXp() + gameData.getMonster().getExp());
		gameData.getPlayer().setKillCount(gameData.getPlayer().getKillCount()+1);
		if(gameData.getPlayer().checkLevelUp()){
			textPane.setText("Congratulations!!! You are now level "+gameData.getPlayer().getPlayerLevel()+"! "+
							 "You have been given a stats boost and a minor health increase");
		}
		gameData.getMap().getRooms().get(gameData.getPlayer().getPlayerLocation()-1).setMonster(false);
		
	}
	
	public JTextPane getTextPane() {
            return textPane;
            }
        
    public JButton getEnterButton() {return enterButton;}

    public JLabel getLabel() {return image;}
    
    public void setImage(Game gameData){
                    
            img = new ImageIcon(this.getClass().getResource(
                gameData.getMap().getRooms().get(gameData.getPlayer().getPlayerLocation()-1)
                .getImg())).getImage();
            image.setIcon(new ImageIcon(img));
    }
}
