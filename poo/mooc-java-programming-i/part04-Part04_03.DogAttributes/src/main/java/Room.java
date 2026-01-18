public class Room {
    private String code;
    private int numberOfSeats;

    public Room(String code, int numberOfSeats) {
        this.code = code;
        this.numberOfSeats = numberOfSeats;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
