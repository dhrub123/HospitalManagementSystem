package com.hospital.frontdesk.response;

import java.util.Map;

public class ProviderResponse {

    public Map<String, String> getProviderMap() {
        return providerMap;
    }

    public void setProviderMap(Map<String, String> providerMap) {
        this.providerMap = providerMap;
    }

    public Map<String, String> providerMap;

    public ProviderResponse(Map<String, String> providerMap) {
        this.providerMap = providerMap;
    }
}
