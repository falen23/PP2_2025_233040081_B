/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Muhammad Fauzan nur
 */

public class KonversiSuhu extends JFrame implements ActionListener {

    // Komponen GUI
    private JTextField txtCelcius;
    private JLabel lblHasil;

    public KonversiSuhu() {
        // Judul jendela
        setTitle("Konversi Suhu Celcius ke Fahrenheit");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5)); // menggunakan GridLayout

        // Komponen
        JLabel lblCelcius = new JLabel("Celcius:");
        txtCelcius = new JTextField();
        JButton btnKonversi = new JButton("Konversi");
        JLabel lblFahrenheit = new JLabel("Fahrenheit:");
        lblHasil = new JLabel(""); // label kosong untuk hasil

        // Tambahkan komponen ke frame
        add(lblCelcius);
        add(txtCelcius);
        add(btnKonversi);
        add(new JLabel("")); // kolom kosong agar rapi
        add(lblFahrenheit);
        add(lblHasil);

        // Tambahkan ActionListener ke tombol
        btnKonversi.addActionListener(this);

        // Tampilkan jendela
        setLocationRelativeTo(null); // agar muncul di tengah layar
        setVisible(true);
    }

    // Method untuk menangani klik tombol
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Ambil input dari JTextField
            String input = txtCelcius.getText();

            // Ubah ke double
            double celcius = Double.parseDouble(input);

            // Rumus konversi
            double fahrenheit = (celcius * 9 / 5) + 32;

            // Tampilkan hasil
            lblHasil.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            // Jika input bukan angka
            JOptionPane.showMessageDialog(this, 
                "Masukkan angka yang valid!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            txtCelcius.setText("");
            lblHasil.setText("");
        }
    }

    // Method utama
    public static void main(String[] args) {
        new KonversiSuhu();
    }
}

