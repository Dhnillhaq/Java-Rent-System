public class TransaksiRental {;
    int kodeTransaksi, lamaPinjam;
    String namaPeminjam, nomorTNKB, namaKendaraan;
    double totalBiaya;


    public TransaksiRental(int kodeTransaksi, String nomorTNKB, String namaKendaraan, String namaPeminjam, int lamaPinjam, double totalBiaya){
        this.totalBiaya = totalBiaya;
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.nomorTNKB = nomorTNKB;
        this.namaKendaraan = namaKendaraan;
    }

    public TransaksiRental (){

    }

    void tampil(){
        System.out.println("|"+kodeTransaksi+"\t|"+ nomorTNKB+"\t|"+ namaKendaraan+"\t|"+ namaPeminjam+"\t\t|"+ lamaPinjam+"\t\t|"+ totalBiaya);
    }
}
