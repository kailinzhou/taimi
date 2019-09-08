package com.taimi.entity;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.entity
 * @ClassName: Status
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 22:23
 * @Version: 1.0
 */

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 *@author kailin_zhou
 *@date 2019/9/8 22:23
 *@description TODO
 *@version v1.0
 **/

public class Status implements Serializable {
    private static final long serialVersionUID=2L;
    private Long robotID;
    private String status;

    @Override
    public String toString() {
        return "Status{" +
                "robotID=" + robotID +
                ", status='" + status + '\'' +
                '}';
    }

    public Status(Long robotID, String status) {
        this.robotID = robotID;
        this.status = status;
    }

    public Long getRobotID() {
        return robotID;
    }

    public void setRobotID(Long robotID) {
        this.robotID = robotID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
