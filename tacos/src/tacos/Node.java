
package tacos;

public class Node {
    char letter;
    int integer;
    Node lc;
    Node rc;
    
    public Node(char letter, int integer)
    {
        this.letter = letter;
        this.integer = integer;
    }
    
    public char getLetter()
    {
        return letter;
    }
    
    public int getInteger()
    {
        return integer; 
    }
    
    public Node getLC()
    {
        return lc;
    }
    
    public void setLC(Node node)
    {
        this.lc = node;
    }
    
    public Node getRC()
    {
        return rc;
    }
    
    public void setRC(Node node)
    {
        this.rc = node;
    }        
    
    public boolean isLeaf()
    {
        if(getLC() == null && getRC() == null)
        {
            return true;
        }
        else
            return false;
    }
      
    
}
