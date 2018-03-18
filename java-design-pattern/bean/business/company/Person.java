package bean.business.company;

import bean.business.JavaDevDirEnum;

public class Person {
    private String name;
    private Integer age;
    /*性别*/
    private Integer general;
    private JavaDevDirEnum.JOB job;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getGeneral() {
        return general;
    }

    public Person setGeneral(Integer general) {
        this.general = general;
        return this;
    }

    public JavaDevDirEnum.JOB getJob() {
        return job;
    }

    public Person setJob(JavaDevDirEnum.JOB job) {
        this.job = job;
        return this;
    }

    /**
     * 生成人物
     *
     * @param name    姓名
     * @param age     年龄
     * @param general 性别（1 为男，0为女）
     * @param job     职位
     * @return 人物
     */
    public static Person createPerson(String name, Integer age, Integer general, JavaDevDirEnum.JOB job) {
        return new Person().setJob(job).setName(name).setAge(age).setGeneral(general);
    }
}
