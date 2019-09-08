package com.taimi.listener;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.listener
 * @ClassName: MQlistener
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 21:17
 * @Version: 1.0
 */

import com.taimi.constants.MQConstants;
import com.taimi.service.RobotService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kailin_zhou
 * @version v1.0
 * @date 2019/9/8 21:17
 * @description TODO
 **/
@Component
public class MQlistener {

    @Autowired
    private RobotService robotService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = MQConstants.Queue.CLOUD_JOB_ASSIGN, durable = "true"),
            exchange = @Exchange(name = MQConstants.Exchange.ROBOT_EXCHANGE_NAME, type = ExchangeTypes.TOPIC),
            key = MQConstants.RoutingKey.JOB_ASSIGN_KEY
    ))
    public void assignJob(byte[] bytes) {
        if (bytes != null) {
            //新增商品到索引库
            robotService.createJob(bytes);
        }
    }
}
