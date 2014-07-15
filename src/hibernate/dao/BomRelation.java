package hibernate.dao;

/**
 * BomRelation entity. @author MyEclipse Persistence Tools
 */

public class BomRelation implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer parentId;
	private Integer itemId;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public BomRelation()
	{
	}

	/** full constructor */
	public BomRelation(Integer parentId, Integer itemId, Integer quantity, Bom parent, Bom item)
	{
		this.parentId = parentId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.parent = parent;
		this.item = item;
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

	private Bom parent;
	private Bom item;

	public Bom getItem()
	{
		return item;
	}

	public void setItem(Bom item)
	{
		this.item = item;
	}

	public Bom getParent()
	{
		return parent;
	}

	public void setParent(Bom parent)
	{
		this.parent = parent;
	}

}