package com.company;

public class Cadet {
    int id;
    String name;
    String lastName;
    SpecialityTrend speciality;

    public static Cadet of(int id, String name, String lastName, SpecialityTrend speciality){
        Cadet cadet = new Cadet();
        cadet.id = id;
        cadet.name = name;
        cadet.lastName = lastName;
        cadet.speciality = speciality;

        return cadet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SpecialityTrend getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityTrend speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Cadet: " +
                "  id=" + id +
                "  name=" + name  +
                "  lastName=" + lastName  +
                "  speciality=" + speciality;
    }
}
