package services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import models.anjing;
import models.petList;
import utils.function;

public class serviceDog {
    static ArrayList<anjing> listAnjing = service.listAnjing;

    public static void displayAlldoggys() {

        if (listAnjing == null || listAnjing.isEmpty()) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                     Tidak ada data pet yang tersedia                  ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        } else {
            int i = 1;
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                           Daftar Semua Pet                            ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-3s | %-13s | %-17s | %-10s | %-14s ║\n",
                    "No", "Ras", "Harga", "Stok", "Diskon");
            System.out.println("╠═════|═══════════════|═══════════════════|════════════|════════════════╣");
            // 🔄 Loop untuk menampilkan setiap pet dalam daftar 🔄
            for (petList doggy : listAnjing) {
                if (doggy instanceof anjing) {
                    String hargaFormatted = String.format("%, .2f", doggy.getHargaPet()).replace(",", ".");
                    System.out.printf("║ %-3s | %-13s | Rp%-15s | %-10d | %-3.0f%%           ║\n", i,
                            doggy.getrasPet(), hargaFormatted, doggy.getStokPet(),
                            doggy.getDiskonPet() * 100);
                    i++; // 🔢 Menambah nomor urut
                }

            }
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }

    }

    public static void displayDetailDoggy(Scanner scanner) {

        displayAlldoggys();
        if (listAnjing == null || listAnjing.isEmpty()) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║              [ERROR] | Tidak ada data pet yang tersedia               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        }

        System.out.print("\nApakah ingin melihat detail salah satu pet? (y/n): ");
        String konfirmasi = scanner.nextLine().trim().toLowerCase();

        if (!konfirmasi.equals("y")) {
            return;
        }
        System.out.print("Masukkan nomor pet anjing yang ingin dilihat: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (pilihan < 1 || pilihan > listAnjing.size()) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║        [ERROR] | Nomor tidak tersedia. Silakan coba lagi.             ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        }

        petList petDipilih = listAnjing.get(pilihan - 1);

        if (petDipilih instanceof anjing) {
            anjing chien = (anjing) petDipilih;

            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n", "  [SUCCESS] | Menampilkan Detail anjing " + chien.getrasPet());
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-69s ║\n", " Ras anjing           : " + chien.getrasPet());
            String hargaFormatted = String.format("%, .2f", chien.getHargaPet()).replace(",", ".");
            System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
            System.out.printf("║ %-69s ║\n", " Stok                 : " + chien.getStokPet());
            System.out.printf("║ %-69s ║\n", " Jenis                : " + chien.getjenisPet());
            System.out.printf("║ %-69s ║\n", " Diskon               : " + (chien.getDiskonPet() * 100) + "%");
            System.out.printf("║ %-69s ║\n", " Tinggi               : " + chien.getTinggi());
            System.out.printf("║ %-69s ║\n", " Rating Latihan       : " + chien.getLatihan());

            // Tampilkan data kesehatan
            petList.HealthRecord health = chien.getHealthRecord();
            System.out.printf("║ %-69s ║\n", " Pemeriksaan Terakhir : " + health.getLastCheckup());
            System.out.printf("║ %-69s ║\n", " Status Vaksin        : " + health.getVaccineStatus());
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                [ERROR] | Data bukan tipe Anjing!!!.                   ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }
    }

    public static void editDoggy(Scanner scanner) {
        displayAlldoggys();
        System.out.print("\nMasukkan nomor pet yang ingin diedit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < listAnjing.size()) {
            petList petEdit = listAnjing.get(index);
            boolean editing = true;

            while (editing) {
                System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                System.out.printf("║ %-69s ║\n", "                         Mengedit pet: " + petEdit.getrasPet());
                function.displayMenuEditDogs();
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
                        if (petEdit instanceof anjing) {
                            System.out.print("Masukkan tinggi baru: ");
                            String tinggiBaru = scanner.nextLine();
                            ((anjing) petEdit).setTinggi(tinggiBaru);
                        }
                        break;
                    case 7:
                        function.displayRating();
                        if (petEdit instanceof anjing) {
                            System.out.print("Masukkan Rating Latihan (Copy Ratingnya): ");
                            String latihanBaru = scanner.nextLine();
                            ((anjing) petEdit).setLatihan(latihanBaru);
                        }
                        break;
                    case 8:
                        petList.HealthRecord record = petEdit.getHealthRecord();

                        System.out.print("Masukkan tanggal pemeriksaan terakhir (yyyy-mm-dd): ");
                        String tanggalString = scanner.nextLine();
                        try {
                            LocalDate tanggal = LocalDate.parse(tanggalString);
                            record.setLastCheckup(tanggal);
                        } catch (DateTimeParseException e) {
                            System.out
                                    .println(
                                            "\n╔═══════════════════════════════════════════════════════════════════════╗");
                            System.out.println(
                                    "║        [ERROR] | Format tanggal salah. Gunakan format yyyy-mm-dd      ║");
                            System.out.println(
                                    "╚═══════════════════════════════════════════════════════════════════════╝");
                        }
                        function.displayVaksin();
                        System.out.print("Masukkan status vaksin (Copy Statusnya): ");
                        String vaksinStatus = scanner.nextLine();
                        record.setVaccineStatus(vaksinStatus);
                        break;
                    case 0:
                        editing = false;
                        System.out
                                .println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                   [SUCCESS] | BERHASIL MENGEDIT PET                   ║");
                        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                        break;
                    default:
                        System.out
                                .println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                      [ERROR] | PILIHAN TIDAK VALID                    ║");
                        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                }
            }

            System.out.println("\nSetelah mengubah data, pet menjadi:");
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n", "  [SUCCESS] | Menampilkan Detail anjing " + petEdit.getrasPet());
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-69s ║\n", " Ras anjing           : " + petEdit.getrasPet());
            String hargaFormatted = String.format("%, .2f", petEdit.getHargaPet()).replace(",", ".");
            System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
            System.out.printf("║ %-69s ║\n", " Stok                 : " + petEdit.getStokPet());
            System.out.printf("║ %-69s ║\n", " Jenis                : " + petEdit.getjenisPet());
            System.out.printf("║ %-69s ║\n", " Diskon               : " + (petEdit.getDiskonPet() * 100) + "%");
            if (petEdit instanceof anjing) {
                String tinggi = ((anjing) petEdit).getTinggi();
                System.out.printf("║ %-69s ║\n", " tinggi               : " + tinggi);
            }
            if (petEdit instanceof anjing) {
                String latihan = ((anjing) petEdit).getLatihan();
                System.out.printf("║ %-69s ║\n", " Latihan              : " + latihan);
            }

            // Tampilkan data kesehatan
            petList.HealthRecord health = petEdit.getHealthRecord();
            System.out.printf("║ %-69s ║\n", " Pemeriksaan Terakhir : " + health.getLastCheckup());
            System.out.printf("║ %-69s ║\n", " Status Vaksin        : " + health.getVaccineStatus());
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");

        } else {
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                   [ERROR] | NOMOR PET TIDAK VALID                     ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }
    }
}
