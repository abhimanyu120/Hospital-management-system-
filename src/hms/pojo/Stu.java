/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// HashMap and Composition Object
  class Junior_Student
  {

    @Override
    public String toString() {
        return "Junior_Student{" + "student_id=" + student_id + ", student_name=" + student_name + '}';
    }
	  int student_id;
	  String student_name;
	  
	  public Junior_Student()
	{
		student_id=0;
		student_name="";
	}
	public Junior_Student(int student_id,String student_name)
	{
		this.student_id=student_id;
		this.student_name=student_name;
	}
	
	public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public int getStudentID() {
        return student_id;
    }

    public void setStudentID(int id) {
        this.student_id = id;
    }

  }

 class Student
{

    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", student_name=" + student_name + ", js=" + js + '}';
    }
	int student_id;
	String student_name;
	Junior_Student js;
	public Student()
	{
		student_id=0;
		student_name="";
		js=null;
	}
	public Student(int student_id,String student_name,Junior_Student js)
	{
		this.student_id=student_id;
		this.student_name=student_name;
		this.js=js;
	}
	
	public String getName() {
        return student_name;
    }

	public Junior_Student getObject() {
        return js;
    }

	public void setObject(Junior_Student js) {
        this.js=js;
    }


    public void setName(String name) {
        this.student_name = name;
    }

    public int getStudentID() {
        return student_id;
    }

    public void setStudentID(int id) {
        this.student_id = id;
    }

}


 class Test8
{
  
	public static void main(String args[])
	{
		
      Map <Integer,Student> stu = new HashMap<>();
	 
	 
	 
	 // How to add data into HashMap
	  stu.put(1,new Student(101,"sumit",new Junior_Student(104,"ankit")));
	  stu.put(2,new Student(102,"amit",new Junior_Student(105,"ajay")));
	  stu.put(3,new Student(103,"sachin sir",new Junior_Student(106,"varsha")));
	  
	  Set<Integer> keys = stu.keySet();
	  
	  for(Integer key:keys)
	 {
		 System.out.println(key + "  "+ stu.get(key));
	 }
	 
	 	 
	/*  for(Student s: stu)
	  {
		  System.out.printf("%d  ",s.getStudentID());
		  System.out.printf("%s\n",s.getName());
		  Junior_Student jn = s.getObject();
		  System.out.printf("%d  ",jn.getStudentID());
		  System.out.printf("%s\n",jn.getName());
		   
	  }*/
	 
	  
}
}