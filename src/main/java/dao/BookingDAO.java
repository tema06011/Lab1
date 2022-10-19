package dao;

import DTO.BookingDTO;
import entity.Booking;
import entity.PaymentType;

import java.sql.SQLException;
import java.util.List;

public interface BookingDAO {
    BookingDTO getBookingByHotelId(long id) throws SQLException;

    List<PaymentType> paymentList() throws SQLException;

    void saveBooking(Booking booking) throws SQLException;

    Long getHotelIDbyName(String name) throws SQLException;

    Long getRoomIDbyCategoryName(String name) throws SQLException;

    Long getPaymentTypeIDbyName(String name) throws SQLException;

    List<BookingDTO> getBookingListByUserId(Long userID) throws SQLException;
}
