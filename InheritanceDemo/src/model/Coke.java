package model;

//Object: A, B, C, D, E, Letter etc.
//Question: A is-a-kind-of Letter?
//Object: orange, apple, fruit
//Question: orange is-a-kind-of apple?
            //orange is-a-kind-of fruit? true 

public class Coke extends Drinks{
    
    //any specific piece of data?
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    //you override the abstract addNew method - mandatory
    @Override
    public void addNew() {
        System.out.println("Adding new coke: " + this.label);
    }
    
    
}
