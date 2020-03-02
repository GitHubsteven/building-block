package leetcode.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/3/1
 * @Descrition:
 */
@Setter
@Getter
public class AccountNode {
    private String name;
    private List<String> emails;
    private AccountNode next;
}
