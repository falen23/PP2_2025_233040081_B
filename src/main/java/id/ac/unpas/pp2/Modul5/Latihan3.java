/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul5;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class Latihan3 {
    
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame ("Label dan tombol");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 1. atur layout manager
                // Flowlayout akan menyusun komponen dari kiri ke kanan.
                frame.setLayout(new FlowLayout());
                
                // 2. buat komponen GUI
                JLabel label = new JLabel ("Teks awal");
                JButton button = new JButton ("Klik Saya!");
                
                /* 3. Tambahkan aksi (ActionListener) ke tombol penambahan 
                 ini menggunakan lambda untuk mempersingkat penggunaan
                 anonymous inner class */
                button.addActionListener(e -> {
                    //aksi ini akan mengubah teks pada label
                    label.setText("Tombol berhasil di Klik");
                });
                
                /* 4. tambahkan komponenke frame karena
                    kita menggunakan flowlayout, keduanya
                    akan tampil berdampingan */
                frame.add(label);
                frame.add(button);
                
                frame.setVisible(true);
            }
        });
    }
}
