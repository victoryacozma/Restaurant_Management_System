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

public class AdministratorGUI implements IRestaurantProcessing {

	public JFrame mainFrame;

	private ImageIcon addImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\add.png");
	private ImageIcon deleteImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\delete.png");
	private ImageIcon viewImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\view.png");
	private ImageIcon editImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\edit.png");
	private ImageIcon backImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\back.png");

	private JButton addBtn = new JButton("Add item", addImage);
	private JButton deleteBtn = new JButton("Delete Item", deleteImage);
	private JButton viewBtn = new JButton("View Items", viewImage);
	private JButton editBtn = new JButton("Edit Item", editImage);
	private JButton backBtn = new JButton("Back", backImage);
	public JPanel board;
	private JLabel background;

	AdministratorGUI() {

		mainFrame = new JFrame();
		mainFrame.setTitle("My restaurant");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(500, 500, 500, 500);
		JPanel butoane = new JPanel();
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(addBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 5)));
		butoane.add(deleteBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 5)));
		butoane.add(editBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 5)));
		butoane.add(viewBtn);
		butoane.add(Box.createRigidArea(new Dimension(0, 50)));
		butoane.add(backBtn);
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

	void addBackListener(ActionListener cal) {
		backBtn.addActionListener(cal);
	}

	public void addCreateItemListener(ActionListener cal) {
		addBtn.addActionListener(cal);

	}

	public void deleteMenuItemListener(ActionListener cal) {
		deleteBtn.addActionListener(cal);

	}

	public void editMenuItemListener(ActionListener cal) {
		editBtn.addActionListener(cal);

	}

	public void viewMenuItemListener(ActionListener cal) {
		viewBtn.addActionListener(cal);

	}

	@Override
	public void addOrderListener(ActionListener cal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void computePriceListener(ActionListener cal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createBillListener(ActionListener cal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewOrderListener(ActionListener cal) {
		// TODO Auto-generated method stub

	}

}
