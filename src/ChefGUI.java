import java.util.Observable;
import java.util.Observer;
import java.beans.*;;

@SuppressWarnings("deprecation")
public class ChefGUI implements Observer {
	Order newOrder;

	public ChefGUI() {
		System.out.println("Notificare!");
	}
	@Override
	public void update(Observable o, Object obj) {
		if(obj instanceof Order) {
			newOrder = (Order) obj;
			System.out.println("New order is:");
			for(MenuItem m : ((Order) obj).comanda) {
				System.out.println(m.name);
			}
		}
		
	}

}
