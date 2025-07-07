package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            when (item.name)
            {
                "Sulfuras, Hand of Ragnaros" -> item.quality = 80
                "Aged Brie" -> item.quality ++
                "Backstage passes to a TAFKAL80ETC concert" -> item.quality ++
                else -> item.quality --
            }
            if (item.name != "Sulfuras, Hand of Ragnaros") {
                if (item.name.startsWith("Conjured")) item.quality--

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.sellIn <= 10)
                        item.quality++

                    if (item.sellIn <= 5)
                        item.quality++

                }

                if (item.sellIn <= 0) {
                    when (item.name) {
                        "Aged Brie" -> item.quality++
                        "Backstage passes to a TAFKAL80ETC concert" -> item.quality = 0
                        else -> item.quality--
                    }
                    if (item.name.startsWith("Conjured")) item.quality--

                }
                item.sellIn--
                if (item.quality > 50) item.quality = 50;
                if (item.quality < 0) item.quality = 0;
            }
        }
    }
}

