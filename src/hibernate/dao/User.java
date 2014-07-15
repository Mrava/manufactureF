package hibernate.dao;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String remark;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** minimal constructor */
	public User(String username)
	{
		this.username = username;
	}

	/** full constructor */
	public User(String username, String password, String remark, Integer typeId)
	{
		this.username = username;
		this.password = password;
		this.remark = remark;
		this.typeId = typeId;
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

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

}