package model;

//if you are considering the abstraction into the solution.
    //you are required to find the abstract methods
public abstract class Drinks {
    
    //Often, specify the data properties
    protected int id;
    protected String name;
    protected String supplier;
    protected int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
            
    //methods/operation
    public abstract void addNew();//unsure the impl details!

}
