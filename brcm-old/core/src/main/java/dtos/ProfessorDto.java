package dtos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Professor} entity
 */
public class ProfessorDto extends CustomerDto implements Serializable {
    private final Integer id;
    private final String department;
    private final String office;
    private final String research;

    public ProfessorDto(Integer id, String department, String office, String research, String firstname, String lastname, LocalDate dateofbirth, String phone) {
        super(id, firstname, lastname, dateofbirth, phone);
        this.id = id;
        this.department = department;
        this.office = office;
        this.research = research;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getOffice() {
        return office;
    }

    public String getResearch() {
        return research;
    }
}