/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul7;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Muhammad Fauzan nur
 */
public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    
    //Method untuk membuat desain Tab Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);
        
        //komponen Mata Pelajaran (comobox)
        panel.add(new JLabel("Mata Peljaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
            "Algoritma & Pemograman I", "Praktikum Pemaograman II" };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);
        
        //komponen Nilai
        panel.add(new JLabel("Nilai (0-100): "));
        txtNilai = new JTextField();
        panel.add(txtNilai);
        
        //tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel("")); //Placehorder Kosong agar tombol di kanan
        panel.add(btnSimpan);
        
        //event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void  actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });
        
        return panel;
    }
    
    // methode untuk membuat desain Tab Tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
     
        //setup Model Tabel (Kolom)
        String[] Kolom = {"Nama Siswa", "Mata Pelajaran ", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(Kolom, 0);
        tableData = new JTable(tableModel);
        
        //membungkus tabel dengan ScrollPane (agar bisa di scroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    // logika validasi dan penyimpanan data
    
    private void prosesSimpan() {
        // 1. ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        
        //2. Validasi input
        
        //validasi 1: cek apakah nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai Harus Antara 0-100!", 
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; //Hentikan Proses
        }
        
        // Validasi 2: cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!", 
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai Harus Berupa Angka!", 
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 3.Logika Bisnis (Menentukan Grade)
        String grade;
        if (nilai >= 80) grade = "A";
        else if (nilai >= 70) grade = "AB";
        else if (nilai >= 60) grade = "B";
        else if (nilai >= 50) grade = "BC";
        else if (nilai >= 40) grade = "C";
        else if (nilai >= 30) grade = "D";
        else grade = "E";
        
        // 4. Masukan ke Tabel (Update Model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);
        
        // 5. reset Form dan pindah Tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        tabbedPane.setSelectedIndex(1); // otomatis pindah ke tab tabel
    }
    
    public ManajemenNilaiSiswaApp() {
    // 1. Konfigurasi Frame Utama
        setTitle("Aplikasi Managemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Posisi ditengah layar
        
        //2. inisisalisasi tabbed pane
        tabbedPane = new JTabbedPane();
        
        //3. membuat panel untuk tab 1 (Form Lanjut)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);
        
        //4. membuat panel untuk tab 2 (Tabel Data)
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftra Nilai", panelTabel);
        
        //menambahkan tabbedpane ke frame
        add(tabbedPane);
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}
