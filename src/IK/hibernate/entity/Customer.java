package IK.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customerDetails")
public class Customer {
        @Id
        private String id;
        @Column(name = "customerName")
        private String name;
        private double salary;
        private String address;

        public Customer() {
        }

        public Customer(String id, String name, double salary, String address) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", salary='" + salary + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
}
