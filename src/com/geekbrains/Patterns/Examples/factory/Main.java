package com.geekbrains.Patterns.Examples.factory;


public class Main {
    public Money getSupplierPrice(String supplierName, String article) throws Exception {
        // создать абстрактную фабрику сервисов конкретного поставщика
        ExchangeFactory exchangeFactory = Fabric.getInstance().createFactory(supplierName);

        // создать фабрикой конкретного поставщика его провайдер некоторых услуг
        PriceProvider priceProvider = exchangeFactory.createPriceProvider();

        // получить услугу
        Money price = priceProvider.getPrice(article);
        return price;
    }
}
