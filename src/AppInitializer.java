import IK.hibernate.entity.*;
import IK.hibernate.util.FactoryConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {

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

///////////////////////////////////////////////////////////////////////////////////////////////////////
        /*IN HQL*/

        // SELECT *

        String hql1 = "FROM Owner";  // need to add JPA Facet to the Module
        Query query1 = session.createQuery(hql1);
        List<Owner> ownerList = query1.list();

        for (Owner owner1 : ownerList) {
            System.out.println(owner1.getoId() + " : " + owner1.getName() + " : " + owner1.getPetList());
            // System.out.println(owner);
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////

        // SELECT specified COLUMN

        String hql2 = "SELECT name FROM Owner";
        Query query2 = session.createQuery(hql2);
        List<String> nameList = query2.list();   // return String List

        for (String name : nameList) {
            System.out.println(name);
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // WHERE clause
        String hql3 = "FROM Owner WHERE name LIKE 'D%'";
        Query query3 = session.createQuery(hql3);
        List<Owner> ownerList2 = query3.list();

        // List<Owner> ownerList = session.createQuery(hql3).list();

        for (Owner owner2 : ownerList2) {
            System.out.println(owner2.getoId() + " : " + owner2.getName() + " : " + owner2.getPetList());
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

        // DELETE clause -> query.executeUpdate()

        String id = "P003";
        String hql4 = "DELETE FROM Pet WHERE pId = :pet_id";

        Query query4 = session.createQuery(hql4);
        query4.setParameter("pet_id", id);

        System.out.println(query4.executeUpdate() > 0 ? "Deleted..!" : "OOPs! something went wrong!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        // UPDATE clause -> query.executeUpdate()

        String id2 = "O001";
        String name = "Sumera";

        String hql5 = "UPDATE Owner SET name = :owner_name WHERE oId = :owner_id";
        Query query5 = session.createQuery(hql5);
        query5.setParameter("owner_name", name);
        query5.setParameter("owner_id", id2);

        int rowCount = query5.executeUpdate();
        System.out.println(rowCount > 0 ? "Hureeeee!!!" : "OOPS!! something went wrong!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ----- Using name parameters -----

        // perform WHERE clause
        String name1 = "Danuja";
        String hql6 = "FROM Owner WHERE name = :owner_name";
        Query query6 = session.createQuery(hql6);
        query6.setParameter("owner_name", name1);
        List<Owner> ownerList3 = query6.list();

        for (Owner owner3 : ownerList3) {
            System.out.println(owner3.getoId() + " : " + owner3.getName() + " : " + owner3.getPetList());

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ORDER BY clause

        String hql7 = "FROM Owner o ORDER BY o.oId DESC";
        List<Owner> ownerList4 = session.createQuery(hql7).list();

        for (Owner owner4 : ownerList4) {
            System.out.println(owner4.getoId() + " : " + owner4.getName() + " : " + owner4.getPetList());
        }

            /*try {
                session.save();
                return true;
            } catch(Exception e) {
                System.out.println("somthing happend");
                return false;
            } finally {
                session.close();
            }*/

        transaction.commit();
        session.close();
    }
}
