package com.geekbrains.Patterns.Examples.factory.factorymetod;

/**
 * Created by i on 21.11.2017.
 */
public class FactoryMetodImpl implements FactoryMetod {
    @Override
    public Product createProduct(EnumProduct enumProduct) {
        Product  product = null;
        switch (enumProduct) {
            case CITY: product = new CityProduct(); break;
            case STREET: product = new StreetProduct(); break;
        }
        return product;
    }
}
