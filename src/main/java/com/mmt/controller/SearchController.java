package com.mmt.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.entity.City;
import com.mmt.entity.Job;
import com.mmt.entity.JobType;
import com.mmt.service.CityService;
import com.mmt.service.JobService;
import com.mmt.service.JobTypeService;
import com.mmt.service.SearchService;

@Controller
public class SearchController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private JobTypeService jobTypeService;
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/search")
	public String search(Model model, @ModelAttribute(value="s_area") String s_area,
			   @ModelAttribute(value="s_jobfunction") String s_jobfunction,
			   @ModelAttribute(value="s_job") String s_job) {
		logger.info("++++++++ search jobs ++++++++++");
		
		List<Job> jobs = new ArrayList<Job>();
		List<Long> city_ids = Collections.emptyList();//new ArrayList<Long>();
		List<Long> jobtype_ids = Collections.emptyList();//new ArrayList<Long>();
		
		// get all the cities by name.
		if (s_area != null) {
			String[] s_areas = s_area.split("-");
			List<City> cities = cityService.findCityByNames(Arrays.asList(s_areas));
			if (cities != null) {
				for (City c : cities) {
					city_ids.add(c.getId());
				}
			}
		}
		
		if (s_jobfunction != null) {
			String[] s_jobfunctions = s_jobfunction.split("-");
			List<JobType> jobtypes = jobTypeService.findJobTypeByNames(Arrays.asList(s_jobfunctions));
			if (jobtypes != null) {
				for (JobType j : jobtypes) {
					if (j.getFlag() == 3) {
						jobtype_ids.add(j.getId());
					} else if (j.getFlag() == 2) {
						for (JobType l3_j : jobTypeService.findJobTypeByParentId(j.getParentId())) {
							jobtype_ids.add(l3_j.getId());
						}
					}
				}
			}
		}
		
		for (Job j : jobService.findJobsByCityAndJobFunctions(city_ids, jobtype_ids))  {
			String city_name = j.getCity().getName();
			String jobtype_name = j.getJobType().getType();
			
			System.out.println("job name:" + j.getName());
			
			if (city_name.contains(s_job) || jobtype_name.contains(s_job)) {
				jobs.add(j);
			}
		}
		
		return "search_result?PageNumber=1";
	}
	
	@RequestMapping(value="/search_jobfunction")
	public String search_by_jobfunction(Model model) {
		logger.info("++++++++enter search by job function page++++++++++");
		
		// get level 1 / 2 / 3 job functions
		List<JobType> level_one_jobtypes = jobTypeService.findAllLevelOneJobType();
		List<JobType> level_two_jobtypes = jobTypeService.findAllLevelTwoJobType();
		List<JobType> level_three_jobtypes = jobTypeService.findAllLevelThreeJobType();
		
		if (level_one_jobtypes != null) {
			model.addAttribute("level_one_jobtypes", level_one_jobtypes);
		}
		if (level_two_jobtypes != null) {
			model.addAttribute("level_two_jobtypes", level_two_jobtypes);
		}
		if (level_three_jobtypes != null) {
			model.addAttribute("level_three_jobtypes", level_three_jobtypes);
		}
		
		// get level 1 / 2 / 3 cities
		List<City> level_one_areas = cityService.findAllLevelOneArea();
		List<City> level_two_areas = cityService.findAllLevelTwoArea();
		List<City> level_three_areas = cityService.findAllLevelThreeArea();
		
		if (level_one_areas != null) {
			model.addAttribute("level_one_areas", level_one_areas);
		}
		if (level_two_areas != null) {
			model.addAttribute("level_two_areas", level_two_areas);
		}
		if (level_three_areas != null) {
			model.addAttribute("level_three_areas", level_three_areas);
		}
		
		return "search_jobfunction";
	}
	
	@RequestMapping(value="/search_area")
	public String search_by_area(Model model) {
		logger.info("++++++++enter search by area page++++++++++");
		
		// get level 1 / 2 / 3 cities
		List<City> level_one_areas = cityService.findAllLevelOneArea();
		List<City> level_two_areas = cityService.findAllLevelTwoArea();
		List<City> level_three_areas = cityService.findAllLevelThreeArea();
		
		if (level_one_areas != null) {
			model.addAttribute("level_one_areas", level_one_areas);
		}
		if (level_two_areas != null) {
			model.addAttribute("level_two_areas", level_two_areas);
		}
		if (level_three_areas != null) {
			model.addAttribute("level_three_areas", level_three_areas);
		}
		
		return "search_area";
	}
}
