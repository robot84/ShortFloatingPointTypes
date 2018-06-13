package com.company;
/*
dostep:     dostepnosc
private     z klasy
(default)   +z pakietu
protected   +child classes
public      anywhere
 */

/*
Zakres i dokladnosc ByteFloatingPoint Value to:
(pierwsza liczba to ilosc bitow na czesc calkowita, a druga na czesc ulamkowa)


dla signed 3b+5b: max 7,96875, dokladnosc 0,03125
dla signed 4b+4b: max 7,9375, dokladnosc 0,0625
dla signed 5b+3b: max 15,875, dokladnosc 0,125
dla signed 6b+2b: max 31,75, dokladnosc 0,25
dla signed 7b+1b: max 63,5, dokladnosc 0,5
(Java traktuje wsio jako signed)
 */


public class ByteFloatingPoint {
    /*
W klasie na razie obslugujemy tylko format unsigned 4/4
 */
    static final byte integralPartSize=4;
    static final byte fractionalPartSize=4;
    static final byte DECIMAL_SYSTEM_BASE=10;
    static final float MAX_BYTE_FLOATING_POINT_VALUE=(float)7.9375;
    static final float MIN_BYTE_FLOATING_POINT_VALUE=0;
    private byte byteFloatingPointVariable;

    ByteFloatingPoint(){

    }

    ByteFloatingPoint(Float floatValue){
        // return 0 if success
        // return 1 if Out of Range Exception
        //
        //obetnij decValue zeby miejscila sie w zakresie ByteFPValue
        //konwertuj dec na ByteFP
        // przypisz do pola

        // check if value in ByteFP range
        if((floatValue>MAX_BYTE_FLOATING_POINT_VALUE) || (floatValue<MIN_BYTE_FLOATING_POINT_VALUE)) System.out.println("Exception: Value Out of Range");

        System.out.println("Input value: "+floatValue);
        //split integral and fractional parts. temporary fractional part in int type
        int integralPart=floatValue.intValue();
        //int fractionalPart= (int) ((floatValue-integralPart)*Math.pow(DECIMAL_SYSTEM_BASE,(double)fractionalPartSize));
        float fractionalPart=floatValue-(float)integralPart;
        //convert it to 2 bytes values (one for integral, and one for fractional part)
        // compute integral part
        byte integralBytePart=(byte)integralPart;
        // compute fractional part
        byte fractionalBytePart=0;
        Float wynik = fractionalPart;
        for(int i=fractionalPartSize-1;i>=0;i--) {
            wynik = wynik* 2;
            if ((wynik) >= 1) {
                fractionalBytePart=(byte)(fractionalBytePart+(byte)Math.pow(2,i));
                wynik-=1;
            }
        }

        /*
         co ciekawe to:
         (byte)(integralBytePart | fractionalBytePart)
         i to:
         (byte)(integralBytePart + fractionalBytePart)
         da nam ten sam rezultat :))
         */
        System.out.println("integral part BIN: "+Integer.toBinaryString(integralBytePart<<fractionalPartSize));
        System.out.println("fraction part BIN: "+Integer.toBinaryString(fractionalBytePart));
        //glue two bytes values into one - final result
          byteFloatingPointVariable= (byte)(integralBytePart<<fractionalPartSize | fractionalBytePart);
        //System.out.println("BIN: "+Integer.toBinaryString(byteFloatingPointVariable));
    }


    private void assignNewValue(){

    }

    byte readValue(){
          return byteFloatingPointVariable;
    }

    void printValue(){
        System.out.print("BIN: "+Integer.toBinaryString(byteFloatingPointVariable>>fractionalPartSize));
        System.out.print(".");
        if ((byteFloatingPointVariable&15)>7)
            System.out.println(""+Integer.toBinaryString(byteFloatingPointVariable&15));
        else if ((byteFloatingPointVariable&15)>3)
            System.out.println("0"+Integer.toBinaryString(byteFloatingPointVariable&15));
        else if ((byteFloatingPointVariable&15)>1)
            System.out.println("00"+Integer.toBinaryString(byteFloatingPointVariable&15));
        else if ((byteFloatingPointVariable&15)>0)
            System.out.println("000"+Integer.toBinaryString(byteFloatingPointVariable&15));
        else
            System.out.println("0000"+Integer.toBinaryString(byteFloatingPointVariable&15));
    }



    // cala arytmetyka jeszcze :)

    // w C++ jeszcze .destroyVar()
}
