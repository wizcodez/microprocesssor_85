/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microprocessor_85;

/**
 *
 * @author Sairaj Hemachandran & Nishka Gulati
 */
public class DataTransfer extends Initialization{
     //Move immediate data instruction                                 //how to differentiate immediate operation ie MVI from MOv
    public static void MVI(char register, int data){
        switch(register){
            case 'A': A = data; break;
            case 'B': B = data; break;
            case 'C': C = data; break;
            case 'D': D = data; break;
            case 'E': E = data; break;
            case 'H': H = data; break;
            case 'L': L = data; break;
            case 'M':
                {   
                    int address = generateAddress(L, H);
                    memory[address] = data;
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
    }
    
    //Move instruction
    public static void MOV(char register1, char register2){
        switch(register2){
            case 'A': MVI(register1,A); break;
            case 'B': MVI(register1,B); break;
            case 'C': MVI(register1,C); break;
            case 'D': MVI(register1,D); break;
            case 'E': MVI(register1,E); break;
            case 'H': MVI(register1,H); break;
            case 'L': MVI(register1,L); break;
            default: break;
        }
        if(register1 == 'M')
        {
            int address = generateAddress(L, H);
            switch(register2){
            case 'A': memory[address] = A; break;
            case 'B': memory[address] = B; break;
            case 'C': memory[address] = C; break;
            case 'D': memory[address] = D; break;
            case 'E': memory[address] = E; break;
            case 'H': memory[address] = H; break;
            case 'L': memory[address] = L; break;
            default: break;
            }
        }
        else if(register2 == 'M')
        {
            int address = generateAddress(L, H);
            switch(register2){
            case 'A': A = memory[address]; break;
            case 'B': B = memory[address]; break;
            case 'C': C = memory[address]; break;
            case 'D': D = memory[address]; break;
            case 'E': E = memory[address]; break;
            case 'H': H = memory[address]; break;
            case 'L': L = memory[address]; break;
            default: break;
            }
        }
    }
    
    //Load Accumulator 
    public static void LDA(int address){ 
        int temp = memory[address];
        setA(temp);
    }
    
    //Load Accumulator with Register pair
    public static void LDAX(char register_pair){ 
        switch(register_pair){
            case 'B':
            {
                int address = generateAddress(C, B);
                A = memory[address];
                break;
            }
            case 'D':
            {
                int address = generateAddress(E, D);
                A = memory[address];
                break;
            }
            default: System.out.println("Invalid input"); break;
        }
    }
    
    //Store Register pair with Accumulator 
    public static void STAX(char register_pair){ 
        switch(register_pair){
            case 'B':
            {
                int address = generateAddress(C, B);
                memory[address] = A;
                break;
            }
            case 'D':
            {
                int address = generateAddress(E, D);
                memory[address] = A;
                break;
            }
            default: System.out.println("Invalid input"); break;
        }
    }
    
    //Store Accumulator content 
    public static void STA(int address){
        int temp = getA();
        memory[address] = temp;
    }
    
    //Load HL register pair
    public static void LHLD(int address){ 
        int temp = memory[address];
        setL(temp);
        temp = memory[address+1];
        setH(temp);
    }
    
    //Store HL register pair
    public static void SHLD(int address){ 
        int temp = getL();
        memory[address] = temp;
        temp = getH();
        memory[address+1] = temp;
    }
    
    //Load register pair
    public static void LXI(char X,int word){ 
        int byte1 = word & 0x00ff;
        int byte2 = word & 0xff00;
        switch(X)
        {
            case 'H':{
                        setH(byte2);
                        setL(byte1);
                        break;
                     }
            case 'B':{
                        setB(byte2);
                        setC(byte1);
                        break;
                     }
            case 'D':{
                        setD(byte2);
                        setE(byte1);
                        break;
                     }
            default: System.out.println("invalid input");
        }

    }
    
    public static void XCHG(){
        int temp1 = getH();
        int temp2 = getL();
        setH(getD());
        setL(getE());
        setD(temp1);
        setE(temp2);
    }
}
