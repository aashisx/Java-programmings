
public class employee {
    int id;
    String name;
    String designation;
    int salary;
    int annualsalary;
    employee(int id, String name, String designation, int salary){
        this.id=id;
        this.name=name;
        this.designation=designation;
        this.salary=salary;
        this.annualsalary=salary*12;
    }
    void displayinfo(){
        System.out.println("The id of employee is: " + this.id);
        System.out.println("The name of employee is: " + this.name);
        System.out.println("The designation of employee is: " + this.designation);
        System.out.println("The salary of employee is: " + this.salary);
        System.out.println("Ännual salary is: " + annualsalary);
        System.out.println();

    }
}
