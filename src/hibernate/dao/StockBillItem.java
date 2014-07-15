package hibernate.dao;

import java.util.Date;

/**
 * StockBillItem entity. @author MyEclipse Persistence Tools
 */

public class StockBillItem implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer itemId;
	private Double quantity;
	private Integer indexId;
	private Integer relationId;
	private String remark;
	private Date tdate;
	private String client;
	private String billno;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public StockBillItem()
	{
	}

	/** full constructor */
	public StockBillItem(Integer itemId, Double quantity, Integer indexId, Integer relationId, String remark,
			Date tdate, String client, String billno, Integer typeId)
	{
		this.itemId = itemId;
		this.quantity = quantity;
		this.indexId = indexId;
		this.relationId = relationId;
		this.remark = remark;
		this.tdate = tdate;
		this.client = client;
		this.billno = billno;
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

	public Integer getItemId()
	{
		return this.itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
	}

	public Double getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Double quantity)
	{
		this.quantity = quantity;
	}

	public Integer getIndexId()
	{
		return this.indexId;
	}

	public void setIndexId(Integer indexId)
	{
		this.indexId = indexId;
	}

	public Integer getRelationId()
	{
		return this.relationId;
	}

	public void setRelationId(Integer relationId)
	{
		this.relationId = relationId;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Date getTdate()
	{
		return this.tdate;
	}

	public void setTdate(Date tdate)
	{
		this.tdate = tdate;
	}

	public String getClient()
	{
		return this.client;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

	public String getBillno()
	{
		return this.billno;
	}

	public void setBillno(String billno)
	{
		this.billno = billno;
	}

	public Integer getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

	public Bom bom;

	public Bom getBom()
	{
		return bom;
	}

	public void setBom(Bom bom)
	{
		this.bom = bom;
	}
	
}