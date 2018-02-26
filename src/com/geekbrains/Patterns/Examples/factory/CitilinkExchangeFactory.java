package com.geekbrains.Patterns.Examples.factory;

public class CitilinkExchangeFactory implements ExchangeFactory {

    @Override
    public PriceProvider createPriceProvider() {
        return new CitilinkPriceProvider();
    }

    @Override
    public DocProvider createDocProvider() {
        return new CitilinkDocProvider();
    }

    @Override
    public MarketingProvider createMarketingProvider() {
        return new CitilinkMarketingProvider();
    }
}
