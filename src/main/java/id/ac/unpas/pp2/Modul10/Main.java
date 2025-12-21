/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul10;

import id.ac.unpas.pp2.Modul10.Controller.MahasiswaController;
import id.ac.unpas.pp2.Modul10.Model.MahasiswaModel;
import id.ac.unpas.pp2.Modul10.View.MahasiswaView;
/**
 *
 * @author Muhammad Fauzan nur
 */



public class Main {
    public static void main(String[] args) {
        MahasiswaView view = new MahasiswaView();
        MahasiswaModel model = new MahasiswaModel();
        new MahasiswaController(view, model);
        view.setVisible(true);
    }
}

