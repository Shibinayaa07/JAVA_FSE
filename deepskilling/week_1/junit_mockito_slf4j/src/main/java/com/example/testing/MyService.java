package com.example.testing;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void processAndSave(String data) {
        externalApi.saveData(data.trim().toUpperCase());
    }
}
