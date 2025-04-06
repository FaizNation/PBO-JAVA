package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import models.*;
import utils.function;

public class service {
    static ArrayList<petList> listPet = new ArrayList<>();

    public static ArrayList<kucing> listKucing = new ArrayList<>();
    public static ArrayList<anjing> listAnjing = new ArrayList<>();
    public static ArrayList<burung> listBurung = new ArrayList<>();
    public static ArrayList<ikan> listIkan = new ArrayList<>();
    static {
        listPet();
    }

    public static void listPet() {
        // 📌 Menambahkan daftar pet awal ke dalam list 📌
        // 😺 LIST KUCING 😺
        listKucing.add(new kucing("Persia", 6500000, 10, "Kucing", 0.1,
                "panjang dan mewah", "■■■■■", LocalDate.of(2024, 12, 25), "Lengkap"));
        listKucing.add(new kucing("Anggora", 1400000, 8, "Kucing", 0.08,
                "panjang dan padat", "■■■■■", LocalDate.of(2024, 2, 29), "Ulang"));
        listKucing.add(new kucing("Maine coon", 1800000, 5, "Kucing", 0.12,
                "Padat dan halus", "■■■■■", LocalDate.of(2024, 9, 25), "Sebagian"));
        // 🐶 LIST ANJING 🐶
        listAnjing.add(new anjing("Golden", 4750000, 5, "Anjing", 0.12,
                "22-24 inchi", "■■■■-", LocalDate.of(2023, 11, 25), "Lengkap"));
        listAnjing.add(new anjing("Husky", 5500000, 4, "Anjing", 0.4,
                "21-23 inci", "■■■■-", LocalDate.of(2021, 8, 25), "Lengkap"));
        listAnjing.add(new anjing("Bulldog", 23000000, 6, "Anjing", 0.7,
                "14–16 inci", "■■■■■", LocalDate.of(2021, 7, 25), "Lengkap"));
        // 🐟 LIST IKAN 🐟
        listIkan.add(new ikan("Koi", 500000, 20, "Ikan", 0.3,
                "Cyprinus rubrofuscus", "18-28°C", LocalDate.of(2021, 5, 8), "Sebagian"));
        listIkan.add(new ikan("Arwana", 200000, 10, "Ikan", 0.10,
                "Scleropages formosus", "26-30°C", LocalDate.of(2019, 4, 6), "Lengkap"));
        listIkan.add(new ikan("Cupang", 25000, 50, "Ikan", 0,
                "Betta", "24-28°C", LocalDate.of(2024, 5, 3), "-"));
        // 🐦 LIST BURUNG 🐦
        listBurung.add(new burung("Kakaktua", 2500000, 8, "Burung", 1,
                "300-900 gram)", "keras dan melengking", LocalDate.of(2024, 2, 23), "-"));
        listBurung.add(new burung("Beo", 1500000, 15, "Burung", 1.1,
                "418-526 gram", "Dapat Bicara", LocalDate.of(2025, 4, 15), "-"));
        listBurung.add(new burung("Kenari", 500000, 28, "Burung", 2.0,
                "15-30 gram", " Gacor dan Panjang", LocalDate.of(2023, 5, 24), "-"));
    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void displayPets(Scanner scanner) {
        while (true) {
            function.displayMenuTampilkan();// 🐾 Menampilkan menu untuk menampilkan daftar pet 🐾
            int PilihDisplayPets = scanner.nextInt();
            scanner.nextLine();
            switch (PilihDisplayPets) {
                case 1:
                    displayAllPets();// 📋 Menampilkan semua pet 📋
                    break;
                case 2:
                    displayPetsHarga();// 💰 Menampilkan pet berdasarkan harga 💰
                    break;
                case 3:
                    displayJenis(scanner);
                case 0:
                    return;// 🔙 Kembali ke menu utama 🔙
            }

        }
    }

    public static void displayJenis(Scanner scanner) {
        function.displayDaftarJenis();
        System.out.print("Pilih jenis pet yang ingin ditampilkan: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        switch (jenis) {
            case 1:
                serviceCat.displayDetailCat(scanner); // Menampilkan semua kucing
                break;
            case 2:
                serviceDog.displayDetailDoggy(scanner);
                break;
            case 3:
                serviceFish.displayDetailIwak(scanner);
                break;
            case 4:
                serviceBird.displayDetailbuwung(scanner);
                break;
            case 0:
                return;// 🔙 Kembali ke menu utama 🔙
        }
    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void displayAllPets() {
        List<petList> listPet = new ArrayList<>();

        listPet.addAll(listKucing);
        listPet.addAll(listAnjing);
        listPet.addAll(listBurung);
        listPet.addAll(listIkan);

        if ((listPet == null || listPet.isEmpty())) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                     Tidak ada data pet yang tersedia                  |");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        } else {
            int i = 1;
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                           Daftar Semua Pet                            ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-3s | %-13s | %-17s | %-4s | %-9s | %-8s ║\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Jenis");
            System.out.println("╠═════|═══════════════|═══════════════════|══════|═══════════|══════════╣");
            // 🔄 Loop untuk menampilkan setiap pet dalam daftar 🔄
            for (petList pet : listPet) {
                // 💰 Format harga dan replace untuk mengubah harga agar lebih rapi dalam
                // tampilan
                String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("║ %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s ║\n", i,
                        pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                        pet.getDiskonPet() * 100, pet.getjenisPet());
                i++; // 🔢 Menambah nomor urut

            }
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }

    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void displayCari(Scanner scanner) {

        while (true) {
            function.displayMenuCari();
            int Cari = scanner.nextInt();
            scanner.nextLine();
            switch (Cari) {
                case 1:
                    displayCariPetHarga(scanner, listPet); // 🔍 cari berdasar harga 🔍
                    break;
                case 2:
                    displayCariPetJenis(scanner, listPet);// 🔍 cari berdasar jenis 🔍
                    break;
                case 0:
                    return;
            }
        }
    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void displayCariPetHarga(Scanner scanner, ArrayList<petList> listpet) {
        List<petList> listPet = new ArrayList<>();

        listPet.addAll(listKucing);
        listPet.addAll(listAnjing);
        listPet.addAll(listBurung);
        listPet.addAll(listIkan);

        System.out.print("Masukkan harga pet yang dicari: ");
        double hargaDicari = scanner.nextDouble();
        scanner.nextLine();

        // 🔎 Panggil cariPetList dari class petList untuk mencari pet berdasarkan harga

        List<petList> hasil = petList.cariSemuaPetByHarga(listPet, hargaDicari);

        if (hasil != null) {
            int i = 1;// 📌 Untuk penomoran daftar 📌
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n", "             Data pet dengan harga Rp" + hargaDicari + " ditemukan");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-3s | %-13s | %-17s | %-4s | %-9s | %-8s ║\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "Jenis");
            System.out.println("╠═════|═══════════════|═══════════════════|══════|═══════════|══════════╣");
            // 💰 Format harga agar lebih rapi (menggunakan koma sebagai pemisah ribuan) 💰
            for (petList pet : hasil) {
                String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("║ %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s ║\n", i,
                        pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                        pet.getDiskonPet() * 100, pet.getjenisPet());
                i++; // 🔢 Menambah nomor urut
            }
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        } else {
            // ⚠️ Jika pet tidak ditemukan ⚠️
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n",
                    " [ERROR] | Data pet dengan harga Rp" + hargaDicari + " tidak ditemukan.  |");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }

    }

    // 📌================================📋 Function
    // 📋================================📌

    public static void displayCariPetJenis(Scanner scanner, ArrayList<petList> listPet) {
        List<petList> listFusion = new ArrayList<>();
        listFusion.addAll(listKucing);
        listFusion.addAll(listAnjing);
        listFusion.addAll(listBurung);
        listFusion.addAll(listIkan);

        System.out.print("\nMasukkan jenis pet yang dicari: ");// 📌 Manipulasi string untuk mengkorversi huruf jadi
                                                               // kecil 📌
        String jenisDicari = scanner.nextLine().toLowerCase();

        System.out.print("Masukkan ras pet yang dicari: ");
        String rasDicari = scanner.nextLine().toLowerCase();

        // 🔄 Searching menggunakan Comparator 🔄
        List<petList> hasil = petList.cariPetListJenis(listFusion, jenisDicari, rasDicari);

        if (hasil != null) {
            int i = 1;
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n",
                    "    Data pet ditemukan berdasarkan jenis '" + jenisDicari + "' dan ras '" + rasDicari);
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-3s | %-13s | %-17s | %-4s | %-9s | %-8s ║\n",
                    "No", "Ras", "Harga", "Stok", "Diskon", "jenis");
            System.out.println("╠═════|═══════════════|═══════════════════|══════|═══════════|══════════");
            for (petList pet : hasil) {
                String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("║ %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s ║\n", i,
                        pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                        pet.getDiskonPet() * 100, pet.getjenisPet());
                System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                i++;
            }
        } else {
            // ⚠️ Jika pet tidak ditemukan ⚠️
            System.out.println("\nPet dengan jenis '" + jenisDicari + "' dan ras '" + rasDicari + "' tidak ditemukan.");
        }
    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void beliPet(Scanner scanner) {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("|                  Silahkan pilih Pet yang Anda Suka!                   |");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        displayAllPets(); // 🐾 Tampilkan daftar pet sebelum membeli 🐾
        List<petList> listPet = new ArrayList<>();

        listPet.addAll(listKucing);
        listPet.addAll(listAnjing);
        listPet.addAll(listBurung);
        listPet.addAll(listIkan);
        
        ArrayList<petList> keranjang = new ArrayList<>();
        ArrayList<Integer> jumlahBeliList = new ArrayList<>();
        boolean beliLagi = true;

        while (beliLagi) {
            System.out.print("\nMasukkan nama ras pet yang ingin dibeli: ");
            String rasPet = scanner.nextLine();

            // 🐶 Cari pet berdasarkan ras 🐶
            petList petDitemukan = null;
            for (petList pet : listPet) {
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
                    System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
                    System.out.printf("║ %-69s ║\n", " [SUCCESS] | " + jumlahBeli + " ekor " + petDitemukan.getrasPet()
                            + " telah ditambahkan ke keranjang.");
                    System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                } else {
                    System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
                    System.out.printf("║ %-69s ║\n", " [ERROR] | Maaf, stok tidak mencukupi atau jumlah tidak valid.");
                    System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                }
            } else {
                System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
                System.out.printf("║ %-69s ║\n", " [ERROR] | Pet dengan ras '" + rasPet + "' tidak ditemukan.");
                System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            }

            System.out.print("Ingin beli pet lain? (true/false): ");
            beliLagi = scanner.nextBoolean();
            scanner.nextLine();
        }

        // 📜 Tampilkan detail pembelian 📜
        if (!keranjang.isEmpty()) {
            double totalHarga = 0;
            double totalDiskon = 0;

            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                         Detail Pembelian Pet                          ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-15s | %-8s | %-15s | %-22s ║\n", "Ras Pet", "Jumlah", "Harga Satuan",
                    "       Subtotal");
            System.out.println("╠═════════════════|══════════|═════════════════|════════════════════════╣");

            for (int i = 0; i < keranjang.size(); i++) {
                petList pet = keranjang.get(i);
                int jumlah = jumlahBeliList.get(i);
                double hargaAsli = pet.getHargaPet() * jumlah;
                double diskon = hargaAsli * pet.getDiskonPet();
                double hargaTotal = hargaAsli - diskon;

                String subtotalFormatted = String.format("%,.2f", hargaTotal).replace(",", ".");
                String hargaFormatted = String.format("%,.2f", pet.getHargaPet()).replace(",", ".");
                System.out.printf("║ %-15s | %-8d | Rp%-13s | Rp%-20s ║\n",
                        pet.getrasPet(), jumlah, hargaFormatted, subtotalFormatted);

                totalHarga += hargaTotal;
                totalDiskon += diskon;
            }
            String totalDiskonFormatted = String.format("%,.2f", totalDiskon).replace(",", ".");
            String totalHargaFormatted = String.format("%,.2f", totalHarga).replace(",", ".");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-44s : Rp%-20s ║\n", "Total Diskon", totalDiskonFormatted);
            System.out.printf("║ %-44s : Rp%-20s ║\n", "Total Bayar", totalHargaFormatted);
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");

            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║             Pembelian berhasil! Stok pet telah diperbarui             ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                                                       ║");
            System.out.println("║                Terimakasih Telah Membeli Pet Di Petopia               ║");
            System.out.println("║                                                                       ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                         Pembelian dibatalkan.                         ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }
    }

    // 📌================================📋 Function
    // 📋================================📌
    public static void displayPetsHarga() {
        List<petList> listPet = new ArrayList<>();

        listPet.addAll(listKucing);
        listPet.addAll(listAnjing);
        listPet.addAll(listBurung);
        listPet.addAll(listIkan);

        // 🔄 Sorting menggunakan Comparator 🔄
        listPet.sort(Comparator.comparingDouble(petList::getHargaPet));
        int i = 1;
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("|                Daftar Semua Pet Berdasar Harga Termurah               |");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf("| %-3s | %-13s | %-17s | %-4s | %-9s | %-8s |\n",
                "No", "Ras", "Harga", "Stok", "Diskon", "Jenis");
        System.out.println("╠═════|═══════════════|═══════════════════|══════|═══════════|══════════╣");
        // 📜 Menampilkan daftar mahasiswa setelah sorting 📜
        for (petList pet : listPet) {
            String hargaFormatted = String.format("%, .2f", pet.getHargaPet()).replace(",", ".");
            System.out.printf("| %-3s | %-13s | Rp%-15s | %-4d | %-3.0f%%      | %-8s |\n", i,
                    pet.getrasPet(), hargaFormatted, pet.getStokPet(),
                    pet.getDiskonPet() * 100, pet.getjenisPet());
            i++;

        }
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
    }

    public static void editPpet(Scanner scanner) {
        function.displayDaftarJenis();
        System.out.print("\nMasukkan nomor pet yang ingin diedit: ");
        int noEdit = scanner.nextInt();
        scanner.nextLine();
        switch (noEdit) {
            case 1:
                serviceCat.editCats(scanner); // Menampilkan semua kucing
                break;
            case 2:
                serviceDog.editDoggy(scanner);
                break;
            case 3:
                serviceFish.editIwak(scanner);
                break;
            case 4:
                serviceBird.editbuwung(scanner);
                break;
            case 0:
                return;// 🔙 Kembali ke menu utama 🔙
        }
    }

}
