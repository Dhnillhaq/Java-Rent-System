import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DaftarRentalan system = new DaftarRentalan();
        TransaksiRental relasi = new TransaksiRental();

        BarangRental brent1 = new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 10000);
        system.tambahB(brent1);
        BarangRental brent2 = new BarangRental("N 4511 VS", "Honda Vario", "Motor", 2018, 10000);
        system.tambahB(brent2);
        BarangRental brent3 = new BarangRental("N 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000);
        system.tambahB(brent3);
        BarangRental brent4 = new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000);
        system.tambahB(brent4);
        BarangRental brent5 = new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000);
        system.tambahB(brent5);

        int kode = 0; // Inisiasi kode peminjaman dimulai dari - 1.
        String[] Plats = new String[10];

        Scanner sc = new Scanner(System.in);
        doLoop: do {

            System.out.println("Menu:\n1.Daftar Kendaraan");
            System.out.println("2.Peminjaman");
            System.out.println("3.Tampilkan Seluruh Transaksi");
            System.out.println("4.Urutkan Transaksi Urut no TNKB");
            System.out.println("5.Keluar");
            System.out.print("Pilih (1-5): ");
            int choice = sc.nextInt();

            exitCase:
            switch (choice) {
                // Untuk Menampilkan Daftar Kendaraan
                case 1:
                    System.out.println("|Nomor TNKB\t|Nama Kendaraan\t|Jenis\t|Tahun\t|Biaya Sewa Perjam");
                    system.tampilB();
                    break;
                // Untuk Input Meminjam
                case 2:

                    sc.nextLine();
                    System.out.println("\nMASUKKAN DATA PEMINJAM\n$>");
                    System.out.print("  Masukkan Nama Peminjam : ");
                    String siPinjam = sc.nextLine();
                    System.out.print("  Masukkan Nomer TNKB : ");
                    String nmr = sc.nextLine();

                    boolean adaKah = system.findApakahAda(nmr);

                    if (adaKah == true) {
                        for (int i = 0; i < Plats.length; i++) {
                            if (nmr.equalsIgnoreCase(Plats[i])) {
                                System.out.println("\n===========MAAF==========\nKendaraan Ini Telah Dipinjam\n");
                                break exitCase;
                            } else {
                                if (Plats[i] == null) {
                                    Plats[i] = nmr;
                                    break;
                                }
                            }
                        }

                        boolean apaJenis = system.findSeqSearch(nmr);
                        String sapaNama = system.namanyaSapa(nmr);

                        System.out.print("  Masukkan Lama Pinjam (Jam) : ");
                        int howLong = sc.nextInt();
                        System.out.print("  Apakah Member (Y/N) : ");
                        String yaKah = sc.next();
                        boolean member = false;
                        double total;
                        if (yaKah.equalsIgnoreCase("y")) {
                            member = true;
                        } else {
                            member = false;
                        }
                        if (apaJenis == true) {
                            total = system.hitungTotalMotor(howLong, member);
                        } else {
                            total = system.hitungTotalMobil(howLong, member);
                        }

                        
                        ++kode;
                        relasi = new TransaksiRental(kode, nmr, sapaNama ,siPinjam, howLong, total);
                        system.tambahT(relasi);
                        system.tampilTempT(kode, nmr, siPinjam, howLong, total);
                    } else {
                        System.out.println("\n!!! Nomor TNKB Yang Anda Masukkan Tidak Ada Dalam Daftar !!!\n");
                    }
                    break;
                case 3:
                    if (relasi.namaPeminjam != null) {
                        System.out.println("|Kode\t|No TNKB\t|Nama Barang\t|Nama Peminjam\t|Lama  Pinjam\t|Total Biaya");
                        system.tampilT();

                    } else {
                        System.out.println(
                                "===============================\n\nBelum ada Transaksi yang masuk\n\n===============================");
                    }
                    break;
                case 4:
                    system.Sorting();
                    break;
                case 5:
                    break doLoop;

                default:
                    break;
            }

        } while (true);
    }
}
