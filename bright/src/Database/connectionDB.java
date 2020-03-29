
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entity.stock;
import Entity.don;

import java.sql.ResultSet;
import java.sql.Statement;


public class connectionDB {

    public static PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String url = "jdbc:mysql://localhost:3306/refugees";
    Connection cnx; 
    String Login="root"; 
    String Password="" ; 
    static connectionDB con ; 
    
   public connectionDB() {
       try {
       
     cnx =DriverManager.getConnection(url,Login,Password);
     System.out.println("connected") ; 
       } catch (SQLException ex) {
                      System.out.println(ex.getMessage()) ; 

       }
       
    }
   public Connection getCnx() {
       return cnx ; 
   }
   public static connectionDB getInstance()  {
       if (con==null) {
           con=new connectionDB() ; 
       }
     return con ; 
       
   }
public static int save (stock  std){
    
    int st=0;
    
    try {
        String sql ="INSERT INTO stock (type )VALUES(?) ";
        Connection con=connectionDB.getInstance().getCnx();
        PreparedStatement stat;
        stat= con.prepareStatement(sql);
        stat.setString(1,std.getType());
        st= stat.executeUpdate();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    
   return st; 
    
}
public static int saved (don  std){
    
    int st=0;
    
    try {
        String sql ="INSERT INTO don (libelle,quantite,date,Stock_id )VALUES(?,?,?,?) ";
        Connection con=connectionDB.getInstance().getCnx();
        PreparedStatement stat;
        stat= con.prepareStatement(sql);
        stat.setString(1,std.getLibelle());
        stat.setInt(2,std.getQuantite());
        stat.setDate(3,std.getDate());        
        stat.setInt(4,std.getStock_id());


 st= stat.executeUpdate();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    
   return st; 
    
}
public static int update(stock std){
    int st=0;
    try{
        String  sql =" UPDATE stock SET type=? WHERE id=?";
       

     Connection con=connectionDB.getInstance().getCnx();
     PreparedStatement stat;
     stat= con.prepareStatement(sql);
     stat.setString(1,std.getType());
     stat.setInt(2,std.getId());
     st= stat.executeUpdate();
        con.close();
        }catch (SQLException e){
        e.printStackTrace();
    }
    return st;
    
}

     
public static int delete (int ide){
    int st=0;
    try{
     String  sql ="DELETE FROM stock WHERE id=?";
     Connection con=connectionDB.getInstance().getCnx();
     PreparedStatement stat;
     stat= con.prepareStatement(sql);
     stat.setInt(1,ide);
     st= stat.executeUpdate();
        con.close();  
        }catch (SQLException e){
        e.printStackTrace();
    }
    return st;
    
}

  
public static stock getStock (int ide){
    stock std=new stock();
    try{
        String sql ="SELECT *FROM stock WHERE id=?";
        
     Connection con=connectionDB.getInstance().getCnx();
     PreparedStatement stat;
     stat= con.prepareStatement(sql);
     stat.setInt(1,ide);
     ResultSet rst =stat.executeQuery();
     if (rst.next())
     {
         std.setId(rst.getInt(1));
         std.setType(rst.getString(2));
     }
        con.close();
         }catch (SQLException e){
        e.printStackTrace();
    }
        return std;
        
    }
public static don getDon (int ide){
    don std=new don();
    try{
        String sql ="SELECT *FROM don WHERE reference=?";
        
     Connection con=connectionDB.getInstance().getCnx();
     PreparedStatement stat;
     stat= con.prepareStatement(sql);
     stat.setInt(1,ide);
         

     ResultSet rst =stat.executeQuery();
     if (rst.next())
     {
         std.setReference(rst.getInt(1));
         std.setLibelle(rst.getString(2));
         std.setQuantite(rst.getInt(3));
         std.setDate(rst.getDate(4));
         std.setStock_id(rst.getInt(5));
     }
        con.close();
         }catch (SQLException e){
        e.printStackTrace();
    }
        return std;
        
    }
}

