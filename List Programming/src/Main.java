
public class Main {
	public static void main(String[] args) {
		/// [1,2,3,4,5]
		List list1 = 
				new Pair(1, 
						new Pair(2, 
								new Pair(3, 
										new Pair(4, 
												new Pair(5, 
														new NullList())))));
		//[]
		List list2 = new NullList();
		
		//["Playing", "With", "Java"]
		List list3 = 
				new Pair(10, 
						new Pair(11, 
								new NullList()));
		list1.print();
		list3.print();
		System.out.print(list1.length()+ ", ");
		System.out.println(list2.length());
		
		System.out.print(list1.sum() + ", ");
		System.out.println(list2.sum());
		
		list1.concat(list3).print();
		list1.reverse().print();
		list1.take(4).print();
		list1.take(3).print();
		list1.take(2).print();
		list1.recTake(3).print();
		list1.recDrop(1).print();
		list1.recDrop(2).print();
		list1.drop(2).print();
		
//		list1.take(1).print();
//		list1.take(6).print();
//		
//		list1.drop(1).print();
//		list1.drop(2).print();
//		list1.drop(3).print();
//		list1.drop(4).print();
//		list1.drop(6).print();
	}
	
}
