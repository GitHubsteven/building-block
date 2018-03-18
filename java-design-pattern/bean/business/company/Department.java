package bean.business.company;

import javafx.util.Builder;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
    private String name;
    private Integer peopleNumber;
    private Person  leader;
    private List<Person> staffList;


    Department(DepartmentBuilder builder){
        this.name = builder.name;
        this.peopleNumber = builder.peopleNumber;
        this.leader = builder.leader;
    }

    public static class DepartmentBuilder implements Builder<Department>{

        private String name;
        private Integer peopleNumber;
        private Person  leader;

        public DepartmentBuilder(String name, Integer peopleNumber, Person leader) {
            this.name = name;
            this.peopleNumber = peopleNumber;
            this.leader = leader;
        }

        @Override
        public Department build() {
            return new Department(this);
        }
    }

    public List<Person> getStaffList() {
        return staffList;
    }

    public Department setStaffList(List<Person> staffList) {
        this.staffList = staffList;
        return this;
    }

    public String getName() {
        return name;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public Person getLeader() {
        return leader;
    }
}
