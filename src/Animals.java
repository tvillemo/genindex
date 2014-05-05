
 

class Animals {
  /**
   * The animal belongs to a specie.
   */
  private String specie;

  private String numberBirthday;

  public Animals(String specie, String birthday) {
    // Bouml preserved body begin 00020D83
	  this.specie = specie;
	  this.numberBirthday = birthday;
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

}
