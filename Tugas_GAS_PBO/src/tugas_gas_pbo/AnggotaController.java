/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class AnggotaController {
    AnggotaModel am;
    AnggotaView av;

    public AnggotaController(AnggotaModel am, AnggotaView av) {
        this.am = am;
        this.av = av;
        
        
                     if (am.getBanyakData()!=0) {
            String dataKontak[][] = am.readAnggota();
            av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
                     
             av.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(av.tfNIM.getText().equals("") || av.tfNama.getText().equals("")|| av.tfUmur.getText().equals("")|| av.tfEmail.getText().equals("")|| av.cmbJurusan.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                String NIM = av.getNim();
                String Nama = av.getNama();
                String Kelamin = av.getKelamin();
                String Jurusan = av.getJurusan();
                String Umur = av.getUmur();
                String Email=av.getEmail();
                String Hp= av.getNoHp();
                am.insertData(NIM, Nama, Kelamin, Jurusan,Umur,Email,Hp);

                String dataperpus[][] = am.readAnggota();
                av.tabel.setModel((new JTable(dataperpus, av.namaKolom)).getModel());
                }
             
            }
        });
             
             av.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 if(av.tfNIM.getText().equals("") || av.tfNama.getText().equals("")|| av.tfUmur.getText().equals("")|| av.tfEmail.getText().equals("")|| av.cmbJurusan.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                 String NIM = av.getNim();
                String Nama = av.getNama();
                String Kelamin = av.getKelamin();
                String Jurusan = av.getJurusan();
                String Umur = av.getUmur();
                String Email=av.getEmail();
                String Hp= av.getNoHp();
                am.updateAnggota(NIM, Nama, Kelamin, Jurusan,Umur,Email,Hp);

                String dataperpus[][] = am.readAnggota();
                av.tabel.setModel((new JTable(dataperpus, av.namaKolom)).getModel());
                }
               
            }
        });
             
             av.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = av.GetCari();

                if (Judul.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataKontak[][] = am.cariNama(Judul);
                    av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
                }

            }
        });
             
        av.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = am.readAnggota();
                av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
            }
        });
        
         av.btnNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                
                String dataKontak[][] = am.sort("Nama");
                av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
            }
        });
         
            av.btnKelamin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                
                String dataKontak[][] = am.sort("Jenis_Kelamin");
                av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
            }
        });
                  
             av.btnJurusan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                
                String dataKontak[][] = am.sort("Jurusan");
                av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
            }
        });
             
         av.btnUmur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                
                String dataKontak[][] = am.sort("Umur");
                av.tabel.setModel((new JTable(dataKontak, av.namaKolom)).getModel());
            }
        });

             
                av.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 MenuView menuView = new MenuView();
                    new MenuController(menuView);
                    av.dispose();
            }
        });
                          
       av.tabel.addMouseListener(new MouseAdapter() {
                                              @Override
     public void mouseClicked(MouseEvent e) {
          super.mousePressed(e);
          int baris = av.tabel.getSelectedRow();
          int kolom = av.tabel.getSelectedColumn(); // ga kepake sekarang

          String NIM = av.tabel.getValueAt(baris, 0).toString();
          String nama= av.tabel.getValueAt(baris,1 ).toString();
          String kelamin = av.tabel.getValueAt(baris,2 ).toString();
           String jurusan = av.tabel.getValueAt(baris,3 ).toString();
           String umur = av.tabel.getValueAt(baris,4 ).toString();
            String email = av.tabel.getValueAt(baris,5 ).toString();
            String hp = av.tabel.getValueAt(baris,6 ).toString();

        

        String[] options = {"Delete","Update"};
        
        int input = JOptionPane.showOptionDialog(null, "Apa anda ingin menghapus Anggota : " + nama+ "? atau Update Data ?", "Pilih Opsi...",
                
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
          if (input == 0) {
              am.delete(NIM);
              String dataKontak[][] = am.readAnggota();
              av.tabel.setModel(new JTable(dataKontak, av.namaKolom).getModel());
          } else {
               av.tfNIM.setText(NIM);
              av.tfNama.setText(nama);
              av.tfUmur.setText(umur);
              av.tfEmail.setText(email);
               av.tfHp.setText(hp);
               av.cmbJurusan.setSelectedItem(jurusan);
               if(kelamin.equals("Laki-Laki")){
           av.rbPria.setSelected(true);
        }else if(kelamin.equals("Perempuan")){
            av.rbWanita.setSelected(true);
        }
          }
      }
  }
        );
                        
   av.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                av.tfNIM.setText(null);
                av.tfNama.setText(null);
                av.tfUmur.setText(null);
                av.tfEmail.setText(null);
                av.tfHp.setText(null);
                av.cmbJurusan.setSelectedItem(null);

            }
        });
        
    }
    
}
