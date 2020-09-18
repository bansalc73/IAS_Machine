import IAS.*;

public class Program_2 {
    public static void main(String[] args) {
        Memory M = new Memory();
        Accumulator AC = new Accumulator();
        Registers reg = new Registers();

        //Instruction codes
        String null_ins = "00000000";
        String add  = "00000101";
        String sub = "00000110";
        String load = "00000001";
        String stor = "00100001";
        String jump_left = "00001101";
        String jump_right = "00001110";
        String jumpMx_left = "00001111";
        String jumpMx_right = "00010000";
        String halt = "11111111";

        //Pre-Programming Of memory
        //Setting Data in last 500 memory blocks
        M.setData(Integer.toBinaryString(5), 500);
        M.setData(Integer.toBinaryString(15), 501);

        //Setting instructions in first 500 blocks
        M.setLeftInstruction(load,Integer.toBinaryString(500),0);
        M.setRightInstruction(sub,Integer.toBinaryString(501),0);
        M.setLeftInstruction(jumpMx_left,Integer.toBinaryString(2),1);
        M.setRightInstruction(jump_right,Integer.toBinaryString(3),1);
        M.setLeftInstruction(stor,Integer.toBinaryString(502),2);
        M.setRightInstruction(jump_left,Integer.toBinaryString(5),2);
        M.setLeftInstruction(load,Integer.toBinaryString(500),3);
        M.setRightInstruction(add,Integer.toBinaryString(501),3);
        M.setRightInstruction(stor,Integer.toBinaryString(502),4);
        
        M.setLeftInstruction(halt,"0",5);

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