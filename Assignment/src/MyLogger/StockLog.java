package MyLogger;

import assignment.DB;

/**
 * StockLog
 */
public class StockLog extends MyLogger {

    private String id;
    private String body;
    private String type;

    public StockLog(String id, String type) {
        this.type = type;
        setHead(type.toUpperCase());
        addHeadIndent(1);
        this.id = id;
        wordBody();
    }

    public void wordBody() {
        body = "A " + type + " of " + DB.getStockNameByID(id) + "(" + id + ")" + " was made. Current Stock is "
                + DB.getStockByID(id);
        setBody(body);
    }
}