public class Main {
    public static void main(String[] args) {
        ListHewan listHewan = new ListHewan("Anggora", 3000000, 3, "Kucing", 0.1, "Mamalia");

        listHewan.displayInfo();
        System.out.println("-------------------");

        listHewan.setNama("Love Bird");
        listHewan.setHarga(250000);
        listHewan.setJumlahHewan(2);
        listHewan.setJenis("Burung");
        listHewan.setDiscountRate(0.15);
        listHewan.setCategory("Ungas");

        listHewan.displayInfo();
        System.out.println("-------------------");

        listHewan.setHarga(-5000);
        System.out.println("-------------------");

        listHewan.setJumlahHewan(-2);
        System.out.println("-------------------");

        listHewan.setDiscountRate(1.2);
        System.out.println("-------------------");

        listHewan.displayInfo();
        System.out.println("-------------------");
    }
}
