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
public class stack extends Initialization{
    
    int n,top;
    
    public stack() {
        n = 0x1000;
        top = 0xffff;
    }
    
    public boolean isEmpty(){
        if(top > 0xffff) System.out.println("SP not pointing to stack");
        if(top == 0xffff) return true;
        else return false;
    }
    
    public void push(int data){
        if(top < 0xefff) System.out.println("SP not pointing to stack");
        if(top == 0xefff){
            System.out.println("stack is full");
        }else{
            top--;
            memory[top] = data; 
        }
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }else{
            int data = memory[top];
            top++;
            return data;
        }
    }
    
    public int getTopIndex(){
        return top;
    }
    
    public void setTopIndex(int top){
        this.top = top;
    }
    
    public int getTop(){
        return memory[top];
    }
    
    public void setTop(int data){
        memory[top] = data;
    }
}

