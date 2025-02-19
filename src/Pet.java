import java.util.ArrayList;

public class Pet {
    public static void main(String[] args) {
        ArrayList<Hewan> ListHewan = new ArrayList<>();
        
        ListHewan.add(new Hewan("Kucing", 100000, "Persia"));
        ListHewan.add(new Hewan("Burung", 75000, "Kenari"));
        ListHewan.add(new Hewan("Ikan", 50000, "Koi"));

        for (Hewan hwn : ListHewan) {
            hwn.tampilkanInfo(7);  // Pastikan metode ini ada di kelas Hewan
            System.out.println("=================================");
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
    
            System.out.println("Nama Hewan: " + this.nama);
            System.out.println("Jenis: " + this.jenis);
            System.out.println("Harga Per Ekor: Rp " + this.harga);
            System.out.println("Jumlah yang dipesan: " + jumlah);
            System.out.println("Diskon: " + diskon + "%");   
            System.out.println("Total Harga: Rp " + hargaDiskon);
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
    

