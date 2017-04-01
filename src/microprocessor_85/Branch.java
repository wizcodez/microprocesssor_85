/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microprocessor_85;

/**
 *
 * @author Sairaj
 */
public class Branch extends Initialization{
    
    //Unconditional Jump 
    public static void JMP(int lowerByte, int higherByte){
        int address = arithmetic.generateAddress(lowerByte, higherByte);
        PC = address;
    }
    
    //Jump on Carry
    public static void JC(int lowerByte, int higherByte){
        if(FlagReg[7] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on no Carry
    public static void JNC(int lowerByte, int higherByte){
        if(FlagReg[7] == '0'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on positive
    public static void JP(int lowerByte, int higherByte){
        if(FlagReg[0] == '0'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on minus
    public static void JM(int lowerByte, int higherByte){
        if(FlagReg[0] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on zero
    public static void JZ(int lowerByte, int higherByte){
        if(FlagReg[1] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on no zero
    public static void JNZ(int lowerByte, int higherByte){
        if(FlagReg[1] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on parity even
    public static void JPE(int lowerByte, int higherByte){
        if(FlagReg[5] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Jump on parity odd
    public static void JPO(int lowerByte, int higherByte){
        if(FlagReg[5] == '1'){
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Unconditional subroutine call
    public static void CALL(int lowerByte, int higherByte){
        st.push(getLowerByte(PC));
        st.push(getHigherByte(PC));
        int address = arithmetic.generateAddress(lowerByte, higherByte);
        PC = address;
    }
    
    //Call on Carry
    public static void CC(int lowerByte, int higherByte){
        if(FlagReg[7] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on no Carry
    public static void CNC(int lowerByte, int higherByte){
        if(FlagReg[7] == '0'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on positive
    public static void CP(int lowerByte, int higherByte){
        if(FlagReg[0] == '0'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on minus
    public static void CM(int lowerByte, int higherByte){
        if(FlagReg[0] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on zero
    public static void CZ(int lowerByte, int higherByte){
        if(FlagReg[1] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on no zero
    public static void CNZ(int lowerByte, int higherByte){
        if(FlagReg[1] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on parity even
    public static void CPE(int lowerByte, int higherByte){
        if(FlagReg[5] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Call on parity odd
    public static void CPO(int lowerByte, int higherByte){
        if(FlagReg[5] == '1'){
            st.push(getLowerByte(PC));
            st.push(getHigherByte(PC));
            int address = arithmetic.generateAddress(lowerByte, higherByte);
            PC = address;
        }
    }
    
    //Return from subroutine unconditionally
    public static void RET(){
        int higherByte = st.pop();
        int lowerByte = st.pop();
        PC = generateAddress(lowerByte, higherByte);
    }
    
     //Return on Carry
    public static void RC(){
        if(FlagReg[7] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on no Carry
    public static void RNC(){
        if(FlagReg[7] == '0'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on positive
    public static void RP(){
        if(FlagReg[0] == '0'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on minus
    public static void RM(){
        if(FlagReg[0] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on zero
    public static void RZ(){
        if(FlagReg[1] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on no zero
    public static void RNZ(){
        if(FlagReg[1] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on parity even
    public static void RPE(){
        if(FlagReg[5] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Return on parity odd
    public static void RPO(){
        if(FlagReg[5] == '1'){
            int higherByte = st.pop();
            int lowerByte = st.pop();
            PC = generateAddress(lowerByte, higherByte);
        }
    }
    
    //Load program counter with HL contents
    public static void PCHL(){
        int address = arithmetic.generateAddress(getL(), getH());
        PC = address;
    }
    
    //Load SP with HL contents
    public static void SPHL(){
        int address = arithmetic.generateAddress(getL(), getH());
        setSP(address);
    }
    
    //exchange top of stack with HL contents
    public static void XTHL(){
        System.out.println(""+decToHex(getMemory(getSP())));
        int temp1 = getMemory(getSP());
        int temp2 = getMemory(getSP()+1);
        setMemory(getSP(), getL());
        setMemory(getSP()+1, getH());
        setL(temp1);
        setH(temp2);
    }
    
    //Restart
    public static void RST0(){
        CALL(0x00, 0x00);
    }
    
    public static void RST1(){
        CALL(0x08, 0x00);
    }
    
    public static void RST2(){
       CALL(0x10, 0x00);
    }
    
    public static void RST3(){
        CALL(0x18, 0x10);
    }
    
    public static void RST4(){
        CALL(0x20, 0x00);   
    }
    
    public static void RST5(){
        CALL(0x28, 0x00);
    }
    
    public static void RST6(){
        CALL(0x30, 0x00);
    }
    
    public static void RST7(){
        CALL(0x38, 0x00);
    }
    
    //Additional Interrupts
    public static void TRAP(){
        CALL(0x24, 0x00);
    }
    
    public static void RST5_5(){
        CALL(0x2C, 0x00);
    }
    
    public static void RST6_5(){
        CALL(0x34, 0x00);
    }
    
    public static void RST7_5(){
        CALL(0x3C, 0x00);
    }

}
