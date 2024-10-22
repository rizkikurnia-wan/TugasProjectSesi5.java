import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        // Daftar buah dengan harga
        String[][] buah = {
            {"apel", "35000"},
            {"jeruk", "50000"},
            {"mangga", "25000"},
            {"duku", "15000"},
            {"semangka", "20000"}
        };

        // ArrayList untuk menyimpan belanjaan
        ArrayList<String[]> keranjang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        boolean beliLagi = true;

        do {
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Pilih Buah (0-4): ");
                int indexBuah = scanner.nextInt();

                if (indexBuah >= 0 && indexBuah < buah.length) {
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    int harga = Integer.parseInt(buah[indexBuah][1]);
                    int subtotal = harga * jumlah;

                    // Menyimpan item ke keranjang
                    keranjang.add(new String[] {
                        buah[indexBuah][0], // Nama buah
                        String.valueOf(jumlah), // Jumlah
                        String.valueOf(harga), // Harga satuan
                        String.valueOf(subtotal) // Subtotal
                    });

                    System.out.print("Input lagi? (y/n): ");
                    char lanjut = scanner.next().charAt(0);
                    if (lanjut == 'n' || lanjut == 'N') {
                        beliLagi = false;
                    }
                } else {
                    System.out.println("Buah tidak valid!");
                }
            } else if (pilihan == 2) {
                tampilkanStruk(keranjang);
            }
        } while (pilihan != 3 && beliLagi);

        scanner.close();
        System.out.println("Terima kasih sudah berbelanja!");
    }

    private static void tampilkanStruk(ArrayList<String[]> keranjang) {
        System.out.println("Daftar Belanja:");
        System.out.println("=================================");
        System.out.printf("%-3s %-10s %-7s %-10s %-10s\n", "No.", "Nama Buah", "Jumlah", "Harga", "Subtotal");

        int total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            String[] item = keranjang.get(i);
            int subtotal = Integer.parseInt(item[3]);
            total += subtotal;

            System.out.printf("%-3d %-10s %-7s %-10s %-10s\n", (i + 1), item[0], item[1], item[2], item[3]);
        }

        int discount = (int) (total * 0.15);
        int totalBayar = total - discount;

        System.out.println("=================================");
        System.out.println("Total: " + total);
        System.out.println("Discount (15%): " + discount);
        System.out.println("Total bayar: " + totalBayar);
    }
}