package dao;

import DTO.BookingDTO;

import entity.Booking;
import entity.PaymentType;


import java.sql.SQLException;
import java.util.List;

public interface BookingDAO {
    public BookingDTO booking(long id) throws SQLException;
    public List<PaymentType> paymentList() throws SQLException;
    public void saveBooking(Booking booking) throws  SQLException;

}
