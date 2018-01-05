package AllObjects.Market;

import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

public class RawMaterialsMarket extends Market {


    public RawMaterialsMarket(){

        List<Goods> rawMaterialList = MenuFunctionality.getRawMaterialList();
        goodsList = new ArrayList<Goods>();

        for(Goods material: rawMaterialList){

            goodsList.add(material);
        }
    }
/*
    public synchronized List<RawMaterials> getGoodsList() {

        List<RawMaterials> result = new ArrayList<>();
        for(Goods good: goodsList) {
            result.add((RawMaterials) good);
        }
        return result;
    }
*/
    public synchronized void add(RawMaterials rawMaterial){
        goodsList.add(rawMaterial);
    }

}
