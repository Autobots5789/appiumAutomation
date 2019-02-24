package Sample;

//import Sample.InstanceAndClassVariables;

public class AccessInstanceAndClassVariables {

	public static void main(String[] args) {
		InstanceAndClassVariables obj1 = new InstanceAndClassVariables();
		
			obj1.setStaticMemberVariable(123); //setting the value to the variable for class/static variable using setter method
			obj1.staticMemberVariable = 789;  //inititalizing the value for the class/static variable directly
			
			obj1.instanceVariable = 456; //initializing the value for instance variable
		
		InstanceAndClassVariables obj2 = new InstanceAndClassVariables();
		
			obj2.setStaticMemberVariable(1234); 
			obj2.staticMemberVariable = 7890;
			
			obj2.instanceVariable = 4567; 
		
		System.out.println(obj1.getStaticMemberVariable());
		System.out.println(obj2.getStaticMemberVariable());
		
		System.out.println(obj1.staticMemberVariable);
		System.out.println(obj2.staticMemberVariable);
		
		System.out.println(obj1.instanceVariable);
		System.out.println(obj2.instanceVariable);

	}

}
