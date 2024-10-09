package com.atguigu.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @projectName:gulimall
 * @see:com.atguigu.common.valid
 * @author:db
 * @createTime:2024/10/9 11:17
 * @version:1.0
 */
public class ListValueConstrainValidator implements ConstraintValidator<ListValue,Integer> {
    private Set<Integer> set =new HashSet<>();
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val : vals){
            set.add(val);
        }

    }
/* description
 * param value 需要校验的值
 * return boolean
 * author db
 * createTime 2024/10/9 11:21
*/
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
