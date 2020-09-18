import IAS.*;

public class Program_1 {
    public static void main(String[] args) {
        Memory M = new Memory();
        Accumulator AC = new Accumulator();
        Registers reg = new Registers();

        //Instruction codes
        String null_ins = "00000000";
        String add  = "00000101";
        String load = "00000001";
        String stor = "00100001";
        String halt = "11111111";

        //Pre-Programming Of memory
        //Setting Data in last 500 memory blocks
        M.setData(Integer.toBinaryString(10), 500);
        M.setData(Integer.toBinaryString(5), 501);

        //Setting instructions in first 500 blocks
        M.setLeftInstruction(load,Integer.toBinaryString(500),0);
        M.setRightInstruction(add,Integer.toBinaryString(501),0);
        M.setRightInstruction(stor,Integer.toBinaryString(502),1);
        M.setLeftInstruction(halt,"0",4);

        while(!M.getLeftCode(reg.pc.getPc()).equals(halt)){
            if(reg.ir.getCode().equals(null_ins)){
                Fetch.fetch(reg.pc.getPc(), reg, M);
                reg.pc.setPc(reg.pc.getPc()+1);
            }
            DecodeExecute.deocde(M,AC,reg); 
        }
        System.out.println("Program Halted at PC:" + reg.pc.getPc());
        System.out.println("Success");

    }
}