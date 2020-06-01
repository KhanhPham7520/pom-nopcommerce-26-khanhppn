package com.nopcommerce.data;

public class ProductData {

    public class ReviewProduct {
        public static final String productName = "Lenovo IdeaCentre 600 All-in-One PC";
        public static final String reviewTitle = "Product Quality";
        public static final String reviewText = "Product Quality is not exellent";
    }

    public class searchProduct {
        public static final String Lenovo_IdeaCentre_600_All_in_One_PC = "Lenovo IdeaCentre 600 All-in-One PC";
        public static final String Lenovo_Thinkpad_X1_Carbon_Laptop = "Lenovo Thinkpad X1 Carbon Laptop";
        public static final String Apple_MacBook_Pro_13_inch = "Apple MacBook Pro 13-inch";
    }

    public class sortAndDisplayData {
        public static final String Navigation_Label = "Computers";
        public static final String Navigation_Item = "Notebooks";
        public static final String Select_Name_A_To_Z = "Name: A to Z";
        public static final String Select_Name_Z_To_A = "Computers";
        public static final String Select_Price_Low_To_High = "Price: Low to High";
        public static final String Select_Price_High_To_Low = "Price: High to Low";
        public static final String Three_Products_Per_Page = "3";
        public static final String Six_Products_Per_Page = "6";
        public static final String Nine_Products_Per_Page = "9";

    }

    public static class orderProduct {
        public static String orderNumber = "";

        public static String getOrderNumber(){
           return orderNumber;
        }
    }

}
