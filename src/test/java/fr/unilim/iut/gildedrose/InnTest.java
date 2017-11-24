package fr.unilim.iut.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InnTest {
	Inn inn = new Inn();

	@Test
	public void test_should_list_items() {
		assertThat(inn.getItems()).extracting("name").containsExactly("+5 Dexterity Vest", "Aged Brie",
				"Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
				"Conjured Mana Cake");
		assertThat(inn.getItems()).extracting("sellIn").containsExactly(10, 2, 5, 0, 15, 3);
		assertThat(inn.getItems()).extracting("quality").containsExactly(20, 0, 7, 80, 20, 6);
	}

	@Test
	public void test_should_update_items() {
		inn.updateQuality();

		assertThat(inn.getItems()).extracting("name").containsExactly("+5 Dexterity Vest", "Aged Brie",
				"Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
				"Conjured Mana Cake");
		assertThat(inn.getItems()).extracting("sellIn").containsExactly(9, 1, 4, 0, 14, 2);
		assertThat(inn.getItems()).extracting("quality").containsExactly(19, 1, 6, 80, 21, 5);
	}

	@Test
	public void test_should_update_items_twice() {
		inn.updateQuality();
		inn.updateQuality();

		assertThat(inn.getItems()).extracting("name").containsExactly("+5 Dexterity Vest", "Aged Brie",
				"Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
				"Conjured Mana Cake");
		assertThat(inn.getItems()).extracting("sellIn").containsExactly(8, 0, 3, 0, 13, 1);
		assertThat(inn.getItems()).extracting("quality").containsExactly(18, 2, 5, 80, 22, 4);
	}
}