import Model.Kucing;
import Model.Anjing;

public class Main {
    public static void main(String[] args) throws Exception {

        //membuat object anjing
        Anjing anjing = new Anjing(  
            "Bulldog", 
            3000000, 
            5, 
            "Anjing", 
            0, 
            1.5, 
            "Darat", 
            "Galak", 
            20);

        System.out.println("Informasi anjing");
        anjing.displayInfo();
        System.out.println();

        //membuat object kucing
        Kucing kucing = new Kucing(
            "Anggora", 
            25000000, 
            7, 
            "Kucing", 
            0,
            0, 
            "Darat", 
            "Putih orange", 
            5);

        System.out.println("Informasi kucing");
        kucing.displayInfo();
        System.out.println();

        //Mengubah informasi anjing
        anjing.setRasPet("Golden Retriever");
        anjing.setHargaPet(40000000);
        anjing.setStokPet(2);
        anjing.setJenisPet("Anjing");
        anjing.setPetDibeli(2);
        anjing.setDiskonPet(2.0);
        anjing.setHabitatPet("-");
        anjing.setkarakterAnjing("Penurut");
        anjing.settingkatKepintaran(80);
        System.out.println("Informasi anjing setelah diubah");
        anjing.displayInfo();
        System.out.println();

        //Mengubah informasi kucing
        kucing.setRasPet("Oyen");
        kucing.setHargaPet(250000);
        kucing.setStokPet(15);
        kucing.setDiskonPet(0);
        kucing.setJenisPet("-");
        kucing.setPetDibeli(0);
        kucing.setHabitatPet("Darat");
        kucing.setWarnaBulu("orange");
        kucing.setUmurKucing(30);
        System.out.println("informasi kucing setelah diubah");
        kucing.displayInfo();
        System.out.println();
    }
}
