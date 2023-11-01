package ru.cherkasov.SecondLab.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, true),
    PO(2.2, true),
    PM(1.0, true),
    BackOfficeManager(1.0, true),
    TL(2.6, true);

    private final double positionCoefficient;
    private final boolean isManager;
    Positions(double positionCoefficient, boolean isManager) {
        this.isManager = isManager;
        this.positionCoefficient = positionCoefficient;
    }
}
