/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class MahasiswaApp extends JFrame {
    
    JTextField txtCari;
    JButton btnCari;
    JTextField txtNama, txtNim, txtJurusan;
    JButton btnSimpan, btnEdit, btnHapus, btnClear;
    JTable tableMahasiswa;
    DefaultTableModel model;
    
    public MahasiswaApp() {
        //setup Frame
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // 1. panel form (input Data)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);
        
        panelForm.add(new JLabel("Nim"));
        txtNim = new JTextField();
        panelForm.add(txtNim);
        
        panelForm.add(new JLabel("Jurusan"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);
        
        
        //panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("SImpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        
        
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panelCari.add(new JLabel("Cari Nama:"));
        txtCari = new JTextField(15);
        panelCari.add(txtCari);
        btnCari = new JButton("Cari");
        panelCari.add(btnCari);
        
        
        
        //Gabungkan panel form dan tombol di bagian atas (NORTH)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        panelAtas.add(panelCari, BorderLayout.NORTH);
        add(panelAtas, BorderLayout.NORTH);
        
        // 2. Tabel Data (Menampilkan Data)
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Nim");
        model.addColumn("Jurusan");
        
        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);
        
        
        //   Event Listenners

        
        // Listenner klik Tabel (Untuk mengambil data saat baris diklik)
        tableMahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNim.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());
            }
        });
        
        //aksi tombol simpan (CREATE)
        btnSimpan.addActionListener(e -> tambahData());
        
        //akasi tomvol simpan
        btnCari.addActionListener(e -> cariData());
        
        //aksi tombol edit
        btnEdit.addActionListener(e -> ubahData());
        
        //aksi tombol gapus (DELETE)
        btnHapus.addActionListener(e -> hapusData());
//        
//        //aksi tombol clear
        btnClear.addActionListener(e -> kosongkanForm());
//        
//        //Load Data saat aolikasi pertama kali jalan
        loadData();
    }
    
    // Logika CRUD
    
    
    //1. READ (Menampilkan Data)
    
    private void loadData() {
        model.setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM Mahasiswa");
            
            
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Load Data: " + e.getMessage());
        }
    }
    
    
    // 2. CREATE (Menambah Data)
private void tambahData() {
    try {
        // Validasi Kosong Latihan 2
        if (txtNama.getText().trim().isEmpty() || txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong!");
            return;
        }
        // Validasi Nim Latihan 4
        if (cekNimAda(txtNim.getText())) {
            JOptionPane.showMessageDialog(this, "Nim Sudah Terdaftar!");
            return;
        }
        
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtNama.getText());
        pst.setString(2, txtNim.getText());
        pst.setString(3, txtJurusan.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        loadData();
        kosongkanForm();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
    }
}
 // 3. UPDATE (Mengubah Data berdasarkan NIM)
private void ubahData() {
    try {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtNama.getText());
        pst.setString(2, txtJurusan.getText());
        pst.setString(3, txtNim.getText()); // Kunci update
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
        loadData();
        kosongkanForm();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Edit: " + e.getMessage());
    }
}
 //  CariData Latihan 3
    private void cariData() {
    model.setRowCount(0);
        if (txtCari.getText().trim().isEmpty()) {
            loadData();
            return;
        }
    
    model.setRowCount(0);
    try {
        
        String keyword = txtCari.getText();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        
        ResultSet res = pst.executeQuery();
        
        int no = 1;
        while (res.next()) {
            model.addRow(new Object[]{
                no++,
                res.getString("nama"),
                res.getString("nim"),
                res.getString("jurusan")
            });
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Cari Data: " + e.getMessage());
    }
}
    
    // CekNim Latihan 4
    private boolean cekNimAda(String nim) {
    try {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // true jika NIM sudah ada
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal cek NIM: " + e.getMessage());
    }
    return false;
}

    // 4. DELETE (Menghapus Data)
private void hapusData() {
    try {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtNim.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        loadData();
        kosongkanForm();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
    }
}



private void kosongkanForm() {
    txtNama.setText(null);
    txtNim.setText(null);
    txtJurusan.setText(null);
}

public static void main(String[] args) {
    // Menjalankan Aplikasi
    SwingUtilities.invokeLater(() -> new MahasiswaApp().setVisible(true));
}
}
