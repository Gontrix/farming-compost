package de.gontrix.farmingcompost.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class CompostBlock extends Block {
    public static final String NAME = "compost";
    private static VoxelShape SHAPE = Stream.of(
            Block.box(1.5, 0, 1.5, 14.5, 16, 14.5),
            Block.box(1, 1, 13, 3, 16, 15),
            Block.box(13, 1, 13, 15, 16, 15),
            Block.box(1, 1, 1, 3, 16, 3),
            Block.box(13, 1, 1, 15, 16, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public CompostBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                .randomTicks()
                .strength(2.0F)
                .sound(SoundType.METAL)
        );
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }

}
