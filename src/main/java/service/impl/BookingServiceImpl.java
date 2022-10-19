package service.impl;

import DTO.BookingDTO;
import dao.BookingDAO;
import dao.impl.BookingDAOImpl;
import entity.Booking;
import entity.PaymentType;
import service.BookingService;

import java.sql.SQLException;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookingDAO = new BookingDAOImpl();
    private final Booking booking = new Booking();

    @Override
    public List<PaymentType> paymentList() {
        List<PaymentType> result = null;

        try {
            result = bookingDAO.paymentList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveBooking(final Booking booking) {
        try {
            bookingDAO.saveBooking(booking);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Long getHotelIDbyName(final String name) {
        Long result = null;
        try {
            booking.setHotelId(bookingDAO.getHotelIDbyName(name));
            result = bookingDAO.getHotelIDbyName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Long getRoomIDbyCategoryName(final String name) {
        Long result = null;
        try {
            booking.setRoomId(bookingDAO.getRoomIDbyCategoryName(name));
            result = bookingDAO.getRoomIDbyCategoryName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Long getPaymentTypeIDbyName(final String name) {
        Long result = null;
        try {
            booking.setPaymentTypeId(bookingDAO.getPaymentTypeIDbyName(name));
            result = bookingDAO.getPaymentTypeIDbyName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<BookingDTO> getBookingListByUserId(final Long userID) {
        List<BookingDTO> result = null;
        try {
            result = bookingDAO.getBookingListByUserId(userID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
