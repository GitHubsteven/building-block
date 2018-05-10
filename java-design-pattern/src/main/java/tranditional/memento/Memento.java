package tranditional.memento;

import lombok.Data;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:06 2018/5/10.
 */
@Data
public class Memento {
    //身份标识
    private Long longId;

    private Integer bloodFlow;
    private Integer magicFlow;
    private Integer level;
    private String scene;
}
