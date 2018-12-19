package dino.one.ruphotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prgres on 2018-12-19.
 */

@Getter
@Setter
@ToString
public class DataValidator {

    public boolean idNumberValidate(String idNumber) {
        idNumber = idNumber.replaceAll(" ", "");

        List<Integer> waga = Arrays.asList(7, 3, 1, 0, 7, 3, 1, 7, 3);

        if (idNumber.length() != 9)
            return false;

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            if (Character.isLetter(idNumber.charAt(i)) && i < 3) {
                sum += waga.get(i) * (idNumber.charAt(i) - 'A' + 10);
            } else if (Character.isDigit(idNumber.charAt(i)) && i >= 3) {
                sum += waga.get(i) * (idNumber.charAt(i) - '0');
            } else return false;
        }

        return ((sum % 10) + '0') == idNumber.charAt(3);
    }

}
