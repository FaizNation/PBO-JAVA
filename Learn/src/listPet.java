
import java.util.ArrayList;

public class listPet {
    private String nama;
    private double harga;
    private int jumlahPet;
    private String jenis;
    protected double discountRate;

    String category;

    public listPet(String nama, double harga, int jumlahPet, String jenis, double discountRate, String category) {
        this.nama = nama;
        this.harga = harga;
        this.jumlahPet = jumlahPet;
        this.jenis = jenis;
        this.discountRate = discountRate;
        this.category = category;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("[ERROR] harga yang dimasukan tidak valid!");
        }
    }

    public int getJumlahPet() {
        return jumlahPet;
    }

    public void setJumlahPet(int jumlahPet) {
        if (jumlahPet >= 0) {
            this.jumlahPet = jumlahPet;
        } else {
            System.out.println("[ERROR] jumlah hewan harus lebih dari 0!");
        }
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    protected double getdiscountRate() {
        return discountRate;
    }

    public void setdiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 1) {
            this.discountRate = discountRate;
        } else {
            System.out.println("[ERROR] discount rate tidak valid!");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static listPet carListPet(ArrayList<listPet> daftar, double harga) {
        for (listPet m : daftar) {
            if (Double.compare(m.getHarga(), harga) == 0) {
                return m;
            }
        }
        System.out.println("\nPet Pet dengan harga " + harga + "tidak ditemukan");
        return null;
    }

    public static ArrayList<listPet> quickSort(ArrayList<listPet> list) {
        quickSortLoop(list, 0, list.size() - 1);
        return list;
    }

    public static void quickSortLoop(ArrayList<listPet> daftar, int low, int high) {
        if (low < high) {
            int pi = partition(daftar, low, high);
            quickSortLoop(daftar, low, pi - 1);
            quickSortLoop(daftar, pi + 1, high);
        }
    }

    private static int partition(ArrayList<listPet> daftar, int low, int high) {
        String pivot = daftar.get(high).getNama();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (daftar.get(j).getNama().compareTo(pivot) <= 0) {
                i++;
                listPet temp = daftar.get(i);
                daftar.set(i, daftar.get(j));
                daftar.set(j, temp);
            }
        }

        listPet temp = daftar.get(i + 1);
        daftar.set(i + 1, daftar.get(i + 1));
        daftar.set(high, temp);

        return i + 1;
    }

    public double calculateTotalPrice() {
        double total = harga * jumlahPet;
        double discount = total * discountRate;
        return total - discount;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + " harga :" + harga + " Jumlah Pet: " + jumlahPet + " Jenis: " + jenis + " discount: "
                + discountRate + " Kategori: " + category;

    }
}
