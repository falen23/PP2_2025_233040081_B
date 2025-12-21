/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.Controller;

import id.ac.unpas.pp2.Modul10.Model.*;   
import id.ac.unpas.pp2.Modul10.View.MahasiswaView;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.List;
     
/**
 *
 * @author Muhammad Fauzan nur
 */


public class MahasiswaController {
    
    private final MahasiswaModel model;
    private MahasiswaView view;

    public MahasiswaController(MahasiswaModel model, MahasiswaView view) {
        this.model = model;
        this.view = view;
        
        loadData(model.getAll());
        
        view.saveListener(e -> simpanData());
        view.editListener(e -> editData());
        view.hapusListener(e -> hapusData());
        view.kosongListener(e -> view.kosongkanForm());
        view.searchListener(e -> cariData());
        
        view.tableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTable().getSelectedRow();
                view.setNama(view.getTableModel().getValueAt(row, 1).toString());
                view.setNIM(view.getTableModel().getValueAt(row, 2).toString());
                view.setJurusan(view.getTableModel().getValueAt(row, 3).toString());
            }
        });
    }

    private void loadData(List<Mahasiswa> list) {
        view.getTableModel().setRowCount(0); // Reset tabel
        int no = 1;
        for (Mahasiswa m : list) {
            view.getTableModel().addRow(new Object[]{
                no++, m.getNama(), m.getNim(), m.getJurusan()
            });
        }
    }

    private void simpanData() {
        // Validasi Kosong (Latihan 2)
        if (view.getNama().trim().isEmpty() || view.getNIM().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }
        // Validasi Duplikasi
        if (model.exists(view.getNIM())) {
            JOptionPane.showMessageDialog(view, "NIM sudah ada!");
            return;
        }

        try {
            Mahasiswa mhs = new Mahasiswa(view.getNama(), view.getNIM(), view.getJurusan());
            model.tambah(mhs);
            JOptionPane.showMessageDialog(view, "Berhasil Simpan");
            loadData(model.getAll());
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal: " + e.getMessage());
        }
    }

    private void editData() {
        try {
            Mahasiswa mhs = new Mahasiswa(view.getNama(), view.getNIM(), view.getJurusan());
            model.edit(mhs);
            JOptionPane.showMessageDialog(view, "Berhasil Edit");
            loadData(model.getAll());
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Edit: " + e.getMessage());
        }
    }

    private void hapusData() {
        try {
            model.hapus(view.getNIM());
            JOptionPane.showMessageDialog(view, "Berhasil Hapus");
            loadData(model.getAll());
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Hapus: " + e.getMessage());
        }
    }
    
    private void cariData() {
        String keyword = view.getSearch();
        loadData(model.search(keyword));
    }
}
