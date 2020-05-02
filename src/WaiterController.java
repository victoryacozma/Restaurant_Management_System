import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WaiterController {

	private Restaurant myRest;
	private RestaurantController resContr;

	public WaiterController(Restaurant a, RestaurantController b) {
		myRest = a;
		resContr = b;

		resContr.createNewOrderListener(new CreateOrderListener());
		resContr.computePriceListener(new ComputePriceListener());
		resContr.createBillListener(new CreateBillListener());
		resContr.viewOrderListener(new ViewOrderListener());

	}

	class CreateOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean gasit = false;
			int count = 0;
			String ordTable = resContr.getNewOrderTable();
			String ordCommand = resContr.getNewOrderCommand();
			int orderTable = Integer.parseInt(ordTable);
			Date date = new Date();

			String[] parts = ordCommand.split("\n");
			ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();

			for (String i : parts) {
				gasit = false;
				MenuItem menuItem;

				for (MenuItem j : myRest.getMenu()) {
					if (i.equals(j.name)) {
						menuItem = new BaseProduct(i, j.price);
						orderList.add(menuItem);
						gasit = true;
						break;
					}
				}

				if (gasit == false) {
					JOptionPane.showMessageDialog(new JFrame(), "This item doesn't exist");
				}

			}

			Order order = new Order(count, date, orderTable, orderList);
			myRest.addOrder(order);

			for (Order i : myRest.getorderList()) {
				System.out.println(i.table + " " + i.date);
				for (MenuItem j : i.comanda) {
					System.out.println(j.name + " " + j.price);
				}
			}

		}
	}

	class ComputePriceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String tableNumber = resContr.getTableNumber();
			int totalPrice = myRest.computePrice(tableNumber);
			resContr.setComputedPrice(totalPrice);

		}
	}

	class ViewOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean gasit = false;
			int count = 0;
			String ordTable = resContr.getViewOrderTable();
			int oTable = Integer.parseInt(ordTable);
			String orderInfo = new String();

			for (Order m : myRest.getorderList()) {
				gasit = false;
				if (m.table == oTable) {
					orderInfo = "Table : " + ordTable + "\n";
					for(MenuItem menuitem: m.comanda) {
						orderInfo += menuitem.name + "\n";
					}
					gasit = true;
					break;
				}
			}

			if (gasit == false) {
				JOptionPane.showMessageDialog(new JFrame(), "This table doesn't have any orders");
				return;
			}
			
			resContr.setOrderCommand(orderInfo);

		}
	}

	class CreateBillListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String tableNumber = resContr.getTableNumber();
			int tNumber = Integer.parseInt(tableNumber);
			int totalPrice = myRest.computePrice(tableNumber);

			try {
				File myObj = new File("bill.txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException err) {
				System.out.println("An error occurred.");
				err.printStackTrace();
			}

			try {
				FileWriter myWriter = new FileWriter("bill.txt");
				myWriter.write("Bill\n");
				myWriter.write("Table : " + tableNumber + "\n");
				for (Order i : myRest.getorderList()) {
					if (i.table == tNumber) {
						for (MenuItem j : i.comanda) {
							myWriter.write(j.name + " " + j.price + "\n");
						}
					}
				}

				myWriter.write("Total price : " + totalPrice);
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException err) {
				System.out.println("An error occurred.");
				err.printStackTrace();
			}

		}
	}

}
