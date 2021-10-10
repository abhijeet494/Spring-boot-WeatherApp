package com.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weather.entity.Root;
import com.weather.service.AppService;

/**
 * 
 * @author Abhijeet
 *
 */

@Controller
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private AppService appService;

	/*@GetMapping("/currentWeather/{city}")
	public ResponseEntity<Root> getWeatherDetails(@PathVariable("city") String city)
	{
		return new ResponseEntity<Root>(appService.getWeather(city), HttpStatus.OK);
	}*/

	@GetMapping("/currentWeather/{city}")
	public String getWeatherDetails(@PathVariable("city") String city,Model model)
	{
		try {
			Root root=appService.getWeather(city, model);
			logger.debug("Result of getWeather() ", root);
			return "index";
		} 

		catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("errorNote", e.getMessage());
			return "error";
		}

	}
}
