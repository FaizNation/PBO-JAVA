package Model;

public class Anjing extends pet {
    private String karakterAnjing;
    private int tingkatKepintaran;

    public Anjing(String rasPet, double hargaPet, int stokPet, String jenisPet, int petDibeli, double diskonPet,
            String habitatPet, String karakterAnjing, int tingkatKepintaran) {
        super(rasPet, hargaPet, stokPet, jenisPet, petDibeli, diskonPet, habitatPet);
        setkarakterAnjing(karakterAnjing);
        settingkatKepintaran(tingkatKepintaran);
    }

    public String getkarakterAnjing() {
        return karakterAnjing;
    }

    public void setkarakterAnjing(String karakterAnjing) {
        this.karakterAnjing = karakterAnjing;
    }

    public int gettingkatKepintaran() {
        return tingkatKepintaran;
    }

    public void settingkatKepintaran(int tingkatKepintaran) {
        this.tingkatKepintaran = tingkatKepintaran;
    }

    public void displayInfo() {
        System.out.println("ras Pet : " + getRasPet());
        System.out.println("harga pet : " + getHargaPet());
        System.out.println("stok pet : " + getStokPet());
        System.out.println("jenis pet : " + getJenisPet());
        System.out.println("pet dibeli : " + getPetDibeli());
        System.out.println("diskon pet : " + getdiskonPet());
        System.out.println("karakter Anjing : " + getkarakterAnjing());
        System.out.println("kepintaran Anjing : " + gettingkatKepintaran());

    }
}
