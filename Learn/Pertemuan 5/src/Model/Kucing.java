package Model;

public class Kucing extends pet {
    private String warnaBulu;
    private int umurKucing;

    public Kucing(String rasPet, double hargaPet, int stokPet, String jenisPet, int petDibeli, double diskonPet,
            String habitatPet, String warnaBulu, int umurKucing) {
        super(rasPet, hargaPet, stokPet, jenisPet, petDibeli, diskonPet, habitatPet);
        setWarnaBulu(warnaBulu);
        setUmurKucing(umurKucing);
    }

    public String getWarnaBulu() {
        return warnaBulu;
    }

    public void setWarnaBulu(String warnaBulu) {
        this.warnaBulu = warnaBulu;
    }

    public int getUmurKucing() {
        return umurKucing;
    }

    public void setUmurKucing(int umurKucing) {
        this.umurKucing = umurKucing;
    }

    public void displayInfo() {
        System.out.println("ras Pet : " + getRasPet());
        System.out.println("harga pet : " + getHargaPet());
        System.out.println("stok pet : " + getStokPet());
        System.out.println("jenis pet : " + getJenisPet());
        System.out.println("pet dibeli : " + getPetDibeli());
        System.out.println("diskon pet : " + getdiskonPet());
        System.out.println("warna bulu kucing : " + getWarnaBulu());
        System.out.println("umur kucing : " + getUmurKucing());

    }
}
