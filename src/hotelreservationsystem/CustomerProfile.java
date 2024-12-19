
package hotelreservationsystem;

interface CustomerProfile {
    public abstract void describe();
}

class RegularCustomer implements CustomerProfile {
    @Override
    public void describe() {
        System.out.println("Regular Customer");
    }
}

class VIPCustomer implements CustomerProfile {
    @Override
    public void describe() {
        System.out.println("VIP Customer");
    }
}

class CorporateCustomer implements CustomerProfile {
    @Override
    public void describe() {
        System.out.println("Corporate Customer");
    }
}

class CustomerProfileFactory {
    public static CustomerProfile createProfile(String type) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularCustomer();
            case "vip":
                return new VIPCustomer();
            case "corporate":
                return new CorporateCustomer();
            default:
                throw new IllegalArgumentException("Unknown customer type");
        }
    }
}