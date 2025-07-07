package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Sulfuras, Hand of Ragnaros") item.quality = 80;
            else {
                    if (item.name == "Aged Brie")
                        item.quality  = item.quality + 1
                    else {
                        if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                            item.quality = item.quality - 1
                            if (item.name.startsWith("Conjured")) item.quality -= 1
                        }
                        else {
                            item.quality ++

                            if (item.sellIn < 11)
                                item.quality ++

                            if (item.sellIn < 6)
                                item.quality ++
                        }
                    }

                    item.sellIn --

                    if (item.sellIn < 0)
                    {
                        if (item.name == "Backstage passes to a TAFKAL80ETC concert")
                                        item.quality = 0
                        else
                            if (item.name == "Aged Brie")
                                item.quality ++
                            else {
                                item.quality --
                                if (item.name.startsWith("Conjured")) item.quality --
                            }
                    }

                    if (item.quality > 50) item.quality = 50;
                    if (item.quality < 0) item.quality = 0;
                }
        }
    }
}


