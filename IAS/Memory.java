package IAS;

public class Memory{

    //A 2-d Array of 1000 rows as in IAS and 2 colums for left and right instruction
    private Instruction[][] mainMemory = new Instruction[1000][2];

    public  Memory(){
        for(int i=0;i<1000;i++){
            mainMemory[i][0] = new Instruction();
            mainMemory[i][1] = new Instruction();
        }
    }

    //Getters and setters methos for every data member
    public String getData(int x){
        return this.mainMemory[x][1].getAddress();
    }
    public void setData(String s,int x){
        s = ("000000000000"+s).substring(s.length());
        mainMemory[x][1].setAddress(s);
    }
    public String getLeftCode(int x){
        return this.mainMemory[x][0].getOpCode();
    }
    public String getRightCode(int x){
        return this.mainMemory[x][1].getOpCode();
    }
    public String getLeftAddr(int x){
        return this.mainMemory[x][0].getAddress();
    }
    public String getRightAddr(int x){
        return this.mainMemory[x][1].getAddress();
    }
  
    public void setLeftInstruction(String code,String addr,int x){
        code = ("00000000"+code).substring(code.length());
        addr = ("000000000000"+addr).substring(addr.length());
        mainMemory[x][0].setOpCode(code);
        mainMemory[x][0].setAddress(addr);
    }
    public void setRightInstruction(String code,String addr,int x){
        code = ("00000000"+code).substring(code.length());
        addr = ("000000000000"+addr).substring(addr.length());
        mainMemory[x][1].setOpCode(code);
        mainMemory[x][1].setAddress(addr);
    }
   
}

//A base instruction class that is a basic building block of instruction
class Instruction{
    private String opCode;
    private String address;

    Instruction(){
        this.opCode = "00000000";
        this.address = "000000000000";
    }

    public void setOpCode(String s){
        this.opCode = s;
    }
    public void setAddress(String s){
        this.address = s;
    }
    public String getOpCode(){
        return this.opCode;
    }
    public String getAddress(){
        return this.address;
    }
}