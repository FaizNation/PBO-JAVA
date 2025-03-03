import java.util.ArrayList;

public class petList {
        private String rasPet;
        private double hargaPet;
        protected int stokPet;
        private String jenisPet;
        protected int petDibeli;
        protected double diskonPet;

        String habitatPet;

        // 🔹 Konstruktor
        public petList(
                        String rasPet,
                        double hargaPet,
                        int stokPet,
                        String jenisPet,
                        double diskonPet,
                        String habitatPet) {

                this.rasPet = rasPet;
                this.hargaPet = hargaPet;
                this.stokPet = stokPet;
                this.jenisPet = jenisPet;
                this.diskonPet = diskonPet;
                this.habitatPet = habitatPet;
        }

        // 🔹 Getter dan Setter
        public String getrasPet() {
                return rasPet;
        }

        public void setrasPet(String rasPet) {
                this.rasPet = rasPet;
        }

        public double getHargaPet() {
                return hargaPet;
        }

        public void setHargaPet(double hargaPet) {
                if (hargaPet >= 0) {
                        this.hargaPet = hargaPet;
                } else {
                        System.out.println("Harga tidak boleh negatif");
                }
        }

        public int getStokPet() {
                return stokPet;
        }

        public void setStokPet(int stokPet) {
                this.stokPet = stokPet;
        }

        public String getjenisPet() {
                return jenisPet;
        }

        public void setjenisPet(String jenisPet) {
                this.jenisPet = jenisPet;
        }

        public int getPetDibeli() {
                if (petDibeli > stokPet) {
                        System.out.println("Stok tidak mencukupi");
                        return 0;
                } else {
                        return petDibeli;
                }
        }

        public double getDiskonPet() {
                return diskonPet;
        }

        public void setDiskonPet(double diskonPet) {
                if (diskonPet >= 0 && diskonPet <= 1) {
                        this.diskonPet = diskonPet;
                } else {
                        System.out.println("Diskon harus diantara 0 dan 1");
                }
        }

        public String getHabitatPet() {
                return habitatPet;
        }

        public void setHabitatPet(String habitatPet) {
                this.habitatPet = habitatPet;
        }

        // 🔹 Menghitung Total Harga Setelah Diskon
        protected double totalHarga() {
                double total = this.hargaPet * this.stokPet;
                double diskon = total * this.diskonPet;
                return total - diskon;
        }

        // 🔹 Mengurangi Stok Setelah Pembelian
        public void kurangiStok(int jumlah) {
                if (jumlah >= 0 && jumlah <= this.stokPet) {
                        stokPet -= jumlah;
                        System.out.println(
                                        "\n╔=======================================================================╗");
                        System.out.println("|                         PEMBELIAN BERHASIL                            |");
                        System.out.println("|=======================================================================|");
                        System.out.printf("| %-69s |\n",
                                        "                   Selamat " + jumlah + " Pet berhasil dibeli");
                        System.out.printf("| %-69s |\n", "          stok pet " + rasPet + " tersisa saat ini adalah: "
                                        + stokPet + " stok");
                        System.out.println("|=======================================================================|");
                } else if (jumlah > this.stokPet) {
                        System.out.println("Stok tidak mencukupi, hanya tersedia" + stokPet + "pet");
                } else {
                        System.out.println("Jumlah tidak valid");
                }
        }

        // 🔹 Mencari Pet Berdasarkan Harga
        public static petList cariPetList(ArrayList<petList> List, double hargaPet) {
                for (petList pet : List) {
                        if (pet.getHargaPet() == hargaPet) {
                                return pet;
                        }
                }
                return null;
        }

        // 🔹 Mencari Pet Berdasarkan Jenis & Ras
        public static petList cariPetListJenis(ArrayList<petList> List, String jenisPet, String rasPet) {
                for (petList pet : List) {
                        if (pet.getjenisPet().equalsIgnoreCase(jenisPet) && pet.getrasPet().equalsIgnoreCase(rasPet)) {
                                return pet;
                        }
                }
                return null;
        }

        // 🔹 QuickSort Berdasarkan Jenis Pet
        public static ArrayList<petList> quickSort(ArrayList<petList> lsst) {
                quickSortLoop(lsst, 0, lsst.size() - 1);
                return lsst;
        }

        private static void quickSortLoop(ArrayList<petList> List, int low, int high) {
                if (low < high) {
                        int pivotIndex = partition(List, low, high);
                        quickSortLoop(List, low, pivotIndex - 1);
                        quickSortLoop(List, pivotIndex + 1, high);
                }
        }

        private static int partition(ArrayList<petList> List, int low, int high) {
                String pivot = List.get(high).getjenisPet();
                int i = low - 1;
                for (int j = low; j < high; j++) {
                        if (List.get(j).getjenisPet().compareTo(pivot) <= 0) {
                                i++;
                                petList temp = List.get(i);
                                List.set(i, List.get(j));
                                List.set(j, temp);
                        }
                }
                petList temp = List.get(i + 1);
                List.set(i + 1, List.get(high));
                List.set(high, temp);
                return i + 1;
        }

        // 🔹 Menampilkan Data Pet
        @Override
        public String toString() {
                return "Ras: " + rasPet +
                                "\nHarga: " + hargaPet +
                                "\nStok: " + stokPet +
                                "\nJenis: " + jenisPet +
                                "\nUkuran: " + rasPet +
                                "\nDiskon: " + (diskonPet * 100) + "%" +
                                "\nHabitat: " + habitatPet + "\n";
        }
}
