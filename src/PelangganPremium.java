public class PelangganPremium extends Pelanggan {

    public PelangganPremium(int kodePelanggan, String nama, String statusKeanggotaan) {
        super(kodePelanggan, nama, statusKeanggotaan);
    }

    @Override
    public void ambilListLagu() {
        // implements get latest songs
    }
}
