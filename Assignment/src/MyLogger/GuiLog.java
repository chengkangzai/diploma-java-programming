package MyLogger;

/**
 * GuiLog
 */
public class GuiLog extends MyLogger {

    private int PlStatus;
    private String PlName;

    public GuiLog(int status, String PanelName) {
        this.PlStatus = status;
        this.PlName = PanelName;
        wordBody();
        wordHead();
    }

    public void wordHead(){
        if("Admin Panel".equals(PlName)){
            setHead("WARNING");
            addHeadIndent(1);
        }else if ("GUI".equals(PlName)){
            setHead("INFO");
            addHeadIndent(2);
        }
    }

    public void wordBody() {
        if (PlStatus == 0) {
            setBody("The " + PlName + " was initialized");
        } else if (PlStatus == 1) {
            setBody("The " + PlName + " was close");
        }
    }
}