/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraan;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Kii
 */
public class Controller {
    // Controller adalah class yang berisikan perintah dalam Bahasa SQL
    
    // Membuat Create data
    public int createData(String plat, String merk, String tipe, int harga){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        String query = "INSERT INTO mobil(plat,merk,tipe,harga) values('"+plat+"','"+merk+"','"+tipe+"','"+harga+"')"; // Perintah dalam bahasa SQL
        
        // Block try-catch
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        conMan.logOff(); // Memutuskan koneksi dengan database
        return hasil; // mereturn nilai hasil
    }
    
    // Untuk membaca Database
    public List<Data> getAllData(){
        String query = "SELECT * from mobil"; // Perintah dalam bahasa SQL yang berarti pilih dari tabel mobil
        List<Data> allData = new ArrayList<Data>(); 
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            // Statement ini akan digunakan untuk mengirim perintah SQL ke database.
            Statement stm = conn.createStatement();
            //Hasil dari query tersebut disimpan dalam ResultSet
            ResultSet rs = stm.executeQuery(query);
            // membaca data pada setiap kolom dari setiap baris dalam objek ResultSet dan memasukkannya ke dalam kelas Data
            while (rs.next()){
               String plat = rs.getString("plat");
               String merk = rs.getString("merk");
               String tipe = rs.getString("tipe");
               int harga = rs.getInt("harga");
               Data dataRead = new Data(plat,merk,tipe,harga);
               allData.add(dataRead);
            }
    } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    conMan.logOff(); // Memutuskan koneksi dengan database
    return allData; // mereturn nilai hasil
    }
    
    public int updateData(String plat, String merk, String tipe, int harga){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        // Perintah dalam bahasa SQL untuk mengupdate data
        String query="UPDATE mobil set plat='"+plat+"', merk='"+merk+"', tipe='"+tipe+"', harga="+harga+" where plat='"+plat+"'";
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        conMan.logOff(); // Memutuskan koneksi dengan database
        return hasil; // mereturn nilai hasil
    }
    
    public int deleteData(String plat){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        // Perintah dalam bahasa SQL untuk menghapus data
        String query = "DELETE FROM mobil where plat='"+plat+"'";
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        conMan.logOff(); // Memutuskan koneksi dengan database
        return hasil; // mereturn nilai hasil
    }

    
}
