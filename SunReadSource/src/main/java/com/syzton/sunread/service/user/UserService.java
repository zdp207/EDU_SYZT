package com.syzton.sunread.service.user;

import com.syzton.sunread.model.user.Parent;
import com.syzton.sunread.model.user.Student;
import com.syzton.sunread.model.user.Teacher;
import com.syzton.sunread.model.user.User;

/**
 * Created by jerry on 3/9/15.
 */
public interface UserService {

    public User findById(Long id);

    public User addUser(User user);
    
    public User findByUserId(String userId);

    void deleteById(Long id);

    public Student addStudent(Student student);

    public Student findByStudentId(Long id);

    void deleteByStudentId(Long id);

    public Parent addParent(Parent parent,Long studentId);

    public Parent addChildren(Long id, String userId);

    public Parent findByParentId(Long id);
    
    public User getSingleUser(String userName);

    public Teacher addTeacher(Teacher teacher);

    public Teacher findByTeacherId(Long id);

    void deleteByTeacherId(Long id);
    
    public User authenticate(String username, String password);

    public Student  addTask(long teacherId,long studentId,int targetBookNum,int targetPoint);
    
    public Student saveStudent(Student student);
}
