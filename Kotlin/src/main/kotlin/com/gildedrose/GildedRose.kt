package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            when
            {
                item.name =="Sulfuras, Hand of Ragnaros" ->
                {
                    item.quality = 80
                }
                item.name == "Aged Brie" -> {
                    item.quality ++
                    if (item.sellIn <= 0) item.quality++
                }
                item.name == "Backstage passes to a TAFKAL80ETC concert" -> {
                    item.quality ++
                    if (item.sellIn <= 10)
                        item.quality++

                    if (item.sellIn <= 5)
                        item.quality++

                    if (item.sellIn <=0) item.quality =0
                }
                item.name.startsWith("Conjured") -> {
                    item.quality -= 2
                    if (item.sellIn<=0) item.quality -= 2
                }
                else -> {
                    item.quality --
                    if (item.sellIn <=0) item.quality --
                }
            }

            item.sellIn--
            if (item.quality > 50 && item.name != "Sulfuras, Hand of Ragnaros") item.quality = 50;
            if (item.quality < 0) item.quality = 0;
        }
    }
}



