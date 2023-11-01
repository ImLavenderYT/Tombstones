package io.github.imlavenderyt.tombstones;

import io.github.imlavenderyt.tombstones.common.init.TombstoneBlocks;
import io.github.imlavenderyt.tombstones.common.init.TombstoneItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tombstones implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Tombstones");
	public static final String MOD_ID = "tombstones";

	@Override
	public void onInitialize(ModContainer mod) {
		TombstoneBlocks.init();
		TombstoneItems.init();
		LOGGER.info("{} by ImLavenderYT is enabled.", mod.metadata().name());
	}
}
