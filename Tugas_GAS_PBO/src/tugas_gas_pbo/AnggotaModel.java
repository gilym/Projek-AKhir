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
public class AnggotaModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public AnggotaModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    
    public String[][] readAnggota(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][7]; //baris, kolom nya ada 4

            String query = "Select * from anggota";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("NIM"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Jenis_Kelamin");
                data[jmlData][3] = resultSet.getString("Jurusan");
                data[jmlData][4] = resultSet.getString("Umur");
                data[jmlData][5] = resultSet.getString("Email");
                data[jmlData][6] = resultSet.getString("No_Hp");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
          public void insertData(String NIM, String Nama, String Kelamin, String Jurusan ,String Umur, String Email, String Hp){
        int jmlData=0;
        try { statement = (Statement) koneksi.createStatement();
            String query = "Select * from anggota WHERE NIM= '"+NIM+"'" ; // cek apakah data sudah ada
                     ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { // jika data dengan no hp tsb belum ada
                query = "INSERT INTO anggota VALUES('"+NIM+"','"+Nama+"','"+Kelamin+"','"+Jurusan+"','"+Umur+"','"+Email+"','"+Hp+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
               public void updateAnggota(String NIM, String Nama, String Kelamin, String Jurusan ,String Umur, String Email, String Hp){
        int jmlData=0;
        try {
            String query = "Select * from anggota WHERE NIM= '"+NIM+"'" ;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE anggota SET  Nama='" + Nama + "', Jenis_Kelamin='" + Kelamin + "' , Jurusan='" + Jurusan + "' , Umur='" + Umur + "' , Email='" + Email + "' , No_HP='" + Hp + "' WHERE NIM= '"+NIM+"'" ;
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
               
    public String[][] cariNama(String Nama){
        try{
            int jmlData = 0;

            String query = "Select * from anggota WHERE Nama LIKE '%" + Nama + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][7]; //baris, kolom nya ada 3


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from anggota WHERE Nama LIKE '%" + Nama + "%'";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                  
                data[jmlData][0] = resultSet.getString("NIM"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Jenis_Kelamin");
                data[jmlData][3] = resultSet.getString("Jurusan");
                data[jmlData][4] = resultSet.getString("Umur");
                data[jmlData][5] = resultSet.getString("Email");
                data[jmlData][6] = resultSet.getString("No_Hp");
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
    
     public String[][] sort(String Sort){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][7]; //baris, kolom nya ada 4

            String query = "Select * from anggota Order by " +Sort ;
            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("NIM"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("Jenis_Kelamin");
                data[jmlData][3] = resultSet.getString("Jurusan");
                data[jmlData][4] = resultSet.getString("Umur");
                data[jmlData][5] = resultSet.getString("Email");
                data[jmlData][6] = resultSet.getString("No_Hp");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     
         public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from anggota";
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
         
       public void delete (String Nim) {
        try{
            String query = "DELETE FROM anggota WHERE NIM = '"+Nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
