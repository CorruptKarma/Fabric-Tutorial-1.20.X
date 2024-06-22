package net.karma.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.entity.ModEntities;
import net.karma.tutorialmod.item.ModItems;
import net.karma.tutorialmod.item.ModItemsGroups;
import net.karma.tutorialmod.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlock.registerModBlock();
		ModPotions.registerPotions();
		ModEntities.RegisterEntities();
	}
}