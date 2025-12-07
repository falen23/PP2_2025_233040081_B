/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.modul8.controller;
import id.ac.unpas.pp2.modul8.model.PersegiPanjangModel;
import id.ac.unpas.pp2.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
//import java.awt.event.AWTEventListener;
import java.awt.event.ActionListener;

/**
 *
 * @author Muhammad Fauzan nur
 */
public class PersegiPanjangController {
    //model dan view sebagai atribut kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;
    
    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;
        
        //menghubungkan tombol di view dengan logic di controller
        this.view.addHitungListener(new HitungListenner());
        view.getReset().addActionListener(new ResetListenner());
    }
    
    class ResetListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.ResetInput();
        }
    }
    
    //insert class untuk menangani event klik tombol
    class HitungListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //1. ambil data dari view
                double p = view.getPanjang();
                double l = view.getLebar();
                model.getKel();
                
                //2.kirim data ke model
                model.setPanjang(p);
                model.setLebar(l);
                
                //3. jalankan logika bisnis di model
                model.hitungLuas();
                model.hitungKeliling();
                
                //4. ambil hasil dari model dan tampilkan kembali di view
                double hasil = model.getLuas();
                view.setHasil(hasil);
                double hasilKel = model.getKel();
                view.setHasilKel(hasilKel);
                
            }catch (NumberFormatException ex) {
                //handle jika user memasukna huruf
                view.tampilkanPesanError("Masukan Angka Yang Valid!");
            }
        }
    }
}
