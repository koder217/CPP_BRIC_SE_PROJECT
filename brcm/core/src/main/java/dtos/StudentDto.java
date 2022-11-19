package dtos;

import entities.Student;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Student} entity
 */
public class StudentDto implements Serializable {
    private final Integer id;
    private final LocalDate enterdate;
    private final String major;
    private final String minor;
    private final LocalDate graddate;

    public StudentDto(Integer id, LocalDate enterdate, String major, String minor, LocalDate graddate) {
        this.id = id;
        this.enterdate = enterdate;
        this.major = major;
        this.minor = minor;
        this.graddate = graddate;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getEnterdate() {
        return enterdate;
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public LocalDate getGraddate() {
        return graddate;
    }
}