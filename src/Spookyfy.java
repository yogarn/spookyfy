import java.util.List;
import java.util.Scanner;

public class Spookyfy {
    public static final Playlist DEFAULT_PLAYLIST = new Playlist(new Lagu[]{
            new Lagu("Bohemian Rhapsody", "Rock", 1975, "Queen", "Freddie Mercury"),
            new Lagu("Hotel California", "Rock", 1976, "Eagles", "Don Felder"),
            new Lagu("Stairway to Heaven", "Rock", 1971, "Led Zeppelin", "Jimmy Page"),
            new Lagu("Sweet Child O' Mine", "Rock", 1987, "Guns N' Roses", "Axl Rose"),
            new Lagu("Smells Like Teen Spirit", "Grunge", 1991, "Nirvana", "Kurt Cobain"),
            new Lagu("Blinding Lights", "Synthwave", 2020, "The Weeknd", "The Weeknd"),
            new Lagu("Dance Monkey", "Pop", 2019, "Tones and I", "Toni Watson"),
            new Lagu("Savage Love", "Pop", 2020, "Jawsh 685 & Jason Derulo", "Jason Derulo"),
            new Lagu("Watermelon Sugar", "Pop", 2020, "Harry Styles", "Harry Styles"),
            new Lagu("Levitating", "Pop", 2020, "Dua Lipa", "Dua Lipa"),
    });

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
            String command = input.nextLine().toLowerCase();
            switch (command) {
                case "exit" -> {
                    break infLoop;
                }
                case "list_lagu" -> {
                    List<Lagu> list = pelanggan.ambilListLagu();
                    String rowSeparator = String.format("+%s+%s+%s+%s+%s+", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
                    String columnFormatter = "| %-30s | %-15s | %-25s | %-20s | %5d |\n";

                    System.out.println(rowSeparator);
                    System.out.printf("| %-30s | %-15s | %-25s | %-20s | %5s |\n", "Judul Lagu", "Genre", "Artist", "Pencipta", "Tahun");
                    System.out.println(rowSeparator);
                    for (Lagu lagu : list) {
                        System.out.printf(columnFormatter,
                                lagu.getJudul(), lagu.getGenre(), lagu.getArtist(), lagu.getPencipta(), lagu.getTahun());
                    }
                    System.out.println(rowSeparator);
                    System.out.println();
                }
                case "play" -> {
                    String lagu = input.nextLine();
                    pelanggan.dengarkan(lagu);
                }
                default -> System.out.println("Perintah tidak masuk akal. Coba lagi.");
            }
        }

        input.close();
    }
}
