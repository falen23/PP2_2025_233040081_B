/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.modul8.view;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class PersegiPanjangView extends JFrame {
    //komponen ui sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung Luas");
    private JLabel lblHasilKel = new JLabel("-");
    private JButton btnReset = new JButton("Reset");
    
    public PersegiPanjangView() {
        //inisialisasi Ui
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 2, 10, 10)); //Grid 4 baris
        this.setTitle("MVC Kalkurator");
        
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKel);
        this.add(new JLabel(""));
        this.add(btnHitung);
        this.add(new JLabel(""));
        this.add(btnReset);
        
    }
        //mengambil nilai panjang dari TextField
     public double getPanjang() {
            return Double.parseDouble(txtPanjang.getText());
        }
     
     //mengambil nilai panjang dari textfield
     public double getLebar() {
         return Double.parseDouble(txtLebar.getText());
     }
            
     //menampilkan hasil label
     public void setHasil(double hasil) {
         lblHasil.setText(String.valueOf(hasil));
     }
     
     public void setHasilKel(double hasilKel) {
         lblHasilKel.setText(String.valueOf(hasilKel));
     }
     
     //menampilkan pesan error (jika input bukan angka)
     public void tampilkanPesanError(String pesan) {
         JOptionPane.showMessageDialog(this, pesan);
     }
     
     //Mendaftarkan listener untuk tombol (Controller yang akan memberikan aksisnya)
     public void addHitungListener(ActionListener listener) {
         btnHitung.addActionListener(listener);
     }
     
     public void ResetInput() {
         txtPanjang.setText("");
         txtLebar.setText("");
         lblHasil.setText("");
         lblHasilKel.setText("");
     }
     
     public JButton getReset() {
         return btnReset;
     }
}
