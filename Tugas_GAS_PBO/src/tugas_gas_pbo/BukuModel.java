
package tugas_gas_pbo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BukuModel {
    
       static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public BukuModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
      public String[][] readPerpus(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4

            String query = "Select * from buku order by Id_Buku";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Id_Buku"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Judul");
                data[jmlData][2] = resultSet.getString("Pengarang");
                data[jmlData][3] = resultSet.getString("Tahun");
                data[jmlData][4] = resultSet.getString("Jumlah");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
      public void insertData(String Id_Buku, String Judul, String Pengarang, String Tahun ,String Jumlah){
        int jmlData=0;
        try { statement = (Statement) koneksi.createStatement();
            String query = "Select * from buku WHERE Id_Buku= '"+Id_Buku+"'" ; // cek apakah data sudah ada
                     ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { // jika data dengan no hp tsb belum ada
                query = "INSERT INTO buku VALUES('"+Id_Buku+"','"+Judul+"','"+Pengarang+"','"+Tahun+"','"+Jumlah+"')";

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
      
      public void update(String Id_Buku, String Judul, String Pengarang, String Tahun ,String Jumlah){
        int jmlData=0;
        try {
            String query = "Select * from buku WHERE Id_Buku= '"+Id_Buku+"'" ;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE buku SET  Judul='" + Judul + "', Pengarang='" + Pengarang + "' , Tahun='" + Tahun + "' , Jumlah='" + Jumlah + "'WHERE Id_Buku= '"+Id_Buku+"'" ;
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
      
       public String[][] cariJudul(String Judul){
        try{
            int jmlData = 0;

            String query = "Select * from buku WHERE Judul LIKE '%" + Judul + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][5]; //baris, kolom nya ada 3


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from buku WHERE Judul LIKE '%" + Judul + "%'";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                  
                data[jmlData][0] = resultSet.getString("Id_Buku"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Judul");
                data[jmlData][2] = resultSet.getString("Pengarang");
                data[jmlData][3] = resultSet.getString("Tahun");
                data[jmlData][4] = resultSet.getString("Jumlah");
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
       
             public String[][] Sort(String sort){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4

            String query = "Select * from buku Order by "+sort;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Id_Buku"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Judul");
                data[jmlData][2] = resultSet.getString("Pengarang");
                data[jmlData][3] = resultSet.getString("Tahun");
                data[jmlData][4] = resultSet.getString("Jumlah");
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
            String query = "Select * from buku";
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
      
          public void delete (String Id_Buku) {
        try{
            String query = "DELETE FROM buku WHERE Id_Buku = '"+Id_Buku+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
