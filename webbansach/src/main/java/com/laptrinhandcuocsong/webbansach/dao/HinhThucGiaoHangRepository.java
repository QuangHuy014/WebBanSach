package com.laptrinhandcuocsong.webbansach.dao;

import com.laptrinhandcuocsong.webbansach.entity.ChiTietDonHang;
import com.laptrinhandcuocsong.webbansach.entity.HinhThucGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucGiaoHangRepository extends JpaRepository<HinhThucGiaoHang,Integer> {

}
