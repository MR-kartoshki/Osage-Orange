package mrkartoshki.osageorange.entity.projectile;

import mrkartoshki.osageorange.entity.ModEntities;
import mrkartoshki.osageorange.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class HedgeAppleProjectileEntity extends ThrowableItemProjectile {
	private static final float DAMAGE = 5.0F;

	public HedgeAppleProjectileEntity(EntityType<? extends HedgeAppleProjectileEntity> entityType, Level level) {
		super(entityType, level);
	}

	public HedgeAppleProjectileEntity(Level level, LivingEntity owner, ItemStack stack) {
		super(ModEntities.HEDGE_APPLE_PROJECTILE, owner, level, stack);
	}

	public HedgeAppleProjectileEntity(Level level, double x, double y, double z, ItemStack stack) {
		super(ModEntities.HEDGE_APPLE_PROJECTILE, x, y, z, level, stack);
	}

	@Override
	protected Item getDefaultItem() {
		return ModItems.HEDGE_APPLE;
	}

	@Override
	protected void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		entityHitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), DAMAGE);
	}

	@Override
	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level().isClientSide()) {
			this.level().broadcastEntityEvent(this, (byte) 3);
			this.discard();
		}
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			ItemStack itemStack = this.getItem();
			for (int i = 0; i < 8; i++) {
				this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
			}
			return;
		}
		super.handleEntityEvent(id);
	}
}
