/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.Model;
import id.ac.unpas.pp2.Modul10.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muhammad Fauzan nur
 */



public class MahasiswaModel {

    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM mahasiswa");
            while (res.next()) {
                list.add(new Mahasiswa(
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void tambah(Mahasiswa mhs) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setString(3, mhs.getJurusan());
        pst.execute();
    }
    
    public void edit(Mahasiswa mhs) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setString(3, mhs.getJurusan());
        pst.executeUpdate();
    }
    
    public void hapus(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.execute();
    }
    
    public List<Mahasiswa> search(String keyword) {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
            
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%"); // Tambahkan wildcard %
            
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                list.add(new Mahasiswa(
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean exists (String nim) {
        try {
            String sql = "SELECT nim FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            ResultSet res = pst.executeQuery();
            
            return res.next(); // Mengembalikan true jika NIM ditemukan
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}