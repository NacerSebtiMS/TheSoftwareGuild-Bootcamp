/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feng.complexrest.data;

/**
 *
 * @author rickytechnip
 */
import feng.complexrest.models.ToDo;
import java.util.List;

public interface ToDoDao {

    ToDo add(ToDo todo);

    List<ToDo> getAll();

    ToDo findById(int id);

    // true if item exists and is updated
    boolean update(ToDo todo);

    // true if item exists and is deleted
    boolean deleteById(int id);
}
