import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RestaurantController {
	JFrame mainFrame;
	JFrame mainFrame1;
	JFrame mainFrame2;
	JFrame mainFrame3;

	JFrame createOrderFrame;

	private WaiterGUI waiterGUI;
	private AdministratorGUI adminGUI;
	private LogInGUI loginGUI;
	private Restaurant myRes;

	JComboBox myComboBox;
	JComboBox tableComboBox;
	JComboBox viewOrderComboBox;
	JLabel numeProdus = new JLabel("Product Name: ");
	JLabel pretProdus = new JLabel("Price: ");
	JLabel pretNouProdus = new JLabel("New Price: ");
	JLabel newOrderTable = new JLabel("Table: ");
	JLabel newOrderCommand = new JLabel("Order: ");
	JLabel chooseTable = new JLabel("Choose table ");
	JLabel totalPrice = new JLabel("Total: ");
	JTextField nProd = new JTextField(20);
	JTextField deleteProdName = new JTextField(20);
	JTextField pretProd = new JTextField(20);
	JTextField pretNouProd = new JTextField(20);
	JTextField newOrdTable = new JTextField(20);
	JTextField computedPrice = new JTextField(20);
	JTextArea command = new JTextArea(6, 20);
	JTextArea viewcommand = new JTextArea(6, 20);
	JButton addProdBtn = new JButton("Add");
	JButton deleteProdBtn = new JButton("Delete");
	JButton editProdBtn = new JButton("Edit");
	JButton cancelBtn = new JButton("Cancel");
	JButton createOrderBtn = new JButton("Create new order");
	JButton computePriceBtn = new JButton("Compute Price");
	JButton createBillBtn = new JButton("Bill");
	JButton viewOrderBtn = new JButton("ViewOrder");
	JLabel background;

	public RestaurantController(LogInGUI c, WaiterGUI a, AdministratorGUI b, Restaurant r) {
		waiterGUI = a;
		adminGUI = b;
		loginGUI = c;
		myRes = r;

		loginGUI.addWaiterListener(new WaiterListener());
		loginGUI.addAdminListener(new AdminListener());
		adminGUI.addBackListener(new BackListener());
		adminGUI.addCreateItemListener(new CreateItemListener());
		adminGUI.deleteMenuItemListener(new DeleteItemListener());
		adminGUI.editMenuItemListener(new EditItemListener());
		adminGUI.viewMenuItemListener(new ViewItemListener());

		waiterGUI.addBackListener(new BackListener());
		waiterGUI.addOrderListener(new CreateOrderListener());
		waiterGUI.computePriceListener(new ComputePriceListener());
		waiterGUI.createBillListener(new CreateBillListener());
		waiterGUI.viewOrderListener(new ViewOrderListener());

	}

	class WaiterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			waiterGUI.mainFrame.setVisible(true);
			loginGUI.mainFrame.setVisible(false);
		}
	}

	class AdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			adminGUI.mainFrame.setVisible(true);
			loginGUI.mainFrame.setVisible(false);
		}
	}

	class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			loginGUI.mainFrame.setVisible(true);
			adminGUI.mainFrame.setVisible(false);
			waiterGUI.mainFrame.setVisible(false);
		}
	}

	class CreateItemListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame = new JFrame();
			mainFrame.setTitle("Admin");
			mainFrame.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel butoane = new JPanel();
			JPanel finalPanel = new JPanel();

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(numeProdus);
			labels.add(pretProdus);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(nProd);
			fields.add(pretProd);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels);
			finalPanel.add(fields);
			finalPanel.add(addProdBtn);

			mainFrame.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			mainFrame.setContentPane(background);
			mainFrame.add(finalPanel, "West");
			mainFrame.setResizable(false);
			mainFrame.setVisible(true);

		}

	}

	class DeleteItemListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame1 = new JFrame();
			mainFrame1.setTitle("Admin");
			mainFrame1.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel finalPanel = new JPanel();

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(numeProdus);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(deleteProdName);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels);
			finalPanel.add(fields);
			finalPanel.add(deleteProdBtn);

			mainFrame1.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			mainFrame1.setContentPane(background);
			mainFrame1.add(finalPanel, "West");
			mainFrame1.setResizable(false);
			mainFrame1.setVisible(true);

		}

	}

	class EditItemListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame2 = new JFrame();
			mainFrame2.setTitle("EditItem");
			mainFrame2.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel finalPanel = new JPanel();

			String[] productsName = new String[myRes.getMenu().size()];
			int i = 0;
			for (MenuItem m : myRes.getMenu()) {
				productsName[i] = m.name;
				i++;
			}

			myComboBox = new JComboBox(productsName);

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(numeProdus);
			labels.add(pretNouProdus);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(myComboBox);
			fields.add(pretNouProd);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels);
			finalPanel.add(fields);
			finalPanel.add(editProdBtn);

			mainFrame2.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			mainFrame2.setContentPane(background);
			mainFrame2.add(finalPanel, "West");
			mainFrame2.setResizable(false);
			mainFrame2.setVisible(true);

		}

	}

	class ViewItemListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame3 = new JFrame();
			mainFrame3.setTitle("View items");
			mainFrame3.setBounds(500, 500, 500, 500);
			mainFrame3.setLocationRelativeTo(null);

			JTable myJtable;
			int size = myRes.getMenu().size();
			String[][] data = new String[size][2];

			for (int i = 0; i < myRes.getMenu().size(); i++) {
				int j = 0;
				data[i][j] = myRes.getMenu().get(i).name;
				String s = String.valueOf(myRes.getMenu().get(i).price);
				data[i][j + 1] = s;
			}

			String[] columnNames = { "Product Name", "Price" };
			myJtable = new JTable(data, columnNames);
			JScrollPane sp = new JScrollPane(myJtable);

			mainFrame3.add(sp);
			mainFrame3.setResizable(false);
			mainFrame3.setVisible(true);

		}

	}

	class CreateOrderListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			createOrderFrame = new JFrame();
			createOrderFrame.setTitle("Create new Order");
			createOrderFrame.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel butoane = new JPanel();
			JPanel finalPanel = new JPanel();

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(newOrderTable);
			labels.add(Box.createRigidArea(new Dimension(0, 50)));
			labels.add(newOrderCommand);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(newOrdTable);
			labels.add(Box.createRigidArea(new Dimension(0, 30)));
			fields.add(command);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels, "North");
			finalPanel.add(fields);
			finalPanel.add(createOrderBtn);

			createOrderFrame.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			createOrderFrame.setContentPane(background);
			createOrderFrame.add(finalPanel);
			createOrderFrame.setResizable(false);
			createOrderFrame.setVisible(true);

		}

	}

	class ComputePriceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			createOrderFrame = new JFrame();
			createOrderFrame.setTitle("ComputePrice");
			createOrderFrame.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel butoane = new JPanel();
			JPanel finalPanel = new JPanel();

			String[] tableNumbers = new String[myRes.getorderList().size()];
			int i = 0;
			for (Order m : myRes.getorderList()) {
				String nrAux = String.valueOf(m.table);
				tableNumbers[i] = nrAux;
				i++;
			}

			tableComboBox = new JComboBox(tableNumbers);

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(chooseTable);
			labels.add(totalPrice);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(tableComboBox);
			fields.add(computedPrice);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels, "North");
			finalPanel.add(fields);
			finalPanel.add(computePriceBtn);

			createOrderFrame.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			createOrderFrame.setContentPane(background);
			createOrderFrame.add(finalPanel);
			createOrderFrame.setResizable(false);
			createOrderFrame.setVisible(true);

		}

	}


	class CreateBillListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			createOrderFrame = new JFrame();
			createOrderFrame.setTitle("ComputePrice");
			createOrderFrame.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel butoane = new JPanel();
			JPanel finalPanel = new JPanel();

			String[] tableNumbers = new String[myRes.getorderList().size()];
			int i = 0;
			for (Order m : myRes.getorderList()) {
				String nrAux = String.valueOf(m.table);
				tableNumbers[i] = nrAux;
				i++;
			}

			tableComboBox = new JComboBox(tableNumbers);

			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(chooseTable);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(tableComboBox);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels, "North");
			finalPanel.add(fields);
			finalPanel.add(createBillBtn);

			createOrderFrame.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			createOrderFrame.setContentPane(background);
			createOrderFrame.add(finalPanel);
			createOrderFrame.setResizable(false);
			createOrderFrame.setVisible(true);

		}

	}
	
	class ViewOrderListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			createOrderFrame = new JFrame();
			createOrderFrame.setTitle("View order");
			createOrderFrame.setBounds(500, 500, 500, 500);
			JPanel labels = new JPanel();
			JPanel fields = new JPanel();
			JPanel butoane = new JPanel();
			JPanel finalPanel = new JPanel();

			String[] tableNumbers = new String[myRes.getorderList().size()];
			int i = 0;
			for (Order m : myRes.getorderList()) {
				String nrAux = String.valueOf(m.table);
				tableNumbers[i] = nrAux;
				i++;
			}

			viewOrderComboBox = new JComboBox(tableNumbers);
			
			labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
			labels.add(newOrderTable);
			labels.add(Box.createRigidArea(new Dimension(0, 50)));
			labels.add(newOrderCommand);

			fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
			fields.add(viewOrderComboBox);
			labels.add(Box.createRigidArea(new Dimension(0, 30)));
			viewcommand.setEditable(false);
			fields.add(viewcommand);

			finalPanel.setLayout(new FlowLayout());
			finalPanel.add(labels, "North");
			finalPanel.add(fields);
			finalPanel.add(viewOrderBtn);

			createOrderFrame.setLocationRelativeTo(null);

			ImageIcon img = new ImageIcon("C:\\Users\\Victoria Cozma\\OneDrive\\Рабочий стол\\restaurant.jpg");
			background = new JLabel();
			background.setIcon(img);
			background.setLayout(new SpringLayout());
			createOrderFrame.setContentPane(background);
			createOrderFrame.add(finalPanel);
			createOrderFrame.setResizable(false);
			createOrderFrame.setVisible(true);

		}

	}

	void createMenuItemListener(ActionListener cal) {
		addProdBtn.addActionListener(cal);
	}

	void deleteMenuItemListener(ActionListener cal) {
		deleteProdBtn.addActionListener(cal);
	}

	void editMenuItemListener(ActionListener cal) {
		editProdBtn.addActionListener(cal);
	}

	void createNewOrderListener(ActionListener cal) {
		createOrderBtn.addActionListener(cal);
	}

	void computePriceListener(ActionListener cal) {
		computePriceBtn.addActionListener(cal);
	}

	void createBillListener(ActionListener cal) {
		createBillBtn.addActionListener(cal);
	}
	
	void viewOrderListener(ActionListener cal) {
		viewOrderBtn.addActionListener(cal);
	}

	String getNewProductName() {
		String prodName = nProd.getText();
		return prodName;
	}

	String getNewProductPrice() {
		String prodPret = pretProd.getText();
		return prodPret;
	}

	String getNewProductNewPrice() {
		String prodPret = pretNouProd.getText();
		return prodPret;
	}

	String getProdToEdit() {
		String prodPret = (String) myComboBox.getSelectedItem();
		return prodPret;
	}

	String getProdToDelete() {
		String prodPret = deleteProdName.getText();
		return prodPret;
	}

	String getNewOrderTable() {
		String prodName = newOrdTable.getText();
		return prodName;
	}
	
	String getViewOrderTable() {
		String prodName = (String) viewOrderComboBox.getSelectedItem();
		return prodName;
	}

	String getNewOrderCommand() {
		String prodName = command.getText();
		return prodName;
	}

	String getTableNumber() {
		String prodName = (String) tableComboBox.getSelectedItem();
		return prodName;
	}
	
	void setOrderCommand(String s) {
		viewcommand.setText(s);
	}

	void setComputedPrice(int price) {
		String sPrice = String.valueOf(price);
		computedPrice.setText(sPrice);
		computedPrice.setEditable(false);
	}

}
