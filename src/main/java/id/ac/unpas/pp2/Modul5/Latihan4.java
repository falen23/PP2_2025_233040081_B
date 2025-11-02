/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class Latihan4 {
   public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                /* 1. atur layout manager ke borderlayout
                    sebenarnya ini tidak perlu karena 
                    borderlayout adlah layout manager default
                */
                frame.setLayout(new BorderLayout());
                
                // 2. Buat Komponen
                JLabel label = new JLabel("Label ada Diatas (NORTH)");
                JButton button = new JButton("Tombol ada Dibawah (SOUTH)");
                
                // 3. Tambahkan aksi (ActionListener) ke tombol
                button.addActionListener(e -> {
                    label.setText("Tombol di (SOUTH) di Klik!");
                });
                
                // 4. Tambahkan Komponen ke frame dengan posisi.
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                
                // kita bisa tambahkan komponen lain
                frame.add(new JButton("WEST"), BorderLayout.WEST);
                frame.add(new JButton("EAST"), BorderLayout.EAST);
                frame.add(new JButton("CENTER"), BorderLayout.CENTER);
                
                frame.setVisible(true);
            }
        });
}
}
