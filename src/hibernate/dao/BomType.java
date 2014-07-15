package hibernate.dao;

/**
 * BomType entity. @author MyEclipse Persistence Tools
 */

public class BomType implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String remark;

	// Constructors

	/** default constructor */
	public BomType()
	{
	}

	/** full constructor */
	public BomType(String name, String remark)
	{
		this.name = name;
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

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

}