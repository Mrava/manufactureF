package hibernate.dao;

/**
 * MakeMaterial entity. @author MyEclipse Persistence Tools
 */

public class MakeMaterial implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer indexId;
	private Integer bomId;
	private Integer quantity;
	private Integer unit;

	// Constructors

	/** default constructor */
	public MakeMaterial()
	{
	}

	/** full constructor */
	public MakeMaterial(Integer indexId, Integer bomId, Integer quantity, Integer unit)
	{
		this.indexId = indexId;
		this.bomId = bomId;
		this.quantity = quantity;
		this.unit = unit;
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

	public Integer getIndexId()
	{
		return this.indexId;
	}

	public void setIndexId(Integer indexId)
	{
		this.indexId = indexId;
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

	public Integer getUnit()
	{
		return this.unit;
	}

	public void setUnit(Integer unit)
	{
		this.unit = unit;
	}
	
	private Bom bom;
	private MakePlan plan;
	
	public Integer getPlanUnit()
	{
		return unit * plan.getQuantity();
	}
	
	public MakePlan getPlan()
	{
		return plan;
	}

	public void setPlan(MakePlan plan)
	{
		this.plan = plan;
	}

	public Bom getBom()
	{
		return bom;
	}

	public void setBom(Bom bom)
	{
		this.bom = bom;
	}
	

}