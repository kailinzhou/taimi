package com.taimi.service;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.service
 * @ClassName: CommandService
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 20:10
 * @Version: 1.0
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taimi.Util.BeanSerializeUtil;
import com.taimi.constants.MQConstants;
import com.taimi.entity.JobEntityDTO;
import com.taimi.entity.Status;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author kailin_zhou
 * @version v1.0
 * @date 2019/9/8 20:10
 * @description TODO
 **/
@Service
@Slf4j
public class CommandService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private BeanSerializeUtil beanSerializeUtil;
    @Autowired
    private ObjectMapper objectMapper;

    public void createJob(JobEntityDTO jobEntityDTO) {
        logger.info("开始运行任务");

        amqpTemplate.convertAndSend(MQConstants.Exchange.ROBOT_EXCHANGE_NAME, MQConstants.RoutingKey.JOB_ASSIGN_KEY, SerializationUtils.serialize(jobEntityDTO));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void statusRecall(byte[] bytes) {
        Status status = SerializationUtils.deserialize(bytes);
        logger.info("状态回调" + status.toString());
    }
}
