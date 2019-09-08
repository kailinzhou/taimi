package com.taimi.entity;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi.entity
 * @ClassName: JobEntityDTO
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 20:04
 * @Version: 1.0
 */

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 *@author kailin_zhou
 *@date 2019/9/8 20:04
 *@description TODO
 *@version v1.0
 **/

public class JobEntityDTO  implements Serializable {
    private static final long serialVersionUID=1L;
    private long id;
    private long robotID;
    private long hospitalID;
    private String job;

    @Override
    public String toString() {
        return "JobEntityDTO{" +
                "id=" + id +
                ", robotID=" + robotID +
                ", hospitalID=" + hospitalID +
                ", job='" + job + '\'' +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRobotID() {
        return robotID;
    }

    public void setRobotID(long robotID) {
        this.robotID = robotID;
    }

    public long getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(long hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
