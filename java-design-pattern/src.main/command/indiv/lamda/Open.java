package command.indiv.lamda;

/**
 * open operation
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class Open implements Action {
    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }


    @Override
    public void operate(Long id) {
        editor.open();
    }
}
