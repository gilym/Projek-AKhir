/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BukuView extends JFrame{
    JLabel lId_Buku = new JLabel("Id_Buku");
    JLabel lJudul = new JLabel("Judul");
    JLabel lPengarang = new JLabel("Pengarang");
    JLabel lTahun_Terbit = new JLabel("Tahun_Terbit");
    JLabel lJumlah = new JLabel("Jumlah");
    JLabel lCari = new JLabel("Cari Buku : ");
    JLabel lsort = new JLabel ("Sort By :");
    JLabel Input = new JLabel ("INPUT DATA");
    JPanel panel = new JPanel();
    

    JTextField tfId_Buku = new JTextField();
    JTextField tfJudul = new JTextField();
    JTextField tfPengarang = new JTextField();
    JTextField tfTahun_Terbit = new JTextField();
    JTextField tfJumlah = new JTextField();
    JTextField tfCari = new JTextField();
    

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnCari = new JButton("Search");
    JButton btnReset = new JButton("Refresh");
    JButton btnJudul = new JButton("Judul");
    JButton btnPengarang = new JButton("Pengarang");
    JButton btnTahun = new JButton("Tahun");
    JButton btnJumlah = new JButton("Jumlah");
    JButton btnBack = new JButton ("Back");
    JButton btnClear = new JButton("Clear");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Id Buku", "Judul", "Pengarang", "Tahun Terbit","Jumlah"};

    public BukuView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Kontak");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
       
     
        setSize(1100,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scrollPane);
        scrollPane.setBounds(470, 110, 550, 300);
        
        add(Input);
        Input.setBounds(150, 20, 150, 100);

        add(lsort);
        lsort.setBounds(470, 80, 90, 20);
        add(btnJudul);
        btnJudul.setBounds(530, 80, 75, 20);
         add(btnPengarang);
        btnPengarang.setBounds(615, 80, 110, 20);
         add(btnTahun);
        btnTahun.setBounds(740, 80, 75, 20);
         add(btnJumlah);
        btnJumlah.setBounds(825, 80, 75, 20);
        add(btnBack);
       btnBack.setBounds(10, 10, 90, 20);
        
        add(lId_Buku);
        lId_Buku.setBounds(30, 100, 90, 20);
        add(tfId_Buku);
        tfId_Buku.setBounds(110, 100, 200, 20);

        add(lJudul);
        lJudul.setBounds(30, 130, 90, 20);
        add(tfJudul);
        tfJudul.setBounds(110, 130, 200, 20);

        add(lPengarang);
        lPengarang.setBounds(30, 160, 90, 20);
        add(tfPengarang);
        tfPengarang.setBounds(110, 160, 200, 20);

        add(lTahun_Terbit);
        lTahun_Terbit.setBounds(30, 190, 90, 20);
        add(tfTahun_Terbit);
       tfTahun_Terbit.setBounds(110, 190, 200, 20);
        
        add(lJumlah);
        lJumlah.setBounds(30, 220, 90, 20);
        add(tfJumlah);
        tfJumlah.setBounds(110, 220, 200, 20);

        add(btnTambah);
        btnTambah.setBounds(70, 260, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(200, 260, 90, 20);
        
        add(btnClear);
        btnClear.setBounds(140, 290, 90, 20);
        

        add(lCari);
        lCari.setBounds(800, 5, 90, 20);

        add(tfCari);
        tfCari.setBounds(870, 5, 120, 20);

        add(btnCari);
        btnCari.setBounds(840, 35, 90, 20);

        add(btnReset);
        btnReset.setBounds(950, 35, 90, 20);
    }

    public String getId(){
        return tfId_Buku.getText();
    }

    public String getJudul(){
        return tfJudul.getText();
    }

    public String getPengarang(){
        return tfPengarang.getText();
    }

    public String getTahun(){
        return tfTahun_Terbit.getText();
    }
    public String getJumlah(){
        return tfJumlah.getText();
    }

    public String getCariJudul(){
        return tfCari.getText();
    }
}