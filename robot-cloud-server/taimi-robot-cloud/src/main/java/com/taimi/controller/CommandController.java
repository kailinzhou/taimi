package com.taimi.controller;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.controller
 * @ClassName: CommandController
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 20:00
 * @Version: 1.0
 */

import com.taimi.entity.JobEntityDTO;
import com.taimi.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@author kailin_zhou
 *@date 2019/9/8 20:00
 *@description demo
 *@version v1.0
 **/
@RestController
@RequestMapping("robot")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @PostMapping("/job")
    public ResponseEntity<Void> createJob(JobEntityDTO jobEntityDTO) {
        commandService.createJob(jobEntityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}