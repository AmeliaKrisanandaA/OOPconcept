/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kandidat;

/**
 *
 * @author ameli
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class omo {
    String nama;
    String gender;
    String alamat;
    int umur;

    public omo(String nama, String gender, String alamat, int umur) {
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.umur = umur;
    }

    public String buatnama() {
        return nama;
    }

    public String buatgender() {
        return gender;
    }

    public String buatalamat() {
        return alamat;
    }

    public int buatumur() {
        return umur;
    }
}

public class Kandidat {
    public static ArrayList<omo> kandidatList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("1. Input Kandidat Baru");
            System.out.println("2. Tampilkan Data Kandidat ");
            System.out.println("3. Hapus Kandidat");
            System.out.println("4. Kluar");
            System.out.print("Masukan Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (pilihan) {
                case 1:
                    kandidatbaru();
                    break;
                case 2:
                    tampilkandata();
                    break;
                case 3:
                    hapuskandidat();
                    break;
                case 4:
                    System.out.println("trimakasih...");
                    break;
                default:
                    System.out.println("pilihan tidak ada mohon di ulang");
            }
        } while (pilihan != 4);
    }

    public static void kandidatbaru() {
        System.out.println("Kandidat Baru");

        System.out.print("Nama Kandidat : ");
        String nama = scanner.nextLine();

        System.out.print("Gender Kandidat: ");
        String gender = scanner.nextLine();

        System.out.print("Alamat Kandidat : ");
        String alamat = scanner.nextLine();

        System.out.print("Umur Kandidat: ");
        int umur = scanner.nextInt();
        scanner.nextLine();

        omo omo  = new omo(nama, gender, alamat, umur);
        kandidatList.add(omo);
        System.out.println("Kandidat berhasil ditambahkan!");
    }

    public static void tampilkandata() {
        System.out.println("Data Kandidat : ");
        if (kandidatList.isEmpty()) {
            System.out.println("No Data!");
        } else {
            Collections.sort(kandidatList, Comparator.comparing(omo::buatnama, String.CASE_INSENSITIVE_ORDER));
            int urut = 1;
            for (omo abc : kandidatList) {
                System.out.println("|No|Nama|Gender|Alamat|Umur| ");
                System.out.print("|"+urut+"|");
                System.out.print("|"+abc.buatnama()+"|");
                System.out.print("|"+abc.buatgender()+"|");
                System.out.print("|"+abc.buatalamat()+"|");
                System.out.print("|"+abc.buatumur()+"|");
                System.out.println();
                urut++;
            }
        }
    }

    public static void hapuskandidat() {
       
        if (kandidatList.isEmpty()) {
            System.out.println("No Data!");
        } else {
            tampilkandata();
            System.out.print("masukan angka kandidat yang akan di hapus sesuai urutan: ");
            int nokandidat = scanner.nextInt();
            scanner.nextLine(); 
            if (nokandidat >= 1 && nokandidat <= kandidatList.size()) {
                kandidatList.remove(nokandidat - 1);
                System.out.println("kandidat berhasil di hapus");
            } else {
                System.out.println("nomor invalid!.");
            }
        }
    }
}
