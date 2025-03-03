import java.util.ArrayList;

public class listHewan {
    public static void main(String[] args) {
        ArrayList<Hewan> ListHewan = new ArrayList<>();
        ListHewan.add(new Hewan("Kucing", 100000, "Darat"));
        ListHewan.add(new Hewan("Burung", 75000, "Udara"));
        ListHewan.add(new Hewan("Ikan", 50000, "Air"));
   
    for (Hewan hwn : ListHewan) {
            hwn.tampilkanHewan();
            System.out.println("==================================");
        }
    }
        
}
class Hewan {
    String nama;
    double harga;
    String habitat;

    Hewan(String nama, double harga, String habitat) {
        this.nama = nama;
        this.harga = harga;
        this.habitat = habitat;
    }

void tampilkanHewan() {
    System.out.println("Nama: " + this.nama);
    System.out.println("Harga: " + this.harga);
    System.out.println("Habitat: " + this.habitat);
    }

}
