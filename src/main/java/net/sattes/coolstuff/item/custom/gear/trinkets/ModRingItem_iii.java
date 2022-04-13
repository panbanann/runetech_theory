package net.sattes.coolstuff.item.custom.gear.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import java.util.UUID;

public class ModRingItem_iii extends ModRingItem{
    public ModRingItem_iii(Settings settings) {
        super(settings);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        //processes the quality NBT (1-5) from the base ring
        float quality = 0;
        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            if (stack.getNbt().toString().contains("quality:1")) {
                quality = 0.01F;
            }
            if (stack.getNbt().toString().contains("quality:2")) {
                quality = 0.02F;
            }
            if (stack.getNbt().toString().contains("quality:3")) {
                quality = 0.03F;
            }
            if (stack.getNbt().toString().contains("quality:4")) {
                quality = 0.04F;
            }
            if (stack.getNbt().toString().contains("quality:5")) {
                quality = 0.05F;
            }
        }


        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            if (stack.getNbt().contains("topaz_3")) {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "guidemod:max_health",
                        0.07 + quality, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "guidemod:max_health",
                        6, EntityAttributeModifier.Operation.ADDITION));
            }
        }
        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            if (stack.getNbt().contains("sapphire_3")) {
                modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "guidemod:armor",
                        0.2 + quality, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "guidemod:max_health",
                        6, EntityAttributeModifier.Operation.ADDITION));
            }
        }

        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            if (stack.getNbt().contains("ruby_3")) {
                modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "guidemod:attack_damage",
                        0.07 + quality, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "guidemod:max_health",
                        6, EntityAttributeModifier.Operation.ADDITION));
            }
        }
        if (stack.hasNbt()) {
            assert stack.getNbt() != null;
            if (stack.getNbt().contains("jade_3")) {
                modifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(uuid, "guidemod:attack_speed",
                        0.07 + quality, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "guidemod:max_health",
                        6, EntityAttributeModifier.Operation.ADDITION));
            }
        }
        return modifiers;
    }}
