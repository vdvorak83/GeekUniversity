package com.geekbrains.Patterns.Examples.factory.factorymetod;

/**
 * Created by i on 21.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        FactoryMetod factory = SingletonFactoryMetod.getInstance().createFactoryMetod();
        for (EnumProduct enumProduct : EnumProduct.values()) {
            Product  product = factory.createProduct(enumProduct);
            product.info();
        }
    }
}
