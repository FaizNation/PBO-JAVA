import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Membuat list untuk menyimpan objek MenuPet
        ArrayList<MenuPet> menuList = new ArrayList<>();

        // Menambahkan objek MenuPetke dalam list
        menuList.add(new MenuPet("Anggora", 2500000, "Kucing"));
        menuList.add(new MenuPet("Husky", 3000000, "Anjing"));
        menuList.add(new MenuPet("Arwana", 2000000, "Ikan"));

        // Menampilkan informasi setiap menu pet dan menghitung harga total berdasarkan jumlah order
        for (MenuPet menu : menuList){
            menu.tampilkanInfoDanHargaDiskon(7);
            System.out.println("==============================================");
        }
    }
}

// Class MenuPet
class MenuPet{
    // Atribut
    String rasPet;
    double harga;
    String jenis;

    // Constructor untuk menginisialisasi objek ManuPet
    MenuPet(String rasPet, double harga, String jenis){
        this.rasPet = rasPet;
        this.harga = harga;
        this.jenis = jenis;
    }

    // Metode pertama: Menampilkan informasi Pet dan menghitung diskon berdasarkan jumlah order
    void tampilkanInfoDanHargaDiskon(int jumlah){
        double diskon = hitungDiskon(jumlah);
        double hargaDiskon = (this.harga * jumlah) - (this.harga * jumlah * diskon/100);

        System.out.println("Nama Makanan: " + this.rasPet);
        System.out.println("Harga per unit: Rp " + this.harga);
        System.out.println("Jumlah yang dipesan: " + jumlah);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Total harga setelah diskon: Rp " + hargaDiskon);
    }

    // Metode kedua: Menghitung diskon berdasarkan jumlah order
    double hitungDiskon(int jumlah) {
        if (jumlah >= 10) {
            return 20; // Diskon 20% jika order 10 atau lebih
        } else if (jumlah >= 5) {
            return 10; // Diskon 10% jika order 5 atau lebih
        } else {
            return 0; // Tidak ada diskon jika kurang 5
        }
    }
}