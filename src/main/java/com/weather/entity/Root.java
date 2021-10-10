package com.weather.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    private List<Weather> weather = new ArrayList<Weather>();
    private String base;
    private Main main;
    private Integer visibility;
    private Integer dt;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
	public Root(List<Weather> weather, String base, Main main, Integer visibility, Integer dt, Integer timezone,
			Integer id, String name, Integer cod) {
		super();
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.visibility = visibility;
		this.dt = dt;
		this.timezone = timezone;
		this.id = id;
		this.name = name;
		this.cod = cod;
	}
	public Root() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public Integer getTimezone() {
		return timezone;
	}
	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "Root [weather=" + weather + ", base=" + base + ", main=" + main + ", visibility=" + visibility + ", dt="
				+ dt + ", timezone=" + timezone + ", id=" + id + ", name=" + name + ", cod=" + cod + "]";
	}
    
    
}
