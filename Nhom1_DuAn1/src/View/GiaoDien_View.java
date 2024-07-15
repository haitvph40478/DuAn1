/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.NhanVien;
import java.awt.Color;

/**
 *
 * @author GIGABYTE
 */
public class GiaoDien_View extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDien_View
     */
    Color DefauColor, ClickColor;
    public static NhanVien nhanVien = null;
    public GiaoDien_View() {
        initComponents();
        setlayout();

    }
    
    public GiaoDien_View(NhanVien nv) {
        initComponents();
        setlayout();
        this.nhanVien = nv;
        
        txtMaNv.setText(nhanVien.getMaNV());
        txtTenNV.setText(nhanVien.getTenNV());
        txtCv.setText(nhanVien.getChucVu().getTenCV());
    }

    public static NhanVien getNhanVien() {
        return nhanVien;
    }

    public static void setNhanVien(NhanVien nhanVien) {
        GiaoDien_View.nhanVien = nhanVien;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu1 = new View.menu();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaNv = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtCv = new javax.swing.JTextField();
        pnlBanHang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlSanPham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlHoaDon = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlVoucher = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlThoat = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jDesktopPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel9.setText("Thông tin nhân viên");

        jLabel10.setText("Mã nhân viên:");

        jLabel11.setText("Tên nhân viên: ");

        jLabel12.setText("Chức vụ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCv, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pnlBanHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBanHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBanHangMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Calendar.png"))); // NOI18N
        jLabel1.setText("Bán hàng");

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSanPham.setBackground(new java.awt.Color(255, 255, 255));
        pnlSanPham.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlSanPham.setRequestFocusEnabled(false);
        pnlSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSanPhamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSanPhamMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Control panel.png"))); // NOI18N
        jLabel2.setText("Sản phẩm");

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pnlNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnlNhanVien.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlNhanVien.setRequestFocusEnabled(false);
        pnlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlNhanVienMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Clien list.png"))); // NOI18N
        jLabel3.setText("Nhân viên");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlKhachHang.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlKhachHangMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/User group.png"))); // NOI18N
        jLabel4.setText("Khách hàng");

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(35, 35, 35))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHoaDonMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/List.png"))); // NOI18N
        jLabel5.setText("Hoá đơn");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlVoucher.setBackground(new java.awt.Color(255, 255, 255));
        pnlVoucher.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlVoucherMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlVoucherMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Euro.png"))); // NOI18N
        jLabel6.setText("Voucher");

        javax.swing.GroupLayout pnlVoucherLayout = new javax.swing.GroupLayout(pnlVoucher);
        pnlVoucher.setLayout(pnlVoucherLayout);
        pnlVoucherLayout.setHorizontalGroup(
            pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVoucherLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVoucherLayout.setVerticalGroup(
            pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVoucherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pnlThongKe.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongKe.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlThongKeMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Diagram.png"))); // NOI18N
        jLabel7.setText("Thống kê");

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongKeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pnlThoat.setBackground(new java.awt.Color(255, 255, 255));
        pnlThoat.setPreferredSize(new java.awt.Dimension(172, 46));
        pnlThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThoatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlThoatMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Exit.png"))); // NOI18N
        jLabel8.setText("Thoát");

        javax.swing.GroupLayout pnlThoatLayout = new javax.swing.GroupLayout(pnlThoat);
        pnlThoat.setLayout(pnlThoatLayout);
        pnlThoatLayout.setHorizontalGroup(
            pnlThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThoatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThoatLayout.setVerticalGroup(
            pnlThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThoatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menu1Layout.createSequentialGroup()
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(menu1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pnlBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menu1Layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pnlNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(pnlKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(pnlHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(pnlVoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(pnlThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(pnlThoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1227, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanel))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPanel)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBanHangMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(ClickColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlBanHangMousePressed

    private void pnlSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSanPhamMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(ClickColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlSanPhamMousePressed

    private void pnlNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNhanVienMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(ClickColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlNhanVienMousePressed

    private void pnlKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachHangMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(ClickColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlKhachHangMousePressed

    private void pnlHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(ClickColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlHoaDonMousePressed

    private void pnlVoucherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVoucherMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(ClickColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlVoucherMousePressed

    private void pnlThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(ClickColor);
        pnlThoat.setBackground(DefauColor);
    }//GEN-LAST:event_pnlThongKeMousePressed

    private void pnlThoatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThoatMousePressed
        // TODO add your handling code here:
        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(ClickColor);
    }//GEN-LAST:event_pnlThoatMousePressed

    private void pnlBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBanHangMouseClicked
        // TODO add your handling code here:
        BanHang_View bh = new BanHang_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(bh).setVisible(true);
    }//GEN-LAST:event_pnlBanHangMouseClicked

    private void pnlVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVoucherMouseClicked
        // TODO add your handling code here:
        Voucher_View vo = new Voucher_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlVoucherMouseClicked

    private void pnlSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSanPhamMouseClicked
        // TODO add your handling code here:
        SanPham_View vo = new SanPham_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlSanPhamMouseClicked

    private void pnlNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNhanVienMouseClicked
        // TODO add your handling code here:
        NhanVien_View vo = new NhanVien_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlNhanVienMouseClicked

    private void pnlKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachHangMouseClicked
        // TODO add your handling code here:
        KhachHang_View vo = new KhachHang_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlKhachHangMouseClicked

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        // TODO add your handling code here:
        HoaDon_View vo = new HoaDon_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void pnlThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseClicked
        // TODO add your handling code here:
        ThongKe_View vo = new ThongKe_View();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(vo).setVisible(true);
    }//GEN-LAST:event_pnlThongKeMouseClicked

    private void pnlThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_pnlThoatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDien_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDien_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDien_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDien_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDien_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private View.menu menu1;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThoat;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlVoucher;
    private javax.swing.JTextField txtCv;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables

    private void setlayout() {
        DefauColor = new Color(255, 255, 255);
        ClickColor = new Color(0, 255, 255);

        pnlBanHang.setBackground(DefauColor);
        pnlSanPham.setBackground(DefauColor);
        pnlNhanVien.setBackground(DefauColor);
        pnlKhachHang.setBackground(DefauColor);
        pnlHoaDon.setBackground(DefauColor);
        pnlVoucher.setBackground(DefauColor);
        pnlThongKe.setBackground(DefauColor);
        pnlThoat.setBackground(DefauColor);
    }
}
