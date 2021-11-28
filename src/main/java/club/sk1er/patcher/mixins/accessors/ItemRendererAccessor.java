package club.sk1er.patcher.mixins.accessors;

//#if MC==10809
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderer.class)
public interface ItemRendererAccessor {
    @Accessor
    ItemStack getItemToRender();
}
//#endif
