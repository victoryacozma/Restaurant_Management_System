import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LogInGUI {

	public JTextField[][] index = new JTextField[9][9];
	public JFrame mainFrame;

	private JButton waiterBtn = new JButton("Log in as Waiter");
	private JButton administratorBtn = new JButton("Log in as Administrator");
	//private JButton chefBtn = new JButton("Log in as Chef");
	public JPanel board;
	private JLabel background;

	LogInGUI() {

		mainFrame = new JFrame();
		mainFrame.setTitle("My restaurant");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(300, 300, 400, 400);
		JPanel butoane = new JPanel();
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(Box.createRigidArea(new Dimension(0, 100)));
		butoane.add(Box.createRigidArea(new Dimension(200, 0)));
		butoane.add(waiterBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 10)));
		butoane.add(administratorBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 10)));
		//butoane.add(chefBtn);
		butoane.setOpaque(false);

		mainFrame.setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
		background = new JLabel();
		background.setIcon(img);
		background.setLayout(new SpringLayout());
		mainFrame.setContentPane(background);
		mainFrame.add(butoane, "East");
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}

	public void setIconImage(Image image) {
		// TODO Auto-generated method stub
		mainFrame.setIconImage(image);
	}
	
	void addWaiterListener(ActionListener cal) {
		waiterBtn.addActionListener(cal);
	}
	
	void addAdminListener(ActionListener cal) {
		administratorBtn.addActionListener(cal);
	}
	
}
