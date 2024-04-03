package online.magicksaddon.magicsaddonmod.ability;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
//KK Imports
import online.kingdomkeys.kingdomkeys.ability.Ability;
import online.kingdomkeys.kingdomkeys.ability.ModAbilities;
//Misc Imports
import online.magicksaddon.magicsaddonmod.MagicksAddonMod;
import online.magicksaddon.magicsaddonmod.lib.StringsRM;

public class ModAbilitiesRM extends ModAbilities{

    public static DeferredRegister<Ability> ABILITIES = DeferredRegister.create(new ResourceLocation(KingdomKeys.MODID, "abilities"), MagicksAddonMod.MODID);

    static int order = 100;

        //New Abilities

    public static final RegistryObject<Ability>
            // Action
    	DARK_PASSAGE = ABILITIES.register(StringsRM.ABMA_Prefix+"dark_passage", () -> new Ability(new ResourceLocation(StringsRM.darkPassage), 3, Ability.AbilityType.ACTION, order++)),
        RAGE_AWAKENED = ABILITIES.register(StringsRM.ABMA_Prefix+"rage_awakened", () -> new Ability(new ResourceLocation(StringsRM.rageAwakened), 5,Ability.AbilityType.ACTION, order++)),
        WAY_TO_LIGHT = ABILITIES.register(StringsRM.ABMA_Prefix+"way_to_light", () -> new Ability(new ResourceLocation(StringsRM.wayToLight), 5, Ability.AbilityType.ACTION, order++)),
        DARK_POWER = ABILITIES.register(StringsRM.ABMA_Prefix+"dark_power", () -> new Ability(new ResourceLocation(StringsRM.darkPower), 5, Ability.AbilityType.ACTION, order++)),
        RISKCHARGE = ABILITIES.register(StringsRM.ABMA_Prefix+"riskcharge", () -> new Ability(new ResourceLocation(StringsRM.riskCharge), 0, Ability.AbilityType.ACTION, order++)),

            // Growth
        LIGHT_STEP = ABILITIES.register(StringsRM.ABMA_Prefix+"light_step", () -> new Ability(new ResourceLocation(StringsRM.lightStep), 3, Ability.AbilityType.GROWTH, order++)),
        DARK_STEP = ABILITIES.register(StringsRM.ABMA_Prefix+"dark_step", () -> new Ability(new ResourceLocation(StringsRM.darkStep), 3, Ability.AbilityType.GROWTH, order++)),

            // Support
        DARKNESS_BOOST = ABILITIES.register(StringsRM.ABMA_Prefix+"darkness_boost", () -> new Ability(new ResourceLocation(StringsRM.darknessBoost), 3, Ability.AbilityType.SUPPORT, order++)),
        LIGHT_BOOST = ABILITIES.register(StringsRM.ABMA_Prefix+"light_boost", () -> new Ability(new ResourceLocation(StringsRM.lightBoost), 3, Ability.AbilityType.SUPPORT, order++)),
        ADRENALINE = ABILITIES.register(StringsRM.ABMA_Prefix+"adrenaline", () -> new Ability(new ResourceLocation(StringsRM.adrenaline), 4, Ability.AbilityType.SUPPORT, order++)),
        CRITICAL_SURGE = ABILITIES.register(StringsRM.ABMA_Prefix+"critical_surge", () -> new Ability(new ResourceLocation(StringsRM.critical_surge), 4, Ability.AbilityType.SUPPORT, order++)),
        LIGHT_WITHIN = ABILITIES.register(StringsRM.ABMA_Prefix+"light_within", () -> new Ability(new ResourceLocation(StringsRM.lightWithin), 5, Ability.AbilityType.SUPPORT, order++)),
        DARKNESS_WITHIN = ABILITIES.register(StringsRM.ABMA_Prefix+"darkness_within", () -> new Ability(new ResourceLocation(StringsRM.darknessWithin), 5, Ability.AbilityType.SUPPORT, order++)),

        HP_WALKER = ABILITIES.register(StringsRM.ABMA_Prefix+"hp_walker", () -> new Ability(new ResourceLocation(StringsRM.hpWalker),10,Ability.AbilityType.SUPPORT, order++)),
        MP_WALKER = ABILITIES.register(StringsRM.ABMA_Prefix+"mp_walker", () -> new Ability(new ResourceLocation(StringsRM.mpWalker),10,Ability.AbilityType.SUPPORT, order++)),
        EXP_WALKER = ABILITIES.register(StringsRM.ABMA_Prefix+"exp_walker", () -> new Ability(new ResourceLocation(StringsRM.expWalker),10,Ability.AbilityType.SUPPORT, order++));

}