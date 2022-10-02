package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
	public List<NhanVien> findByLuongLessThan(int Luong);
	
	@Query(value = "SELECT SUM(Luong) as TongSoLuongPhaiTra FROM nhanvien", nativeQuery = true)
	public int totalLuong();
	
	public List<NhanVien> findByTenLike(String ten);
}
