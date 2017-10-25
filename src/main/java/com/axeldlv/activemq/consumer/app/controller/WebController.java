package com.axeldlv.activemq.consumer.app.controller;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.axeldlv.activemq.consumer.app.domain.MessageDomain;
import com.axeldlv.activemq.consumer.app.service.MessageService;

@Controller
public class WebController {

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);

	@Autowired
	MessageService messageService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		logger.info("Method getIndexPage()");
		// ModelAndView("index") identify the page
		return new ModelAndView("index").addObject("name", "Axel from JAVA");
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView messagePage() throws JMSException {
		logger.info("Method messagePage()");
		return new ModelAndView("message");
	}
	
	@RequestMapping(value = "/getInfoMessage", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView receive() throws JMSException {
		logger.info("Method receive()");
		messageService.getConsumer();
		return new ModelAndView("message");
	}
}
