package ru.cherkasov.SecondLab.model;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SER("Service_1");
    private String description;

    Systems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

