import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
	
	ArrayList<MenuItem> compProduct = new ArrayList<MenuItem>();

	public CompositeProduct(String s, int p) {
		super(s, p);
	}
}
