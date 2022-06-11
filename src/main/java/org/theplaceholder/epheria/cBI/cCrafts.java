package org.theplaceholder.epheria.cBI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.theplaceholder.epheria.EPH;

public class cCrafts {
    public static void register(){
    addRecipe(goldenBanana());
    addRecipe(bananHat());

    addRecipe(rubyH());
    addRecipe(rubyC());
    addRecipe(rubyL());
    addRecipe(rubyB());

    overwriteVanilla("jack_o_lantern", jackLantern());
    overwriteVanilla("clay", clayBlock());
    overwriteVanilla("brick", brick());
}
    private static ShapedRecipe clayBlock(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "clay"), new ItemStack(Material.CLAY));
        recipe.shape("CC", "CC");
        recipe.setIngredient('C', new ItemStack(Material.CLAY_BALL));
        return recipe;
    }

    private static FurnaceRecipe brick(){
        FurnaceRecipe recipe = new FurnaceRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "brick"), new ItemStack(Material.BRICK), new RecipeChoice.ExactChoice(new ItemStack(Material.CLAY_BALL)), 0.3f, 1);
        return recipe;
    }
    private static ShapedRecipe goldenBanana(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "golden_banana"), cItems.goldenBanana.getItem());
        recipe.shape("GGG", "GBG", "GGG");
        recipe.setIngredient('B', cItems.banana.getItem());
        recipe.setIngredient('G', Material.GOLD_INGOT);

        return recipe;
    }

    private static ShapedRecipe bananHat(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "bananhat"), cItems.bananHat.getItem());
        recipe.shape("SBS", "S S");
        recipe.setIngredient('B', cItems.banana.getItem());
        recipe.setIngredient('S', cItems.bananaSkin.getItem());

        return recipe;
    }

    private static ShapedRecipe jackLantern(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "jack_o_lantern"), new ItemStack(Material.JACK_O_LANTERN));
        recipe.shape("P", "T");
        recipe.setIngredient('P', new ItemStack(Material.CARVED_PUMPKIN));
        recipe.setIngredient('T', new ItemStack(Material.TORCH));

        return recipe;
    }

    private static ShapedRecipe rubyH(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "ruby_helmet"), cItems.rubyHelmet.getItem());
        recipe.shape("RRR", "R R");
        recipe.setIngredient('R', cItems.ruby.getItem());

        return recipe;
    }

    private static ShapedRecipe rubyC(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "ruby_chestplate"), cItems.rubyChestplate.getItem());
        recipe.shape("R R", "RRR", "RRR");
        recipe.setIngredient('R', cItems.ruby.getItem());

        return recipe;
    }

    private static ShapedRecipe rubyL(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "ruby_leggings"), cItems.rubyLeggings.getItem());
        recipe.shape("RRR", "R R", "R R");
        recipe.setIngredient('R', cItems.ruby.getItem());

        return recipe;
    }

    private static ShapedRecipe rubyB(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(EPH.getInstance(), "ruby_boots"), cItems.rubyBoots.getItem());
        recipe.shape("R R", "R R");
        recipe.setIngredient('R', cItems.ruby.getItem());

        return recipe;
    }

    private static void overwriteVanilla(String s, ShapedRecipe sr){
        removeVanilla(s);
        addRecipe(sr);
    }
    private static void overwriteVanilla(String s, ShapelessRecipe sr){
        removeVanilla(s);
        addRecipe(sr);
    }
    private static void overwriteVanilla(String s, FurnaceRecipe r){
        removeVanilla(s);
        addRecipe(r);
    }

    private static void removeVanilla(String s){Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, s));}
    public static void addRecipe(ShapedRecipe r){Bukkit.addRecipe(r);}
    public static void addRecipe(ShapelessRecipe r){Bukkit.addRecipe(r);}
    public static void addRecipe(FurnaceRecipe r){Bukkit.addRecipe(r);}
}
