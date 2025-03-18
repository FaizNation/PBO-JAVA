package Model;

public class pet {
    private String rasPet;
    private double hargaPet;
    protected int stokPet;
    private String jenisPet;
    protected int petDibeli;
    protected double diskonPet;

    String habitatPet;

    public pet(String rasPet, double hargaPet, int stokPet, String jenisPet, int petDibeli, double diskonPet,
            String habitatPet) {
        setRasPet(rasPet);
        setHargaPet(hargaPet);
        setStokPet(stokPet);
        setJenisPet(jenisPet);
        setPetDibeli(petDibeli);
        setDiskonPet(diskonPet);
        setHabitatPet(habitatPet);
    }

    public String getRasPet() {
        return rasPet;
    }

    public void setRasPet(String rasPet) {
        this.rasPet = rasPet;
    }

    public double getHargaPet() {
        return hargaPet;
    }

    public void setHargaPet(double hargaPet) {
        this.hargaPet = hargaPet;
    }

    public int getStokPet() {
        return stokPet;
    }

    public void setStokPet(int stokPet) {
        this.stokPet = stokPet;
    }

    public String getJenisPet() {
        return jenisPet;
    }

    public void setJenisPet(String jenisPet) {
        this.jenisPet = jenisPet;
    }

    public int getPetDibeli() {
        return petDibeli;
    }

    public void setPetDibeli(int petDibeli) {
        this.petDibeli = petDibeli;
    }

    public double getdiskonPet() {
        return diskonPet;
    }

    public void setDiskonPet(double diskonPet) {
        this.diskonPet = diskonPet;
    }

    public String getHabitatPet() {
        return habitatPet;
    }

    public void setHabitatPet(String habitatPet) {
        this.habitatPet = habitatPet;
    }
}
