package hibernate.dao;

/**
 * BomMaterial entity. @author MyEclipse Persistence Tools
 */

public class BomMaterial implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer parentId;
	private Integer itemId;
	private Integer quantity;
	private Integer RId;

	// Constructors

	/** default constructor */
	public BomMaterial()
	{
	}

	/** minimal constructor */
	public BomMaterial(Integer parentId, Integer itemId, Integer quantity)
	{
		this.parentId = parentId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	/** full constructor */
	public BomMaterial(Integer parentId, Integer itemId, Integer quantity, Integer RId)
	{
		this.parentId = parentId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.RId = RId;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getParentId()
	{
		return this.parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public Integer getItemId()
	{
		return this.itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
	}

	public Integer getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public Integer getRId()
	{
		return this.RId;
	}

	public void setRId(Integer RId)
	{
		this.RId = RId;
	}

	private Bom parent;
	private Bom item;

	public Bom getParent()
	{
		return parent;
	}

	public void setParent(Bom parent)
	{
		this.parent = parent;
	}

	public Bom getItem()
	{
		return item;
	}

	public void setItem(Bom item)
	{
		this.item = item;
	}

}