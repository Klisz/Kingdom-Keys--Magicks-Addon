package online.magicksaddon.magicsaddonmod.handler;

import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.magicksaddon.magicsaddonmod.MagicksAddonMod;
import online.magicksaddon.magicsaddonmod.capabilities.IGlobalCapabilitiesX;
import online.magicksaddon.magicsaddonmod.capabilities.ModCapabilitiesX;
import online.magicksaddon.magicsaddonmod.lib.StringsX;
import online.magicksaddon.magicsaddonmod.sound.BerserkAuraSoundInstance;

public class ClientEventsX {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinLevelEvent e) {
        if (e.getEntity() instanceof LivingEntity ent) {
            if (e.getLevel().isClientSide) {
                Minecraft minecraft = Minecraft.getInstance();
                minecraft.getSoundManager().play(new BerserkAuraSoundInstance(ent));

				IPlayerCapabilities playerData = ModCapabilities.getPlayer(minecraft.player);

				if (playerData.getLevel() >= 1){
					playerData.addShotlockToList(MagicksAddonMod.MODID+":"+ StringsX.flameSalvo, true);
					playerData.addShotlockToList(MagicksAddonMod.MODID+":"+ StringsX.bubbleBlaster, true);
				}
				if (playerData.getLevel() >= 25){
					playerData.addShotlockToList(MagicksAddonMod.MODID+":"+ StringsX.thunderStorm, true);
					playerData.addShotlockToList(MagicksAddonMod.MODID+":"+ StringsX.bioBarrage, true);
				}
				if (playerData.getLevel() >= 50){
					playerData.addShotlockToList(MagicksAddonMod.MODID+":"+ StringsX.meteorShower, true);
				}
            }
        }
    }

    @SubscribeEvent
	public void RenderEntity(RenderLivingEvent.Pre event){
		if (event.getEntity() != null){
			if (event.getEntity() instanceof Player) {
				Player player = (Player) event.getEntity();
				IPlayerCapabilities playerData = ModCapabilities.getPlayer(player);
				IGlobalCapabilitiesX globalData = ModCapabilitiesX.getGlobal(event.getEntity());
				if (playerData != null){
					// Light and Dark Step SFX
					if(globalData.getStepTicks() > 0){
						event.setCanceled(true);
						player.invulnerableTime = globalData.getStepTicks();
						//System.out.println(globalData.getStepTicks());
						if (globalData.getStepType() == StringsX.darkStepType) {
							player.level.addAlwaysVisibleParticle(ParticleTypes.SQUID_INK, player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(0.5F,0F,0.5F),1F),player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(0.5F,0F,1F),1F),player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(0.2F,0F,0F),1F),player.getX() + player.level.random.nextDouble() - 0.55D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.55D, 0, 0, 0);
						} else if (globalData.getStepType() == StringsX.lightStepType) {
							player.level.addAlwaysVisibleParticle(ParticleTypes.END_ROD, player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(ParticleTypes.CLOUD, player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(0F,0.9F,0.9F),1F),player.getX() + player.level.random.nextDouble() - 0.5D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.5D, 0, 0, 0);
							player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(1F,1F,0.7F),1F),player.getX() + player.level.random.nextDouble() - 0.55D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.55D, 0, 0, 0);
						}
					}
				}

				// Rage Form Active and Walk particles
				if (playerData.getActiveDriveForm().equals("magicksaddon:form_rage")){
					player.level.addParticle(new DustParticleOptions(new Vector3f(0.1F,0F,0F),1F),player.getX() + player.level.random.nextDouble() - 0.55D, player.getY()+ player.level.random.nextDouble() *2D, player.getZ() + player.level.random.nextDouble() - 0.55D, 0, 0, 0);

					if (player.isOnGround()){
						player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(0.2F,0F,0F),1F),player.getX(), player.getY(), player.getZ(), 0, 0, 0);

					}
				}
			}
		}
	}
}
