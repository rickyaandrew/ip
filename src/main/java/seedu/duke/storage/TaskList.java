package seedu.duke.storage;

import java.util.ArrayList;

import seedu.duke.commands.Ui;
import seedu.duke.exceptions.action.DukeActionOutOfBoundException;
import seedu.duke.tasks.Task;

public class TaskList {
    private final ArrayList<Task> taskList;

    /**
     * Primary Constructor.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Retrieves an {@code ArrayList<Task>} that is being stored in this
     * {@code TaskList}.
     * 
     * @return an {@code ArrayList<Task>} which is being stored on this
     *         {@code TaskList}.
     * @see java.util.ArrayList
     */
    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Loads previous saved Tasks from a txt file. Save it in this current
     * {@code TaskList} in an {@code ArrayList<Task>}.
     * 
     * @param savedTasks this is the {@code ArrayList<Task>} coming from the txt
     *                   file.
     * @see java.util.ArrayList
     */
    public void loadFromStorage(ArrayList<Task> savedTasks) {
        this.taskList.addAll(savedTasks);
    }

    /**
     * Marks the {@code Task} in the {@code ArrayList<Task>} as done.
     * 
     * @param number is the {@code Task} id.
     */
    public Task doneItem(int index) {
        try {
            Task doneTask = this.taskList.get(index).markAsDone();
            this.taskList.set(index, doneTask);
            return doneTask;

        } catch (IndexOutOfBoundsException err) {
            throw new DukeActionOutOfBoundException(Ui.ERROR_MESSAGE_ACTION_OUT_OF_BOUND);
        }
    }

    /**
     * Adds a particular {@code Task} given by the user into the {@code TaskList}.
     * 
     * @param task is the {@code Task} that is to be added into the
     *             {@code TaskList}.
     */
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    /**
     * Deletes a particular task that is present in the {@code TaskList}.
     * 
     * @param number is the {@code Task} id.
     */
    public Task deleteItem(int index) {
        try {
            return this.taskList.remove(index);
        } catch (IndexOutOfBoundsException err) {
            throw new DukeActionOutOfBoundException(Ui.ERROR_MESSAGE_ACTION_OUT_OF_BOUND);
        }
    }

    /**
     * Finds the specific {@code Task} from the {@code ArrayList<Task>} in
     * {@code TaskList} based on the description given.
     * 
     * @param find is the description coming from the user, which the list of
     *             {@code Task} they would like to find.
     */
    public ArrayList<Task> find(String find) {
        ArrayList<Task> foundList = new ArrayList<>();

        this.taskList.forEach(task -> {
            if (task.getDescription().contains(find)) {
                foundList.add(task);
            }
        });

        return foundList;

    }
}
