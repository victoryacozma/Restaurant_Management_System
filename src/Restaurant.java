import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Restaurant extends Observable{
	private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	// private HashMap<Order, Collection<MenuItem>> orderList = new HashMap<Order,
	// Collection<MenuItem>>();
	private ArrayList<Order> orderList = new ArrayList<Order>();

	public void addItemToMenu(MenuItem m) {
		menu.add(m);
	}

	public void deleteItemToMenu(String name) {
		Iterator itr = menu.iterator();
		while (itr.hasNext()) {
			MenuItem x = (MenuItem) itr.next();
			if (x.name.equals(name)) {
				itr.remove();
				return;
			}
		}
		JOptionPane.showMessageDialog(new JFrame(), "This item doesn't exist");
	}

	public void editItemToMenu(String name, String price) {

		int newPrice = Integer.parseInt(price);
		Iterator itr = menu.iterator();
		while (itr.hasNext()) {
			MenuItem x = (MenuItem) itr.next();
			if (x.name.equals(name)) {
				x.price = newPrice;
				return;
			}
		}
		JOptionPane.showMessageDialog(new JFrame(), "This item doesn't exist");
	}

	public int computePrice(String s) {

		int tableNumber = Integer.parseInt(s);
		int totalPrice = 0;

		for (Order i : orderList) {
			if (i.table == tableNumber) {
				for (MenuItem j : i.comanda) {
					totalPrice += j.price;
				}
			}
		}
		return totalPrice;
	}

	public ArrayList<MenuItem> getMenu() {
		return menu;
	}

	public ArrayList<Order> getorderList() {
		return orderList;
	}

	public void addOrder(Order b) {
		orderList.add(b);
		notifyObservers(b);
	}

}
