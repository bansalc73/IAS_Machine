package IAS;

public class Accumulator {
    private String accContent;

    public void setAccContent(String s){
        s = ("000000000000"+s).substring(s.length());
        this.accContent = s;
    }
    public String getAccContent(){
        return this.accContent;
    }
}