/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class ContohMouseListener {
    public static void main(String [] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        
        //1.Buat Komponen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));
        
        //2. Buat MouseListener menggunakan ( MouseAdafter)
        MouseAdapter adapter = new MouseAdapter() {
          @Override 
          public void mouseEntered(MouseEvent e) {
              //saat maouse masuk ubah warna jadi biru
              panel.setBackground(Color.cyan);
          }
          
          @Override 
          public void mouseExited(MouseEvent e) {
              // saat mouse keluar kembalikan ke warna asli atau sebelumnya
              panel.setBackground(Color.LIGHT_GRAY);              
          }
          
          @Override
          public void mouseClicked(MouseEvent e) {
              //saat diklik menampilkan koordinat klik
              System.out.println("Mouse di Klik di: X" + e.getX() + ", y=" + e.getY());
          }
        };
        
        //3. Daftarkan listenner ke source
        panel.addMouseListener(adapter);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
