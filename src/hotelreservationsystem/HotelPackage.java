
package hotelreservationsystem;


class HotelPackage {
    private String roomType;
    private String mealPlan;
    private String amenities;

    public HotelPackage(String roomType, String mealPlan, String amenities) {
        this.roomType = roomType;
        this.mealPlan = mealPlan;
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Hotel Package [Room Type: " + roomType + ", Meal Plan: " + mealPlan + ", Amenities: " + amenities + "]";
    }
}

class HotelPackageBuilder {
    private String roomType;
    private String mealPlan;
    private String amenities;

    public HotelPackageBuilder setRoomType(String roomType) {
        this.roomType = roomType;
        return this;
    }

    public HotelPackageBuilder setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
        return this;
    }

    public HotelPackageBuilder setAmenities(String amenities) {
        this.amenities = amenities;
        return this;
    }

    public HotelPackage build() {
        return new HotelPackage(roomType, mealPlan, amenities);
    }
}