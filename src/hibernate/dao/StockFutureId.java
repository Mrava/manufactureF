package hibernate.dao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * StockFutureId entity. @author MyEclipse Persistence Tools
 */

public class StockFutureId implements java.io.Serializable
{

	// Fields

	private Integer bomId;
	private BigDecimal extant;
	private BigDecimal make;
	private BigDecimal bought;
	private BigDecimal used;
	private Date tdate;
	private Integer stockType;

	// Constructors

	/** default constructor */
	public StockFutureId()
	{
	}

	/** full constructor */
	public StockFutureId(Integer bomId, BigDecimal extant, BigDecimal make, BigDecimal bought, BigDecimal used,
			Date tdate, Integer stockType)
	{
		this.bomId = bomId;
		this.extant = extant;
		this.make = make;
		this.bought = bought;
		this.used = used;
		this.tdate = tdate;
		this.stockType = stockType;
	}

	// Property accessors

	public Integer getBomId()
	{
		return this.bomId;
	}

	public void setBomId(Integer bomId)
	{
		this.bomId = bomId;
	}

	public BigDecimal getExtant()
	{
		return this.extant;
	}

	public void setExtant(BigDecimal extant)
	{
		this.extant = extant;
	}

	public BigDecimal getMake()
	{
		return this.make;
	}

	public void setMake(BigDecimal make)
	{
		this.make = make;
	}

	public BigDecimal getBought()
	{
		return this.bought;
	}

	public void setBought(BigDecimal bought)
	{
		this.bought = bought;
	}

	public BigDecimal getUsed()
	{
		return this.used;
	}

	public void setUsed(BigDecimal used)
	{
		this.used = used;
	}

	public Date getTdate()
	{
		return this.tdate;
	}

	public void setTdate(Date tdate)
	{
		this.tdate = tdate;
	}

	public Integer getStockType()
	{
		return this.stockType;
	}

	public void setStockType(Integer stockType)
	{
		this.stockType = stockType;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockFutureId))
			return false;
		StockFutureId castOther = (StockFutureId) other;

		return ((this.getBomId() == castOther.getBomId()) || (this.getBomId() != null && castOther.getBomId() != null && this
				.getBomId().equals(castOther.getBomId())))
				&& ((this.getExtant() == castOther.getExtant()) || (this.getExtant() != null
						&& castOther.getExtant() != null && this.getExtant().equals(castOther.getExtant())))
				&& ((this.getMake() == castOther.getMake()) || (this.getMake() != null && castOther.getMake() != null && this
						.getMake().equals(castOther.getMake())))
				&& ((this.getBought() == castOther.getBought()) || (this.getBought() != null
						&& castOther.getBought() != null && this.getBought().equals(castOther.getBought())))
				&& ((this.getUsed() == castOther.getUsed()) || (this.getUsed() != null && castOther.getUsed() != null && this
						.getUsed().equals(castOther.getUsed())))
				&& ((this.getTdate() == castOther.getTdate()) || (this.getTdate() != null
						&& castOther.getTdate() != null && this.getTdate().equals(castOther.getTdate())))
				&& ((this.getStockType() == castOther.getStockType()) || (this.getStockType() != null
						&& castOther.getStockType() != null && this.getStockType().equals(castOther.getStockType())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getBomId() == null ? 0 : this.getBomId().hashCode());
		result = 37 * result + (getExtant() == null ? 0 : this.getExtant().hashCode());
		result = 37 * result + (getMake() == null ? 0 : this.getMake().hashCode());
		result = 37 * result + (getBought() == null ? 0 : this.getBought().hashCode());
		result = 37 * result + (getUsed() == null ? 0 : this.getUsed().hashCode());
		result = 37 * result + (getTdate() == null ? 0 : this.getTdate().hashCode());
		result = 37 * result + (getStockType() == null ? 0 : this.getStockType().hashCode());
		return result;
	}

}