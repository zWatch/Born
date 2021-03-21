package zwatch.mcmod.born.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "born")
public final class ItemInitializer {

    // 我们一会会用到它。
    public static Item firstItem;

    // 我们需要一个 CreativeTabs 的实例，当然那个类下面就有原版的 10 个，可以直接拿来用，
    // 但是你不觉得有一个自己的更方便吗……
    // 一般是使用匿名内部类，就像这样。
    public static final CreativeTabs EXAMPLE_CREATIVE_TAB = new CreativeTabs("born_tab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    // 和正常的事件一样，你不需要手动调用此方法！Forge 会自动调用它的。
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        // 注意 setRegistryName 调用。
        // 每一个物品都对应唯一一个注册名，用于和其他物品区分开来。这个注册名不能含有大写字母。
        // 此方法返回被注册的 Item 对象。
        firstItem = new Item();
        firstItem.setRegistryName("born", "first_item");
        firstItem.setUnlocalizedName("first_item");
        firstItem.setCreativeTab(EXAMPLE_CREATIVE_TAB);
        event.getRegistry().registerAll(firstItem);
    }

}