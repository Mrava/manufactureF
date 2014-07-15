package hibernate.dao;

/**
 * BillType entity. @author MyEclipse Persistence Tools
 */

public class BillType implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private Integer stock;
	private String remark;

	// Constructors

	/** default constructor */
	public BillType()
	{
	}

	/** full constructor */
	public BillType(String name, Integer stock, String remark)
	{
		this.name = name;
		this.stock = stock;
		this.remark = remark;
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

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getStock()
	{
		return this.stock;
	}

	public void setStock(Integer stock)
	{
		this.stock = stock;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

}