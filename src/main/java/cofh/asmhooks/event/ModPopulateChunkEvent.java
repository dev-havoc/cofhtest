package cofh.asmhooks.event;

import cpw.mods.fml.common.eventhandler.Event;

import net.minecraft.world.World;

public class ModPopulateChunkEvent extends Event {

	public final World world;
	public final int chunkX;
	public final int chunkZ;

	public ModPopulateChunkEvent(World world, int chunkX, int chunkZ) {

		super();
		this.world = world;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
	}

	public static class Pre extends ModPopulateChunkEvent {

		public Pre(World world, int chunkX, int chunkZ) {

			super(world, chunkX, chunkZ);
		}
	}

	public static class Post extends ModPopulateChunkEvent {

		public Post(World world, int chunkX, int chunkZ) {

			super(world, chunkX, chunkZ);
		}
	}

}
