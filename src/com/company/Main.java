package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Cadet[] cadets = new Cadet[30];
        cadets[0] = Cadet.of(0, "Radenko", "Katia", SpecialityTrend.Analytics);
        cadets[1] = Cadet.of(1, "Milenko", "Masha", SpecialityTrend.ArtyficialIntelligence);
        cadets[2] = Cadet.of(2, "Vaguner", "Sasha", SpecialityTrend.MachineLearning);

        String[] lastNames = new String[]{"Wanderland", "Sirii", "Claus", "Borsh", "Chebuek"};
        String[] names = new String[]{"Alisa", "Volk", "Santa", "Lolita", "Armen"};

        CadetUtil.printAll(cadets);
        System.out.println("______________________");

//        CadetUtil.printInfo(cadets, 32);
//        System.out.println("______________________");
        CadetUtil.delete(cadets, 5);
        CadetUtil.printAll(cadets);

        System.out.println("______________________");




        CadetUtil.insert(cadets, Cadet.of(
                6,
                cadetRandom(lastNames),
                cadetRandom(names),
                randomSpeciality()
        ));
        CadetUtil.printAll(cadets);
    }


    public static String cadetRandom(String[] people){
        String person = people[new Random().nextInt(people.length)];
        return person;
    }

    public static SpecialityTrend randomSpeciality() {
        int speciality = new Random().nextInt(SpecialityTrend.values().length);
        return SpecialityTrend.values()[speciality];
    }

//    public static int indexRandom(Cadet[] cadets) {
//        int counter = 0;
//        for (int i = 0; i < cadets.length; i++) {
//            if(cadets[i] !=null){
//                counter++;
//            }
//        }
//        Random randNumber = new Random();
//        int id = randNumber.nextInt(counter, cadets.length);
//        System.out.println("random index =" + id);
//        return id;
//    }
}
