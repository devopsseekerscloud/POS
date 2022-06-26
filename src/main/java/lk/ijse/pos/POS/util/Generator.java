package lk.ijse.pos.POS.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {
    private final Random RANDOM = new Random();
    private final String NUMERIC = "0123456789";
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Long generateDigits(int length) {
        return generateRandomDigits(length);
    }

    private Long generateRandomDigits(int length) {
        StringBuilder returnValue= new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }
        return Long.parseLong(returnValue.toString());
    }
    public GeneratedIdentificationDto createId(){
        StringBuilder builder= new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index=(int) (ALPHABET.length()*Math.random());
            builder.append(ALPHABET.charAt(index));
        }
        Long digits= generateDigits(8);
        return new GeneratedIdentificationDto(digits, builder.toString());
    }

}
