/* Copyright 2002, 2003, 2005 Elliotte Rusty Harold
   
   This library is free software; you can redistribute it and/or modify
   it under the terms of version 2.1 of the GNU Lesser General Public 
   License as published by the Free Software Foundation.
   
   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   GNU Lesser General Public License for more details.
   
   You should have received a copy of the GNU Lesser General Public
   License along with this library; if not, write to the 
   Free Software Foundation, Inc., 59 Temple Place, Suite 330, 
   Boston, MA 02111-1307  USA
   
   You can contact Elliotte Rusty Harold by sending e-mail to
   elharo@metalab.unc.edu. Please include the word "XOM" in the
   subject line. The XOM home page is located at http://www.xom.nu/
*/

package nu.xom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * <p>
 * Implements a list of nodes for traversal purposes.
 * Changes to the document from which this list was generated
 * are not reflected in this list, nor are changes to the list
 * reflected in the document. Changes to the individual
 * <code>Node</code> objects in the list and the document
 * are reflected in the other one.
 * </p>
 * 
 * <p>
 * There is no requirement that the list not contain duplicates,
 * or that all the members come from the same document. It is simply
 * a list of nodes. 
 * </p>
 * 
 * @author Elliotte Rusty Harold
 * @version 1.1b4
 *
 */
public final class Nodes implements Iterable<Node>{
    
    private final List<Node> nodes;
    
    
    /**
     * <p>
     * Creates an empty node list. 
     * </p>
     */
    public Nodes() {
        nodes = new ArrayList<Node>();
    }
    
    /**
     * <p>
     * Provides the Iterator.
     * </p>
     */
	@Override
	public Iterator<Node> iterator() {
		Iterator<Node> inode = nodes.iterator();
		return inode;
	}

    
    /**
     * <p>
     * Creates a node list containing a single node.
     * </p>
     * 
     * @param node the node to insert in the list
     * 
     * @throws NullPointerException if <code>node</code> is null
     */
    public Nodes(Node node) {
        
        if (node == null) {
            throw new NullPointerException("Nodes content must be non-null");
        }
        nodes = new ArrayList<Node>(1);
        nodes.add(node);
        
    }
    
    
    Nodes(List<Node> results) {
        this.nodes = results;
    }


    /**
     * <p>
     * Returns the number of nodes in the list.
     * This is guaranteed to be non-negative. 
     * </p>
     * 
     * @return the number of nodes in the list
     */
    public int size() {
        return nodes.size(); 
    }
    
    
    /**
     * <p>
     * Returns the index<sup>th</sup> node in the list.
     * The first node has index 0. The last node
     * has index <code>size()-1</code>.
     * </p>
     * 
     * @param index the node to return
     * 
     * @return the node at the specified position
     * 
     * @throws IndexOutOfBoundsException if <code>index</code> is  
     *     negative or greater than or equal to the size of the list
     */
    public Node get(int index) {
        return (Node) nodes.get(index);   
    }

    
    /**
     * <p>
     * Removes the index<sup>th</sup>node in the list.
     * Subsequent nodes have their indexes reduced by one.
     * </p>
     * 
     * @param index the node to remove
     * 
     * @return the node at the specified position
     * 
     * @throws <code>IndexOutOfBoundsException</code> if index is  
     *     negative or greater than or equal to the size of the list
     */
    public Node remove(int index) {
        return (Node) nodes.remove(index);   
    }
    
    
    /**
     * <p>
     * Inserts a node at the index<sup>th</sup> position in the list.
     * Subsequent nodes have their indexes increased by one.
     * </p>
     * 
     * @param node the node to insert
     * @param index the position at which to insert the node
     * 
     * @throws IndexOutOfBoundsException if <code>index</code> is  
     *     negative or strictly greater than the size of the list
     * @throws NullPointerException if <code>node</code> is null
     */
    public void insert(Node node, int index) {
        if (node == null) {
            throw new NullPointerException("Nodes content must be non-null");
        }
        nodes.add(index, node);   
    }
    
    
    /**
     * <p>
     * Adds a node at the end of this list.
     * </p>
     * 
     * @param node the node to add to the list
     * 
     * @throws NullPointerException if <code>node</code> is null
     */
    public void append(Node node) {
    	if (node == null) {
    		throw new NullPointerException("Nodes content must be non-null");
    	}
    	nodes.add(node);
    }
    
    
    /**
     * <p>
     * Adds nodes at the end of this list.
     * </p>
     * 
     * @param nodes the node to add to the list
     * 
     * @throws NullPointerException if <code>node</code> is null
     */
    public void appendNodes(Nodes nodes) {
        if (nodes == null) {
            throw new NullPointerException("Nodes content must be non-null");
        }
        nodes.add(nodes);
    }
    private void add(Nodes nodes) {
    	for (int i=0; i<nodes.size(); i++) {
    		this.nodes.add(nodes.get(i));
    	}
	}


    /**
     * <p>
     * Determines whether a node is contained in this list.
     * </p>
     * 
     * @param node the node to search for
     * 
     * @return true if this list contains the specified node;
     *     false otherwise
     */
    public boolean contains(Node node) {
        return nodes.contains(node);
    }
    
    
}