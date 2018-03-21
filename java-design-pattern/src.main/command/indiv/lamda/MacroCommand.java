package command.indiv.lamda;

/**
 * macro commander pattern?
 * <p>
 * Created by rongbin.xie on 2018/3/21.
 */
public class MacroCommand {
    public static void main(String[] args) {
        Editor editor = new XMLEditor();
        Macro macro = new Macro();

//        macro.record(new Open(editor));
//        macro.record(new Save(editor));
//        macro.record(new Close(editor));

//        macro.run();

        //macro lamda;
        macro.record((it)->editor.open());
        macro.record((it)->editor.save());
        macro.record((it)->editor.close());

        macro.run();
    }
}
