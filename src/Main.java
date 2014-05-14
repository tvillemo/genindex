import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();

		
		Customers c = d.searchCustomerID(5);
		
		System.out.println(c.getFirstName());
		System.out.println(c.getLastName());
		System.out.println(c.getAdressClient().getNumber());
		d.close();

	}

}
