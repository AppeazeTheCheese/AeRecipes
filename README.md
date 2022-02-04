# AeRecipes
This plugin is an extension of the [AdvancedEnchantments](https://advancedplugins.net/item/AdvancedEnchantments.1) plugin.

<h3>Features:</h3>
<ul>
  <li>Adds recipes for: </li>
  <ul>
    <li>EXP Bottles</li>
    <li>Black Scrolls (25%, 50%, 75% and 100%)</li>
    <li>White Scrolls</li>
    <li>Slot Increasers</li>
    <li>Soul Trackers</li>
  </ul>
  <li>Split soul gems</li>
  <li>Combine soul gems</li>
  <li>Move souls from an item to a soul gem (at a cost)</li>
</ul>

<h3>Commands:</h3>
<ul>
  <li><code>/combine</code>: Combines all soul gems in the player's inventory into the least amount possible. The max amount of souls in a single soul gem is defined in [Constants.java](https://github.com/jumanjicraftprojects/AeRecipes/blob/master/src/main/java/com/appeazethecheese/aerecipes/Constants.java)</li>
  <li><code>/split {amount}</code>: Splits the soul gem in the player's hand into two. The new gem will have the amount of souls specified in the command. The minimum number of souls in a single soul gem is defined in [Constants.java](https://github.com/jumanjicraftprojects/AeRecipes/blob/master/src/main/java/com/appeazethecheese/aerecipes/Constants.java</li>
  <li><code>/drain {amount}</code>: Removes souls from the item in the player's hand and creates the minimum amount of soul gems required to store the amount of souls specified after the soul tax is applied. The soul tax, minimum amount of souls in a gem, and maximum amount of souls in a gem are defined in [Constants.java](https://github.com/jumanjicraftprojects/AeRecipes/blob/master/src/main/java/com/appeazethecheese/aerecipes/Constants.java</li>
</ul>
