package by.epam.taining.classes.trains;

import by.epam.taining.classes.wagons.GoodsWagon;

import java.util.ArrayList;
import java.util.List;

public class GoodsTrain extends Train {
    private List<GoodsWagon> goodsWagons;

    public GoodsTrain(Locomotive locomotive) {
        super(locomotive);
        this.goodsWagons = new ArrayList<>();
    }

    public List<GoodsWagon> getGoodsWagons() {
        return goodsWagons;
    }
}
