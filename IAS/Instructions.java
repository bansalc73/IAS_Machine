package IAS;

import IAS.Accumulator;

//Different instructions performing their task as per IAS
public class Instructions {
    
    static public void LOAD_Mx(Memory M,int x,Accumulator AC){
        System.out.println("LOAD M("+x+")");
        AC.setAccContent(M.getData(x));
        int data = Integer.parseInt(AC.getAccContent(),2);
        System.out.println( data + " : Stored in Accumulator");
    }
    static public void STOR_Mx(Memory M,int x,Accumulator AC){
        System.out.println("STOR M("+x+")");
        M.setData(AC.getAccContent(), x);
        int data = Integer.parseInt(M.getData(x),2);
        System.out.println( data + " : Stored in Memory location "+x);
    }
    static public void ADD_Mx(Memory M,int x,Accumulator AC){
        System.out.println("ADD M("+x+")");
        int a = Integer.parseInt(M.getData(x),2);
        int b = Integer.parseInt(AC.getAccContent(),2);
        System.out.println("Adding " + a +" and "+b);
        AC.setAccContent(Integer.toBinaryString(a+b));
        int data = Integer.parseInt(AC.getAccContent(),2);
        System.out.println( data + " : Stored in Accumulator");
    }
    static public void SUB_Mx(Memory M,int x,Accumulator AC){
        System.out.println("SUB M("+x+")");
        int a = Integer.parseInt(M.getData(x),2);
        int b = Integer.parseInt(AC.getAccContent(),2);
        System.out.println("Subtracting " + a +" and "+b);
        AC.setAccContent(Integer.toBinaryString(a-b));
        int data = Integer.parseInt(AC.getAccContent(),2);
        System.out.println( data + " : Stored in Accumulator");
    }
    static public void JUMP_Left(Integer x,Registers reg){
        System.out.println("JUMP M("+x+",0:19)");
        reg.pc.setPc(x);
        reg.ir.setCode("0");
    }
    static public void JUMP_Right(Memory M,Integer x,Registers reg){
        System.out.println("JUMP M("+x+",20:39)");
        reg.ibr.setInstruction(M.getRightCode(x), M.getRightAddr(x));
        reg.pc.setPc(x+1);
    }
    static public void JUMPMx_Left(Integer x,Registers reg,Accumulator AC){
        System.out.println("JUMP + M("+x+",0:19)");
        int data = Integer.parseInt(AC.getAccContent(),2);
        System.out.println( data + " : is in Accumulator");
        if(data >= 0){
            reg.pc.setPc(x);
            reg.ir.setCode("0");
        }
    }
    static public void JUMPMx_Right(Memory M,Integer x,Registers reg,Accumulator AC){
        System.out.println("JUMP + M("+x+",20:39)");
        int data = Integer.parseInt(AC.getAccContent(),2);
        System.out.println( data + " : is in Accumulator");
        if(data >= 0){
            reg.ibr.setInstruction(M.getRightCode(x), M.getRightAddr(x));
            reg.pc.setPc(x+1);
        }
    }
}