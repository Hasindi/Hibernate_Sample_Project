import IK.hibernate.entity.Customer;
import IK.hibernate.entity.Laptop;
import IK.hibernate.entity.Student;
import IK.hibernate.util.FactoryConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer  {

    public static void main(String[] args) {

/*        Customer c1 = new Customer();
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
        c4.setAddress("Galle");*/

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


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.save(l1);
        session.save(l2);

       /* //session.save(new Student("S003","Gayan"));
        session.save(new Laptop("L001","Hp",new Student("S003","Gayan")));*/

        transaction.commit();
        session.close();
    }

}
