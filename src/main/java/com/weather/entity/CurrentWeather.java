package com.weather.entity;

public class CurrentWeather {

	private String description;
    private String icon;
    private Double temp;
    private Integer humidity;
    private String name;
	public CurrentWeather(String description, String icon, Double temp, Integer humidity, String name) {
		super();
		this.description = description;
		this.icon = icon;
		this.temp = temp;
		this.humidity = humidity;
		this.name = name;
	}
	public CurrentWeather() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CurrentWeather [description=" + description + ", icon=" + icon + ", temp=" + temp + ", humidity="
				+ humidity + ", name=" + name + "]";
	}
    
    
}
