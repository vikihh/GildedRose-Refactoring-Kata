package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun sameName() {
        val items = listOf(Item("same name", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("same name", app.items[0].name)

    }
    @Test
    fun  `quality decreases by one for a normal item before expiry` () {
        val items = listOf(Item("name", 1, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }
    @Test
    fun `number of days before expiry decreases by 1`() {
        val items = listOf(Item("name", 2, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)

    }
    @Test
    fun `sell in decreases after expiry too`() {
        val items = listOf(Item("name", 0, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)

    }
    @Test
    fun qualityNotBelowZeroWhenExpired() {
        val items = listOf(Item("name", -10, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }
    @Test
    fun `quality goes to 0 when the item reaches its expiry`() {
        val items = listOf(Item("name", 10, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }
    @Test
    fun qualityDegradesTwiceAsFast() {
        val items = listOf(Item("name", -10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun qualityNotMoreThan50() {
        val items = listOf(Item("name", 0, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }
    @Test
    fun sulfarasQualityAlway80() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
    }


    @Test
    fun agedBrieIncreasesByOneBeforeExpiryDate() {
        val items = listOf(Item("Aged Brie", 10, 30))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(31, app.items[0].quality)
    }
    @Test
    fun agedBrieDoesNotIncreaseOver50() {
        val items = listOf(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }
    @Test
    fun agedBrieDoesNotIncreaseOver50AfterExpiryDate() {
        val items = listOf(Item("Aged Brie", 0, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun agedBrieIncreasesTwiceAsFastAfterExpiryDate() {
        val items = listOf(Item("Aged Brie", 0, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }


    @Test
    fun agedBrieNotBelowZero() {
        val items = listOf(Item("Aged Brie", 0, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun concertZeroAfterExpiryDate() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
    @Test
    fun concertIncreaseBefore10DaysBeforeDateOfEvent() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
    }
    @Test
    fun `concert quality increases twice as fast once we reach 10 days before date of event`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }

    @Test
    fun concertIncreasesThrice5DaysBeforeDateOfEvent() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
    }

    @Test
    fun conjuredItemsBeforeExpiryDateDecreaseTwiceAsFastInQuality() {
        val items = listOf(Item("Conjured Mnan cake", 5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(38, app.items[0].quality)
    }

    @Test
    fun conjuredItemsAfterExpiryDateDecreaseFourimesAsFastInQuality() {
        val items = listOf(Item("Conjured Mana Cake", 0, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(36, app.items[0].quality)
    }
}


