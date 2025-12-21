/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10.Model;

/**
 *
 * @author Muhammad Fauzan nur
 */

import id.ac.unpas.pp2.Modul10.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaModel {

    public List<Mahasiswa> getAll() throws Exception {
        List<Mahasiswa> list = new ArrayList<>();
        Connection conn = KoneksiDB.configDB();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM mahasiswa");

        while (rs.next()) {
            list.add(new Mahasiswa(
                rs.getString("nama"),
                rs.getString("nim"),
                rs.getString("jurusan")
            ));
        }
        return list;
    }

    public void insert(Mahasiswa mhs) throws Exception {
        String sql = "INSERT INTO mahasiswa VALUES (?, ?, ?)";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setString(3, mhs.getJurusan());
        pst.execute();
    }

    public boolean cekNim(String nim) throws Exception {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim=?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nim);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    public List<Mahasiswa> cari(String keyword) throws Exception {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            list.add(new Mahasiswa(
                rs.getString("nama"),
                rs.getString("nim"),
                rs.getString("jurusan")
            ));
        }
        return list;
    }
}

