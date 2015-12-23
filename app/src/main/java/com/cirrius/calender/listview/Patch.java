package com.cirrius.calender.listview;

import java.util.ArrayList;

public class Patch {

	private String name;
	String patchtime;
	private ArrayList<DoctorList> countryList = new ArrayList<DoctorList>();

	public Patch(String name, String patchtime, ArrayList<DoctorList> countryList) {
		super();
		this.name = name;
		this.patchtime = patchtime;
		this.countryList = countryList;
	}

	public String getPatchtime() {
		return patchtime;
	}

	public void setPatchtime(String patchtime) {
		this.patchtime = patchtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DoctorList> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<DoctorList> countryList) {
		this.countryList = countryList;
	};

}
