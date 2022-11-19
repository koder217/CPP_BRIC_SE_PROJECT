package dtos;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link entities.Appointment} entity
 */
public class AppointmentDto implements Serializable {
    private final Integer id;
    private final Instant starttime;
    private final Instant endtime;
    private final Integer activityid;
    private final Integer customerid;

    public AppointmentDto(Integer id, Instant starttime, Instant endtime, Integer activityid, Integer customerid) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.activityid = activityid;
        this.customerid = customerid;
    }

    public Integer getId() {
        return id;
    }

    public Instant getStarttime() {
        return starttime;
    }

    public Instant getEndtime() {
        return endtime;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public Integer getCustomerid() {
        return customerid;
    }
}