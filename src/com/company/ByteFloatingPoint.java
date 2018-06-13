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
dla unsigned 3b+5b: max 7,96875, dokladnosc 0,03125
dla unsigned 4b+4b: max 15,9375, dokladnosc 0,0625
dla unsigned 5b+3b: max 31,875, dokladnosc 0,125
dla unsigned 6b+2b: max 63,75, dokladnosc 0,25
dla unsigned 7b+1b: max 127,5, dokladnosc 0,5

dla signed 3b+5b: max 7,96875, dokladnosc 0,03125
dla signed 4b+4b: max 7,9375, dokladnosc 0,0625
dla signed 5b+3b: max 15,875, dokladnosc 0,125
dla signed 6b+2b: max 31,75, dokladnosc 0,25
dla signed 7b+1b: max 63,5, dokladnosc 0,5

 */


public class ByteFloatingPoint {
    /*
W klasie na razie obslugujemy tylko format unsigned 4/4
 */
    static final byte integralPartSize=4;
    static final byte fractionalPartSize=4;
    static final byte DECIMAL_SYSTEM_BASE=10;
    static final float MAX_BYTE_FLOATING_POINT_VALUE=(float)15.9375;
    static final float MIN_BYTE_FLOATING_POINT_VALUE=0;
    private byte byteFloatingPointVariable;

    private byte ByteFloatingPoint(Float floatValue){
        // return 0 if success
        // return 1 if Out of Range Exception
        //
        //obetnij decValue zeby miejscila sie w zakresie ByteFPValue
        //konwertuj dec na ByteFP
        // przypisz do pola

        // check if value in ByteFP range
        if((floatValue>MAX_BYTE_FLOATING_POINT_VALUE) || (floatValue<MIN_BYTE_FLOATING_POINT_VALUE)) return 1;

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
        return 0;
        //glue two bytes values into one - final result
    }


    private void assignNewValue(){

    }



    // cala arytmetyka jeszcze :)

    // w C++ jeszcze .destroyVar()
}
