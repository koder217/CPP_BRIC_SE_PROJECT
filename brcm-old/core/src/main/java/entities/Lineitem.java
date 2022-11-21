package entities;

import javax.persistence.*;

@Entity
@Table(name = "lineitems")
public class Lineitem {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activityid", nullable = false)
    private Activity activityid;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointmentid", nullable = false)
    private Appointment appointmentid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderid", nullable = false)
    private Order orderid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activity getActivityid() {
        return activityid;
    }

    public void setActivityid(Activity activityid) {
        this.activityid = activityid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Appointment getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(Appointment appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Order getOrderid() {
        return orderid;
    }

    public void setOrderid(Order orderid) {
        this.orderid = orderid;
    }

}