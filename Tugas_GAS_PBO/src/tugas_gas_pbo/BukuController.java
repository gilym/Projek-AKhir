/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class BukuController {
    BukuModel bukumodel;
    BukuView bukuview;

    public BukuController(BukuModel bukumodel, BukuView bukuView) {
        this.bukumodel = bukumodel;
        this.bukuview = bukuView;
        
             if (bukumodel.getBanyakData()!=0) {
            String dataKontak[][] = bukumodel.readPerpus();
            bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
             
              bukuview.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(bukuview.tfId_Buku.getText().equals("") || bukuview.tfJudul.getText().equals("")|| bukuview.tfPengarang.getText().equals("")|| bukuview.tfTahun_Terbit.getText().equals("")|| bukuview.tfJumlah.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                       String Id_Buku = bukuview.getId();
                String Judul = bukuview.getJudul();
                String Pengarang = bukuview.getPengarang();
                String Tahun = bukuview.getTahun();
                String Jumlah = bukuview.getJumlah();
                bukumodel.insertData(Id_Buku, Judul, Pengarang, Tahun,Jumlah);

                String dataperpus[][] = bukumodel.readPerpus();
                bukuview.tabel.setModel((new JTable(dataperpus, bukuview.namaKolom)).getModel());
                }
             
            }
        });
              
                 bukuview.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(bukuview.tfId_Buku.getText().equals("") || bukuview.tfJudul.getText().equals("")|| bukuview.tfPengarang.getText().equals("")|| bukuview.tfTahun_Terbit.getText().equals("")|| bukuview.tfJumlah.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                    String Id_Buku = bukuview.getId();
                String Judul = bukuview.getJudul();
                String Pengarang = bukuview.getPengarang();
                String Tahun = bukuview.getTahun();
                String Jumlah = bukuview.getJumlah();
                 bukumodel.update(Id_Buku, Judul, Pengarang, Tahun,Jumlah);

              String dataperpus[][] = bukumodel.readPerpus();
                bukuview.tabel.setModel((new JTable(dataperpus, bukuview.namaKolom)).getModel());
                }
               
            }
        });
                 
                    bukuview.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = bukuview.getCariJudul();

                if (Judul.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataKontak[][] = bukumodel.cariJudul(Judul);
                    bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
                }

            }
        });
                    
                     bukuview.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = bukumodel.readPerpus();
                bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
            }
        });

             bukuview.btnJudul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = bukumodel.Sort("Judul");
                bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
            }
        });
             
             bukuview.btnPengarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = bukumodel.Sort("Pengarang");
                bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
            }
        });        

             
             bukuview.btnTahun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = bukumodel.Sort("Tahun");
                bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
            }
        });
             
             bukuview.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 MenuView menuView = new MenuView();
                    new MenuController(menuView);
                    bukuview.dispose();
            }
        });
             
       bukuview.btnJumlah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = bukumodel.Sort("Jumlah");
                bukuview.tabel.setModel((new JTable(dataKontak, bukuview.namaKolom)).getModel());
            }
        });
       
            bukuview.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bukuview.tfId_Buku.setText(null);
                bukuview.tfJudul.setText(null);
                bukuview.tfPengarang.setText(null);
                bukuview.tfTahun_Terbit.setText(null);
                bukuview.tfJumlah.setText(null);
            }
        });
       
       
              bukuview.tabel.addMouseListener(new MouseAdapter() {
                                              @Override
     public void mouseClicked(MouseEvent e) {
          super.mousePressed(e);
          int baris = bukuview.tabel.getSelectedRow();
          int kolom = bukuview.tabel.getSelectedColumn(); // ga kepake sekarang

          String id_buku = bukuview.tabel.getValueAt(baris, 0).toString();
          String judul= bukuview.tabel.getValueAt(baris,1 ).toString();
          String pengarang = bukuview.tabel.getValueAt(baris,2 ).toString();
           String tahun = bukuview.tabel.getValueAt(baris,3 ).toString();
           String jumlah = bukuview.tabel.getValueAt(baris,4 ).toString();

        

        String[] options = {"Delete","Update"};
        
        int input = JOptionPane.showOptionDialog(null, "Apa anda ingin menghapus Buku : " + judul+ "? atau Update Data ?", "Pilih Opsi...",
                
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
          if (input == 0) {
              bukumodel.delete(id_buku);
              String dataKontak[][] = bukumodel.readPerpus();
              bukuview.tabel.setModel(new JTable(dataKontak, bukuview.namaKolom).getModel());
          } else {
               bukuview.tfId_Buku.setText(id_buku);
              bukuview.tfJudul.setText(judul);
              bukuview.tfPengarang.setText(pengarang);
              bukuview.tfTahun_Terbit.setText(tahun);
               bukuview.tfJumlah.setText(jumlah);
          }
      }
  }
        );
               
               
               
    }
    
}
