package base.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Vince on 2017/1/5.
 * E_mail :  xhys01@163.com
 * Description :
 */

@Entity(indexes = {
        @Index(value = "name, age DESC")
})
public class Person {
    @Id
    private Long personId;

    @NotNull
    private String name;
    private int age;
    private String gender;
    private java.util.Date birthdate;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", recorded=" + recorded +
                '}';
    }

    private java.util.Date recorded;
@Generated(hash = 1186002858)
public Person(Long personId, @NotNull String name, int age, String gender,
        java.util.Date birthdate, java.util.Date recorded) {
    this.personId = personId;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.birthdate = birthdate;
    this.recorded = recorded;
}
@Generated(hash = 1024547259)
public Person() {
}
public Long getPersonId() {
    return this.personId;
}
public void setPersonId(Long personId) {
    this.personId = personId;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}
public int getAge() {
    return this.age;
}
public void setAge(int age) {
    this.age = age;
}
public String getGender() {
    return this.gender;
}
public void setGender(String gender) {
    this.gender = gender;
}
public java.util.Date getBirthdate() {
    return this.birthdate;
}
public void setBirthdate(java.util.Date birthdate) {
    this.birthdate = birthdate;
}
public java.util.Date getRecorded() {
    return this.recorded;
}
public void setRecorded(java.util.Date recorded) {
    this.recorded = recorded;
}

}
