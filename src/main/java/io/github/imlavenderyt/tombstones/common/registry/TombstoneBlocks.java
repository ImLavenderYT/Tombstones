package io.github.imlavenderyt.tombstones.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import io.github.imlavenderyt.tombstones.common.block.HeadstoneBlock;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static io.github.imlavenderyt.tombstones.Tombstones.MOD_ID;

public class TombstoneBlocks {

	public static Block HEADSTONE;

	public static void init() {
		HEADSTONE = registerModBlocks(new HeadstoneBlock(QuiltBlockSettings.of(Material.STONE)
				.strength(2.0f, 6.0f)),"headstone", ItemGroups.FUNCTIONAL);
	}

	public static Block registerModBlocks(Block block, String name, ItemGroup group) {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
		BlockItem item = new BlockItem(block, new QuiltItemSettings());
		TombstoneItems.registerItem(item, name, group);
		return block;
	}
}
