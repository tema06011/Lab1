package service;

import DTO.BookingDTO;
import entity.Booking;
import entity.PaymentType;

import java.util.List;

public interface BookingService {

    List<PaymentType> paymentList();

    void saveBooking(Booking booking);

    Long getHotelIDbyName(String name);

    Long getRoomIDbyCategoryName(String name);

    Long getPaymentTypeIDbyName(String name);

    List<BookingDTO> getBookingListByUserId(Long userID);
}
