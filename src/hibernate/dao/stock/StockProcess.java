package hibernate.dao.stock;

import java.util.Date;

/**
 * StockProcessId entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class StockProcess implements java.io.Serializable
{

	// Fields
	private Integer idx;
	private Integer itemId;
	private Double buying;
	private Double making;
	private Double taking;
	private Date tdate;

	// Constructors

	/** default constructor */
	public StockProcess()
	{
	}

	
	// Property accessors

	public Integer getIdx()
	{
		return idx;
	}

	public void setIdx(Integer idx)
	{
		this.idx = idx;
	}

	public Integer getItemId()
	{
		return this.itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
	}

	public Double getBuying()
	{
		return buying;
	}


	public void setBuying(Double buying)
	{
		this.buying = buying;
	}


	public Double getMaking()
	{
		return making;
	}


	public void setMaking(Double making)
	{
		this.making = making;
	}


	public Double getTaking()
	{
		return taking;
	}


	public void setTaking(Double taking)
	{
		this.taking = taking;
	}


	public Date getTdate()
	{
		return this.tdate;
	}

	public void setTdate(Date tdate)
	{
		this.tdate = tdate;
	}

}