package online.magicksaddon.magicsaddonmod.shotlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.shotlock.ModShotlocks;
import online.kingdomkeys.kingdomkeys.shotlock.Shotlock;
import online.magicksaddon.magicsaddonmod.MagicksAddonMod;
import online.magicksaddon.magicsaddonmod.lib.Strings;

public class AddonShotlocks {

    public static DeferredRegister<Shotlock> SHOTLOCKS = DeferredRegister.create(new ResourceLocation(KingdomKeys.MODID, "shotlocks"), MagicksAddonMod.MODID);

    static int order = 100;
    public static final RegistryObject<Shotlock>
    	FLAME_SALVO = SHOTLOCKS.register(Strings.flameSalvo, () -> new ShotlockFlameSalvo(MagicksAddonMod.MODID + ":" + Strings.flameSalvo, order++, 2, 15));


}