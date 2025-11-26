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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class TugasModul7 extends JFrame {

/**
 * Aplikasi Manajemen Nilai Siswa
 * Menyimpan, menampilkan, dan menghapus data nilai siswa
 */

    // Deklarasi komponen input
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;

    // Komponen tabel
    private JTable tableData;
    private DefaultTableModel tableModel;

    // Tab
    private JTabbedPane tabbedPane;

    /**
     * Membuat panel Input Data Siswa
     */
    private JPanel createInputPanel() {

        // Panel dengan grid 5 baris dan 2 kolom
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ================================
        // FIELD NAMA
        // ================================
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField(); // Input nama siswa
        panel.add(txtNama);

        // ================================
        // FIELD MATA PELAJARAN (COMBOBOX)
        // ================================
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
            "Matematika Dasar",
            "Bahasa Indonesia",
            "Algoritma & Pemograman I",
            "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // ================================
        // FIELD NILAI
        // ================================
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField(); // Input nilai siswa
        panel.add(txtNilai);

        // ================================
        // TOMBOL SIMPAN DATA
        // ================================
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        // ================================
        // TOMBOL RESET INPUTAN
        // ================================
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);

        // Event listener tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan(); // Memanggil method simpan
            }
        });

        // Event tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
            }
        });

        return panel;
    }

    /**
     * Membuat panel Tabel Daftar Nilai
     */
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Header kolom tabel
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};

        // Model tabel penyimpan data
        tableModel = new DefaultTableModel(kolom, 0);

        // Tabelnya
        tableData = new JTable(tableModel);

        // ScrollPane agar tabel bisa discroll
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol hapus data (di bawah tabel)
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        panel.add(btnHapus, BorderLayout.SOUTH);

        // Event tombol hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Mengambil baris yang dipilih user
                int rowIndex = tableData.getSelectedRow();

                // Jika ada yang dipilih
                if (rowIndex > -1) {
                    tableModel.removeRow(rowIndex); // Hapus baris
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus!");
                }
            }
        });

        return panel;
    }

    /**
     * Proses validasi & simpan data ke tabel
     */
    private void prosesSimpan() {

        // Mengambil data input user
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // ================================
        // VALIDASI NAMA
        // ================================
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Nama minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ================================
        // VALIDASI NILAI
        // ================================
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);

            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ================================
        // MENENTUKAN GRADE (SWITCH CASE)
        // ================================

        // Kita gunakan nilai / 10 agar dapat kategori 80–100 = 8–10
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }

        // ================================
        // TAMBAH DATA KE TABEL
        // ================================
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // ================================
        // RESET FORM
        // ================================
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        // Notifikasi berhasil
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        // Pindah otomatis ke tab tabel
        tabbedPane.setSelectedIndex(1);
    }

    /**
     * Konstruktor utama aplikasi (Frame)
     */
    public TugasModul7() {

        setTitle("Aplikasi Manajemen Nilai Siswa"); // Judul aplikasi
        setSize(550, 420);                         // Ukuran window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);               // Tampil di tengah layar

        // Membuat tab
        tabbedPane = new JTabbedPane();

        // Tab input
        tabbedPane.addTab("Input Data", createInputPanel());

        // Tab tabel nilai
        tabbedPane.addTab("Daftar Nilai", createTablePanel());

        // Menambahkan tab ke frame
        add(tabbedPane);
    }

    /**
     * Main method untuk menjalankan aplikasi
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasModul7().setVisible(true);
        });
    }


}
