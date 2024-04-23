package com.laptrinhandcuocsong.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@Table(name = "the_loai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_the_loai")
    private int maTheLoai;

    @Column(name = "ten_the_loai")
    private String tenTheLoai;

    @ManyToMany(fetch = FetchType.LAZY,cascade ={
            ///thay vi dung cascade.all thi ta dung 4 cascade nay
            //vi ta k muon dung remove neu nhu ta dung remove thi
            //thi ta xoa khoa ngoai bang nay thi no se xoa cac bang khac
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH
    } )
    //ten bang trung gian giua sach va the loai
    @JoinTable(name="sach_theloai",
            joinColumns = @JoinColumn(name="ma_the_loai"),
            inverseJoinColumns = @JoinColumn(name="ma_sach")
    )
    private List<Sach> danhSachQuyenSach;
}
