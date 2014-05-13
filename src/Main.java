import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		Customers c = new Customers(null, 0, null, null, 0);
		c.setName("jeje", "Peyro");
		c.setPhone("+33148963256");
		c.setAdressClient(new Adress(25,"rue Apero",26000,"Valence"));
		c.setPro(false);
		
		//System.out.println(d.IfCustomerExist(c));
		
		boolean pro = d.saveCustomer(c);
		
		System.out.println(pro);

		d.close();



	}

}