
package hotelreservationsystem;

interface Room {
    public abstract void describe();
}

class StandardRoom implements Room {
    @Override
    public void describe() {
        System.out.println("Standard Room");
    }
}

class DeluxeRoom implements Room {
    @Override
    public void describe() {
        System.out.println("Deluxe Room");
    }
}

class SuiteRoom implements Room {
    @Override
    public void describe() {
        System.out.println("Suite Room");
    }
}

class RoomFactory {
    public static Room createRoom(String type) {
        switch (type.toLowerCase()) {
            case "standard":
                return new StandardRoom();
            case "deluxe":
                return new DeluxeRoom();
            case "suite":
                return new SuiteRoom();
            default:
                throw new IllegalArgumentException("Unknown room type");
        }
    }
}