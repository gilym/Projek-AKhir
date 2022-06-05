/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static tugas_gas_pbo.PinjamModel.DB_URL;
import static tugas_gas_pbo.PinjamModel.JDBC_DRIVER;
import static tugas_gas_pbo.PinjamModel.PASS;
import static tugas_gas_pbo.PinjamModel.USER;
public class PinjamController {
    PinjamView pv;
    PinjamModel pm;
    
              static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public PinjamController(PinjamView pv, PinjamModel pm) {
        this.pv = pv;
        this.pm = pm;
         try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        
                     if (pm.getBanyakData()!=0) {
            String dataKontak[][] = pm.readPinjam();
            pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
                     
             pv.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pv.tfId_Buku.getText().equals("") || pv.tfNIM.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                       
                String NIM = pv.getNim();
                String Id_Buku = pv.getId();
                String tgl = pv.getTanggal();
                
                pm.insertData(NIM,Id_Buku,tgl);

                String dataperpus[][] = pm.readPinjam();
                pv.tabel.setModel((new JTable(dataperpus, pv.namaKolom)).getModel());
                }
             
            }
        });
             
         pv.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pv.tfId_Buku.getText().equals("") || pv.tfNIM.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                    String Id_Pinjam = pv.getIdPinjam();
               String NIM = pv.getNim();
                String Id_Buku = pv.getId();
                String tgl = pv.getTanggal();
                
                 pm.update(Id_Pinjam,NIM,Id_Buku,tgl);

              String dataperpus[][] = pm.readPinjam();
                pv.tabel.setModel((new JTable(dataperpus, pv.namaKolom)).getModel());
                }
               
            }
        });
                              pv.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = pm.readPinjam();
                pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
            }
        });
                 pv.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 MenuView menuView = new MenuView();
                    new MenuController(menuView);
                    pv.dispose();
            }
        });
                 
         pv.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NIM = pv.getCariNIM();

                if (NIM.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataKontak[][] = pm.cariNIM(NIM);
                    pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
                }

            }
        });
         
          pv.btnJudul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = pm.sortJudul();
                pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
            }
        });
          
           pv.btnNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = pm.sortNama();
                pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
            }
        });
            pv.btnTgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = pm.sortTanggal();
                pv.tabel.setModel((new JTable(dataKontak, pv.namaKolom)).getModel());
            }
        });
            
            
            pv.tabel.addMouseListener(new MouseAdapter() {
                                              @Override
     public void mouseClicked(MouseEvent e) {
          super.mousePressed(e);
          int baris = pv.tabel.getSelectedRow();
          int kolom = pv.tabel.getSelectedColumn(); // ga kepake sekarang

         String id = pv.tabel.getValueAt(baris, 0).toString();
          String nama= pv.tabel.getValueAt(baris,1 ).toString();
          
            
              String NIM="",Id_Buku="",tgl="";
                  try{
                   String query="Select * From peminjaman  WHERE No_Pinjam = '"+id+"'";
                   statement = (Statement) koneksi.createStatement();
                      ResultSet resultSet = statement.executeQuery(query);
           
            
              while (resultSet.next()){
               NIM=resultSet.getString("NIM");
               Id_Buku=resultSet.getString("Id_Buku");
               tgl=resultSet.getString("Tanggal_Pinjam");
              
            }
              
            
                  }
                 catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
                     System.out.println("gagal");
        }
            
          
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date temp = null;
String dateInString = tgl;
                                                  try {
                                                      Date date = formatter.parse(dateInString);temp=date;
                                                  } catch (ParseException ex) {
                                                      Logger.getLogger(PinjamController.class.getName()).log(Level.SEVERE, null, ex);
                                                  }

          

           String[] options = {"Delete","Update"};
        
        int input = JOptionPane.showOptionDialog(null, "Apa anda ingin menghapus Anggota : " + nama+ "? atau Update Data ?", "Pilih Opsi...",
                
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        
          if (input == 0) {
              pm.delete(id);
              String dataKontak[][] = pm.readPinjam();
              pv.tabel.setModel(new JTable(dataKontak, pv.namaKolom).getModel());
              
              
          } else {
              JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
              pv.tfId.setText(id);
              pv.tfId_Buku.setText(Id_Buku);
              pv.tfNIM.setText(NIM);
              pv.date.setDate(temp);
          }
      }
  }
        );
            
                     pv.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pv.tfId_Buku.setText(null);
                pv.tfNIM.setText(null);
                pv.tfId.setText(null);
               
            }
        });
            
            
    }
    
    
}
