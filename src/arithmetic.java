

/*
* @author Sairaj Hemachandran & Nishka Gulati
*/
//DAA is to be done...

class arithmetic extends Initialization {
   
    //Addition without carry
    public static void ADD(char register){
        
        switch(register){
            case 'A': ADI(A); break;
            case 'B': ADI(B); break;
            case 'C': ADI(C); break;
            case 'D': ADI(D); break;
            case 'E': ADI(E); break;
            case 'H': ADI(H); break;
            case 'L': ADI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    ADI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
    }
    
    //Addition with carry
    public static void ADC(char register){
        
        switch(register){
            case 'A': ACI(A); break;
            case 'B': ACI(B); break;
            case 'C': ACI(C); break;
            case 'D': ACI(D); break;
            case 'E': ACI(E); break;
            case 'H': ACI(H); break;
            case 'L': ACI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    ACI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
    }
    
    //Addition of immediate data without carry
    public static void ADI(int B) {        
        
        char[] temp1 = getFlagReg();
        
        A=A+B;
        int temp_x = A & 0x0f;
        int temp_y = B & 0x0f;
        if(temp_x+temp_y>0x0f)
        {
            temp1[3]='1';
        }else temp1[3]='0';
        if(A>0xff)
        {
                temp1[7]='1';     //carry flag set
                setA(A-0xFF-1);
        }else temp1[7]='0';
        
        if(A==0x00) temp1[1]='1';      //zero flag set  
        else temp1[1]='0';
        
        
        setFlagReg(temp1);
    }
    
    //Addition immediate data with carry
    public static void ACI(int B) {
        char[] temp1 = getFlagReg();
        
        A=A+B+Character.getNumericValue(temp1[7]);
        int temp_x = A & 0x0f;
        int temp_y = (B+Character.getNumericValue(temp1[7])) & 0x0f;
        if(temp_x+temp_y>0x0f)
        {
            temp1[3]='1';
        }else temp1[3]='0';
        if(A>0xff)
        {
                temp1[7]='1';     //carry flag set
                setA(A-0xFF-1);
        }else temp1[7]='0';
        
        if(A==0x00) temp1[1]='1';      //zero flag set  
        else temp1[1]='0';
        
        setFlagReg(temp1);
        
    }
    
    //Subtraction without borrow
    public static void SUB(char register){
        
        switch(register){
            case 'A': SUI(A); break;
            case 'B': SUI(B); break;
            case 'C': SUI(C); break;
            case 'D': SUI(D); break;
            case 'E': SUI(E); break;
            case 'H': SUI(H); break;
            case 'L': SUI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    SUI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
    }
    
    //Subtraction with borrow
    public static void SBB(char register){
        switch(register){
            case 'A': SBI(A); break;
            case 'B': SBI(B); break;
            case 'C': SBI(C); break;
            case 'D': SBI(D); break;
            case 'E': SBI(E); break;
            case 'H': SBI(H); break;
            case 'L': SBI(L); break;
            case 'M': 
                {
                    int address = generateAddress(L, H);
                    SBI(memory[address]);
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
    }
    
      //Subtraction of immediate data without borrow 
    public static void SUI(int B) {        
        int temp = getA();
        char[] temp1 = getFlagReg();
        
        temp=temp-B;
   
        if(temp<0x00)
        {
                 
                temp1[0]='1';        //sign flag set
                setFlagReg(temp1);
                setA(temp);
                System.out.println(getFlagReg()); 
        }
        else if(temp==0x00)
        {
                temp1[1]='1';        //zero flag set
                setFlagReg(temp1);
                setA(temp);
                System.out.println(getFlagReg());   
        }
        else
        {
                setA(temp);
                temp1[0]='0';
                temp1[1]='0';
                setFlagReg(temp1);
        }
        
    }
    
    //Subtract of immediate data with borrow
    public static void SBI(int B) {
         int temp = getA();
         char[] temp1 = getFlagReg();
        
        temp=temp-B-Character.getNumericValue(temp1[7]);;

            
        if(temp<0x00)
            {       
                temp1[0]='1';            //sign flag set
                setFlagReg(temp1);
                setA(temp);
            }
        else if(temp==0x00)
            {
                temp1[1]='1';            //zero flag set
                setFlagReg(temp1);
                setA(temp);
            }
        else
            {
                setA(temp);
                temp1[1]='0';
                temp1[0]='0';
                setFlagReg(temp1);
            }
        
    }
    
     //Increment
    public static void INR(char register){
        int value=0;
        int address = generateAddress(L, H);
        switch(register){
            case 'A': value=A; break;
            case 'B': value=B; break;
            case 'C': value=C; break;
            case 'D': value=D; break;
            case 'E': value=E; break;
            case 'H': value=H; break;
            case 'L': value=L; break;
            case 'M': 
                {
                    value = memory[address];
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        value++;
        char temp1[]=getFlagReg();
         if(value>0xff)
            {   
                temp1[7]='1';
                value = 0;
            }
         else{
             temp1[7]='0';
         }
        switch(register){
        case 'A':   setA(value); break;
        case 'B':   setB(value); break;
        case 'C':   setC(value); break;
        case 'D':   setD(value); break;
        case 'E':   setE(value); break;
        case 'H':   setH(value); break;
        case 'L':   setL(value); break;
        case 'M':   memory[address] = value; break;
        default: System.out.println("invalid input"); break;
        }
        
    }
    
    //Decrement
    public static void DCR(char register){
        int value=0;
        int address = generateAddress(L, H);
        switch(register){
            case 'A': value=A; break;
            case 'B': value=B; break;
            case 'C': value=C; break;
            case 'D': value=D; break;
            case 'E': value=E; break;
            case 'H': value=H; break;
            case 'L': value=L; break;
            case 'M': 
                {
                    value = memory[address];
                    break;
                }
            default: System.out.println("invalid input"); break;
        }
        value--;
        char temp1[]=getFlagReg();
         if(value==0)
            {   
                temp1[7]='0';
                value = 0;
            }
         else{
             temp1[7]=temp1[7];
         }
        switch(register){
        case 'A':   setA(value); break;
        case 'B':   setB(value); break;
        case 'C':   setC(value); break;
        case 'D':   setD(value); break;
        case 'E':   setE(value); break;
        case 'H':   setH(value); break;
        case 'L':   setL(value); break;
        case 'M':   memory[address] = value; break;
        default: System.out.println("invalid input"); break;
        }
        
    }
    
    //Increment register pair
    public static void INX(char X){
        char[] temp1 = getFlagReg();
        switch(X)
        {
            case 'H':{
                        L++;
                        if(L>0xff){
                            setL(L - 0xff - 1);
                            H++;
                        }
                        if(H>0xff){
                            temp1[7] = '1';
                            setH(H - 0xff - 1);                            
                        }else temp1[7] = '0';
                        
                        if(H == 0x00 && L == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            case 'B':{
                        C++;
                        if(L>0xff){
                            setC(C - 0xff - 1);
                            B++;
                        }
                        if(B>0xff){
                            temp1[7] = '1';
                            setB(B - 0xff - 1);                            
                        }else temp1[7] = '0';
                        
                        if(B == 0x00 && C == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            case 'D':{
                        E++;
                        if(E>0xff){
                            setE(E - 0xff - 1);
                            E++;
                        }
                        if(D>0xff){
                            temp1[7] = '1';
                            setD(D - 0xff - 1);                            
                        }else temp1[7] = '0';
                        
                        if(D == 0x00 && E == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            default: System.out.println("invalid input");
        }
    }
    
    //Decrement register pair
    public static void DCX(char X){
        char[] temp1 = getFlagReg();
        switch(X)
        {
            case 'H':{
                        L--;
                        if(L==0x00){
                            setL(0xff);
                            H--;
                        }
                        if(H == 0x00 && L == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            case 'B':{
                        C--;
                        if(C==0x00){
                            setL(0xff);
                            B--;
                        }
                        if(B == 0x00 && C == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            case 'D':{
                        E--;
                        if(E==0x00){
                            setL(0xff);
                            D--;
                        }
                        if(D == 0x00 && E == 0x00)temp1[1] = '1';
                        else temp1[1] = '0';
                        
                        setFlagReg(temp1);
                        break;
                     }
            default: System.out.println("invalid input");
        }
    }
   
    //Add register pair to HL
    public static void DAD(char X) {
        char[] temp1 = getFlagReg();
        switch(X)
        {
            case 'B':{
                        L = L + C;
                        H = H + B;
                        if(L>0xff)
                        {
                            H++;
                        }
                        if(H>0xff)
                        {
                            temp1[7]='1';
                        }
                        else temp1[7]='0';
                        
                        if(L==0x00 && H==0x00){
                            temp1[1]='1';
                        }
                        else temp1[1]='0';
                        break;
                     }
            case 'D':{
                        L = L + E;
                        H = H + D;
                        if(L>0xff)
                        {
                            H++;
                        }
                        if(H>0xff)
                        {
                            temp1[7]='1';
                        }
                        else temp1[7]='0';
                        
                        if(L==0x00 && H==0x00){
                            temp1[1]='1';
                        }
                        else temp1[1]='0';
                        break;
                     }
            default: System.out.println("invalid input");break;
            
        }
        
    }
    
}
