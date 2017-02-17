package com.application.activemq;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.activemq.topic.customer.ActiveMQTopicMessageCustomer;
import com.application.base.activemq.topic.producer.ActiveMQTopicMessageProducer;
import com.application.base.core.BaseJunit4Test;

public class ActiveMQTopicTest extends BaseJunit4Test {

	// 队列消息生产者
	@Autowired
	private ActiveMQTopicMessageProducer topicProducer;

	// 队列消息消费者
	@Autowired
	private ActiveMQTopicMessageCustomer topicCustomer;

	private String destionQueue = "topic.activeMQ";
	
	@Test
	public void send() {
		String msg = "topic-往消息队列中注入消息";
		for (int i = 0; i < 20; i++) {
			logger.info(msg+i);
			topicProducer.sendMessage(msg+i,destionQueue,false,50000);
		}
	}
	
	@Test
	public void receive() {
		List<TextMessage> messages = topicCustomer.receiveMessage(destionQueue);
		try {
			for (TextMessage message : messages) {
				logger.info("====================================================================================================================");
				logger.info("接收到消息是:"+message.getText());
				logger.info("====================================================================================================================");
			}
		}
		catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
