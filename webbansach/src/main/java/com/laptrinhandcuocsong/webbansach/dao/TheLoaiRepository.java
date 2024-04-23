package com.laptrinhandcuocsong.webbansach.dao;

import com.laptrinhandcuocsong.webbansach.entity.Sach;
import com.laptrinhandcuocsong.webbansach.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "the-loai")
public interface TheLoaiRepository extends JpaRepository<TheLoai,Integer> {

}
