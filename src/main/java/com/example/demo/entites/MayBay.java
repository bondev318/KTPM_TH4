package com.example.demo.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "maybay")
@Entity
public class MayBay {
	@Id
	@Column(name = "MaMB")
	private int maMB;
	@Column(name = "Loai")
	private String loai;
	@Column(name = "TamBay")
	private int tamBay;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "danhSachMayBay")
	private List<NhanVien> danhSachNhanVien;
	
	
	public MayBay() {
		
	}
	
	public MayBay(int maMB, String loai, int tamBay) {
		this.maMB = maMB;
		this.loai = loai;
		this.tamBay = tamBay;
	}
	public int getMaMB() {
		return maMB;
	}
	public void setMaMB(int maMB) {
		this.maMB = maMB;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getTamBay() {
		return tamBay;
	}
	public void setTamBay(int tamBay) {
		this.tamBay = tamBay;
	}

	
	public List<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	@Override
	public String toString() {
		return "MayBay [maMB=" + maMB + ", loai=" + loai + ", tamBay=" + tamBay + "]";
	}
	
	
}
