/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.Modul9;
import java.io.Serializable;
/**
 *
 * @author Muhammad Fauzan nur
 */
public class UserConfig implements Serializable{
    private String username;
    private int fontsize;
    
    public String getUsernmae() {
        return username;
    }
    
    public void setUsername() {
        this.username = username;
    }
    
    public int getFontsize() {
        return fontsize;
    }
    
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    void setUsername(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
