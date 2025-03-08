
public class ListHewan {
    private String nama;
    private double harga;  
    private int jumlahHewan;
    private String jenis;
    protected double discountRate;

    String category;
    public ListHewan(String nama, double harga, int jumlahHewan, String jenis, double discountRate, String category) {
        this.nama = nama;
        this.harga = harga;
        this.jumlahHewan = jumlahHewan;
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
            System.out.println("[ERROR] Harga yang dimasukkan tidak valid");
        }
    }
    public int getJumlahHewan() {
        return jumlahHewan;
    }
    public void setJumlahHewan(int jumlahHewan) {
        if (jumlahHewan >= 0) {
            this.jumlahHewan = jumlahHewan;
        } else {
            System.out.println("[ERROR] Jumlah hewan harus lebih dari 0");
        }
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    protected double getDiscountRate() {
        return discountRate;
    }
    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 1) {
            this.discountRate = discountRate;
        } else {
            System.out.println("[ERROR] Diskon yang dimasukkan tidak valid");
        }
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double calculateTotalPrice() {
        double total = harga * jumlahHewan;
        double discount = total * discountRate;
        return total - discount;
    }

    public void displayInfo() {
        System.out.println("Informasi hewan yang dipesan");
        System.out.println("Nama Hewan : " + getNama());
        System.out.println("Jenis Hewan : " + getJenis());
        System.out.println("Harga PerEkor: " + String.format("Rp %.2f", getHarga()));
        System.out.println("Jumlah yang dipesan: " + getJumlahHewan());
        System.out.println("Category: " + getCategory());
        System.out.println("Diskon: " + (getDiscountRate() * 100) + "%");
        System.out.println("Total Harga: Rp " + String.format("%.2f", calculateTotalPrice()));
    }

}
