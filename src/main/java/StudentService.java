import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }

    public Student findStudentById(String id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = repo.findStudentById(id);
        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + id + " does not exist in Repo");
        }
        return optionalStudent.get();
    }

}
