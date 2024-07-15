/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Model.ChatLieu;
import Model.Hang;
import Model.MauSac;
import Model.QuaiDeo;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.Size;
import Model.SoNgan;
import Service.ChatLieu_Service;
import Service.Hang_Service;
import Service.MauSac_Service;
import Service.QuaiDeo_Service;
import Service.SanPhamChiTiet_Service;
import Service.SanPham_Service;
import Service.Size_Service;
import Service.SoNgan_Service;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIGABYTE
 */
public class SanPham_View extends javax.swing.JInternalFrame {

    private SanPham_Service sanpham = new SanPham_Service();
    private SanPhamChiTiet_Service SanPhamChiTiet = new SanPhamChiTiet_Service();
    private MauSac_Service mausac = new MauSac_Service();
    private SoNgan_Service songan = new SoNgan_Service();
    private Hang_Service hang = new Hang_Service();
    private QuaiDeo_Service quaideo = new QuaiDeo_Service();
    private Size_Service size = new Size_Service();
    private ChatLieu_Service chatlieu = new ChatLieu_Service();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    /**
     * Creates new form SanPham_View
     */
    public SanPham_View() {
        initComponents();
        setBorder();
        this.fillTable_SanPham(sanpham.getAll_SanPham());
        this.fillTable_SanPhamChiTiet(SanPhamChiTiet.getAll_SanPhamChiTiet());
        this.fillComboBox_Hang(hang.getAll_Hang());
        this.fillComboBox_MauSac(mausac.getAll_Mau());
        this.fillComboBox_QuaiDeo(quaideo.getAll_QuaiDeo());
        this.fillComboBox_SanPham(sanpham.getAll_SanPham());

        this.fillComboBox_Size(size.getAll_Size());
        this.fillComboBox_SoNgan(songan.getAll_SoNgan());
        this.fillComboBox_Hang(hang.getAll_Hang());
        this.fillComboBox_ChatLieu(chatlieu.getAll_ChatLieu());
        clearForm();

//        this.fillComboBox_LocMauSac(mausac.getAll_Mau());
    }

    void fillTable_SanPham(List<SanPham> list) {
        model = (DefaultTableModel) tbSanPham.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");

        int stt = tbSanPham.getSelectedRow();
        stt = stt + 1;
        for (SanPham cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaSP(),
                cl.getTenSP()};
            model.addRow(row);
        }
    }

    void fillTable_SanPhamChiTiet(List<SanPhamChiTiet> list) {
        model = (DefaultTableModel) tbSanPhamChiTiet.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã CTSP");
        model.addColumn("Tên SP");
        model.addColumn("Màu sắc");
        model.addColumn("Chất liệu");
        model.addColumn("Số ngăn");
        model.addColumn("Size");
        model.addColumn("Quai đeo");
        model.addColumn("Hãng");
        model.addColumn("Giá");
        model.addColumn("Số lượng");
        model.addColumn("Tình trạng");

        int stt = tbSanPhamChiTiet.getSelectedRow();
        stt = stt + 1;
        for (SanPhamChiTiet cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaSPCT(),
                cl.getSanpham(),
                cl.getMausac(),
                cl.getChatlieu(),
                cl.getSongan(),
                cl.getSize(),
                cl.getQuaideo(),
                cl.getHang(),
                cl.getGia(),
                cl.getSoluong(),
                cl.getTinhTrang()
            };
            model.addRow(row);
        }
    }

    void fillTable_MauSac(List<MauSac> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (MauSac cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaMau(),
                cl.getTenMau()};
            model.addRow(row);
        }
    }

    void fillTable_ChatLieu(List<ChatLieu> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (ChatLieu cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaChatLieu(),
                cl.getTenChatLieu()};
            model.addRow(row);
        }
    }

    void fillTable_Hang(List<Hang> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (Hang cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaHang(),
                cl.getTenHang()};
            model.addRow(row);
        }
    }

    void fillTable_Size(List<Size> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (Size cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaSize(),
                cl.getTenSize()};
            model.addRow(row);
        }
    }

    void fillTable_QuaiDeo(List<QuaiDeo> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (QuaiDeo cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaQuaiDeo(),
                cl.getTenQuaiDeo()};
            model.addRow(row);
        }
    }

    void fillTable_SoNgan(List<SoNgan> list) {
        model = (DefaultTableModel) tbThuoctinh.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");

        int stt = tbThuoctinh.getSelectedRow();
        stt = stt + 1;
        for (SoNgan cl : list) {
            Object[] row = new Object[]{
                stt = stt + 1,
                cl.getMaSoNgan(),
                cl.getTenSoNgan()};
            model.addRow(row);
        }
    }

    private void fillComboBox_SanPham(List<SanPham> list) {
        cboTenSP.removeAllItems();
        for (SanPham mqh : list) {
            cboTenSP.addItem(mqh);
        }
    }

    private void fillComboBox_MauSac(List<MauSac> list) {
        cboMauSac.removeAllItems();
//        this.fillTable3(mausac.getAll());
        for (MauSac mqh : list) {
            cboMauSac.addItem(mqh);
        }
    }

//    private void fillComboBox_LocMauSac(List<MauSac> list) {
//        cbo_LocMauSac.removeAllItems();
////        this.fillTable3(mausac.getAll());
//        for (MauSac mqh : list) {
//            cbo_LocMauSac.addItem(mqh);
//        }
//    }
    private void fillComboBox_Hang(List<Hang> list) {
        cboHang.removeAllItems();
        for (Hang mqh : list) {
            cboHang.addItem(mqh);
        }
    }

    private void fillComboBox_QuaiDeo(List<QuaiDeo> list) {
        cboQuaiDeo.removeAllItems();
        for (QuaiDeo mqh : list) {
            cboQuaiDeo.addItem(mqh);
        }
    }

    private void fillComboBox_SoNgan(List<SoNgan> list) {
        cboSoNgan.removeAllItems();
        for (SoNgan mqh : list) {
            cboSoNgan.addItem(mqh);
        }
    }

    private void fillComboBox_Size(List<Size> list) {
        cboSize.removeAllItems();
        for (Size mqh : list) {
            cboSize.addItem(mqh);
        }
    }

    private void fillComboBox_ChatLieu(List<ChatLieu> list) {
        cboChatLieu.removeAllItems();
        for (ChatLieu mqh : list) {
            cboChatLieu.addItem(mqh);
        }
    }

    private void setBorder() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }

    void showData(int index) {
        SanPham sp = sanpham.getAll_SanPham().get(index);
        txtMaSanPham.setText(sp.getMaSP());
        txtTenSanPham.setText(sp.getTenSP());
    }

    SanPham readForm() {
        String maSP = txtMaSanPham.getText();
        String tenSP = txtTenSanPham.getText();
        return new SanPham(maSP, tenSP);
    }

    SanPhamChiTiet readForm_SPCT() {
        String maSPCT = txtmaCTSP.getText();
        if (maSPCT.trim().length() == 0 || txtGia.getText().trim().length() == 0 || txtSoLuong.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "");
            return null;
        }

        SanPham sanpham = (SanPham) cboTenSP.getSelectedItem();
        MauSac mausac = (MauSac) cboMauSac.getSelectedItem();
        ChatLieu chatlieu = (ChatLieu) cboChatLieu.getSelectedItem();
        SoNgan songan = (SoNgan) cboSoNgan.getSelectedItem();
        Size size = (Size) cboSize.getSelectedItem();
        QuaiDeo quaideo = (QuaiDeo) cboQuaiDeo.getSelectedItem();
        Hang hang = (Hang) cboHang.getSelectedItem();
        double gia = 0.0;
        Integer soluong = 0;
        try {
            gia = Double.parseDouble(txtGia.getText());
            soluong = Integer.valueOf(txtSoLuong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số");
            return null;
        }
        if (gia <= 0) {
            JOptionPane.showMessageDialog(this, "Giá Phải Lớn Hơn 0");
            return null;
        }
        if (soluong <= 0) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0");
            return null;
        }

        SanPhamChiTiet v = new SanPhamChiTiet();
        if (rdoDangBan.isSelected() == true) {
            v.setTinhTrang("Đang bán");
        } else {
            v.setTinhTrang("Ngừng Bán");
        }

        v.setMaSPCT(maSPCT);
        v.setSanpham(sanpham);
        v.setMausac(mausac);
        v.setChatlieu(chatlieu);
        v.setSongan(songan);
        v.setSize(size);
        v.setQuaideo(quaideo);
        v.setHang(hang);
        v.setGia(gia);
        v.setSoluong(soluong);

        return v;
    }

    ChatLieu readForm_CL() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        ChatLieu v = new ChatLieu();
        v.setMaChatLieu(maSN);
        v.setTenChatLieu(tenSN);

        return v;
    }

    Hang readForm_HG() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        Hang v = new Hang();
        v.setMaHang(maSN);
        v.setTenHang(tenSN);

        return v;
    }

    MauSac readForm_MS() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        MauSac v = new MauSac();
        v.setMaMau(maSN);
        v.setTenMau(tenSN);

        return v;
    }

    QuaiDeo readForm_QD() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        QuaiDeo v = new QuaiDeo();
        v.setMaQuaiDeo(maSN);
        v.setTenQuaiDeo(tenSN);

        return v;
    }

    Size readForm_SZ() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        Size v = new Size();
        v.setMaSize(maSN);
        v.setTenSize(tenSN);

        return v;
    }

    SoNgan readForm_SN() {
        String maSN = txtMathuoctinh.getText();
        String tenSN = txtTenthuoctinh.getText();

        SoNgan v = new SoNgan();
        v.setMaSoNgan(maSN);
        v.setTenSoNgan(tenSN);

        return v;
    }

    public void clearForm() {

        txtMaSanPham.setText("");
        rdoDangBan.setSelected(true);
        txtGia.setText("");
        txtSoLuong.setText("");
        cboChatLieu.setSelectedIndex(0);
        cboHang.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboQuaiDeo.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboSoNgan.setSelectedIndex(0);
        cboTenSP.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnLamMoiSP = new javax.swing.JButton();
        btnChiTietSP = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboSoNgan = new javax.swing.JComboBox<SoNgan>();
        btnMauSac = new javax.swing.JButton();
        cboChatLieu = new javax.swing.JComboBox<ChatLieu>();
        btnChatLieu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<MauSac>();
        btnSoNgan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<Hang>();
        btnQuaiDeo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboQuaiDeo = new javax.swing.JComboBox<QuaiDeo>();
        BtnSize = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<Size>();
        btnHang = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtmaCTSP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboTenSP = new javax.swing.JComboBox<SanPham>();
        jLabel13 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnThemSanPhamChiTiet = new javax.swing.JButton();
        btnSuaSanPhamChiTiet = new javax.swing.JButton();
        btnXoaSPCT = new javax.swing.JButton();
        btnLamMoiSPCT = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        rdoDangBan = new javax.swing.JRadioButton();
        rdoNgungBan = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPhamChiTiet = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cbbLocMau = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMathuoctinh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenthuoctinh = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoSoNgan = new javax.swing.JRadioButton();
        rdoSize = new javax.swing.JRadioButton();
        rdoQuaiDeo = new javax.swing.JRadioButton();
        rdoHang = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        btnThemThuocTinh = new javax.swing.JButton();
        btnSuaThuocTInh = new javax.swing.JButton();
        btnXoaThuocTinh = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbThuoctinh = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setText("Tên sản phẩm:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(txtMaSanPham))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThemSP.setBackground(new java.awt.Color(153, 255, 255));
        btnThemSP.setText("Thêm");
        btnThemSP.setPreferredSize(new java.awt.Dimension(77, 23));
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setBackground(new java.awt.Color(153, 255, 255));
        btnSuaSP.setText("Sửa");
        btnSuaSP.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setBackground(new java.awt.Color(153, 255, 255));
        btnLamMoiSP.setText("Làm mới");
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        btnChiTietSP.setBackground(new java.awt.Color(153, 255, 255));
        btnChiTietSP.setText("Chi tiết sản phẩm");
        btnChiTietSP.setPreferredSize(new java.awt.Dimension(77, 23));
        btnChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        jLabel1.setText("Tìm kiếm: ");

        txtTimKiemSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemSanPhamMouseClicked(evt);
            }
        });
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel5.setText("Màu sắc: ");

        cboSoNgan.setModel(new javax.swing.DefaultComboBoxModel<SoNgan>());
        cboSoNgan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSoNganActionPerformed(evt);
            }
        });

        btnMauSac.setBackground(new java.awt.Color(102, 255, 255));
        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        btnMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMauSacMouseClicked(evt);
            }
        });
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieu>());

        btnChatLieu.setBackground(new java.awt.Color(102, 255, 255));
        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        jLabel6.setText("Chất liệu:");

        jLabel7.setText("Số Ngăn:");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<MauSac>());
        cboMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauSacActionPerformed(evt);
            }
        });

        btnSoNgan.setBackground(new java.awt.Color(102, 255, 255));
        btnSoNgan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        btnSoNgan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoNganActionPerformed(evt);
            }
        });

        jLabel8.setText("Quai đeo:");

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<Hang>());

        btnQuaiDeo.setBackground(new java.awt.Color(102, 255, 255));
        btnQuaiDeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        btnQuaiDeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaiDeoActionPerformed(evt);
            }
        });

        jLabel9.setText("Size: ");

        cboQuaiDeo.setModel(new javax.swing.DefaultComboBoxModel<QuaiDeo>());

        BtnSize.setBackground(new java.awt.Color(102, 255, 255));
        BtnSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        BtnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSizeActionPerformed(evt);
            }
        });

        jLabel10.setText("Hãng: ");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<Size>());

        btnHang.setBackground(new java.awt.Color(102, 255, 255));
        btnHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cong1.png"))); // NOI18N
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã CTSP: ");

        txtmaCTSP.setMinimumSize(new java.awt.Dimension(72, 22));

        jLabel12.setText("Tên sản phẩm: ");

        cboTenSP.setModel(new javax.swing.DefaultComboBoxModel<SanPham>());

        jLabel13.setText("Giá: ");

        jLabel16.setText("Số lượng: ");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThemSanPhamChiTiet.setBackground(new java.awt.Color(102, 255, 255));
        btnThemSanPhamChiTiet.setText("Thêm");
        btnThemSanPhamChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamChiTietActionPerformed(evt);
            }
        });

        btnSuaSanPhamChiTiet.setBackground(new java.awt.Color(102, 255, 255));
        btnSuaSanPhamChiTiet.setText("Sửa");
        btnSuaSanPhamChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamChiTietActionPerformed(evt);
            }
        });

        btnXoaSPCT.setBackground(new java.awt.Color(102, 255, 255));
        btnXoaSPCT.setText("Xoá");
        btnXoaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPCTActionPerformed(evt);
            }
        });

        btnLamMoiSPCT.setBackground(new java.awt.Color(102, 255, 255));
        btnLamMoiSPCT.setText("Làm mới");
        btnLamMoiSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoiSPCT)
                    .addComponent(btnSuaSanPhamChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPhamChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSanPhamChiTiet)
                .addGap(18, 18, 18)
                .addComponent(btnSuaSanPhamChiTiet)
                .addGap(18, 18, 18)
                .addComponent(btnXoaSPCT)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiSPCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("Trạng Thái:");

        buttonGroup2.add(rdoDangBan);
        rdoDangBan.setText("Đang Bán");

        buttonGroup2.add(rdoNgungBan);
        rdoNgungBan.setText("Ngừng Bán");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmaCTSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMauSac)
                .addGap(139, 139, 139)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel17))
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rdoDangBan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgungBan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboHang, 0, 220, Short.MAX_VALUE)
                            .addComponent(cboSoNgan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboQuaiDeo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSize, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSoNgan)
                                .addComponent(BtnSize, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnQuaiDeo))
                            .addComponent(btnHang)
                            .addComponent(btnChatLieu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel11)
                                                .addComponent(txtmaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7)
                                                .addComponent(cboSoNgan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnSoNgan))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(cboQuaiDeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnQuaiDeo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel9)
                                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(BtnSize, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(btnHang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnChatLieu)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnMauSac)
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rdoDangBan)
                    .addComponent(rdoNgungBan))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSanPhamChiTiet);

        jLabel4.setText("Tìm kiếm: ");

        cbbLocMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Màu Đen", "Màu Trắng", "Màu Xanh", "Màu Xám" }));
        cbbLocMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLocMauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbLocMauMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel3);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setText("Mã thuộc tính: ");

        jLabel15.setText("Tên thuộc tính: ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(37, 37, 37)
                        .addComponent(txtMathuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenthuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMathuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenthuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauSacMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoSoNgan);
        rdoSoNgan.setText("Số ngăn");
        rdoSoNgan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSoNganMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoSize);
        rdoSize.setText("Size");
        rdoSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSizeMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoQuaiDeo);
        rdoQuaiDeo.setText("Quai đeo");
        rdoQuaiDeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoQuaiDeoMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoHang);
        rdoHang.setText("Hãng");
        rdoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdoChatLieu)
                    .addComponent(rdoMauSac, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoSoNgan, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoQuaiDeo)
                    .addComponent(rdoHang)
                    .addComponent(rdoSize))
                .addGap(49, 49, 49))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoSize))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoChatLieu)
                    .addComponent(rdoQuaiDeo))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSoNgan)
                    .addComponent(rdoHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThemThuocTinh.setBackground(new java.awt.Color(102, 255, 255));
        btnThemThuocTinh.setText("Thêm");
        btnThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocTinhActionPerformed(evt);
            }
        });

        btnSuaThuocTInh.setBackground(new java.awt.Color(102, 255, 255));
        btnSuaThuocTInh.setText("Sửa");
        btnSuaThuocTInh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTInhActionPerformed(evt);
            }
        });

        btnXoaThuocTinh.setBackground(new java.awt.Color(102, 255, 255));
        btnXoaThuocTinh.setText("Xoá");
        btnXoaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuocTinhActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(102, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaThuocTInh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnThemThuocTinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSuaThuocTInh)
                .addGap(27, 27, 27)
                .addComponent(btnXoaThuocTinh)
                .addGap(26, 26, 26)
                .addComponent(btnLamMoi)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbThuoctinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbThuoctinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThuoctinhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbThuoctinh);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:

        index = tbSanPham.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
        // TODO add your handling code here:
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        fillTable_SanPham(sanpham.getAll_SanPham());
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        SanPham sp = this.readForm();
        if (sanpham.them(sp) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            this.fillTable_SanPham(sanpham.getAll_SanPham());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        // TODO add your handling code here:
        SanPham sp = this.readForm();
        index = tbSanPham.getSelectedRow();
        String ma = tbSanPham.getValueAt(index, 1).toString();
        if (sanpham.sua(sp, ma) > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            this.fillTable_SanPham(sanpham.getAll_SanPham());
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSPActionPerformed
        // TODO add your handling code here:
        int banghi = tbSanPham.getSelectedRow();
        if (banghi == 0) {
            new ChiTietSanPham01_View().setVisible(true);
        }

    }//GEN-LAST:event_btnChiTietSPActionPerformed

    private void btnMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMauSacMouseClicked

    }//GEN-LAST:event_btnMauSacMouseClicked

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        // TODO add your handling code here:
        new MauSacDiaLog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_MauSac(mausac.getAll_Mau());
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        // TODO add your handling code here:
        new ChatLieuDiaLog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_ChatLieu(chatlieu.getAll_ChatLieu());
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnSoNganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoNganActionPerformed
        // TODO add your handling code here:
        new SoNgangDialog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_SoNgan(songan.getAll_SoNgan());
    }//GEN-LAST:event_btnSoNganActionPerformed

    private void btnQuaiDeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaiDeoActionPerformed
        // TODO add your handling code here:
        new QuaiDeoDialog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_QuaiDeo(quaideo.getAll_QuaiDeo());
    }//GEN-LAST:event_btnQuaiDeoActionPerformed

    private void BtnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSizeActionPerformed
        // TODO add your handling code here:
        new SizeDialog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_Size(size.getAll_Size());
    }//GEN-LAST:event_BtnSizeActionPerformed

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        // TODO add your handling code here:
        new HangDialog(new javax.swing.JFrame(), true).setVisible(true);
        this.fillComboBox_Hang(hang.getAll_Hang());
    }//GEN-LAST:event_btnHangActionPerformed

    private void tbSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamChiTietMouseClicked
        int indexj = tbSanPhamChiTiet.getSelectedRow();
        String maSPCT = (String) tbSanPhamChiTiet.getValueAt(indexj, 1);
        double gia = (double) tbSanPhamChiTiet.getValueAt(indexj, 9);
        int soluong = (int) tbSanPhamChiTiet.getValueAt(indexj, 10);
        txtmaCTSP.setText(maSPCT);
        txtGia.setText(String.valueOf(gia));
        txtSoLuong.setText(String.valueOf(soluong));
        
        Object ten = tbSanPhamChiTiet.getValueAt(indexj, 2);
        Object mauSac =   tbSanPhamChiTiet.getValueAt(indexj, 3);
        Object chatLieu = tbSanPhamChiTiet.getValueAt(indexj, 4);
        Object soNgan = tbSanPhamChiTiet.getValueAt(indexj, 5);
        Object size = tbSanPhamChiTiet.getValueAt(indexj, 6);
        Object quaiDeo = tbSanPhamChiTiet.getValueAt(indexj, 7);
        Object hang = tbSanPhamChiTiet.getValueAt(indexj, 8);
            

        
        int tenCount = cboTenSP.getItemCount();
        for (int i = 0; i < tenCount; i++) {
            Object l = cboTenSP.getItemAt(i);
            System.out.println(l.toString());
            if (l.toString().equals(ten.toString())) {
                cboTenSP.setSelectedIndex(i);
                break;
            }
        }
        
        int mauSacCount = cboMauSac.getItemCount();
        for (int i = 0; i < mauSacCount; i++) {
            Object l = cboMauSac.getItemAt(i);
            if (l.toString().equals(mauSac.toString())) {
                cboMauSac.setSelectedIndex(i);
                break;
            }
        }
        
        int chatLieuCount = cboChatLieu.getItemCount();
        for (int i = 0; i < chatLieuCount; i++) {
            Object l = cboChatLieu.getItemAt(i);
            if (l.toString().equals(chatLieu.toString())) {
                cboChatLieu.setSelectedIndex(i);
                break;
            }
        }
        
        int soNganCount = cboSoNgan.getItemCount();
        for (int i = 0; i < soNganCount; i++) {
            Object l = cboSoNgan.getItemAt(i);
            if (l.toString().equals(soNgan.toString())) {
                cboSoNgan.setSelectedIndex(i);
                break;
            }
        }
        int sizeCount = cboSize.getItemCount();
        for (int i = 0; i < sizeCount; i++) {
            Object l = cboSize.getItemAt(i);
            if (l.toString().equals(size.toString())) {
                cboSize.setSelectedIndex(i);
                break;
            }
        }
        
        int quaiDeoCount = cboQuaiDeo.getItemCount();
        for (int i = 0; i < quaiDeoCount; i++) {
            Object l = cboQuaiDeo.getItemAt(i);
            if (l.toString().equals(quaiDeo.toString())) {
                cboQuaiDeo.setSelectedIndex(i);
                break;
            }
        }
        
        
        int hangCount = cboHang.getItemCount();
        for (int i = 0; i < hangCount; i++) {
            Object l = cboHang.getItemAt(i);
            if (l.toString().equals(hang.toString())) {
                cboHang.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tbSanPhamChiTietMouseClicked

    private void rdoMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauSacMouseClicked
        // TODO add your handling code here:
        this.fillTable_MauSac(mausac.getAll_Mau());
    }//GEN-LAST:event_rdoMauSacMouseClicked

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        // TODO add your handling code here:
        this.fillTable_ChatLieu(chatlieu.getAll_ChatLieu());
    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void rdoSoNganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSoNganMouseClicked
        // TODO add your handling code here:
        this.fillTable_SoNgan(songan.getAll_SoNgan());
    }//GEN-LAST:event_rdoSoNganMouseClicked

    private void rdoSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSizeMouseClicked
        // TODO add your handling code here:
        this.fillTable_Size(size.getAll_Size());
    }//GEN-LAST:event_rdoSizeMouseClicked

    private void rdoQuaiDeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoQuaiDeoMouseClicked
        // TODO add your handling code here:
        this.fillTable_QuaiDeo(quaideo.getAll_QuaiDeo());
    }//GEN-LAST:event_rdoQuaiDeoMouseClicked

    private void rdoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoHangMouseClicked
        // TODO add your handling code here:
        this.fillTable_Hang(hang.getAll_Hang());
    }//GEN-LAST:event_rdoHangMouseClicked

    private void tbThuoctinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThuoctinhMouseClicked
        // TODO add your handling code here:
        //        index1 = tbthuoctinh.getSelectedRow();
        //        this.showData1(index1);
        int indexn = tbThuoctinh.getSelectedRow();
        String mathuoctinh = (String) tbThuoctinh.getValueAt(indexn, 1);
        String tenthuoctinh = (String) tbThuoctinh.getValueAt(indexn, 2);
        txtMathuoctinh.setText(mathuoctinh);
        txtTenthuoctinh.setText(tenthuoctinh);
    }//GEN-LAST:event_tbThuoctinhMouseClicked

    private void btnThemSanPhamChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamChiTietActionPerformed
        // TODO add your handling code here:
        SanPhamChiTiet spct = this.readForm_SPCT();
        if (spct == null) {
            return;
        }

        if (SanPhamChiTiet.Them_SanPhamChiTiet(spct) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            this.fillTable_SanPhamChiTiet(SanPhamChiTiet.getAll_SanPhamChiTiet());
        } else {
            JOptionPane.showMessageDialog(this, "Them thất bại");
        }
    }//GEN-LAST:event_btnThemSanPhamChiTietActionPerformed

    private void btnSuaSanPhamChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamChiTietActionPerformed
        // TODO add your handling code here:
        SanPhamChiTiet sp = this.readForm_SPCT();
        if (sp == null) {
            return;
        }
        index = tbSanPhamChiTiet.getSelectedRow();
        String ma = tbSanPhamChiTiet.getValueAt(index, 1).toString();
        if (SanPhamChiTiet.Sua_SanPhamChiTiet(sp, ma) > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            this.fillTable_SanPhamChiTiet(SanPhamChiTiet.getAll_SanPhamChiTiet());
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaSanPhamChiTietActionPerformed

    private void btnXoaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPCTActionPerformed
        // TODO add your handling code here:
        index = tbSanPhamChiTiet.getSelectedRow();
        String ma = tbSanPhamChiTiet.getValueAt(index, 1).toString();
        if (SanPhamChiTiet.Xoa_SanPhamChiTiet(ma) > 0) {
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            this.fillTable_SanPhamChiTiet(SanPhamChiTiet.getAll_SanPhamChiTiet());
        } else {
            JOptionPane.showMessageDialog(this, "Xoá thất bại");
        }
    }//GEN-LAST:event_btnXoaSPCTActionPerformed

    private void btnThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocTinhActionPerformed
        // TODO add your handling code here:
        if (rdoChatLieu.isSelected()) {
            ChatLieu spct = this.readForm_CL();
            if (chatlieu.them_ChatLieu(spct) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_ChatLieu(chatlieu.getAll_ChatLieu());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        } else if (rdoHang.isSelected()) {
            Hang h = this.readForm_HG();
            if (hang.them_Hang(h) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_Hang(hang.getAll_Hang());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        } else if (rdoMauSac.isSelected()) {
            MauSac mau = this.readForm_MS();
            if (mausac.them_Mau(mau) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_MauSac(mausac.getAll_Mau());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        } else if (rdoQuaiDeo.isSelected()) {
            QuaiDeo spct = this.readForm_QD();
            if (quaideo.them_QuaiDeo(spct) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_QuaiDeo(quaideo.getAll_QuaiDeo());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        } else if (rdoSize.isSelected()) {
            Size spct = this.readForm_SZ();
            if (size.them_Size(spct) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_Size(size.getAll_Size());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        } else if (rdoSoNgan.isSelected()) {
            SoNgan spct = this.readForm_SN();
            if (songan.them_SoNgan(spct) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable_SoNgan(songan.getAll_SoNgan());
            } else {
                JOptionPane.showMessageDialog(this, "Them thất bại");
            }
        }
    }//GEN-LAST:event_btnThemThuocTinhActionPerformed

    private void btnSuaThuocTInhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTInhActionPerformed
        // TODO add your handling code here:
        if (rdoChatLieu.isSelected()) {
            ChatLieu sp = this.readForm_CL();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (chatlieu.sua(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_ChatLieu(chatlieu.getAll_ChatLieu());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else if (rdoHang.isSelected()) {
            Hang sp = this.readForm_HG();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (hang.sua_Hang(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_Hang(hang.getAll_Hang());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else if (rdoMauSac.isSelected()) {
            MauSac sp = this.readForm_MS();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (mausac.sua_Mau(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_MauSac(mausac.getAll_Mau());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else if (rdoQuaiDeo.isSelected()) {
            QuaiDeo sp = this.readForm_QD();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (quaideo.sua_QuaiDeo(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_QuaiDeo(quaideo.getAll_QuaiDeo());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else if (rdoSize.isSelected()) {
            Size sp = this.readForm_SZ();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (size.sua_Size(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_Size(size.getAll_Size());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else if (rdoSoNgan.isSelected()) {
            SoNgan sp = this.readForm_SN();
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (songan.sua_SoNgan(sp, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable_SoNgan(songan.getAll_SoNgan());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaThuocTInhActionPerformed

    private void btnXoaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuocTinhActionPerformed
        // TODO add your handling code here:
        if (rdoChatLieu.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (chatlieu.Xoa_ChatLieu(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_ChatLieu(chatlieu.getAll_ChatLieu());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        } else if (rdoHang.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (hang.Xoa_Hang(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_Hang(hang.getAll_Hang());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        } else if (rdoMauSac.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (mausac.Xoa_Mau(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_MauSac(mausac.getAll_Mau());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        } else if (rdoQuaiDeo.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (quaideo.Xoa_QuaiDeo(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_QuaiDeo(quaideo.getAll_QuaiDeo());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        } else if (rdoSize.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (size.Xoa_Size(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_Size(size.getAll_Size());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        } else if (rdoSoNgan.isSelected()) {
            index = tbThuoctinh.getSelectedRow();
            String ma = tbThuoctinh.getValueAt(index, 1).toString();
            if (songan.Xoa_SoNgan(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thành công");
                this.fillTable_SoNgan(songan.getAll_SoNgan());
            } else {
                JOptionPane.showMessageDialog(this, "Xoa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaThuocTinhActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMathuoctinh.setText("");
        txtTenthuoctinh.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemSanPhamMouseClicked

    private void txtTimKiemSanPhamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyTyped
        // TODO add your handling code here:
        String name = txtTimKiemSanPham.getText();
        List<SanPham> splist = sanpham.TimKiem_Ten(name);
        if (splist != null && !splist.isEmpty()) {
            model = (DefaultTableModel) tbSanPham.getModel();
            model.setRowCount(0);
            int stt = tbSanPham.getSelectedRow();
            stt = stt + 1;
            for (SanPham sp : splist) {
                Object[] row = {stt = stt + 1, sp.getMaSP(), sp.getTenSP()};
                model.addRow(row);
            }
        }
//        }else{
//            JOptionPane.showMessageDialog(this, "Khong tim thay ten san pham" + name);
//        }
    }//GEN-LAST:event_txtTimKiemSanPhamKeyTyped

    private void cbbLocMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocMauMouseClicked
        // TODO add your handling code here:
//           String cbb = (String) cbbLocMau.getSelectedItem();
//        System.out.println(cbb);
//                List<SanPhamChiTiet> list = SanPhamChiTiet.getAll_SanPhamChiTiet();
//        model.setRowCount(0);
//        int stt = tbSanPhamChiTiet.getSelectedRow();
//        stt = stt + 1;
//        for (SanPhamChiTiet cl : list) {
//            if(cl.getMausac().getTenMau().equals(cbb)){
//            Object[] row = new Object[]{
//                stt = stt + 1,
//                cl.getMaSPCT(),
//                cl.getSanpham(),
//                cl.getMausac(),
//                cl.getChatlieu(),
//                cl.getSongan(),
//                cl.getSize(),
//                cl.getQuaideo(),
//                cl.getHang(),
//                cl.getGia(),
//                cl.getSoluong(),
////                cl.getTinhTrang()
//            };
//            model.addRow(row);
//            }
//            if(cbb.equals("Tất Cả")){
//                fillTable_SanPhamChiTiet(list);
//            }
//        }
    }//GEN-LAST:event_cbbLocMauMouseClicked

    private void cboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMauSacActionPerformed

    private void cboSoNganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSoNganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSoNganActionPerformed

    private void cbbLocMauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocMauMouseEntered
        // TODO add your handling code here:

        String cbb = (String) cbbLocMau.getSelectedItem();
        System.out.println(cbb);
        List<SanPhamChiTiet> list = SanPhamChiTiet.getAll_SanPhamChiTiet();
        model.setRowCount(0);
        int stt = tbSanPhamChiTiet.getSelectedRow();
        stt = stt + 1;
        for (SanPhamChiTiet cl : list) {
            if (cl.getMausac().getTenMau().equals(cbb)) {
                Object[] row = new Object[]{
                    stt = stt + 1,
                    cl.getMaSPCT(),
                    cl.getSanpham(),
                    cl.getMausac(),
                    cl.getChatlieu(),
                    cl.getSongan(),
                    cl.getSize(),
                    cl.getQuaideo(),
                    cl.getHang(),
                    cl.getGia(),
                    cl.getSoluong(), //                cl.getTinhTrang()
                };
                model.addRow(row);
            }
            if (cbb.equals("Tất Cả")) {
                fillTable_SanPhamChiTiet(list);
            }
        }
    }//GEN-LAST:event_cbbLocMauMouseEntered

    private void btnLamMoiSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSPCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSize;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnChiTietSP;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiSP;
    private javax.swing.JButton btnLamMoiSPCT;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnQuaiDeo;
    private javax.swing.JButton btnSoNgan;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnSuaSanPhamChiTiet;
    private javax.swing.JButton btnSuaThuocTInh;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnThemSanPhamChiTiet;
    private javax.swing.JButton btnThemThuocTinh;
    private javax.swing.JButton btnXoaSPCT;
    private javax.swing.JButton btnXoaThuocTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLocMau;
    private javax.swing.JComboBox<ChatLieu> cboChatLieu;
    private javax.swing.JComboBox<Hang> cboHang;
    private javax.swing.JComboBox<MauSac> cboMauSac;
    private javax.swing.JComboBox<QuaiDeo> cboQuaiDeo;
    private javax.swing.JComboBox<Size> cboSize;
    private javax.swing.JComboBox<SoNgan> cboSoNgan;
    private javax.swing.JComboBox<Model.SanPham> cboTenSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoHang;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoNgungBan;
    private javax.swing.JRadioButton rdoQuaiDeo;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JRadioButton rdoSoNgan;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbSanPhamChiTiet;
    private javax.swing.JTable tbThuoctinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMathuoctinh;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenthuoctinh;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtmaCTSP;
    // End of variables declaration//GEN-END:variables
}
