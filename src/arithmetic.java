/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;


import java.util.Arrays;

/**
 *
 * @author Sairaj
 */
class arithmetic {
    private static String setup = "00000000";
    private static int A,B,C,D,E,H,L;
    private static int memory[] = new int[0xffff];
     public static char[] FlagReg;

    public static char[] getFlagReg() {
        return FlagReg;
    }

    public static void setFlagReg(char[] FlagReg) {
        arithmetic.FlagReg = FlagReg;
    }

    public static int getC() {
        return C;
    }

    public static void setC(int C) {
        arithmetic.C = C;
    }

    public static int getD() {
        return D;
    }

    public static void setD(int D) {
        arithmetic.D = D;
    }

    public static int getE() {
        return E;
    }

    public static void setE(int E) {
        arithmetic.E = E;
    }

    public static int getH() {
        return H;
    }

    public static void setH(int H) {
        arithmetic.H = H;
    }

    public static int getL() {
        return L;
    }

    public static void setL(int L) {
        arithmetic.L = L;
    }

    public static int getA() {
        return A;
    }

    public static void setA(int A) {
        arithmetic.A = A;
    }

    public static int getB() {
        return B;
    }

    public static void setB(int B) {
        arithmetic.B = B;
    }
    
    public static void initialize()
    {
        FlagReg = setup.toCharArray();  
        Arrays.fill(memory, 0x0000);
    }

    //Addition without carry
    public static String ADD(int B) {        
        int temp = arithmetic.getA();
        char[] temp1 = arithmetic.getFlagReg();
        String a = hex2bin(temp);
         System.out.println(a);
        String b = hex2bin(B);
         System.out.println(b);
        temp=temp+B;
//    String temp = Integer.toHexString(A);
//   int k = Integer.parseInt(temp,16);
//   System.out.println(k);
            
        if(temp>0xff)
        {
                 temp1[7]='1';     //carry flag set
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp-0xFF-1);
                System.out.println(arithmetic.getFlagReg()); 
        }
        else if(temp==0x00)
        {
                temp1[1]='1';      //zero flag set
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp);
                System.out.println(arithmetic.getFlagReg());   
        }
        else
        {
                arithmetic.setA(temp);
                temp1[7]='0';
                temp1[1]='0';
                arithmetic.setFlagReg(temp1);
        }
        return String.format("%02x",arithmetic.getA());
    }
    
    //Addition with carry
    public static String ADC(int B) {
         int temp = arithmetic.getA();
         char[] temp1 = arithmetic.getFlagReg();
        String a = hex2bin(temp);
         System.out.println(a);
        String b = hex2bin(B);
         System.out.println(b);
        temp=temp+B+Character.getNumericValue(temp1[7]);;
//    String temp = Integer.toHexString(A);                                     //convert int to hex and store in registers;
//   int k = Integer.parseInt(temp,16);
//   System.out.println(k);
            
        if(temp>0xff)
            {       
                temp1[7]='1';      //carry flag set
                arithmetic.setFlagReg(temp1);
                arithmetic.setA(temp-0xFF-1);
            }
        else if(temp==0x00)
            {
                temp1[1]='1';      //zero flag set
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp);
                System.out.println(arithmetic.getFlagReg());    
            }
        else
            {
                arithmetic.setA(temp);
                temp1[7]='0';
                temp1[1]='0';
                arithmetic.setFlagReg(temp1);
            }
        return String.format("%02x",arithmetic.getA());
    }
    
    //Increment
    public static void INR(int value,int c){
        value++;
        char temp1[]=arithmetic.getFlagReg();
         if(value>0xff)
            {   
                temp1[7]='1';
                value = 0;
            }
         else{
             temp1[7]='0';
         }
        switch(c){
        case 1:   arithmetic.setA(value); break;
        case 2:   arithmetic.setB(value); break;
        case 3:   arithmetic.setC(value); break;
        case 4:   arithmetic.setD(value); break;
        case 5:   arithmetic.setE(value); break;
        case 6:   arithmetic.setH(value); break;
        case 7:   arithmetic.setL(value); break;
        case 8:   arithmetic.setL(value); break;  // INR M how to do?????
        default: System.out.println("invalid input"); break;
        }
        
    }
    
    //Decrement
    public static void DCR(int value,int c){
        value--;
        char temp1[]=arithmetic.getFlagReg();
         if(value==0)
            {   
                temp1[7]='0';
                value = 0;
            }
         else{
             temp1[7]=temp1[7];
         }
        switch(c){
        case 1:   arithmetic.setA(value); break;
        case 2:   arithmetic.setB(value); break;
        case 3:   arithmetic.setC(value); break;
        case 4:   arithmetic.setD(value); break;
        case 5:   arithmetic.setE(value); break;
        case 6:   arithmetic.setH(value); break;
        case 7:   arithmetic.setL(value); break;
        case 8:   arithmetic.setL(value); break; // INR M how to do?????
        default: System.out.println("invalid input"); break;
        }
        
    }
    
    //Subtract without carry                     //-------check this out
    public static String SUB(int B) {        
        int temp = arithmetic.getA();
        char[] temp1 = arithmetic.getFlagReg();
        String a = hex2bin(temp);
         System.out.println(a);
        String b = hex2bin(B);
         System.out.println(b);
        temp=temp-B;
//    String temp = Integer.toHexString(A);
//   int k = Integer.parseInt(temp,16);
//   System.out.println(k);
            
        if(temp<0x00)
        {
                 
                 temp1[0]='1';        //sign flag set
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp);
                System.out.println(arithmetic.getFlagReg()); 
        }
        else if(temp==0x00)
        {
                temp1[1]='1';        //zero flag set
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp);
                System.out.println(arithmetic.getFlagReg());   
        }
        else
        {
                arithmetic.setA(temp);
                temp1[0]='0';
                temp1[1]='0';
                arithmetic.setFlagReg(temp1);
        }
        return String.format("%02x",arithmetic.getA());
    }
    
    //Subtract with carry
    public static String SBB(int B) {
         int temp = arithmetic.getA();
         char[] temp1 = arithmetic.getFlagReg();
        String a = hex2bin(temp);
         System.out.println(a);
        String b = hex2bin(B);
         System.out.println(b);
        temp=temp-B-Character.getNumericValue(temp1[7]);;
//    String temp = Integer.toHexString(A);                                     //convert int to hex and store in registers;
//   int k = Integer.parseInt(temp,16);
//   System.out.println(k);
            
        if(temp<0x00)
            {       
                temp1[0]='1';            //sign flag set
                arithmetic.setFlagReg(temp1);
                arithmetic.setA(temp);
            }
        else if(temp==0x00)
            {
                temp1[1]='1';            //zero flag set
                arithmetic.setFlagReg(temp1);
                arithmetic.setA(temp);
            }
        else
            {
                arithmetic.setA(temp);
                temp1[1]='0';
                temp1[0]='0';
                arithmetic.setFlagReg(temp1);
            }
        return String.format("%02x",arithmetic.getA());
    }
////////////////////////////////////////////////////////////////////// //////////////////////////////
                                //DATA TRANSFER//
/////////////////////////////////////////////////////////////////////////////////////////////////////
    //Move immediate instruction                                 //how to differentiate immediate operation ie MVI from MOv
    public static void MVI(int R1, int R2)
    {
        R1 = R2;
    }
    
    //Move instruction                                 //how to differentiate immediate operation ie MVI from MOv
    public static void MOV(int R1, int R2)
    {
        R1 = R2;
    }
    
    //Load Accumulator 
    public static void LDA(int address){ 
        int temp = arithmetic.memory[address];
        arithmetic.setA(temp);
    }
    
    //Store Accumulator content 
    public static void STA(int address){
        int temp = arithmetic.getA();
        arithmetic.memory[address] = temp;
    }
    
    //Load HL register pair
    public static void LHLD(int address){ 
        int temp = arithmetic.memory[address];
        arithmetic.setL(temp);
        temp = arithmetic.memory[address+1];
        arithmetic.setH(temp);
    }
    
    //Store HL register pair
    public static void SHLD(int address){ 
        int temp = arithmetic.getL();
        arithmetic.memory[address] = temp;
        temp = arithmetic.getH();
        arithmetic.memory[address+1] = temp;
    }
    
    //Load register pair
    public static void LXI(char X,int word){ 
        int byte1 = word & 0x00ff;
        int byte2 = word & 0xff00;
        switch(X)
        {
            case 'H':{
                        arithmetic.setH(byte2);
                        arithmetic.setL(byte1);
                        break;
                     }
            case 'B':{
                        arithmetic.setB(byte2);
                        arithmetic.setC(byte1);
                        break;
                     }
            case 'D':{
                        arithmetic.setD(byte2);
                        arithmetic.setE(byte1);
                        break;
                     }
            default: System.out.println("invalid input");
        }

    }
    
    public static void XCHG(){
        int temp1 = arithmetic.getH();
        int temp2 = arithmetic.getL();
        arithmetic.setH(arithmetic.getD());
        arithmetic.setL(arithmetic.getE());
        arithmetic.setD(temp1);
        arithmetic.setE(temp2);
    }
    
    
    
    ///////////////////////////////////////////////////////////////////
    public static String hex2bin(int A)
    {
        String z = Integer.toBinaryString(A);
        int b = Integer.parseInt(z);
        String y = String.format("%08d",b);
        return y;
    }

}
