import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EdukasiSampah edukasi = new EdukasiSampah();
        LaporanSampah laporan = new LaporanSampah();

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------------------------");
        System.out.println("              MANAJEMEN SAMPAH BANYUWANGI              ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Menu utama :");
        System.out.println("1. Edukasi Sampah");
        System.out.println("2. Tambah Laporan Sampah");
        System.out.println("3. Tampilkan Data Sampah");
        System.out.println("4. Cari Data Sampah");
        System.out.println("5. Hapus Data Sampah");
        System.out.print("Masukkan pilihan Anda : ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                edukasi.menuEdukasi(scanner);
                break;
            case 2:
                laporan.tambahLaporanSampah(scanner);
                break;
            case 3:
                laporan.tampilkanDataSampah(scanner);
                break;
            case 4:
                laporan.cariDataSampah(scanner);
                break;
            case 5:
                laporan.hapusDataSampah(scanner);
                break;
            default:
                System.out.println("Pilihan Anda tidak tersedia");
        }

    }
}