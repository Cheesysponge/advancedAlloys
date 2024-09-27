package name.advancedalloys.block.custom;

import name.advancedalloys.block.entity.AlloyBlasterBlockEntity;
import name.advancedalloys.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AlloyBlasterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static BooleanProperty LIT = Properties.LIT;


    public AlloyBlasterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, false));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate((mirror.getRotation(state.get(FACING))));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, LIT});
    }
    //Block Entity v

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AlloyBlasterBlockEntity) {
                ItemScatterer.spawn(world, pos, (AlloyBlasterBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyBlasterBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.ALLOY_BLASTER, AlloyBlasterBlockEntity::tick);
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        LIT = Properties.LIT;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ((Boolean)state.get(LIT)) {
            double h = random.nextDouble() * 0.1;
            double d = (double)pos.getX() + h+0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + h +0.5;

            world.addParticle(ParticleTypes.SMOKE, d - 0.5, e + 0.5, f + 0.0, -0.01, 0.0, 0.0);
            world.addParticle(ParticleTypes.FLAME, d - 0.5, e + 0.5, f + 0.0, -0.01, 0.0, 0.0);
            world.addParticle(ParticleTypes.SMOKE, d + 0.5, e + 0.5, f + 0.0, 0.01, 0.0, 0.0);
            world.addParticle(ParticleTypes.FLAME, d + 0.5, e + 0.5, f + 0.0, 0.01, 0.0, 0.0);
            world.addParticle(ParticleTypes.SMOKE, d - 0.0, e + 0.5, f - 0.5, 0.0, 0.0, -0.01);
            world.addParticle(ParticleTypes.FLAME, d - 0.0, e + 0.5, f - 0.5, 0.0, 0.0, -0.01);
            world.addParticle(ParticleTypes.SMOKE, d + 0.0, e + 0.5, f + 0.5, 0.0, 0.0, 0.01);
            world.addParticle(ParticleTypes.FLAME, d + 0.0, e + 0.5, f + 0.5, 0.0, 0.0, 0.01);
        }
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        LIT = Properties.LIT;
    }

}
