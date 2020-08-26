
package myHuffmanTree;
import java.util.HashMap;
import java.util.Set;

public class HuffmanTree 
{
    Node root;
    HashMap<Character, String> binaryCodes = new HashMap();
    
    public void generateHuffmanTree(OurArrayList list)
    {
        while(list.size() > 1)
        {
            Node child = list.lowestFrequency();
            list.remove(child);
            Node child2 = list.lowestFrequency();
            list.remove(child2);
            Node parent = new Node('x', child.getInteger() + child2.getInteger());
            list.add(parent);
            Node lc = child.getInteger() < child2.getInteger()
                    ? child : child2;            
            Node rc = child.getInteger() >= child2.getInteger()
                    ? child : child2;
            parent.setLC(lc);
            parent.setRC(rc);
        }
        root = (Node)list.get(0);
    }
    
    public void generateCodes() 
    {
        if(root == null)
            return;
        else
        {
            if(root.getLC() != null)
            {
                recursivelyGenerateCodes(root.getLC(), "0");
            }
            if(root.getRC() != null)
            {
                recursivelyGenerateCodes(root.getRC(), "1");
            }
        }
        
    }
    
    public void recursivelyGenerateCodes(
            Node node, 
            String currentPath) 
    {
        if(node.isLeaf())
        {
            binaryCodes.put(node.getLetter(), currentPath);
        }
        if(node.getLC() != null)
        {
           recursivelyGenerateCodes(node.getLC(), currentPath.concat("0"));
        }
        if(node.getRC() != null)
        {
            recursivelyGenerateCodes(node.getRC(), currentPath.concat("1"));
        }      
        
    }
    
    public void printCodes()
    {
        System.out.println();
        System.out.println("Code Table");
        System.out.println();
        Set<Character> keySet  = binaryCodes.keySet();
        for(Character key : keySet)
        {
            System.out.println(key + " - " + binaryCodes.get(key));
        }
    }
    
    public String adjustBinary(String line)
    {
        char[] array = line.toCharArray();
        String string = "";
        
        for(Character letter : array)
        {
            String code = binaryCodes.get(letter);
            string = string.concat(code);
        }
        return string;
    }
    
    public String decode(String string) throws Exception
    {
        char[] array = string.toCharArray();
        String decodedString = "";
        Node pointer = root;
        
        for(Character bit : array)
        {
            if(bit == '0')
            {
                pointer = pointer.getLC();
            }
            else if(bit == '1')
            {
                pointer = pointer.getRC();
            }
            else
                throw new Exception();            
            if(pointer.isLeaf())
            {                
                String code = Character.toString(pointer.getLetter());
                decodedString = decodedString.concat(code);
                pointer = root;
            }
        }
        return decodedString;        
    }
}
