/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul6;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class ContohFlowLayout {
    public static void main(String [] args) {
        // 1,Buat Frame (Window)
        JFrame frame = new JFrame("Contoh FlowLaout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        //2. Buat Panel (Container)
        // JPanel secara default sudah menggunakan FlowLaout
        JPanel panel = new JPanel();
        // bisa juga diatur secara eksplisit:
       // panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //Center,left atau right
       
       //3.Buat dan Tambahakn Komponen
       panel.add(new JButton("Tombol 1"));
       panel.add(new JButton("Tombol 2"));
       panel.add(new JButton("Tombol Tiga"));
       panel.add(new JButton("Tombol Empat Panjang"));
       panel.add(new JButton("Tombol 5"));
       
       //4.Tambahkan panel ke frame 
       frame.add(panel);
       
       //5.Tampilkan frame
       frame.setVisible(true);
    }
}
