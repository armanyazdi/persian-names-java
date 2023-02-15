package armanyazdi;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PersianNames name = new PersianNames();

        // Generate Persian names in Farsi:
        System.out.println(name.fullNameFa("male"));
        System.out.println(name.fullNameFa("female"));
        System.out.println(name.fullNameFa("random"));

        // Generate Persian names in English:
        System.out.println(name.fullNameEn("m"));
        System.out.println(name.fullNameEn("f"));
        System.out.println(name.fullNameEn("r"));
    }
}