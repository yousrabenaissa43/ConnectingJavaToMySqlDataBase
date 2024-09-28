package org.esprit.jdbc;

public class Etudiant {
	
	  private int no;   
	  private String nom;   
	  private String prenom;   
	  private Option option;    
	  public int getNo() {  return no; } 
	  public void setNo(int no) {  this.no = no; } 
	  public String getNom() {  return nom; }
	  public void setNom(String nom) {  this.nom = nom; } 
	  public String getPrenom() {  return prenom; }
	  public void setPrenom(String prenom) {  this.prenom = prenom; }
	  public Option getOption() {  return option; } 
	  public void setOption(Option option) {  this.option = option; }
	  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (no != other.no)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Etudiant [no=" + no + ", nom=" + nom + ", prenom=" + prenom + ", option=" + option + "]";
	}

}
