package io.github.imlavenderyt.tombstones.common.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import io.github.imlavenderyt.tombstones.common.block.HeadstoneBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static io.github.imlavenderyt.tombstones.Tombstones.MOD_ID;

public class TombstoneBlocks {

	public static Block HEADSTONE;
	public static Block IRON_FENCE;
	public static Block CANDY_CORN_BLOCK;

	public static void init() {
		HEADSTONE = register(new HeadstoneBlock(QuiltBlockSettings.create()
			.requiresTool().strength(2.0f, 6.0f)),"headstone", ItemGroups.FUNCTIONAL_BLOCKS);
		IRON_FENCE = register(new FenceBlock(QuiltBlockSettings.create()
			.requiresTool().strength(2.0F, 6.0F).sounds(BlockSoundGroup.METAL)), "iron_fence", ItemGroups.BUILDING_BLOCKS);
		CANDY_CORN_BLOCK = register(new Block(QuiltBlockSettings.create()
			.strength(0.0F, 1.0F)), "candy_corn_block", ItemGroups.FOOD_AND_DRINKS);
	}

	public static Block register(Block block, String name, @Nullable RegistryKey<ItemGroup> itemGroupRegistryKey) {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
		BlockItem item = new BlockItem(block, new QuiltItemSettings());
		TombstoneItems.register(item, name, itemGroupRegistryKey);
		return block;
	}
}
