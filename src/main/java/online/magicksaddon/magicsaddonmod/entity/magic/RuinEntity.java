package online.magicksaddon.magicsaddonmod.entity.magic;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.entity.magic.MagnetEntity;
import online.kingdomkeys.kingdomkeys.lib.DamageCalculation;
import online.kingdomkeys.kingdomkeys.lib.Party;
import online.magicksaddon.magicsaddonmod.entity.ModEntitiesMA;
import online.kingdomkeys.kingdomkeys.damagesource.DarknessDamageSource;

public class RuinEntity extends ThrowableProjectile {

    // Start
    int maxTicks = 100;
    float dmgMult = 1;

    public RuinEntity(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        this.blocksBuilding = true;
    }

    public RuinEntity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        super(ModEntitiesMA.TYPE_RUIN.get(), world);
    }

    public RuinEntity(Level world) {
        super(ModEntitiesMA.TYPE_RUIN.get(), world);
        this.blocksBuilding = true;
    }

    public RuinEntity(Level world, LivingEntity player, float dmgMult) {
        super(ModEntitiesMA.TYPE_RUIN.get(), player, world);
        this.dmgMult = dmgMult;
    }

    private void ruinExplode(){
        float explosionSize = 2.0F;
        this.level.explode(this, this.blockPosition().getX(), this.blockPosition().getY() + (double)(this.getBbHeight() / 1.0F), this.blockPosition().getZ(), explosionSize, false, Explosion.BlockInteraction.NONE);
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return (Packet<ClientGamePacketListener>) NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getGravity() {
        return 0F;
    }

    @Override
    public void tick() {
        if (this.tickCount > maxTicks) {
            this.remove(RemovalReason.KILLED);
        }

        //world.addParticle(ParticleTypes.ENTITY_EFFECT, getPosX(), getPosY(), getPosZ(), 1, 1, 0);
        if(tickCount > 2)
            level.addParticle(ParticleTypes.SQUID_INK, getX(), getY(), getZ(), 0, 0, 0);

        super.tick();
    }

    @Override
    protected void onHit(HitResult rtRes) {
        if (!level.isClientSide && getOwner() != null) {
            EntityHitResult ertResult = null;
            BlockHitResult brtResult = null;

            if (rtRes instanceof EntityHitResult) {
                ertResult = (EntityHitResult) rtRes;
            }

            if (rtRes instanceof BlockHitResult) {
                brtResult = (BlockHitResult) rtRes;
            }

            if (ertResult != null && ertResult.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) ertResult.getEntity();

                if (target != getOwner()) {
                    Party p = null;
                    if (getOwner() != null) {
                        p = ModCapabilities.getWorld(getOwner().level).getPartyFromMember(getOwner().getUUID());
                    }
                    if(p == null || (p.getMember(target.getUUID()) == null || p.getFriendlyFire())) { //If caster is not in a party || the party doesn't have the target in it || the party has FF on
                        float dmg = this.getOwner() instanceof Player ? DamageCalculation.getMagicDamage((Player) this.getOwner()) * 0.2F : 2;
                        float explosionSize = 2.0F;
                        this.level.explode(this, this.blockPosition().getX(), this.blockPosition().getY() + (double)(this.getBbHeight() / 16.0F), this.blockPosition().getZ(), explosionSize, false,Explosion.BlockInteraction.NONE );
                        target.invulnerableTime = 0;
                        target.hurt(DarknessDamageSource.getDarknessDamage(this, this.getOwner()), dmg * dmgMult);


                    }
                }
            }

            if (brtResult != null) {
                float explosionSize = 2.0F;
                this.level.explode(this, this.blockPosition().getX(), this.blockPosition().getY() + (double)(this.getBbHeight() / 16.0F), this.blockPosition().getZ(), explosionSize, false,Explosion.BlockInteraction.NONE );
                remove(RemovalReason.KILLED);
                }
            }

        }

    public int getMaxTicks() {
        return maxTicks;
    }

    public void setMaxTicks(int maxTicks) {
        this.maxTicks = maxTicks;
    }



    @Override
    protected void defineSynchedData() {
        // TODO Auto-generated method stub

    }
}