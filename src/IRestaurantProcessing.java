import java.awt.event.ActionListener;

public interface IRestaurantProcessing {

	void deleteMenuItemListener(ActionListener cal);

	void editMenuItemListener(ActionListener cal);

	void viewMenuItemListener(ActionListener cal);

	void addCreateItemListener(ActionListener cal);

	void addOrderListener(ActionListener cal);

	void computePriceListener(ActionListener cal);

	void createBillListener(ActionListener cal);

	void viewOrderListener(ActionListener cal);

}
