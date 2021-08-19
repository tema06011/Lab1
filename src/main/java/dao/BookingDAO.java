package dao;

import DTO.BookingDTO;
import entity.Booking;
import entity.PaymentType;

import java.sql.SQLException;
import java.util.List;

public interface BookingDAO {
    public BookingDTO getBookingByHotelId(long id) throws SQLException;

    public List<PaymentType> paymentList() throws SQLException;

    public void saveBooking(Booking booking) throws SQLException;

    public Long getHotelIDbyName(String name) throws SQLException;

    public Long getRoomIDbyCategoryName(String name) throws SQLException;

    public Long getPaymentTypeIDbyName(String name) throws SQLException;

    public List<BookingDTO> getBookingListByUserId(Long userID) throws SQLException;
}
