package IAS;

//Different Registers as in IAS
public class Registers {
    public MAR mar = new MAR();
    public IR ir = new IR();
    public IBR ibr = new IBR();
    public MBR mbr = new MBR();
    public PC pc = new PC();

    public class MAR{
        private String addr;
    
        public void setAddr(String s){
            s = ("000000000000"+s).substring(s.length());
            this.addr = s;
        }
        public String getAddr(){
            return this.addr;
        }
    }
    public class PC{
        private Integer pc;
        public PC(){
            this.pc = 0;
        }
        public Integer getPc(){
            return this.pc;
        }
        public void setPc(Integer x){
            this.pc = x;
        }
    }
    public class IR{
        private String instructionCode;
    
        public IR(){
            this.instructionCode = "00000000";
        }
        public void setCode(String s){
            s = ("00000000"+s).substring(s.length());
            this.instructionCode = s;
        }
        public String getCode(){
            return this.instructionCode;
        }
    }
    public class IBR{
        private String addr;
        private String insCode;
    
        public String getAddr(){
            return this.addr;
        }  
        public String getCode(){
            return this.insCode;
        }
        public void setInstruction(String code,String addr){
            code = ("00000000"+code).substring(code.length());
            addr = ("000000000000"+addr).substring(addr.length());
            this.insCode= code;
            this.addr = addr;
        }
    
    }
    public class MBR{
        private String leftCode;
        private String leftAddr;
        private String rightCode;
        private String rightAddr;
    
        public void setLeftInstruction(String code,String addr){
            code = ("00000000"+code).substring(code.length());
            addr = ("000000000000"+addr).substring(addr.length());
            this.leftCode = code;
            this.leftAddr = addr;
    
        }
        public void setRightInstruction(String code,String addr){
            code = ("00000000"+code).substring(code.length());
            addr = ("000000000000"+addr).substring(addr.length());
            this.rightCode = code;
            this.rightAddr = addr;
    
        }
        public String getLeftCode(){
            return this.leftCode;
        }
        public String getLeftAddress(){
            return this.leftAddr;
        }
        public String getRightCode(){
            return this.rightCode;
        }
        public String getRightAddress(){
            return this.rightAddr;
        }
    }
}

