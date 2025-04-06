package services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import models.kucing;
import models.petList;
import utils.function;

public class serviceCat {
    static ArrayList<kucing> listKucing = service.listKucing; // Mengambil daftar kucing dari class function

    public static void displayAllCats() {

        if (listKucing == null || listKucing.isEmpty()) {
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
            for (petList cat : listKucing) {
                if (cat instanceof kucing) {
                    String hargaFormatted = String.format("%, .2f", cat.getHargaPet()).replace(",", ".");
                    System.out.printf("║ %-3s | %-13s | Rp%-15s | %-10d | %-3.0f%%           ║\n", i,
                            cat.getrasPet(), hargaFormatted, cat.getStokPet(),
                            cat.getDiskonPet() * 100);
                    i++; // 🔢 Menambah nomor urut
                }

            }
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }

    }

    public static void displayDetailCat(Scanner scanner) {

        displayAllCats();
        if (listKucing == null || listKucing.isEmpty()) {
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
        System.out.print("Masukkan nomor pet kucing yang ingin dilihat: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (pilihan < 1 || pilihan > listKucing.size()) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║        [ERROR] | Nomor tidak tersedia. Silakan coba lagi.             ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        }

        petList petDipilih = listKucing.get(pilihan - 1);

        if (petDipilih instanceof kucing) {
            kucing elgato = (kucing) petDipilih;
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n", "  [SUCCESS] | Menampilkan Detail Kucing " + elgato.getrasPet());
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-69s ║\n", " Ras Kucing           : " + elgato.getrasPet());
            String hargaFormatted = String.format("%, .2f", elgato.getHargaPet()).replace(",", ".");
            System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
            System.out.printf("║ %-69s ║\n", " Stok                 : " + elgato.getStokPet());
            System.out.printf("║ %-69s ║\n", " Jenis                : " + elgato.getjenisPet());
            System.out.printf("║ %-69s ║\n", " Diskon               : " + (elgato.getDiskonPet() * 100) + "%");
            System.out.printf("║ %-69s ║\n", " Mantel Bulu          : " + elgato.getManteBulu());
            System.out.printf("║ %-69s ║\n", " Keramahan            : " + elgato.getKeramahan());

            // Tampilkan data kesehatan
            petList.HealthRecord health = elgato.getHealthRecord();
            System.out.printf("║ %-69s ║\n", " Pemeriksaan Terakhir : " + health.getLastCheckup());
            System.out.printf("║ %-69s ║\n", " Status Vaksin        : " + health.getVaccineStatus());
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                [ERROR] | Data bukan tipe kucing!!!.                   ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }
    }

    public static void editCats(Scanner scanner) {
        displayAllCats();
        System.out.print("\nMasukkan nomor pet yang ingin diedit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < listKucing.size()) {
            petList petEdit = listKucing.get(index);
            boolean editing = true;

            while (editing) {
                System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                System.out.printf("║ %-69s ║\n", "                         Mengedit pet: " + petEdit.getrasPet());
                function.displayMenuEditCats();
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
                        if (petEdit instanceof kucing) {
                            System.out.print("Masukkan mantel bulu baru: ");
                            String mantelBaru = scanner.nextLine();
                            ((kucing) petEdit).setMantelBulu(mantelBaru);
                        }
                        break;
                    case 7:
                    function.displayRating();
                        if (petEdit instanceof kucing) {
                            System.out.print("Masukkan Rating keramahan (Copy Ratingnya): ");
                            String ramahBaru = scanner.nextLine();
                            ((kucing) petEdit).setMantelBulu(ramahBaru);
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
                                        .println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                                System.out.println("║        [ERROR] | Format tanggal salah. Gunakan format yyyy-mm-dd      ║");
                                System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
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
                System.out.printf("║ %-69s ║\n" , "  [SUCCESS] | Menampilkan Detail Kucing " + petEdit.getrasPet());
                System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
                System.out.printf("║ %-69s ║\n", " Ras Kucing           : " + petEdit.getrasPet());
                String hargaFormatted = String.format("%, .2f", petEdit.getHargaPet()).replace(",", ".");
                System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
                System.out.printf("║ %-69s ║\n", " Stok                 : " + petEdit.getStokPet());
                System.out.printf("║ %-69s ║\n", " Jenis                : " + petEdit.getjenisPet());
                System.out.printf("║ %-69s ║\n", " Diskon               : " + (petEdit.getDiskonPet() * 100) + "%");
                if (petEdit instanceof kucing) {
                    String mantel = ((kucing) petEdit).getManteBulu();
                    System.out.printf("║ %-69s ║\n", " Mantel Bulu          : " + mantel);
                }
                if (petEdit instanceof kucing) {
                    String bulu = ((kucing) petEdit).getKeramahan();
                    System.out.printf("║ %-69s ║\n", " Keramahan            : " + bulu);
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
