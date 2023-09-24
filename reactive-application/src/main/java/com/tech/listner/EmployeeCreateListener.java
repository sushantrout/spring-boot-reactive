package com.tech.listner;

import com.tech.constant.KafkaConstant;
import com.tech.dto.EmployeeDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreateListener {

    @KafkaListener(topics = KafkaConstant.TOPIC, groupId = KafkaConstant.GROUP_ID)
    public EmployeeDTO listener(EmployeeDTO e) {
        System.out.println("***Msg recieved from Kafka Topic ::" + e);
        return e;
    }
}
