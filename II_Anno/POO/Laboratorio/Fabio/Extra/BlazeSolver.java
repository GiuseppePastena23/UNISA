/* Decompiler 95ms, total 383ms, lines 199 */
package gg.skytils.skytilsmod.features.impl.dungeons.solvers;

import gg.essential.universal.UMatrixStack;
import gg.skytils.skytilsmod.Skytils;
import gg.skytils.skytilsmod.core.TickTask;
import gg.skytils.skytilsmod.utils.RenderUtil;
import gg.skytils.skytilsmod.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.world.WorldEvent.Load;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 7, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006$"},
   d2 = {"Lgg/skytils/skytilsmod/features/impl/dungeons/solvers/BlazeSolver;", "", "()V", "blazeChest", "Lnet/minecraft/util/BlockPos;", "getBlazeChest", "()Lnet/minecraft/util/BlockPos;", "setBlazeChest", "(Lnet/minecraft/util/BlockPos;)V", "blazeMode", "", "getBlazeMode", "()I", "setBlazeMode", "(I)V", "impossible", "", "getImpossible", "()Z", "setImpossible", "(Z)V", "orderedBlazes", "Ljava/util/ArrayList;", "Lgg/skytils/skytilsmod/features/impl/dungeons/solvers/BlazeSolver$ShootableBlaze;", "Lkotlin/collections/ArrayList;", "getOrderedBlazes", "()Ljava/util/ArrayList;", "setOrderedBlazes", "(Ljava/util/ArrayList;)V", "onWorldChange", "", "event", "Lnet/minecraftforge/event/world/WorldEvent$Load;", "onWorldRender", "Lnet/minecraftforge/client/event/RenderWorldLastEvent;", "ShootableBlaze", "SkytilsMod"}
)
public final class BlazeSolver {
   @NotNull
   public static final BlazeSolver INSTANCE = new BlazeSolver();
   @NotNull
   private static ArrayList<BlazeSolver.ShootableBlaze> orderedBlazes = new ArrayList();
   private static int blazeMode;
   @Nullable
   private static BlockPos blazeChest;
   private static boolean impossible;

   private BlazeSolver() {
   }

   @NotNull
   public final ArrayList<BlazeSolver.ShootableBlaze> getOrderedBlazes() {
      return orderedBlazes;
   }

   public final void setOrderedBlazes(@NotNull ArrayList<BlazeSolver.ShootableBlaze> <set-?>) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      orderedBlazes = var1;
   }

   public final int getBlazeMode() {
      return blazeMode;
   }

   public final void setBlazeMode(int <set-?>) {
      blazeMode = var1;
   }

   @Nullable
   public final BlockPos getBlazeChest() {
      return blazeChest;
   }

   public final void setBlazeChest(@Nullable BlockPos <set-?>) {
      blazeChest = var1;
   }

   public final boolean getImpossible() {
      return impossible;
   }

   public final void setImpossible(boolean <set-?>) {
      impossible = var1;
   }

   @SubscribeEvent
   public final void onWorldRender(@NotNull RenderWorldLastEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Skytils.Companion.getConfig().getBlazeSolver() && Utils.INSTANCE.getInDungeons() && orderedBlazes.size() > 0) {
         UMatrixStack matrixStack = new UMatrixStack();
         BlazeSolver.ShootableBlaze shootableBlaze;
         EntityBlaze highestBlaze;
         if (blazeMode < 0) {
            shootableBlaze = (BlazeSolver.ShootableBlaze)CollectionsKt.first((List)orderedBlazes);
            highestBlaze = shootableBlaze.blaze;
            RenderUtil.drawLabel$default(RenderUtil.INSTANCE, new Vec3(highestBlaze.field_70165_t, highestBlaze.field_70163_u + (double)3, highestBlaze.field_70161_v), "§lSmallest", Skytils.Companion.getConfig().getLowestBlazeColor(), event.partialTicks, matrixStack, false, 0.0F, 96, (Object)null);
         }

         if (blazeMode > 0) {
            shootableBlaze = (BlazeSolver.ShootableBlaze)CollectionsKt.last((List)orderedBlazes);
            highestBlaze = shootableBlaze.blaze;
            RenderUtil.drawLabel$default(RenderUtil.INSTANCE, new Vec3(highestBlaze.field_70165_t, highestBlaze.field_70163_u + (double)3, highestBlaze.field_70161_v), "§lBiggest", Skytils.Companion.getConfig().getHighestBlazeColor(), event.partialTicks, matrixStack, false, 0.0F, 96, (Object)null);
         }
      }

   }

   @SubscribeEvent
   public final void onWorldChange(@NotNull Load event) {
      Intrinsics.checkNotNullParameter(event, "event");
      orderedBlazes.clear();
      blazeMode = 0;
      blazeChest = null;
      impossible = false;
   }

   static {
      new TickTask(20, true, false, (Function0)null.INSTANCE, 4, (DefaultConstructorMarker)null);
      new TickTask(4, true, false, (Function0)null.INSTANCE, 4, (DefaultConstructorMarker)null);
   }

   @Metadata(
      mv = {1, 7, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"},
      d2 = {"Lgg/skytils/skytilsmod/features/impl/dungeons/solvers/BlazeSolver$ShootableBlaze;", "", "blaze", "Lnet/minecraft/entity/monster/EntityBlaze;", "health", "", "(Lnet/minecraft/entity/monster/EntityBlaze;I)V", "getHealth", "()I", "setHealth", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "SkytilsMod"}
   )
   public static final class ShootableBlaze {
      @JvmField
      @NotNull
      public EntityBlaze blaze;
      private int health;

      public ShootableBlaze(@NotNull EntityBlaze blaze, int health) {
         Intrinsics.checkNotNullParameter(blaze, "blaze");
         super();
         this.blaze = blaze;
         this.health = health;
      }

      public final int getHealth() {
         return this.health;
      }

      public final void setHealth(int <set-?>) {
         this.health = var1;
      }

      @NotNull
      public final EntityBlaze component1() {
         return this.blaze;
      }

      public final int component2() {
         return this.health;
      }

      @NotNull
      public final BlazeSolver.ShootableBlaze copy(@NotNull EntityBlaze blaze, int health) {
         Intrinsics.checkNotNullParameter(blaze, "blaze");
         return new BlazeSolver.ShootableBlaze(blaze, health);
      }

      // $FF: synthetic method
      public static BlazeSolver.ShootableBlaze copy$default(BlazeSolver.ShootableBlaze var0, EntityBlaze var1, int var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.blaze;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.health;
         }

         return var0.copy(var1, var2);
      }

      @NotNull
      public String toString() {
         return "ShootableBlaze(blaze=" + this.blaze + ", health=" + this.health + ')';
      }

      public int hashCode() {
         int result = this.blaze.hashCode();
         result = result * 31 + Integer.hashCode(this.health);
         return result;
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof BlazeSolver.ShootableBlaze)) {
            return false;
         } else {
            BlazeSolver.ShootableBlaze var2 = (BlazeSolver.ShootableBlaze)other;
            if (!Intrinsics.areEqual(this.blaze, var2.blaze)) {
               return false;
            } else {
               return this.health == var2.health;
            }
         }
      }
   }
}
