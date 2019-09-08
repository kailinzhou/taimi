package com.taimi.constants;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.constants
 * @ClassName: MQConstants
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 20:41
 * @Version: 1.0
 */

/**
 * @author kailin_zhou
 * @version v1.0
 * @date 2019/9/8 20:41
 * @description TODO
 **/
public abstract class MQConstants {
    public static final class Exchange {
        /**
         * 钛米任务交换机名称
         */
        public static final String ROBOT_EXCHANGE_NAME = "taimi.job.exchange";
    }

    public static final class RoutingKey {
        /**
         * 新创建任务的routing-key
         */
        public static final String JOB_ASSIGN_KEY = "job.assign";
        /**
         * 医院状态回传的routing-key
         */
        public static final String STATUS_RECALL_KEY = "status.recall";

    }
    public static final class Queue{
        /**
         * 云服务新任务的队列
         */
        public static final String CLOUD_JOB_ASSIGN = "cloud.job.assign.queue";
        /**
         * 医院服务状态回传的队列
         */
        public static final String HOSPITAL_STATUS_RECALL= "hospital.status.recall.queue";

    }
}
