import com.enigmacamp.model.Nasabah;
import com.enigmacamp.service.NasabahService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================== Bank Stream API ===============================");
        NasabahService service = new NasabahService();
        service.addNasabah();
        service.readAllNasabah();
        System.out.println();
        service.allNasabahAverageBalance();
    }
}