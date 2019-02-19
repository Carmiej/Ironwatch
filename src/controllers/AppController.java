package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import sun.audio.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.*;
import models.*;

public class AppController extends JFrame {

	private Container contain;
	Game gameData = new Game();
        IronwatchDB db = new IronwatchDB();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController frame = new AppController();
					frame.setVisible(true);
                                        frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
	public AppController() {
		super("IRONWATCH");
                db.connectDB();
                db.createTable();
                
                String[] results = db.getTable();
                
                int i = 0;
                while (i<results.length)
                {
                    System.out.println(results[i]);
                    ++i;
                }
               
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 370);
                
		gameData.setUp();
                
                ExplorePanel explore = new ExplorePanel(gameData);
		MenuPanel menu = new MenuPanel(gameData.getPlayer(), db);
		CombatPanel combat = new CombatPanel(gameData);
		DefeatPanel defeat = new DefeatPanel();
                
		getContentPane().add(menu);
                
		explore.getEnterButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameData.getPlayer().setPlayerLocation(Integer.parseInt(JOptionPane.showInputDialog("Enter room number: ")),
						gameData.getMap().connectedRooms(gameData.getPlayer().getPlayerLocation()), explore.getTextPane());
				if(gameData.getMap().getRooms().get(gameData.getPlayer().getPlayerLocation()-1).getMonster() == true){
					gameData.setMonster(gameData.getObtainMonster().generate(gameData.getPlayer()));
					switchPanel(combat);
					combat.setText(gameData.getMonster());
                                        combat.setImage(gameData.getMonster());
				}
				else if(gameData.getPlayer().getPlayerLocation() == 1){
					gameData.getMap().repopulate();
					gameData.getPlayer().setPlayerCurrentHealth(gameData.getPlayer().getPlayerMaxHealth());
					explore.setTextPane("Map has been repopulated with monsters and your health has been restored!");
				}
                                explore.setImage(gameData);
			}
		});
		
		menu.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameData.getPlayer().setPlayerName(menu.getField().getText());
				switchPanel(explore);
                                playMP3();
			}
		});
		
		combat.getAttackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combat.damageMonster(gameData);
				if(gameData.getMonster().getHealth() <= 0){
					switchPanel(explore);
					explore.handleVictory(gameData);
				}
				combat.damagePlayer(gameData);
				if(gameData.getPlayer().getPlayerCurrentHealth() <= 0){
                                    try {
                                        db.updateTable(gameData.getPlayer().getPlayerName(), gameData.getPlayer().getKillCount());
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					switchPanel(defeat);
				}
				combat.setText(gameData.getMonster(), gameData.getPlayer());
			}
		});
		
		combat.getRunButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int number = rand.nextInt(2) + 1;
				if(number == 1){
					gameData.getPlayer().takeDamage(gameData.getMonster().getDamage());
					combat.setText("You have been hit by a "+(gameData.getMonster().getDamage())*2
									+" damage penelty");
                                        if(gameData.getPlayer().getPlayerCurrentHealth() <= 0){
                                            try {
                                                db.updateTable(gameData.getPlayer().getPlayerName(), gameData.getPlayer().getKillCount());
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            switchPanel(defeat);
                                        }
                                }
				else if(number == 2){
					switchPanel(explore);
					gameData.getPlayer().setPlayerLocation(2);
					explore.setTextPane("You have successfully escaped to the second room!");
				}
			}
		});
	}
	
	public void switchPanel(JPanel panel){
		contain = getContentPane();
		contain.removeAll();
		contain.add(panel);
		contain.validate();
		contain.repaint();
	}
        
        public static void playMP3() {
            new javafx.embed.swing.JFXPanel();
            String uriString = new File("music.mp3").toURI().toString();
            new MediaPlayer(new Media(uriString)).play();
        }
}
