package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testToString() {
        Item item = new Item("Test name", 1, 2);

        assertEquals("Test name, 1, 2", item.toString());
    }
}
