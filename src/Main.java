public class Main {
    public static void main(String[] args) {
        listPet ListPet = new listPet("ANGGORA" ,3000000, 3, "Kucing", 0.1, "Mamalia");

        ListPet.displayInfo();
        System.out.println("======================================");

        ListPet.setNama("Love Bird");
        ListPet.setHarga(25000);
        ListPet.setJumlahPet(2);
        ListPet.setJenis("Burung");
        ListPet.setdiscountRate(0.15);
        ListPet.setCategory("unggas");

        ListPet.displayInfo();
        System.out.println("======================================");

        ListPet.setHarga(-5000);
        System.out.println("======================================");
        
        ListPet.setJumlahPet(2);
        System.out.println("======================================");

        ListPet.setdiscountRate(-1.2);
        System.out.println("======================================");

        ListPet.displayInfo();
        System.out.println("**************************************");
    


    }
}
