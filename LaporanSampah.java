import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class LaporanSampah {
    ArrayList<Sampah> dataSampah = new ArrayList<>();

    private class Sampah {
        String tanggal, desa, kecamatan, jenis;
        double berat;

        public Sampah(String tanggal, String desa, String kecamatan, String jenis, double berat) {
            this.tanggal = tanggal;
            this.desa = desa;
            this.kecamatan = kecamatan;
            this.jenis = jenis;
            this.berat = berat;
        }
    }

    // Method untuk menambahkan laporan sampah
    public void tambahLaporanSampah(Scanner scanner) {
        System.out.print("\nMasukkan tanggal (yyyy/mm/dd) : ");
        String tanggal = scanner.next();
        System.out.print("Masukkan desa : ");
        String desa = scanner.next();
        System.out.print("Masukkan kecamatan : ");
        String kecamatan = scanner.next();
        System.out.print("Masukkan jenis sampah : ");
        String jenis = scanner.next();
        System.out.print("Masukkan berat sampah (kg) : ");
        double berat = scanner.nextDouble();

        Sampah sampah = new Sampah(tanggal, desa, kecamatan, jenis, berat);

        dataSampah.add(sampah);

        // Menyimpan data sampah ke dalam file
        saveToFile(sampah);

        System.out.println("Terimakasih, laporan sampah berhasil ditambahkan");
    }

    private void saveToFile(Sampah sampah) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv", true))) {
            writer.append(sampah.tanggal + ",");
            writer.append(sampah.desa + ",");
            writer.append(sampah.kecamatan + ",");
            writer.append(sampah.jenis + ",");
            writer.append(sampah.berat + "\n");
        } catch (IOException e) {
            System.out.println("Data tidak tersimpan");
        }
    }

    // Method untuk menampilkan data sampah
    public void tampilkanDataSampah(Scanner scanner) {
        System.out.println("\nPilih urutan berdasarkan :");
        System.out.println("1. Data Terbaru");
        System.out.println("2. Data Terlama");
        System.out.print("Masukkan pilihan Anda : ");
        int choice = scanner.nextInt();

        // Mengambil data dari file "data.csv"
        readFile("data.csv");

        switch (choice) {
            case 1:
                insertionSortDescending();
                break;
            case 2:
                insertionSortAscending();
                break;
            default:
                System.out.println("Pilihan Anda tidak tersedia");
        }

        // Menampilkan data sampah setelah diurutkan
        printDataSampah();
    }

    private void readFile(String data) {
        try {
            Scanner scanner = new Scanner(new File("data.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(",");
                Sampah sampah = new Sampah(arr[0], arr[1], arr[2], arr[3],
                        Double.parseDouble(arr[4]));

                dataSampah.add(sampah);
            }
        } catch (IOException e) {
            System.out.println("Data tidak ditemukan");
        }
    }

    private void insertionSortAscending() {
        int n = dataSampah.size();
        for (int i = 0; i < n; i++) {
            Sampah sampah = dataSampah.get(i);
            int j = i - 1;
            while (j >= 0 && dataSampah.get(j).tanggal.compareTo(sampah.tanggal) > 0) { // ASC
                dataSampah.set(j + 1, dataSampah.get(j));
                j--;
            }
            dataSampah.set(j + 1, sampah);
        }
    }

    private void insertionSortDescending() {
        int n = dataSampah.size();
        for (int i = 0; i < n; i++) {
            Sampah sampah = dataSampah.get(i);
            int j = i - 1;
            while (j >= 0 && dataSampah.get(j).tanggal.compareTo(sampah.tanggal) < 0) { // DESC
                dataSampah.set(j + 1, dataSampah.get(j));
                j--;
            }
            dataSampah.set(j + 1, sampah);
        }
    }

    private void printDataSampah() {
        System.out.println("\nNo. Tanggal \tDesa      \tKecamatan\tJenis Sampah\tBerat Sampah(kg)");
        System.out.println("----------------------------------------------------------------------------------");
        int n = dataSampah.size();
        for (int i = 0; i < n; i++) {
            Sampah sampah = dataSampah.get(i);
            System.out.println(
                    (i + 1) + "   " + sampah.tanggal + "\t" + sampah.desa + "\t" + sampah.kecamatan
                            + "\t" + sampah.jenis + "\t\t" + sampah.berat);
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    // Method untuk mencari data sampah
    public void cariDataSampah(Scanner scanner) {
        System.out.println("\nPilih pencarian berdasarkan :");
        System.out.println("1. Lokasi (Desa/Kecamatan)");
        System.out.println("2. Jenis Sampah");
        System.out.print("Masukkan pilihan Anda : ");
        int choice = scanner.nextInt();

        readFile("data.csv");

        switch (choice) {
            case 1:
                System.out.print("Masukkan lokasi (Desa/Kecamatan) : ");
                String lokasi = scanner.next();
                sequentialSearchLokasi(lokasi);
                break;
            case 2:
                System.out.print("Masukkan jenis sampah : ");
                String jenis = scanner.next();
                sequentialSearchJenis(jenis);
                break;
            default:
                System.out.println("Pilihan Anda tidak tersedia");
        }
    }

    private void sequentialSearchLokasi(String lokasi) {
        ArrayList<Sampah> result = new ArrayList<>();
        boolean found = false;

        for (Sampah sampah : dataSampah) {
            if (sampah.desa.equalsIgnoreCase(lokasi) || sampah.kecamatan.equalsIgnoreCase(lokasi)) {
                found = true;
                result.add(sampah);
            }
        }

        if (found == true) {
            System.out.println("\nData sampah ditemukan :");
            printResult(result);
        } else {
            System.out.println("Data sampah tidak ditemukan");
        }
    }

    private void sequentialSearchJenis(String jenis) {
        ArrayList<Sampah> result = new ArrayList<>();
        boolean found = false;

        for (Sampah sampah : dataSampah) {
            if (sampah.jenis.equalsIgnoreCase(jenis)) {
                found = true;
                result.add(sampah);
            }
        }

        if (found == true) {
            System.out.println("\nData sampah ditemukan :");
            printResult(result);
        } else {
            System.out.println("Data sampah tidak ditemukan");
        }
    }

    private void printResult(List<Sampah> result) {
        System.out.println("No. Tanggal \tDesa      \tKecamatan\tJenis Sampah\tBerat Sampah(kg)");
        System.out.println("----------------------------------------------------------------------------------");
        int i = 1;
        for (Sampah sampah : result) {
            System.out.println(
                    i + "   " + sampah.tanggal + "\t" + sampah.desa + "\t" + sampah.kecamatan
                            + "\t" + sampah.jenis + "\t\t" + sampah.berat);
            i++;
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    // Method untuk menghapus data sampah
    public void hapusDataSampah(Scanner scanner) {
        System.out.println("\nPilih metode penghapusan :");
        System.out.println("1. Berdasarkan Nomor");
        System.out.println("2. Berdasarkan Lokasi");
        System.out.println("3. Berdasarkan Jenis Sampah");
        System.out.print("Masukkan pilihan Anda : ");
        int choice = scanner.nextInt();

        readFile("data.csv");

        switch (choice) {
            case 1:
                hapusByNomor(scanner);
                break;
            case 2:
                hapusByLokasi(scanner);
                break;
            case 3:
                hapusByJenis(scanner);
                break;
            default:
                System.out.println("Pilihan Anda tidak tersedia");
        }
    }

    private void hapusByNomor(Scanner scanner) {
        insertionSortAscending();
        printDataSampah();
        System.out.print("\nMasukkan nomor data yang akan dihapus : ");
        int nomor = scanner.nextInt();

        if (nomor > 0 && nomor <= dataSampah.size()) {
            dataSampah.remove(nomor - 1); // non indeksasi
            deleteFromFile();
            System.out.println("\nData sampah berhasil dihapus\n");
            System.out.println("Data sekarang :");
            printDataSampah();
        } else {
            System.out.println("Nomor data tidak valid");
        }
    }

    private void hapusByLokasi(Scanner scanner) {
        System.out.print("Masukkan lokasi (Desa/Kecamatan) : ");
        String lokasi = scanner.next();

        Stack<Sampah> result = new Stack<>();
        for (Sampah sampah : dataSampah) {
            if (sampah.desa.equalsIgnoreCase(lokasi) || sampah.kecamatan.equalsIgnoreCase(lokasi)) {
                result.push(sampah);
            }
        }

        if (!result.isEmpty()) {
            System.out.println("Data sampah yang akan dihapus :");
            printResult(result);

            while (!result.isEmpty()) {
                Sampah sampah = result.pop();
                dataSampah.remove(sampah);
            }

            deleteFromFile();
            System.out.println("\nData sampah berhasil dihapus\n");
            System.out.println("Data sekarang :");
            printDataSampah();
        } else {
            System.out.println("Data sampah tidak ditemukan");
        }
    }

    private void hapusByJenis(Scanner scanner) {
        System.out.print("Masukkan jenis sampah : ");
        String jenis = scanner.next();

        Stack<Sampah> result = new Stack<>();
        for (Sampah sampah : dataSampah) {
            if (sampah.jenis.equalsIgnoreCase(jenis)) {
                result.push(sampah);
            }
        }

        if (!result.isEmpty()) {
            System.out.println("Data sampah yang akan dihapus :");
            printResult(result);

            while (!result.isEmpty()) {
                Sampah sampah = result.pop();
                dataSampah.remove(sampah);
            }

            deleteFromFile();
            System.out.println("\nData sampah berhasil dihapus\n");
            System.out.println("Data sekarang :");
            printDataSampah();
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private void deleteFromFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"))) {
            for (Sampah sampah : dataSampah) {
                writer.append(sampah.tanggal + ",");
                writer.append(sampah.desa + ",");
                writer.append(sampah.kecamatan + ",");
                writer.append(sampah.jenis + ",");
                writer.append(sampah.berat + "\n");
            }
        } catch (IOException e) {
            System.out.println("Gagal menghapus data dari file");
        }
    }
}