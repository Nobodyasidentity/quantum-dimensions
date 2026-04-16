/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mcreator.quantumdimensions.QuantumDimensionsMod;

public class QuantumDimensionsModSounds {
	public static SoundEvent MUSIC_DISC_BLACKBOXWARRIOR;
	public static SoundEvent MUSIC_DISC_SLASH_INFERNO;
	public static SoundEvent MUSIC_DISC_LABYRINTH;
	public static SoundEvent BG_ONLY_YOU;
	public static SoundEvent MUSIC_DISC_RUNNING_IN_THE_90S;
	public static SoundEvent MUSIC_DISC_LOVE_ME_NORMALLY;
	public static SoundEvent MUSIC_DISC_OUTLIARS_AND_HYPPOCRATES;
	public static SoundEvent MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR;
	public static SoundEvent MUSIC_DISC_HIGHSCORE;

	public static void load() {
		MUSIC_DISC_BLACKBOXWARRIOR = register("music_disc.blackboxwarrior", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.blackboxwarrior")));
		MUSIC_DISC_SLASH_INFERNO = register("music_disc.slash_inferno", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.slash_inferno")));
		MUSIC_DISC_LABYRINTH = register("music_disc.labyrinth", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.labyrinth")));
		BG_ONLY_YOU = register("bg.only_you", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "bg.only_you")));
		MUSIC_DISC_RUNNING_IN_THE_90S = register("music_disc.running_in_the_90s", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.running_in_the_90s")));
		MUSIC_DISC_LOVE_ME_NORMALLY = register("music_disc.love_me_normally", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.love_me_normally")));
		MUSIC_DISC_OUTLIARS_AND_HYPPOCRATES = register("music_disc.outliars_and_hyppocrates", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.outliars_and_hyppocrates")));
		MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR = register("music_disc.dream_sweet_in_sea_major", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.dream_sweet_in_sea_major")));
		MUSIC_DISC_HIGHSCORE = register("music_disc.highscore", SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("quantum_dimensions", "music_disc.highscore")));
	}

	private static SoundEvent register(String registryname, SoundEvent element) {
		return Registry.register(BuiltInRegistries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, registryname), element);
	}
}