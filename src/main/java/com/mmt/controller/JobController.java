package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmt.entity.Job;
import com.mmt.service.JobService;

@Controller
public class JobController 
{
    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/job")
	public String job() 
	{
		logger.info("++++++++ job ++++++++++");
		
		return "job";
	}
	
	public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
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
    	
    	// send email
    	SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(ent_email);
        msg.setText("Dear");
        
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            logger.error(ex.getMessage());
        }
    	
    	// 0 =  success; 1 = failure
    	return 0;
    }
	
}
