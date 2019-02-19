package views;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;

public class DefeatPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DefeatPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
                Image img = new ImageIcon(this.getClass().getResource("/You-Died.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(48, 120, 288, 58);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your details will be remembered in the database of heroes!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 209, 345, 36);
		add(lblNewLabel_1);

	}
}