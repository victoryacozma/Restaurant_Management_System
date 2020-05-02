import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) throws IOException {

		MenuItem m1 = new BaseProduct("coffee", 5);
		MenuItem m2 = new BaseProduct("croissant", 3);
		MenuItem m3 = new BaseProduct("cheesecake", 10);
		MenuItem m4 = new BaseProduct("fries", 10);
		MenuItem m5 = new BaseProduct("pizza", 100);

		Restaurant myRest = new Restaurant();
		myRest.addObserver(new ChefGUI());
		myRest.addItemToMenu(m1);
		myRest.addItemToMenu(m2);
		myRest.addItemToMenu(m3);
		myRest.addItemToMenu(m4);
		myRest.addItemToMenu(m5);

		LogInGUI logGUI = new LogInGUI();
		WaiterGUI waiterGUI = new WaiterGUI();
		waiterGUI.mainFrame.setVisible(false);
		AdministratorGUI adminGUI = new AdministratorGUI();
		adminGUI.mainFrame.setVisible(false);
		RestaurantController r1 = new RestaurantController(logGUI, waiterGUI, adminGUI, myRest);
		AdminController adminController = new AdminController(myRest, r1);
		WaiterController waiterController = new WaiterController(myRest, r1);

		ArrayList<MenuItem> o1 = new ArrayList<MenuItem>();
		o1.add(m1);
		o1.add(m3);
		Date today = new Date();
		Order myOrder = new Order(1, today, 1, o1);
		myRest.addOrder(myOrder);

		SerializableClass object = new SerializableClass();

		FileOutputStream file = new FileOutputStream("restaurant.ser");
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(object);
		out.close();
		file.close();

	}

}
