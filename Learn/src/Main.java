import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<listPet> ListPet = new ArrayList<>();

        ListPet.add(new listPet("Persia", 100000, 7, "Kucing", 20, "Hewan"));
        ListPet.add(new listPet("Anggora", 75000, 5, "Kucing", 10, "Hewan"));
        ListPet.add(new listPet("Buldog", 50000, 3, "Anjing", 0, "Hewan"));
        ListPet.add(new listPet("Kakatua", 200000, 2, "Burung", 0, "Hewan"));
        ListPet.add(new listPet("Cucak Ijo", 150000, 4, "Burung", 10, "Hewan"));

        System.out.println("Daftar Pet sebelum di sorting");
        for (listPet m : ListPet) {
            System.out.println(m);
        }

        ListPet.sort(Comparator.comparingDouble(listPet::getHarga));

        System.out.println("\nDaftar Pet setelah di sorting (harga rendah)");
        for (listPet m : ListPet) {
            System.out.println(m);
        }

        listPet petEdit = ListPet.get(1);
        petEdit.setNama("Rumahan");
        petEdit.setHarga(80000);
        petEdit.setJumlahPet(10);
        petEdit.setCategory("Hewan");
        petEdit.setdiscountRate(15);
        System.out.println("\nSetelah megubah data pet " + petEdit.getNama() + " menjadi:");
        System.out.println(petEdit);

        listPet.carListPet(ListPet, 00000);
        double hargaDicari = 75000;
        listPet petDitemukan = listPet.carListPet(ListPet, hargaDicari);

        if (petDitemukan != null) {
            System.out.println("\nData " + hargaDicari + " ditemukan dalam listPet");
            System.out.println(petDitemukan);
        } else {
            System.out.println("\nData " + hargaDicari + " tidak ditemukan dalam listPet");
        }

        ListPet.sort(Comparator.comparing(listPet::getJumlahPet));
        System.out.println("\nDaftar Pet setelah di sorting (jumlah rendah)");
        for (listPet m : ListPet) {
            System.out.println(m);
        }

        ArrayList<listPet> quickSorted = listPet.quickSort(ListPet);    
        System.out.println("\nDaftar Pet menggunakan method baru");
        for (listPet m : quickSorted) {
            System.out.println(m);
        }   
    }
}
