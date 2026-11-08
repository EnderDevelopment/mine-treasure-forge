# Minecraft Forge Mod: Mine Treasure OP Forge

Mine Treasure OP Forge is a Minecraft Forge mod for Minecraft 1.20.1 that adds an overpowered treasure chest filled with OP items, enchanted gear, powerful potions, shulker items, netherite blocks, and optional loot from AllTheModium and Apotheosis.

## Install

1. Install Minecraft Java Edition 1.20.1.
2. Install Minecraft Forge 47.2.0 or another compatible Forge 47 build.
3. Install Java 17.
4. Build the project with:

```bash
./gradlew build
```

5. Copy the generated jar from `build/libs` into the Minecraft instance `mods` folder.
6. Install AllTheModium and Apotheosis separately if their optional items are required.
7. Launch Minecraft with the Forge profile.

## Use

1. Enter a creative world and search for `OP Treasure Chest` in the creative inventory.
2. Place the chest and open it to generate its contents.
3. Alternatively, use an operator command:

```text
/op_treasure give
```

4. Give yourself multiple chests:

```text
/op_treasure give <count>
```

5. Give a chest to another player:

```text
/op_treasure give <player> <count>
```

The command requires operator permission level 2. The chest can also be crafted with four netherite blocks, two diamond blocks, two chests, and one obsidian using the included shaped recipe.

The chest contains its generated inventory permanently, so the loot is created only the first time it is opened and is saved with the block entity.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/c1bc1721-5dfd-47bb-88a8-5b616c198278?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=c1bc1721-5dfd-47bb-88a8-5b616c198278
