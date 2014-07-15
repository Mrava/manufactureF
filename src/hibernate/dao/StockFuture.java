package hibernate.dao;

/**
 * StockFuture entity. @author MyEclipse Persistence Tools
 */

public class StockFuture implements java.io.Serializable
{

	// Fields

	private StockFutureId id;

	// Constructors

	/** default constructor */
	public StockFuture()
	{
	}

	/** full constructor */
	public StockFuture(StockFutureId id)
	{
		this.id = id;
	}

	// Property accessors

	public StockFutureId getId()
	{
		return this.id;
	}

	public void setId(StockFutureId id)
	{
		this.id = id;
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