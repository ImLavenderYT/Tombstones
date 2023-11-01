package io.github.imlavenderyt.tombstones.common.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static io.github.imlavenderyt.tombstones.Tombstones.MOD_ID;

public class TombstoneItems {

	public static Item CANDY_CORN;

	public static void init() {
		CANDY_CORN = register(new Item(new QuiltItemSettings().food(
			new FoodComponent.Builder()
				.hunger(2)
				.saturationModifier(1)
				.snack()
				.alwaysEdible()
				.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10), 0.5f)
				.build()
		)), "candy_corn", ItemGroups.FOOD_AND_DRINKS);
	}

	public static Item register(Item item, String name, @Nullable RegistryKey<ItemGroup> itemGroupRegistryKey) {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
		ItemGroupEvents.modifyEntriesEvent(itemGroupRegistryKey).register(entries -> entries.addItem(item));
		return item;
	}
}
