package com.taimi.application;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi
 * @ClassName: TaimiRegistry
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 19:44
 * @Version: 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author kailin_zhou
 * @version v1.0
 * @date 2019/9/8 19:44
 * @description TODO
 **/
@EnableEurekaServer
@SpringBootApplication
public class TaimiRegistry {
    public static void main(String[] args) {
        SpringApplication.run(TaimiRegistry.class, args);
    }
}
