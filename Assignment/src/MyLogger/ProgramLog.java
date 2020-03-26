package MyLogger;




/**
 * ProgramLog
 */
public class ProgramLog extends MyLogger{

    
    private int PlStatus;
    public ProgramLog(int status){
        setHead("INFO");
        addHeadIndent(2);
        this.PlStatus = status;
        wordBody();
    }
    
    public void setPLStatus(int status) {
        this.PlStatus = status;
    }

    public int getPLStatus() {
        return PlStatus;
    }

    public void wordBody() {
        if (PlStatus ==0) {
            setBody("The Software was initialized");
        }else if (PlStatus ==1){
            setBody("The Software was close");
        }
    }
}