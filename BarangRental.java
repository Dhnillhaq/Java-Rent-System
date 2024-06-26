public class BarangRental {
    String noTNKB, namaKendaraan, jenisKendaraan;
    int tahun, biayaSewa;
    
    public BarangRental(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int sewa){
        this.noTNKB = noTNKB;
        this.tahun = tahun;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.biayaSewa = sewa;
    }
    
    void tampil(){
        System.out.println("|"+noTNKB+"\t|"+ namaKendaraan+"\t|"+ jenisKendaraan+"\t|"+ tahun +"\t|"+biayaSewa);
    }


}