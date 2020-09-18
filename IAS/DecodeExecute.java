package IAS;

import IAS.Instructions;

public class DecodeExecute {

    //Different types of Instructions
    static String null_mx = "00000000";
    static String stor_Mx="00100001";
    static String load_Mx = "00000001";
    static String add_Mx = "00000101";
    static String sub_Mx = "00000110";
    static String jump_left = "00001101";
    static String jump_right = "00001110";
    static String jumpMx_left = "00001111";
    static String jumpMx_right = "00010000"; 

    
    public static void deocde(Memory M,Accumulator AC,Registers reg){

        //If the instruction is null i.e 0
        if(reg.ir.getCode().equals(null_mx)){
            return;
        }
        //If there is some instruction
        else{
            System.out.println();
            System.out.println("************DECODE**************");
            if(reg.ir.getCode().equals(stor_Mx)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.STOR_Mx(M,x, AC);
            }
            else if(reg.ir.getCode().equals(load_Mx)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.LOAD_Mx(M, x, AC);
            }
            else if(reg.ir.getCode().equals(add_Mx)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.ADD_Mx(M, x, AC);
            }
            else if(reg.ir.getCode().equals(sub_Mx)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.SUB_Mx(M, x, AC);
            }
            else if(reg.ir.getCode().equals(jump_left)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.JUMP_Left(x, reg);
                System.out.println("********************************");
                return;
            }
            else if(reg.ir.getCode().equals(jump_right)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.JUMP_Right(M,x, reg);
            }
            else if(reg.ir.getCode().equals(jumpMx_left)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.JUMPMx_Left(x, reg, AC);
                System.out.println("********************************");
                return;
            }
            else if(reg.ir.getCode().equals(jumpMx_right)){
                int x = Integer.parseInt(reg.mar.getAddr(),2);
                Instructions.JUMPMx_Right(M,x, reg,AC);
            }
            reg.ir.setCode(reg.ibr.getCode());
            reg.mar.setAddr(reg.ibr.getAddr());
            reg.ibr.setInstruction("0","0");
            System.out.println("********************************");
            System.out.println();
        }
        
    }
}