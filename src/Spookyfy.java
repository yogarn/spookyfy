import java.util.List;
import java.util.Scanner;

public class Spookyfy {
    public static final Playlist DEFAULT_PLAYLIST = new Playlist(new Lagu[]{
            new Lagu("Rolling in the Deep", "Pop", 2010, "Adele", "Adele Adkins"),
            new Lagu("Uptown Funk", "Funk", 2014, "Mark Ronson ft. Bruno Mars", "Bruno Mars"),
            new Lagu("Shape of You", "Pop", 2017, "Ed Sheeran", "Ed Sheeran"),
            new Lagu("Believer", "Rock", 2017, "Imagine Dragons", "Dan Reynolds"),
            new Lagu("Old Town Road", "Country Rap", 2019, "Lil Nas X", "Lil Nas X"),
            new Lagu("As It Was", "Pop", 2022, "Harry Styles", "Harry Styles"),
            new Lagu("Stay", "Pop", 2021, "The Kid LAROI & Justin Bieber", "Justin Bieber"),
            new Lagu("Easy On Me", "Pop", 2021, "Adele", "Adele Adkins"),
            new Lagu("About Damn Time", "Funk Pop", 2022, "Lizzo", "Melissa Jefferson"),
            new Lagu("Shivers", "Pop", 2021, "Ed Sheeran", "Ed Sheeran"),
    });

    public static String HELP = "Perintah yang tersedia: list_lagu, play, exit, help, ubah_status";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Kode: ");
        int kode = input.nextInt();
        input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();
        Pelanggan pelanggan;
        infLoop: while (true) {
            System.out.print("Status keanggotaan (FREE/PREMIUM): ");
            switch (input.nextLine().toLowerCase()) {
                case "free" -> {
                    pelanggan = new PelangganFree(kode, nama);
                    break infLoop;
                }
                case "premium" -> {
                    pelanggan = new PelangganPremium(kode, nama);
                    break infLoop;
                }
                default -> System.out.println("Status keanggotaan tidak masuk akal. Coba lagi.");
            }
        }

        System.out.println(pelanggan);

        infLoop: while (true) {
            System.out.println(HELP);
            System.out.print("Masukkan perintah: ");
            String command = input.nextLine().toLowerCase();
            switch (command) {
                case "exit" -> {
                    break infLoop;
                }
                case "help" -> System.out.println(HELP);
                case "list_lagu" -> {
                    List<Lagu> list = pelanggan.ambilListLagu();
                    String rowSeparator = String.format("+%s+%s+%s+%s+%s+", "-".repeat(32), "-".repeat(17), "-".repeat(32), "-".repeat(22), "-".repeat(7));
                    String columnFormatter = "| %-30s | %-15s | %-30s | %-20s | %5d |\n";

                    System.out.println(rowSeparator);
                    System.out.printf("| %-30s | %-15s | %-30s | %-20s | %5s |\n", "Judul Lagu", "Genre", "Artist", "Pencipta", "Tahun");
                    System.out.println(rowSeparator);
                    for (Lagu lagu : list) {
                        System.out.printf(columnFormatter,
                                lagu.getJudul(), lagu.getGenre(), lagu.getArtist(), lagu.getPencipta(), lagu.getTahun());
                    }
                    System.out.println(rowSeparator);
                    System.out.println();
                }
                case "play" -> {
                    System.out.print("Judul lagu: ");
                    String lagu = input.nextLine();
                    pelanggan.dengarkan(lagu);
                }
                case "ubah_status" -> {
                    StatusKeanggotaan targetStatus = pelanggan.getStatusKeanggotaan() == StatusKeanggotaan.FREE ? StatusKeanggotaan.PREMIUM : StatusKeanggotaan.FREE;
                    System.out.println("Mengubah status keanggotaan menjadi "+targetStatus);
                    pelanggan = pelanggan.ubahStatusKeanggotaan(targetStatus);
                }
                default -> System.out.println("Perintah tidak masuk akal. Coba lagi.");
            }
            System.out.println();
        }

        input.close();
    }
}
