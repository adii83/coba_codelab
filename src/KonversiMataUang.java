import java.util.Scanner;

public class KonversiMataUang {
    double idrToUsd;
    double idrToEur;
    double idrToJpy;
    double idrToGbp;
    double idrToAud;

    // Konstruktor untuk inisialisasi kurs konversi
    public KonversiMataUang() {
        this.idrToUsd = 0.000065;  // 1 IDR = 0.000065 USD
        this.idrToEur = 0.000061;  // 1 IDR = 0.000061 EUR
        this.idrToJpy = 0.0097;    // 1 IDR = 0.0097 JPY
        this.idrToGbp = 0.000053;  // 1 IDR = 0.000053 GBP
        this.idrToAud = 0.00010;   // 1 IDR = 0.00010 AUD
    }

    // Method untuk melakukan konversi
    public double convert(double rupiah, int pilihan) {
       double hasilKonversi=0;
        switch (pilihan) {
            case 1:
                double usd = rupiah * idrToUsd;
                System.out.println(usd);
                break;
            case 2:
                double eur = rupiah * idrToEur;
                System.out.println(eur);
                break;
            case 3:
                double jpy = rupiah * idrToJpy;
                System.out.println(jpy);
                break;
            case 4:
                double gbp = rupiah * idrToGbp;
                System.out.println(gbp);
                break;
            case 5:
                double aud = rupiah * idrToAud;
                System.out.println(aud);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                hasilKonversi = -1;  // Mengembalikan nilai -1 jika pilihan tidak valid
        }
        return hasilKonversi;
    }

    // Method untuk menampilkan hasil konversi
    public void printResult(double hasil, String mataUang) {
        if (hasil != -1) {  // Cek apakah konversi valid
            System.out.printf("Hasil konversi: %.2f %s\n", hasil, mataUang);
        }
    }

    // Method untuk menampilkan menu mata uang
    public static void showMenu() {
        System.out.println("Pilih mata uang tujuan:");
        System.out.println("1. USD (Dolar Amerika)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. JPY (Yen Jepang)");
        System.out.println("4. GBP (Poundsterling)");
        System.out.println("5. AUD (Dolar Australia)");
        System.out.print("Pilihan Anda (1/2/3/4/5): ");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        KonversiMataUang converter = new KonversiMataUang();  // Inisialisasi objek

        System.out.println("=== Program Konversi Mata Uang ===");
        System.out.print("Masukkan jumlah Rupiah (IDR): ");
        double rupiah = input.nextDouble();

        KonversiMataUang.showMenu();  // Tampilkan menu
        int pilihan = input.nextInt();

        // Lakukan konversi dan tampilkan hasil
        double hasilKonversi = converter.convert(rupiah, pilihan);
        String mataUang = getCurrencyCode(pilihan);
        converter.printResult(hasilKonversi, mataUang);

        input.close();
    }

    // Method untuk mendapatkan kode mata uang berdasarkan pilihan
    public static String getCurrencyCode(int pilihan) {
        switch (pilihan) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "JPY";
            case 4:
                return "GBP";
            case 5:
                return "AUD";
            default:
                return "";
        }
    }
}
