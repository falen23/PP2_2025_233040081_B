/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.View;

/**
 *
 * @author Muhammad Fauzan nur
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MahasiswaView extends JFrame {

    public JTextField txtNama, txtNim, txtJurusan, txtCari;
    public JButton btnSimpan, btnEdit, btnHapus, btnCari;
    public JTable table;
    public DefaultTableModel model;

    public MahasiswaView() {
        setTitle("CRUD Mahasiswa MVC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNama = new JTextField();
        txtNim = new JTextField();
        txtJurusan = new JTextField();
        txtCari = new JTextField(15);

        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnCari = new JButton("Cari");

        model = new DefaultTableModel(new Object[]{"No","Nama","NIM","Jurusan"},0);
        table = new JTable(model);

        JPanel panel = new JPanel(new GridLayout(5,2));
        panel.add(new JLabel("Nama")); panel.add(txtNama);
        panel.add(new JLabel("NIM")); panel.add(txtNim);
        panel.add(new JLabel("Jurusan")); panel.add(txtJurusan);
        panel.add(btnSimpan); panel.add(btnEdit);
        panel.add(btnHapus); panel.add(btnCari);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

