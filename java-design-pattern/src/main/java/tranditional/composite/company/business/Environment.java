package tranditional.composite.company.business;

import tranditional.bean.business.JavaDevDirEnum;
import tranditional.bean.business.company.Department;
import tranditional.bean.business.company.Person;

public class Environment {
    public static void main(String[] args) {
        Person techLeader = new Person().setName("XB").setAge(40).setGeneral(1).setJob(JavaDevDirEnum.JOB.LEADER);
        Person allLeader = new Person().setName("DM").setAge(40).setGeneral(1).setJob(JavaDevDirEnum.JOB.LEADER);
        Person hrLeader = new Person().setName("amanda").setAge(35).setGeneral(0).setJob(JavaDevDirEnum.JOB.LEADER);
        Person SNLeader = new Person().setName("sneaker").setAge(35).setGeneral(1).setJob(JavaDevDirEnum.JOB.LEADER);

        Company voyageOne = new Company("VoyageOne");
        Department hrDepartment = new Department.DepartmentBuilder("HR", 100, hrLeader).build();
        voyageOne.setLeader(allLeader).addDepartment(hrDepartment);
        Company voyageOneTech = new Company("VoyageOne_Tech").setParentCompany(voyageOne).setLeader(techLeader);
        voyageOne.addSubCompany(voyageOneTech);
        Company sneakerHead = new Company("sneakerHead").setParentCompany(voyageOne).setLeader(SNLeader);
        voyageOne.addSubCompany(sneakerHead);

        voyageOne.getSubCompany().forEach(System.out::println);
    }

}
