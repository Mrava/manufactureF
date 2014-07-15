package hibernate.dao;

import java.util.Date;

/**
 * MakePlan entity. @author MyEclipse Persistence Tools
 */

public class MakePlan implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer indexId;
	private Integer bomId;
	private Integer quantity;
	private Date tdate;

	// Constructors

	/** default constructor */
	public MakePlan()
	{
	}

	/** minimal constructor */
	public MakePlan(Integer bomId, Integer quantity, Date tdate)
	{
		this.bomId = bomId;
		this.quantity = quantity;
		this.tdate = tdate;
	}

	/** full constructor */
	public MakePlan(Integer indexId, Integer bomId, Integer quantity, Date tdate)
	{
		this.indexId = indexId;
		this.bomId = bomId;
		this.quantity = quantity;
		this.tdate = tdate;
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

	public Date getTdate()
	{
		return this.tdate;
	}

	public void setTdate(Date tdate)
	{
		this.tdate = tdate;
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