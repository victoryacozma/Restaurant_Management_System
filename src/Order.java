import java.util.ArrayList;
import java.util.Date;

public class Order {
	int orderId;
	Date date;
	int table;
	ArrayList<MenuItem> comanda = new ArrayList<MenuItem>();

	public Order(int id, Date d, int t, ArrayList<MenuItem> c) {
		orderId = id;
		date = d;
		table = t;
		comanda = c;
	}

}
