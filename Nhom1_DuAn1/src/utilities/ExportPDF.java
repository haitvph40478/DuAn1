/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import Model.KhachHang;
import Service.HoaDonChiTietService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Admin
 */
public class ExportPDF {

    //https://stackjava.com/library/doc-ghi-file-ms-word-bang-java-voi-apache-poi.html
    public static void main(String[] args) throws IOException {
        Document document = new Document();

        try {
            FileOutputStream out = new FileOutputStream(new File("./ExportHoaDon/HelloWorld.pdf"));
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, out);
            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph("A Hello World PDF document."));
            // đóng file
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ExportPDF(HoaDon hoaDon) {
        Document document = new Document();

        try {
            FileOutputStream out = new FileOutputStream(new File("./ExportHoaDon/" + hoaDon.getMaHoaDon() + ".pdf"));
            PdfWriter.getInstance(document, out);
            document.open();
 
            BaseFont baseFont = BaseFont.createFont("./font/calibrii.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font vietnameseFont = new Font(baseFont, 18,Font.NORMAL);

            // Tiêu đề hóa đơn
            Paragraph title = new Paragraph("Hóa Đơn Thanh Toán", vietnameseFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(16);
            document.add(title);

            // Thông tin hóa đơn
            document.add(createHoaDonInfo(hoaDon, vietnameseFont));

            // Thông tin sản phẩm/dịch vụ (nếu có)
            document.add(createProductInfo(hoaDon, vietnameseFont));

            // Tổng tiền, tiền nhận, tiền thừa
            document.add(createTongTienInfo(hoaDon, vietnameseFont));

            // Đóng file
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Paragraph createHoaDonInfo(HoaDon hoaDon, Font font) {
        Paragraph hoaDonInfo = new Paragraph();
        hoaDonInfo.setAlignment(Element.ALIGN_LEFT);

        hoaDonInfo.add(new Chunk("Ngày lập: " + hoaDon.getNgayTao(), font));
        hoaDonInfo.add(new Chunk("\nMã hóa đơn: " + hoaDon.getMaHoaDon(), font));
        KhachHang kh = new KhachHang();
        kh = hoaDon.getKhachHang();
        if (kh == null) {
            hoaDonInfo.add(new Chunk("\nTên khách hàng: Khách Lẻ", font));
        } else {
            hoaDonInfo.add(new Chunk("\nTên khách hàng: " + kh.getTenKH(), font));
        }

        hoaDonInfo.add(new Chunk("\n\n"));

        return hoaDonInfo;
    }

    private static PdfPTable createProductInfo(HoaDon hoaDon, Font font) {
        HoaDonChiTietService hdctService = new HoaDonChiTietService();
        PdfPTable table = new PdfPTable(4); // 3 cột cho Mã SP, Tên SP, Giá
        table.setWidthPercentage(100);

        PdfPCell cell1 = new PdfPCell(new Phrase("Ma San Pham", font));
        PdfPCell cell2 = new PdfPCell(new Phrase("Ten San Pham", font));
        PdfPCell cell3 = new PdfPCell(new Phrase("So Luong", font));
        PdfPCell cell4 = new PdfPCell(new Phrase("Gia", font));

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);

        // Thêm thông tin sản phẩm/dịch vụ vào bảng
        for (HoaDonChiTiet hdct : hdctService.getAllByHoaDon(String.valueOf(hoaDon.getID()))) {

            BigDecimal giaTien = hdct.getGiaTien();
            int soLuong = hdct.getSoLuong();
            BigDecimal thanhTien = giaTien.multiply(BigDecimal.valueOf(soLuong));

            table.addCell(new Phrase(hdct.getSanPhamChiTiet().getMaSPCT(), font));
            table.addCell(new Phrase(hdct.getSanPhamChiTiet().getSanpham().getTenSP(), font));
            table.addCell(new Phrase(String.valueOf(hdct.getSoLuong()), font));
            table.addCell(new Phrase(String.valueOf(thanhTien), font));
        }

        return table;
    }

    private static Paragraph createTongTienInfo(HoaDon hoaDon, Font font) {
        Paragraph tongTienInfo = new Paragraph();
        tongTienInfo.setAlignment(Element.ALIGN_RIGHT);

        BigDecimal tienMat = hoaDon.getTienMat();
        BigDecimal tienChuyenKhoan = hoaDon.getTienChuyenKhoan();
        BigDecimal tongTien = hoaDon.getTongTien();

        BigDecimal tienThua = tienMat.add(tienChuyenKhoan).subtract(tongTien);

        tongTienInfo.add(new Chunk("\n\nTổng Tiền: " + tongTien, font));
        tongTienInfo.add(new Chunk("\nHình Thức Thanh Toán: " + hoaDon.getHinhThuc(), font));

        tongTienInfo.add(new Chunk("\nTiền Khách Đưa: " + tienMat.add(tienChuyenKhoan), font));
        tongTienInfo.add(new Chunk("\nTiền Thừa: " + tienThua, font));

        return tongTienInfo;
    }
}

//public static void ExportWord(HoaDon hd, Double giaGiam, Double KhachDua, Double tienThua) {
//        IHoaDonService hdService = new HoaDonService();
//        IHoaDonChiTietService hdctService = new HoaDonChiTietService();
//
//        String maHd = hd.getMa();
//        Double tongTien = 0.0;
//        for (HoaDonChiTiet hdct : hdctService.getAllByMa(maHd)) {
//            tongTien = tongTien + (hdct.getSoLuong() * Double.valueOf(String.valueOf(hdct.getDonGia())));
//        }
//
//        XWPFDocument document = new XWPFDocument();
//        XWPFParagraph paragraphTitle = document.createParagraph();
//        paragraphTitle.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun runName = paragraphTitle.createRun();
//        runName.setText("DÉP SHOP");
//        runName.setBold(true);
//        runName.setFontSize(36);
//        runName.setFontFamily("Tahoma");
//        runName.addBreak();
//
//        XWPFRun runDiaChi = paragraphTitle.createRun();
//        runDiaChi.setText("ÐC: Tòa nhà FPT Polytechnic, Phố Trịnh Văn Bô, Nam Từ Liêm, Hà Nội");
//        runDiaChi.setFontSize(12);
//        runDiaChi.setFontFamily("Tahoma");
//        runDiaChi.addBreak();
//
//        XWPFRun runPhone = paragraphTitle.createRun();
//        runPhone.setText("SÐT: 09123456789");
//        runPhone.setFontSize(12);
//        runPhone.setFontFamily("Tahoma");
//        runPhone.addBreak();
//
//        XWPFRun runKe1 = paragraphTitle.createRun();
//        runKe1.setText("-----------------------");
//        runKe1.setBold(true);
//        runKe1.setFontSize(12);
//        runKe1.setFontFamily("Tahoma");
//        runKe1.addBreak();
//        runKe1.addBreak();
//
//        XWPFRun runTile = paragraphTitle.createRun();
//        runTile.setText("HÓA ĐƠN THANH TOÁN");
//        runTile.setBold(true);
//        runTile.setFontSize(20);
//        runTile.setFontFamily("Tahoma");
//        runTile.addBreak();
//
//        XWPFRun runMaHD = paragraphTitle.createRun();
//        runMaHD.setText("Số: "+hd.getMa());
//        runMaHD.setBold(true);
//        runMaHD.setFontSize(14);
//        runMaHD.setFontFamily("Tahoma");
//        runMaHD.addBreak();
//
//        //left
//        XWPFParagraph paragraphLeft = document.createParagraph();
//        paragraphLeft.setAlignment(ParagraphAlignment.LEFT);
//        XWPFRun runNgayMua = paragraphLeft.createRun();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
//        Date d = new Date();
//        runNgayMua.setText("Ngày mua: " + sdf.format(d));
//        runNgayMua.setFontSize(14);
//        runNgayMua.setFontFamily("Tahoma");
//        runNgayMua.addBreak();
//
//        String khachHang = hd.getKhachHang() == null ? "Khách lẻ" : hd.getKhachHang().getTen();
//        XWPFRun runKhachHang = paragraphLeft.createRun();
//        runKhachHang.setText("Khách Hàng: " + khachHang);
//        runKhachHang.setFontSize(14);
//        runKhachHang.setFontFamily("Tahoma");
//        runKhachHang.addTab();
//        runKhachHang.addTab();
//        runKhachHang.addTab();
//
//        String thuNgan = hd.getNguoiDung() == null ? "Nhân Viên Ảo" : hd.getNguoiDung().getTen();
//        XWPFRun runThuNgan = paragraphLeft.createRun();
//        runThuNgan.setText("Thu Ngân: " + thuNgan);
//        runThuNgan.setFontSize(14);
//        runThuNgan.setFontFamily("Tahoma");
//        runThuNgan.addBreak();
//
//        XWPFRun runke2 = paragraphLeft.createRun();
//        runke2.setText("_____________________________________________________________");
//        runke2.setFontSize(14);
//        runke2.setFontFamily("Tahoma");
//        runke2.addBreak();
//
//        XWPFRun runColum = paragraphLeft.createRun();
//        runColum.setFontSize(20);
//        runColum.setBold(true);
//        runColum.setFontFamily("Tahoma");
//        runColum.setText("Tên Sp");
//        runColum.addTab();
//        runColum.addTab();
//        runColum.addTab();
//        runColum.setText("SL");
//        runColum.addTab();
//        runColum.addTab();
//        runColum.setText("Đ.Giá");
//        runColum.addTab();
//        runColum.addTab();
//        runColum.addTab();
//        runColum.setText("T.Tiền");
//        runColum.addBreak();
//
//        XWPFRun runke3 = paragraphLeft.createRun();
//        runke3.setText("_____________________________________________________________");
//        runke3.setFontSize(14);
//        runke3.setFontFamily("Tahoma");
//        runke3.addBreak();
//
//        XWPFRun SP = paragraphLeft.createRun();
//        SP.setFontSize(14);
//        SP.setFontFamily("Tahoma");
//
//        String tenSp = "";
//        String soLuongSp = "";
//        String giaBan = "";
//        Double thanhTien = 0.0;
//        for (HoaDonChiTiet hdct : hdctService.getAllByMa(maHd)) {
//            tenSp = hdct.getChiTietDep().getDep().getTen();
//            SP.setText(tenSp);
//            SP.addTab();
//            SP.addTab();
//            SP.addTab();
//            soLuongSp = String.valueOf(hdct.getSoLuong());
//            SP.setText(soLuongSp);
//            SP.addTab();
//            SP.addTab();
//            giaBan = String.valueOf(hdct.getDonGia());
//            SP.setText(giaBan);
//            SP.addTab();
//            SP.addTab();
//            SP.addTab();
//            thanhTien = Double.valueOf(giaBan) * Double.valueOf(soLuongSp);
//            SP.setText(String.valueOf(thanhTien));
//            SP.addBreak();
//
//        }
//
//        XWPFRun runke4 = paragraphLeft.createRun();
//        runke4.setText("_____________________________________________________________");
//        runke4.setFontSize(14);
//        runke4.setFontFamily("Tahoma");
//        runke4.addBreak();
//
//        XWPFRun runTongTien = paragraphLeft.createRun();
//        runTongTien.setText("Tổng Tiền:");
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.addTab();
//        runTongTien.setText(String.valueOf(tongTien));
//        runTongTien.setFontSize(14);
//        runTongTien.setFontFamily("Tahoma");
//        runTongTien.addBreak();
//
//        XWPFRun runGiamGia = paragraphLeft.createRun();
//        runGiamGia.setText("Giảm Giá:");
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.addTab();
//        runGiamGia.setText(String.valueOf(giaGiam));
//        runGiamGia.setFontSize(14);
//        runGiamGia.setFontFamily("Tahoma");
//        runGiamGia.addBreak();
//
//        XWPFRun runThanhTien = paragraphLeft.createRun();
//        runThanhTien.setText("Tổng Thanh Toán:");
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.addTab();
//        runThanhTien.setText(String.valueOf(tongTien - giaGiam));
//        runThanhTien.setFontSize(14);
//        runThanhTien.setFontFamily("Tahoma");
//        runThanhTien.addBreak();
//
//        XWPFRun runKhachDua = paragraphLeft.createRun();
//        runKhachDua.setText("Tiền Khách Đưa:");
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.addTab();
//        runKhachDua.setText(String.valueOf(KhachDua));
//        runKhachDua.setFontSize(14);
//        runKhachDua.setFontFamily("Tahoma");
//        runKhachDua.addBreak();
//
//        XWPFRun runTienThua = paragraphLeft.createRun();
//        runTienThua.setText("Tiền Thừa:");
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.addTab();
//        runTienThua.setText(String.valueOf(tienThua));
//        runTienThua.setFontSize(14);
//        runTienThua.setFontFamily("Tahoma");
//        runTienThua.addBreak();
//
//        XWPFRun runKe5 = paragraphLeft.createRun();       
//        runKe5.setText("_____________________________________________________________");
//        runKe5.setBold(true);
//        runKe5.setFontSize(12);
//        runKe5.setFontFamily("Tahoma");
//        runKe5.addBreak();
//        runKe5.addBreak();
//
//        XWPFRun runThanks = paragraphLeft.createRun();
//        runThanks.setText("Xin cảm ơn, hẹn gặp lại quý khách!");
//        runThanks.setBold(true);
//        runThanks.setFontSize(20);
//        runThanks.setFontFamily("Tahoma");
//        runThanks.addBreak();
//
//        try {
//            FileOutputStream out = new FileOutputStream(new File("./ExportHoaDon/" + maHd + ".docx"));
//            document.write(out);
//            out.close();
//            document.close();
//            System.out.println("thành công");
//        } catch (FileNotFoundException ex) {
//            System.out.println("Trùng Tên File");
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            System.out.println("Nhân 2");
//            ex.printStackTrace();
//        }
//
//    }
//
////    public static void main(String[] args) {
//////        ExportWord();
////
////    }
//}
