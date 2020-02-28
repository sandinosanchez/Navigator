package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	private T t;

	private List<Node<T>> neighbors = new ArrayList<Node<T>>();

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public List<Node<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public Node(T t) {
		this.t = t;
	}

	public void addNeighbor(Node<T> neighbor) {
		neighbors.add(neighbor);
	}

	@Override
	public String toString() {
		return "Node [t=" + t + ", neighbors=" + neighbors + "]";
	}

}