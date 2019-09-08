package com.taimi;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi
 * @ClassName: TaimiCloudApplication
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 19:48
 * @Version: 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 *@author kailin_zhou
 *@date 2019/9/8 19:48
 *@description TODO
 *@version v1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class TaimiCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaimiCloudApplication.class, args);
    }
}
