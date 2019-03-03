package com.jingen.booking.biz.common.validate;

import com.jingen.booking.biz.common.result.ResultBaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult extends ResultBaseModel {

    private int errorCode;
    private String message = null;
    private List<ValidateField> errors = new ArrayList<>();

    public boolean isSuccess() {
        if(errors.size() > 0 || message != null){
            return false;
        }
        return errorCode == 200 ? true : false;
    }

    public void setErrorField(String filed, String msg) {
        errors.add(new ValidateField(filed, msg));
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        for (ValidateField field : errors) {
            stringBuffer.append(field.toString() + "\r\n");
        }
        return stringBuffer.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Data
    @AllArgsConstructor
    class ValidateField{
        private String fieldName;
        private String message;

        public String ToString(){
            return String.format("{0} => {1}", fieldName, message);
        }
    }
}
