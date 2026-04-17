/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.item.*;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import java.util.function.Function;

public class QuantumDimensionsModItems {
	public static Item TESSERACT;
	public static Item QUANTUM_MACHINE;
	public static Item REBREATHER;
	public static Item THE_CORRECT_FURNACE;
	public static Item QUANTUM_ERASER;
	public static Item HELLRACK;
	public static Item BEAN_SOUP_BUCKET;
	public static Item ZOMBIE_PIGMAN_SPAWN_EGG;
	public static Item BIG_ASS_HAMMER;
	public static Item MUSIC_DISC_BLACKBOXWARRIOR;
	public static Item MUSIC_DISC_SLASH_INFERNO;
	public static Item MUSIC_DISC_LABYRINTH;
	public static Item MUSIC_DISC_RUNNING_IN_THE_90S;
	public static Item MUSIC_DISC_LOVE_ME_NORMALLY;
	public static Item MUSIC_DISC_OUTLIARS_AND_HYPPOCRATES;
	public static Item CASSETTE_ONLY_YOU;
	public static Item MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR;
	public static Item MUSIC_DISC_HIGHSCORE;

	public static void load() {
		TESSERACT = register("tesseract", TesseractItem::new);
		QUANTUM_MACHINE = block(QuantumDimensionsModBlocks.QUANTUM_MACHINE, "quantum_machine", new Item.Properties().rarity(Rarity.EPIC).fireResistant());
		REBREATHER = register("rebreather", RebreatherItem::new);
		THE_CORRECT_FURNACE = block(QuantumDimensionsModBlocks.THE_CORRECT_FURNACE, "the_correct_furnace");
		QUANTUM_ERASER = register("quantum_eraser", QuantumEraserItem::new);
		HELLRACK = block(QuantumDimensionsModBlocks.HELLRACK, "hellrack");
		BEAN_SOUP_BUCKET = register("bean_soup_bucket", BeanSoupItem::new);
		ZOMBIE_PIGMAN_SPAWN_EGG = register("zombie_pigman_spawn_egg", properties -> new SpawnEggItem(QuantumDimensionsModEntities.ZOMBIE_PIGMAN, properties));
		BIG_ASS_HAMMER = register("big_ass_hammer", BigAssHammerItem::new);
		MUSIC_DISC_BLACKBOXWARRIOR = register("music_disc_blackboxwarrior", MusicDiscBlackboxwarriorItem::new);
		MUSIC_DISC_SLASH_INFERNO = register("music_disc_slash_inferno", MusicDiscSlashInfernoItem::new);
		MUSIC_DISC_LABYRINTH = register("music_disc_labyrinth", MusicDiscLabyrinthItem::new);
		MUSIC_DISC_RUNNING_IN_THE_90S = register("music_disc_running_in_the_90s", MusicDiscRunningInThe90sItem::new);
		MUSIC_DISC_LOVE_ME_NORMALLY = register("music_disc_love_me_normally", MusicDiscLoveMeNormallyItem::new);
		MUSIC_DISC_OUTLIARS_AND_HYPPOCRATES = register("music_disc_outliars_and_hyppocrates", MusicDiscOutliarsAndHyppocratesItem::new);
		CASSETTE_ONLY_YOU = register("cassette_only_you", CassetteOnlyYouItem::new);
		MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR = register("music_disc_dream_sweet_in_sea_major", MusicDiscDreamSweetInSeaMajorItem::new);
		MUSIC_DISC_HIGHSCORE = register("music_disc_highscore", MusicDiscHighscoreItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}