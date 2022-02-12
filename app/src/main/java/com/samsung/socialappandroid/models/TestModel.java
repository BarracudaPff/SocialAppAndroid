package com.samsung.socialappandroid.models;

import java.util.ArrayList;
import java.util.Arrays;

public class TestModel {
    public String string;
    public String stringWithQuote;
    public int number;
    public boolean booleanValue;
    public ArrayList<String> nicknames;
    public TestInnerObject object;

    public TestModel() {
        //do not remove
    }

    public TestModel(String string, String stringWithQuote, int number, boolean booleanValue, ArrayList<String> nicknames, TestInnerObject object) {
        this.string = string;
        this.stringWithQuote = stringWithQuote;
        this.number = number;
        this.booleanValue = booleanValue;
        this.nicknames = nicknames;
        this.object = object;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "string='" + string + '\'' +
                ", stringWithQuote='" + stringWithQuote + '\'' +
                ", number=" + number +
                ", booleanValue=" + booleanValue +
                ", nicknames=" + nicknames.toString() +
                ", object=" + object +
                '}';
    }

    public static class TestInnerObject {
        public TestAnotherInnerObject another;

        public TestInnerObject() {
            //do not remove
        }

        public TestInnerObject(TestAnotherInnerObject another) {
            this.another = another;
        }

        @Override
        public String toString() {
            return "TestInnerObject{" +
                    "another=" + another +
                    '}';
        }
    }

    public static class TestAnotherInnerObject {
        public String name;
        public int age;
        public String gender;

        public TestAnotherInnerObject() {
            //do not remove
        }

        public TestAnotherInnerObject(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "TestAnotherInnerObject{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
