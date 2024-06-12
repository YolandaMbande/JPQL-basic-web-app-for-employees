package za.ac.tut.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Employee;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-12T14:16:04")
@StaticMetamodel(Temperature.class)
public class Temperature_ { 

    public static volatile SingularAttribute<Temperature, Double> temperatures;
    public static volatile SingularAttribute<Temperature, Long> id;
    public static volatile SingularAttribute<Temperature, Employee> employee;

}