
package sss;

public class TemperatureConvert {
    String fah;
    String cel;
    
    public String toFarenheit(){
        double result = 0 ;
        double fahdbl = Double.parseDouble(cel);
        result = (fahdbl-32)*5/9;
        return Double.toString(result);
    }
    
    
}
