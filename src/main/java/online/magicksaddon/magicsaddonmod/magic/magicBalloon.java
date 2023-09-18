package online.magicksaddon.magicsaddonmod.magic;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import online.kingdomkeys.kingdomkeys.magic.Magic;
import online.magicksaddon.magicsaddonmod.capabilities.IGlobalCapabilitiesMA;
import online.magicksaddon.magicsaddonmod.capabilities.ModCapabilitiesMA;
import online.magicksaddon.magicsaddonmod.client.sound.MagicSounds;
import online.magicksaddon.magicsaddonmod.entity.magic.BalloonEntity;
import online.magicksaddon.magicsaddonmod.entity.magic.BalloongaEntity;

public class magicBalloon extends Magic {

	public magicBalloon(ResourceLocation registryName, boolean hasToSelect, int maxLevel, int order) {
		super(registryName, hasToSelect, maxLevel, null, order);
	}

	@Override
	protected void magicUse(Player player, Player caster, int level, float fullMPBlastMult) {
		float dmgMult = getDamageMult(level) * 1F;
		caster.swing(InteractionHand.MAIN_HAND);

		// Levels
		// ThrowableProjectile balloon = new BalloonEntity(player.level, player,
		// dmgMult);
		player.level.playSound(null, player.blockPosition(), MagicSounds.BALLOON.get(), SoundSource.PLAYERS, 1F, 1F);
    	//System.out.println(player.level.isClientSide);

		switch(level) {
		case 0:
			for (int i = -45; i <= 45; i += 45) {
				ThrowableProjectile balloon = new BalloonEntity(player.level, player, dmgMult);
				player.level.addFreshEntity(balloon);
				balloon.shootFromRotation(player, player.getXRot(), player.getYRot() + i, 0, 0.5F, 0);
			}
			break;
		case 1:
			for (int i = -90; i <= 90; i += 45) {
				ThrowableProjectile balloonra = new BalloonEntity(player.level, player, dmgMult);
				player.level.addFreshEntity(balloonra);
				balloonra.shootFromRotation(player, player.getXRot(), player.getYRot() + i, 0, 0.5F, 0);
			}
			break;
		case 2:
			ThrowableProjectile balloonga = new BalloongaEntity(player.level, player, dmgMult);
			player.level.addFreshEntity(balloonga);
			balloonga.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 0.5F, 0);
			break;
		}
	}
}