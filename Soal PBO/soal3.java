public class soal3 {
    public static void bubbleSort(double p[]) {
        int n = p.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p[j] > p[j + 1]) {
                    double temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        double hargaHewan[] = { 2500000, 3000000, 1500000, 5000000, 2000000 };
        bubbleSort(hargaHewan);
        for (double harga : hargaHewan) {
            System.out.println("Rp " + harga);
        }
    }
}
