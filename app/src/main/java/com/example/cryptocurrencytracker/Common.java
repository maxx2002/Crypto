package com.example.cryptocurrencytracker;

import Remote.CoinService;
import Remote.RetrofitClient;

public class Common {
    private final static String API_URL = "https://min-api.cryptocompare.com";

    public static CoinService getCoinService() {
        return RetrofitClient.getClient(API_URL).create(CoinService.class);
    }
}
