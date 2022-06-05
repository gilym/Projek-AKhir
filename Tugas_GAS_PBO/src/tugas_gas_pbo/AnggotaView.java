/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class AnggotaView extends JFrame{
    JLabel lNIM = new JLabel("NIM  ");
    JLabel lNama = new JLabel("Nama");
    JLabel lKelamin = new JLabel("Jenis Kelamin");
    JLabel lJurusan = new JLabel("Jurusan");
    JLabel lUmur = new JLabel("Umur");
    JLabel lEmail = new JLabel("Email");
    JLabel lHp = new JLabel("No HP");
    
    
    JLabel lCari = new JLabel("Cari Nama : ");
    JLabel lsort = new JLabel ("Sort By :");
    JLabel Input = new JLabel ("INPUT DATA");
    

    JTextField tfNIM = new JTextField();
    JTextField tfNama = new JTextField();
    
    JRadioButton rbPria = new JRadioButton("Laki-Laki");
    JRadioButton rbWanita = new JRadioButton("Perempuan");
    
    String []Jurusan={"Informatika","Sistem Informasi","Teknik Industri","D3 Teknik Kimia","Teknik Kimia"};
    JComboBox cmbJurusan = new JComboBox(Jurusan);
    
    JTextField tfUmur = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfHp = new JTextField();
    JTextField tfCari = new JTextField();
    

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnCari = new JButton("Search");
    JButton btnReset = new JButton("Refresh");
    JButton btnNama = new JButton("Nama");
    JButton btnKelamin = new JButton("Jenis-Kelamin");
    JButton btnJurusan = new JButton("Jurusan");
    JButton btnUmur = new JButton("Umur");
    JButton btnBack = new JButton ("Back");
     JButton btnClear = new JButton("Clear");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM", "Nama", "Jenis Kelamin", "Jurusan","Umur","Email","No Hp"};

    public AnggotaView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Menu Anggota");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
     
        setSize(1100,600);
        
        add(scrollPane);
        scrollPane.setBounds(400, 110, 650, 400);
        
        add(Input);
        Input.setBounds(150, 20, 150, 100);

        add(lsort);
        lsort.setBounds(470, 80, 90, 20);
        add(btnNama);
        btnNama.setBounds(530, 80, 75, 20);
         add(btnKelamin);
        btnKelamin.setBounds(615, 80, 140, 20);
         add(btnJurusan);
        btnJurusan.setBounds(760, 80, 100, 20);
         add(btnUmur);
        btnUmur.setBounds(870, 80, 75, 20);
        add(btnBack);
       btnBack.setBounds(10, 10, 90, 20);
        
       ButtonGroup grup = new ButtonGroup();
       grup.add(rbPria);
        grup.add(rbWanita);
       
        add(lNIM);
        lNIM.setBounds(30, 100, 90, 20);
        add(tfNIM);
        tfNIM.setBounds(110, 100, 200, 20);

        add(lNama);
        lNama.setBounds(30, 130, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 130, 200, 20);

        add(lKelamin);
        lKelamin.setBounds(30, 160, 90, 20);
        add(rbPria);
        rbPria.setBounds(125, 160, 90, 20);
        add(rbWanita);
        rbWanita.setBounds(215, 160, 90, 20);

        add(lJurusan);
        lJurusan.setBounds(30, 190, 90, 20);
        add(cmbJurusan);
       cmbJurusan.setBounds(110, 190, 200, 20);
        
        add(lUmur);
        lUmur.setBounds(30, 220, 90, 20);
        add(tfUmur);
        tfUmur.setBounds(110, 220, 200, 20);
        
        add(lEmail);
        lEmail.setBounds(30, 250, 90, 20);
        add(tfEmail);
        tfEmail.setBounds(110, 250, 200, 20);
        
        add(lHp);
        lHp.setBounds(30, 280, 90, 20);
        add(tfHp);
        tfHp.setBounds(110, 280, 200, 20);

        add(btnTambah);
        btnTambah.setBounds(70, 310, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(200, 310, 90, 20);
        
        add(btnClear);
        btnClear.setBounds(140, 340, 90, 20);

        add(lCari);
        lCari.setBounds(800, 5, 90, 20);

        add(tfCari);
        tfCari.setBounds(870, 5, 120, 20);

        add(btnCari);
        btnCari.setBounds(840, 35, 90, 20);

        add(btnReset);
        btnReset.setBounds(950, 35, 90, 20);
    }

    public String getNim(){
        return tfNIM.getText();
    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getKelamin(){
        String kelamin=null;
       
        if(rbPria.isSelected()){
            kelamin="Laki-Laki";
        }else if(rbWanita.isSelected()){
            kelamin = "Perempuan";
        }
            return kelamin;
    }

    public String getJurusan(){
       return cmbJurusan.getSelectedItem().toString();
  
    }
    public String getUmur(){
        return tfUmur.getText();
    }

    public String getEmail(){
        return tfEmail.getText();
    }
    public String getNoHp(){
        return tfHp.getText();
    }
    public String GetCari(){
        return tfCari.getText();
    }
}