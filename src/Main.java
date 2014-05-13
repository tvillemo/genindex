import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();

		Customers c = new Customers(null, 0, null, null, 0);
		c.setName("Louna", "Taylor");
		c.setPhone("+33148963214");
		c.setAdressClient(new Adress(15,"avenue Pelletier",17000,"Cognac"));

		ArrayList<Customers> x =  d.searchCustomersByName("Sansa", "Clement");
		System.out.println(x.size());
		d.close();

	}

}