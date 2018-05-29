
package tacos;

import java.util.ArrayList;

public class OurArrayList<T> extends ArrayList
{
    public Node lowestFrequency()
    {
        Node currentLowestNode = new Node('x', 999999999);
        for(Object node : this)    
        {
            Node thisNode = (Node)node;
            if(thisNode.getInteger() < currentLowestNode.getInteger())
            {
                currentLowestNode = thisNode;
            }
        }
        return currentLowestNode.getInteger() == 999999999
            ? null : currentLowestNode;
        
    }
}
