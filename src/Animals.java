
 

class Animals {
  /**
   * The animal belongs to a specie.
   */
private String name;
	private int IdAnimal;
  private String specie;
  private int sexe;

  private String numberBirthday;

  public Animals(String specie, String birthday) {
    // Bouml preserved body begin 00020D83
	  this.specie = specie;
	  this.numberBirthday = birthday;
    // Bouml preserved body end 00020D83
  }
  
  public Animals(int id, String nameAnimal) {
	    // Bouml preserved body begin 00020D83
		  this.IdAnimal = id;
		  this.name = nameAnimal;
	    // Bouml preserved body end 00020D83
	  }
  
  public Animals(int sexe, String nameAnimal, String nameSpecies, String birthday) {
	    // Bouml preserved body begin 00020D83
		  this.sexe=sexe;
	  	  this.name = nameAnimal;
		  this.specie = nameSpecies;
		  this.numberBirthday=birthday;
	    // Bouml preserved body end 00020D83
	  }

  public String getSpecie() {
    // Bouml preserved body begin 00022C83
	  return this.specie;
    // Bouml preserved body end 00022C83
  }

  public String getNumberBirthday() {
    // Bouml preserved body begin 00022D03
	  return this.numberBirthday;
    // Bouml preserved body end 00022D03
  }
  
  public int getSexe() {
	    // Bouml preserved body begin 00022D03
		  return this.sexe;
	    // Bouml preserved body end 00022D03
	  }

  public void setSpecie(String new_Specie) {
    // Bouml preserved body begin 00022D83
	  this.specie = new_Specie;
    // Bouml preserved body end 00022D83
  }

  public void setNumberBirthday(String new_NumberBirthday) {
    // Bouml preserved body begin 00022E03
	  this.numberBirthday = new_NumberBirthday;
    // Bouml preserved body end 00022E03
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getIdAnimal() {
	return IdAnimal;
}

public void setIdAnimal(int idAnimal) {
	IdAnimal = idAnimal;
}

}
