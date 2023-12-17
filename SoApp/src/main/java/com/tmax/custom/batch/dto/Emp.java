package com.tmax.custom.batch.dto;

public class Emp {
	private Integer empno;
	private String ename;

	public Emp() {
	}

	public Emp(Integer empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public String getEname() {

		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "empno: " + empno + ", ename: " + ename;
	}
}
