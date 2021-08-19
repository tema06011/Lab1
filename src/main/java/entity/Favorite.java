package entity;

public class Favorite {
    private long id;
    private long hotelID;
    private long userID;

    public Favorite() {
    }


    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(final long hotelID) {
        this.hotelID = hotelID;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(final long userID) {
        this.userID = userID;
    }
}
