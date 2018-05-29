
package tacos;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Anna Watson
 * CSCI232 - Program 2
 * This program reads in from an input file, creates a frequency table,
 * constructs a Huffman Tree from the data, encodes the message, 
 * decodes the message, and then outputs the message to the output file
 * 
 */
public class Tacos 
{

    public static void main(String[] args) throws Exception
    {
            String line = "";
            HashMap <Character,Integer> charactorFrequencyMap = new HashMap();
            try
            {
                Scanner fileInput = new Scanner(new File("input.txt"));
                while(fileInput.hasNextLine())
                {
                    line = fileInput.nextLine();
                    for(char charactor : line.toCharArray())
                    {
                        if(charactorFrequencyMap.containsKey(charactor))
                        {
                            int get = charactorFrequencyMap.get(charactor);
                            get++;
                            charactorFrequencyMap.replace(charactor, get);
                        }
                        else 
                            charactorFrequencyMap.put(charactor, 1);
                    }
                }
                
            }
             
            
            catch (Exception e) 
            {
                System.out.println("File not found.");
            }
            
            //creating nodes from hashmap
            OurArrayList<Node> nodes = new OurArrayList();
            for(char charactor : charactorFrequencyMap.keySet())
            {
                Node node = 
                    new Node(charactor, charactorFrequencyMap.get(charactor));
                nodes.add(node);
            }
            System.out.println("Frequency Table");
            System.out.println();
            for(Object node : nodes)
            {
                System.out.println(((Node)node).getLetter() + " - " + ((Node)node).getInteger());
            }            
            Node result = nodes.lowestFrequency();
            
            HuffmanTree tree = new HuffmanTree();
            tree.generateHuffmanTree(nodes);
            tree.generateCodes();
            tree.printCodes();
            String here = tree.adjustBinary(line);
            System.out.println();
            System.out.println("Encoded Binary");
            System.out.println();
            System.out.println(here);
            System.out.println();
            String there = tree.decode(here);
            System.out.println();
            System.out.println("Decoded Bianry");
            System.out.println();
            System.out.println(there);
            PrintWriter wr;
            wr = new PrintWriter(new File("output1.txt"));
            wr.write(there);
            wr.close (); 
    }
}