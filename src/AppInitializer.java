import IK.hibernate.entity.*;
import IK.hibernate.util.FactoryConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AppInitializer  {

    public static void main(String[] args) {

        //Customer
        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName("Kamal");
        c1.setSalary(25000);
        c1.setAddress("Galle");

        Customer c2 = new Customer();
        c2.setId("C002");
        c2.setName("Nuwan");
        c2.setSalary(25000);
        c2.setAddress("Galle");

        Customer c3 = new Customer();
        c3.setId("C003");
        c3.setName("Gayan");
        c3.setSalary(25000);
        c3.setAddress("Galle");

        Customer c4 = new Customer();
        c4.setId("C004");
        c4.setName("Pawan");
        c4.setSalary(25000);
        c4.setAddress("Galle");


        //Student
        Student s1 = new Student();
        s1.setId("S001");
        s1.setName("Hasindi");

        Student s2 = new Student();
        s2.setId("S002");
        s2.setName("Hasindi");


        //Laptop
        Laptop l1 = new Laptop();
        l1.setlId("L001");
        l1.setDescription("Asus");
        l1.setStudent(s1);

        Laptop l2 = new Laptop();
        l2.setlId("L002");
        l2.setDescription("Dell");
        l2.setStudent(s2);

      /*session.save(new Student("S003","Gayan"));
        session.save(new Laptop("L001","Hp",new Student("S003","Gayan")));*/


        //Owner
        Owner o1 = new Owner();
        o1.setoId("O001");
        o1.setName("Hasindi");


        //Pet
        Pet p1 = new Pet();
        p1.setpId("P001");
        p1.setName("Dog");
        p1.setOwner(o1);

        Pet p2 = new Pet();
        p2.setpId("P002");
        p2.setName("Cat");
        p2.setOwner(o1);

        //method 1
        ArrayList<Pet> petList = new ArrayList<>();
        petList.add(p1);
        petList.add(p2);
        o1.setPetList(petList);

     /*   //method 2
        o1.getPetList().add(p1);
        o1.getPetList().add(p2);*/


        //Lecture
        Lecture lec1 = new Lecture();
        lec1.setLecId("LE001");
        lec1.setName("Hasindi");

        Lecture lec2 = new Lecture();
        lec2.setLecId("LE002");
        lec2.setName("Dasun");


        //Subject
        Subject sub1 = new Subject();
        sub1.setSubId("SUB001");
        sub1.setName("ORM");

        Subject sub2 = new Subject();
        sub2.setSubId("SUB002");
        sub2.setName("PRF");


        //method 2
        ArrayList<Lecture> lectureArrayList = new ArrayList<>();
        lectureArrayList.add(lec1);
        lectureArrayList.add(lec2);

        ArrayList<Subject> subList = new ArrayList<>();
        subList.add(sub1);
        subList.add(sub2);

        lec1.setSubjectList(subList);
        lec2.setSubjectList(subList);
        sub1.setLectureList(lectureArrayList);
        sub2.setLectureList(lectureArrayList);

      /*  //method 2
        lec1.getSubjectList().add(sub1);
        lec2.getSubjectList().add(sub2);

        sub1.getLectureList().add(lec1);
        sub2.getLectureList().add(lec2);*/


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(s1);
        session.save(s2);
        session.save(l1);
        session.save(l2);
        session.save(o1);
        session.save(p1);
        session.save(p2);
        session.save(lec1);
        session.save(lec2);
        session.save(sub1);
        session.save(sub2);


        transaction.commit();
        session.close();
    }

}
