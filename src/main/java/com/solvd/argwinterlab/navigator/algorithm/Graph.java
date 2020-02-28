package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, Node> nodes = new HashMap<String, Node>();

	public Graph() {}

	public void addEdge(String nodeName1, String nodeName2) {
		Node node1 = nodes.get(nodeName1);
		if (node1 == null) {
			node1 = new Node(nodeName1);
		}

		Node node2 = nodes.get(nodeName2);
		if (node2 == null) {
			node2 = new Node(nodeName2);
		}

		node1.addNeighbor(node2);
		node2.addNeighbor(node1);

		nodes.put(nodeName1, node1);
		nodes.put(nodeName2, node2);
	}

	public List<String> shortestPath(String startNodeName, String endNodeName) {
		Map<String, String> parents = new HashMap<String, String>();
		List<Node> temp = new ArrayList<Node>();

		Node start = nodes.get(startNodeName);
		temp.add(start);
		parents.put(startNodeName, null);

		while (temp.size() > 0) {
			Node currentNode = temp.get(0);
			List<Node> neighbors = currentNode.getNeighbors();

			for (int i = 0; i < neighbors.size(); i++) {
				Node neighbor = neighbors.get(i);
				String nodeName = neighbor.getName();

				boolean visited = parents.containsKey(nodeName);
				if (visited) {
					continue;
				} else {
					temp.add(neighbor);

					parents.put(nodeName, currentNode.getName());

					if (nodeName.equals(endNodeName)) {
						System.out.println(parents);
						return getPath(parents, endNodeName);
					}
				}
			}

			temp.remove(0);
		}

		return null;
	}

	private List<String> getPath(Map<String, String> parents, String endNodeName) {
		List<String> path = new ArrayList<String>();
		String node = endNodeName;
		while (node != null) {
			path.add(0, node);
			String parent = parents.get(node);
			node = parent;
		}
		return path;
	}
}