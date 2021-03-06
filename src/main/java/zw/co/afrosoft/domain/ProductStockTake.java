package zw.co.afrosoft.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product_stocktake")
public class ProductStockTake extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "stock_take_id")
	private StockTake stockTake;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int qtyCounted;

	public StockTake getStockTake() {
		return stockTake;
	}

	public void setStockTake(StockTake stockTake) {
		this.stockTake = stockTake;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQtyCounted() {
		return qtyCounted;
	}

	public void setQtyCounted(int qtyCounted) {
		this.qtyCounted = qtyCounted;
	}

	public Long getId() {
		return id;
	}
}
