import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import services.service;
import utils.function;

public class petOPia {
    // 🐾 ArrayList untuk menyimpan daftar pet yang tersedia 🐾
    static ArrayList<petList> lisPet = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        function.dislpayJudul();// 🎉 menampilkan judul aplikasi 🎉
        try (Scanner scanner = new Scanner(System.in)) {



            while (true) { // 🔄 Looping menu utama 🔄 
                try {
                    function.displayMenu(); // 📜 menampilkan menu utama 📜
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();
                    switch (pilihan) { // 🔀 switch case untuk percabangan 🔀
                        case 1:
                            service.displayPets(scanner); // 🐶 menampilkan menu pet 🐶
                            break;
                        case 2:
                            service.displayCari(scanner); // 🔍 menampilkan menu cari pet 🔍
                            break;
                        case 3:
                            service.editPpet(scanner); // ✏️ menampilkan menu edit pet ✏️
                            break;
                        case 4:
                            service.beliPet(scanner); // 💰 menampilkan menu beli pet 💰
                            break;
                        case 5:
                            function.displayFaizNation(); // 😎 menampilkan by faiz nation 😎
                            return;
                        default:
                            // ❌ Menampilkan pesan error jika pilihan tidak valid ❌

                            System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
                            System.out.printf("║ %-69s ║\n", " [ERROR] | INPUT TIDAK VALID, SILAHKAN COBALAGI.");
                            System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                    }
                } catch (InputMismatchException e) {
                    // 🛑 Catch untuk menangani kesalahan jika input bukan angka 🛑
                    System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
                    System.out.printf("║ %-69s ║\n", " [ERROR] | INPUT HARUS ANGKA, SILAHKAN COBA ULANGI DARI MENU.");
                    System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
                    scanner.nextLine();

                }
            }

        }

    }

}
