package com.nopcommerce.data;

import commons.GlobalConstants;

public class CustomerData {
    public static final String REGISTERED_EMAIL = GlobalConstants.USER_EMAIL;
    public static final String REGISTERD_PASSWORD = GlobalConstants.USER_PASSWORD;

    public class NewCustomer {
        public static final String FIRST_NAME = "Corona";
        public static final String LAST_NAME = "Virus";
        public static final String INVALID_EMAIL = "a.gmail.com";
        public static final String COMPANY = "Corona Virus";
        public static final String BIRTHDAY = "1";
        public static final String INVALID_LOWER_THAN_6_CHARS_PASSWORD = "fos1";
        public static final String INVALID_PASSWORD = "fos123456";
        public static final String BIRTHMONTH = "March";
        public static final String BIRTHYEAR = "1986";
    }

    public class LoginData {
        public static final String EMAIL_BLANK = "";
        public static final String PASSWORD_BLANK = "";
        public static final String INVALID_EMAIL = "a.gmail.com";
        public static final String WRONG_PASSWORD = "abc12345678";
        public static final String EMAIL_NO_REGISTER = "nhatkhanh@gmail.com";

    }
}
