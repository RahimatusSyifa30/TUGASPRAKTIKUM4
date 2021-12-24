package Model07276;

import Entity07276.MahasiswaEntity;
import Controller07276.Koneksi07276;
import java.sql.*;
import java.util.ArrayList;

 public class KursusModel07276 {   
     private String sql;
     Connection conn = Koneksi07276.getconnection();
     
    public ArrayList<MahasiswaEntity> getMahasiswa(){ 
        ArrayList<MahasiswaEntity> arraylistMahasiswa = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM mahasiswa";
            ResultSet rs= stat.executeQuery(sql);
            while(rs.next()) {
                MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
                mahasiswaEntity.setId(rs.getInt("id"));
                mahasiswaEntity.setNama(rs.getString("nama"));
                mahasiswaEntity.setNpm(rs.getString("npm"));
                mahasiswaEntity.setPassword(rs.getString("password"));
                mahasiswaEntity.setNoTelp(rs.getString("noTelp"));
                mahasiswaEntity.setStatus(rs.getInt("status"));
                arraylistMahasiswa.add(mahasiswaEntity);}
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistMahasiswa; 
    }
    
    public ArrayList<MahasiswaEntity> getMahasiswa(int id){
        ArrayList<MahasiswaEntity> arraylistMahasiswa = new ArrayList<>();
        try {
            sql = "SELECT * FROM mahasiswa WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
                
                mahasiswaEntity.setId(rs.getInt("id"));
                mahasiswaEntity.setNama(rs.getString("nama"));
                mahasiswaEntity.setNpm(rs.getString("npm"));
                mahasiswaEntity.setPassword(rs.getString("password"));
                mahasiswaEntity.setNoTelp(rs.getString("noTelp"));
                mahasiswaEntity.setStatus(rs.getInt("status"));
                arraylistMahasiswa.add(mahasiswaEntity);}
        }catch (SQLException e) {
            e.printStackTrace();
        }return arraylistMahasiswa;
    }
    
    public void createData(MahasiswaEntity MahasiswaEntity) {
        try {
            sql = "INSERT INTO mahasiswa (nama,npm, password, noTelp) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, MahasiswaEntity.getNama());
            stat.setString(2, MahasiswaEntity.getNpm());
            stat.setString(3, MahasiswaEntity.getPassword());
            stat.setString(4, MahasiswaEntity.getNoTelp());
            
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    
   
    
    public void deleteMahasiswa(int id){
        try{
            sql = "DELETE FROM mahasiswa WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL HAPUS");
            e.printStackTrace();
        }
    }
   
    
    public int cekVerif(int id){
        int cek = 0;
        try {
            sql = "SELECT * FROM mahasiswa WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("status");
            } else {
                cek = 0;
            }
        } catch (Exception e){
            System.out.println("GAGAL HAPUS");
            e.printStackTrace();
        } return cek;
    }
    public void verifMahasiswa(int id){
        try{
        sql = "update mahasiswa SET status = 1 WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL HAPUS");
            e.printStackTrace();
        }
    }
     public void updateNama(String nama, int id){
        try{
            sql = "update mahasiswa SET nama =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL UPDATE NAMA!!!");
            e.printStackTrace();
        }
    }
      public void updateNpm(String npm, int id){
        try{
            sql = "update mahasiswa SET npm =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL UPDATE NPM!!!");
            e.printStackTrace();
        }
    }
       public void updatePassword(String password, int id){
        try{
            sql = "update mahasiswa SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL UPDATE PASSWORD!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "update mahasiswa SET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL update NoTelp!!!");
            e.printStackTrace();
        }
    }
 }

