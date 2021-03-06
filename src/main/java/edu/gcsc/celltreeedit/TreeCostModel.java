package edu.gcsc.celltreeedit;

import node.Node;

import java.io.Serializable;

/**
 *
 */
public class TreeCostModel implements costmodel.CostModel<NodeData>, Serializable {

    /**
     *
     * @param n
     * @return
     */
    @Override
    public float del(Node<NodeData> n) {
        return Math.abs((float) n.getNodeData().getLabel());
    }

    /**
     *
     * @param n
     * @return
     */
    @Override
    public float ins(Node<NodeData> n) {
        return Math.abs((float) n.getNodeData().getLabel());
    }

    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    @Override
    public float ren(Node<NodeData> n1, Node<NodeData> n2) {
        if(n1.getNodeData().getLabel()==n2.getNodeData().getLabel())
          return 0;
        else return Math.abs((float) n1.getNodeData().getLabel()- (float) n2.getNodeData().getLabel());
    }
}
