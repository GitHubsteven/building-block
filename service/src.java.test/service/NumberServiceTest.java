package service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * numberService test class
 *
 * Created by rongbin.xie on 2018/3/21.
 */
@RunWith(JUnit4.class)
public class NumberServiceTest {
    @Autowired
    private NumberService numberService;
    @Test
    @Ignore
    public void sortGrade() throws Exception {
        int[] numbers = {1,2,3};
        numberService.sortGrade(numbers);
    }

}