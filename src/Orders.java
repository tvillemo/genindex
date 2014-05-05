
 

import java.util.List;
import java.util.ArrayList;

class Orders {
  private static int countId = 1;

  private int idOrder;

  private Customers customer;

  /**
   * The priority level is expressed in days.
   */
  private int priorityLevel;

  /**
   * The number of samples for the order.
   */
  private int numberSamples;

  private List<Samples> samples;

  private Date dateDeadline;

  private Date dateOrder;

  private Invoice invoice;

  /**
   * TRUE if the invoice is paid, FALSE if not.
   * 
   */
  private boolean paid;

  /**
   * TRUE if the results are send. in this case, the analyse is finished, so the order is "stored" in the database.
   * FALSE if the analyse is still in progress. 
   */
  private boolean results_send;

  public Orders(int num_samples, Date date_order, Date date_deadline, int priority, Customers customer) {
    // Bouml preserved body begin 0001F402
	  this.samples = new ArrayList<Samples>();
	  this.numberSamples=num_samples;
	  this.dateOrder=date_order;
	  this.dateDeadline=date_deadline;
	  this.priorityLevel = priority;
	  this.customer=customer;
	  this.paid = false;
	  this.results_send=false;
	  this.idOrder=countId;
	  countId = countId +1;
    // Bouml preserved body end 0001F402
  }

  public int getId() {
    // Bouml preserved body begin 0002FA02
	  return this.idOrder;
    // Bouml preserved body end 0002FA02
  }

  public int getPriorityLevel() {
    // Bouml preserved body begin 00042A82
	  return(this.priorityLevel);
    // Bouml preserved body end 00042A82
  }

  public List<Samples> getSamples() {
    // Bouml preserved body begin 00042C82
	  return (this.samples);
    // Bouml preserved body end 00042C82
  }

  public Invoice getInvoice() {
    // Bouml preserved body begin 00043402
	  return this.invoice;
    // Bouml preserved body end 00043402
  }

  public boolean getPaid() {
    // Bouml preserved body begin 00042B02
	  return(this.paid);
    // Bouml preserved body end 00042B02
  }

  public boolean getResultSend() {
    // Bouml preserved body begin 00042B82
	  return(this.results_send);
    // Bouml preserved body end 00042B82
  }

  /**
   * A setter to change the priority level.
   */
  public void setPriorityLevel(int newP) {
    // Bouml preserved body begin 0001F682
	  this.priorityLevel=newP;
    // Bouml preserved body end 0001F682
  }

  public void setPaid(boolean paid) {
    // Bouml preserved body begin 00026582
	  this.paid=paid;
    // Bouml preserved body end 00026582
  }

  public void setResultsSend(boolean sent) {
    // Bouml preserved body begin 00026602
	  this.results_send=sent;
    // Bouml preserved body end 00026602
  }

  /**
   * This function is just a setter that permits to change the attribute "Paid" from FALSE to TRUE
   */
  public void payAnalyse() {
    // Bouml preserved body begin 0001F602
	  this.paid=true;
    // Bouml preserved body end 0001F602
  }

  /**
   * This function permits to attach a sample to its order.
   */
  public void addSample(Samples sample) {
    // Bouml preserved body begin 0002F882
	  this.samples.add(sample);
    // Bouml preserved body end 0002F882
  }

  /**
   * This function permits to print the informations of this order.
   */
  public void printOrder() {
    // Bouml preserved body begin 00024902
	  System.out.print("Order n ?");
	  System.out.println(this.idOrder);
	  
	  System.out.print("Customer : ");
	  System.out.println(this.customer.getLastName());
	  
	  System.out.print("DeadLine : ");
	  this.dateDeadline.printDate();
	  
	  System.out.print("Number of samples : ");
	  System.out.println(this.numberSamples);
	  
	 /* for (int i=0; i<this.numberSamples; i++){
		  System.out.println(this.samples.get(i));
	  }*/
	  
	  System.out.println("");
	  
    // Bouml preserved body end 00024902
  }

  /**
   * This function permits to create the invoice attached to this order.
   */
  public void editInvoice() {
    // Bouml preserved body begin 0002FA82
	  
	 double totalPrice=0;
	 for (int i=0; i<samples.size(); i++){
		 totalPrice = totalPrice + samples.get(i).getAnalysis().getTypeAnalysis().getPrice();
	 }
	 
	 this.invoice = new Invoice(totalPrice, this.numberSamples, this.idOrder);
    // Bouml preserved body end 0002FA82
  }

  /**
   * This function permits to list all the samples related to this order.
   */
  public void listSamples() {
    // Bouml preserved body begin 00042C02
	  System.out.print("There (is) are ");
	  System.out.print(this.samples.size());
	  System.out.println(" sample(s) for this order : ");
	  for (int i=0; i<this.samples.size(); i++){
		System.out.println(this.samples.get(i).getId());  
	  }
    // Bouml preserved body end 00042C02
  }

}
