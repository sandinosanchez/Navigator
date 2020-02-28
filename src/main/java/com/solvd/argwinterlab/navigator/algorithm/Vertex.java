package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private T data;
	private List<Vertex<T>> neighbors;

	public Vertex() {}

	public Vertex(T t) {
		this.data = t;
		this.neighbors = new ArrayList<>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Vertex<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public void addNeighbor(Vertex<T> neighbor) {
		neighbors.add(neighbor);
	}

	@Override
	public String toString() {
		return "Node [t=" + data + ", neighbors=" + neighbors + "]";
	}

}