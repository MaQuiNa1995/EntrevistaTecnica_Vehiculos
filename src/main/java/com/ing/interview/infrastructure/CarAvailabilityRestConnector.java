package com.ing.interview.infrastructure;

import java.util.HashSet;
import java.util.Set;

public class CarAvailabilityRestConnector {

    private static final Set<String> STOCK = new HashSet<String>() {{
        add("PEUGEOT:BLUE");
        add("FIAT:YELLOW");
        add("MERCEDES:BLACK");
    }};

    public boolean available(String color, String model) {
        String colorModel = color + ":" + model;

        return STOCK.contains(colorModel);
    }

}
