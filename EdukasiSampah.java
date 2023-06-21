import java.util.Scanner;

public class EdukasiSampah {

        public void menuEdukasi(Scanner scanner) {
                System.out.println("\nMenu Edukasi Sampah :");
                System.out.println("1. Apa itu sampah?");
                System.out.println("2. Jenis-jenis sampah");
                System.out.println("3. Dampak sampah terhadap lingkungan");
                System.out.print("Masukkan pilihan Anda : ");
                int choice = scanner.nextInt();

                switch (choice) {
                        case 1:
                                apaItuSampah();
                                break;
                        case 2:
                                jenisSampah();
                                break;
                        case 3:
                                dampakSampah();
                                break;
                        default:
                                System.out.println("Pilihan Anda tidak tersedia");
                }
        }

        private void apaItuSampah() {
                System.out.println("\nApa itu sampah?");
                System.out.println(
                                "Sampah adalah segala sesuatu yang tidak diinginkan, tidak bernilai, atau tidak bermanfaat bagi manusia. Sampah dapat berupa bahan organik, bahan anorganik, atau campuran dari keduanya. Penanganan sampah yang tidak tepat dapat menyebabkan pencemaran lingkungan dan masalah kesehatan.");
        }

        private void jenisSampah() {
                System.out.println("\nJenis-jenis Sampah :");
                System.out.println("1. Sampah Organik");
                System.out.println("   - Contoh : sisa makanan, daun, kayu, kertas yang terkontaminasi oleh makanan");
                System.out.println("   - Sifat : mudah membusuk, dapat diolah menjadi kompos");
                System.out.println("   - Contoh pengolahan : pengomposan");
                System.out.println("2. Sampah Anorganik");
                System.out.println("   - Contoh : plastik, kaca, logam, kertas yang tidak terkontaminasi oleh makanan");
                System.out.println("   - Sifat : tidak mudah membusuk, tidak dapat diurai oleh alam secara alami");
                System.out.println("   - Contoh pengolahan : daur ulang, penggunaan kembali");
                System.out.println("3. Sampah B3 (Bahan Berbahaya dan Beracun)");
                System.out.println("   - Contoh : baterai, cat, pestisida, obat-obatan");
                System.out.println(
                                "   - Sifat : mengandung zat-zat berbahaya dan beracun, berpotensi merusak kesehatan dan lingkungan");
                System.out.println("   - Contoh pengolahan : pengumpulan khusus, pengolahan di tempat yang sesuai");
        }

        private void dampakSampah() {
                System.out.println("\nDampak Sampah terhadap Lingkungan :");
                System.out.println("1. Pencemaran Tanah");
                System.out.println("   - Akibat : tanah menjadi tidak subur, gangguan pada ekosistem tanah");
                System.out.println("2. Pencemaran Air");
                System.out.println(
                                "   - Akibat : air tercemar, mengganggu kehidupan biota air dan manusia yang mengonsumsi air tersebut");
                System.out.println("3. Pencemaran Udara");
                System.out.println(
                                "   - Akibat : udara menjadi tercemar, polusi udara menyebabkan gangguan pernapasan dan masalah kesehatan");
                System.out.println("4. Kerusakan Ekosistem");
                System.out.println(
                                "   - Akibat : hilangnya habitat, kehilangan keanekaragaman hayati, dan gangguan pada rantai makanan");
                System.out.println("5. Perubahan Iklim");
                System.out.println(
                                "   - Akibat : emisi gas rumah kaca dari sampah yang terurai dan proses pembuangan sampah yang tidak tepat");
                System.out
                                .println("   - Mengakibatkan perubahan suhu, perubahan pola cuaca, dan dampak negatif pada lingkungan");
                System.out.println("6. Ancaman Kesehatan");
                System.out.println(
                                "   - Akibat : penyebaran penyakit melalui vektor (misalnya nyamuk dan tikus) yang hidup di tempat sampah");
                System.out.println(
                                "   - Kontaminasi bahan kimia berbahaya yang terkandung dalam sampah juga dapat merusak kesehatan manusia");
                System.out.println("7. Estetika Lingkungan");
                System.out.println(
                                "   - Akibat : keindahan alam dan lingkungan terganggu oleh tumpukan sampah dan pemandangan yang tidak menyenangkan");
        }
}
