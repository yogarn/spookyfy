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
        
        Pelanggan pelanggan = new PelangganFree(kode, nama, JenisPelanggan.FREE);

        System.out.println();
        System.out.printf("+%s+%s+\n", "-".repeat(20), "-".repeat(88));
        System.out.printf("| %-18s | %-86s |\n", "Informasi Pengguna", "Keterangan");
        System.out.printf("+%s+%s+\n", "-".repeat(20), "-".repeat(88));
        System.out.printf("| %-18s | %-86s |\n", "Kode", pelanggan.getKode());
        System.out.printf("| %-18s | %-86s |\n", "Nama", pelanggan.getNama());
        System.out.printf("| %-18s | %-86s |\n", "Status", pelanggan.getStatusKeanggotaan());
        System.out.printf("+%s+%s+\n", "-".repeat(20), "-".repeat(88));
        System.out.println();

        String command = "";

        while (true) {
            command = input.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("list_lagu")) {
                List<Lagu> list = pelanggan.ambilListLagu();

                System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
                System.out.printf("| %-30s | %-15s | %-25s | %-20s | %5s |\n", "Judul Lagu", "Genre", "Artist", "Pencipta", "Tahun");
                System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
                for (Lagu lagu : list) {
                    System.out.printf("| %-30s | %-15s | %-25s | %-20s | %5d |\n", 
                    lagu.getJudul(), lagu.getGenre(), lagu.getArtist(), lagu.getPencipta(), lagu.getTahun());
                }
                System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
                System.out.println();
            } else if (command.equalsIgnoreCase("play")) {
                String lagu = input.nextLine();
                pelanggan.dengarkan(lagu);
            } else {
                System.out.println("command not recognized");
            }
        }

        input.close();
    }
}
