package command.indiv.lamda;

/**
 * save operation
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class Save implements Action {
    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }


    @Override
    public void operate(Long id) {
        editor.save();
    }
}
