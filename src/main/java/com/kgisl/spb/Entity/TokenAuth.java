package com.kgisl.spb.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenAuth {

    @JsonProperty("access_token")
    private String accesstoken;

    private String scope;

    @JsonProperty("token_type")
    private String tokentype;

    @JsonProperty("expires_in")
    private long expiresin;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTokentype() {
        return tokentype;
    }

    public void setTokentype(String tokentype) {
        this.tokentype = tokentype;
    }

    public long getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(long expiresin) {
        this.expiresin = expiresin;
    }

}
