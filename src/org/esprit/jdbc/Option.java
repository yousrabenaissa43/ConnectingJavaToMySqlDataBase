package org.esprit.jdbc;

public class Option {  
	
	private int no; 
	private String nom; 
	public int getNo() {   return no;  }  
	public void setNo(int no) {   this.no = no;  } 
	public String getNom() {   return nom;  }
	public void setNom(String nom)
	{   this.nom = nom;  }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Option other = (Option) obj;
		if (no != other.no)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Option [no=" + no + ", nom=" + nom + "]";
	} }   