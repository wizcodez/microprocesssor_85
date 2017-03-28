/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sairaj Hemachandran & Nishka Gulati
 */
public class stack {
    int a[];
    int n,top;
    
    public stack(int[] a) {
        this.a = a;
        n = a.length;
        top = n-1;
    }
    
    public boolean isEmpty(){
        if(top == n-1) return true;
        else return false;
    }
    
    public void push(int data){
        
        if(top == 0){
            System.out.println("stack is full");
        }else{
            top--;
            a[top] = data; 
        }
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }else{
            int data = a[top];
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
}

