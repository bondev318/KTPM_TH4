package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.ChuyenBay;
@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String>{
	public List<ChuyenBay> findByGaDi(String gaDi);
	public List<ChuyenBay> findByDoDaiGreaterThanAndDoDaiLessThan(int start, int end);
	@Query(value = "SELECT * FROM chuyenbay WHERE HOUR(GioDi) < :hour", nativeQuery = true)
	public List<ChuyenBay> flightsStartBeforeHour(@Param("hour") int hour);
}
