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
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmt.entity.Job;
import com.mmt.service.JobService;

@Controller
public class JobController 
{
	@Autowired
    private JavaMailSender sender;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private Environment environment;
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/job")
	public String job() 
	{
		logger.info("++++++++ job ++++++++++");
		
		return "job";
	}
	
    @ResponseBody
    @RequestMapping(value="/applyjob")
    public Integer applyJob(@ModelAttribute(value="jobId") Long jobId,
    		@ModelAttribute(value="userId") Long userId){
        // get user object
    	
    	// read resume from resume path
    	
    	// get job / enterprise details
    	Job job = jobService.getJobById(jobId);
    	String ent_email = job.getCompany().getEmail();

    	MimeMessage message = sender.createMimeMessage();

    	// use the true flag to indicate you need a multipart message
    	MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
	    	helper.setTo("leonchan1204@hotmail.com");
	    	helper.setSubject("Hi There");
	    	helper.setText("Check out this image!");
	
	    	// let's attach the infamous windows Sample file (this time copied to c:/)
	    	FileSystemResource file = new FileSystemResource(new File("/Users/leonchan/Documents/ZhaoPinWang.numbers"));
	    	helper.addAttachment("求职简历.doc", file);
	    	
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
