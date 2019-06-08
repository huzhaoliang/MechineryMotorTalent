package com.mmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	private int pageSize = 20;
	
	@RequestMapping(value="/search")
	public String search(Model model, @ModelAttribute(value="s_area") String s_area,
			   @ModelAttribute(value="s_jobfunction") String s_jobfunction,
			   @ModelAttribute(value="s_job") String s_job,
			   @ModelAttribute(value="pageNumber") int pageNumber) {
		logger.info("++++++++ search jobs ++++++++++");
		
		Page<Job> jobs = jobService.searchJobs(s_area, s_jobfunction, s_job, pageNumber, this.pageSize);
		
		if(jobs != null) {
			model.addAttribute("jobs", jobs);
		}
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalPages", jobs.getTotalPages());
		model.addAttribute("s_area", s_area);
		model.addAttribute("s_jobfunction", s_jobfunction);
		model.addAttribute("s_job", s_job);
		
		return "search";
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
