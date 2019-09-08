package com.taimi;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi
 * @ClassName: TaimiHospitalApplication
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 21:15
 * @Version: 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@author kailin_zhou
 *@date 2019/9/8 21:15
 *@description TODO
 *@version v1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class TaimiHospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaimiHospitalApplication.class, args);
    }
}
