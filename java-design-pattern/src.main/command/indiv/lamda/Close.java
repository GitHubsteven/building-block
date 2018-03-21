package command.indiv.lamda;

/**
 * close operation
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class Close implements Action {
    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }


    @Override
    public void operate(Long id) {
        editor.close();
    }
}
