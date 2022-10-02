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


@Table(name = "nhanvien")
@Entity
public class NhanVien {
	@Id
	@Column(name = "MaNV")
	private String maNV;
	@Column(name = "Ten")
	private String ten;
	@Column(name = "Luong")
	private int luong;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "chungnhan",
			joinColumns = { @JoinColumn(name = "MaNV", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "MaMB", nullable = false) }
	)
	private List<MayBay> danhSachMayBay;

	public NhanVien() {
	}

	public NhanVien(String maNV, String ten, int luong) {
		this.maNV = maNV;
		this.ten = ten;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
	

	public List<MayBay> getDanhSachMayBay() {
		return danhSachMayBay;
	}

	public void setDanhSachMayBay(List<MayBay> danhSachMayBay) {
		this.danhSachMayBay = danhSachMayBay;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ten=" + ten + ", luong=" + luong + "]";
	}

}
