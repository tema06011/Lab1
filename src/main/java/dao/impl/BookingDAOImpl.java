package dao.impl;

import DTO.BookingDTO;
import dao.BookingDAO;
import entity.Booking;
import entity.PaymentType;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    public static final String REGEX_FOR_ALL_ALPHABETIC_SYMBOLS = "[^a-zA-Z]";
    public static final String BLANK_STRING = "";
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public BookingDTO getBookingByHotelId(final long id) throws SQLException {
        String querySql = "SELECT user.lastname,user.name as userName," +
                "user.surname, user.id as userId,booking.start,booking.end," +
                "category.name as categoryName,room.cost" +
                "FROM user join booking on user.id=booking.user_id," +
                "category join room on category.id=room.category_id " +
                "where hotel.id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        BookingDTO bookingDTO = new BookingDTO();
        while (resultSet.next()) {
            bookingDTO.setStart(resultSet.getDate("start"));
            bookingDTO.setEnd(resultSet.getDate("end"));
            bookingDTO.setCategoryName(resultSet.getString("categoryName"));
            bookingDTO.setCost(resultSet.getInt("cost"));
        }
        return bookingDTO;
    }

    @Override
    public List<PaymentType> paymentList() throws SQLException {
        String querySql = "SELECT id,name FROM payment_type ";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<PaymentType> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            PaymentType paymentType1 = new PaymentType();
            paymentType1.setName(resultSet.getString("name"));
            paymentType1.setId(resultSet.getLong("id"));
            paymentList.add(paymentType1);
        }
        return paymentList;
    }

    @Override
    public void saveBooking(final Booking booking) throws SQLException {
        final String querySql = "insert into booking(hotel_id,room_id,user_id,start,end,payment_type_id)" +
                " values (?,?,?,?,?,?)";
        final PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, booking.getHotelId());
        prstatment.setLong(2, booking.getRoomId());
        prstatment.setLong(3, booking.getUserId());
        prstatment.setDate(4, booking.getStart());
        prstatment.setDate(5, booking.getEnd());
        prstatment.setLong(6, booking.getPaymentTypeId());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating booking failed, no rows affected.");
        }
    }

    public Long getHotelIDbyName(final String name) throws SQLException {
        String querySql = "SELECT id FROM hotel where name=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, name);
        ResultSet resultSet = prstatment.executeQuery();
        Long hotelId = null;
        while (resultSet.next()) {
            hotelId = resultSet.getLong("id");
        }
        return hotelId;
    }

    @Override
    public Long getRoomIDbyCategoryName(String name) throws SQLException {
        String querySql = "SELECT room.cost,room.id, category.id as categoryId, category.name" +
                " FROM category" +
                " join room on category.id=room.category_id" +
                " where category.name=? limit 1";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        name = name.replaceAll(REGEX_FOR_ALL_ALPHABETIC_SYMBOLS, BLANK_STRING).toLowerCase();
        prstatment.setString(1, name);
        ResultSet resultSet = prstatment.executeQuery();
        Long roomId = null;
        while (resultSet.next()) {
            roomId = resultSet.getLong("id");
        }
        return roomId;
    }

    @Override
    public Long getPaymentTypeIDbyName(final String name) throws SQLException {
        String querySql = "SELECT id FROM payment_type where name=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, name);
        ResultSet resultSet = prstatment.executeQuery();
        Long paymentTypeID = null;
        while (resultSet.next()) {
            paymentTypeID = resultSet.getLong("id");
        }
        return paymentTypeID;
    }

    @Override
    public List<BookingDTO> getBookingListByUserId(final Long userID) throws SQLException {
        String querySql = "select b.start, b.end, pt.name as paymentTypeID, c.name as categoryName, r.cost, h.name as hotelName" +
                " from booking b" +
                "         join room r on r.id = b.room_id" +
                "         join payment_type pt on b.payment_type_id = pt.id" +
                "         join hotel h on b.hotel_id = h.id" +
                "         join category c on r.category_id = c.id" +
                " where b.user_id =?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, userID);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<BookingDTO> bookingList = new ArrayList<>();
        while (resultSet.next()) {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setHotelName(resultSet.getString("hotelName"));
            bookingDTO.setPaymentTypeId(resultSet.getString("paymentTypeID"));
            bookingDTO.setStart(resultSet.getDate("start"));
            bookingDTO.setEnd(resultSet.getDate("end"));
            bookingDTO.setCategoryName(resultSet.getString("categoryName"));
            bookingDTO.setCost(resultSet.getInt("cost"));
            bookingList.add(bookingDTO);
        }
        return bookingList;
    }
}
