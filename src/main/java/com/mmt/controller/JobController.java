package com.mmt.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmt.entity.Job;
import com.mmt.entity.User;
import com.mmt.service.JobService;
import com.mmt.service.UserService;

@Controller
public class JobController 
{
	@Autowired
    private JavaMailSender sender;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private Environment env;
	
    @Autowired
	private UserService userService;
    
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/job")
	public String job(Model model, @ModelAttribute(value="jobId") Long jobId) 
	{
		logger.info("++++++++ job ++++++++++");
		
		Job job = jobService.getJobById(jobId);
		
		model.addAttribute("job", job);
		
		return "job";
	}
	
    @ResponseBody
    @RequestMapping(value="/applyjob")
    public Integer applyJob(@ModelAttribute(value="jobId") Long jobId,
    		@ModelAttribute(value="userId") Long userId){
    	// read resume from resume path
    	User user = userService.getUser(userId);
    	String resume_path = user.getResumePath();
    	String[] paths = resume_path.split(File.separator);
    	String file_name = paths[paths.length - 1];
    	
    	// get job / enterprise details
    	Job job = jobService.getJobById(jobId);
    	String company_email = job.getCompany().getEmail();

    	MimeMessage message = sender.createMimeMessage();

    	// use the true flag to indicate you need a multipart message
    	MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(env.getProperty("spring.mail.username"));
	    	helper.setTo(company_email);
	    	helper.setSubject(String.format("求职简历 - %s 寻求职位 - %s", user.getName(), job.getName()));
	    	helper.setText(String.format("申请职位：%s", job.getName()));
	
	    	// let's attach the infamous windows Sample file (this time copied to c:/)
	    	FileSystemResource file = new FileSystemResource(new File(resume_path)); ///Users/leonchan/Documents/ZhaoPinWang.numbers"));
	    	helper.addAttachment(file_name, file);
	    	
	    	sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return 1;
		} catch (MailSendException mse) {
			mse.printStackTrace();
			return 1;
		}
    	
    	// 0 =  success; 1 = failure
    	return 0;
    }
	
}
