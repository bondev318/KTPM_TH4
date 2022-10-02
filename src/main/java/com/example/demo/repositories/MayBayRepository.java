package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.MayBay;

@Repository
public interface MayBayRepository extends JpaRepository<MayBay, String> {
	public List<MayBay> findByTamBayGreaterThan(int TamBay);
	public List<MayBay> findByLoaiContains(String Loai);
}
