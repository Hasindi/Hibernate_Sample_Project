package IK.hibernate.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    @Id
    private String subId;
    private String name;

    @ManyToMany(mappedBy = "subjectList")
    private List<Lecture> lectureList = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subId, String name, List<Lecture> lectureList) {
        this.subId = subId;
        this.name = name;
        this.lectureList = lectureList;
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

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId='" + subId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
