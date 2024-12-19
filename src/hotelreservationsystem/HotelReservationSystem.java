
package hotelreservationsystem;

public class HotelReservationSystem {
    public static void main(String[] args) {
       Gui gui=new Gui();
        ReservationManager reservationManager = ReservationManager.getInstance();
        reservationManager.manageReservation("Booking for Mina Ezzat");
        //------------------------------------------------------------------------
//        PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
//        paymentProcessor.processPayment(250.00);
        //------------------------------------------------------------------------
//        Room room = RoomFactory.createRoom("Deluxe");
//        room.describe();
        //------------------------------------------------------------------------
        CustomerProfile customerProfile = CustomerProfileFactory.createProfile("VIP");
        customerProfile.describe();
        //------------------------------------------------------------------------
//        MealPlan breakfastOnly = new BreakfastOnly();
//        MealPlan clonedPlan = MealPlanFactory.getClonedPlan(breakfastOnly);
//        breakfastOnly.describe();
//        clonedPlan.describe();

        //-----------------------------------------------------------------------
//        HotelPackage hotelPackage = new HotelPackageBuilder()
//                .setRoomType("Deluxe")
//                .setMealPlan("Full Board")
//                .setAmenities("Pool Access, Spa")
//                .build();
//        System.out.println(hotelPackage);

        //-----------------------------------------------------------------------
//        CurrencyConverter euroConverter = new EuroToUSDConverter();
//        CurrencyConverterAdapter adapter = new CurrencyConverterAdapter(euroConverter);
//        double amountInUSD = adapter.convert(100); // Convert 100 EUR to USD
//        System.out.println("100 EUR in USD: $" + amountInUSD);
    }
}