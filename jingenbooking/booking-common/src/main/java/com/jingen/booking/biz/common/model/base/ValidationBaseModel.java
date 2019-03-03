package com.jingen.booking.biz.common.model.base;

import com.jingen.booking.biz.common.annotation.validate.ValidationAnnatation;
import com.jingen.booking.biz.common.annotation.validate.ValidationAnnotations;
import com.jingen.booking.biz.common.utils.StringUtils;
import com.jingen.booking.biz.common.validate.ValidationMethodEnum;
import com.jingen.booking.biz.common.validate.ValidationResult;
import org.javatuples.Triplet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationBaseModel {

    public ValidationResult validate(){

        ValidationResult result = new ValidationResult();
        // 获取所有的自定义字段
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields){
            // 注解判断
            if (!field.isAnnotationPresent(ValidationAnnatation.class)
                    && !field.isAnnotationPresent(ValidationAnnotations.class)){
                continue;
            }
            // 存在自定义注解的话，获取所有注解
            Annotation[] annotations = field.getAnnotations();
            List<ValidationAnnatation> lstValidate = new ArrayList<>();
            for (Annotation item : annotations) {
                if (item instanceof ValidationAnnotations){
                    ValidationAnnotations itemGroup = (ValidationAnnotations)item;
                    lstValidate = Arrays.asList(itemGroup.value());
                } else {
                    lstValidate.add((ValidationAnnatation)item);
                }
            }
            for (ValidationAnnatation validateItem : lstValidate) {
                Triplet<Boolean, String, String> validateResult = validate(validateItem, field);
                if (!validateResult.getValue0()) {
                    result.setErrorField(validateResult.getValue1(), validateResult.getValue2());
                }
            }
        }
        // 获取所有的方法，如果存在validate开头的方法，则进行执行验证
        List<Triplet<Boolean, String, String>> lstResult = validateAll();
        if (lstResult != null) {
            for (Triplet<Boolean, String, String> item : lstResult) {
                if (!item.getValue0()){
                    result.setErrorField(item.getValue1(), item.getValue2());
                }
            }
        }
        return result;
    }

    /***
     * 进行验证所有
     * @return
     */
    protected List<Triplet<Boolean, String, String>> validateAll(){
        return null;
    }

    // 验证所有的对象
    private Triplet<Boolean, String, String> validate(ValidationAnnatation annotation, Field filed){
        filed.setAccessible(true);
        Object value = null;
        try{
            value = filed.get(this);
        }catch (IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }
        boolean isValidateOk = true;
        switch (annotation.methodName()){
            case NotEmpty:
                isValidateOk = !StringUtils.isEmptyOrNull(value);
                break;
            case Length:
                isValidateOk = !StringUtils.overLength(value, annotation.minLen(), annotation.maxLen());
                break;
            case Email:
                isValidateOk = StringUtils.isEmail(value);
                break;
            case Phone:
                isValidateOk = StringUtils.isPhone(value);
                break;
            case Regex:
                isValidateOk = StringUtils.isMatch(value, annotation.pattern());
                break;
            default:
        }

        if(!isValidateOk) {
            return Triplet.with(false, filed.getName(), annotation.message());
        }
        return Triplet.with(true, "", "");
    }
}
