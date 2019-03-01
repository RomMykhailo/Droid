package com.example.droid.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements ConstraintValidator<MyValidation,String> {

    private boolean required;
    @Override
    public void initialize(MyValidation constraintAnnotation) {
        required= constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null){
            return !required;
        }
        String pattern = "(.*)((ab)|(bc)|(cd)|(de)|(ef)|(fg)|(gh)|(hi)|(ij)|(jk)|(kl)|(lm)|"
                + "(mn)|(no)|(op)|(pq)|(qr)|(rs)|(st)|(tu)|(uv)|(vw)|(wx)|(xy)|(yz)|"
                + "(01)|(12)|(23)|(34)|(45)|(56)|(67)|(78)|(89))(.*)";
        return !s.matches(pattern);
    }
}
