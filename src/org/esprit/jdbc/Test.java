package org.esprit.jdbc;

import java.sql.Connection; import java.sql.DriverManager; 
import java.sql.ResultSet; import java.sql.SQLException;
import java.sql.Statement;  
public class Test {  
 static Connection connection=null;
 static Statement st=null;    
 
 
 
 //inserting an "etudiant"
 public static void enregistrerEtudiant(Etudiant etd){  
	 String nom=etd.getNom();   
	 String prenom=etd.getPrenom();  
     Option opt=etd.getOption();   
     int noOption=opt.getNo();      
 
     String sql="INSERT INTO esprit.etudiant(nom_etudiant,prenom_etudiant,no_option)" +  
     "VALUES('"+nom+"','"+prenom+"',"+noOption+")";   
 
 try {      st=connection.createStatement();
 st.executeUpdate(sql);  
 } 
 catch (SQLException e1) {  
	     e1.printStackTrace();   }  
 } 
 
 // updating option
 
 public static void enregistrerOption(Option opt){  
		 String nom=opt.getNom();   
		 String sql="INSERT INTO esprit.option(nom_option)VALUES('"+nom+"')";
		 try {      st=connection.createStatement();  
		 st.executeUpdate(sql);  
		 }
		 catch (SQLException e1) {   
			 e1.printStackTrace();  } 
}   

 //deleting option 
 
public static void supprimerOption(Option opt){   
		 String sql="DELETE FROM esprit.option WHERE nom_option='"+opt.getNom()+"'"; 
		 try {      st=connection.createStatement();    st.executeUpdate(sql);   } 
		 catch (SQLException e1) {   
			 e1.printStackTrace();   } }

//deleting Etudiant 

	 public static void supprimerEtudiant(Etudiant opt){   
		 String sql="DELETE FROM esprit.etudiant WHERE nom_etudiant='"+opt.getNom()+"'"; 
		 try {      st=connection.createStatement();    st.executeUpdate(sql);   } 
		 catch (SQLException e1) {   
			 e1.printStackTrace();   }        } 
	 
	 
// get option from no_option 
	 
public static Option lireOption(int no){    
		 Option opt=new Option();     
		 
		 
		 String sql="SELECT * FROM esprit.option WHERE no_option='"+no+"'";  
		 
		 try {     ResultSet rs;  
		           st=connection.createStatement();  
		
		           rs=st.executeQuery(sql);   
		 
		 
		 while (rs.next()){    
			 opt.setNo(rs.getInt("no_option"));   
			 opt.setNom(rs.getString("nom_option"));    }       } 
		 catch (SQLException e1) {    
			 e1.printStackTrace();   }   
		 return opt;  }

//get option from nom 

public static Option lireOption(String  nom){    
		 Option opt=new Option();     
		 String sql="SELECT * FROM esprit.option WHERE nom_option='"+nom+"'";  
		 try {     ResultSet rs;    
		 
		 st=connection.createStatement();  
		 rs=st.executeQuery(sql);   
		 while (rs.next()){    
			 opt.setNo(rs.getInt("no_option"));   
			 opt.setNom(rs.getString("nom_option"));    }       } 
		 catch (SQLException e1) {    
			 e1.printStackTrace();   }   
		 return opt; } 


//main 

	 public static void main(String[] args) {  
		 System.out.println("Bonjour");    
		 try { 
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
			 System.out.println("Bonjour2");    

		 }
		 
		 catch (InstantiationException e) {  
			 e.printStackTrace();
			 }
		 catch (IllegalAccessException e) { 
				
				 e.printStackTrace();  }
		 catch (ClassNotFoundException e) { 
				  e.printStackTrace(); }
	
	 String url="jdbc:mysql://localhost:3306/esprit";  
	 
	 String login="root"; 
	 String mdp="root";  
	 
	 
	 try {  connection=DriverManager.getConnection(url,login,mdp); 
	 System.out.println("Connection reussie...");    
	 }
	 catch (SQLException ex)
	 {   System.out.println("Connexion echouee....");  
	 ex.printStackTrace(); 
	 }   
	 Option option=new Option();  
	 option.setNom("Italien"); 
	 Etudiant etudiant; 
	 etudiant=new Etudiant(); 
	 etudiant.setNom("Sassi");  
	 etudiant.setPrenom("Ridha");  
	enregistrerOption(option); 
	System.out.println("le Num�ro d'option= "+option.getNo());
	option= lireOption(option.getNom());
	System.out.println("Apr� appel � lireOption le Num�ro d'option= "+option.getNo());

	etudiant.setOption(option);

	 enregistrerEtudiant(etudiant);   
	 //supprimerOption(option);   
	// Option opt1=lireOption(1) ;  
	 
	// System.out.println(opt1);
	// supprimerEtudiant(etudiant);
	// supprimerOption(option); 
	 
	 
	 } 
	 }