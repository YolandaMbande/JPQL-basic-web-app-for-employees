package za.ac.tut.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Subjects;
import za.ac.tut.entity.Temperature;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-12T14:16:04")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, byte[]> image;
    public static volatile ListAttribute<Employee, Subjects> subjects;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile ListAttribute<Employee, Temperature> temperature;
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, String> outcome;
    public static volatile SingularAttribute<Employee, Integer> age;

}