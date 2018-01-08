package AllObjects.Market;

import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CurrencyMarket extends Market implements Serializable {

    public CurrencyMarket(){

        List<Goods> currencyList = MenuFunctionality.getCurrencyList();
        goodsList = new ArrayList<>();

        for(Goods currency: currencyList){
            goodsList.add((Currency)currency);
        }
    }

    public synchronized void add(Currency currency){
        goodsList.add(currency);
    }
}
