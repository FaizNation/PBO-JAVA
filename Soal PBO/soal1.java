import java.util.ArrayList;

public class soal1 {
    public static void main(String[] args) {
        ArrayList<MenuPet> menuPet = new ArrayList<>();

        menuPet.add(new MenuPet("Anggora", 2500000, "Kucing"));

        for (MenuPet menu : menuPet) {
            System.out.println("\nDiskon: " + menu.hitungDiskon(7) + "%\n");
        }
    }
}

class MnuPet {
    String rasPet;
    double harga;
    String jenis;

    MnuPet(String rasPet, double harga, String jenis) {
        this.rasPet = rasPet;
        this.harga = harga;
        this.jenis = jenis;
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
