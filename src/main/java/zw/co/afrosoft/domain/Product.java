package zw.co.afrosoft.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product extends BaseEntity{

	@Column(nullable = false,length = 25)
	private String name;
	
	@Column(nullable = false,length = 255)
	private String description;
	
	@Column(name = "purchase_price", nullable = false,length = 10)
	private double purchasePrice;
	
	@Column(name = "selling_price", nullable = false,length = 10)
	private double sellingPrice;
	
	@Column(name = "quantity_on_hand", nullable = false,length = 8)
	private int quantityOnHand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
