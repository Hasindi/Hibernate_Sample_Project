package IK.hibernate.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
    @Id
    private String lecId;
    private String name;

    @ManyToMany
    private List<Subject> subjectList = new ArrayList<>();

    public Lecture() {
    }

    public Lecture(String lecId, String name) {
        this.lecId = lecId;
        this.name = name;
    }

    public String getLecId() {
        return lecId;
    }

    public void setLecId(String lecId) {
        this.lecId = lecId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lecId='" + lecId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
