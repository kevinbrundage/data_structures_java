package datastructures;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
		Array array = new Array();
		System.out.println("----- Array traverse -----");
		array.traverse();

		System.out.println(" ");
		System.out.println("----- Array search -----");
		array.search();

		System.out.println(" ");
		System.out.println("----- Array update -----");
		array.update();

		System.out.println(" ");
		System.out.println("----- Array delete -----");
		array.delete();
    }
}
