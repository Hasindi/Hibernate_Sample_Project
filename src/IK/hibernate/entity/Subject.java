package IK.hibernate.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    @Id
    private String subId;
    private String name;

    @ManyToMany
    private List<Lecture> lectureList = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subId, String name) {
        this.subId = subId;
        this.name = name;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId='" + subId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
