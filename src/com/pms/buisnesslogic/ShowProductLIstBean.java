/**
 * 
 */
package com.pms.buisnesslogic;

import java.io.Serializable;

/**
 * @author Paramita
 *
 */
public class ShowProductLIstBean implements Serializable {

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the vname
	 */
	public String getVname() {
		return vname;
	}
	/**
	 * @param vname the vname to set
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	private int  productId;
	private String productName;
	private int  quantity;
	private float price;
	private String vname;
	public ShowProductLIstBean() {
		// TODO Auto-generated constructor stub
		super();
	}

}
