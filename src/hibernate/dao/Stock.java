package hibernate.dao;

/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer bomId;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Stock()
	{
	}

	/** full constructor */
	public Stock(Integer bomId, Integer quantity)
	{
		this.bomId = bomId;
		this.quantity = quantity;
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

	public Integer getBomId()
	{
		return this.bomId;
	}

	public void setBomId(Integer bomId)
	{
		this.bomId = bomId;
	}

	public Integer getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	private Bom bom;

	public Bom getBom()
	{
		return bom;
	}

	public void setBom(Bom bom)
	{
		this.bom = bom;
	}
	
}