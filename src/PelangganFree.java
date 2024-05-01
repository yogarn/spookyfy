import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class PelangganFree extends Pelanggan {

    public PelangganFree(int kode, String nama, JenisPelanggan statusKeanggotaan) {
        super(kode, nama, statusKeanggotaan);
    }

    @Override
    public List<Lagu> ambilListLagu() {
        List<Lagu> laguList = new ArrayList<>();
        for (Lagu lagu : Spookyfy.DEFAULT_PLAYLIST.getLaguList()) {
            if(lagu.getTahun() < Year.now().getValue() - 3) {
                laguList.add(lagu);
            }
        }
        return laguList;
    }    
}
