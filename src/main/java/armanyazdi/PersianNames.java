package armanyazdi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersianNames {
    private byte sex;
    private final String[] files = {"male_en.txt", "female_en.txt", "male_fa.txt", "female_fa.txt"};
    private final ArrayList<String> firstNamesEn = new ArrayList<>();
    private final ArrayList<String> lastNamesEn = new ArrayList<>();
    private final ArrayList<String> firstNamesFa = new ArrayList<>();
    private final ArrayList<String> lastNamesFa = new ArrayList<>();
    private String[] someSuffixes, moreSuffixes, chooseBetween;

    private void setGender(String sex) {
        switch (sex.toLowerCase()) {
            case "male", "m" -> this.sex = 0;
            case "female", "f" -> this.sex = 1;
            case "random", "r", default -> this.sex = (byte) Math.round(Math.random());
        }
    }

    public String firstNameEn(String sex) throws FileNotFoundException {
        setGender(sex);
        File file = new File("src/main/resources/files/" + files[this.sex]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            firstNamesEn.add((Arrays.toString(data.split("\n"))));
        }

        reader.close();
        return firstNamesEn.get((int) (Math.random() * firstNamesEn.size())).replace("[", "").replace("]", "");
    }

    public String firstNameEn() throws FileNotFoundException {
        return firstNameEn("random");
    }

    public String lastNameEn() throws FileNotFoundException {
        // English Suffixes
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "",
                "pour",
                "zadeh",
                "far",
                "fard",
                "an",
                "kia",
                "rad",
                "zand",
                "khah",
                "nia",
                "mehr"
        };
        moreSuffixes = new String[]{
                "i", "i", "i", "i", "i", "i", "i", "i", "i",
                "pour",
                "zadeh",
                "far",
                "fard",
                "khani",
                "vand",
                "lou",
                "nia",
                "zehi"
        };

        File file = new File("src/main/resources/files/" + files[0]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            lastNamesEn.add(Arrays.toString(data.split("\n")));
        }

        reader.close();
        String lastName = lastNamesEn.get((int) (Math.random() * lastNamesEn.size())).replace("[", "").replace("]", "");

        if (lastName.equals("Mostafa") || lastName.equals("Mousa") || lastName.equals("Yahya"))
            lastName += "vi";
        else if (lastName.equals("Morteza"))
            lastName = lastName.replace("ez", "az") + "vi";
        else if (lastName.equals("Khosro"))
            lastName = lastName.replace("ro", "ravi");
        else if (lastName.charAt(lastName.length() -1) == 'a' || lastName.charAt(lastName.length() -1) == 'o' || lastName.charAt(lastName.length() -1) == 'u')
            lastName += "ei";
        else if (lastName.charAt(lastName.length() -1) == 'i')
            assert true;
        else {
            chooseBetween = new String[]{"i", ""};
            lastName += chooseBetween[(byte) (Math.round(Math.random()))];
        }

        if (lastName.length() > 10 && lastName.charAt(lastName.length() -1) == 'i')
            lastName += "";
        else if (lastName.length() > 10 && lastName.charAt(lastName.length() -1) != 'i')
            lastName += "i";
        else if (lastName.charAt(lastName.length() -1) == 'i')
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        return lastName;
    }

    public String fullNameEn(String sex) throws FileNotFoundException {
        return firstNameEn(sex) + " " + lastNameEn();
    }

    public String fullNameEn() throws FileNotFoundException {
        return fullNameEn("random");
    }

    public String firstNameFa(String sex) throws FileNotFoundException {
        setGender(sex);
        File file = new File("src/main/resources/files/" + files[this.sex + 2]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            firstNamesFa.add((Arrays.toString(data.split("\n"))));
        }

        reader.close();
        return firstNamesFa.get((int) (Math.random() * firstNamesFa.size())).replace("[", "").replace("]", "");
    }

    public String firstNameFa() throws FileNotFoundException {
        return firstNameFa("random");
    }

    public String lastNameFa() throws FileNotFoundException {
        // Farsi Suffixes
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "",
                " پور",
                " زاده",
                " فر",
                " فرد",
                "ان",
                " کیا",
                " راد",
                " زند",
                " خواه",
                " نیا",
                " مهر"
        };
        moreSuffixes = new String[]{
                "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی",
                " پور",
                " زاده",
                " فر",
                " فرد",
                " خانی",
                " وند",
                " لو",
                " نیا",
                " زهی"
        };

        File file = new File("src/main/resources/files/" + files[2]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            lastNamesFa.add(Arrays.toString(data.split("\n")));
        }

        reader.close();
        String lastName = lastNamesFa.get((int) (Math.random() * lastNamesFa.size())).replace("[", "").replace("]", "");

        if (lastName.equals("مرتضی") || lastName.equals("مصطفی") || lastName.equals("موسی"))
            lastName = lastName.replace("ی", "وی");
        else if (lastName.equals("یحیی"))
            lastName = lastName.replace("یی", "یوی");
        else if (lastName.equals("خسرو"))
            assert true;
        else if (lastName.charAt(lastName.length() -1) == 'ا' || lastName.charAt(lastName.length() -1) == 'و')
            lastName += "ئی";
        else if (lastName.charAt(lastName.length() -1) == 'ی')
            assert true;
        else {
            chooseBetween = new String[]{"ی", ""};
            lastName += chooseBetween[(byte) (Math.round(Math.random()))];
        }

        if (lastName.charAt(lastName.length() -1) == 'ی')
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        return lastName;
    }

    public String fullNameFa(String sex) throws FileNotFoundException {
        return firstNameFa(sex) + " " + lastNameFa();
    }

    public String fullNameFa() throws FileNotFoundException {
        return fullNameFa("random");
    }
}