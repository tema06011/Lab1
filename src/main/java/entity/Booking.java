package entity;

import java.sql.Date;

public class Booking {
    private long id;
    private long hotelID;
    private long roomID;
    private long userID;
    private long paymentTypeID;
    private Date start;

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    private Date end;

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(long paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

}
