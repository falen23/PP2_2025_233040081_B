/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.Controller;

import id.ac.unpas.pp2.Modul10.Model.*;   
import id.ac.unpas.pp2.Modul10.View.MahasiswaView;
import javax.swing.JOptionPane;
     
/**
 *
 * @author Muhammad Fauzan nur
 */
public class MahasiswaController {
    private MahasiswaView view;
    private MahasiswaModel model;

    public MahasiswaController(MahasiswaView view, MahasiswaModel model) {
        this.view = view;
        this.model = model;

        view.btnSimpan.addActionListener(e -> simpan());
        view.btnCari.addActionListener(e -> cari());
        loadTable();
    }

    private void loadTable() {
        try {
            view.model.setRowCount(0);
            int no = 1;
            for (Mahasiswa m : model.getAll()) {
                view.model.addRow(new Object[]{
                    no++, m.getNama(), m.getNim(), m.getJurusan()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void simpan() {
        try {
            if (model.cekNim(view.txtNim.getText())) {
                JOptionPane.showMessageDialog(view, "NIM sudah ada!");
                return;
            }
            model.insert(new Mahasiswa(
                view.txtNama.getText(),
                view.txtNim.getText(),
                view.txtJurusan.getText()
            ));
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cari() {
        try {
            view.model.setRowCount(0);
            int no = 1;
            for (Mahasiswa m : model.cari(view.txtCari.getText())) {
                view.model.addRow(new Object[]{
                    no++, m.getNama(), m.getNim(), m.getJurusan()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
