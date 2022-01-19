import beans.Client;
import service.ClientService;
import service.CreneauService;
import service.OccupationService;
import service.ReservationService;
import service.SalleService;

public class test {

    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        CreneauService creneauService = new CreneauService();

        OccupationService occupationService = new OccupationService();

        ReservationService reservationService = new ReservationService();

        SalleService salleService = new SalleService();
    }
}
