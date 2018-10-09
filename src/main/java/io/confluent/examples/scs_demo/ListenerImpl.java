package io.confluent.examples.scs_demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(ListenerDefinition.class)
public class ListenerImpl {

	@StreamListener(ListenerDefinition.INPUT)
	public void processRawMessage(Message<?> message) {
		System.out.println("Received message in processRawMessage(): "+message);
		byte[] payloadBytes = (byte[]) message.getPayload();
		String payload = new String(payloadBytes);
		System.out.println("Payload: "+payload);
		System.out.println("");
	}

	@StreamListener(ListenerDefinition.INPUT)
	public void processDeserialised(String jsonPayload) {
		System.out.println("Received message in processDeserialised(): "+jsonPayload);
		System.out.println("");
	}
}
