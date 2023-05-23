/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraan;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kii
 */
public class Data {
    private String plat;
    private String merk;
    private String tipe;
    private int harga;

    // Contructor kosong
    public Data() {
    }

    // Constructor isi
    public Data(String plat, String merk, String tipe, int harga) {
        this.plat = plat;
        this.merk = merk;
        this.tipe = tipe;
        this.harga = harga;
    }

    // Setter getter
    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "> Plat Mobil : " + plat + ", Merk Mobil : " + merk + ", Tipe Mobil : " + tipe + ", Harga Mobil : " + harga;
    } // ToString

    // Create data
    public void create(){
        // Mengeluarkan Windows baru untuk menjawab pertanyaan dan jawabannya akan di simpan pada variable yang di tetapkan
        plat = JOptionPane.showInputDialog("Masukan Plat Nomer Kendaraan : ");
        merk = JOptionPane.showInputDialog("Masukan Merk Kendaraan : ");
        tipe = JOptionPane.showInputDialog("Masukan Tipe Kendaraan : ");
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukan Harga Kendaraan : "));
        
        Controller manCon = new Controller();
        int hasil = manCon.createData(plat,merk,tipe,harga);// Memanggil fungsi createData
        System.out.println("Hasil input data : "+hasil);// Mengeluarkan hasil input data
        read(); // Menampilkan data
    }
    
    // Read Data
    public void read(){
        Controller manCon = new Controller();
        List<Data> allData = manCon.getAllData(); // Arraylist
        System.out.println("Data Mobil Terkini : ");
        for(Data dat1: allData){ // Mengulan dari data1 sampai data terakhir
            System.out.println(dat1);
        }
    }
    
    // Update Data
    public void update(){
        plat = JOptionPane.showInputDialog("Masukan Plat Nomer Kendaraan yang akan diubah : ");
        merk = JOptionPane.showInputDialog("Masukan Merk Kendaraan yang akan diubah : ");
        tipe = JOptionPane.showInputDialog("Masukan Tipe Kendaraan yang akan diubah : ");
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukan Harga Kendaraan yang akan diubah : "));
        
        Controller manCon = new Controller();
        int hasil = manCon.updateData(plat,merk,tipe,harga);
        System.out.println("Hasil input data : "+hasil);
        read();
    }
    
    public void delete(){
        plat = JOptionPane.showInputDialog("Masukan Plat Nomer Kendaraan yang akan dihapus : ");
        Controller manCon = new Controller();
        int hasil = manCon.deleteData(plat);
        System.out.println("Hasil input data : "+hasil);
        read();
    }
}
