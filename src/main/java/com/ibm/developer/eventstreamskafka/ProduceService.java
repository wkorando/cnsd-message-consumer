package com.ibm.developer.eventstreamskafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {

	private ProduceRepo repo;

	public ProduceService(ProduceRepo repo) {
		this.repo = repo;
	}

	@KafkaListener(topics = "${listener.topic}")
	public void addNewProduce(ConsumerRecord<String, Produce> message) {
		Produce produce = message.value();
		repo.save(produce);
	}

}
