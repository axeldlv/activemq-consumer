package com.axeldlv.activemq.consumer.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messageDB")
public class MessageDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String text;
	private String messageId;
	private String producerID;
	private String jmsDestination;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public String getJmsDestination() {
		return jmsDestination;
	}

	public void setJmsDestination(String jmsDestination) {
		this.jmsDestination = jmsDestination;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageModel [text=").append(text).append(", messageId=").append(messageId)
				.append(", producerID=").append(producerID).append(", jmsDestination=").append(jmsDestination)
				.append(", getText()=").append(getText()).append(", getMessageId()=").append(getMessageId())
				.append(", getProducerID()=").append(getProducerID()).append(", getJmsDestination()=")
				.append(getJmsDestination()).append(", getClass()=").append(getClass()).append(", hashCode()=")
				.append(hashCode()).append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}
	
}
