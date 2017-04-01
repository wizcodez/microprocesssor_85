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
public class Initialization {
    protected static String setup = "00000000";
    protected static int A,B,C,D,E,H,L,PC,SP;
    protected static int memory[] = new int[0x10000];
    public static char[] FlagReg;
     
    static stack st;
    public static void initialize(){
        FlagReg = setup.toCharArray();  
        Arrays.fill(memory, 0x0000);
        st = new stack();
        SP = 0xffff;
    }
    
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

    public static String hex2bin(int A){
        String z = Integer.toBinaryString(A);
        int b = Integer.parseInt(z);
        String y = String.format("%08d",b);
        return y;
    }
     
    public static String decToHex(int dec){
        return String.format("%02x",dec);
    }
    
    public static void setMemory(int address, int data){
        memory[address] = data;
    }
    
    public static int getMemory(int address){
        return memory[address];
    }
    
    public static int generateAddress(int lowerByte, int higherByte){
        int no =0x0100;
        higherByte = higherByte * no;
        no = higherByte + lowerByte;
        return no;
    }
    
    
 public static int getPC() {
        return PC;
    }

    public static void setPC(int PC) {
        Initialization.PC = PC;
    }

public static void incrementPC(){
        PC++;
        if(PC > 0xffff){
            PC = PC - 0xffff-1;
        }
    }

    public static int getSP() {
        SP = st.getTopIndex();
        return SP;
    }

    public static void setSP(int SP) {
        Initialization.SP = SP;
        st.setTopIndex(SP);
    }
    
    public static int getLowerByte(int address){
        return (address & 0x00ff);
    }
    
    public static int getHigherByte(int address){
        return ((address & 0xff00)/0x0100);
    
}
}
