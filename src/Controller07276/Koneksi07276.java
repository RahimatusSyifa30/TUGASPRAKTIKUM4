package Controller07276;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Koneksi07276 {
    
    public static Statement stmt = null;
    public static ResultSet rs;
    
    public static Connection getconnection(){
        
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";//memanggil driver
        String url = "jdbc:mysql://localhost:3306/db_verifkursus";
        String user = "root";//xampp
        String pass = "";
        
        try{
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            System.out.println("Berhasil Koneksi Database");
            
        }catch(Exception e){
            
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
            
        }
        return conn;
    }
    
}
