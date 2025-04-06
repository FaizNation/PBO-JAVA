package services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import models.burung;
import utils.function;
import models.petList;

public class serviceBird {
    static ArrayList<burung> listburung = service.listBurung;

    public static void displayAllbuwungs() {

        if (listburung == null || listburung.isEmpty()) {
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
            for (petList buwung : listburung) {
                if (buwung instanceof burung) {
                    String hargaFormatted = String.format("%, .2f", buwung.getHargaPet()).replace(",", ".");
                    System.out.printf("║ %-3s | %-13s | Rp%-15s | %-10d | %-3.0f%%           ║\n", i,
                            buwung.getrasPet(), hargaFormatted, buwung.getStokPet(),
                            buwung.getDiskonPet() * 100);
                    i++; // 🔢 Menambah nomor urut
                }

            }
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }

    }

    public static void displayDetailbuwung(Scanner scanner) {

        displayAllbuwungs();
        if (listburung == null || listburung.isEmpty()) {
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
        System.out.print("Masukkan nomor pet burung yang ingin dilihat: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (pilihan < 1 || pilihan > listburung.size()) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║        [ERROR] | Nomor tidak tersedia. Silakan coba lagi.             ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
            return;
        }

        petList petDipilih = listburung.get(pilihan - 1);

        if (petDipilih instanceof burung) {
            burung oiseau = (burung) petDipilih;
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-69s ║\n", "  [SUCCESS] | Menampilkan Detail burung " + oiseau.getrasPet());
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-69s ║\n", " Ras burung           : " + oiseau.getrasPet());
            String hargaFormatted = String.format("%, .2f", oiseau.getHargaPet()).replace(",", ".");
            System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
            System.out.printf("║ %-69s ║\n", " Stok                 : " + oiseau.getStokPet());
            System.out.printf("║ %-69s ║\n", " Jenis                : " + oiseau.getjenisPet());
            System.out.printf("║ %-69s ║\n", " Diskon               : " + (oiseau.getDiskonPet() * 100) + "%");
            System.out.printf("║ %-69s ║\n", " Berat                : " + oiseau.getBerat());
            System.out.printf("║ %-69s ║\n", " Kicauan              : " + oiseau.getKicauan());

            // Tampilkan data kesehatan
            petList.HealthRecord health = oiseau.getHealthRecord();
            System.out.printf("║ %-69s ║\n", " Pemeriksaan Terakhir : " + health.getLastCheckup());
            System.out.printf("║ %-69s ║\n", " Status Vaksin        : " + health.getVaccineStatus());
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                [ERROR] | Data bukan tipe burung!!!.                   ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        }
    }

    public static void editbuwung(Scanner scanner) {
        displayAllbuwungs();
        System.out.print("\nMasukkan nomor pet yang ingin diedit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < listburung.size()) {
            petList petEdit = listburung.get(index);
            boolean editing = true;

            while (editing) {
                System.out.println("\n╔═══════════════════════════════════════════════════════════════════════╗");
                System.out.printf("║ %-69s ║\n", "                         Mengedit pet: " + petEdit.getrasPet());
                function.displayMenuEditbird();
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
                        if (petEdit instanceof burung) {
                            System.out.print("Masukkan berat baru: ");
                            String beratBaru = scanner.nextLine();
                            ((burung) petEdit).setBerat(beratBaru);
                        }
                        break;
                    case 7:
                        if (petEdit instanceof burung) {
                            System.out.print("Masukkan Kicauan baru: ");
                            String kicauanBaru = scanner.nextLine();
                            ((burung) petEdit).setKicauan(kicauanBaru);
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
            System.out.printf("║ %-69s ║\n", "  [SUCCESS] | Menampilkan Detail Burung " + petEdit.getrasPet());
            System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ %-69s ║\n", " Ras burung           : " + petEdit.getrasPet());
            String hargaFormatted = String.format("%, .2f", petEdit.getHargaPet()).replace(",", ".");
            System.out.printf("║ %-69s ║\n", " Harga                : Rp" + hargaFormatted);
            System.out.printf("║ %-69s ║\n", " Stok                 : " + petEdit.getStokPet());
            System.out.printf("║ %-69s ║\n", " Jenis                : " + petEdit.getjenisPet());
            System.out.printf("║ %-69s ║\n", " Diskon               : " + (petEdit.getDiskonPet() * 100) + "%");
            if (petEdit instanceof burung) {
                String berat = ((burung) petEdit).getBerat();
                System.out.printf("║ %-69s ║\n", " Berat                : " + berat);
            }
            if (petEdit instanceof burung) {
                String kicaua = ((burung) petEdit).getKicauan();
                System.out.printf("║ %-69s ║\n", " kicauan              : " + kicaua);
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
