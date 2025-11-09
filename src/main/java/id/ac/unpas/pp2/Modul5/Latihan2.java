/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul5;

import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Jendela Dengan Label");
                frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 1.Buat komponen JLabel
                JLabel label = new JLabel("Ini adalah JLabel.");
                
                // 2.tambahkan JLabel ke JFrame
                // Secara default, JFrame menggunakan BorderLayout,
                // dan .add() akan menambahkannya ke bagian tengan (CENTER),
                
                frame.add(label);
                
                frame.setVisible(true);
            }
        });
    }
    
}
