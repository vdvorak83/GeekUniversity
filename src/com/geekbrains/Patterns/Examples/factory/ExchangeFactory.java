package com.geekbrains.Patterns.Examples.factory;

public interface ExchangeFactory {
    PriceProvider createPriceProvider();
    DocProvider createDocProvider();
    MarketingProvider createMarketingProvider();
}
