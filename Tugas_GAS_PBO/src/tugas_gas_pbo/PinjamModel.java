/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gilym
 */
public class PinjamModel {
           static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public PinjamModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
          public String[][] readPinjam(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4

            String query = "select peminjaman.No_Pinjam,anggota.Nama,buku.Judul, peminjaman.Tanggal_Pinjam from peminjaman INNER JOIN anggota on peminjaman.NIM = anggota.NIM INNER JOIN buku on peminjaman.Id_Buku= buku.Id_Buku ORDER BY No_Pinjam";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("No_Pinjam"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tanggal_Pinjam");
               
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
          
           public void insertData( String NIM, String Id_Buku, String Tanggal ){
        int jmlData=0;
        try { 
            String query ;
            statement = (Statement) koneksi.createStatement();
            int temp = 0;
            query = "INSERT INTO peminjaman VALUES(default,'"+NIM+"','"+Id_Buku+"','"+Tanggal+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
                
                String qry= "Select * from buku WHERE Id_Buku= '"+Id_Buku+"'";
                ResultSet resultSet = statement.executeQuery(qry);
                
          while (resultSet.next()){
               temp =resultSet.getInt("Jumlah");
              
            }
          temp--;
            System.out.println(temp);
          
          qry="UPDATE buku SET Jumlah='" + temp + "'WHERE Id_Buku= '"+Id_Buku+"'" ;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(qry); //execute querynya
                
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
       
       
    }
           
                 public void update(String Id_Pinjam,String NIM, String Id_Buku, String Tanggal){
        int jmlData=0;
        try {
            String query = "Select * from peminjaman WHERE No_Pinjam= '"+Id_Pinjam+"'" ;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }
            System.out.println(jmlData );

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE peminjaman SET  NIM = '"+NIM+"' ,Id_Buku='" + Id_Buku + "' , Tanggal_Pinjam='" + Tanggal + "' WHERE No_Pinjam= '"+Id_Pinjam+"'" ;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
              
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
                 
    public String[][] cariNIM(String NIM){
        try{
            int jmlData = 0;

            String query = "Select * from peminjaman WHERE NIM LIKE '%" + NIM + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][4]; //baris, kolom nya ada 3


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                
                 query = "select peminjaman.No_Pinjam,anggota.Nama,buku.Judul, peminjaman.Tanggal_Pinjam from peminjaman INNER JOIN anggota on peminjaman.NIM = anggota.NIM INNER JOIN buku on peminjaman.Id_Buku= buku.Id_Buku  WHERE anggota.NIM LIKE '%" + NIM + "%'";
            
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                  
                data[jmlData][0] = resultSet.getString("No_Pinjam"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tanggal_Pinjam");
               
                jmlData++;
                }

            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] sortNama(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4

            String query = "select peminjaman.No_Pinjam,anggota.Nama,buku.Judul, peminjaman.Tanggal_Pinjam from peminjaman INNER JOIN anggota on peminjaman.NIM = anggota.NIM INNER JOIN buku on peminjaman.Id_Buku= buku.Id_Buku  ORDER BY anggota.Nama";
            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
              data[jmlData][0] = resultSet.getString("No_Pinjam"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tanggal_Pinjam");
               
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
        public String[][] sortJudul(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4

            String query = "select peminjaman.No_Pinjam,anggota.Nama,buku.Judul, peminjaman.Tanggal_Pinjam from peminjaman INNER JOIN anggota on peminjaman.NIM = anggota.NIM INNER JOIN buku on peminjaman.Id_Buku= buku.Id_Buku  ORDER BY buku.Judul";
            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
              data[jmlData][0] = resultSet.getString("No_Pinjam"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tanggal_Pinjam");
               
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
            public String[][] sortTanggal(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4

            String query = "select peminjaman.No_Pinjam,anggota.Nama,buku.Judul, peminjaman.Tanggal_Pinjam from peminjaman INNER JOIN anggota on peminjaman.NIM = anggota.NIM INNER JOIN buku on peminjaman.Id_Buku= buku.Id_Buku  ORDER BY peminjaman.Tanggal_Pinjam";
            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
              data[jmlData][0] = resultSet.getString("No_Pinjam"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tanggal_Pinjam");
               
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
            
                         public void delete (String Id) {
        try{int temp=0;
        String id="";
            String qry="Select * from peminjaman WHERE No_pinjam = '"+Id+"' ";
           ResultSet resultSet = statement.executeQuery(qry);
            
            while (resultSet.next()){
               id =resultSet.getString("Id_Buku");
              
            }
            System.out.println(id);
           String qry1="Select * from buku WHERE Id_Buku = '"+id+"' ";
            
              resultSet = statement.executeQuery(qry1);
                while (resultSet.next()){
               temp =resultSet.getInt("Jumlah");
              
            }
                
             temp++;
             System.out.println(temp);
              qry="UPDATE buku SET Jumlah='" + temp + "'WHERE Id_Buku= '"+id+"'" ;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(qry); //execute querynya
            
            
            
            
            String query = "DELETE FROM peminjaman WHERE No_pinjam = '"+Id+"'";
             statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
          
               public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from peminjaman";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
}

