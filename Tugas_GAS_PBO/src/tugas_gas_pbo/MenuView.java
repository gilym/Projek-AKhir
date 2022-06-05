/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import javax.swing.*;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuView extends JFrame{
    JButton btnBuku = new JButton("1.Buku");
    JButton btnAnggota = new JButton("2.Anggota");
    JButton btnPeminjaman = new JButton("3.Peminjaman");
    JLabel noted = new JLabel("SELAMAT DATANG DI APLIKASI PERPUSTAKAAN");
    JLabel menu = new  JLabel (" Pilih Menu : ");

    public MenuView() {
        setTitle("Menu APlikasi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setSize(350,450);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(btnBuku);
        btnBuku.setBounds(90, 140, 150, 20);
        
        add(btnAnggota);
        btnAnggota.setBounds(90, 170, 150, 20);
        
        add(btnPeminjaman);
        btnPeminjaman.setBounds(90, 200, 150, 20);
        
        add(noted);
        noted.setBounds(25, 50, 300, 30);
        add(menu);
        menu.setBounds(80, 115, 150, 20);
        
        
    }
}