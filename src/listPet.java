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
    public void setCategory (String category) {
        this.category = category;
    }
    public double calculateTotalPrice() {
        double total = harga * jumlahPet;
        double discount = total * discountRate;
        return total - discount;
    }
    public void displayInfo() {
        System.out.println("======================================");
        System.out.println("============ Pet Shop Info ===========");
        System.out.println("======================================");
        System.out.println("Nama            : " + getNama());
        System.out.println("Harga           : " + String.format("Rp %.2f",  getHarga()));
        System.out.println("Jenis           : " + getJenis());
        System.out.println("Pet yang diBeli : " + getJumlahPet());
        System.out.println("Category        : " + getCategory());
        System.out.println("Discount        : " + (getdiscountRate() * 100) + "%");
        System.out.println("Total Harga     : " + String.format("%.2f", calculateTotalPrice()));
        System.out.println("=============== By FAIZ ==============");
        
    }

}
