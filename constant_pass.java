/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * By Abdalnassef :D ♥
 * and open the template in the editor.
 */
package pkg1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AGA
 */

public class constant_pass {
    static ArrayList<Character> x=new ArrayList<>();
    static char Litter[];
    static char Key[][];
    static int n;
    public constant_pass(char L[]) {
        Litter=L;
        n=(int) Math.sqrt(L.length);
        for(int i=0;i<L.length;i++)x.add(L[i]);
        Key=new char[n][n];
    }
    public static ArrayList<Character> s(){
        ArrayList<Character> h = new ArrayList<>();
        h.addAll(x);
        return h;
    }
       static void findPwd(char[] pw, int pos,String c_c,String c_p)  {
            if (pos < 0) {
//        System.out.println(new String(pw));
//                ch
                
//                for(int p=0;p<pw.length;p++)Key[p/n][p%n]=pw[p];
            
//        if(new String(pw).equals("monarc")){
           ArrayList<Character> m=new ArrayList<>();
          int[] n1=new int[Litter.length];
          for(int i=0;i<pw.length;i++){
              for(int y=0;y<Litter.length;y++)
              if(pw[i]==Litter[y]){
                  n1[y]++;
                  if(n1[y]>1)return;
              }
          }
          String u=new String(pw);
          for(int i=0;i<Litter.length;i++)if(n1[i]==0)u+=Litter[i];
//            if(new String(pw).equals("monarc")){System.out.println("\n"+"monarc");System.exit(-1);}
          
         /*  m.addAll(x);
            
            for(int i=0;i<u.length();i++){
             try{   
                 m.remove(m.indexOf(u.charAt(i)));
             }catch(Exception e){return;}
            }
            
            
//            System.out.println(new String(pw));
            for(;m.size()>0;){
            u=u+m.get(0);
            m.remove(0);
            }*/
//            System.out.println(u);
            char[] AlphaChar=u.toCharArray();
            for(int p=0;p<AlphaChar.length;p++){
                Key[p/n][p%n]=AlphaChar[p];
            }
            
                 if(use_key(c_c, c_p, Key)){
            System.out.println("Founded");System.exit(-1);
        }
//        }
        return;
    }
    for (int index=0 ; index < Litter.length ; index++){
        pw[pos] = Litter[index];
        findPwd(pw, pos-1,c_c,c_p);
    }
           
}
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter chars of alpha want to work with " );
        String Alpha = "";
        char AlphaChar[];
//            Alpha=in.nextLine();
            Alpha="abcdefghijklmnopqrstuvwxyz";
            AlphaChar=Alpha.toCharArray();
            int n=(int) Math.sqrt(Alpha.length());
            System.out.println(n+"  "+Alpha.length());
            int number_eq=Alpha.length()-n*n;
            char[][] eq = new char[number_eq][2]; 
            for(int b=0;b<number_eq;b++){
                System.out.println("the "+(b+1)+" write 2 char are equal");
                eq[b][0]=in.nextLine().charAt(0);
//                eq[b][0]='i';
                eq[b][1]=in.nextLine().charAt(0);
//                eq[b][1]='j';
                
                if(eq[b][0]==eq[b][1]){System.out.println("Error you Insert same char if want to remove remove from inserting chars");System.exit(-1);}
            }
            
            char[][] insert_char=new char[n][n];
            String m=Alpha;
            for(int i=0;i<eq.length;i++)
            m=m.replaceAll(""+eq[i][1], "");
            
//            System.out.println(m);
            
            
            AlphaChar=m.toCharArray();
            System.out.println("Alpha is : "+m);
        new constant_pass(AlphaChar);
        
       
        
        System.out.print("Enter Cipher : ");String cipher=in.nextLine();
        System.out.print("Enter Plain : ");String plain=in.nextLine();
//        String cipher="pleasetransferonemilliondollar";
//        String plain="ugketduaraudfanacakggknabnizkrnz";
        for(int i=0;i<eq.length;i++)
            cipher=cipher.replaceAll(""+eq[i][1], ""+eq[i][0]);
            
        String cutten_cipher=cutten(cipher, plain)[0];
        String cutten_plain=cutten(cipher, plain)[1];
        
        System.out.print("\n  New Cipher : "+cutten_cipher);
        System.out.print("\n  New Plain  : "+cutten_plain);
        
         System.out.print("\nEnter Length of key : " );
        int Length;
        try{
            Length=Integer.parseInt(in.nextLine());
        }catch(Exception e){
            System.out.println("Not Number so defalut length = 26");Length=25;}
        
        
        char[] pw ;
        int x=Length;
//        int x=6;
        pw=new char[x];
                findPwd(pw, x-1,cutten_cipher,cutten_plain);
 
        
    }
    public static String[] cutten(String Cipher,String Plain){
        String result[]=new String[2];
        Scanner in =new Scanner(System.in);
        String newCipher="";
        
        String newPlain="";
        
        int cipher_n=Cipher.length();
        for(int i=0;i<cipher_n;i+=2){
        if(i+1==cipher_n)newCipher+=""+Cipher.charAt(i)+'x';
        else if(Cipher.charAt(i)!=Cipher.charAt(i+1))
            newCipher+=""+Cipher.charAt(i)+Cipher.charAt(i+1)+"";
        else {newCipher+=""+Cipher.charAt(i)+'x'+"";i--;}
        }
//        System.out.println(newCipher);
        
        int plain_n=Plain.length();
        if(plain_n%2==1)System.exit(-1);
        for(int i=0;i<plain_n;i+=2){
        if(Plain.charAt(i)==Plain.charAt(i+1))System.exit(-1);
            newPlain+=""+Plain.charAt(i)+Plain.charAt(i+1)+"";
        }
        result[0]=newCipher;
        result[1]=newPlain;
//        System.out.println(newPlain);
        return result;
    }
    
    
    public static boolean use_key(String cipher,String plain,char[][] key){
        String newCipher="";
        String newPlain="";
        
        int cipher_n=cipher.length();
        for(int i=0;i<cipher_n;i+=2){
        if(i+1==cipher_n)newCipher+=""+cipher.charAt(i)+'x';
        else if(cipher.charAt(i)!=cipher.charAt(i+1))
            newCipher+=""+cipher.charAt(i)+cipher.charAt(i+1)+"";
        else {newCipher+=""+cipher.charAt(i)+'x'+"";i--;}
        }
        String HPlain="";
        int index1[]=new int[2];
        int index2[]=new int[2];
        
        for(int i=0;i<newCipher.length();i+=2){
            for(int y=0;y<key.length;y++){
                for(int y2=0;y2<key[y].length;y2++){
                    if(newCipher.charAt(i)==key[y][y2]){
                        index1[0]=y;
                        index1[1]=y2;
                    }
                    if(newCipher.charAt(i+1)==key[y][y2]){
                        index2[0]=y;
                        index2[1]=y2;
                    }
                }
            }
            if(index1[0]==index2[0]){
                HPlain+=""+key[index1[0]][(index1[1]+1)%key.length];
                HPlain+=""+key[index2[0]][(index2[1]+1)%key.length];
            }if(index1[1]==index2[1]){
                HPlain+=""+key[(index1[0]+1)%key[0].length][index1[1]];
                HPlain+=""+key[(index2[0]+1)%key[0].length][index2[1]];
            }
            if(index1[0]!=index2[0]&&index1[1]!=index2[1]){
                HPlain+=""+key[index1[0]][index2[1]];
                HPlain+=""+key[index2[0]][index1[1]];
            }
        }
        if(plain.equals(HPlain)){
            System.out.println("");
            for(int i=0;i<key.length;i++){for(int o=0;o<key[i].length;o++)System.out.print(key[i][o]+ " ");System.out.println("");}
            return true;}
        return false;
    }
    
}

