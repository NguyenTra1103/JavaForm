package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CustomerDao {
    public boolean insert(Customer cust) throws Exception {
        String sql = "insert into KhachHang(MaThe,BienSo,LoaiXe,TenKH,CMND,ThoiGianVao,ThoiGianRa,ThoiGianDo,ChiPhi) values (?,?,?,?,?,?,?,?,?)";

        try (
                Connection connection = DatabaseHelper.openConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {
            pst.setString(1, cust.getMaThe());
            pst.setString(2, cust.getBienSo());
            pst.setInt(3, cust.getLoaiXe());
            pst.setString(4, cust.getTenKH());
            pst.setString(5, cust.getCMND());
            pst.setString(6, cust.getThoiGianVao());
            pst.setString(7, cust.getThoiGianRa());
            pst.setString(8, cust.getThoiGianDo());
            pst.setString(9, cust.getChiPhi());

            return pst.executeUpdate() > 0;


        }
    }

    public boolean update(Customer cust) throws Exception {
        String sql = "Update KhachHang set BienSo = ?, LoaiXe = ?,TenKH = ?,CMND = ?,ThoiGianVao = ?,ThoiGianRa = ?,ThoiGianDo= ?,ChiPhi = ? where MaThe = ?";
        try (
                Connection connection = DatabaseHelper.openConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {

            pst.setString(1, cust.getBienSo());
            pst.setInt(2, cust.getLoaiXe());
            pst.setString(3, cust.getTenKH());
            pst.setString(4, cust.getCMND());
            pst.setString(5, cust.getThoiGianVao());
            pst.setString(6, cust.getThoiGianRa());
            pst.setString(7, cust.getThoiGianDo());
            pst.setString(8, cust.getChiPhi());
            pst.setString(9, cust.getMaThe());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaThe) throws Exception {
        String sql = "DELETE from KhachHang  where MaThe = ?";
        try (
                Connection connection = DatabaseHelper.openConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {


            pst.setString(1, MaThe);
            return pst.executeUpdate() > 0;
        }
    }

    public Customer findByIdTemp(String MaThe) throws Exception {
        String sql = "select * from KhachHang where MaThe = ?";
        try (
                Connection cn = DatabaseHelper.openConnection();
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, MaThe);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer();

                cust.setBienSo(rs.getString("BienSo"));
                cust.setMaThe(rs.getString("MaThe"));
                cust.setLoaiXe(rs.getInt("LoaiXe"));
                cust.setTenKH(rs.getString("TenKH"));
                cust.setCMND(rs.getString("CMND"));
                cust.setThoiGianVao(rs.getString("ThoiGianVao"));
                return (cust);
            }
        }
        return null;
    }

    public Customer findByIdLicense(String BienSo) throws Exception {
        String sql = "select * from KhachHang where BienSo = ?";
        try (
                Connection cn = DatabaseHelper.openConnection();
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, BienSo);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer();
                cust.setMaThe(rs.getString("MaThe"));
                cust.setBienSo(rs.getString("BienSo"));
                cust.setLoaiXe(rs.getInt("LoaiXe"));
                cust.setTenKH(rs.getString("TenKH"));
                cust.setCMND(rs.getString("CMND"));
                cust.setThoiGianVao(rs.getString("ThoiGianVao"));

                return (cust);
            }
        }
        return null;
    }

    public Customer FindTempOunt(String MaThe) throws Exception {
        String sql = "select * from KhachHang where MaThe = ?";
        try (
                Connection cn = DatabaseHelper.openConnection();
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, MaThe);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer();
                cust.setMaThe(rs.getString("MaThe"));
                cust.setThoiGianVao(rs.getString("ThoiGianVao"));
                cust.setTenKH(rs.getString("TenKH"));
                cust.setThoiGianRa(rs.getString("ThoiGianRa"));
                cust.setThoiGianDo(rs.getString("ThoiGianDo"));
                cust.setChiPhi(rs.getString("ChiPhi"));
                return (cust);
            }
        }
        return null;
    }

    public Customer findOutBien(String BienSo) throws Exception {
        String sql = "select * from KhachHang where BienSo = ?";
        try (
                Connection cn = DatabaseHelper.openConnection();
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, BienSo);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer();
                cust.setMaThe(rs.getString("MaThe"));
                cust.setBienSo(rs.getString("BienSo"));
                cust.setTenKH(rs.getString("TenKH"));
                cust.setThoiGianRa(rs.getString("ThoiGianRa"));
                cust.setThoiGianDo(rs.getString("ThoiGianDo"));
                cust.setChiPhi(rs.getString("ChiPhi"));
                return (cust);
            }
        }
        return null;
    }

  }
