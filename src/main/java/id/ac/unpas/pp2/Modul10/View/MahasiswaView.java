/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.View;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
/**
 *
 * @author Muhammad Fauzan nur
 */

public class MahasiswaView extends JFrame {

    private final JTextField txtNama, txtNIM, txtJurusan, txtCari;
    
    private final JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private final JTable tableMahasiswa;
    private final DefaultTableModel model;
    
    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);
        
        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        
        // Panel Cari
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCari.add(new JLabel("Cari Nama:"));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        panelCari.add(txtCari);
        panelCari.add(btnCari);
        
        // Gabung Panel Header
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.add(panelForm, BorderLayout.NORTH);
        JPanel panelActions = new JPanel(new BorderLayout());
        panelActions.add(panelTombol, BorderLayout.NORTH);
        panelActions.add(panelCari, BorderLayout.SOUTH);
        panelHeader.add(panelActions, BorderLayout.SOUTH);
        
        add(panelHeader, BorderLayout.NORTH);
        
        // Gabungkan Panel Form dan Tombol di bagian Atas (NORTH)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);
        panelHeader.add(panelAtas, BorderLayout.NORTH); // Form & Tombol CRUD
        panelHeader.add(panelCari, BorderLayout.CENTER); // Panel Pencarian
        add(panelHeader, BorderLayout.NORTH);
        
        model = new DefaultTableModel(new String[] {"No", "NIM", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }
    
    // SETTER & GETTER
    public String getNama() {
        return txtNama.getText();
    }
    
    public String getNIM() {
        return txtNIM.getText();
    }
    
    public String getJurusan() {
        return txtJurusan.getText();
    }
    
    public String getSearch() {
        return txtCari.getText();
    }
    
    public void setNama(String text) {
        txtNama.setText(text);
    }
    
    public void setNIM(String text) {
        txtNIM.setText(text);
    }
    
    public void setJurusan(String text) {
        txtJurusan.setText(text);
    }
    
    public void kosongkanForm() {
        txtNama.setText(null);
        txtNIM.setText(null);
        txtJurusan.setText(null);
    }
    
    public DefaultTableModel getTableModel() {
        return model;
    }
    
    public JTable getTable() {
        return tableMahasiswa;
    }
    
    public void saveListener(ActionListener listener) { 
        btnSimpan.addActionListener(listener); 
    }
    public void editListener(ActionListener listener) { 
        btnEdit.addActionListener(listener); 
    }
    public void hapusListener(ActionListener listener) { 
        btnHapus.addActionListener(listener); 
    }
    public void kosongListener(ActionListener listener) { 
        btnClear.addActionListener(listener); 
    }
    public void searchListener(ActionListener listener) { 
        btnCari.addActionListener(listener); 
    }
    public void tableMouseListener(MouseAdapter adapter) { 
        tableMahasiswa.addMouseListener(adapter); 
    }
}


