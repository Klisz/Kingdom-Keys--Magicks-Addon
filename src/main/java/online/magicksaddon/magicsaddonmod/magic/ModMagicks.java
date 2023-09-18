package online.magicksaddon.magicsaddonmod.magic;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.magic.Magic;
import online.magicksaddon.magicsaddonmod.MagicksAddonMod;

public class ModMagicks {

    static int order = 11;

    //The Command
    public static DeferredRegister<Magic> MAGIC = DeferredRegister.create(new ResourceLocation(KingdomKeys.MODID, "magics"), "magicksaddon");

    //Normal Spells
    public static final RegistryObject<Magic>
            HASTE = MAGIC.register("magic_haste", () -> new magicHaste(new ResourceLocation(MagicksAddonMod.MODID, "magic_haste"), true, 3, order++)),
            SLOW = MAGIC.register("magic_slow", () -> new magicSlow(new ResourceLocation(MagicksAddonMod.MODID, "magic_slow"), false, 3, order++)),
            HOLY = MAGIC.register("magic_holy",() -> new magicHoly(new ResourceLocation(MagicksAddonMod.MODID, "magic_holy"), false, 3, null, order++)),
            RUIN = MAGIC.register("magic_ruin", () -> new magicRuin(new ResourceLocation(MagicksAddonMod.MODID, "magic_ruin"), false, 3, null, order++)),
            BALLOON = MAGIC.register("magic_balloon", () -> new magicBalloon(new ResourceLocation(MagicksAddonMod.MODID, "magic_balloon"), false, 3, order++));
            //COMET = MAGIC.register("magic_comet", () -> new magicBalloon(new ResourceLocation(MagicksAddonMod.MODID, "magic_comet"), false, 2, order++));
            //ULTIMA = MAGIC.register("magic_ultima", () -> new magicBalloon(new ResourceLocation(MagicksAddonMod.MODID, "magic_ultima"), false, 1, order++));




    // Add more magic later...



    }






