package entities;

import java.time.Duration;
import java.util.ArrayList;


public class Student {

    private int code;
    private String name;
    private String lastName;
    private String email;
    private Duration workedHours = Duration.ZERO;

    public Student(String name, Duration workedHours) {
        this.name = name;
        this.workedHours = workedHours;
    }


    public String getName() {
        return name;
    }


    public Duration getWorkedHours() {
        return workedHours;
    }
}