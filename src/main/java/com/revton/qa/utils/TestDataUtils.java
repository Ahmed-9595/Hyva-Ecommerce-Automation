package com.revton.qa.utils;

import com.revton.qa.dto.CheckoutData;
import com.revton.qa.dto.SearchData;

public class TestDataUtils {

    private static final   String checkoutDataFilePath = "src/test/java/tests/testData/checkoutData.json";
    private static final  String searchDataFilePath = "src/test/java/tests/testData/searchData.json";

    public static CheckoutData loadCheckoutData() {
            return JsonUtils.readJsonFile(checkoutDataFilePath, CheckoutData.class);
        }
    public static SearchData loadSearchData() {
        return JsonUtils.readJsonFile(searchDataFilePath, SearchData.class);
    }
    }
