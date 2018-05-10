package tranditional.composite.company.business;

import tranditional.bean.business.company.Department;
import tranditional.bean.business.company.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司结构就是一个典型的树形结构，公司下有很多个子公司，但是子公司和父公司一样具有相同的结构，依次类推，不断的叠加
 */
public class Company {

    private Person leader;
    private List<Department> departments = new ArrayList<>();
    private String name;
    private List<Company> subCompany = new ArrayList<>();
    private Company parentCompany;

    public List<Department> getDepartments() {
        return departments;
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public List<Company> getSubCompany() {
        return subCompany;
    }

    public Company getParentCompany() {
        return parentCompany;
    }

    public Company setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
        return this;
    }

    public boolean addSubCompany(Company newCompany){
        return this.subCompany.add(newCompany);
    }

    public boolean addDepartment(Department newDepartment){
        return this.departments.add(newDepartment);
    }

    public boolean removeSubCompany(Company company){
        return this.subCompany.remove(company);
    }

    public boolean removeDepartment(Department department){
        return this.departments.remove(department);
    }

    public Person getLeader() {
        return leader;
    }

    public Company setLeader(Person leader) {
        this.leader = leader;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "leader=" + leader.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
