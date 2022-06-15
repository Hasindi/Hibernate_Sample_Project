package IK.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
    @Id
    private String lId;
    private String description;

    @OneToOne(mappedBy = "Student")
    private Student student;

    public Laptop() {
    }

    public Laptop(String lId, String description, Student student) {
        this.lId = lId;
        this.description = description;
        this.student = student;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId='" + lId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
