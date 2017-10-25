package com.axeldlv.activemq.consumer.app.service;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.axeldlv.activemq.consumer.app.controller.WebController;
import com.axeldlv.activemq.consumer.app.domain.MessageDomain;
import com.axeldlv.activemq.consumer.app.respositories.MessageRepository;

@Component
public class MessageServiceImpl implements MessageService {

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);

	@Value("${spring.activemq.broker-url}")
	private String url;

	@Value("${jms.queue.destination}")
	private String queue;

	private MessageRepository messageRepository;

	@Autowired
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public MessageDomain getConsumer() throws JMSException {
		logger.info("Begin Method getConsumer()");

		// ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		// Connection
		Connection connection = connectionFactory.createConnection();
		logger.info("Connection START");

		MessageDomain md = new MessageDomain();

		try {
			// Creating session to get messages
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			logger.info("Session START : " + session);

			// Getting the queue
			logger.info("Destination START : " + queue);
			Queue destination = session.createQueue(queue);

			// Consume the message from destination Synchronously
			MessageConsumer consumer = session.createConsumer(destination);

			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						logger.info("Message START : " + message);
						md.setText(((ActiveMQTextMessage) message).getText());
						md.setJmsDestination(((ActiveMQTextMessage) message).getJMSDestination().toString());
						md.setProducerID(((ActiveMQTextMessage) message).getProducerId().toString());
						md.setMessageId(((ActiveMQTextMessage) message).getJMSMessageID());
						if (md != null) {
							logger.info("Message Consumed :" + md);
							logger.info("Saving");
							messageRepository.save(md);
						}
					} catch (JMSException e) {
						logger.info("Error reading message" + e.getMessage());
					}
				}
			});
			connection.start();
			Thread.sleep(2000);
		} catch (NullPointerException e) {
			logger.info("Exception : " + e.getMessage());
		} catch (InterruptedException e) {
			logger.info("InterruptedException : " + e.getMessage());
		} finally {
			connection.close();
			logger.info("Finally");
		}

		logger.info("End Method getConsumer()");
		return md;
	}
}
