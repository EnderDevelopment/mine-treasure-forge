package com.example.optreasure.content;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.core.registries.BuiltInRegistries;

public final class TreasureGenerator {
    private TreasureGenerator() {
    }

    public static void fill(ItemStackHandler inventory) {
        int[][] armor = {{15}, {15}, {15}, {15}};
        add(inventory, 0, enchanted(Items.NETHERITE_HELMET, 1, true, new String[][] {
                {"minecraft:protection", "15"}, {"minecraft:fire_protection", "15"},
                {"minecraft:blast_protection", "15"}, {"minecraft:projectile_protection", "15"},
                {"minecraft:respiration", "10"}, {"minecraft:aqua_affinity", "1"},
                {"minecraft:unbreaking", "10"}, {"minecraft:mending", "1"}}));
        add(inventory, 1, enchanted(Items.NETHERITE_CHESTPLATE, 1, true, armorEnchantments()));
        add(inventory, 2, enchanted(Items.NETHERITE_LEGGINGS, 1, true, armorEnchantments()));
        add(inventory, 3, enchanted(Items.NETHERITE_BOOTS, 1, true, new String[][] {
                {"minecraft:protection", "15"}, {"minecraft:fire_protection", "15"},
                {"minecraft:blast_protection", "15"}, {"minecraft:projectile_protection", "15"},
                {"minecraft:feather_falling", "15"}, {"minecraft:depth_strider", "10"},
                {"minecraft:soul_speed", "10"}, {"minecraft:unbreaking", "10"}, {"minecraft:mending", "1"}}));
        add(inventory, 4, enchanted(Items.NETHERITE_SWORD, 1, true, new String[][] {
                {"minecraft:sharpness", "80"}, {"minecraft:fire_aspect", "10"},
                {"minecraft:looting", "10"}, {"minecraft:sweeping", "10"},
                {"minecraft:knockback", "10"}, {"minecraft:unbreaking", "10"}, {"minecraft:mending", "1"}}));
        add(inventory, 5, potion(MobEffects.DAMAGE_BOOST, 40, 72000));
        add(inventory, 6, potion(MobEffects.REGENERATION, 10, 72000));
        add(inventory, 7, potion(MobEffects.MOVEMENT_SPEED, 10, 72000));
        add(inventory, 8, stack(Items.SHULKER_BOX, 64));
        add(inventory, 9, stack(Items.NETHERITE_BLOCK, 64));
        add(inventory, 10, stack(Items.SHULKER_SHELL, 64));
        addOptional(inventory, 11, "allthemodium:vibranium_block", 64);
        addOptional(inventory, 12, "allthemodium:unobtainium_block", 64);
        addOptional(inventory, 13, "allthemodium:allthemodium_block", 64);
        addOptional(inventory, 14, "apotheosis:gem", 64);
        addOptional(inventory, 15, "apotheosis:prismatic_gem", 64);
        addOptional(inventory, 16, "apotheosis:gem_dust", 64);
    }

    private static String[][] armorEnchantments() {
        return new String[][] {{"minecraft:protection", "15"}, {"minecraft:fire_protection", "15"},
                {"minecraft:blast_protection", "15"}, {"minecraft:projectile_protection", "15"},
                {"minecraft:unbreaking", "10"}, {"minecraft:mending", "1"}};
    }

    private static ItemStack enchanted(Item item, int count, boolean unbreakable, String[][] enchantments) {
        ItemStack stack = new ItemStack(item, count);
        CompoundTag tag = stack.getOrCreateTag();
        if (unbreakable) tag.putBoolean("Unbreakable", true);
        ListTag list = new ListTag();
        for (String[] enchantment : enchantments) {
            CompoundTag entry = new CompoundTag();
            entry.putString("id", enchantment[0]);
            entry.putShort("lvl", Short.parseShort(enchantment[1]));
            list.add(entry);
        }
        tag.put("Enchantments", list);
        return stack;
    }

    private static ItemStack potion(MobEffect effect, int amplifier, int duration) {
        ItemStack stack = new ItemStack(Items.POTION, 1);
        PotionUtils.setCustomEffects(stack, java.util.List.of(new MobEffectInstance(effect, duration, amplifier - 1)));
        return stack;
    }

    private static ItemStack stack(Item item, int count) {
        return new ItemStack(item, count);
    }

    private static void add(ItemStackHandler inventory, int slot, ItemStack stack) {
        inventory.setStackInSlot(slot, stack);
    }

    private static void addOptional(ItemStackHandler inventory, int slot, String id, int count) {
        Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(id));
        if (item != Items.AIR) add(inventory, slot, new ItemStack(item, count));
    }
}
