package xstream.generic.custom.characteristic;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 20:28 2019/2/20.
 */
@Setter
@Getter
@XMLSequence({"imID", "zipCode"})
public class Buyer {
    private String email;
    private String zipCode;
    private String address;
    private String imID;
    private String name;
    private String phone;
    private String mobile;
}