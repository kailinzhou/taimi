package com.taimi.listener;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.listener
 * @ClassName: MQlistener
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 22:21
 * @Version: 1.0
 */

import com.taimi.constants.MQConstants;
import com.taimi.controller.CommandController;
import com.taimi.service.CommandService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author kailin_zhou
 *@date 2019/9/8 22:21
 *@description TODO
 *@version v1.0
 **/
@Component
public class MQlistener {
    @Autowired
    private CommandService commandService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = MQConstants.Queue.HOSPITAL_STATUS_RECALL, durable = "true"),
            exchange = @Exchange(name = MQConstants.Exchange.ROBOT_EXCHANGE_NAME, type = ExchangeTypes.TOPIC),
            key = MQConstants.RoutingKey.STATUS_RECALL_KEY
    ))
    public void statusRecall(byte[] bytes) {
        if (bytes != null) {
            //状态回调
            commandService.statusRecall(bytes);
        }
    }
}
