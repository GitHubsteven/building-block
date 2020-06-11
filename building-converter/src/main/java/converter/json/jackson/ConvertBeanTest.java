package converter.json.jackson;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/11
 * @description 测试BeanUtils.copy和convert的效率问题
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ConvertBeanTest {

    public static void main(String[] args) {
        StaffWrapper wrapper = new StaffWrapper("id_1", getStaff());
        WorkerWrapper workerWrapper = new WorkerWrapper();
        BeanUtils.copyProperties(wrapper, workerWrapper);
        System.out.println(workerWrapper.getId());

        BeanUtils.copyProperties(wrapper.getStaff(), workerWrapper.getStaff());
        System.out.println(workerWrapper.getStaff().getAge());
    }

    /**
     * 运算次数 | beanUtils | convert
     * <p>
     * 10 	 130	 273
     * 100 	 7	 10
     * 1000 	 11	 24
     * 10000 	 24	 58
     * 100000 	 69	 156
     */
    private static void loop() {
        Staff staff = ReadValueTest.getStaff();
        Arrays.asList(10, 100, 1000, 10000, 100000).forEach(n -> {
            long beanUtils = beanUtils(n, staff);
            long convert = convert(n, staff);
            String result = String.format("%d \t %d\t %d", n, beanUtils, convert);
            System.out.println(result);
        });
    }

    public static long beanUtils(int n, Staff staff) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker();
            BeanUtils.copyProperties(staff, worker);
        }
        return System.currentTimeMillis() - start;
    }

    public static long convert(int n, Staff staff) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Worker worker = JacksonConstant.OM.convertValue(staff, Worker.class);
        }
        return System.currentTimeMillis() - start;
    }

    protected static Staff getStaff() {
        return new Staff().setAge(1)
                .setName("rb.x")
                .setPosition("sh")
                .setSalary(new BigDecimal("100.23"))
                .setSkills(Arrays.asList("java", "mysql"));
    }

}
