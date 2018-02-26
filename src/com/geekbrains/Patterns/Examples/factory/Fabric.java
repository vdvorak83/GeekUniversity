package com.geekbrains.Patterns.Examples.factory;

import java.util.Set;

public class Fabric {
    // определяем конфигурационные константы
    public static final String SUPPLIER_ONE = "Citilink";
    public static final String SUPPLIER_TWO = "Ulmart";

    // создать объект, реализующий известный интерфейс на основе внешней информации
    public ExchangeFactory createFactory(String name) throws Exception {
        switch (name) {
            case SUPPLIER_ONE:
                return new CitilinkExchangeFactory();
            case SUPPLIER_TWO:
                return null;
        }
        return null;
    }

    private static Fabric instance = new Fabric();

    public static Fabric getInstance() {
        return instance;
    }

    private Fabric() {
    }
}

