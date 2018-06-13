package com.company;
/*
Ale ujnia! Java operatory arytmetyczne umie stosowac tylko dla int/double.
Jak masz byte + byte to spadaj na drzewo

Przyklad:
byte d=2,e=2,f=2;
        f=d+e; // WRONG
        f=((byte)(d+e));  // OK

 */
public class Main {

    public static void main(String[] args) {
	// write your code here
ByteFloatingPoint b=new ByteFloatingPoint((float)7.18534);
int i=7;
System.out.println();
b.printValue();
//System.out.println("BIN: "+Integer.toBinaryString(b.readValue()));
    }
}
