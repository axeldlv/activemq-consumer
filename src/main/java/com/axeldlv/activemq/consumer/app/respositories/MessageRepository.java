package com.axeldlv.activemq.consumer.app.respositories;

import org.springframework.data.repository.CrudRepository;

import com.axeldlv.activemq.consumer.app.domain.MessageDomain;

public interface MessageRepository extends CrudRepository<MessageDomain, Integer> {
}
