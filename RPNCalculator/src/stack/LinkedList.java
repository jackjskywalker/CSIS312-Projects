/**
* CSIS 312 Assignment X.
* @author Wade Schofield and Abby Schofield
* LinkedList class example made into a Generic
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
* !! Note you don't have to change this code at all !!
**/
package stack;

//
public class LinkedList<T>
{    
    // Points to the first item in the list
    Item start = null; // what is private?

    // Holds a single list element
    public class Item<T>    // what is protected?
    {
        Item next = null;
        Item prev = null;
        T data;

        public Item(T data)
        {
            this.data = data;
        }       
        
        @Override
        public String toString()
        {
            return data.toString();
        }
    }

    /**
     * Size method
     * @return size of the linked list
     */
    public int size()
    {
        int count = 0;
        if (isEmpty())
            return count;
        else
        {         
            Item item = start;
            do
            {
                count++;
                item = item.next;
            }
            while (item != null); 
        }
        return count;
    }

    /**
     *
     * @return
     */
    private Item findEnd()
    {
        if (!isEmpty())
        {
            Item item = start;
            while (item.next != null) {
                item = item.next;
            }
            return item;
        }
        else
        {
            return null;
        }
    }

    /**
     *
     */
    public void add(T o)
    {
        Item item = new Item(o);
        
        // handle empty list
        if (isEmpty())
        {
            start = item;
            start.prev = null;  // nothing before
        }
        else
        {           
            Item end = findEnd();
            item.prev = end;
            end.next = item;  
        }
    }

    public boolean isEmpty()
   {
        return (start == null); // empty list
   }

    public T get(int i)
    {
        int ndx = 0;
        if (!isEmpty())
        {       
            Item item = start;
            do 
            {
                if (ndx == i)
                {
                    return (T)item.data;
                }
                item = item.next;
                ndx+=1;
            }
            while (item != null);
        }
        return null;   // not found;
    }

    public boolean remove(int i)
    {
        int ndx = 0;
        if (!isEmpty())
        {       
            Item item = start;
            do 
            {
                if (ndx == i)
                {
                    if (item.prev != null)                    
                        (item.prev).next = item.next;                    
                    else
                        start = item.next;
                    return true;
                }
                item = item.next;
                ndx+=1;
            }
            while (item != null);
        }
        return false;   // not found;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty())
        {
            Item item = start;
            do
            {
                sb.append(item);
                item = item.next;
            } while (item != null);   
            return sb.toString();
        }
        else
        {
            return "<Empty>";
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<>();
        String[] data = {"See","Jane","Run","Fast","Home","Bear","Chasing"};
        for (String s : data)
        {
            System.out.println(s);
            ll.add(s);
        }
        
                System.out.println(ll);

        ll.remove(3);
        System.out.println(ll);
        

        // TODO code application logic here

    }


}
