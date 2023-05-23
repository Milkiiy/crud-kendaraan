/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kendaraan;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Kii
 */
public class Kendaraan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        System.out.println("Koneksi: "+ conn +"\n");
        Data data = new Data();
        System.out.println("Halo! Selamat Datang di Dealer Mobil Bekas Kami!");
        System.out.println("1. Menambahkan Data (Create)");
        System.out.println("2. Menampilkan Data (Read)");
        System.out.println("3. Memperbarui Data (Update)");
        System.out.println("4. Menghapus Data (Delete)");
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan Pilihan Anda : ");
        int a = input.nextInt();
        if (a == 1){
            data.create();
        }
        if (a == 2){
            data.read();
        }
        if (a == 3){
            data.update();
        }
        if (a == 4){
            data.delete();
        }
        
    }
    
}
