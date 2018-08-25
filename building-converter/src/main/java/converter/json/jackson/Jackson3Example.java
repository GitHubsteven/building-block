package converter.json.jackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/24
 * @Time: 20:54
 * @Description:
 * @version: 1.0.0
 */
public class Jackson3Example {
    public static void main(String[] args) {
        Jackson3Example obj = new Jackson3Example();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        StaffOne staff = createDummyObject();

        try {

            // Salary will be hidden
            System.out.println("Normal View");
            String normalView = mapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
            System.out.println(normalView);

            String jsonInString = "{\"name\":\"mkyong\",\"age\":33,\"position\":\"Developer\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
            StaffOne normalStaff = mapper.readerWithView(Views.Normal.class).forType(StaffOne.class).readValue(jsonInString);
            System.out.println(normalStaff);

            // Display everything
            System.out.println("\nManager View");
            String managerView = mapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
            System.out.println(managerView);

            StaffOne managerStaff = mapper.readerWithView(Views.Manager.class).forType(StaffOne.class).readValue(jsonInString);
            System.out.println(managerStaff);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StaffOne createDummyObject() {

        StaffOne staff = new StaffOne();

        staff.setName("mkyong");
        staff.setAge(33);
        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal("7500"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");

        staff.setSkills(skills);

        return staff;

    }
}