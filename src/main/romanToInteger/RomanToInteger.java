package romanToInteger;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToInteger {
    public int romeNumbersConvert(String str) throws SizeLimitExceededException {
        romanNumeralCheck(str);
        String[] separator = str.split("");
        List<Integer> temp = new ArrayList<>();
        for (String s : separator) {
            switch (s) {
                case "M":
                    temp.add(1000);
                    break;
                case "D":
                    temp.add(500);
                    break;
                case "C":
                    temp.add(100);
                    break;
                case "L":
                    temp.add(50);
                    break;
                case "X":
                    temp.add(10);
                    break;
                case "V":
                    temp.add(5);
                    break;
                case "I":
                    temp.add(1);
                    break;
                default://SMILE ;)
            }
        }
        int countNumbers = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (countNumbers == 0 && (temp.size() > (i + 1)) && temp.get(i + 1) < temp.get(i)) {
                countNumbers += temp.get(i);
            } else if ((temp.size() > (i + 1)) && (temp.get(i) < temp.get(i + 1))) {
                countNumbers = countNumbers + temp.get(i + 1) - temp.get(i);
                i++;
            } else if (temp.get(i) > countNumbers) {
                countNumbers += temp.get(i);
            } else {
                countNumbers += temp.get(i);
            }
        }
        if (separator.length > 15 | countNumbers > 3999) {
            throw new SizeLimitExceededException("Valid roman number in the range 1 to 3999!");
        }
        return countNumbers;
    }

    private void romanNumeralCheck(String str) {
        Pattern pattern = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Misspelled roman number!");
        }
    }
}
