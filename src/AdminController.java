import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {

	private Restaurant myRest;
	private RestaurantController resContr;

	public AdminController(Restaurant a, RestaurantController b) {
		myRest = a;
		resContr = b;

		resContr.createMenuItemListener(new CreateMenuItemListener());
		resContr.deleteMenuItemListener(new DeleteMenuItemListener());
		resContr.editMenuItemListener(new EditMenuItemListener());

	}

	class CreateMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String prodName = resContr.getNewProductName();
			String prodPriceString = resContr.getNewProductPrice();
			int prodPrice = Integer.parseInt(prodPriceString);

			MenuItem newMenuItem = new BaseProduct(prodName, prodPrice);
			myRest.addItemToMenu(newMenuItem);

			for (MenuItem i : myRest.getMenu()) {
				System.out.println(i.name + " " + i.price);
			}

		}
	}

	class DeleteMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String prodName = resContr.getProdToDelete();
			myRest.deleteItemToMenu(prodName);

			for (MenuItem i : myRest.getMenu()) {
				System.out.println(i.name + " " + i.price);
			}

		}
	}

	class EditMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String prodName = resContr.getProdToEdit();
			String newPrice = resContr.getNewProductNewPrice();
			myRest.editItemToMenu(prodName, newPrice);

			for (MenuItem i : myRest.getMenu()) {
				System.out.println(i.name + " " + i.price);
			}

		}
	}

}
