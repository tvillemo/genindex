


class Analysis {
	/**
	 * This attribute is TRUE if the analysis has been validated and FALSE if it has not.
	 */
	private boolean validate = false;

	/**
	 * This attribute contains the different results of the analysis.
	 */
	private int report;

	private int ID;

	private Users secondReading;

	private Users firstReading;

	private Date dateAnalysis;

	private Types_analysis typeAnalysis;

	private Integer IDMother;

	private Integer IDFather;
	
	private String Statut; 
	
	private String result1;
	
	private String result2;

	/**
	 * constructor of analysis
	 */
	public Analysis(int ID, Types_analysis ta, Date date,Integer IDFather,Integer IDMother,String statut) {
		// Bouml preserved body begin 00040602
		this.ID=ID;
		typeAnalysis=ta;
		dateAnalysis=date;
		this.Statut=statut;
		try{
			this.IDFather=IDFather.intValue();

		}
		catch(ClassCastException e){
			this.IDFather=null;
		}
		try{
			this.IDMother=IDMother.intValue();
		}
		catch(ClassCastException e){
			this.IDMother=null;
		}

		// Bouml preserved body end 00040602
	}

	public void generateReport() {
		// Bouml preserved body begin 0002C102
		dateAnalysis.printDate();
		System.out.print(typeAnalysis.getType());
		System.out.println(ID);
		System.out.print("first reading :");
		if(firstReading == null)
		{
			System.out.println("not done");
		}
		else
		{
			System.out.print(firstReading.getFirstName()+" ");
			System.out.println(firstReading.getLastName());
		}
		System.out.print("second reading :");
		if(secondReading == null)
		{
			System.out.println("not done");
		}
		else
		{
			System.out.print(secondReading.getFirstName()+" ");
			System.out.println(secondReading.getLastName());
			System.out.print("validate : ");
			System.out.println(validate);
			System.out.println(report);
		}
		System.out.print(typeAnalysis.getPrice());
		System.out.println("?");
		// Bouml preserved body end 0002C102
	}

	/**
	 * name of the scientist who validate first reading
	 */
	public void firstReading(Users user) {
		// Bouml preserved body begin 00040902
		firstReading=user;
		// Bouml preserved body end 00040902
	}

	/**
	 * name of the scientist who validate the second reading
	 */
	public void secondReading(Users user, boolean validate, int com) {
		// Bouml preserved body begin 00040982
		if(firstReading!=null)
		{
			secondReading = user;
			report = com;
			validation(validate);
		}
		else
		{
			System.out.println("first reading not done");
		}
		// Bouml preserved body end 00040982
	}

	/**
	 * accessor to ID
	 */
	public int getID() {
		// Bouml preserved body begin 00040682
		//System.out.println(ID);
		return ID;
		// Bouml preserved body end 00040682
	}

	/**
	 * change ID
	 */
	public void setID(int ID) {
		// Bouml preserved body begin 00040A02
		this.ID=ID;
		// Bouml preserved body end 00040A02
	}

	/**
	 * to validated the analysis
	 */
	private void validation(boolean validate) {
		// Bouml preserved body begin 00040702
		this.validate=validate;
		// Bouml preserved body end 00040702
	}

	public Types_analysis getTypeAnalysis() {
		// Bouml preserved body begin 00043302
		return this.typeAnalysis;
		// Bouml preserved body end 00043302
	}

	/**
	 * get the first reader
	 */
	public Users getFirstReader() {
		// Bouml preserved body begin 000239C5
		return firstReading;
		// Bouml preserved body end 000239C5
	}

	/**
	 * get the second reader
	 */
	public Users getSecondReader() {
		// Bouml preserved body begin 00023A45
		return secondReading;
		// Bouml preserved body end 00023A45
	}

	public boolean getValidate() {
		// Bouml preserved body begin 00023AC5
		return validate;
		// Bouml preserved body end 00023AC5
	}

	public int getReport() {
		// Bouml preserved body begin 00023B45
		return report;
		// Bouml preserved body end 00023B45
	}

	public int getIDMother() {
		return IDMother;
	}

	public void setIDMother(int iDMother) {
		IDMother = iDMother;
	}

	public int getIDFather() {
		return IDFather;
	}

	public void setIDFather(int iDFather) {
		IDFather = iDFather;
	}

	public String getStatut() {
		return Statut;
	}

	public void setStatut(String statut) {
		Statut = statut;
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

}
