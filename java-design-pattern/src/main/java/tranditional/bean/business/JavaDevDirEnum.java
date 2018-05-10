package tranditional.bean.business;

public class JavaDevDirEnum {

    public enum  ReportType{
        Logictis("Logictis"), Stock("Stock"), Order("Order");
        String val;
        ReportType(String val){
            this.val = val;
        }

        public String getVal(){
            return val;
        }
    }

    public enum JOB{
        LEADER("Leader"), STAFF("Staff");
        private String val;
        JOB(String val){
            this.val = val;
        }
        public String getVal(){
            return this.val;
        }
    }

    public enum TASK_TYPE{
        PICK_UP("00"), ON_SHLF("01");
        private String val;

        TASK_TYPE(String val){
            this.val = val;
        }
    }

    public enum COMMAND_ROLE {
        SOLDIER_ZERO("0"),SOLDIER_ONE("1"),SOLDIER_TWO("2");
        private String val;
        COMMAND_ROLE(String val){
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }
}
