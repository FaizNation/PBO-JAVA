import java.util.ArrayList;

public class petShop {
    public static void main(String[] args) {
        ArrayList<Hewan> ListHewan = new ArrayList<>();
        ListHewan.add(new Hewan("Persia", 100000, "Kucing"));
        ListHewan.add(new Hewan("Anggora", 75000, "Kucing"));
        ListHewan.add(new Hewan("Buldog", 50000, "Anjing"));
   
    for (Hewan hwn : ListHewan) {
            hwn.tampilkanInfo(7);
            System.out.println("==================================");
        }
    }
        
}
class Hewan {
    String nama;
    double harga;
    String jenis;

    Hewan(String nama, double harga, String jenis) {
        this.nama = nama;
        this.harga = harga;
        this.jenis = jenis;
    }

void tampilkanInfo(int jumlah) {
    double diskon = hitungDiskon(jumlah);
    double hargaDiskon = (this.harga * jumlah) - (this.harga * jumlah * diskon / 100);

    System.out.println("Nama Hewan          : " + this.nama);
    System.out.println("Harga perEkor       : " + this.harga);
    System.out.println("Jenis Hewan         : " + this.jenis);
    System.out.println("Jumlah yang dipesan : " + jumlah);
    System.out.println("Diskon              : " + diskon + "%");
    System.out.println("Total Harga         : Rp " + hargaDiskon);
    }

    double hitungDiskon(int jumlah) {
        if (jumlah >= 10) {
            return 20;
        } else if (jumlah >= 5) {
            return 10;
        } else {
            return 0;
        }
    }

}


