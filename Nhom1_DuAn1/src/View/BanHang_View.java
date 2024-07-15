/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import Model.KhachHang;
import Model.NhanVien;
import Model.SanPhamChiTiet;
import Model.Size;
import Service.ChatLieu_Service;
import Service.HangService;
import Service.Hang_Service;
import Service.HoaDonChiTietService;
import Service.HoaDonService;
import Service.MauSacService;
import Service.MauSac_Service;
import Service.QuaiDeo_Service;
import Service.SanPhamChiTietService;
import Service.SanPhamChiTiet_Service;
import Service.SanPham_Service;
import Service.SizeService;
import Service.Size_Service;
import Service.SoNgan_Service;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import utilities.ExportPDF;

/**
 *
 * @author GIGABYTE
 */
public class BanHang_View extends javax.swing.JInternalFrame {
//
//    private SanPham_Service sanpham = new SanPham_Service();
//    private SanPhamChiTiet_Service SanPhamChiTiet = new SanPhamChiTiet_Service();
//    private MauSac_Service mausac = new MauSac_Service();
//    private SoNgan_Service songan = new SoNgan_Service();
//    private Hang_Service hang = new Hang_Service();
//    private QuaiDeo_Service quaideo = new QuaiDeo_Service();
//    private Size_Service size = new Size_Service();
//    private ChatLieu_Service chatlieu = new ChatLieu_Service();
//    private DefaultTableModel model = new DefaultTableModel();

    private int index = -1;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<SanPhamChiTiet> listSP = new ArrayList<>();

    private DefaultTableModel tblModelSanPham;
    private DefaultTableModel tblModelGioHang;
    private DefaultTableModel tblModelHoaDon;

    private List<HoaDon> lstHoaDon = null;
    private List<HoaDonChiTiet> lstHoaDonChiTiet = null;
    private List<SanPhamChiTiet> lstSanPhamChiTiet = null;

    private SanPhamChiTietService spctService;
    private HoaDonService hdService;
    private HoaDonChiTietService hdctService;
    private SizeService sizeService;
    private MauSacService msService;
    private HangService hangService;

    private HoaDon hoaDon = null;
    private KhachHang khachHang = null;
    private NhanVien nhanVien = null;

    /**
     * Creates new form BanHang_View
     */
    public BanHang_View() {
        initComponents();
        setBorder();

//        AddPleacehoderStyle(txtTimKiem);
        spctService = new SanPhamChiTietService();
        hdService = new HoaDonService();
        hdctService = new HoaDonChiTietService();
        sizeService = new SizeService();
        msService = new MauSacService();
        hangService = new HangService();
        this.nhanVien = GiaoDien_View.getNhanVien();
        getModelTable();
        initCbo();
        initRdo();
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));
        clearFormHoaDon();
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

    public void getModelTable() {
        tblModelSanPham = (DefaultTableModel) tblDSSP.getModel();
        tblModelGioHang = (DefaultTableModel) tblGioHang.getModel();
        tblModelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        tblModelGioHang.setRowCount(0);
    }

    public void LoadTableSanPham(List<SanPhamChiTiet> lst) {
        int i = 0;
        tblModelSanPham.setRowCount(0);
        this.lstSanPhamChiTiet = lst;
        for (SanPhamChiTiet ctsp : lst) {
            tblModelSanPham.addRow(new Object[]{
                ++i,
                ctsp.getMaSPCT(),
                ctsp.getSanpham(),
                ctsp.getMausac(),
                ctsp.getSize(),
                ctsp.getHang(),
                ctsp.getQuaideo(),
                ctsp.getSoluong(),
                ctsp.getGia()
            });
        }
    }

    public void LoadTableHoaDon(List<HoaDon> lst) {
        int i = 0;
        tblModelHoaDon.setRowCount(0);
        this.lstHoaDon = lst;
        for (HoaDon hd : lst) {
            tblModelHoaDon.addRow(new Object[]{
                ++i,
                hd.getMaHoaDon(),
                hd.getNgayTao(),
                hd.getNhanVien().getMaNV(),
                hd.getKhachHang() == null ? "Khách Lẻ" : hd.getKhachHang().getTenKH(),
                "Tại Quầy",
                hd.getTrangThai().equals("0") ? "Chờ thanh toán" : hd.getTrangThai().equals("1") ? "Đã thanh toán" : "Đã huỷ"
            });
        }
    }

    public void LoadTableGioHang(List<HoaDonChiTiet> lst) {

        int i = 0;
        tblModelGioHang.setRowCount(0);
        this.lstHoaDonChiTiet = lst;
        System.out.println(lstHoaDonChiTiet);
        for (HoaDonChiTiet hdct : lst) {
            tblModelGioHang.addRow(new Object[]{
                ++i,
                hdct.getSanPhamChiTiet().getMaSPCT(),
                hdct.getSanPhamChiTiet().getSanpham().getTenSP(),
                hdct.getGiaTien(),
                hdct.getSoLuong(),
                new BigDecimal(hdct.getSoLuong()).multiply(hdct.getGiaTien())
            });
        }

        loadFormHoaDon(this.hoaDon, lst);
    }

    public void initCbo() {
        initCboObj(cbbSize, sizeService.getAll());
        initCboObj(cbbMauSac, msService.getAll());
        initCboObj(cbbLocHang, hangService.getAll());

    }

    public void initCboObj(JComboBox<String> cbb, List lst) {
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();
        cbb.removeAllItems();

        cbb.setModel((DefaultComboBoxModel) boxModel);
        boxModel.addElement("Tất Cả");
        for (Object obj : lst) {
            boxModel.addElement(obj.toString());
        }
    }

    public String getItemCbo(JComboBox cbo) {
        if (cbo.getSelectedIndex() == 0) {
            return "";
        }
        return (String) cbo.getSelectedItem();
    }

    public void initRdo() {
        rdoTatCa.setText("Tất cả");
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoDaHuy.setText("Đã huỷ");

        rdoChoThanhToan.setSelected(true);
        LoadTableHoaDon(hdService.getAllByTrangThai("0"));
    }

    public void loadFormKhachHang(KhachHang kh) {
        txtMaKh.setText(kh == null ? "Khách Lẻ" : kh.getMaKH());
        txtTenKh.setText(kh == null ? "Khách Lẻ" : kh.getTenKH());
    }

    public void loadFormHoaDon(HoaDon hd, List<HoaDonChiTiet> lst) {
        txtMaHd.setText(hd.getMaHoaDon());
        txtTenNv.setText(hd.getNhanVien().getTenNV());
        txtNgayTao.setText(sdf.format(hd.getNgayTao()));
        BigDecimal tongTien = BigDecimal.ZERO;
        for (HoaDonChiTiet hdct : lst) {
            BigDecimal soLuong = BigDecimal.valueOf(hdct.getSoLuong());
            BigDecimal giaTien = hdct.getGiaTien();
            tongTien = tongTien.add(soLuong.multiply(giaTien));
        }
        txtTongTien.setText(tongTien.toString());
    }

    public void clickHoaDon() {
        int index = tblHoaDon.getSelectedRow();
        this.hoaDon = this.lstHoaDon.get(index);
        String maHd = this.hoaDon.getMaHoaDon();
        if (this.hoaDon.getNhanVien() != null) {
            this.nhanVien = this.hoaDon.getNhanVien();
        }
        if (this.hoaDon.getKhachHang() != null) {
            this.khachHang = this.hoaDon.getKhachHang();
        }
        System.out.println(maHd);
        List<HoaDonChiTiet> lstHdct = hdctService.getAllByHoaDon(String.valueOf(this.hoaDon.getID()));
        LoadTableGioHang(lstHdct);
        loadFormKhachHang(this.hoaDon.getKhachHang());
        loadFormHoaDon(this.hoaDon, lstHdct);
    }

    public void clickSanPham() {
        Boolean isSanPham = false;
        if (this.hoaDon == null) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Hóa Đơn");
            return;
        }
        if (!this.hoaDon.getTrangThai().equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn chờ thanh toán");
            return;
        }

        int index = tblDSSP.getSelectedRow();
        SanPhamChiTiet spct = this.lstSanPhamChiTiet.get(index);
        int soLuong = 0;
        try {
            soLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "Vui Lòng Nhập Số Lượng"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số");
            return;
        }
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Lon Hon 0");
            return;
        }
        if (soLuong > spct.getSoluong()) {
            JOptionPane.showMessageDialog(this, "Số Lượng Không Khả Dụng");
            return;
        }
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        for (HoaDonChiTiet hoaDon : lstHoaDonChiTiet) {
            if (hoaDon.getSanPhamChiTiet().getId() == spct.getId()) {
                isSanPham = true;
                hdct = hoaDon;
            }
        }
        if (isSanPham) {
            hdct.setSanPhamChiTiet(spct);
            hdct.setSoLuong(hdct.getSoLuong() + soLuong);
            hdct.setGiaTien(new BigDecimal(spct.getGia()));
            BigDecimal thanhTien = BigDecimal.valueOf(hdct.getSoLuong()).multiply(BigDecimal.valueOf(spct.getGia()));
            hdct.setThanhTien(thanhTien);
            hdctService.update(String.valueOf(hdct.getID()), hdct);
        } else {
            hdct.setHoaDon(this.hoaDon);
            hdct.setSanPhamChiTiet(spct);
            hdct.setSoLuong(soLuong);
            hdct.setGiaTien(new BigDecimal(spct.getGia()));
            BigDecimal thanhTien = BigDecimal.valueOf(soLuong).multiply(BigDecimal.valueOf(spct.getGia()));
            hdct.setThanhTien(thanhTien);
            hdctService.add(hdct);
        }
        spct.setSoluong(spct.getSoluong() - soLuong);
        spctService.update(String.valueOf(spct.getId()), spct);
        List<HoaDonChiTiet> lstHdct = hdctService.getAllByHoaDon(String.valueOf(this.hoaDon.getID()));
        LoadTableGioHang(lstHdct);
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }

    public void clickGioHang() {
        if (!this.hoaDon.getTrangThai().equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn chờ thanh toán");
            return;
        }
        int index = tblGioHang.getSelectedRow();

        HoaDonChiTiet hdct = this.lstHoaDonChiTiet.get(index);
        int soLuong = 0;
        try {
            soLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "Vui Lòng Nhập Số Lượng"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số");
            return;
        }
        if (soLuong < 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Lon Hon 0");
            return;
        }
        SanPhamChiTiet spct = hdct.getSanPhamChiTiet();

        if (soLuong <= 0) {
            spct.setSoluong(spct.getSoluong() + hdct.getSoLuong());
            hdctService.delete(String.valueOf(hdct.getID()));

        } else {
            if (soLuong >= spct.getSoluong()) {
                JOptionPane.showMessageDialog(this, "Số Lượng Không Đủ");
                return;
            }
            spct.setSoluong(spct.getSoluong() + hdct.getSoLuong() - soLuong);
            hdct.setSoLuong(soLuong);
            hdctService.update(String.valueOf(hdct.getID()), hdct);
        }
        spctService.update(String.valueOf(spct.getId()), spct);
        List<HoaDonChiTiet> lstHdct = hdctService.getAllByHoaDon(String.valueOf(this.hoaDon.getID()));
        LoadTableGioHang(lstHdct);
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }

    public void taoHoaDon() {
        HoaDon hd = new HoaDon();
//        hd.setKhachHang(this.khachHang);
        hd.setNhanVien(this.nhanVien);
        hdService.add(hd);
        LoadTableHoaDon(hdService.getAllByTrangThai("0"));
        rdoChoThanhToan.setSelected(true);
        JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");

    }

    public void deleteAddGioHang() {
        for (HoaDonChiTiet hdct : this.lstHoaDonChiTiet) {
            SanPhamChiTiet ctsp = hdct.getSanPhamChiTiet();
            ctsp.setSoluong(ctsp.getSoluong() + hdct.getSoLuong());
            spctService.update(String.valueOf(ctsp.getId()), ctsp);
            hdctService.delete(String.valueOf(hdct.getID()));
        }
        LoadTableGioHang(hdctService.getAllByHoaDon(String.valueOf(this.hoaDon.getID())));
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }

    public void chonKhachHang() {
        KhachHangDialog khDialog = new KhachHangDialog(null, true);
        khDialog.setVisible(true);
        this.khachHang = khDialog.getKhachHang();
        if (this.khachHang != null) {
            txtMaKh.setText(this.khachHang.getMaKH());
            txtTenKh.setText(this.khachHang.getTenKH());

            if (this.hoaDon != null) {
                this.hoaDon.setKhachHang(this.khachHang);
                this.hoaDon.setNhanVien(this.nhanVien);
                hdService.update(String.valueOf(this.hoaDon.getID()), this.hoaDon);
                LoadTableHoaDon(hdService.getAllByTrangThai("0"));
            }

        }

    }

    public void tienThua() {

        if (this.hoaDon == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        Double tongTien = Double.valueOf(txtTongTien.getText());
        Double tienKhachDua = 0.0;
        Double tienChuyenKhoan = 0.0;

        if (txtTienKhachDua.getText().trim().length() != 0) {
            try {
                tienKhachDua = Double.valueOf(txtTienKhachDua.getText());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tiền Khách Đưa Là Sô");
                txtTienKhachDua.setText("");
                txtTienThua.setText("");
                return;
            }
        }
        if (txtTienKhachCk.getText().trim().length() != 0) {
            try {
                tienChuyenKhoan = Double.valueOf(txtTienKhachCk.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tiền Khách CK Là Sô");
                txtTienKhachCk.setText("");
                txtTienThua.setText("");
                return;
            }
        }

        Double tien = tienKhachDua + tienChuyenKhoan;
        txtTienThua.setText(tien - tongTien + "");

    }

    public void thanhToanHoaDon() {
        if (this.hoaDon == null) {
             JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Hóa Đơn");
            return;
        }
        
        if (!this.hoaDon.getTrangThai().equals("0")) {
            JOptionPane.showMessageDialog(this, "Không Thể Thanh Toán Hóa Đơn Này");
            return;
        }

        if (Double.valueOf(txtTongTien.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Có Gì Để Thanh Toán");
            txtTienKhachCk.setText("");
            txtTienKhachDua.setText("");
            txtTienThua.setText("");
            return;
        }

        if (txtTienThua.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tiền Thanh Toán");
            return;
        }

        Double tienThua = 0.0;
        try {
            tienThua = Double.valueOf(txtTienThua.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tienThua < 0) {
            JOptionPane.showMessageDialog(this, "Tiền Thanh Toán Chưa Đủ");
            return;
        }
        
        int chkTT = JOptionPane.showConfirmDialog(this, "Xác Nhận Thanh Toán ?");
        if (chkTT != JOptionPane.YES_OPTION) {
            return;
        }
        if (cboHinhThuc.getSelectedIndex() != 0) {
            String input = JOptionPane.showInputDialog(this, "Nhập Mã Giao Dịch ");
            this.hoaDon.setMaChuyenKhoan(input);
        }

        this.hoaDon.setTrangThai("1");
        this.hoaDon.setTongTien(new BigDecimal(txtTongTien.getText()));
        if (txtTienKhachDua.getText().trim().length() != 0) {
            this.hoaDon.setTienMat(new BigDecimal(txtTienKhachDua.getText()));
        }
        if (txtTienKhachCk.getText().trim().length() != 0) {
            this.hoaDon.setTienChuyenKhoan(new BigDecimal(txtTienKhachCk.getText()));
        }
        this.hoaDon.setHinhThuc(cboHinhThuc.getSelectedItem().toString());
        hdService.update(String.valueOf(this.hoaDon.getID()), this.hoaDon);

        rdoChoThanhToan.setSelected(true);
        tblModelGioHang.setRowCount(0);
        JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
        LoadTableHoaDon(hdService.getAllByTrangThai("0"));

        int chk = JOptionPane.showConfirmDialog(this, "In Hoa Don ?");
        if (chk == JOptionPane.YES_OPTION) {
            ExportPDF.ExportPDF(this.hoaDon);
            JOptionPane.showMessageDialog(this, "In Hóa Đơn Thành Công");
        }

        clearFormHoaDon();

    }

    public void huyHoaDon() {
        if (this.hoaDon.getID() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng chọn Hóa Đơn");
            return;
        }
        int chk = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Muốn Hủy Hóa Đơn Này");
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }
        deleteAddGioHang();
        this.hoaDon.setTrangThai("2");
        if (hdService.update(String.valueOf(this.hoaDon.getID()), this.hoaDon)) {
            JOptionPane.showMessageDialog(this, "Hủy Hóa Đơn Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Hủy Hóa Đơn Thất Bại");
        }

        this.hoaDon = null;
        LoadTableHoaDon(hdService.getAllByTrangThai("0"));
        rdoChoThanhToan.setSelected(true);
        tblModelGioHang.setRowCount(0);

    }

    public void clearFormHoaDon() {
        this.hoaDon = null;
        this.khachHang = null;
        txtMaHd.setText("");
        txtTenNv.setText("");
        txtNgayTao.setText("");
        txtTongTien.setText("");
        cboHinhThuc.setSelectedIndex(0);
        txtTienKhachCk.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtTienKhachCk.setEnabled(false);
        txtMaKh.setText("Khach Le");
        txtTenKh.setText("Khach Le");
        tblModelGioHang.setRowCount(0);
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
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbbLocHang = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHd = new javax.swing.JTextField();
        txtTenNv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cboHinhThuc = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTienKhachCk = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        jButton1.setText("Tạo hoá đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoThanhToanActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDaHuy);
        rdoDaHuy.setText("Đã huỷ");
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày Tạo", "Nhân Viên", "Khách Hàng", "Hình Thức", "Trạng Thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jButton6.setBackground(new java.awt.Color(0, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(61, 61, 61)
                .addComponent(rdoTatCa)
                .addGap(18, 18, 18)
                .addComponent(rdoDaThanhToan)
                .addGap(18, 18, 18)
                .addComponent(rdoChoThanhToan)
                .addGap(18, 18, 18)
                .addComponent(rdoDaHuy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(rdoTatCa)
                        .addComponent(rdoDaThanhToan)
                        .addComponent(rdoChoThanhToan)
                        .addComponent(rdoDaHuy))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tblGioHang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblGioHangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        jButton3.setBackground(new java.awt.Color(0, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(715, 715, 715)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Tên SP", "Màu Sắc", "Size", "Hãng", "Quai Đeo", "Số Lượng", "Giá"
            }
        ));
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDSSP);

        jLabel9.setText("Tìm kiếm:");

        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel10.setText(" Hãng: ");

        cbbLocHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "NIKE", "PUMA", "ADIDAS", "MLB" }));
        cbbLocHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbLocHangMouseEntered(evt);
            }
        });
        cbbLocHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocHangActionPerformed(evt);
            }
        });

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Màu Đen", "Màu Xanh", "Màu Trắng", "Màu Xám" }));
        cbbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbMauSacMouseEntered(evt);
            }
        });
        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        jLabel11.setText("Màu:");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        cbbSize.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbbSizeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbSizeMouseEntered(evt);
            }
        });
        cbbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSizeActionPerformed(evt);
            }
        });

        jLabel12.setText("Size:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLocHang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbbLocHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setText("Mã hoá đơn:");

        txtMaHd.setEnabled(false);

        txtTenNv.setEnabled(false);

        jLabel2.setText("Tên nhân viên:");

        jLabel4.setText("Ngày tạo:");

        jLabel5.setText("Tổng tiền:");

        txtNgayTao.setEnabled(false);

        txtTongTien.setEnabled(false);

        jLabel6.setText("Tiền khách đưa:");

        jLabel7.setText("Tiền thừa:");

        txtTienThua.setEnabled(false);

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Coins.png"))); // NOI18N
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setText("Mã kh: ");

        txtMaKh.setEnabled(false);

        txtTenKh.setEnabled(false);

        jLabel8.setText("Tên kh:");

        jButton4.setText("Chon");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("KH Le");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel13.setText("Hinh Thưc TT:");

        cboHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt ", "Chuyển Khoản ", "Tiền Mặt & Chuyển Khoản" }));
        cboHinhThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucActionPerformed(evt);
            }
        });

        jLabel14.setText("Tiền Khach Ck:");

        txtTienKhachCk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachCkKeyReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Làm Mới");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtNgayTao)
                            .addComponent(txtTenNv)
                            .addComponent(txtMaHd))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(24, 24, 24)
                                .addComponent(cboHinhThuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtTienKhachCk)))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienKhachCk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tại Quầy", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đặt Hàng", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed

    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void cbbLocHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocHangMouseEntered

    }//GEN-LAST:event_cbbLocHangMouseEntered

    private void cbbMauSacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMauSacMouseEntered

    }//GEN-LAST:event_cbbMauSacMouseEntered

    private void cbbSizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseEntered

    }//GEN-LAST:event_cbbSizeMouseEntered

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        // TODO add your handling code here:
        if (txtTimKiem.getText().equals("Tên Sản Phẩm")) {
            txtTimKiem.setText(null);
            txtTimKiem.requestFocus();
            RemovePleacehoderStyle(txtTimKiem);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        // TODO add your handling code here:
        if (txtTimKiem.getText().length() == 0) {
            AddPleacehoderStyle(txtTimKiem);
            txtTimKiem.setText("Tên Sản Phẩm");
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbbSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSizeActionPerformed
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }//GEN-LAST:event_cbbSizeActionPerformed

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }//GEN-LAST:event_cbbMauSacActionPerformed

    private void cbbLocHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocHangActionPerformed
        LoadTableSanPham(spctService.getAllByTenAndTinhTrangAndCombobox(txtTimKiem.getText(), getItemCbo(cbbSize), getItemCbo(cbbMauSac), getItemCbo(cbbLocHang), "Đang bán"));

    }//GEN-LAST:event_cbbLocHangActionPerformed

    private void cbbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeMouseClicked

    private void cbbSizeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbbSizeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeAncestorAdded

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        LoadTableHoaDon(hdService.getAllByTrangThai(""));

    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        LoadTableHoaDon(hdService.getAllByTrangThai("1"));
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        LoadTableHoaDon(hdService.getAllByTrangThai("0"));
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        LoadTableHoaDon(hdService.getAllByTrangThai("2"));

    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        clickHoaDon();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        clickSanPham();
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        taoHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblGioHangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblGioHangAncestorAdded

    }//GEN-LAST:event_tblGioHangAncestorAdded

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        clickGioHang();
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int chk = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Bỏ Toàn Bộ Sản Phẩm Khỏi Giỏ Hàng");
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }
        deleteAddGioHang();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        chonKhachHang();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.khachHang = null;
        txtMaKh.setText("Khách Lẻ");
        txtTenKh.setText("Khách Lẻ");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        tienThua();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        thanhToanHoaDon();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        huyHoaDon();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       clearFormHoaDon();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cboHinhThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucActionPerformed
        int index = cboHinhThuc.getSelectedIndex();

        if (index == 2) {
            txtTienKhachDua.setEnabled(true);
            txtTienKhachCk.setEnabled(true);
            txtTienThua.setText("");
        } else if (index == 1) {
            txtTienKhachCk.setEnabled(true);
            txtTienKhachDua.setEnabled(false);
            txtTienKhachDua.setText("");
            txtTienThua.setText("");

        } else {
            txtTienKhachCk.setEnabled(false);
            txtTienKhachCk.setText("");
            txtTienKhachDua.setEnabled(true);
            txtTienThua.setText("");

        }
    }//GEN-LAST:event_cboHinhThucActionPerformed

    private void txtTienKhachCkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachCkKeyReleased
        tienThua();
    }//GEN-LAST:event_txtTienKhachCkKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLocHang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cboHinhThuc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHd;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTenNv;
    private javax.swing.JTextField txtTienKhachCk;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void setBorder() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
}
