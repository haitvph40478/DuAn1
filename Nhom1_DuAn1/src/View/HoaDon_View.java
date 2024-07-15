/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import Repository.HoaDonRepo;
import Repository.HoaDonChiTietRepo;
import Repository.HoaDonRepository;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.ExportPDF;

/**
 *
 * @author GIGABYTE
 */
public class HoaDon_View extends javax.swing.JInternalFrame {

    /**
     * Creates new form BanHang_View
     */
    HoaDonRepo repo = new HoaDonRepo();
    HoaDonChiTietRepo hdctrepo = new HoaDonChiTietRepo();
    HoaDonRepository hdRepo = new HoaDonRepository();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    List<HoaDon> listHD = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    HoaDon hoaDon = null;

    public HoaDon_View() {
        initComponents();
        setBorder();
        model = (DefaultTableModel) tblHoaDon.getModel();
        model1 = (DefaultTableModel) tblChiTietHoaDon.getModel();
        model2 = (DefaultTableModel) tblLSHD.getModel();
        fillTable(hdRepo.getAllByTrangThai(""));
//        fillTableLSHT();
//        fillTableHDCT();
        AddPleacehoderStyle(txtMaTimKiem);
    }

    public void AddPleacehoderStyle(JTextField textField) {
        java.awt.Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }

    public void RemovePleacehoderStyle(JTextField textField) {
        java.awt.Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }

    public void fillTable(List<HoaDon> lst) {

        int stt = tblHoaDon.getSelectedRow();
        stt += 1;
        listHD = lst;
        model.setRowCount(0);
        for (HoaDon hd : lst) {
            model.addRow(new Object[]{
                stt += 1,
                hd.getMaHoaDon(),
                hd.getNhanVien() == null ? "NV ao" : hd.getNhanVien().getMaNV(),
                hd.getKhachHang() == null ? "Khách Lẻ" : hd.getKhachHang().getTenKH(),
                hd.getKhachHang() == null ? "Khách Lẻ" : hd.getKhachHang().getSDT(),
                hd.getDiaChiNguoiNhan(),
                hd.getTongTien(),
                hd.getNgayTao(),
                hd.getTrangThai().equals("0") ? "Chờ thanh toán" : hd.getTrangThai().equals("1") ? "Đã thanh toán" : "Đã huỷ"
            });

        }
    }

    public void fillTableLSHT() {
        listHD = repo.getAll();
        int stt = tblHoaDon.getSelectedRow();
        stt += 1;

        model2.setRowCount(0);
        for (HoaDon hd : listHD) {
            model2.addRow(new Object[]{
                stt += 1,
                hd.getNgayTao(),
                hd.getIdNhanVien().getMaNV(),
                hd.getIdNhanVien().getTenNV(),
                hd.getTrangThai(),});

        }
    }
    ///

    ///
    public void fillTableHDCT() {
        listHDCT = hdctrepo.getAll();
        model1.setRowCount(0);
        int stt = tblChiTietHoaDon.getSelectedRow();
        stt += 1;
        for (HoaDonChiTiet hdct : listHDCT) {
            model1.addRow(new Object[]{
                stt += 1,
                hdct.getIdHoaDon().getMaHoaDon(),
                hdct.getIdSanPham().getTenSP(),
                hdct.getIdMauSac().getTenMau(),
                hdct.getIdHang().getTenHang(),
                hdct.getGiaTien(),
                hdct.getSoLuong(),
                hdct.getThanhTien()
            });
        }
    }

    void loadTableHoaDonCT() {

    }

//    public void searchByTT() {
//        if (rdoTatCa.isSelected()) {
//            list = repo.getAll();
//            model = (DefaultTableModel) tblHoaDon.getModel();
//            showDataTable(list);
//        } else if (rdoTien.isSelected()) {
//            list = repo.getListByHTTT(1);
//            model = (DefaultTableModel) tblHoaDon.getModel();
//            showDataTable(list);
//        } else if (rdoCK.isSelected()) {
//            list = repo.getListByHTTT(0);
//            model = (DefaultTableModel) tblHoaDon.getModel();
//            showDataTable(list);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaTimKiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        CbbTrangThai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        inexcel = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLSHD = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã Nhân Viên", "Tên Khách Hàng", "SDT", "Địa Chỉ", "Tổng Tiền", "Ngày Tạo", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setText("Tìm kiếm");

        txtMaTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaTimKiemFocusLost(evt);
            }
        });
        txtMaTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaTimKiemKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Tên SP", "Giá Tiền", "SoLuong", "ThanhTien"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblChiTietHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        CbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Chờ Thanh Toán", "Đã Thanh Toán", "Đã huỷ" }));
        CbbTrangThai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbbTrangThaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CbbTrangThaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CbbTrangThaiMouseExited(evt);
            }
        });
        CbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbTrangThaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Trạng Thái Hóa Đơn");

        inexcel.setText("Xuất Danh Sách");
        inexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inexcelActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lịch Sử Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblLSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày ", "Mã NV", "Tên NV", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblLSHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        jButton1.setText("In Hóa Đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(345, 345, 345)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnLamMoi)
                        .addGap(121, 121, 121)
                        .addComponent(inexcel)
                        .addGap(66, 66, 66)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inexcel)
                            .addComponent(jButton1)))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inexcelActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("Hóa Đơn");

            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH HOA DON");

            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MA HD");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("MA NHAN VIEN");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("TEN KHACH HANG");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("SDT ");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("ĐIA CHi ");
            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue("NGAY TAO");

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue("TRANG THAI");

            listHD = repo.getAll();
            for (int i = 0; i < listHD.size(); i++) {
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listHD.get(i).getMaHoaDon());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listHD.get(i).getIdNhanVien().getMaNV());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(listHD.get(i).getIdKhachHang().getTenKH());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listHD.get(i).getIdKhachHang().getSDT());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listHD.get(i).getDiaChiNguoiNhan());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listHD.get(i).getNgayTao());

                cell = row.createCell(7, CellType.NUMERIC);
                cell.setCellValue(listHD.get(i).getTrangThai());

            }

            File f = new File("F://HoaDon.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "in thanh cong F:\\HoaDon");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }

    }//GEN-LAST:event_inexcelActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:

       
        int rowIndex = tblHoaDon.getSelectedRow();
        HoaDon hd = listHD.get(rowIndex);
        System.out.println(hd.getMaHoaDon());
        this.hoaDon = hd;
        listHDCT = hdctrepo.getAll();
        model1.setRowCount(0);
        int stt = tblChiTietHoaDon.getSelectedRow();
        stt += 1;
        for (HoaDonChiTiet hdct : listHDCT) {
            if (hdct.getIdHoaDon().getMaHoaDon().equals(hd.getMaHoaDon())) {
                model1.addRow(new Object[]{
                    stt += 1,
                    hdct.getIdHoaDon().getMaHoaDon(),
                    hdct.getIdSanPham().getTenSP(),
                    hdct.getGiaTien(),
                    hdct.getSoLuong(),
                    hdct.getThanhTien()
                });
            }
        }
        ///bảng lịch sử hóa đơn 
        int sttt = tblLSHD.getSelectedRow();
        model2.setRowCount(0);
        model2.addRow(new Object[]{
            sttt += 1,
            hd.getNgayTao(),
            hd.getNhanVien().getMaNV(),
            hd.getNhanVien().getTenNV(),
            hd.getTrangThai(),});

    }//GEN-LAST:event_tblHoaDonMouseClicked

    public void findCombo() {

        int index = CbbTrangThai.getSelectedIndex();
        if (index == 1) {
            fillTable(hdRepo.getAllByTrangThai("0"));
        } else if (index == 2) {
            fillTable(hdRepo.getAllByTrangThai("1"));
        } else if (index == 3) {
            fillTable(hdRepo.getAllByTrangThai("2"));
        } else {
            fillTable(hdRepo.getAllByTrangThai(""));

        }

    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        fillTable(hdRepo.getAllByTrangThai(""));

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void CbbTrangThaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbbTrangThaiMouseClicked
//        String cbb = (String) CbbTrangThai.getSelectedItem();
//        int ID;
//        System.out.println(cbb);
//        if (cbb.equals("Đã Thanh Toán")) {
//            ID = 1;
//        } else if (cbb.equals("Chưa Thanh Toán")) {
//            ID = 2;
//        } else {
//            ID = 0;
//        }
//        System.out.println(ID);
//        listHD = repo.getAll();
//        model.setRowCount(0);
//        int stt = tblHoaDon.getSelectedRow();
//        stt += 1;
//        for (HoaDon hd : listHD) {
//            if (hd.getTrangthaicbb() == ID) {
//                model.addRow(new Object[]{
//                    stt += 1,
//                    hd.getMaHoaDon(),
//                    hd.getIdNhanVien().getMaNV(),
//                    hd.getIdKhachHang().getTenKH(),
//                    hd.getIdKhachHang().getSDT(),
//                    hd.getDiaChiNguoiNhan(),
//                    hd.getTongTien(),
//                    hd.getNgayTao(),
//                    hd.getTrangThai(),});
//            }
//            if (ID == 0) {
//                fillTable();
//            }
//        }


    }//GEN-LAST:event_CbbTrangThaiMouseClicked

    private void txtMaTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaTimKiemKeyPressed
        // TODO add your handling code here:
        listHD = repo.getAll();
        int stt = tblHoaDon.getSelectedRow();
        stt += 1;
        model.setRowCount(0);
        for (HoaDon hd : listHD) {
            if (hd.getMaHoaDon().equals(txtMaTimKiem.getText())
                    || hd.getIdKhachHang().getSDT().equals(txtMaTimKiem.getText())) {
                System.out.println("Tim thấy");
                model.addRow(new Object[]{
                    stt += 1,
                    hd.getMaHoaDon(),
                    hd.getIdNhanVien().getMaNV(),
                    hd.getIdKhachHang().getTenKH(),
                    hd.getIdKhachHang().getSDT(),
                    hd.getDiaChiNguoiNhan(),
                    hd.getTongTien(),
                    hd.getNgayTao(),
                    hd.getTrangThai(),});
            }
        }
    }//GEN-LAST:event_txtMaTimKiemKeyPressed

    private void txtMaTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaTimKiemFocusGained
        // TODO add your handling code here:
        if (txtMaTimKiem.getText().equals("Mã Hóa Đơn, SDT")) {
            txtMaTimKiem.setText(null);
            txtMaTimKiem.requestFocus();
            RemovePleacehoderStyle(txtMaTimKiem);
        }
    }//GEN-LAST:event_txtMaTimKiemFocusGained

    private void txtMaTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaTimKiemFocusLost
        // TODO add your handling code here:
        if (txtMaTimKiem.getText().length() == 0) {
            AddPleacehoderStyle(txtMaTimKiem);
            txtMaTimKiem.setText("Mã Hóa Đơn, SDT");
        }
    }//GEN-LAST:event_txtMaTimKiemFocusLost

    private void CbbTrangThaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbbTrangThaiMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_CbbTrangThaiMouseEntered

    private void CbbTrangThaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbbTrangThaiMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbTrangThaiMouseExited

    private void CbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbTrangThaiActionPerformed
        findCombo();
    }//GEN-LAST:event_CbbTrangThaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                int rowIndex = tblHoaDon.getSelectedRow();
        HoaDon hd = listHD.get(rowIndex);
        if (this.hoaDon == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        
        if (this.hoaDon.getTrangThai().equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn dã tt");
            return;
        }
                if (this.hoaDon.getTrangThai().equals("2")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn dã tt");
            return;
        }
        try {
            System.out.println(hd.getMaHoaDon());
            ExportPDF.ExportPDF(hd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "in hóa đơn thất bại");
            e.printStackTrace();
            return;
        }
        JOptionPane.showMessageDialog(this, "in hóa đơn thành công");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbTrangThai;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton inexcel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblLSHD;
    private javax.swing.JTextField txtMaTimKiem;
    // End of variables declaration//GEN-END:variables

    private void setBorder() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
}
