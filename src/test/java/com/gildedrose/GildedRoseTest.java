package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void afterSellByDateDegradeDouble() {
        GildedRose app = checkItem("Any", 0, 10);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void beforeSellByDateDegradeSingle() {
        GildedRose app = checkItem("Any", 1, 10);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void qualityOfItemNotNegative() {
        GildedRose app = checkItem("Any", 0, 0);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void brieImprovesWithAge() {
        GildedRose app = checkItem("Aged Brie", 0, 0);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityOfItemLimit50() {
        GildedRose app = checkItem("Aged Brie", 0, 50);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void legendarySulfuras() {
        GildedRose app = checkItem("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstageValueLosesAllQualityOnDate() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void backstageValueLongBefore() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 100, 100);
        assertEquals(100, app.items[0].quality);
    }

    @Test
    void backstageValue10DaysBefore() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 8, 47);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void backstageValueTwoDaysBefore() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 2, 40);
        assertEquals(43, app.items[0].quality);
    }

    @Test
    void backstage1() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstage2() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 51);
        assertEquals(51, app.items[0].quality);
    }

    @Test
    void backstage3() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 13, 51);
        assertEquals(51, app.items[0].quality);
    }

    @Test
    void backstage4() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 15, 45);
        assertEquals(46, app.items[0].quality);
    }

    @Test
    void backstage5() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 45);
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void backstage6() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstage7() {
        GildedRose app = checkItem("Backstage passes to a TAFKAL80ETC concert", 7, 52);
        assertEquals(52, app.items[0].quality);
    }

    @Test
    void legendarySulfuras2() {
        GildedRose app = checkItem("Sulfuras, Hand of Ragnaros", -1, 80);
        assertEquals(80, app.items[0].quality);
    }

    @Disabled
    @Test
    void conjuredAfterSellByDateDegradeDoubleOfDouble() {
        GildedRose app = checkItem("conjured", 0, 10);
        assertEquals(6, app.items[0].quality);
    }

    @Disabled
    @Test
    void conjuredBeforeSellByDateDegradeDouble() {
        GildedRose app = checkItem("conjured", 1, 10);
        assertEquals(8, app.items[0].quality);
    }

    GildedRose checkItem(String item, Integer sellin, Integer quality) {
        Item[] items = new Item[] { new Item(item, sellin, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

}
