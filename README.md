# Cooking & farming

## Mechanics

- Get recipes by looting structures or fishing
- Food can give you effects
- use different utensils to cook (cauldron to simmer), iron plate for cooking

## Added items

### Ingredients

#### Fruit

- olives
- peppers
- bananas
- prickly pear
- cherries
- orange
- strawberries
- dragon fruit
- pineapple
- coconut
- lemon

#### Mushroom

- sulphur shelf
- lion's mane
- enoki
- truffles

#### Berries

- blueberries
- grapes

#### Veg

- broccoli
- onions
- garlic
- tomatoes
- sugar beet

#### Grain
- Rice
- Corn
- 

#### product

- butter
- chocolate
- sunflower oil

### Tools

- sickle (more crop drop, right-click harvest)
- cutlery knife (cut things like diced onions)

### Blocks

- plow
- cooking plate
- brewery (wine, beer, met, vodka)
- mill (flour, sugar)
- Fermentation bottle

# Program info
The build up of the mod is achived by following [this guide by Kaupenjoe](https://youtu.be/TPfNvwfgXAU).

## Data gen

### Recipes
To create recipes, go to file [ModRecipeProvider](./src/main/java/net/robin/foodplus/datagen/ModRecipeProvider.java)

#### Shaped recipes
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.{Block/Item to craft}.get())
        .pattern("KKK")
        .pattern("KCK")
        .pattern("KFK")
        .define('K', Items.COPPER_INGOT)
        .define('C', ItemTags.PLANKS)
        .define('F', Items.CAMPFIRE)
        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
        .save(pWriter);

#### Shapeless recipe
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.{Block/Item to craft}, {count})
        .requires({Ingredient})
        .unlockedBy(getHasName({item to get}), has({item to get}))
        .save(pWriter);