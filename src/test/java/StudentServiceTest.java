import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void findStudentById_shouldReturnStudent_whenCalledWithKnownId() {
        StudentService studentService = new StudentService();
        Student anna = studentService.addNewStudent(Student.builder().name("Anna").subject("english").build());
        Student bruno = studentService.addNewStudent(Student.builder().name("Bruno").subject("french").build());
        Student carla = studentService.addNewStudent(Student.builder().name("Carla").subject("physics").build());

        try {
            Student actual = studentService.findStudentById(bruno.id());
            Assertions.assertEquals(bruno, actual);
        } catch (StudentNotFoundException e) {
            fail();
        }
    }

    @Test
    void findStudentById_shouldThrowException_whenCalledWithUnknownId() {
        StudentService studentService = new StudentService();
        Student anna = studentService.addNewStudent(Student.builder().name("Anna").subject("english").build());
        Student bruno = studentService.addNewStudent(Student.builder().name("Bruno").subject("french").build());
        Student carla = studentService.addNewStudent(Student.builder().name("Carla").subject("physics").build());


        try {
            Student actual = studentService.findStudentById("abc");
            fail();
        } catch (StudentNotFoundException e) {
            Assertions.assertTrue(true);
        }
    }

}