import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class WaiterGUI implements IRestaurantProcessing {

	public JTextField[][] index = new JTextField[9][9];
	public JFrame mainFrame;

	private ImageIcon newOrderImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\add.png");
	private ImageIcon computePriceImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\calculator.png");
	private ImageIcon viewOrdersImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\view.png");
	private ImageIcon generateBillImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\bill.png");
	private ImageIcon backImage = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\back.png");

	private JButton newOrderBtn = new JButton("New Order", newOrderImage);
	private JButton computePriceBtn = new JButton("Compute Price", computePriceImage);
	private JButton viewOrdersBtn = new JButton("View Orders", viewOrdersImage);
	private JButton generateBillBtn = new JButton("Bill", generateBillImage);
	private JButton backBtn = new JButton("Back", backImage);
	public JPanel board;
	private JLabel background;

	
	WaiterGUI() {
		
		mainFrame = new JFrame();
        mainFrame.setTitle("My restaurant");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(500, 500, 500, 500);
        JPanel butoane = new JPanel();
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(newOrderBtn);
		butoane.add(Box.createRigidArea(new Dimension(0,5)));
		butoane.add(computePriceBtn);
		butoane.add(Box.createRigidArea(new Dimension(0,5)));
		butoane.add(viewOrdersBtn);
		butoane.add(Box.createRigidArea(new Dimension(0,5)));
		butoane.add(generateBillBtn);
		butoane.add(Box.createRigidArea(new Dimension(0,50)));
		butoane.add(backBtn);
		butoane.setOpaque(false);
   
        mainFrame.setLocationRelativeTo(null);
        
        ImageIcon img=new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
        background = new JLabel();
        background.setIcon(img);
        background.setLayout( new SpringLayout());
        mainFrame.setContentPane( background );
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
    
    public void addOrderListener(ActionListener cal) {
		newOrderBtn.addActionListener(cal);
	}
    
    public void computePriceListener(ActionListener cal) {
		computePriceBtn.addActionListener(cal);
	}
    
    public void createBillListener(ActionListener cal) {
		generateBillBtn.addActionListener(cal);
	}
    
    public void viewOrderListener(ActionListener cal) {
		viewOrdersBtn.addActionListener(cal);
	}

	@Override
	public void deleteMenuItemListener(ActionListener cal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editMenuItemListener(ActionListener cal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewMenuItemListener(ActionListener cal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCreateItemListener(ActionListener cal) {
		// TODO Auto-generated method stub
		
	}

	
}
