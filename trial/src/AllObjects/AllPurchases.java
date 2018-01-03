package AllObjects;

import java.util.ArrayList;
import java.util.List;

public class AllPurchases {

    private static List<Purchase> list = new ArrayList<>();

    public static void addToList(Purchase purchase){

        Purchase onList = findOnList(purchase);
        if(onList == null)
            list.add(purchase);
        else{
            double amount = onList.getAmount();
            onList.setAmount(amount+purchase.getAmount());
        }
    }

    public static void deleteFromList(int clientId, int sellerId){

        for(int i=0; i<list.size(); i++){

            if (list.get(i).getClientId() == clientId && list.get(i).getSellerId() == sellerId)
                list.remove(i);
        }
    }

    public static Purchase findOnList(Purchase purchase){

        for (Purchase purch: list) {
            if(purch.getSellerId()==purchase.getSellerId() && purch.getClientId() == purchase.getSellerId())return purch;
        }
        return null;

    }

}
