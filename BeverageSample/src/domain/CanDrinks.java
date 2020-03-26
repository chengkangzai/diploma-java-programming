package domain;

import java.nio.file.StandardOpenOption;

public class CanDrinks extends Drinks{
    
    private String slogan; //encapsulate the data

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public void addNew() {
        String line = String.join("|", Integer.toString(this.getId()), this.getName(), this.getQuantity(), this.getSupplier(), 
                this.getSlogan());
        line += System.lineSeparator();
        super.writeTo(line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    @Override
    public void edit() {
        String newline = String.join("|", Integer.toString(this.getId()), this.getName(), this.getQuantity(), this.getSupplier(),
                this.getSlogan());
        super.update(Integer.toString(this.getId()), newline);
    }
    
    
}
