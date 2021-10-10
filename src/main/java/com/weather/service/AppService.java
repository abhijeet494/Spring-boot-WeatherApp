package com.weather.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.weather.entity.CurrentWeather;
import com.weather.entity.Root;
/**
 * 
 * @author Abhijeet
 *
 */
@Service
public class AppService {



	@Autowired
	private RestTemplate restTemplate;

	@Value("${appApikey}")
	private String apiey;

	private Root root;

	/**
	 * Weather api is getting call.
	 * 
	 * @param city
	 * @param model
	 * @return
	 */
	public Root getWeather(String city, Model model)
	{
		root= restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+city.trim()+"&APPID="+apiey+"&units=metric", Root.class);

		CurrentWeather currentWeather = new CurrentWeather(
				root.getWeather().get(0).getDescription(),
				root.getWeather().get(0).getIcon(),
				(double)Math.round(root.getMain().getTemp()),
				root.getMain().getHumidity(),root.getName());

		model.addAttribute("weather",currentWeather );
		model.addAttribute("img",currentWeather.getIcon());

		String tme= getTime();
		model.addAttribute("date", tme.substring(0, tme.indexOf('|')));
		model.addAttribute("time", tme.substring(tme.indexOf('|')+1));

		return root;
	}


	public String getTime()
	{

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy|HH:mm");

		String[] id = TimeZone.getAvailableIDs(root.getTimezone()*1000);

		if(id.length!=0)
		{
			String cityName=id[0];

			for(String i:id)
			{
				if(i.contains(root.getName()))
				{
					cityName=i;
					break;  
				}

			}

			sdf.setTimeZone(TimeZone.getTimeZone(cityName));

		}
		return sdf.format(date);
	}
}
