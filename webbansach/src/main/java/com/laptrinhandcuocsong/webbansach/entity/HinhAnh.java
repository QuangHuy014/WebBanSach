package com.laptrinhandcuocsong.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_anh")
    private int maHinhAnh;

    @Column(name = "ten_hinh_anh",length = 256)
    private String tenHinhAnh;

    @Column(name = "la_icon")//trong mysql la dung tiny int
    private boolean laIcon;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "du_lieu_anh")
    @Lob//van la string nhung la kieu du lieu lon
    private String duLieuAnh;
    @ManyToOne(cascade = {
            //nghia la khi ta xoa hinh anh thi no ko xoa xach
            //neu ta dung cascade.all thi khi ta xoa hinh anh thi no xoa ljuon sach
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH
    })
    @JoinColumn(name="ma_sach",nullable = false)//khi @manytoone thi dung joincolum den id cua bang do
    //o day dung nullable vi khi luu anh xuong thi bat buoc phai co sach,neu ko co sach thi k ton tai anh
    private Sach sach;
}
