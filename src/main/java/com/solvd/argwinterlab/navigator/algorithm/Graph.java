package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

	private List<Long> nodesId = new LinkedList<Long>();

	public List<Long> shortestPath(Long startNodeId, Long endNodeId) {
	    // key node, value parent
	    Map<Long, Long> parents = new HashMap<Long, Long>();
	    List<Long> temp = new ArrayList<Long>();

	    temp.add(startNodeId);
	    parents.put(startNodeId, null);

	    while (temp.size() > 0) {
	      Long currentNodeId = temp.get(0);
	      List<Long> neighbors = currentNodeId.getNeighborsByNodeId(currentNodeId);

	      for (int i = 0; i < neighbors.size(); i++) {
	        Long neighborId = neighbors.get(i);

	        // a node can only be visited once if it has more than one parents
	        boolean visited = parents.containsKey(neighborId);
	        if (visited) {
	          continue;
	        } else {
	          temp.add(neighborId);

	          // parents map can be used to get the path
	          parents.put(neighborId, currentNodeId);

	          // return the shortest path if end node is reached
	          if (neighborId.equals(endNodeId)) {
	            System.out.println(parents);
	            return getPath(parents, endNodeId);
	          }
	        }
	      }

	      temp.remove(0);
	    }

	    return null;
	  }

	private List<Long> getPath(Map<Long, Long> parents, Long endNodeId) {
	    List<Long> path = new ArrayList<Long>();
	    Long node = endNodeId;
	    while (node != null) {
	      path.add(0, node);
	      Long parent = parents.get(node);
	      node = parent;
	    }
	    return path;
	  }
}
