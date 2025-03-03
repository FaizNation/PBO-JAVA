import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class petOPia {
    // 🐾 ArrayList untuk menyimpan daftar pet yang tersedia 🐾
    static ArrayList<petList> lisPet = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        dislpayJudul();// 🎉 menampilkan judul aplikasi 🎉
        try (Scanner scanner = new Scanner(System.in)) {

            // 📌 Menambahkan daftar pet awal ke dalam list 📌
            // 😺 LIST KUCING 😺
            lisPet.add(new petList("Persia", 1500000, 10, "Kucing", 0.1, "darat"));
            lisPet.add(new petList("Anggora", 1400000, 8, "Kucing", 0.08, "darat"));
            lisPet.add(new petList("Maine coon", 1800000, 5, "Kucing", 0.12, "darat"));
            // 🐶 LIST ANJING 🐶
            lisPet.add(new petList("Golden", 3000000, 5, "Anjing", 0.1, "darat"));
            lisPet.add(new petList("Husky", 3000000, 4, "Anjing", 0.1, "darat"));
            lisPet.add(new petList("Bulldog", 3000000, 6, "Anjing", 0.1, "darat"));
            // 🐟 LIST IKAN 🐟
            lisPet.add(new petList("Koi", 500000, 20, "Ikan", 0.1, "Air"));
            lisPet.add(new petList("Arwana", 200000, 20, "Ikan", 0.1, "Air"));
            lisPet.add(new petList("Cupang", 25000, 50, "Ikan", 0.1, "Air"));
            // 🐦 LIST BURUNG 🐦
            lisPet.add(new petList("Kakaktua", 2500000, 8, "Burung", 0.1, "udara"));
            lisPet.add(new petList("Beo", 1500000, 15, "Burung", 0.1, "udara"));
            lisPet.add(new petList("Kenari", 500000, 28, "Burung", 0.1, "udara"));

            while (true) { // 🔄 Looping menu utama 🔄 
                try {
                    displayMenu(); // 📜 menampilkan menu utama 📜
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();
                    switch (pilihan) { // 🔀 switch case untuk percabangan 🔀
                        case 1:
                            displayPets(scanner); // 🐶 menampilkan menu pet 🐶
                            break;
                        case 2:
                            displayCari(scanner); // 🔍 menampilkan menu cari pet 🔍
                            break;
                        case 3:
                            editPet(scanner); // ✏️ menampilkan menu edit pet ✏️
                            break;
                        case 4:
                            beliPet(scanner); // 💰 menampilkan menu beli pet 💰
                            break;
                        case 5:
                            displayFaizNation(); // 😎 menampilkan by faiz nation 😎
                            return;
                        default:
                            // ❌ Menampilkan pesan error jika pilihan tidak valid ❌

                            System.out.println(
                                    "╔=======================================================================╗");
                            System.out.printf("| %-69s |\n", " [ERROR] | INPUT TIDAK VALID, SILAHKAN COBALAGI.");
                            System.out.println(
                                    "╚=======================================================================╝");
                    }
                } catch (InputMismatchException e) {
                    // 🛑 Catch untuk menangani kesalahan jika input bukan angka 🛑
                    System.out.println("╔=======================================================================╗");
                    System.out.printf("| %-69s |\n", " [ERROR] | INPUT HARUS ANGKA, SILAHKAN COBA ULANGI DARI MENU.");
                    System.out.println("╚=======================================================================╝");
                    scanner.nextLine();

                }
            }

        }

    }

    // 📌================================📋 Function 📋================================📌
    public static void dislpayJudul() {
        System.out.println("╔=======================================================================╗");
        System.out.println("|>>>                       SELAMAT DATANG DI                         <<<|");
        System.out.println("|>>                         <<< PETOPIA >>>                           <<|");
        System.out.println("|>>>                   Temukan Sahabat Terbaikmu                     <<<|");
        System.out.println("╚=======================================================================╝");
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayMenu() {
        System.out.println("\n╔=======================================================================╗");
        System.out.println("|                                MENU                                   |");
        System.out.println("╚=======================================================================╝");
        System.out.println("╔=======================================================================╗");
        System.out.println("|  1. | Tampilkan ras pet                                               |");
        System.out.println("|  2. | Cari pet                                                        |");
        System.out.println("|  3. | edit pet                                                        |");
        System.out.println("|  4. | Beli pet                                                        |");
        System.out.println("|  5. | Keluar                                                          |");
        System.out.println("╚=======================================================================╝");
        System.out.print("Pilihan: ");

    }

    // 📌================================📋 Function 📋================================📌
    public static void displayPets(Scanner scanner) {
        while (true) {
            displayMenuTampilkan();// 🐾 Menampilkan menu untuk menampilkan daftar pet 🐾
            int PilihDisplayPets = scanner.nextInt();
            scanner.nextLine();
            switch (PilihDisplayPets) {
                case 1:
                    displayAllPets();// 📋 Menampilkan semua pet 📋
                    break;
                case 2:
                    displayPetsHarga();// 💰 Menampilkan pet berdasarkan harga 💰
                    break;
                case 0:
                    return;// 🔙 Kembali ke menu utama 🔙
            }

        }
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayAllPets() {
        int i = 1;
        if (lisPet == null || lisPet.isEmpty()) {
            System.out.println("╔=======================================================================╗");
            System.out.println("|                     Tidak ada data pet yang tersedia                  |");
            System.out.println("╚=======================================================================╝");
            return;
        } else {

            System.out.println("╔=======================================================================╗");
            System.out.println("|                           Daftar Semua Pet                            |");
            System.out.println("|=======================================================================|");
            System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Habitat");
            System.out.println("|-----|---------------|-------------------|------|-----------|----------|");
            // 🔄 Loop untuk menampilkan setiap pet dalam daftar 🔄
            for (petList pet : lisPet) {
                // 💰 Format harga dan replace untuk mengubah harga agar lebih rapi dalam
                // tampilan
                String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                        pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                        pet.getDiskonPet() * 100, pet.getHabitatPet());
                i++; // 🔢 Menambah nomor urut

            }
            System.out.println("╚=======================================================================╝");
        }

    }

    // 📌================================📋 Function 📋================================📌
    public static void displayCari(Scanner scanner) {

        while (true) {
            displayMenuCari();
            int Cari = scanner.nextInt();
            scanner.nextLine();
            switch (Cari) {
                case 1:
                    displayCariPetHarga(scanner, lisPet); // 🔍 cari berdasar harga 🔍
                    break;
                case 2:
                    displayCariPetJenis(scanner, lisPet);// 🔍 cari berdasar jenis 🔍
                    break;
                case 0:
                    return;
            }
        }
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayCariPetHarga(Scanner scanner, ArrayList<petList> lispet) {
        System.out.print("Masukkan harga pet yang dicari: ");
        double hargaDicari = scanner.nextDouble();
        scanner.nextLine();

        // 🔎 Panggil cariPetList dari class petList untuk mencari pet berdasarkan harga
  
        petList petDitemukan = petList.cariPetList(lisPet, hargaDicari);

        if (petDitemukan != null) {
            int i = 1;// 📌 Untuk penomoran daftar 📌
            System.out.println("╔=======================================================================╗");
            System.out.printf("| %-69s |\n", "             Data pet dengan harga Rp" + hargaDicari + " ditemukan");
            System.out.println("|=======================================================================|");
            System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Habitat");
            System.out.println("|-----|---------------|-------------------|------|-----------|----------|");
            // 💰 Format harga agar lebih rapi (menggunakan koma sebagai pemisah ribuan) 💰
            String hargaFormatted = String.format("%, .2f", petDitemukan.getHargaPet()).replace(",", ".");
            System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                    petDitemukan.getrasPet(), hargaFormatted, petDitemukan.getStokPet(),
                    petDitemukan.getDiskonPet() * 100, petDitemukan.getHabitatPet());
            i++;
            System.out.println("╚=======================================================================╝");
        } else {
            // ⚠️ Jika pet tidak ditemukan ⚠️
            System.out.println("\n╔=======================================================================╗");
            System.out.printf("| %-69s |\n",
                    " [ERROR] | Data pet dengan harga Rp" + hargaDicari + " tidak ditemukan.  |");
            System.out.println("╚=======================================================================╝");
        }

    }

    // 📌================================📋 Function 📋================================📌

    public static void displayCariPetJenis(Scanner scanner, ArrayList<petList> listPet) {
        System.out.print("\nMasukkan jenis pet yang dicari: ");// 📌 Manipulasi string untuk mengkorversi huruf jadi kecil 📌
        String jenisDicari = scanner.nextLine().toLowerCase();

        System.out.print("Masukkan ras pet yang dicari: ");
        String rasDicari = scanner.nextLine().toLowerCase();

        // 🔄 Searching menggunakan Comparator 🔄
        petList petDitemukan = petList.cariPetListJenis(listPet, jenisDicari, rasDicari);

        if (petDitemukan != null) {
            int i = 1;
            System.out.println("╔=======================================================================╗");
            System.out.printf("| %-69s |\n",
                    "    Data pet ditemukan berdasarkan jenis '" + jenisDicari + "' dan ras '" + rasDicari);
            System.out.println("|=======================================================================|");
            System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Habitat");
            System.out.println("|-----|---------------|-------------------|------|-----------|----------|");
            String hargaFormatted = String.format("%, .2f", petDitemukan.getHargaPet()).replace(",", ".");
            System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                    petDitemukan.getrasPet(), hargaFormatted, petDitemukan.getStokPet(),
                    petDitemukan.getDiskonPet() * 100, petDitemukan.getHabitatPet());
            System.out.println("╚=======================================================================╝");
            i++;
        } else {
            // ⚠️ Jika pet tidak ditemukan ⚠️
            System.out.println("\nPet dengan jenis '" + jenisDicari + "' dan ras '" + rasDicari + "' tidak ditemukan.");
        }
    }

    // 📌================================📋 Function 📋================================📌
    public static void beliPet(Scanner scanner) {
        System.out.println("\n╔=======================================================================╗");
        System.out.println("|                  Silahkan pilih Pet yang Anda Suka!                   |");
        System.out.println("╚=======================================================================╝");
        displayAllPets(); // 🐾 Tampilkan daftar pet sebelum membeli 🐾

        ArrayList<petList> keranjang = new ArrayList<>();
        ArrayList<Integer> jumlahBeliList = new ArrayList<>();
        boolean beliLagi = true;

        while (beliLagi) {
            System.out.print("\nMasukkan nama ras pet yang ingin dibeli: ");
            String rasPet = scanner.nextLine();

            // 🐶 Cari pet berdasarkan ras 🐶
            petList petDitemukan = null;
            for (petList pet : lisPet) {
                if (pet.getrasPet().equalsIgnoreCase(rasPet)) {
                    petDitemukan = pet;
                    break;
                }
            }

            if (petDitemukan != null) {
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlahBeli = scanner.nextInt();
                scanner.nextLine();

                if (jumlahBeli > 0 && jumlahBeli <= petDitemukan.getStokPet()) {
                    keranjang.add(petDitemukan);
                    jumlahBeliList.add(jumlahBeli);
                    petDitemukan.setStokPet(petDitemukan.getStokPet() - jumlahBeli);
                    System.out.println("╔=======================================================================╗");
                    System.out.printf("| %-69s |\n", jumlahBeli + " [SUCCESS] | ekor " + petDitemukan.getrasPet()
                            + " telah ditambahkan ke keranjang.");
                    System.out.println("╚=======================================================================╝");
                } else {
                    System.out.println("╔=======================================================================╗");
                    System.out.printf("| %-69s |\n", " [ERROR] | Maaf, stok tidak mencukupi atau jumlah tidak valid.");
                    System.out.println("╚=======================================================================╝");
                }
            } else {
                System.out.println("╔=======================================================================╗");
                System.out.printf("| %-69s |\n", " [ERROR] | Pet dengan ras '" + rasPet + "' tidak ditemukan.");
                System.out.println("╚=======================================================================╝");
            }

            System.out.print("Ingin beli pet lain? (true/false): ");
            beliLagi = scanner.nextBoolean();
            scanner.nextLine();
        }

        // 📜 Tampilkan detail pembelian 📜
        if (!keranjang.isEmpty()) {
            double totalHarga = 0;
            double totalDiskon = 0;

            System.out.println("\n╔=======================================================================╗");
            System.out.println("|                         Detail Pembelian Pet                          |");
            System.out.println("|=======================================================================|");
            System.out.printf("| %-15s | %-8s | %-15s | %-22s |\n", "Ras Pet", "Jumlah", "Harga Satuan",
                    "       Subtotal");
            System.out.println("|-----------------|----------|-----------------|------------------------|");

            for (int i = 0; i < keranjang.size(); i++) {
                petList pet = keranjang.get(i);
                int jumlah = jumlahBeliList.get(i);
                double hargaAsli = pet.getHargaPet() * jumlah;
                double diskon = hargaAsli * pet.getDiskonPet();
                double hargaTotal = hargaAsli - diskon;

                String subtotalFormatted = String.format("%,.2f", hargaTotal).replace(",", ".");
                ;
                String hargaFormatted = String.format("%,.2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("| %-15s | %-8d | Rp%-13s | Rp%-20s |\n",
                        pet.getrasPet(), jumlah, hargaFormatted, subtotalFormatted);

                totalHarga += hargaTotal;
                totalDiskon += diskon;
            }
            String totalDiskonFormatted = String.format("%,.2f", totalDiskon).replace(",", ".");
            String totalHargaFormatted = String.format("%,.2f", totalHarga).replace(",", ".");
            System.out.println("|=======================================================================|");
            System.out.printf("| %-44s : Rp%-20s |\n", "Total Diskon", totalDiskonFormatted);
            System.out.printf("| %-44s : Rp%-20s |\n", "Total Bayar", totalHargaFormatted);
            System.out.println("╚=======================================================================╝");

            System.out.println("\n╔=======================================================================╗");
            System.out.println("|             Pembelian berhasil! Stok pet telah diperbarui             |");
            System.out.println("╚=======================================================================╝");
            System.out.println("\n╔=======================================================================╗");
            System.out.println("|                                                                       |");
            System.out.println("|                Terimakasih Telah Membeli Pet Di Petopia               |");
            System.out.println("|                                                                       |");
            System.out.println("╚=======================================================================╝");
        } else {
            System.out.println("\n╔=======================================================================╗");
            System.out.println("|                         Pembelian dibatalkan.                         |");
            System.out.println("╚=======================================================================╝");
        }
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayPetsHarga() {
        // 🔄 Sorting menggunakan Comparator 🔄
        lisPet.sort(Comparator.comparingDouble(petList::getHargaPet));
        int i = 1;
        System.out.println("╔=======================================================================╗");
        System.out.println("|                Daftar Semua Pet Berdasar Harga Termurah               |");
        System.out.println("|=======================================================================|");
        System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                "No", "Ras", "Harga", "Stok", "Diskon", "Habitat");
        System.out.println("|-----|---------------|-------------------|------|-----------|----------|");
        // 📜 Menampilkan daftar mahasiswa setelah sorting 📜
        for (petList pet : lisPet) {
            String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
            System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                    pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                    pet.getDiskonPet() * 100, pet.getHabitatPet());
            i++;

        }
        System.out.println("╚=======================================================================╝");
    }

    // 📌================================📋 Function 📋================================📌
    public static void editPet(Scanner scanner) {
        displayAllPets();
        System.out.print("\nMasukkan nomor pet yang ingin diedit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < lisPet.size()) {
            petList petEdit = lisPet.get(index);
            boolean editing = true;

            while (editing) {
                System.out.println("\n╔=======================================================================╗");
                System.out.printf("| %-69s |\n", "                         Mengedit pet: " + petEdit.getrasPet());
                displayMenuEdit();
                int subPilihan = scanner.nextInt();
                scanner.nextLine();
                // ✏️ Mengubah nilai mahasiswa menggunakan setter & switch case ✏️
                switch (subPilihan) {
                    case 1:
                        System.out.print("Masukkan nama baru: ");
                        String namaBaru = scanner.nextLine();
                        petEdit.setrasPet(namaBaru);
                        break;
                    case 2:
                        System.out.print("Masukkan harga baru: ");
                        double hargaBaru = scanner.nextDouble();
                        petEdit.setHargaPet(hargaBaru);
                        break;
                    case 3:
                        System.out.print("Masukkan stok baru: ");
                        int stokBaru = scanner.nextInt();
                        petEdit.setStokPet(stokBaru);
                        break;
                    case 4:
                        System.out.print("Masukkan jenis baru: ");
                        String jenisBaru = scanner.nextLine();
                        petEdit.setjenisPet(jenisBaru);
                        break;
                    case 5:
                        System.out.print("Masukkan diskon baru (dalam %): ");
                        double diskonBaru = scanner.nextDouble() / 100;
                        petEdit.setDiskonPet(diskonBaru);
                        break;
                    case 6:
                        System.out.print("Masukkan habitat baru: ");
                        String habitatBaru = scanner.nextLine();
                        petEdit.setHabitatPet(habitatBaru);
                        break;
                    case 7:
                        editing = false;
                        System.out
                                .println("\n╔=======================================================================╗");
                        System.out.println("|                   [SUCCESS] | BERHASIL MENGEDIT PET                   |");
                        System.out.println("╚=======================================================================╝");
                        break;
                    default:
                        System.out
                                .println("\n╔=======================================================================╗");
                        System.out.println("|                      [ERROR] | PILIHAN TIDAK VALID                    |");
                        System.out.println("╚=======================================================================╝");
                }
            }

            System.out.println("\nSetelah mengubah data, pet menjadi:");
            int i = 1;
            System.out.println("╔=======================================================================╗");
            System.out.printf("| %-69s |\n", "                        Data pet setelah diubah:");
            System.out.println("|=======================================================================|");
            System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Habitat");
            System.out.println("|-----|---------------|-------------------|------|-----------|----------|");
            String hargaFormatted = String.format("%,.2f", petEdit.getHargaPet()).replace(",", "."); 
            System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                    petEdit.getrasPet(), hargaFormatted, petEdit.getStokPet(),
                    petEdit.getDiskonPet() * 100, petEdit.getHabitatPet());
            System.out.println("╚=======================================================================╝");
            i++;
        } else {
            System.out.println("\n╔=======================================================================╗");
            System.out.println("|                   [ERROR] | NOMOR PET TIDAK VALID                     |");
            System.out.println("╚=======================================================================╝");
        }
    }

    // 📌================================📋 Function 📋================================📌

    public static void displayMenuCari() {
        System.out.println("\n╔=======================================================================╗");
        System.out.println("|                                MENU                                   |");
        System.out.println("╚=======================================================================╝");
        System.out.println("╔=======================================================================╗");
        System.out.println("|  1. | Cari berdasar harga                                             |");
        System.out.println("|  2. | Cari pet berdasarkan jenis                                      |");
        System.out.println("|  0. | Kembali                                                         |");
        System.out.println("╚=======================================================================╝");
        System.out.print("Pilihan: ");
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayMenuTampilkan() {
        System.out.println("\n╔=======================================================================╗");
        System.out.println("|                                MENU                                   |");
        System.out.println("╚=======================================================================╝");
        System.out.println("╔=======================================================================╗");
        System.out.println("|  1. | Tampilkan semua pet                                             |");
        System.out.println("|  2. | Tampilkan pet berdasarkan harga                                 |");
        System.out.println("|  0. | Kembali                                                         |");
        System.out.println("╚=======================================================================╝");
        System.out.print("Pilihan: ");
    }

    // 📌================================📋 Function 📋================================📌
    public static void displayMenuEdit() {
        System.out.println("|=======================================================================|");
        System.out.println("|  1. | Ubah Nama                                                       |");
        System.out.println("|  2. | Ubah Harga                                                      |");
        System.out.println("|  3. | Ubah Stok                                                       |");
        System.out.println("|  4. | Ubah Jenis                                                      |");
        System.out.println("|  5. | Ubah Diskon                                                     |");
        System.out.println("|  6. | Ubah Habitar                                                    |");
        System.out.println("|  7. | CONFRIM                                                         |");
        System.out.println("╚=======================================================================╝");
        System.out.print("Pilih bagian yang ingin diedit: ");

    }

    // 📌================================📋 Function 📋================================📌
    public static void displayFaizNation() {
        System.out.println("╔=======================================================================╗");
        System.out.println("|>>>           TERIMAKASIH TELAH MENGGUNAKAN APLIKASI SAYA           <<<|");
        System.out.println("|>>                  <<< FADLY FAIS FAJARRUDDIN >>>                   <<|");
        System.out.println("|>>>                           24111814015                           <<<|");
        System.out.println("|=======================================================================|");
        System.out.println("|>>>                                                                 <<<|");
        System.out.println("|>>                       SEMANGAT PUASANYA!!!                        <<|");
        System.out.println("|>>                    Jangan ampe bolong ya gess                     <<|");
        System.out.println("|>>>                                                                 <<<|");
        System.out.println("╚=======================================================================╝");
    }

}
