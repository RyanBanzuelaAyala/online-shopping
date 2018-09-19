package net.dev.backendshopping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "grand_total")
	private double grandTotal;

	@Column(name = "cart_lines")
	private int cartLines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	// linking the cart with a user
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines + ", user=" + user + "]";
	}



	@OneToOne
	//@JoinColumn(name = "uid") //optional only
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
