package AllObjects.Market;

import AllObjects.Client;
import AllObjects.Goods.Goods;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;

import java.util.List;

public class Market {

    protected List<AllInstancess> goodsList;
    protected double markup;

    public static void buy(Client client, Goods subject, double cost){

        MenuFunctionality.getrandomMarket();

    }

}
