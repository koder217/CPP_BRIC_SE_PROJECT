package edu.cpp.brcm.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "starttime", nullable = false)
    private Instant starttime;

    @Column(name = "endtime", nullable = false)
    private Instant endtime;

    @Column(name = "activityid", nullable = false)
    private Integer activityid;

    @Column(name = "customerid", nullable = false)
    private Integer customerid;

    @Lob
    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getStarttime() {
        return starttime;
    }

    public void setStarttime(Instant starttime) {
        this.starttime = starttime;
    }

    public Instant getEndtime() {
        return endtime;
    }

    public void setEndtime(Instant endtime) {
        this.endtime = endtime;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}