
package hotelreservationsystem;

public class ReservationManager {
    private static ReservationManager instance;

    private ReservationManager() {
        
    }

    public static synchronized ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    public void manageReservation(String reservationDetails) {
        System.out.println("Managing reservation: " + reservationDetails);
    }
}