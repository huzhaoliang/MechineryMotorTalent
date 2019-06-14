package com.mmt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.entity.EnterpriseUser;
import com.mmt.entity.Job;
import com.mmt.service.EnterpriseService;
import com.mmt.service.JobService;

@Controller
public class EnterpriseController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/manage/enter_list")
	public String list(Model model) {
		logger.info("++++++++enterprise list++++++++++");
		List<EnterpriseUser> list = enterpriseService.getAllEnterprise();
		model.addAttribute("enterprises", list);
		return "manage/enter_list";
	}

	@RequestMapping(value="/enterprise")
	public String search(Model model, @ModelAttribute(value="entId") Long entId) {
		EnterpriseUser eu = enterpriseService.getEUser(entId);
		List<Job> eu_jobs = jobService.findJobsByEnterprise(entId);
		
		String reString = null;
		try {
			Reader is = eu.getDescription().getCharacterStream();// 得到流
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {
				sb.append(s);
				s = br.readLine();
			}
			reString = sb.toString();
			if (br != null) {
				br.close();
			}
			if (is != null) {
				is.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("eu", eu);
		model.addAttribute("eu_jobs", eu_jobs);
		model.addAttribute("eu_description", reString);
		
		return "enterprise";
	}
}