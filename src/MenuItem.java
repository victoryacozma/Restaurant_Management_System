
public abstract class MenuItem {
	String name;
	int price;
	
	public MenuItem(String s, int p) {
		name = s;
		price = p;
	}
	
	public MenuItem(String s) {
		name = s;
	}
}
