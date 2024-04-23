package com.laptrinhandcuocsong.webbansach.dao;

import com.laptrinhandcuocsong.webbansach.entity.ChiTietDonHang;
import com.laptrinhandcuocsong.webbansach.entity.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia,Long> {

}
