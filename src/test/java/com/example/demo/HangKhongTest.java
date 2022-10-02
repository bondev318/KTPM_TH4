package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entites.ChuyenBay;
import com.example.demo.entites.MayBay;
import com.example.demo.entites.NhanVien;
import com.example.demo.repositories.ChuyenBayRepository;
import com.example.demo.repositories.MayBayRepository;
import com.example.demo.repositories.NhanVienRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HangKhongTest {
	@Autowired
	private ChuyenBayRepository chuyenBayRepository;

	@Autowired
	private MayBayRepository mayBayRepository;

	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Test
	@Transactional
	public void cau1() {
		List<ChuyenBay> list = chuyenBayRepository.findByGaDi("DAD");
		for (ChuyenBay c : list) {
			System.out.println(c);
		}
	}

	@Test
	@Transactional
	public void cau2() {
		List<MayBay> list = mayBayRepository.findByTamBayGreaterThan(10000);
		for (MayBay m : list) {
			System.out.println(m);

		}
	}

	@Test
	@Transactional
	public void cau3() {
		List<NhanVien> list = nhanVienRepository.findByLuongLessThan(10000);
		for (NhanVien n : list) {
			System.out.println(n);
		}
	}

	@Test
	@Transactional
	public void cau4() {
		List<ChuyenBay> list = chuyenBayRepository.findByDoDaiGreaterThanAndDoDaiLessThan(8000, 10000);
		for (ChuyenBay c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	@Transactional
	public void cau6() {
		List<ChuyenBay> list = chuyenBayRepository.findByDoDaiGreaterThanAndDoDaiLessThan(8000, 10000);
		for (ChuyenBay c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	@Transactional
	public void cau8() {
		int tongLuongPhaiTra = nhanVienRepository.totalLuong();
		System.out.println(tongLuongPhaiTra);
	}
	
	@Test
	@Transactional
	public void cau9() {
		List<MayBay> list = mayBayRepository.findByLoaiContains("Boeing");
		Set<NhanVien> filterd = new HashSet<>();
		for (MayBay m : list) {
			filterd.addAll(m.getDanhSachNhanVien());
		}
		
		filterd.forEach(nv -> System.out.println(nv));
	}
	
	@Test
	@Transactional
	public void cau11() {
		List<NhanVien> list = nhanVienRepository.findByTenLike("Nguyen%");
		Set<MayBay> listMB = new HashSet<>();
		for (NhanVien nv : list) {
			listMB.addAll(nv.getDanhSachMayBay());
		}
		
		for(MayBay mb : listMB){
			System.out.println(mb.getMaMB());
		}
		
//		List<NhanVien> list = nhanVienRepository.findByTenLike("Nguyen%");
//		Set<Integer> listMaMB = new HashSet<>();
//		for (NhanVien nv : list) {
//			nv.getDanhSachMayBay().forEach(mb -> listMaMB.add(mb.getMaMB()));
//		}
//		
//		for(Integer maMB : listMaMB){
//			System.out.println(maMB);
//		}
	}

	@Test
	@Transactional
	public void cau20() {
		List<ChuyenBay> list = chuyenBayRepository.flightsStartBeforeHour(12);
		for (ChuyenBay c : list) {
			System.out.println(c);
		}
	}
}
