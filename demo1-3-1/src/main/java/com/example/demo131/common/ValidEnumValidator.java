package com.example.demo131.common;
import com.example.demo131.annotation.ValidString;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ValidEnumValidator implements ConstraintValidator<ValidString,String> {

    private List<String> validStringList;

    @Override
    public void initialize(ValidString constraintAnnotation) {
        String[] value = constraintAnnotation.value();
        validStringList = Arrays.asList(value);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return true;
        }
        return validStringList.contains(s);
    }
}
