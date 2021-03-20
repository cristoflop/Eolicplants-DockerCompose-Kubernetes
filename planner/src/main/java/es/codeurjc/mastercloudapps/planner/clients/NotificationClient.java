package es.codeurjc.mastercloudapps.planner.clients;

import es.codeurjc.mastercloudapps.planner.models.Eoloplant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationClient {

	private static Logger LOG = LoggerFactory.getLogger(NotificationClient.class);

	@Autowired
	RabbitTemplate rabbitTemplate;

	public void notify(Eoloplant eoloplant) {
		LOG.info("eoloplantCreationProgressNotifications: "+eoloplant);
		rabbitTemplate.convertAndSend("eoloplantCreationProgressNotifications", eoloplant);
	}
}
