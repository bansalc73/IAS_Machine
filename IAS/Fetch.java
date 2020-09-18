package IAS;

public class Fetch {
    static String nullCode="00000000";

    public static void fetch(int PC,Registers reg,Memory M){
        System.out.println();
        System.out.println("***********FETCH****************");
        System.out.println("PC : "+PC);

        //If both the instructions are absent
        if(M.getLeftCode(PC).equals(nullCode) && M.getRightCode(PC).equals(nullCode)){
            System.out.println("No Instruction Present");
            System.out.println("********************************");
            return;
        }
        reg.mar.setAddr(Integer.toBinaryString(PC));
        int x = Integer.parseInt(reg.mar.getAddr(),2);
        reg.mbr.setLeftInstruction(M.getLeftCode(x), M.getLeftAddr(x));
        reg.mbr.setRightInstruction(M.getRightCode(x), M.getRightAddr(x));

        //Only one instruction present 
        if(reg.mbr.getLeftCode().equals(nullCode)){
            System.out.println("Left Instruction Absent");
            System.out.println("Right Instruction Present");
            reg.ibr.setInstruction("0","0");
            reg.ir.setCode(reg.mbr.getRightCode());
            reg.mar.setAddr(reg.mbr.getRightAddress());
        }
        //Both left and right instruction is present
        else{
            System.out.println("Left Instruction Present");
            System.out.println("Right Instruction Present");
            reg.ibr.setInstruction(reg.mbr.getRightCode(), reg.mbr.getRightAddress());
            reg.ir.setCode(reg.mbr.getLeftCode());
            reg.mar.setAddr(reg.mbr.getLeftAddress());
        }
        System.out.println("********************************");
        System.out.println();
    }
}