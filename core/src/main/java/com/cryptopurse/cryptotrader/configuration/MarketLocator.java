package com.cryptopurse.cryptotrader.configuration;

import com.cryptopurse.cryptotrader.api.market.KrakenMarketService;
import com.cryptopurse.cryptotrader.api.market.MarketService;
import com.cryptopurse.cryptotrader.api.market.PoloniexMarketService;
import com.cryptopurse.cryptotrader.exchange.service.supported.SupportedExchanges;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MarketLocator {

    @Bean
    public PoloniexMarketService poloniex() {
        return new PoloniexMarketService();
    }

    @Bean
    public KrakenMarketService kraken() {
        return new KrakenMarketService();
    }

    @Bean
    public Map<SupportedExchanges, ? extends MarketService> marketServicesPerSuppportedExchange() {
        final HashMap<SupportedExchanges, MarketService> marketServiceExchange = new HashMap<>();
        marketServiceExchange.put(SupportedExchanges.KRAKEN, kraken());
        marketServiceExchange.put(SupportedExchanges.POLONIEX, poloniex());
        return marketServiceExchange;
    }

}
