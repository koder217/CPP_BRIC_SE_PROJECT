package edu.cpp.brcm.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historicalprice")
public class Historicalprice {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activityid", nullable = false)
    private Activity activityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Activity getActivityid() {
        return activityid;
    }

    public void setActivityid(Activity activityid) {
        this.activityid = activityid;
    }

}