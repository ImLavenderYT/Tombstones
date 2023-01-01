package io.github.imlavenderyt.tombstones.common.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class HeadstoneBlock extends HorizontalFacingBlock {
	public static final DirectionProperty FACING;
	public static final VoxelShape FRONT_SHAPE;
	public static final VoxelShape SIDE_SHAPE;
	public static final VoxelShape DEBUG_SHAPE;


	public HeadstoneBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return switch (state.get(FACING).ordinal()) {
			case 2 -> FRONT_SHAPE; // North
			case 3 -> FRONT_SHAPE; // South
			case 4 -> SIDE_SHAPE; // West
			case 5 -> SIDE_SHAPE; // East
			default -> DEBUG_SHAPE;
		};
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	static {
		FRONT_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 6.0D, 15.0D, 16.0D, 10.0D);
		SIDE_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 1.0D, 10.0D, 16.0D, 15.0D);
		DEBUG_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
		FACING = HorizontalFacingBlock.FACING;
	}

}
