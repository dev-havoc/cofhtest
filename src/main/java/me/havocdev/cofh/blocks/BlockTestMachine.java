package me.havocdev.cofh.blocks;

import me.havocdev.cofh.CofhTest;
import me.havocdev.cofh.tileentities.TileEntityGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockTestMachine extends BlockContainer{
	public IIcon[] icons = new IIcon[6];
    @SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
	
	public BlockTestMachine()
	{
		super(Material.rock);
	}
	
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGenerator();
	}
	
	/** Gets the player placing the block and rotates it according to their facing direction **/
	@Override
	 public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
	    {
	        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
	        }

	        if (l == 1)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
	        }

	        if (l == 2)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
	        }

	        if (l == 3)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
	        }

	        if (p_149689_6_.hasDisplayName())
	        {
	            ((TileEntityFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
	        }
	    }
	
	/** Gets and registers icons for the block **/
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149935_N : (p_149691_1_ == 0 ? this.field_149935_N : (p_149691_1_ != p_149691_2_ ? this.blockIcon : this.field_149936_O));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(CofhTest.modid+":test_generator_block_sides");
        this.field_149936_O = p_149651_1_.registerIcon(CofhTest.modid+":test_generator_block_front");
        this.field_149935_N = p_149651_1_.registerIcon(CofhTest.modid+":test_generator_block_sides");
    }
    
}
