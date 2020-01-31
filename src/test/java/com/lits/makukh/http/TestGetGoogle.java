package com.lits.makukh.http;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.lits.makukh.lits.LitsHttpClient;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TestGetGoogle {

   private LitsHttpClient client = new LitsHttpClient();

    @Test
    public void testGetGoogle() throws IOException {
//        //Initialize Http client
//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        //Prepare Http request
//        Request getGoogleRequest = new Request.Builder().url("https://www.google.com/").build();
        //Execute request/get response
        //Response getGoogleResponse = okHttpClient.newCall(getGoogleRequest).execute();

        Response getGoogleResponse = client.GET("https://google.com");

        String stringResponse = getGoogleResponse.body().string();
        System.out.println("BODY: " + stringResponse);

        int code = getGoogleResponse.code();
        System.out.println("STATUS: " + code);

        System.out.println("HEADERS: " + getGoogleResponse.headers());

        Assert.assertEquals(getGoogleResponse.code(), 200);
        Assert.assertEquals(getGoogleResponse.header("Content-Type"), "text/html; charset=ISO-8859-1");
    }

    @Test
    public void testGetCurrencyExchangeRate() throws IOException{

//        //Initialize Http client
//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        //Prepare Http request
//        Request getNBURequest = new Request.Builder().url("https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json").build();
//
//        //Execute request/get response
//        Response getNBUResponse = okHttpClient.newCall(getNBURequest).execute();

        Response getNBUResponse = client.GET("https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json");

        CurrencyRate[] currencyRates = LitsHttpClient.convert(getNBUResponse, CurrencyRate[].class);

//        //Create
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        String string = getNBUResponse.body().string();
//
//        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, CurrencyRate.class);
//        List<CurrencyRate> currencyRates = objectMapper.readValue(string, collectionType);

        for (CurrencyRate currencyRate : currencyRates){
            System.out.println(currencyRate);
        }

///////////////////////////////////////////////////////////////////////////////////
//        int code = getNBUResponse.code();
//        System.out.println("STATUS: " + code);
//
//        System.out.println("HEADERS: " + getNBUResponse.headers());
//
//        String stringResponse = getNBUResponse.body().string();
//        System.out.println("BODY: " + stringResponse);
//
//        Assert.assertEquals(getNBUResponse.code(), 200);
//        Assert.assertEquals(getNBUResponse.header("Content-Type"), "application/json; charset=utf-8");

    }


    public static class CurrencyRate{
        @JsonProperty("StartDate")
        private String StartDate;
        @JsonProperty("TimeSign")
        private String TimeSign;
        @JsonProperty("CurrencyCode")
        private String CurrencyCode;
        @JsonProperty("CurrencyCodeL")
        private String CurrencyCodeL;
        @JsonProperty("Units")
        private int Units;
        @JsonProperty("Amount")
        private BigDecimal Amount;

        @Override
        public String toString() {
            return "CurrencyRate{" +
                    "StartDate='" + StartDate + '\'' +
                    ", TimeSigh='" + TimeSign + '\'' +
                    ", Currencynode='" + CurrencyCode + '\'' +
                    ", CurrencyCodeL='" + CurrencyCodeL + '\'' +
                    ", Units=" + Units +
                    ", Amount=" + Amount +
                    '}';
        }


        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String startDate) {
            StartDate = startDate;
        }

        public String getTimeSign() {
            return TimeSign;
        }

        public void setTimeSign(String timeSign) {
            TimeSign = timeSign;
        }

        public String getCurrencyCode() {
            return CurrencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            CurrencyCode = currencyCode;
        }

        public String getCurrencyCodeL() {
            return CurrencyCodeL;
        }

        public void setCurrencyCodeL(String currencyCodeL) {
            CurrencyCodeL = currencyCodeL;
        }

        public int getUnits() {
            return Units;
        }

        public void setUnits(int units) {
            Units = units;
        }

        public BigDecimal getAmount() {
            return Amount;
        }

        public void setAmount(BigDecimal amount) {
            Amount = amount;
        }
    }
}
