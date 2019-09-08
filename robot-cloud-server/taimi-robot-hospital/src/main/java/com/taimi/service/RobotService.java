package com.taimi.service;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.service
 * @ClassName: RobotService
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 21:27
 * @Version: 1.0
 */

import com.taimi.Util.BeanSerializeUtil;
import com.taimi.constants.MQConstants;
import com.taimi.entity.JobEntityDTO;
import com.taimi.entity.Status;
import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kailin_zhou
 * @version v1.0
 * @date 2019/9/8 21:27
 * @description TODO
 **/
@Service
public class RobotService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private BeanSerializeUtil beanSerializeUtil;

    public void createJob(byte[] bytes) {
        JobEntityDTO jobEntity = null;
        if (bytes != null) {
            try {
                jobEntity = (JobEntityDTO) SerializationUtils.deserialize(bytes);
                logger.info("执行任务" + jobEntity);
                Status status = new Status(jobEntity.getRobotID(), "ok");
                amqpTemplate.convertAndSend(MQConstants.Exchange.ROBOT_EXCHANGE_NAME, MQConstants.RoutingKey.STATUS_RECALL_KEY, SerializationUtils.serialize(status));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
