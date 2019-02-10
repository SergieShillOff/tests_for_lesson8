package com.example.rumpilstilstkin.lesson4;


public class MegaClassForTest {

    public int someWithNumber(String token){
        if(token == null){
            return -1;
        }else {
            return token.indexOf("o");
        }
    }

    public String someWithString(int number){
        String t = "";
        for(int i = 0; i < number; i++ ){
            t += "o";
        }
        return t;
    }

    public void somwFunk(int k){
        switch(k){
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
        }
    }
}
