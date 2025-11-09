/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul6;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class Tugas1 {
    public static void main(String [] args) {
        //1. Buat Frame
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        
        //2.Buat layar dibagian atas menggunakan JTextField
        JTextField layar = new JTextField();
        frame.add(layar, BorderLayout.NORTH);
        
        // 3.Buat panel untuk tombol dengan GridLayout 4 baris, 4 kolom
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(4, 4, 5, 5));
        
        Panel.add(new JButton("7"));
        Panel.add(new JButton("8"));
        Panel.add(new JButton("9"));
        
        Panel.add(new JButton("/"));
        Panel.add(new JButton("4"));
        Panel.add(new JButton("5"));
        
        Panel.add(new JButton("6"));
        Panel.add(new JButton("*"));
        Panel.add(new JButton("1"));
        
        Panel.add(new JButton("2"));
        Panel.add(new JButton("3"));
        Panel.add(new JButton("-"));
        
        Panel.add(new JButton("0"));
        Panel.add(new JButton("'"));
        Panel.add(new JButton("="));
        Panel.add(new JButton("+"));
        
        frame.add(Panel, BorderLayout.CENTER);
 
        frame.setVisible(true);
    }
}
