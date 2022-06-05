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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;


public class PinjamView extends JFrame{
   
    JLabel lNIM = new JLabel("NIM");
    JLabel lId_Buku = new JLabel("Id_Buku");
    JLabel lPinjam = new JLabel("Tanggal Peminjaman");
    JLabel lId = new JLabel ("Id_Peminjaman ");
    JLabel lCari = new JLabel("Cari NIM : ");
    JLabel lsort = new JLabel ("Sort By :");
    JLabel Input = new JLabel ("INPUT DATA");
    JLabel note = new JLabel ("Sebelum UPDATE Harap Isi Id_Peminjaman Yang Ingin Di UPDATE");
    

    JTextField tfNIM = new JTextField();
    JTextField tfId_Buku = new JTextField();
    JTextField tfId = new JTextField();
  JXDatePicker date = new JXDatePicker();
  
       JTextField tfCari = new JTextField();
    

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnCari = new JButton("Search");
    JButton btnReset = new JButton("Refresh");
    JButton btnNama = new JButton("Nama");
    JButton btnJudul = new JButton("Judul");
    JButton btnTgl = new JButton("Tanggal Peminjaman");
    JButton btnBack = new JButton ("Back");
    JButton btnClear = new JButton("Clear");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Id Peminjaman", "Nama", "Judul", "Tanggal Peminjaman"};

    public PinjamView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        date.setDate(Calendar.getInstance().getTime());
        date.setFormats(new SimpleDateFormat("yyyy.MM.dd"));
        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Data Kontak");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
     
        setSize(1100,600);
        
        add(scrollPane);
        scrollPane.setBounds(470, 110, 550, 300);
        
        add(Input);
        Input.setBounds(150, 20, 150, 100);

        add(lsort);
        lsort.setBounds(470, 80, 90, 20);
        add(btnNama);
        btnNama.setBounds(530, 80, 75, 20);
         add(btnJudul);
        btnJudul.setBounds(615, 80, 110, 20);
         add(btnTgl);
        btnTgl.setBounds(740, 80, 158, 20);
       
        add(btnBack);
       btnBack.setBounds(10, 10, 90, 20);
        
        add(lNIM);
        lNIM.setBounds(30, 100, 90, 20);
        add(tfNIM);
        tfNIM.setBounds(110, 100, 200, 20);

        add(lId_Buku);
        lId_Buku.setBounds(30, 130, 90, 20);
        add(tfId_Buku);
        tfId_Buku.setBounds(110, 130, 200, 20);
        
        add(lPinjam);
        lPinjam.setBounds(30, 160, 120, 20);
        add(date);
        getContentPane().add(date);
        date.setBounds(150, 160, 170, 20);
        
        add(note);
        note.setBounds(40, 205, 500, 60);
        
        add(lId);
        lId.setBounds(30, 250, 90, 20);
        add(tfId);
        tfId.setBounds(120, 250, 180, 20);

        add(btnTambah);
        btnTambah.setBounds(70, 280, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(200, 280, 90, 20);
        
        add(btnClear);
        btnClear.setBounds(140, 310, 90, 20);


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

    public String getNim(){
        return tfNIM.getText();
    }

    public String getTanggal(){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String Tanggal = String.valueOf(fm.format(date.getDate()));
        return Tanggal;
    }
    public String getIdPinjam(){
        return tfId.getText();
    }

   

    public String getCariNIM(){
        return tfCari.getText();
    }
}