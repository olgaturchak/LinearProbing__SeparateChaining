package com.company;

import java.util.NoSuchElementException;

public class CadetUtil {

    public static void insert(Cadet[] cadets, Cadet cadet){
        cadets[cadet.getId()] = cadet;
    }

    public static Cadet search(Cadet[] cadets, int id){
        return cadets[id];
    }

    public static void delete(Cadet[] cadets, int id){
        try{
            if(cadets[id] != null){
                cadets[id] = null;
            }
            else if(cadets[id] == null){
                System.out.println("Is already empty");
            }
        }
        catch (Exception e){
            throw new NoSuchElementException(e);
        }

    }

    public static void printAll(Cadet[] cadets){
        for(Cadet cadet : cadets){
            System.out.println(cadet);
        }
    }


    public static void printInfo(Cadet[]cadets, int id){
        try {
            if (cadets[id] != null) {
                System.out.println(cadets[id]);
            }
            else {
                System.out.println("It`s empty now");;
            }
        }catch (Exception e) {
            throw new NoSuchElementException(e);
        }


    }


}
