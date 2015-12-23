package com.cirrius.calender.listview;

public class DoctorList {
	private String code = "";
	private String name = "";
	private int population = 0;

	private String drclass = "";
	private String drtime = "";

	public DoctorList(String code, String name, int population, String drclass,
			String drtime) {
		super();
		this.code = code;
		this.name = name;
		this.population = population;
		this.drclass = drclass;
		this.drtime = drtime;

	}

	public String getDrtime() {
		return drtime;
	}

	public void setDrtime(String drtime) {
		this.drtime = drtime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getDrclass() {
		return drclass;
	}

	public void setDrclass(String drclass) {
		this.drclass = drclass;
	}
}
