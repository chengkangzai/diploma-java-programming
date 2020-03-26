package MyLogger;

import assignment.DB;

/**
 * PurchaseLog
 */
public class PurchaseLog extends MyLogger {

    private final String id;
    private String body;


    public PurchaseLog(String id) {
        setHead("PURCHASE");
        addHeadIndent(1);
        this.id = id;
        wordBody();
    }

    public void wordBody() {
        body = "A Purchase of " + DB.getStockNameByID(id) + "was made. Current Stock is "+ DB.getStockByID(id);
        setBody(body);
    }
}