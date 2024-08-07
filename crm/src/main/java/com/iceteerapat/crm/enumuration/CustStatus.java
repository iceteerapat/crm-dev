package com.iceteerapat.crm.enumuration;

public enum CustStatus {
    ACTIVE("Active"), INACTIVE("INACTIVE");
    private final String custStatus;

    CustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public String getCustStatus(){
        return this.custStatus;
    }
}
