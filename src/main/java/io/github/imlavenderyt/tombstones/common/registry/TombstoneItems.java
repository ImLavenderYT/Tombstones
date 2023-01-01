package io.github.imlavenderyt.tombstones.common.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.github.imlavenderyt.tombstones.Tombstones.MOD_ID;

public class TombstoneItems {

	public static void init() {
	}

	public static Item registerItem(Item item, String name, ItemGroup group) {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addItem(item));
		return item;
	}
}
