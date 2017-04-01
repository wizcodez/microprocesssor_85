/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microprocessor_85;

import java.util.Arrays;

/**
 *
 * @author Sairaj Hemachandran & Nishka Gulati
 */
public class Logical extends Initialization{
    //Compare with accumulator
    public static void CMP(char register){
        int temp;
        char[] temp1 = getFlagReg();
        switch(register){
            case 'A': CPI(A); break;
            case 'B': CPI(B); break;
            case 'C': CPI(C); break;
            case 'D': CPI(D); break;
            case 'E': CPI(E); break;
            case 'H': CPI(H); break;
            case 'L': CPI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    CPI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        
    }
    
    //Compare immediate data with accumulator
    public static void CPI(int data){
        int temp;
        char[] temp1 = getFlagReg();
            temp = A - data;
            if(temp>0)
            {
                temp1[7]='0';
                temp1[1]='0';
            }
            else if(temp==data)
            {
                temp1[1]='1';
            }
            else
            {
                temp1[7]='1';
            }
            setFlagReg(temp1);
        }
    
    //AND with accumulator
    public static void ANA(char register){
        int temp;
        char[] temp1 = getFlagReg();
        switch(register){
            case 'A': ANI(A); break;
            case 'B': ANI(B); break;
            case 'C': ANI(C); break;
            case 'D': ANI(D); break;
            case 'E': ANI(E); break;
            case 'H': ANI(H); break;
            case 'L': ANI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    ANI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        
    }
    
    //AND immediate data with accumulator
    public static void ANI(int data){
        int temp;
        char[] temp1 = getFlagReg();
            temp = A & data;
            temp1[7] = '0';
            temp1[3] = '1';
            if(temp<0)
            {
                temp1[1]='1';
            }
            else if(temp==0x00)
            {
                temp1[1]='1';
            }
            else if(temp>0)
            {
                temp1[1]='0';
            }
            String temp2 = Integer.toBinaryString(temp);
            char[] temp3 = temp2.toCharArray();
            int cnt=0;
            for(int i=0;i<7;i++)
            {   
                if(temp3[i]=='1')
                {
                    cnt++;
                }
            }
            if(cnt%2==0)
                {
                    temp1[5]='1';
                }
                else temp1[5]='0';
            setFlagReg(temp1);
        }
        
    //XOR with accumulator
    public static void XOR(char register){
        int temp;
        char[] temp1 = getFlagReg();
        switch(register){
            case 'A': XRI(A); break;
            case 'B': XRI(B); break;
            case 'C': XRI(C); break;
            case 'D': XRI(D); break;
            case 'E': XRI(E); break;
            case 'H': XRI(H); break;
            case 'L': XRI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    XRI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        
    }
    
    //XOR immediate data with accumulator
    public static void XRI(int data){
        int temp;
        char[] temp1 = getFlagReg();
            temp = A ^ data;
            A = temp;
            temp1[7] = '0';
            temp1[3] = '0';
            if(temp<0)
            {
                temp1[1]='1';
            }
            else if(temp==0x00)
            {
                temp1[1]='1';
            }
            else if(temp>0)
            {
                temp1[1]='0';
            }
            String temp2 = Integer.toBinaryString(temp);
            char[] temp3 = temp2.toCharArray();
            int cnt=0;
            for(int i=0;i<7;i++)
            {   
                if(temp3[i]=='1')
                {
                    cnt++;
                }
            }
            if(cnt%2==0)
                {
                    temp1[5]='1';
                }
                else temp1[5]='0';
            setFlagReg(temp1);
        }
    
    //OR with accumulator
    public static void ORA(char register){
        int temp;
        char[] temp1 = getFlagReg();
        switch(register){
            case 'A': ORI(A); break;
            case 'B': ORI(B); break;
            case 'C': ORI(C); break;
            case 'D': ORI(D); break;
            case 'E': ORI(E); break;
            case 'H': ORI(H); break;
            case 'L': ORI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    ORI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        
    }
    
    //OR immediate data with accumulator
    public static void ORI(int data){
        int temp;
        char[] temp1 = getFlagReg();
            temp = A | data;
            A = temp;
            temp1[7] = '0';
            temp1[3] = '0';
            if(temp<0)
            {
                temp1[1]='1';
            }
            else if(temp==0x00)
            {
                temp1[1]='1';
            }
            else if(temp>0)
            {
                temp1[1]='0';
            }
            String temp2 = Integer.toBinaryString(temp);
            char[] temp3 = temp2.toCharArray();
            int cnt=0;
            for(int i=0;i<7;i++)
            {   
                if(temp3[i]=='1')
                {
                    cnt++;
                }
            }
            if(cnt%2==0)
                {
                    temp1[5]='1';
                }
                else temp1[5]='0';
            setFlagReg(temp1);
        }
    
    //Complement Accumulator
    public static void CMA()
    {
        A = ~A;
    }
    
    //Complement carry
    public static void CMC(){
        char[] temp1 = getFlagReg();
        if(temp1[7]=='1')
        {
            temp1[7]='0';
        }
        else temp1[7]='1';
        setFlagReg(temp1);
    }
    
    //Set carry
    public static void STC(){
        char[] temp1 = getFlagReg();
        temp1[7]='1';
        setFlagReg(temp1);
    }
    
    //Rotate accumulator left through carry
    public static void RAL(){
        String y = "";
        String temp = String.format("%8s", Integer.toBinaryString(A)).replace(' ', '0');
        char[] temp1 = getFlagReg();
        char[] temp3 = temp.toCharArray();
        char temp2 = temp3[0];
        for(int i=0;i<temp3.length-1;i++)
        {
            temp3[i]=temp3[i+1];
        }
        temp3[7]=temp1[7];
        temp1[7]=temp2;
        for(int i=0;i<temp3.length;i++)
        {
        String x = Character.toString(temp3[i]);
        y = y+x;
        }
        A = Integer.parseInt(y,2);
        setFlagReg(temp1); 
    }
    
    //Rotate accumulator left without carry
    public static void RLC(){
        String y = "";
        String temp = String.format("%8s", Integer.toBinaryString(A)).replace(' ', '0');
        char[] temp1 = getFlagReg();
        char[] temp3 = temp.toCharArray();
        char temp2 = temp3[0];
        for(int i=0;i<temp3.length-1;i++)
        {
            temp3[i]=temp3[i+1];
        }
        temp3[7]=temp2;
        temp1[7]=temp2;
        for(int i=0;i<temp3.length;i++)
        {
        String x = Character.toString(temp3[i]);
        y = y+x;
        }
        A = Integer.parseInt(y,2);
        setFlagReg(temp1); 
    }
    
    //Rotate accumulator right through carry
    public static void RAR(){
        
        String y = "";
        String temp = String.format("%8s", Integer.toBinaryString(A)).replace(' ', '0');
        char[] temp1 = getFlagReg();
        char[] temp3 = temp.toCharArray();
        char temp2 = temp3[7];
        for(int i=6;i>=0;i--)
        {
            temp3[i+1]=temp3[i];
        }
        temp3[0]=temp1[7];
        temp1[7]=temp2;
        for(int i=0;i<temp3.length;i++)
        {
        String x = Character.toString(temp3[i]);
        y = y+x;
        }
        A = Integer.parseInt(y,2);
        setFlagReg(temp1); 
    }
    //Rotate accumulator right without carry
    public static void RRC(){
        
        String y = "";
        String temp = String.format("%8s", Integer.toBinaryString(A)).replace(' ', '0');
        char[] temp1 = getFlagReg();
        char[] temp3 = temp.toCharArray();
        char temp2 = temp3[7];
        for(int i=6;i>=0;i--)
        {
            temp3[i+1]=temp3[i];
        }
        temp3[0]=temp2;
        temp1[7]=temp2;
        for(int i=0;i<temp3.length;i++)
        {
        String x = Character.toString(temp3[i]);
        y = y+x;
        }
        A = Integer.parseInt(y,2);
        setFlagReg(temp1); 
    }
}
