package sis.main;

import java.io.Serializable;

public class Student implements Serializable {

	private String Name;
	private String ID;
	private String Major;
	private String Semester;
	private String Credit;
	private String CGPA;

	public Student() {
		super();
	}

	public Student(String name, String ID, String major, String semester, String credit, String cGPA) {
		super();
		this.Name = name;
		this.ID = ID;
		this.Major = major;
		this.Semester = semester;
		this.Credit = credit;
		this.CGPA = cGPA;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public String getCredit() {
		return Credit;
	}

	public void setCredit(String credit) {
		Credit = credit;
	}

	public String getCGPA() {
		return CGPA;
	}

	public void setCGPA(String cGPA) {
		CGPA = cGPA;
	}
}