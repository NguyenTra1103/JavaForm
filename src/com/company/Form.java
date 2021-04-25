package com.company;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Form extends JFrame {
    private JPanel rootPanel;
    private JButton btnQuanLyXe;
    private JButton btnQuanLyXeRa;
    private JButton btnMaVao;
    private JButton btnMaRa;
    private JTextField txtMaRa;
    private JButton btnMaBienVao;
    private JTextField txtMaBienVao;
    private JButton btnMaBienRa;
    private JTextField txtMaBienRa;
    private JButton btnMaThe;
    private JButton btnMaBienSo;
    private JButton btnTenKHVao;
    private JButton btnCmnd;
    private JTextField txtMaThe;
    private JTextField txtMaBienSo;
    private JTextField txtKHVao;
    private JTextField txtCmnd;
    private JButton btnTimeIn;
    private JTextField txtTimeIn;
    private JButton btnKHRa;
    private JTextField txtKHRa;
    private JButton btnTimeOut;
    private JTextField txtTimeOut;
    private JTextField txtTimeDo;
    private JButton btnChiPhi;
    private JTextField txtChiPhi;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnXoa;
    private JButton btnThemDanhSach;
    private JButton btnUpdate;
    private JTable table1;
    private JButton btnLoaiXe;
    private JComboBox box;
    private JButton btnTimeDo;
    private JRadioButton radioBtnMay;
    private JRadioButton RadioBtnO;
    private JTextField txtMaVao;
    private JLabel label;
    private JButton btnMathera;
    private JTextField txtMaTheRa;
    private JTextField txtCount;
    private JButton btnXeUse;
    private JButton btnCarUse;
    private JTextField txtCarUse;
    private JButton btnMototemp;
    private JTextField txtMotoTemp;
    private JButton btnCarTemp;
    private JTextField txtCarTemp;
    private JButton btnXeMayRa;
    private JTextField txtXeMayRa;
    private JButton btnOToRa;
    private JTextField txtOToRa;

    DefaultTableModel tableModel = new DefaultTableModel();



    public Form() {
        add(rootPanel);
        setResizable(false);
        setVisible(true);
        setSize(1000, 600);
        loadData();


        Clock th = new Clock(label);
        th.start();




        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaThe.setText("");
                txtMaBienVao.setText("");
                txtKHVao.setText("");
                txtMaBienSo.setText("");
                txtCmnd.setText("");
                txtTimeIn.setText("");
                txtMaVao.setText("");
                txtMaBienVao.setText("");
                txtMaRa.setText("");
                txtMaBienRa.setText("");

                txtTimeOut.setText("");
                txtTimeDo.setText("");
                txtChiPhi.setText("");


            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                if (txtMaThe.getText().equals("")) {
                    sb.append("Mã Thẻ Xe Không Được Để Trống");

                } else {
                    txtMaThe.setBackground(Color.white);

                }

                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(null, sb);
                    return;
                }


                try {
                    Customer cust = new Customer();
                    cust.setMaThe(txtMaThe.getText());
                    cust.setBienSo(txtMaBienSo.getText());
                    cust.setLoaiXe(radioBtnMay.isSelected() ? 1 : 0);
                    cust.setTenKH(txtKHVao.getText());
                    cust.setCMND(txtCmnd.getText());
                    cust.setThoiGianVao(txtTimeIn.getText());
                    cust.setThoiGianRa(txtTimeOut.getText());
                    cust.setThoiGianDo(txtTimeDo.getText());
                    cust.setChiPhi(txtChiPhi.getText());
                    CustomerDao dao = new CustomerDao();
                    dao.insert(cust);


                    JOptionPane.showMessageDialog(null, "Xe đi vào và lưu trong CSDL");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error" + e1.getMessage());
                    e1.printStackTrace();
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*StringBuilder sb = new StringBuilder();
                if (txtMaThe.getText().equals("")) {
                    sb.append("Mã Thẻ Xe Không Được Để Trống");

                } else {
                    txtMaThe.setBackground(Color.white);
                }

                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(null, sb);
                    return;
                }

                try {
                    Customer cust = new Customer();
                    cust.setMaThe(txtMaThe.getText());
                    cust.setBienSo(txtMaBienSo.getText());
                    cust.setLoaiXe(radioBtnMay.isSelected() ? 1 : 0);
                    cust.setTenKH(txtKHVao.getText());
                    cust.setCMND(txtCmnd.getText());
                    cust.setThoiGianVao(txtTimeIn.getText());
                    cust.setThoiGianRa(txtTimeOut.getText());
                    cust.setThoiGianDo(txtTimeDo.getText());
                    cust.setChiPhi(txtChiPhi.getText());

                    CustomerDao dao = new CustomerDao();
                    dao.update(cust);

                    JOptionPane.showMessageDialog(null, "Khách hàng đã được cập nhật vào CSDL");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error" + e1.getMessage());
                    e1.printStackTrace();
                }*/

                try (
                        Connection cn = DatabaseHelper.openConnection();
                        PreparedStatement pst = cn.prepareStatement("update KhachHang set TenKH = ?,ThoiGianVao = ?,ThoiGianRa = ?,ThoiGianDo= ?,ChiPhi = ? where MaThe = ?");
                ) {
                    pst.setString(6, txtMaTheRa.getText());
                   /* pst.setString(1, txtMaBienSo.getText());*/
                   /* pst.setInt(2, radioBtnMay.isSelected() ? 1 : 0);*/
                    pst.setString(1, txtKHVao.getText());
                   /* pst.setString(4, txtCmnd.getText());*/
                    pst.setString(2, txtTimeIn.getText());
                    pst.setString(3, txtTimeOut.getText());
                    pst.setString(4, txtTimeDo.getText());
                    pst.setString(5, txtChiPhi.getText());
                    pst.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null,"Cap Nhat Thanh Cong");
                }catch (Exception exception) {
                    System.out.println(exception.toString());
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /* StringBuilder sb = new StringBuilder();
                if (txtMaThe.getText().equals("")) {
                    sb.append("Mã Thẻ Xe Không Được Để Trống");

                } else {
                    txtMaThe.setBackground(Color.white);

                }

                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(null, sb);
                    return;
                }

                try {
                    CustomerDao dao = new CustomerDao();
                    dao.delete(txtMaThe.getText());

                    JOptionPane.showMessageDialog(null, "Xe rời khỏi và đã được xoá khỏi CSDL");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error" + e1.getMessage());
                    e1.printStackTrace();
                }*/
                try (
                        Connection cn = DatabaseHelper.openConnection();
                        PreparedStatement pst = cn.prepareStatement("Delete KhachHang  where MaThe = ?");
                ) {
                    pst.setString(1,table1.getValueAt(table1.getSelectedRow(),0) + "");
                  /*  pst.setString(2, txtMaBienSo.getText());
                    pst.setInt(3, radioBtnMay.isSelected() ? 1 : 0);
                    pst.setString(4, txtKHVao.getText());
                    pst.setString(5, txtCmnd.getText());
                    pst.setString(6, txtTimeIn.getText());
                    pst.setString(7, txtTimeOut.getText());
                    pst.setString(8, txtTimeDo.getText());
                    pst.setString(9, txtChiPhi.getText());*/
                    pst.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                   
                    
                    JOptionPane.showMessageDialog(null,"Cap Nhat Thanh Cong");
                }catch (Exception exception) {
                    System.out.println(exception.toString());
                }
                
            }
        });
        btnMaVao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtMaVao.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Ma so Xe can phai tim kiem");
                    return;
                }
                try {
                    CustomerDao dao = new CustomerDao();
                    Customer cust = dao.findByIdTemp(txtMaVao.getText());
                    if (cust != null) {
                        txtMaThe.setText(cust.getMaThe());
                        txtKHVao.setText(cust.getTenKH());
                        txtCmnd.setText(cust.getCMND());
                        txtTimeIn.setText(cust.getThoiGianVao());
                        radioBtnMay.setSelected(cust.getLoaiXe() == 1);
                        RadioBtnO.setSelected(cust.getLoaiXe() == 0);
                        txtMaBienSo.setText(cust.getBienSo());

                    } else {
                        JOptionPane.showMessageDialog(null, " Khong tim thay thong tin gui xe Khach Hang");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }
        });
        btnMaBienVao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtMaBienVao.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Ma so Xe can phai tim kiem");
                    return;
                }
                try {
                    CustomerDao dao = new CustomerDao();
                    Customer cust = dao.findByIdLicense(txtMaBienVao.getText());
                    if (cust != null) {

                        txtMaThe.setText(cust.getMaThe());
                        txtMaBienSo.setText(cust.getBienSo());
                        txtKHVao.setText(cust.getTenKH());
                        txtCmnd.setText(cust.getCMND());
                        txtTimeIn.setText(cust.getThoiGianVao());

                        radioBtnMay.setSelected(cust.getLoaiXe() == 1);
                        RadioBtnO.setSelected(cust.getLoaiXe() == 0);

                    } else {
                        JOptionPane.showMessageDialog(null, " Khong tim thay thong tin gui xe Khach Hang");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }
        });
        btnMaRa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtMaRa.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Ma so Xe can phai tim kiem");
                    return;
                }
                try {
                    CustomerDao dao = new CustomerDao();
                    Customer cust = dao.FindTempOunt(txtMaRa.getText());
                    if (cust != null) {

                        txtMaTheRa.setText(cust.getMaThe());

                        txtKHRa.setText(cust.getTenKH());
                        txtTimeIn.setText(cust.getThoiGianVao());
                        txtTimeOut.setText(cust.getThoiGianVao());

                        txtTimeDo.setText(cust.getThoiGianDo());
                        txtChiPhi.setText(cust.getChiPhi());

                    } else {
                        JOptionPane.showMessageDialog(null, " Khong tim thay thong tin gui xe Khach Hang");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }


            }
        });

        btnMaBienRa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtMaBienRa.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Ma so Xe can phai tim kiem");
                    return;
                }
                try {
                    CustomerDao dao = new CustomerDao();
                    Customer ct= dao.findOutBien(txtMaBienRa.getText());
                    if (ct != null) {

                        txtMaRa.setText(ct.getBienSo());

                        txtKHRa.setText(ct.getTenKH());

                        txtTimeOut.setText(ct.getThoiGianRa());
                        txtTimeDo.setText(ct.getThoiGianDo());

                    } else {
                        JOptionPane.showMessageDialog(null, " Khong tim thay thong tin gui xe Khach Hang");
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }
        });
        btnTimeIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                java.util.Date now = new Date();
                String st = format.format(now);
                txtTimeIn.setText(String.valueOf(st));
               /* SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                java.util.Date now = new Date();
                txtTimeIn.setText(String.valueOf(now));*/


            }
        });
        btnTimeOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                java.util.Date now = new Date();
                String st = format.format(now);

                txtTimeOut.setText(String.valueOf(st));
            }
        });
        btnTimeDo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    Date date1 = format.parse(txtTimeIn.getText());
                    Date date2 = format.parse(txtTimeOut.getText());

                    long difference = date2.getTime() - date1.getTime();
                    long diffSecond = difference / 1000 % 60;
                    float diffMinutes = difference / (60 * 1000) % 60;
                    long diffHours = difference / (60 * 60 * 1000) % 24;
                    long diffDay = difference / (24 * 60 * 60 * 1000);

                    txtTimeDo.setText(diffDay + "ngày " + diffHours + " " + ":" + diffMinutes + ":" + diffSecond + "");
                    /* txtTimeDo.setText(diffHours +"");*/
                    float hours = diffDay * 24 + diffHours + diffMinutes / 60;
                    if (radioBtnMay.getModel().isSelected()) {
                        float chiphi = hours * 2000;
                        txtChiPhi.setText(chiphi + "");
                    } else {
                        float chiphi = hours * 5000;
                        txtChiPhi.setText(chiphi + "");
                    }


                } catch (ParseException exception) {
                    exception.printStackTrace();
                }

            }
        });

        btnThemDanhSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                try (
                        Connection cn = DatabaseHelper.openConnection();
                        PreparedStatement pst = cn.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?)");
                ) {
                    pst.setString(1, txtMaThe.getText());
                    pst.setString(2, txtMaBienSo.getText());
                    pst.setInt(3, radioBtnMay.isSelected() ? 1 : 0);
                    pst.setString(4, txtKHVao.getText());
                    pst.setString(5, txtCmnd.getText());
                    pst.setString(6, txtTimeIn.getText());
                    pst.setString(7, txtTimeOut.getText());
                    pst.setString(8, txtTimeDo.getText());
                    pst.setString(9, txtChiPhi.getText());
                    int check = pst.executeUpdate();
                    if (check > 0) {
                        JOptionPane.showMessageDialog(null, "Them Thanh Cong");
                        tableModel.setRowCount(0);
                        loadData();
                    } else {

                    }
                }catch (Exception exception) {
                    System.out.println(exception.toString());
                }
            }

        });
        btnChiPhi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"So tien quy khach la : " + txtChiPhi.getText()+"\n Hen gap lai Quy Khach");
            }
        });
        btnXeUse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try(
                       Connection cn = DatabaseHelper.openConnection();

                       ){ Statement s = cn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       ResultSet r = s.executeQuery("select * from KhachHang where ChiPhi = 0 and LoaiXe = 1");
                       r.last();
                       int count = r.getRow();
                       r.beforeFirst();
                       txtCount.setText(count + " ");
                       txtMotoTemp.setText(String.valueOf(Math.subtractExact(8000,count)));

               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               } catch (Exception exception) {
                   exception.printStackTrace();
               }
            }
        });
        btnCarUse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        Connection cn = DatabaseHelper.openConnection();

                ){ Statement s = cn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet r = s.executeQuery("select * from KhachHang where ChiPhi = 0 and LoaiXe = 0");
                    r.last();
                    int countcar = r.getRow();
                    r.beforeFirst();
                    txtCarUse.setText(countcar + " ");
                    txtCarTemp.setText(String.valueOf(Math.subtractExact(9000,countcar)));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnXeMayRa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        Connection cn = DatabaseHelper.openConnection();

                ){ Statement s = cn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet r = s.executeQuery("select * from KhachHang where ChiPhi > 0 and LoaiXe = 1");
                    r.last();
                    int ct = r.getRow();
                    r.beforeFirst();
                    txtXeMayRa.setText(ct + " ");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnOToRa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        Connection cn = DatabaseHelper.openConnection();

                ){ Statement s = cn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet r = s.executeQuery("select * from KhachHang where ChiPhi > 0 and LoaiXe = 0");
                    r.last();
                    int co = r.getRow();
                    r.beforeFirst();
                    txtOToRa.setText(co + " ");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnMaBienSo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tesseract tesseract = new Tesseract();
                try{
                    tesseract.setDatapath("D:\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
                    String text = tesseract.doOCR(new File("D:\\Downloads\\bien3.jpeg"));

                    txtMaBienSo.setText(text + "");
                }catch (TesseractException e2){
                    e2.printStackTrace();
                }
            }
        });
    }

    public void loadData() {
        try
        { Connection connection = DatabaseHelper.openConnection();
            int number;
            Vector row, column;

            column = new Vector();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from KhachHang");
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            for (int i = 1; i <= number; i++) {
                column.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));

                }
                tableModel.addRow(row);
                table1.setModel(tableModel);

            }
            table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (table1.getSelectedRow() >= 0) {
                        txtMaThe.setText(table1.getValueAt(table1.getSelectedRow(), 0) + "");
                        txtMaBienSo.setText(table1.getValueAt(table1.getSelectedRow(), 1) + "");
                       /* radioBtnMay.setText(table1.getValueAt(table1.getSelectedRow(), 2) + "");
                        RadioBtnO.setText(table1.getValueAt(table1.getSelectedRow(), 2) + "");*/
                        txtKHVao.setText(table1.getValueAt(table1.getSelectedRow(), 3) + "");
                        txtCmnd.setText(table1.getValueAt(table1.getSelectedRow(), 4) + "");
                        txtTimeIn.setText(table1.getValueAt(table1.getSelectedRow(), 5) + "");
                        txtTimeOut.setText(table1.getValueAt(table1.getSelectedRow(), 6) + "");
                        txtTimeDo.setText(table1.getValueAt(table1.getSelectedRow(), 7) + "");
                        txtChiPhi.setText(table1.getValueAt(table1.getSelectedRow(), 8) + "");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }



    }



