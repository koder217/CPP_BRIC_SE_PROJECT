package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Customer customers;

    @Column(name = "enterdate", nullable = false)
    private LocalDate enterdate;

    @Lob
    @Column(name = "major", nullable = false)
    private String major;

    @Lob
    @Column(name = "minor", nullable = false)
    private String minor;

    @Column(name = "graddate", nullable = false)
    private LocalDate graddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public LocalDate getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(LocalDate enterdate) {
        this.enterdate = enterdate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public LocalDate getGraddate() {
        return graddate;
    }

    public void setGraddate(LocalDate graddate) {
        this.graddate = graddate;
    }

}