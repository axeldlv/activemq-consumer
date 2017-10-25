package com.axeldlv.activemq.consumer.app.service;

import javax.jms.JMSException;

import com.axeldlv.activemq.consumer.app.domain.MessageDomain;


public interface MessageService {

	MessageDomain getConsumer() throws JMSException;

}
