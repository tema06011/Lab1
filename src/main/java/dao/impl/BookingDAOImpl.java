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
    private final Connection connection = DatabaseConnection.getConnection();
    @Override
    public BookingDTO booking(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "SELECT user.lastname,user.name as userName," +
                "user.surname,booking.start,booking.end," +
                "category.name as categoryName,room.cost" +
                "FROM user join booking on user.id=booking.user_id," +
                "category join room on category.id=room.category_id where hotel.id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        BookingDTO bookingDTO=new BookingDTO();
        while (resultSet.next()) {
            bookingDTO.setLastname(resultSet.getString("lastname"));
            bookingDTO.setUserName(resultSet.getString("userName"));
            bookingDTO.setSurname(resultSet.getString("surname"));
            bookingDTO.setStart(resultSet.getDate("start"));
            bookingDTO.setEnd(resultSet.getDate("end"));
            bookingDTO.setCategoryName(resultSet.getString("categoryName"));
            bookingDTO.setCost(resultSet.getInt("cost"));
        }
        return bookingDTO;

    }
    @Override
    public List<PaymentType> paymentList() throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "SELECT name FROM payment_type ";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<PaymentType> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            PaymentType paymentType1=new PaymentType();
            paymentType1.setName(resultSet.getString("name"));
            paymentList.add(paymentType1);
        }
        return paymentList;
    }

    @Override
    public void saveBooking(Booking booking) throws SQLException {
        Statement statement = connection.createStatement();

    }

}
