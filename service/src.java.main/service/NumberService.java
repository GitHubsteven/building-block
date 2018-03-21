package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service to handle numbers
 *
 * Created by rongbin.xie on 2018/3/21.
 */
@Service
public class NumberService  {
    @Autowired
    private SortService sortService;

    int[] sortGrade(int[] grades){
        return sortService.sort(grades);
    }
}
