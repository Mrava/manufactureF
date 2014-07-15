package hibernate.dao;

/**
 * Provider entity. @author MyEclipse Persistence Tools
 */

public class Provider implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String remark;

	// Constructors

	/** default constructor */
	public Provider()
	{
	}

	/** full constructor */
	public Provider(String name, String remark)
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