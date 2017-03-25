
import java.util.Arrays;

/**
 *
 * @author Sairaj
 */
class arithmetic {
    public static String setup = "00000000";
    public static int A,B,C,D,E,H,L;
     public static char[] FlagReg = setup.toCharArray();  

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
                 
                 temp1[7]='1';
                 arithmetic.setFlagReg(temp1);
                 arithmetic.setA(temp-0xFF-1);
                System.out.println(arithmetic.getFlagReg()); 
        }
        else if(temp==0x00)
        {
            System.out.println("zero flag set");
                 arithmetic.setA(temp);   
        }
        else
        {
                arithmetic.setA(temp);
                temp1[7]='0';
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
                temp1[7]='1';
                arithmetic.setFlagReg(temp1);
                arithmetic.setA(temp-0xFF-1);
            }
        else if(temp==0x00)
            {
                System.out.println("zero flag set");
                arithmetic.setA(temp);   
            }
        else
            {
                arithmetic.setA(temp);
                temp1[7]='0';
                arithmetic.setFlagReg(temp1);
            }
        return String.format("%02x",arithmetic.getA());
    }
    
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
        case 1:   arithmetic.setA(value);
        case 2:   arithmetic.setB(value);
        case 3:   arithmetic.setC(value);
        case 4:   arithmetic.setD(value);
        case 5:   arithmetic.setE(value);
        case 6:   arithmetic.setH(value);
        case 7:   arithmetic.setL(value);
        case 8:   arithmetic.setL(value);  // INR M how to do?????
        default: System.out.println("invalid input"); break;
        }
        
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
