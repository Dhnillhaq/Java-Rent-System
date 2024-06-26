public class DaftarRentalan {
    TransaksiRental[] trentalan = new TransaksiRental[10];
    BarangRental[] brentalan = new BarangRental[5];
    String[] Plats = new String[20];
    int idxT, idxB;

    void tambahB(BarangRental b) {
        if (idxB < brentalan.length) {
            brentalan[idxB] = b;
            idxB++;
        } else {
            System.out.println("Data sudh penuh");
        }
    }

    void tampilB() {
        for (BarangRental b : brentalan) {
            b.tampil();
            System.out.println("------------------------------------------------------");
        }
    }

    boolean findApakahAda(String cari) {
        boolean benerGa = false;
        for (int i = 0; i < brentalan.length; i++) {
            if (brentalan[i].noTNKB.equalsIgnoreCase(cari)) {
                benerGa = true;
                break;
            } else {
                benerGa = false;
            }
        }
        return benerGa;
    }

    void tambahTransaksi(String data) {
        for (int i = 0; i < Plats.length; i++) {
            if (Plats[i] == null) {
                Plats[i] = data;
                System.out.println(Plats[i]);
            }
            System.out.println(Plats[0]);
        }
    }

    boolean findSeqSearch(String cari) {
        boolean benerGa = false;
        for (int i = 0; i < brentalan.length; i++) {
            if (brentalan[i].noTNKB.equalsIgnoreCase(cari)) {
                if (brentalan[i].jenisKendaraan.equals("Motor")) {
                    benerGa = true;
                } else {
                    benerGa = false;
                }
            }
        }
        return benerGa;
    }

    String namanyaSapa(String cari) {
        String namanya = "";
        for (int i = 0; i < brentalan.length; i++) {
            if (brentalan[i].noTNKB.equalsIgnoreCase(cari)) {
                namanya = brentalan[i].namaKendaraan;
            }
        }
        return namanya;
    }

    double hitungTotalMotor(int lama, boolean isMember) {
        double harga = 25000;
        double semua = harga * lama;
        if (lama > 48 && lama < 78) {
            semua = semua - (semua * 10 / 100);
        } else if (lama > 78) {
            semua = semua - (semua * 20 / 100);
        }
        if (isMember) {
            semua = semua - 25000;
        }
        return semua;
    }

    double hitungTotalMobil(int lama, boolean isMember) {
        double harga = 40000;
        double semua = harga * lama;
        if (lama > 48 && lama < 78) {
            semua = semua - (semua * 10 / 100);
        } else if (lama > 78) {
            semua = semua - (semua * 20 / 100);
        }
        if (isMember) {
            semua = semua - 25000;
        }
        return semua;
    }

    void tambahT(TransaksiRental t) {
        if (idxT < trentalan.length) {
            trentalan[idxT] = t;
            idxT++;
        } else {
            System.out.println("Data Sudah Penuh");
        }
    }

    void Sorting() {
        if (trentalan[0] == null) {
            System.out.println("\n~~~ DATA BELUM ADA ~~~\n");
        } else if (trentalan[1] != null) {
            for (int i = 0; i < trentalan.length - 1; i++) {
                for (int j = i + 1; j < trentalan.length; j++) {
                    if (trentalan[j] != null) {
                    System.out.println(trentalan[i].nomorTNKB);
                        if (trentalan[i].nomorTNKB.compareTo(trentalan[j].nomorTNKB) > 0) {
                            TransaksiRental temp = trentalan[i];
                            trentalan[i] = trentalan[j];
                            trentalan[j] = temp;
                        }
                    }
                }
            }
            System.out.println("\nDATA SETELAH DIURUTKAN: \n");
            System.out.println("|Kode\t|No TNKB\t|Nama Barang\t|Nama Peminjam\t|Lama  Pinjam\t|Total Biaya");
            tampilT();
        } else {
            System.out.println("DATA MASIH 1");
            System.out.println("|Kode\t|No TNKB\t|Nama Barang\t|Nama Peminjam\t|Lama  Pinjam\t|Total Biaya");
            tampilT();
        }
    }

    void tampilTempT(int kode, String nmr, String name, int howLong, double total) {
        System.out.println("|kode\t|No TNKB\t|Nama Peminjam\t|LamaPinjam\t|Total Biaya");
        System.out.println("|" + kode + "\t|" + nmr + "\t|" + name + "\t\t|" + howLong + "\t\t|" + total);
    }

    void tampilT() {
        for (int i = 0; i < trentalan.length; i++) {
            if (trentalan[i] != null) {
                trentalan[i].tampil();
            }
        }
    }
}
