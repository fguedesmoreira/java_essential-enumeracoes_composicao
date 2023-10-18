package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdfDateHour = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Client client;
	private Date moment = new Date(System.currentTimeMillis());
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Client client, OrderStatus status) {
		this.client = client;
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		Double total = 0.0;
		for (OrderItem item : items) {
			total += item.subTotal();
		}
		return total;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: " + sdfDateHour.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items:\n");

		Double totalPrice = 0.0;

		for (OrderItem item : items) {
			sb.append(item + "\n");
			totalPrice += item.subTotal();
		}

		sb.append("Total price: $" + String.format("%.2f",total()));

		return sb.toString();

	}

}