package hibernate.dao;

/**
 * Bom entity. @author MyEclipse Persistence Tools
 */

public class Bom implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String remark;
	private String numero;
	private Integer typeId;
	private String sort;

	// Constructors

	/** default constructor */
	public Bom()
	{
	}

	/** minimal constructor */
	public Bom(String code)
	{
		this.code = code;
	}

	/** full constructor */
	public Bom(String code, String name, String remark, String numero, Integer typeId, String sort)
	{
		this.code = code;
		this.name = name;
		this.remark = remark;
		this.numero = numero;
		this.typeId = typeId;
		this.sort = sort;
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

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
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

	public String getNumero()
	{
		return this.numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public Integer getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

	public String getSort()
	{
		return this.sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	private BomType type;

	public BomType getType()
	{
		return type;
	}

	public void setType(BomType type)
	{
		this.type = type;
	}

}