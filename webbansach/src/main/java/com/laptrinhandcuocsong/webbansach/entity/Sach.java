package com.laptrinhandcuocsong.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_sach")
    private int MaSach;

    @Column(name="ten_sach" ,length = 256)
    private String tenSach;

    @Column(name="ten_tac_gia" ,length = 512)
    private String tacGia;

    @Column(name="isbn" ,length = 256)
    private String ISBN;
    @Column(name="mo_ta" ,columnDefinition = "text")//dinh nghia kieu dl la text
    private String moTa;

    @Column(name="gia_niem_yet")
    private double giaNiemYet;

    @Column(name="gia_ban")
    private double giaBan;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="trung_binh_xep_hang")
    private double trungBinhXepHang;

    @ManyToMany(fetch = FetchType.LAZY,cascade ={
            ///thay vi dung cascade.all thi ta dung 4 cascade nay
            //vi ta k muon dung remove neu nhu ta dung remove thi
            //thi ta xoa khoa ngoai bang nay thi no se xoa cac bang khac
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH
    } )
    //ten bang trung gian giua sach va the loai
    @JoinTable(name="sach_theloai",
            joinColumns = @JoinColumn(name="ma_sach"),
            inverseJoinColumns = @JoinColumn(name="ma_the_loai")
    )
    private List<TheLoai> danhSachTheLoai;

    //dung all giup khi ta xoa sach thi no se xoa anh
    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private List<DanhGia> danhSachSuDanhGia;

     @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })//neu nhu xoa sach ma xoa luong ctdonhang thi khi chung ta tinh thong ke doanh thu thi no bi sai
    private List<ChiTietDonHang> danhSachChiTietDonHang;

     @OneToMany( mappedBy = "sach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SachYeuThich> danhSachYeuThich;
}
